using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;

namespace ItemInfoMaker
{
    abstract class Reader
    {
        public string filename;

        public Reader(string readfile)
        {
            filename = readfile;
        }
        protected string TrimComment( string buff)
        {
            if (buff.Contains("//"))
            {
                int index = buff.IndexOf("//");
                if (index == 0)
                {
                    return "";
                }
                else
                {
                    return buff.Substring(0, index);
                }
            }
            return buff;
        }
        public abstract void AddInfo(Dictionary<int, Item> dic);
    }
    class itemdbReader : Reader
    {
        public itemdbReader(string readfile) : base(readfile)
        {

        }
        public override void AddInfo(Dictionary<int, Item> dic)
        {
            StreamReader sr = new StreamReader(filename, Encoding.GetEncoding("Shift_JIS"));

            while (sr.Peek() != -1)
            {
                string buff = TrimComment( sr.ReadLine() );
                string[] word = buff.Split(',');
                if (word.Length >= 18)
                {
                    int id;
                    if (Int32.TryParse(word[0].Trim(), out id))
                    {
                        if (!dic.ContainsKey(id))
                        {
                            dic.Add(id, new Item(id));
                        }
                        dic[id].identifiedDisplayName = word[2].Trim();
                        int slot;
                        if (Int32.TryParse(word[10].Trim(), out slot))
                        {
                            dic[id].slotCount = slot;
                        }
                        int class_num;
                        if (Int32.TryParse(word[(int)ItemDBPos.View].Trim(), out class_num))
                        {
                            dic[id].ClassNum = class_num;
                        }
                        int loc;
                        if ( Int32.TryParse(word[(int)ItemDBPos.Loc].Trim(), out loc))
                        {
                            if ((loc & (int)EquipLoc.LOC_COSTUME_ALL) != 0)
                            {
                                dic[id].costume = true;
                            }
                            else
                            {
                                dic[id].costume = false;
                            }
                        }
                        int Effect;
                        if (Int32.TryParse(word[10].Trim(), out Effect))
                        {
                            dic[id].EffectID = Effect;
                        }
                    }
                }
            }
            sr.Close();
        }
    }

    abstract class itemdisplaynametableReader : Reader
    {
        public itemdisplaynametableReader(string readfile) : base(readfile)
        {

        }
        protected abstract void SetItemDisplayName( Item itm, string newname );
        public override void AddInfo(Dictionary<int, Item> dic)
        {
            StreamReader sr = new StreamReader(filename, Encoding.GetEncoding("Shift_JIS"));

            while (sr.Peek() != -1)
            {
                string buff = TrimComment(sr.ReadLine());
                string[] word = buff.Split('#');
                if (word.Length >= 2)
                {
                    int id;
                    if (Int32.TryParse(word[0].Trim(), out id))
                    {
                        if (!dic.ContainsKey(id))
                        {
                            dic.Add(id, new Item(id));
                        }
                        SetItemDisplayName(dic[id], word[1].Trim());
                    }
                }
            }
            sr.Close();
        }
    }

    class idnum2itemdisplaynametableReader : itemdisplaynametableReader
    {
        public idnum2itemdisplaynametableReader(string readfile) : base(readfile)
        {

        }
        protected override void SetItemDisplayName(Item itm, string newname)
        {
            itm.identifiedDisplayName = newname;
        }
    }

    class num2itemdisplaynametableReader : itemdisplaynametableReader
    {
        public num2itemdisplaynametableReader(string readfile) : base(readfile)
        {

        }
        protected override void SetItemDisplayName(Item itm, string newname)
        {
            itm.unidentifiedDisplayName = newname;
        }
    }

    class itemclassnumtable : itemdisplaynametableReader
    {
        public itemclassnumtable(string readfile) : base(readfile)
        {

        }
        protected override void SetItemDisplayName(Item itm, string newname)
        {
            int num;
            if (int.TryParse(newname, out num))
            {
                itm.ClassNum = num;
            }
        }
    }

