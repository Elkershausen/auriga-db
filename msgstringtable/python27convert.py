# -*- coding: utf-8 -*-
import csv
import base64

# CSV ファイルの読み込み・書き込みはバイナリモードで行います
with open('msgstringtable_decoded.txt', 'rb') as decoded, \
     open('msgstringtable.csv', 'wb') as outfile:
    
    rdr = csv.reader(decoded, delimiter=',')
    for row in rdr:
        if len(row) < 2:  # 空行や列が足りない行はスキップ
            continue
        # row[0] と row[1] は既に UTF-8 エンコードされたバイト列
        idx = base64.b64encode(row[0])
        msg = base64.b64encode(row[1])
        print("{},{}".format(idx, msg))
        outfile.write("{},{}\n".format(idx, msg))
