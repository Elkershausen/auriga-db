2026/01//13 第0版

* AIで作成しました
* pythonは3.13を使っています
* 開発者がいなくなっても利用者が簡易な手順でアップデートしながら使い続ける事を目標にしてます
* Job演算値を表示します
* コピーとリセット機能をボタンにつけています

Cドライブ直下に Python313 というフォルダを作ってください

GUIを使うために "customtinker"というpythonでGUIアプリを作れるようになる拡張機能を導入します

1. customtinker インストール
コマンドプロンプトを立ち上げる

<<この次の行をコピーする>>
pip3 install customtkinter
<<ここまで>>

上記文字列をコピーしてコマンドプロンプトで実行する

2. customtinker アップグレード
頻繁な更新があるためアップグレードが推薦されています

<<この次の行をコピーする>>
python.exe -m pip install --upgrade pip
<<ここまで>>

上記文字列をコピーしてコマンドプロンプトで実行する

3. PyInstaller のインストール
実行ファイル(exe)化するためのmodです
まず、EXE化するためのツールをインストールします。ターミナル（コマンドプロンプト）で以下のコマンドを実行してください。

<<この次の行をコピーする>>
pip install pyinstaller
<<ここまで>>

4. sample.py を Python313フォルダに配置する
<<コマンドプロンプト>>
cd c:\Python313
<<コマンドプロンプトここまで>>

5. コンパイルして実行ファイルを作る

<<この次の行をコピーする>>
pyinstaller --onefile --noconsole --collect-all customtkinter sample.py
<<ここまで>>

distというフォルダにsample.exeが作られます

6. 同じフォルダに classnum.json を置く

7. 起動する

8. classnum.json の拡張編集
classnum.jsonを編集すればある程度自分に合うような改造がコンパイル不要でできます

9 うまくいかない場合は [PyInstaller] [customtinker] の使い方をAIに聞いて下さい