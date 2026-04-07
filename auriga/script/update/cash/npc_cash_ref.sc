prontera.gat,155,105,4	script	鍛冶師レイブン	731,{

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
		case 1: goto L_Check_Equip;
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

L_Check_Equip:
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

L_Refine_Start:
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
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  69000,  44000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  72000,  46000,  22000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  75000,  60000,  23000,  22000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  78000,  50000,  48000,  23000,  22000,  10000; break;
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
