# -*- coding: utf-8 -*-
import csv
import base64

# エンコードされたCSVを読み込み、デコードしてTXTに保存
with open('msgstringtable.csv', 'r', encoding='utf-8') as encoded, \
     open('msgstringtable_decoded.txt', 'w', encoding='utf-8', newline='') as outfile:

    rdr = csv.reader(encoded, delimiter=',')
    writer = csv.writer(outfile, delimiter=',')

    for row in rdr:
        if len(row) < 2:  # 空行や列が足りない行はスキップ
            continue
        
        # Base64デコード
        idx = base64.b64decode(row[0]).decode("utf-8")
        msg = base64.b64decode(row[1]).decode("utf-8")

        # TXTに書き込み
        writer.writerow([idx, msg])
        
        # 確認のため表示
        print(f"{idx},{msg}")
