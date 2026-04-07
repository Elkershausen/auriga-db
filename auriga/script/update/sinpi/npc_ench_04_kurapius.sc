// 2026/04/07 クラピウスNPC (AI実装)
// 仕様通り実装
// ev_season01.gat 必要
// 未実装要素：メッセージ未調査

ev_season01.gat,36,123,4	script	クラピウス	897,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	mes '@npcname$;
	mes "指定アイテムを上位のアイテムに交換します。";
	mes "ご用件をどうぞ。";
	next;

	// メニュー階層
	switch(select("説明を詳しく聞く:話をやめる:グループ1:グループ2:グループ3:グループ4:グループ5")) {
		case 1:
			mes '@npcname$;
			mes "【アイテム交換の案内】";
			mes "指定の材料を ^FF0000 200個 ^000000 持っていれば、";
			mes "上位のアイテム1個と交換して差し上げましょう。";
			close;

		case 2:
			mes '@npcname$;
			mes "また御用があればお声がけください。";
			close;

		case 3:
			// --- グループ1 ---
			setarray '@pay_items[1], 25660, 25788, 27047, 25789, 25389, 25661, 25443, 25442, 25720, 25397, 25790, 25719, 27049;
			setarray '@pay_num[1], 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200;
			setarray '@target_items[1], 27300, 29608, 27046, 29609, 27155, 27299, 27205, 27204, 27303, 27156, 29610, 27302, 27048;
			setarray '@target_num[1], 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1;
			goto L_Exchange_Main;

		default:
			mes '@npcname$; mes "準備中です。"; close;
	}

// --- 交換用共通ロジック ---
L_Exchange_Main:
	mes '@npcname$;
	mes "どのアイテムを交換に出しますか？";
	next;

	// 1. メニュー作成
	set '@menu_str$, "";
	for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
		set '@menu_str$, '@menu_str$ + getitemname('@pay_items['@i]) + " (" + '@pay_num['@i] + "個):";
	}

	set '@idx, select('@menu_str$);

	// 交換データの確定
	set '@p_id, '@pay_items['@idx];
	set '@p_num, '@pay_num['@idx];
	set '@t_id, '@target_items['@idx];
	set '@t_num, '@target_num['@idx];

	mes '@npcname$;
	mes "【交換内容の確認】";
	mes "材料：^FF0000" + getitemname('@p_id) + " " + '@p_num + "個^000000"; 
	mes "報酬：^0000FF" + getitemname('@t_id) + " " + '@t_num + "個^000000"; 
	next;

	if(select("交換する:やめる") == 2) {
		mes '@npcname$; mes "またの機会に。"; close;
	}

	// 2. 条件チェック
	if (countitem('@p_id) < '@p_num) {
		mes '@npcname$;
		mes "材料が足りないようです。";
		mes "あと " + ('@p_num - countitem('@p_id)) + " 個必要です。"; 
		close;
	}

	if (checkweight('@t_id, '@t_num) == 0) { 
		mes '@npcname$; mes "荷物が重すぎて受け取れません。"; close;
	}

	// 3. 実行処理
	delitem '@p_id, '@p_num;
	getitem '@t_id, '@t_num;

	misceffect 12;
	mes '@npcname$;
	mes "交換が完了しました。";
	close;
}