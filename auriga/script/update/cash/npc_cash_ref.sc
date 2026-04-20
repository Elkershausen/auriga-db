// 2026/04/21 アップデート
// 究極精錬[鍛冶師レイブン] / 微力の究極精錬[スズメ] / 確定精錬チケット[サンバ] / 改良濃縮精錬[アビダブ] 実装
// 成功テーブルに [加算される場合] [乗算される場合] を記述し、選べるように追記(標準は乗算)

// 究極精錬
iz_gimlet.gat,13,73,5	script	鍛冶師レイブン#35018	731,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";
	set '@cost_id, 6952;

	// 1. インベントリ種類数チェック (91個以上の場合は中断)
	getinventorylist;
	if (@inventorylist_count >= 91) {
		mes '@npcname$;
		mes "荷物が種類数でいっぱい（" + @inventorylist_count + "/100）だ。";
		mes "インベントリを10個以上空けてから来てくれ。";
		close;
	}

	if((Weight * 100 / MaxWeight) > 90) {
		mes '@npcname$;
		//mes "最大所持重量 : " + (MaxWeight / 10);
		//mes "今の所持重量 : " + (Weight / 10);
		//mes "重量使用% : " + (Weight * 100 / MaxWeight) + "% ";
		//mes "---------------------------";
		mes "所持重量が90％を超えている。";
		mes "荷物を預けて来てくれ。";
		close;
	}

	mes '@npcname$;
	mes "……何の様だ？";
	next;
	switch(select("精錬を依頼する:話を聞きたい:立ち去る")) {
		case 1: break;
		case 2:
			mes '@npcname$;
			mes "装備は壊れたり";
			mes "精錬値が下がる心配は無いが、";
			mes "成功・失敗どちらでも";
			mes "「<ITEM>究極精錬チケット<INFO>6952</INFO></ITEM>」は手数料としてもらう。";
			next;
			mes '@npcname$;
			mes "精錬サービス利用のお礼に";
			mes "ささやかなアイテムを一緒に渡す。";
			mes "なので、所持欄を空け";
			mes "所持重量に余裕を持って来てくれ。";
			close;
		case 3:
			mes '@npcname$;
			mes "それじゃあな。";
			close;
	}

	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;

	// 1-10の部位をループで確認
	for(set '@i, 1; '@i <= 10; set '@i, '@i + 1) {
		if (getequipisequiped('@i)) {
			set '@match_count, '@match_count + 1;
			set '@match_idx['@match_count], '@i;
			
			// エラー回避のため、情報を一度変数に格納してから結合します
			set '@temp_id, getequipid('@i);
			set '@temp_name$, getequipname('@i);
			set '@temp_slot, getiteminfo('@temp_id, 10);
			
			// 文字列を1ステップずつ結合して安定させます
			set '@menu_str$, '@menu_str$ + '@temp_name$;
			set '@menu_str$, '@menu_str$ + "[" + '@temp_slot + "]:";
		}
	}

	if ('@match_count == 0) {
		mes '@npcname$;
		mes "装備が見当たらないぜ。";
		close;
	}

	mes '@npcname$;
	mes "どれを精錬するんだ？";
	next;

	set '@sel, select('@menu_str$);
	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes '@npcname$;
		mes "その装備は精錬できない。";
		close;
	}
	if(getequipisidentify('@i) == 0) {
		mes '@npcname$;
		mes "未鑑定アイテムは精錬できない。";
		close;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes '@npcname$;
		mes "これ以上は精錬できない。";
		close;
	}

	set '@wlv, getequipweaponlv('@i);

	// 成功テーブルの定義 (1/100000)
	switch('@wlv) {
		// 成功率が倍率で増える場合(防具の+4 -> +5 の場合 60% * 130% = 78%)
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  69000,  44000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  72000,  46000,  22000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  75000,  60000,  23000,  22000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;

		// 成功率が上乗せされる場合(防具の+4 -> +5 の場合 60% + 30% = 90%)
		//case 0: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
		//case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  90000,  60000,  20000; break;
		//case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  30000,  20000; break;
		//case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  90000,  90000,  30000,  30000,  20000; break;
		//case 4: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
	}
		mes '@npcname$;
		mes "お前が選んだ装備を";
		mes "精錬するためには";
		mes "「<ITEM>究極精錬チケット<INFO>6952</INFO></ITEM>」が1枚必要だ。";
		mes "精錬するか？";
		next;
		if(select("はい:いいえ") == 2) close;

	// --- 成功率によるメッセージ分岐 ---
	if ('@rate['@current_ref] < 100000) {
		// 成功率が100%を下回る場合
		mes '@npcname$;
		mes "…ふむ…";
		mes "この装備はもう何回も";
		mes "精錬されている。";
		next;
		mes '@npcname$;
		mes "装備は壊れたり";
		mes "精錬値が下がる心配は無いが、";
		mes "成功・失敗どちらでも";
		mes "「<ITEM>究極精錬チケット<INFO>6952</INFO></ITEM>」は手数料としてもらう。";
		mes "それでも精錬するか？";
		next;
		if(select("はい:いいえ") == 2) close;
	}
	// アイテム所持チェック
	if(countitem('@cost_id) < 1) {
		mes '@npcname$;
		mes "「<ITEM>究極精錬チケット<INFO>6952</INFO></ITEM>」が";
		mes "足りないな。";
		close;
	}

	// 実行：材料消費
	delitem '@cost_id, 1;
	mes '@npcname$;
	mes "カン！ カン！ カン！";

	// --- 追加アイテム入手処理 ---
	// 追加アイテムリストの定義 1000868 より後ろは 48時間で消滅
	setarray '@extra_item[0], 101286, 101287, 101288, 101289, 101290, 101291, 101292, 25374, 1000868, 1000869, 1000870, 1000871, 1000872, 1000873;
	setarray '@extra_num[0], 1, 1, 1, 10, 1, 1, 1, 20, 1, 1, 1, 1, 1, 1;
	
	// 0-13の範囲でランダムに1つ選ぶ (等しい確率)
	set '@r, rand(14);
	set '@get_id, '@extra_item['@r];
	set '@get_num, '@extra_num['@r];
	if('@r > 7) { getitem2 '@get_id,'@get_num,1,0,0,0,0,0,0,172800; } else { getitem '@get_id, '@get_num; }

	// 成功判定
	if('@rate['@current_ref] > rand(100000)) {
		successrefitem '@i;
		next;
		emotion 21;
		mes '@npcname$;
		mes "無事に精錬が終わった。";
		mes "それじゃあな。";
		close;
	} else {
		misceffect 155;
		next;
		emotion 23;
		mes '@npcname$;
		mes "…こればっかりは慣れないな。";
		next;
		mes '@npcname$;
		mes "無事とは言えないが精錬が終わった。";
		mes "それじゃあな。";
		close;
	}
}

// 微力の究極精錬
iz_gimlet.gat,13,77,5	script	スズメ#35017	757,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";
	
	// 性別取得関数でメッセージが変わるように設定
	// Sex: 0=女性, 1=男性
	set '@player_name$, strcharinfo(0);
	set '@honorific$, (Sex == 1 ? "くん" : "ちゃん");

	// 1. インベントリ種類数チェック
	getinventorylist;
	if (@inventorylist_count >= 91) {
		mes '@npcname$;
		mes "荷物が種類数でいっぱい（" + @inventorylist_count + "/100）だよ。";
		mes "インベントリを10個以上空けてから来てね。";
		close;
	}

	if((Weight * 100 / MaxWeight) > 90) {
		mes '@npcname$;
		mes "所持重量が90％を超えているよ。";
		mes "荷物を預けて来てね。";
		close;
	}

	emotion 2;
	mes '@npcname$;
	mes "はぁい☆";
	mes "スズメだよーっ！";
	mes "ヨロ～♪";
	// 性別判定に基づいた呼称を表示
	mes "" + '@player_name$ + " " + '@honorific$;
	mes "今日もガンバってるぅ～？";
	next;

	switch(select("精錬サービス:話を聞く:立ち去る")) {
		case 1: break;
		case 2:
			mes '@npcname$;
			mes "スズメは精錬値6以下のアイテムを";
			mes "パワーアップ(精錬)！";
			mes "できるんだ～♪";
			next;
			mes '@npcname$;
			mes "依頼を受ける時は";
			mes "「<ITEM>微力の究極精錬チケット<INFO>1000463</INFO></ITEM>」を";
			mes "1個もらってるよー☆";
			next;
			mes '@npcname$;
			mes "アイテムが消滅したり";
			mes "精錬値が下がらないの！";
			mes "すっごいでしょ～？";
			mes "失敗はイヤだけど！";
			next;
			mes '@npcname$;
			mes "精錬値3以下の場合でも";
			mes "精錬することは可能なんだけど～";
			mes "安全精錬圏のアイテムについては";
			mes "他の人に頼んだほうが良いよ☆";
			mes "もったいないもんね♪";
			next;
			emotion 39;
			mes '@npcname$;
			mes "ちなみに～？";
			mes "スズメの好きなものは";
			mes "美味しいキャンディ☆";
			next;
			emotion 31;
			mes '@npcname$;
			mes "ん？";
			mes "" + '@player_name$ + " " + '@honorific$ + " も";
			mes "キャンディほしいの？";
			mes "ほい！間接キス☆";
			close;

		case 3:
			mes '@npcname$;
			mes "じゃあね。";
			close;
	}

	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;

	for(set '@i, 1; '@i <= 10; set '@i, '@i + 1) {
		if (getequipisequiped('@i)) {
			set '@match_count, '@match_count + 1;
			set '@match_idx['@match_count], '@i;
			set '@temp_id, getequipid('@i);
			set '@temp_name$, getequipname('@i);
			set '@temp_slot, getiteminfo('@temp_id, 10);
			set '@menu_str$, '@menu_str$ + '@temp_name$ + "[" + '@temp_slot + "]:";
		}
	}

	if ('@match_count == 0) {
		mes '@npcname$;
		mes "装備が見当たらないよ。";
		close;
	}

	mes '@npcname$;
	mes "どれを精錬したいのー？";
	next;

	set '@sel, select('@menu_str$);
	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes '@npcname$;
		mes "その装備は精錬できないよ。";
		close;
	}
	if(getequipisidentify('@i) == 0) {
		mes '@npcname$;
		mes "未鑑定アイテムは精錬できないよ。";
		close;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 7) {
		mes '@npcname$;
		mes "これ以上は精錬できないよ。";
		close;
	}

	set '@wlv, getequipweaponlv('@i);

	// 成功テーブル
	switch('@wlv) {
		// 成功率が倍率で増える場合(防具の+4 -> +5 の場合 60% * 130% = 78%)
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  69000,  44000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  72000,  46000,  22000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  75000,  60000,  23000,  22000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;

		// 成功率が上乗せされる場合(防具の+4 -> +5 の場合 60% + 30% = 90%)
		//case 0: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
		//case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  90000,  60000,  20000; break;
		//case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  30000,  20000; break;
		//case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  90000,  90000,  30000,  30000,  20000; break;
		//case 4: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
	}

	emotion 5;
	mes '@npcname$;
	mes "精錬をするには～";
	mes "「<ITEM>微力の究極精錬チケット<INFO>1000463</INFO></ITEM>」が";
	mes "1個必要だよーん。";
	mes "本当に精錬していーい？";
	next;
	
	// 選択肢の入れ替え（いいえ を先に配置）
	if(select("いいえ:はい") == 1) close;

	emotion 2;
	mes '@npcname$;
	mes "それじゃ、どーんと";
	mes "いってみよー！";
	next;
		
	// 必要アイテムのチェック（開発者向けメモ用・仮設定を維持）
	set '@cost_id, 1000463; 
	// 1000463[キャンペーン]微力の究極精錬チケット 1000464[イベント]微力の究極精錬チケット 2種ある

	if(countitem('@cost_id) < 1) {
		mes '@npcname$;
		mes "「<ITEM>微力の究極精錬チケット<INFO>1000463</INFO></ITEM>」が";
		mes "足りないよ。";
		close;
	}

	delitem '@cost_id, 1;

	if('@rate['@current_ref] > rand(100000)) {
		successrefitem '@i;
		// misceffect 白っぽく丸い-虹色に変わる-星が飛ぶ- のような感じ 1400番まで調べ単体なかったので誰か調べて下さい;
		next;
		emotion 2;
		mes '@npcname$;
		mes "大☆成☆功!!";
		mes "いえーい！";
		mes "スズメってば超イケてるっしょ～☆";
		close;
	} else {
		misceffect 155;
		next;
		emotion 16;
		mes '@npcname$;
		mes "えぇ～……なにそれ～";
		mes "マジ最低～……。";
		mes "" + '@player_name$ + " " + '@honorific$;
		mes "ごめ～ん……。";
		close;
	}
}

