// 26/04/07 汎用交換NPC アップデート
// case3 case4 case5 case6 は共通で '@pay_items[1] '@target_items[1] '@cost_id '@cost_num[1] を書き換えるだけで動作します
// 精錬値、カード、エンチャント、ランダムオプション、超越段階や製造武器オプション要素は消えます(case3 は 古いカード帖1000個を使い サングラス[0] -> サングラス[1]+豪傑 グラス[0] -> グラス[1]+真理の解放)
// インベントリから直接交換します
// 成功率は100%です
// setarray '@en3[1] にエンチャントIDを設定したら、配列が同じアイテムにスロット4にエンチャントが付きます
// case7 は装備している場合で、精錬値と既についているカードを引き継ぎます(デフォルトは兜中段)
// 追加したい場合はメニュー階層に グループ6:グループ7 と増やし、汎用テンプレートをコピペしてください
// グループ2以降を使いたい時は、所定のコメントアウト行を消して下さい

prontera.gat,155,105,4	script	アイテムエクスチェンジ	100,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	mes '@npcname$;
	mes "指定アイテムを別のアイテムに交換します。";
	mes "ご用件をどうぞ。";
	next;

	// メニュー階層
	switch(select("説明を詳しく聞く:話をやめる:グループ1:グループ2:グループ3:グループ4:グループ5")) {
		case 1:
			mes '@npcname$;
			mes "【アイテム交換の案内】";
			mes "各グループを選択すると、対象アイテムのリストが表示されます。";
			mes "交換には「材料」と「手数料」が必要です。";
			close;

		case 2:
			mes '@npcname$;
			mes "また御用があればお声がけください。";
			close;

		case 3:
			// ==========================================
			// グループ1: 汎用テンプレート（所持品から選択）
			// 他の開発者はここを書き換えて使用してください
			// ==========================================
			setarray '@pay_items[1],	2201, 2203; // 材料アイテムID
			setarray '@target_items[1],	2202, 2204; // 報酬アイテムID
			setarray '@cost_num[1], 	1000, 1000; // 手数料の個数
			// エンチャント(card4)を指定する場合のみIDを記入（不要なら0）
			setarray '@en3[1], 		29509, 29371; 
			
			set '@cost_id, 616; // 手数料アイテムID(共通)
			goto L_Exchange_Main;

		case 4:
			mes '@npcname$; mes "準備中です。"; close;	//有効にする場合、この行を消す

			// --- グループ2 (エンチャントあり) ---
			setarray '@pay_items[1],	2732, 2730, 2731, 2903, 2902, 1309, 13437, 2923, 28362, 2925, 28363, 2924, 28364, 2926, 28365, 2927, 28366, 2928, 28367;
			setarray '@target_items[1],	2730, 2731, 2732, 2902, 2903, 13437, 1309, 28362, 2923, 28363, 2925, 28364, 2924, 28365, 2926, 28366, 2927, 28367, 2928;
			setarray '@cost_num[1], 	10, 10, 10, 10, 10, 10, 10, 100, 10, 100, 10, 100, 10, 100, 10, 100, 10, 100, 10;
			setarray '@en3[1], 		0, 0, 0, 0, 0, 0, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0;
			set '@cost_id, 6081;
			//goto L_Exchange_Main;

		case 5:
			mes '@npcname$; mes "準備中です。"; close;	//有効にする場合、この行を消す

			// --- グループ3 ---
			setarray '@pay_items[1],	2656, 28373;
			setarray '@target_items[1],	28373, 2656;
			setarray '@cost_num[1], 	10, 10;
			cleararray '@en3[0], 0, 128;
			set '@cost_id, 6081;
			//goto L_Exchange_Main;

		case 6:
			mes '@npcname$; mes "準備中です。"; close;	//有効にする場合、この行を消す

			// --- グループ4 ---
			setarray '@pay_items[1],	2900, 2901, 28348, 28347, 13324, 13326, 13325, 18940, 28906, 18941, 28907, 18942, 28908, 18943, 28909, 2998, 22082;
			setarray '@target_items[1],	2901, 2900, 28347, 28348, 13326, 13325, 13324, 28906, 18940, 28907, 18941, 28908, 18942, 28909, 18943, 22082, 2998;
			setarray '@cost_num[1], 	10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10;
			cleararray '@en3[0], 0, 128;
			set '@cost_id, 6081;
			goto L_Exchange_Main;

		case 7:
			mes '@npcname$; mes "準備中です。"; close;	//有効にする場合、この行を消す

			// --- グループ5 (装備中アイテム交換) ---
			// ※特殊ロジックのため L_Exchange_Main は使わず個別に完結
			setarray '@pay_items[1], 410322, 410323, 410340, 410341, 410504, 410506, 410505, 410507;
			setarray '@target_items[1], 410340, 410341, 410322, 410323, 410505, 410507, 410504, 410506;
			setarray '@cost_num[1], 10, 10, 10, 10, 10, 10, 10, 10;
			set '@cost_id, 6081;

			set '@part, 9;
			if (getequipisequiped('@part) == 0) {
				mes '@npcname$; mes "中段にアイテムを装備していません。"; close;
			}
			set '@current_eq_id, getequipid('@part);
			set '@idx, 0;
			for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
				if ('@pay_items['@i] == '@current_eq_id) { set '@idx, '@i; break; }
			}
			if ('@idx == 0) {
				mes '@npcname$; mes "装備中のアイテムは交換対象外です。"; close;
			}
			set '@target_id, '@target_items['@idx];
			set '@num, '@cost_num['@idx];
			set '@ref, getequiprefinerycnt('@part);
			set '@en0, getequipcardid('@part, 0);

			mes '@npcname$;
			mes "装備中の ^FF0000" + getitemname('@current_eq_id) + "^000000 を交換します。";
			mes "精錬値とカードを引き継ぎます。手数料：" + '@num + "個";
			next;
			if(select("交換する:やめる") == 2) close;
			if(countitem('@cost_id) < '@num) { mes '@npcname$; mes "手数料不足。"; close; }
			if(checkweight('@target_id, 1) == 0) { mes '@npcname$; mes "重量オーバー。"; close; }
			delitem '@cost_id, '@num;
			unequip '@part;
			delitem '@current_eq_id, 1;
			getitem2 '@target_id, 1, 1, '@ref, 0, '@en0, 0, 0, 0;
			misceffect 12; mes '@npcname$; mes "完了しました。"; close;

		default:
			mes '@npcname$; mes "準備中です。"; close;
	}

// --- 交換用共通ロジック (グループ1-4用) ---
L_Exchange_Main:
	mes '@npcname$;
	mes "どのアイテムを交換に出しますか？";
	next;

	set '@menu_str$, "";
	for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
		set '@p_id, '@pay_items['@i];
		set '@menu_str$, '@menu_str$ + getitemname('@p_id) + "[" + getiteminfo('@p_id, 10) + "]:";
	}
	
	set '@idx, select('@menu_str$);
	
	set '@target_id, '@target_items['@idx];
	set '@pay_id, '@pay_items['@idx];
	set '@num, '@cost_num['@idx];
	set '@en_id, '@en3['@idx];

	mes '@npcname$;
	mes "【確認】";
	mes "材料：" + getitemname('@pay_id) + "[" + getiteminfo('@pay_id, 10) + "]";
	mes "費用：" + getitemname('@cost_id) + " " + '@num + "個";
	mes "入手：" + getitemname('@target_id) + "[" + getiteminfo('@target_id, 10) + "]";
	if ('@en_id > 0) mes "付与：" + getitemname('@en_id);
	next;

	if(select("交換する:やめる") == 2) close;

	if(countitem('@pay_id) < 1 || countitem('@cost_id) < '@num) {
		mes '@npcname$; mes "アイテムが足りません。"; close;
	}
	if(checkweight('@target_id, 1) == 0) {
		mes '@npcname$; mes "重量オーバーです。"; close;
	}

	delitem '@pay_id, 1;
	delitem '@cost_id, '@num;

	if ('@en_id > 0) {
		getitem2 '@target_id, 1, 1, 0, 0, 0, 0, 0, '@en_id;
	} else {
		getitem '@target_id, 1;
	}

	misceffect 12;
	mes '@npcname$; mes "完了しました。";
	close;
}
