// 2026/04/07 五欲の壺NPC (AI実装)
// 仕様通り実装
// ev_season01.gat 必要
// 未実装要素：メッセージ未調査

ev_season01.gat,37,116,4	script	五欲の壺	10158,{

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
			mes "指定の装備を身に着けた状態で話しかけてください。";
			mes "交換するアイテムと同じアイテムを持たないで下さい。";
			mes "交換には ^FF0000精錬値 " + 9 + " 以上^000000 が必要です。";
			close;

		case 2:
			mes '@npcname$;
			mes "また御用があればお声がけください。";
			close;

		case 3:
			// --- グループ1 ---
			setarray '@pay_items[1], 13473, 28940, 15237, 19304, 450223, 450224, 450288, 450287;
			setarray '@pay_pos[1],   4,     3,     2,     1,     2,      2,      2,      2;
			setarray '@target_items[1], 500005, 460000, 450120, 400019, 450224, 450225, 450287, 450286;
			set '@pay_ref, 9; // 必要な精錬値
			goto L_Exchange_Main;

		case 4:
		case 5:
		case 6:
		case 7:
			mes '@npcname$; mes "準備中です。"; close;

		default:
			mes '@npcname$; mes "準備中です。"; close;
	}

// --- 交換用共通ロジック ---
L_Exchange_Main:
	// 1. プレイヤーが現在装備しているアイテムを走査してリストを作成
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128; // マッチした配列インデックスを保存

	for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
		set '@pos, '@pay_pos['@i];
		// 指定部位に指定アイテムを装備しているかチェック 
		if (getequipid('@pos) == '@pay_items['@i]) {
			set '@match_count, '@match_count + 1;
			set '@match_idx['@match_count], '@i;
			// メニュー用に「アイテム名[スロット] (+精錬値)」を表示
			set '@menu_str$, '@menu_str$ + getitemname('@pay_items['@i]) + "[" + getiteminfo('@pay_items['@i], 10) + "] (+" + getequiprefinerycnt('@pos) + "):";
		}
	}

	if ('@match_count == 0) {
		mes '@npcname$;
		mes "交換対象のアイテムを装備していないようです。";
		mes "対象の装備を身に着けてから再度話しかけてください。";
		close;
	}

	mes '@npcname$;
	mes "交換に出す装備を選択してください。";
	next;

	set '@sel, select('@menu_str$);
	set '@target_idx, '@match_idx['@sel]; // 配列内の元々の位置を特定

	// 選択された装備のデータ確定
	set '@p_id,  '@pay_items['@target_idx];
	set '@p_pos, '@pay_pos['@target_idx];
	set '@t_id,  '@target_items['@target_idx];
	set '@current_ref, getequiprefinerycnt('@p_pos); // 現在の精錬値取得 

	// 2. 精錬値チェック
	mes '@npcname$;
	mes "【交換確認】";
	mes "対象：^FF0000" + getitemname('@p_id) + " (+" + '@current_ref + ")^000000";
	mes "報酬：^0000FF" + getitemname('@t_id) + "^000000";
	next;

	if ('@current_ref < '@pay_ref) {
		mes '@npcname$;
		mes "精錬値が足りません。";
		mes "上位交換には ^FF0000+" + '@pay_ref + " 以上^000000 の精錬値が必要です。";
		close;
	}

	mes '@npcname$;
	mes "本当に交換しますか？";
	mes "（元の装備は消滅します）";
	next;
	if (select("交換する:やめる") == 2) {
		mes '@npcname$; mes "またの機会に。"; close;
	}

	// 3. 重量チェック 
	if (checkweight('@t_id, 1) == 0) {
		mes '@npcname$; mes "荷物が重すぎて受け取れません。"; close;
	}

	// 4. 実行処理
	unequip '@p_pos;       // 装備を外す [cite: 47]
	delitem '@p_id, 1;    // アイテム削除 [cite: 33]
	getitem '@t_id, 1;    // 報酬配布 

	misceffect 12;    // 成功エフェクト [cite: 36]
	mes '@npcname$;
	mes "交換が完了しました！";
	mes "新しい装備をご活用ください。";
	close;
}