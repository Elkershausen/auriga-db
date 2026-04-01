// 26/04/02 アップデート (AI実装)
// costume ファイル(拡張子なしcsv)をdbフォルダに移動し、サーバーに "script_csvload: db\costume load successfully" と出れば使えます
// 毎回所持アイテムを全部消します
// 0が先頭で行数 100 単位で costume ファイル に定義のあるアイテムを入手します

prontera.gat,150,140,4	script	衣装実装確認(CSV)	10439,{

    clearitem;
    mes "[アイテム実装確認]";
    mes "モードを選択してください。";
    next;

    // メニューにCSV読み込みモードを追加
    set '@mode, select("全種類100個:衣装(CSVから順に100個):1個ずつ確認:終了");

    switch('@mode) {
        case 1: goto L_BatchMode;
        case 2: goto L_CsvMode;
        case 3: goto L_SingleMode;
        default: close;
    }

// --- CSV読み込みモード ---
L_CsvMode:
	set @file$, "db/costume";
    mes "[CSV一括入手モード]";
    // CSVの総行数を取得 
    set '@rows, csvgetrows(@file$);
    
    if ('@rows <= 0) {
        mes "CSVファイルが見つからないか、空です。";
        close;
    }

    mes "CSVの全 " + '@rows + " 件中、";
    mes "何番目の行から開始しますか？(0 ～ " + ('@rows - 1) + ")";
    next;
    input '@start_row;

    if ('@start_row < 0 || '@start_row >= '@rows) {
        mes "無効な行番号です。";
        close;
    }

    set '@count, 0;
    set '@total_rows, 100 + '@start_row;
// 100個分、またはCSVの最後までループ処理
    while('@count < 100 && ('@start_row + '@count) < '@total_rows) {
        
        // CSVの指定行(行番号: @start_row + @count) の 0列目からアイテムIDを取得
        set '@target_id, csvread(@file$, '@start_row + '@count, 0);
        
        if (getitemname('@target_id) != "") {
            getitem '@target_id, 1;
            set '@count, '@count + 1;
        } else {
            set '@start_row, '@start_row + 1;
            if (('@start_row + '@count) >= '@total_rows) break;
        }
    }
    
    // 最後に完了メッセージを表示
    mes "CSVからの配布を完了しました。";
    mes "(" + '@count + "個の衣装を入手完了)";
    close;

// --- 他のモードは以前のものを流用 ---
L_BatchMode:
    // (省略: ID順に100個配布するロジック)
    mes "使いません。";
    close;

L_SingleMode:
    // (省略: 1個ずつ確認するロジック)
    mes "使いません。";
    close;
}