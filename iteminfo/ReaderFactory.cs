using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ItemInfoMaker
{
    enum FileType
    {
        idnum2itemdisplaynametable,
        idnum2itemdesctable,
        idnum2itemresnametable,
        num2itemdisplaynametable,
        num2itemdesctable,
        num2itemresnametable,
        itemslotcounttable,
        itemclassnumtable,
        dropeffecttable,
        iteminfo,
        itemdb,
    }
    class ReaderFactorySetting
    {
        public FileType type { get; set; }
        public string path { get; set; }
    }
    class ReaderFactory
    {
        static public Reader CreateInstance( string type, string path)
        {
            Reader fr = null;
            foreach (FileType v in Enum.GetValues(typeof(FileType)))
            {
                if( type == Enum.GetName(typeof(FileType), v))
                {
                    switch (v)
                    {
                        case FileType.idnum2itemdisplaynametable:
                            fr = new idnum2itemdisplaynametableReader(path);
                            break;
                        case FileType.idnum2itemdesctable:
                            fr = new idnum2itemdesctableReader(path);
                            break;
                        case FileType.idnum2itemresnametable:
                            fr = new idnum2itemresnametableReader(path);
                            break;
                        case FileType.num2itemdisplaynametable:
                            fr = new num2itemdisplaynametableReader(path);
                            break;
                        case FileType.num2itemdesctable:
                            fr = new num2itemdesctableReader(path);
                            break;
                        case FileType.num2itemresnametable:
                            fr = new num2itemresnametableReader(path);
                            break;
                        case FileType.itemslotcounttable:
                            fr = new itemslotcounttable(path);
                            break;
                        case FileType.itemclassnumtable:
                            fr = new itemclassnumtable(path);
                            break;
                        case FileType.dropeffecttable:
                            fr = new dropeffecttable(path);
                            break;
                        case FileType.iteminfo:
                            fr = new iteminfoReader(path, false);
                            break;
                        case FileType.itemdb:
                            fr = new itemdbReader(path);
                            break;
                    }
                    break;
                }
            }
            return fr;
        }
    }
}
