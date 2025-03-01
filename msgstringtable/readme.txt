2024年以降の環境に必須のbase64でエンコードされたmsgstringtable.csvに対応する基礎ファイルとbase64エンコードアプリです
rathenaの不具合を修正しpython27で動作するようにしています
python27が残っていたので適応させました
このままでは使えないので必ず以下の手順に従ってご自身で作成してください

msgstringtable_decoded.txt はUTF-8で保存してください(メモ帳可)
UTF-8にBOM(Byte Order Mark)という要素が混じっていたら使えないのでpowershellで変換してください(chatGPTに聞いたら教えてくれます)

<<<仕様書>>>
記述内の MSI_XXXX は固定の定義です
[MSI_XXXX,"ほにゃらら"] が旧式の [ほにゃらら#]に相当します

<<<python27で変換する手順開始>>>
Python27フォルダに[msgstringtable_decoded.txt] と [convert.py] を置きます
コマンドプロンプト起動
cd c:\Python27
python convert.py
ずらずらっとコードがプロンプト画面に流れ、msgstringtable.csv が生成されます
<<<python27で変換する手順終了>>>

python3.X 以降でも大体同じ流れだと思います