    class itemslotcounttable : itemdisplaynametableReader
    {
        public itemslotcounttable(string readfile) : base(readfile)
        {

        }
        protected override void SetItemDisplayName(Item itm, string newname)
        {
            int num;
            if (int.TryParse(newname, out num))
            {
                itm.slotCount = num;
            }
        }
    }

    class dropeffecttable : itemdisplaynametableReader
    {
        public dropeffecttable(string readfile) : base(readfile)
        {

        }
        protected override void SetItemDisplayName(Item itm, string newname)
        {
            int num;
            if (int.TryParse(newname, out num))
            {
                itm.EffectID = num;
            }
        }
    }

    abstract class itemresnametableReader : Reader
    {
        public itemresnametableReader(string readfile) : base(readfile)
        {

        }
        protected abstract void SetResourceName(Item itm, string newname);
        public override void AddInfo(Dictionary<int, Item> dic)
        {
            Encoding encoding = Encoding.GetEncoding("ks_c_5601-1987");
            StreamReader sr = new StreamReader(filename, encoding);

            while (sr.Peek() != -1)
            {
                string buff = TrimComment(sr.ReadLine());
                string[] word = buff.Split('#');
                if (word.Length >= 2)
                {
                    int id;
                    if (Int32.TryParse(word[0].Trim(), out id))
                    {
                        if (!dic.ContainsKey(id))
                        {
                            dic.Add(id, new Item(id));
                        }
                        word[1] = word[1].Trim();

                        string res_name = "";
                        if (word[1].Length == encoding.GetByteCount(word[1].ToCharArray()))
                        {
                            res_name = word[1];
                        }
                        else {
                            byte[] res = encoding.GetBytes(word[1].Trim());
                            foreach (byte ch in res)
                            {
                                res_name += "\\" + ch.ToString();
                            }
                        }

                        SetResourceName(dic[id],res_name);
                    }
                }
            }
            sr.Close();
        }
    }
    class idnum2itemresnametableReader : itemresnametableReader
    {
        public idnum2itemresnametableReader(string readfile) : base(readfile)
        {

        }
        protected override void SetResourceName(Item itm, string newname)
        {
            itm.identifiedResourceName = newname;
        }
    }
    class num2itemresnametableReader : itemresnametableReader
    {
        public num2itemresnametableReader(string readfile) : base(readfile)
        {

        }
        protected override void SetResourceName(Item itm, string newname)
        {
            itm.unidentifiedResourceName = newname;
        }
    }

    abstract class itemdesctableReader : Reader
    {
        public itemdesctableReader(string readfile) : base(readfile)
        {

        }
        protected abstract List<string> GetDescriptionList(Item itm);
        public override void AddInfo(Dictionary<int, Item> dic)
        {
            StreamReader sr = new StreamReader(filename, Encoding.GetEncoding("Shift_JIS"));

            while (sr.Peek() != -1)
            {
                string buff = TrimComment(sr.ReadLine());

                if( buff == "")
                {
                    continue;
                }
                if (!buff.EndsWith("#") || (buff.Length < 2))
                {
                    continue;
                }
                int id=0;
                if (Int32.TryParse(buff.Substring(0, buff.Length - 1), out id) && ( id > 0))
                {
                    if (!dic.ContainsKey(id)) {
                        dic.Add(id, new Item(id));
                    }
                    List<string> descs = GetDescriptionList(dic[id]);
                    descs.Clear();
                    while (sr.Peek() != -1)
                    {
                        buff = TrimComment(sr.ReadLine());
                        if (buff.EndsWith("#"))
                        {
                            break;
                        }
                        descs.Add(buff);
                    }
                }
            }
            sr.Close();
        }
    }
    class idnum2itemdesctableReader : itemdesctableReader
    {
        public idnum2itemdesctableReader(string readfile) : base(readfile)
        {

        }
        protected override List<string> GetDescriptionList(Item itm)
        {
            return itm.identifiedDescriptionName;
        }
    }
    class num2itemdesctableReader : itemdesctableReader
    {
        public num2itemdesctableReader(string readfile) : base(readfile)
        {

        }
        protected override List<string> GetDescriptionList(Item itm)
        {
            return itm.unidentifiedDescriptionName;
        }
    }
    
