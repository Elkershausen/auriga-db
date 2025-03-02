# -*- coding: utf-8 -*-
import csv
import base64

# CSV ファイルを UTF-8 エンコードで読み書き
with open('msgstringtable_decoded.txt', 'r', encoding='utf-8') as decoded, \
     open('msgstringtable.csv', 'w', encoding='utf-8', newline='') as outfile:

    rdr = csv.reader(decoded, delimiter=',')
    writer = csv.writer(outfile, delimiter=',')

    for row in rdr:
        if len(row) < 2:  # 空行や列が足りない行はスキップ
            continue
        
        # Base64エンコード
        idx = base64.b64encode(row[0].encode("utf-8")).decode("utf-8")
        msg = base64.b64encode(row[1].encode("utf-8")).decode("utf-8")

        # CSVに書き込み
        writer.writerow([idx, msg])
        
        # 確認のため表示
        print(f"{idx},{msg}")