// 確定精錬チケット
morocc.gat,131,61,5	script	サンバ#35019	449,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	mes '@npcname$;
	mes "私はあらゆる精錬大会で";
	mes "優勝を収めてきました。";
	mes "しかしそれに驕ることなく";
	mes "これからも研鑽に励んでまいります。";
	next;

	switch(select("精錬サービス:話を聞く:立ち去る")) {
		case 1: break;
		case 2:
			mes '@npcname$;
			mes "特定のチケットを消費することで";
			mes "精錬値を確実に引き上げます。";
			close;
		case 3:
			mes '@npcname$;
			mes "じゃあね。";
			close;
	}

	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;

	for(set '@i, 1; '@i <= 10; set '@i, '@i + 1) {
		if (getequipisequiped('@i)) {
			set '@match_count, '@match_count + 1;
			set '@match_idx['@match_count], '@i;
			set '@temp_id, getequipid('@i);
			set '@temp_name$, getequipname('@i);
			set '@temp_slot, getiteminfo('@temp_id, 10);
			set '@menu_str$, '@menu_str$ + '@temp_name$ + "[" + '@temp_slot + "]:";
		}
	}

	if ('@match_count == 0) {
		mes '@npcname$;
		mes "装備が見当たらないです。";
		close;
	}

	mes '@npcname$;
	mes "どれを精錬しますか？";
	next;

	set '@sel, select('@menu_str$);
	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes '@npcname$;
		mes "その装備は精錬できません。";
		close;
	}
	if(getequipisidentify('@i) == 0) {
		mes '@npcname$;
		mes "未鑑定アイテムは精錬できません。";
		close;
	}
	
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes '@npcname$;
		mes "これ以上は精錬できません。";
		close;
	}

	mes '@npcname$;
	mes "このアイテムの現在の精錬値は";
	mes "「"+ '@current_ref + "」です。";
	mes "精錬値をいくつにしますか？";
	next;

	// チケットと目標精錬値の定義
	setarray '@ticket[0],  1000868, 1000869, 1000870, 1000871, 1000872, 1000873;
	setarray '@refval[0],  5,       6,       7,       8,       9,       10;

	set '@sel_ticket, select("精錬値を5にする:精錬値を6にする:精錬値を7にする:精錬値を8にする:精錬値を9にする:精錬値を10にする:やめる") - 1;

	if ('@sel_ticket >= 6) {
		mes '@npcname$;
		mes "中止します。";
		close;
	}

	set '@del_ticket, '@ticket['@sel_ticket];
	set '@target_ref, '@refval['@sel_ticket];

	mes '@npcname$;
	mes "「" + getitemname('@del_ticket) + "」";
	mes "を使用して、このアイテムの";
	mes "精錬値を「" + '@target_ref + "」にします。";
	mes "精錬しても宜しいですか？";
	next;

	if (select("はい:いいえ") == 2) {
		mes '@npcname$;
		mes "精錬を中止します。";
		close;
	}

	// 条件チェック：所持数
	if (countitem('@del_ticket) < 1) {
		mes '@npcname$;
		mes getitemname('@del_ticket) + " が";
		mes "ありません。";
		close;
	}

	// 条件チェック：現在の精錬値の方が高い、または同じ場合
	if ('@current_ref >= '@target_ref) {
		mes '@npcname$;
		mes "そのチケットでは";
		mes "精錬値を増やせません。";
		close;
	}

	// 最終処理
	delitem '@del_ticket, 1;
	set '@ref_count, '@target_ref - '@current_ref;
	
	while('@ref_count > 0) {
		successrefitem '@i;
		// sleep2の戻り値をチェックしつつ、スタックを溜めないようにする
		if (sleep2(1) == 0) end; 
		set '@ref_count, '@ref_count - 1;
	}

	misceffect 12;
	mes '@npcname$;
	mes "優勝……こほん";
	mes "……苦しい戦いでした。";
	mes "今回の結果に驕ることなく";
	mes "これからも研鑽に励んで参ります。";
	mes "";
	close;
}

// 改良濃縮精錬
morocc.gat,155,78,5	script	アビダブ#26673	99,{
	// messize 2022環境互換性のため表示ウインドウ拡張 未使用

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	// messize 300, 280;	// 表示ウインドウ拡張(縦 * 横)
	mes '@npcname$;
	mes "俺は鍛冶屋だ！";
	mes "お前が装備しているアイテムを";
	mes "精錬できるってわけだ。ただし、";
	mes " ";
	mes "■武器";
	mes "<ITEM>改良型濃縮オリデオコン<INFO>6240</INFO></ITEM>1個";
	mes " ";
	mes "■防具";
	mes "<ITEM>改良型濃縮エルニウム<INFO>6241</INFO></ITEM>1個";
	mes " ";
	mes "■シャドウ装備";
	mes "<ITEM>改良型濃縮シャドウダイト<INFO>1001811</INFO></ITEM>1個";
	mes " ";
	mes "と、手数料が必要だぞ。";
	next;
	switch(select("精錬を依頼する:立ち去る")) {
		case 1: break;
		case 2:
			mes '@npcname$;
			mes "やめるなら仕方がないな。";
			close;
	}

	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;

	// スキャン対象：1-10(通常) と 17-22(シャドウ)
	setarray '@scan_list[0], 1,2,3,4,5,6,7,8,9,10, 17,18,19,20,21,22;

	for(set '@i, 0; '@i < getarraysize('@scan_list); set '@i, '@i + 1) {
		set '@part, '@scan_list['@i];
		if (getequipisequiped('@part)) {
			set '@match_count, '@match_count + 1;
			set '@match_idx['@match_count], '@part;
			
			set '@temp_id, getequipid('@part);
			set '@temp_name$, getequipname('@part);
			set '@temp_slot, getiteminfo('@temp_id, 10);
			
			set '@menu_str$, '@menu_str$ + '@temp_name$ + "[" + '@temp_slot + "]:";
		}
	}

	if ('@match_count == 0) {
		mes '@npcname$;
		mes "装備が見当たらないな。";
		close;
	}

	mes '@npcname$;
	mes "それで、お前はどの装備アイテムを";
	mes "精錬したい？";
	next;

	set '@sel, select('@menu_str$);
	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes '@npcname$; mes "その装備は精錬でません。"; close;
	}
	if(getequipisidentify('@i) == 0) {
		mes '@npcname$; mes "未鑑定のままでは精錬できません。"; close;
	}
	
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes '@npcname$; mes "これ以上は精錬できません。"; close;
	}

	// 武器レベルと部位に応じたコスト・下限値の設定
	set '@wlv, getequipweaponlv('@i);
	// インデックス: 0=防具, 1=Lv1, 2=Lv2, 3=Lv3, 4=Lv4
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 6241, 6240, 6240, 6240, 6240;
	setarray '@min_refs, 4, 7, 6, 5, 4;

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if('@wlv == 0) { set '@str$, "<ITEM>改良型濃縮エルニウム<INFO>6241</INFO></ITEM>"; }
	else { set '@str$, "<ITEM>改良型濃縮オリデオコン<INFO>6240</INFO></ITEM>"; }

	// シャドウ装備(17-22)の場合のコストとメッセージ上書き
	if ('@i >= 17) {
		set '@cost_zeny, 10000;
		set '@cost_item, 1001811;
		set '@min_limit, 4;
		set '@str$, "<ITEM>改良型濃縮シャドウダイト<INFO>1001811</INFO></ITEM>";
	}

	// 下限精錬値チェック
	if ('@current_ref < '@min_limit) {
		mes '@npcname$;
		mes "その装備の精錬値はまだ ^FF0000+" + '@current_ref + "^000000。";
		mes "精錬値は最低でも ^0000FF+" + '@min_limit + "^000000 必要だ。";
		close;
	}

	// messize 300, 280;	// 表示ウインドウ拡張
	mes '@npcname$;
	mes "お前が選んだ装備を精錬するには";
	mes "" + '@str$ + "1個と";
	mes "手数料 " + '@cost_zeny + "Zenyが必要だ。";
	mes "装備が壊れる心配はないが";
	mes "失敗した場合は";
	mes "^FF0000精錬値が1下がっっちゃうからな……!?^000000";
	mes "それでも精錬するつもりか？";
	next;
	if(select("はい:いいえ") == 2) {
		mes '@npcname$; mes "やめるなら仕方がないな。"; close;
	}

	// 成功テーブル定義
	switch('@wlv) {
		// 成功率が倍率で増える場合(防具の+4 -> +5 の場合 60% * 130% = 78%)
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  69000,  44000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  72000,  46000,  22000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  75000,  60000,  23000,  22000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;

		// 成功率が上乗せされる場合(防具の+4 -> +5 の場合 60% + 30% = 90%)
		//case 0: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
		//case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  90000,  60000,  20000; break;
		//case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  30000,  20000; break;
		//case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  90000,  90000,  30000,  30000,  20000; break;
		//case 4: setarray '@rate, 100000, 100000, 100000, 100000,  90000,  60000,  60000,  30000,  30000,  10000; break;
	}

	// 所持チェック
	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes '@npcname$; mes "材料か資金が足りません。"; close;
	}

	delitem '@cost_item, 1;
	set Zeny, Zeny - '@cost_zeny;
	showmessage "カン！カン！カン！";

	if('@rate['@current_ref] > rand(100000)) {
		successrefitem '@i;
		emotion 21;
		mes '@npcname$;
		mes "さ！無事に精錬が終わったぜ。";
		mes "俺の腕はまだまだ使えるぜ！";
		mes "自分で言うのもなんだが";
		mes "なかなか良い出来じゃないか！";
	} else {
		// 失敗時は精錬値が下がる（破壊はされない仕様を想定）
		// messize 300, 280;	// 表示ウインドウ拡張
		downrefitem '@i;
		emotion 23;
		mes '@npcname$;
		mes "ウアアアアアアアアアアッ!!!!";
		mes " ";
		mes "あ、あら…";
		mes "失敗しちゃった。ご、ごめん……";
		mes "で、でも装備は壊れないぞ!!";
		mes " ";
		mes "精錬値は1下がってしまったが……";
		mes "だ、だからさ……";
		mes "危ないって言ったじゃないか……";
		mes "俺をそんな目でみないでくれ……";
	}
	close;
}