    class iteminfoReader : Reader
    {
        private bool strictcheck;
        public iteminfoReader(string readfile,bool strict) : base(readfile)
        {
            strictcheck = strict;
        }
        public override void AddInfo(Dictionary<int, Item> dic)
        {
            List<Item> tmpdoc = new List<Item>();

            //既存のiteminfoを読み込み
            StreamReader sr = new StreamReader(filename, Encoding.GetEncoding("Shift_JIS"));

            while (sr.Peek() != -1)
            {
                string buff = sr.ReadLine();
                buff = buff.Trim();
                Match match = Regex.Match(buff, "\\[\\d+\\]");
                if (!match.Success)
                {
                    continue;
                }
                Item add = new Item(int.Parse(match.Value.Substring(1, match.Value.Length - 2)));
                while (sr.Peek() != -1)
                {
                    buff = sr.ReadLine().Trim();
                    match = Regex.Match(buff, "\".*\"");
                    string str = "";
                    if (match.Success)
                    {
                        str = match.Value.Substring(1, match.Value.Length - 2);
                    }
                    if (buff.StartsWith("unidentifiedDisplayName"))
                    {
                        add.unidentifiedDisplayName = str.Replace("\\", "");
                    }
                    else if (buff.StartsWith("unidentifiedResourceName"))
                    {
                        add.unidentifiedResourceName = str;
                    }
                    else if (buff.StartsWith("identifiedDisplayName"))
                    {
                        add.identifiedDisplayName = str.Replace("\\", "");
                    }
                    else if (buff.StartsWith("identifiedResourceName"))
                    {
                        add.identifiedResourceName = str;
                    }
                    else if (buff.StartsWith("slotCount"))
                    {
                        match = Regex.Match(buff, "\\d+");
                        if (match.Success)
                        {
                            add.slotCount = int.Parse(match.Value);
                        }
                    }
                    else if (buff.StartsWith("costume"))
                    {
                        if(buff.ToLower().Contains("true"))
                        {
                            add.costume = true;
                        }
                        else
                        {
                            add.costume = false;
                        }
                    }
                    else if (buff.StartsWith("ClassNum"))
                    {
                        match = Regex.Match(buff, "\\d+");
                        if (match.Success)
                        {
                            add.ClassNum = int.Parse(match.Value);
                        }
                    }
                    else if (buff.StartsWith("unidentifiedDescriptionName") || buff.StartsWith("identifiedDescriptionName"))
                    {
                        List<string> description;
                        if (buff.StartsWith("unidentifiedDescriptionName"))
                        {
                            description = add.unidentifiedDescriptionName;
                        }
                        else
                        {
                            description = add.identifiedDescriptionName;
                        }
                        while (!buff.Contains("}") && sr.Peek() != -1)
                        {
                            buff = sr.ReadLine();
                            match = Regex.Match(buff, "\".*\"");
                            if (match.Success)
                            {
                                description.Add(match.Value.Substring(1, match.Value.Length - 2));
                            }
                        }
                    }
                    else if (buff.Contains("}"))
                    {
                        tmpdoc.Add(add);
                        break;
                    }
                }
            }
            sr.Close();
            List<Item> list = new List<Item>(dic.Values);

            foreach (Item ritem in tmpdoc)
            {
                
                Item witem;
                int index = list.IndexOf(ritem);
                if (index >= 0)
                {
                    //識別済みの名前とslotが一致したら情報を必要に応じて上書き
                    witem = list[index];
                    witem.unidentifiedDisplayName = ritem.unidentifiedDisplayName;
                    witem.unidentifiedResourceName = ritem.unidentifiedResourceName;
                    witem.unidentifiedDescriptionName = ritem.unidentifiedDescriptionName;
                    witem.identifiedResourceName = ritem.identifiedResourceName;
                    witem.identifiedDescriptionName = ritem.identifiedDescriptionName;
                    witem.ClassNum = ritem.ClassNum;
                }
                else if(dic.ContainsKey(ritem.id)){
                    dic[ritem.id] = ritem;
                }
                else
                {
                    dic.Add(ritem.id, ritem);
                }
            }
        }
    }
}
