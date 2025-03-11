* 2024年以降の環境に必須のbase64でエンコードされたmsgstringtable.csvに対応する基礎ファイルとbase64エンコードアプリです
* rathenaの不具合を修正し [python27] [python313] で動作するようにしています
* msgstringtable_decoded.txt はUTF-8で保存してください(メモ帳可)
* UTF-8にBOM(Byte Order Mark)という要素が混じっていたら使えないのでpowershellで変換してください(chatGPTに聞いたら教えてくれます)
* BASE64をUTF-8に変換したときにcsvとしての記述である ,"" くくりが表示されないので修正して反映させてください

例)
MSI_DO_YOU_AGREE,"同意しますか？" -> MSI_DO_YOU_AGREE,同意しますか？ -> MSI_DO_YOU_AGREE,"同意しますか？"
 
<<<仕様書>>>
記述内の MSI_XXXX は固定の定義です
[MSI_XXXX,"ほにゃらら"] が旧式の [ほにゃらら#]に相当します

<<<python27で変換する手順開始>>>
Python27フォルダをC直下に作成
Python27フォルダに[msgstringtable_decoded.txt] と [python27convert.py] を置きます
コマンドプロンプト起動
cd c:\Python27
python python27convert.py
ずらずらっとコードがプロンプト画面に流れ、msgstringtable.csv が生成されます
<<<python27で変換する手順終了>>>

<<<python313で変換する手順開始>>>
Python313フォルダをC直下に作成
Python313フォルダに[msgstringtable_decoded.txt] と [python313convert.py] を置きます
コマンドプロンプト起動
cd c:\Python313
python python313convert.py
ずらずらっとコードがプロンプト画面に流れ、msgstringtable.csv が生成されます
あるいはダブルクリックでも生成されます
<<<python313で変換する手順終了>>>

<<<python313でBASE64をUTF-8に変換する手順開始>>>
Python313フォルダをC直下に作成
Python313フォルダに[msgstringtable.csv] と [python313 BASE64 to UTF8.py] を置きます
コマンドプロンプト起動
cd c:\Python313
python python313convert.py
ずらずらっとコードがプロンプト画面に流れ、読めるようになった[msgstringtable_decoded.txt]が生成されます
あるいはダブルクリックでも生成されます
<<<python313でBASE64をUTF-8に変換する手順終了>>>