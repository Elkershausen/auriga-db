using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;

namespace ItemInfoMaker
{
    class Item : IComparable<Item>
    {
        public override int GetHashCode()
        {
            return this.id.GetHashCode() ^ this.identifiedDisplayName.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            // asでは、objがnullでも例外は発生せずにnullが入ってくる
            var other = obj as Item;
            if (other == null) return false;
            if (this.identifiedDisplayName == null) return false;

            //IDを2バイトに制限しているケースを考慮してID下位2バイトとアイテム名一致で同一とみなす
            if((this.identifiedDisplayName == other.identifiedDisplayName)
                && (( this.id % 0x10000 ) == ( other.id % 0x10000)))
            {
                return true;
            }
            return false;
        }
        int IComparable<Item>.CompareTo(Item obj)
        {
            return this.id.CompareTo(obj.id);
        }
        public Item(int addid)
        {
            id = addid;
            unidentifiedDescriptionName = new List<string>();
            identifiedDescriptionName = new List<string>();
            slotCount = 0;
            ClassNum = 0;
            unidentifiedDisplayName = "";
            unidentifiedResourceName = "";
            identifiedDisplayName = "";
            identifiedResourceName = "";
            costume = false;
            EffectID = 0;
        }

        public int id { get; set; }
        public string unidentifiedDisplayName { get; set; }
        public string unidentifiedResourceName { get; set; }
        public List<string> unidentifiedDescriptionName { get; set; }
        public string identifiedDisplayName { get; set; }
        public string identifiedResourceName { get; set; }
        public List<string> identifiedDescriptionName { get; set; }
        public int slotCount { get; set; }
        public int ClassNum { get; set; }
        public bool costume { get; set; }
        public int EffectID { get; set; }

        public void FillDummyData()
        {
            if((identifiedDisplayName != "") && (unidentifiedDisplayName == ""))
            {
                unidentifiedDisplayName = identifiedDisplayName;
            }
            else if ((identifiedDisplayName == "") && (unidentifiedDisplayName != ""))
            {
                identifiedDisplayName = unidentifiedDisplayName;
            }
            else if ((identifiedDisplayName == "") && (unidentifiedDisplayName == ""))
            {
                identifiedDisplayName = "UnkownItem";
                unidentifiedDisplayName = "UnkownItem";
            }

            if ((identifiedResourceName != "") && (unidentifiedResourceName == ""))
            {
                unidentifiedResourceName = identifiedResourceName;
            }
            else if ((identifiedResourceName == "") && (unidentifiedResourceName != ""))
            {
                identifiedResourceName = unidentifiedResourceName;
            }
            else if ((identifiedResourceName == "") && (unidentifiedResourceName == ""))
            {
                identifiedResourceName = "\\187\\231\\176\\250";  //リンゴ
                unidentifiedResourceName = "\\187\\231\\176\\250";  //リンゴ
            }
        }
    }
}
