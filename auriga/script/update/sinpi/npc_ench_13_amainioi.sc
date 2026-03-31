// 2026/03/31 メロン武器エンチャントNPC (AI実装)
// 3段階条件別エンチャント / 精錬値による選択肢変化 / 他要素維持 / 精錬値リセット 仕様通り実装
// ev_season01.gat 必要
// 関連アイテム効果実装済み
// 未実装要素：NPCのIDは仮設定 / メッセージ未調査

ev_season01.gat,19,109,4	script	甘い匂いがする男	100,{
//prontera.gat,155,105,4	script	甘い匂いがする男	100,{

set '@npcname$, "[" + strnpcinfo(1) + "]";

	// ==========================================
	// 0. メインメニュー
	// ==========================================
	mes '@npcname$;
	mes "御用は何でしょうか？";
	next;

	set '@main_menu, select("グループ1 (メロン武器):グループ2 (完熟エンチャント):グループ3 (完熟付きエンチャント):やめる");
	
	if ('@main_menu == 1) { goto L_Group1; }
	if ('@main_menu == 2) { goto L_Group2; }
	if ('@main_menu == 3) { goto L_Group3; }
	if ('@main_menu == 4) { close; }

	// ==========================================
	// グループ1：メロン武器通常エンチャント
	// ==========================================
L_Group1:
	// 対象アイテムIDリスト
	setarray '@target_items[1], 510048, 500041, 600022, 530022, 630017, 520015, 620014, 590033, 550048, 640030, 700048, 610032, 540038, 560029, 570026, 580026, 650016, 800007, 810004, 830006, 820003, 840003, 550049;
	
	// 基本候補カードID
	setarray '@ids3[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858;
	setarray '@ids2[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858;
	setarray '@ids1[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858;
	setarray '@ids0[1], 4701; // ダミー

	// デフォルト失敗率(%)
	cleararray '@fails3[1], 0, 16;
	cleararray '@fails2[1], 0, 16;
	cleararray '@fails1[1], 0, 16;
	setarray '@fails0[1], 0;
	
	set '@need_refine3, 0; set '@need_refine2, 0; set '@need_refine1, 0; set '@need_refine0, 11;

	set '@cost_id, 25655; // メロリンコイン
	set '@cost_num, 200;

	// ==========================================
	// 2. 装備・条件チェック (グループ1)
	// ==========================================
	mes '@npcname$;
	mes "グループ1：鎧のエンチャントを行います。";
	mes "精錬値に応じて最大4段階の付与が可能です。";
	next;

	set '@i, 4; // 鎧
	if (getequipisequiped('@i) == 0) { mes '@npcname$; mes "鎧を装備していません。"; close; }
	set '@itemid, getequipid('@i);
	
	set '@is_target, 0;
	set '@target_count, getarraysize('@target_items) - 1;
	for (set '@j, 1; '@j <= '@target_count; set '@j, '@j + 1) {
		if ('@itemid == '@target_items['@j]) { set '@is_target, 1; break; }
	}
	if ('@is_target == 0) { mes '@npcname$; mes "その装備は対象外のようですね。"; close; }

	// 特定エンチャント重複チェック
	if (getequipcardid('@i, 3) == 311442) {
		mes '@npcname$; mes "既に強力な魔力が宿っているようです。"; mes "これ以上のエンチャントは出来ません。"; close;
	}

	set '@current_refine, getequiprefinerycnt('@i);

	// ==========================================
	// 3-1. エンチャント選択フロー (グループ1)
	// ==========================================
	set '@step, 0; set '@fail_sum, 0;

	// --- 【1段階目】 ---
	if ('@current_refine >= 8) {
		setarray '@ids3[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 4879, 4876, 29436;
		cleararray '@fails3[1], 0, 16;
	}
	cleararray @name$[0], "", 128;
	set '@count3, getarraysize('@ids3) - 1;
	for (set '@j, 1; '@j <= '@count3; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids3['@j]); }
	set @name$['@count3 + 1], "やめる";
	mes '@npcname$; mes "【1段階目】スロット3の効果を選んでください。";
	if ('@current_refine >= 8) { mes "^0000FF※精錬値+8ボーナスリスト適用中^000000"; }
	set '@s3, select(printarray(@name$[1], ":"));
	if ('@s3 > '@count3) { close; }
	set '@ench3, '@ids3['@s3]; set '@fail_sum, '@fail_sum + '@fails3['@s3]; set '@step, 1;

	// --- 【2段階目】 ---
	if ('@current_refine < '@need_refine2) { goto L_Confirm; }
	next;
	if ('@current_refine >= 9) {
		setarray '@ids2[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 29585;
		cleararray '@fails2[1], 0, 14;
	}
	cleararray @name$[0], "", 128;
	set '@count2, getarraysize('@ids2) - 1;
	for (set '@j, 1; '@j <= '@count2; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids2['@j]); }
	set @name$['@count2 + 1], "やめる";
	mes '@npcname$; mes "【2段階目】スロット2の効果を選んでください。";
	if ('@current_refine >= 9) { mes "^0000FF※精錬値+9ボーナスリスト適用中^000000"; }
	set '@s2, select(printarray(@name$[1], ":"));
	if ('@s2 > '@count2) { goto L_Confirm; }
	set '@ench2, '@ids2['@s2]; set '@fail_sum, '@fail_sum + '@fails2['@s2]; set '@step, 2;

	// --- 【3段階目】 ---
	if ('@current_refine < '@need_refine1) { goto L_Confirm; }
	next;
	if ('@current_refine >= 10) {
		setarray '@ids1[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 310321;
		cleararray '@fails1[1], 0, 14;
	}
	cleararray @name$[0], "", 128;
	set '@count1, getarraysize('@ids1) - 1;
	for (set '@j, 1; '@j <= '@count1; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids1['@j]); }
	set @name$['@count1 + 1], "やめる";
	mes '@npcname$; mes "【3段階目】スロット1の効果を選んでください。";
	if ('@current_refine >= 10) { mes "^0000FF※精錬値+10ボーナスリスト適用中^000000"; }
	set '@s1, select(printarray(@name$[1], ":"));
	if ('@s1 > '@count1) { goto L_Confirm; }
	set '@ench1, '@ids1['@s1]; set '@fail_sum, '@fail_sum + '@fails1['@s1]; set '@step, 3;

	// --- 【4段階目】 ---
	if ('@current_refine < '@need_refine0) { goto L_Confirm; }
	next;
	cleararray @name$[0], "", 128;
	set '@count0, getarraysize('@ids0) - 1;
	for (set '@j, 1; '@j <= '@count0; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids0['@j]); }
	set @name$['@count0 + 1], "やめる";
	mes '@npcname$; mes "【4段階目】スロット0の効果を選んでください。";
	set '@s0, select(printarray(@name$[1], ":"));
	if ('@s0 > '@count0) { goto L_Confirm; }
	set '@ench0, '@ids0['@s0]; set '@fail_sum, '@fail_sum + '@fails0['@s0]; set '@step, 4;

goto L_Confirm;

	// ==========================================
	// 3-2. エンチャント選択フロー (グループ2)
	// ==========================================
L_Group2:
	// --- 1. 設定セクション ---
	setarray '@target_items[1], 510048, 500041, 600022, 530022, 630017, 520015, 620014, 590033, 550048, 640030, 700048, 610032, 540038, 560029, 570026, 580026, 650016, 800007, 810004, 830006, 820003, 840003, 550049;
	
	set '@ench3, 311442; // 固定付与ID
	set '@fail_sum, 0;    // 失敗率 0%
	set '@cost_id, 25655; // メロリンコイン

	// --- 2. 装備・条件チェック ---
	set '@i, 4; // 鎧
	if (getequipisequiped('@i) == 0) { mes '@npcname$; mes "鎧を装備していません。"; close; }
	set '@itemid, getequipid('@i);
	
	// 対象判定
	set '@is_target, 0;
	set '@target_count, getarraysize('@target_items) - 1;
	for (set '@j, 1; '@j <= '@target_count; set '@j, '@j + 1) {
		if ('@itemid == '@target_items['@j]) { set '@is_target, 1; break; }
	}
	if ('@is_target == 0) { mes '@npcname$; mes "その装備は対象外のようですね。"; close; }

	// 精錬値の取得
	set '@current_refine, getequiprefinerycnt('@i);

	// --- 3. コスト判定ロジック ---
	if ('@current_refine == 9) {
		// 精錬値9の場合：パターンA
		set '@cost_num, 10000;
	} else if ('@current_refine >= 10) {
		// 精錬値10以上の場合：パターンB
		set '@cost_num, 1;
	} else {
		// 精錬値8以下の場合：追い返す
		mes '@npcname$;
		mes "この特殊なエンチャントを施すには、";
		mes "精錬値が ^FF0000+9^000000 以上必要です。";
		close;
	}

	// 重複チェック (スロット3)
	if (getequipcardid('@i, 3) == 311442) {
		mes '@npcname$; mes "既に同じ力が宿っています。"; close;
	}

	// 段階設定
	set '@step, 1; 
	// スロット3以外の変数を念のためリセット（グループ1の残骸防止）
	set '@ench2, 0;
	set '@ench1, 0;

	mes '@npcname$;
	mes "精錬値 +" + '@current_refine + " ですね。";
	mes "特殊エンチャント「" + getitemname('@ench3) + "」を";
	mes "材料 " + '@cost_num + "個 で付与いたします。";
	
	goto L_Confirm;

	// ==========================================
	// 3-3. エンチャント選択フロー (グループ3)
	// ==========================================
L_Group3:
	// --- 1. 設定セクション ---
	setarray '@target_items[1], 510048, 500041, 600022, 530022, 630017, 520015, 620014, 590033, 550048, 640030, 700048, 610032, 540038, 560029, 570026, 580026, 650016, 800007, 810004, 830006, 820003, 840003, 550049;
	
	// 初期候補リスト（精錬値ボーナス適用前）
	setarray '@ids3[1], 311442;
	setarray '@ids2[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 4879, 4876, 29436;
	setarray '@ids1[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 29585, 310321;

	// 失敗率 0% で初期化
	cleararray '@fails3[1], 0, 1;
	cleararray '@fails2[1], 0, 20; // 拡張を見越して多めにリセット
	cleararray '@fails1[1], 0, 20;
	
	set '@need_refine3, 0; set '@need_refine2, 0; set '@need_refine1, 0; set '@need_refine0, 11;
	set '@cost_id, 25655; // メロリンコイン
	set '@cost_num, 200;

	// --- 2. 装備・条件チェック ---
	set '@i, 4; // 鎧
	if (getequipisequiped('@i) == 0) { mes '@npcname$; mes "鎧を装備していません。"; close; }
	set '@itemid, getequipid('@i);
	
	set '@is_target, 0;
	set '@target_count, getarraysize('@target_items) - 1;
	for (set '@j, 1; '@j <= '@target_count; set '@j, '@j + 1) {
		if ('@itemid == '@target_items['@j]) { set '@is_target, 1; break; }
	}
	if ('@is_target == 0) { mes '@npcname$; mes "その装備は対象外のようですね。"; close; }

	// 311442装着チェック
	if (getequipcardid('@i, 3) != 311442) {
		mes '@npcname$;
		mes "この強化を行うには、1段階目に";
		mes "「" + getitemname(311442) + "」が";
		mes "付与されている必要があります。";
		close;
	}

	set '@current_refine, getequiprefinerycnt('@i);

	// --- 3. 選択フロー ---
	set '@step, 0; set '@fail_sum, 0;

	// 【1段階目】311442 固定
	set '@ench3, 311442;
	set '@fail_sum, '@fail_sum + '@fails3[1];
	set '@step, 1;

	// 【2段階目：スロット2】
	// 精錬値9以上の場合にリストを拡張
	if ('@current_refine >= 9) {
		setarray '@ids2[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 4879, 4876, 29436, 29509, 29371, 310012;
		cleararray '@fails2[1], 0, 20;
	}
	
	next;
	cleararray @name$[0], "", 128;
	set '@count2, getarraysize('@ids2) - 1;
	for (set '@j, 1; '@j <= '@count2; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids2['@j]); }
	set @name$['@count2 + 1], "やめる";
	mes '@npcname$; mes "【2段階目】スロット2の効果を選んでください。";
	if ('@current_refine >= 9) { mes "^0000FF※精錬値+9ボーナスリスト適用中^000000"; }
	set '@s2, select(printarray(@name$[1], ":"));
	if ('@s2 > '@count2) { goto L_Confirm; }
	set '@ench2, '@ids2['@s2]; set '@fail_sum, '@fail_sum + '@fails2['@s2]; set '@step, 2;

	// 【3段階目：スロット1】
	// 精錬値10以上の場合にリストを拡張
	if ('@current_refine >= 10) {
		setarray '@ids1[1], 4706, 4736, 4746, 4716, 4726, 4756, 4853, 4854, 4855, 4856, 4857, 4858, 29585, 310321, 311284;
		cleararray '@fails1[1], 0, 20;
	}

	next;
	cleararray @name$[0], "", 128;
	set '@count1, getarraysize('@ids1) - 1;
	for (set '@j, 1; '@j <= '@count1; set '@j, '@j + 1) { set @name$['@j], getitemname('@ids1['@j]); }
	set @name$['@count1 + 1], "やめる";
	mes '@npcname$; mes "【3段階目】スロット1の効果を選んでください。";
	if ('@current_refine >= 10) { mes "^0000FF※精錬値+10ボーナスリスト適用中^000000"; }
	set '@s1, select(printarray(@name$[1], ":"));
	if ('@s1 > '@count1) { goto L_Confirm; }
	set '@ench1, '@ids1['@s1]; set '@fail_sum, '@fail_sum + '@fails1['@s1]; set '@step, 3;

	goto L_Confirm;

	// ==========================================
	// 最終確認・実行 (共通)
	// ==========================================
L_Confirm:
	next;
	set '@success_rate, 100 - '@fail_sum;
	if ('@success_rate < 0) { set '@success_rate, 0; }

	mes '@npcname$;
	mes "以下の内容でエンチャントを施します。";
	mes "--------------------------------";
	mes "対象：^FF0000" + getitemname('@itemid) + " (+" + '@current_refine + ")^000000";
	if ('@step >= 1) { mes "スロット3：^0000FF" + getitemname('@ench3) + "^000000"; }
	if ('@step >= 2) { mes "スロット2：^0000FF" + getitemname('@ench2) + "^000000"; }
	if ('@step >= 3) { mes "スロット1：^0000FF" + getitemname('@ench1) + "^000000"; }
	mes "--------------------------------";
	mes "成功率：^00FF00" + '@success_rate + " %^000000";
	mes "材料： " + getitemname('@cost_id) + " " + '@cost_num + "個";
	mes "^FF0000※失敗した場合、装備は破壊されます。^000000";
	next;

	if(select("実行する:やめる") == 2) { mes '@npcname$; mes "中止しました。"; close; }

	if (countitem('@cost_id) < '@cost_num) { mes '@npcname$; mes "材料が足りません。"; close; }
	delitem '@cost_id, '@cost_num;

	if (rand(100) < '@success_rate) {
		// 【分離処理】グループ2：特殊エンチャント（精錬リセット）
		if ('@main_menu == 2) {
			// スロット3に 0x4 フラグで書き込み。これだけで精錬値が0になりインベントリに戻る
			setequipcardid '@i, 1, '@ench1, 0x1;
			setequipcardid '@i, 2, '@ench2, 0x1;
			setequipcardid '@i, 3, '@ench3, 0x4;
			
			misceffect 102;
			mes '@npcname$;
			mes "エンチャントが完了しました！";
			mes "^FF0000力と引き換えに、精錬値が初期化され";
			mes "装備がインベントリに戻されました。^000000";
			close;
		}

		// 【分離処理】グループ1・3：通常・追加エンチャント（精錬維持）
		if ('@step >= 1) { setequipcardid '@i, 3, '@ench3, 0x1; }
		if ('@step >= 2) { setequipcardid '@i, 2, '@ench2, 0x1; }
		if ('@step >= 3) { setequipcardid '@i, 1, '@ench1, 0x1; }

		misceffect 102;
		mes '@npcname$;
		mes "エンチャントが完了しました！";
	} else {
		delequip '@i;
		misceffect 154;
		mes '@npcname$; mes "^FF0000残念ながら失敗しました。"; mes "装備は砕け散ってしまいました...^000000";
	}
	close;
}