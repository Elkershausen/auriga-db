using System.Collections.Generic;
using System.IO;
using System.Text;

namespace ItemInfoMaker
{
    class Writer
    {
        public string filename;
        public string footer;

        public Writer(string readfile,string footerfile)
        {
            filename = readfile;
            footer = footerfile;
        }
        public void Write(List<Item> itemlist, bool costume, bool escape)
        {
            StreamWriter sw = new StreamWriter(filename, false, Encoding.GetEncoding("Shift_JIS"));

            sw.WriteLine("tbl = {");
            foreach (Item item in itemlist)
            {
                sw.WriteLine("\t[" + AddEscape(item.id.ToString(), escape) + "] = {");
                string itemname = AddEscape(item.unidentifiedDisplayName, escape);
                //itemname = item.slotCount == 0 ? itemname : itemname + "[" + item.slotCount.ToString() + "]";
                sw.WriteLine("\t\tunidentifiedDisplayName = \"" + itemname + "\",");
                sw.WriteLine("\t\tunidentifiedResourceName = \"" + item.unidentifiedResourceName + "\",");
                sw.WriteLine("\t\tunidentifiedDescriptionName = {");
                foreach (string description in item.unidentifiedDescriptionName)
                {
                    sw.WriteLine("\t\t\t\"" + AddEscape(description, escape) + "\",");
                }
                sw.WriteLine("\t\t},");

                itemname = AddEscape(item.identifiedDisplayName, escape);
                //itemname = item.slotCount == 0 ? itemname : itemname + "[" + item.slotCount.ToString() + "]";
                sw.WriteLine("\t\tidentifiedDisplayName = \"" + itemname + "\",");
                sw.WriteLine("\t\tidentifiedResourceName = \"" + item.identifiedResourceName + "\",");
                sw.WriteLine("\t\tidentifiedDescriptionName = {");
                if (item.identifiedDescriptionName.Count > 0)
                {
                    foreach (string description in item.identifiedDescriptionName)
                    {
                        sw.WriteLine("\t\t\t\"" + AddEscape(description, escape) + "\",");
                    }
                }
                sw.WriteLine("\t\t},");

                sw.WriteLine("\t\tslotCount = " + item.slotCount.ToString() + ",");
                sw.WriteLine("\t\tClassNum = " + item.ClassNum.ToString() + ",");
                if( costume)
                {
                    sw.WriteLine("\t\tcostume = " + item.costume.ToString().ToLowerInvariant() + ",");
                }
                sw.WriteLine("\t\tEffectID = " + item.EffectID.ToString() + ",");
                sw.WriteLine("\t},");
                sw.WriteLine("");
            }
            sw.WriteLine("}");

            StreamReader sr = new StreamReader(footer, Encoding.GetEncoding("Shift_JIS"));
            sw.Write(sr.ReadToEnd());

            sr.Close();
            sw.Close();
        }
        private string AddEscape(string buff, bool enable)
        {
            if (buff == null)
            {
                return "";
            }
            if (enable)
            {
                char[] ch = buff.ToCharArray();
                for( int i = ch.Length - 1; i >= 0; i--)
                {
                    Encoding encoding = Encoding.GetEncoding("Shift_JIS");
                    byte[] data=encoding.GetBytes(ch,i,1);
                    if (data.Length == 2)   //2バイト文字で
                    {
                        if(data[1]== 0x5C)  //5C問題が発生する場合
                        {
                            if((i >= ch.Length - 1) || (ch[i + 1] != '\\')) //後ろに￥がついていなければ挿入する
                            {
                                buff = buff.Insert(i + 1, "\\");
                            }
                        }
                    }
                }
            }
            buff = buff.Replace("\"", "\\034").Replace("\\\\034", "\\034");
	    buff = buff.Replace("<URL>[公式サイト]<INFO>","</").Replace("null","null");	//httpsの変換エラーの抑止
	    buff = buff.Replace("https:","//").Replace("null","null");			//httpsの変換エラーの抑止
            return buff;
        }
    }
}
