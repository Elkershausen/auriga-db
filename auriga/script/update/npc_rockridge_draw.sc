// 2026/04/14 アップデート
// ロックリッジコイン抽選NPC[ハワード] / ロックリッジエンチャントNPC[目覚めの息吹] 実装
// 未実装要素：メッセージ未調査 / 最大試行回数制限 / インベントリ最大種類 / 出現率

harboro1.gat,275,206,4	script	ハワード#31954	899,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	set '@cost_id, 25250; // ロックリッジコイン
	set '@cost_num, 10;   // 10個で1回抽選
	set '@maxdraw_limit, 50; // 1回の最大試行制限数

	// 1. 所持重量50%制限チェック
	if((Weight * 100 / MaxWeight) > 50) {
		mes '@npcname$;
		//mes "最大所持重量 : " + (MaxWeight / 10);
		//mes "今の所持重量 : " + (Weight / 10);
		//mes "重量使用% : " + (Weight * 100 / MaxWeight) + "% ";
		//mes "---------------------------";
		mes "所持重量が50％を超えています。";
		mes "荷物を預けて来て下さい。";
		close;
	}

	// 2. インベントリ空き種類数チェック (getinventorylistを使用)
	getinventorylist;
	// @inventorylist_count は現在の所持種類数。空きが80必要 = 100 - 80 = 20種類以下であること
	if (@inventorylist_count > 20) {
		mes '@npcname$;
		mes "現在、インベントリを ^FF0000" + @inventorylist_count + "種類^000000 使用しています。";
		mes "抽選にはインベントリの空きが ^0000FF80種類以上^000000 必要です。";
		mes "（所持種類数を20種類以下にして下さい）";
		close;
	}

	// 最大抽選可能回数の計算（所持数ベース）
	set '@maxdraw_ct, (countitem('@cost_id) / '@cost_num);
	if ('@maxdraw_ct > '@maxdraw_limit) set '@maxdraw_ct, '@maxdraw_limit;

	mes '@npcname$;
	mes "ロックリッジコイン10個で1回抽選に参加できます。";
	mes "一度に最大 ^FF0000" + '@maxdraw_limit + "回^000000 まで抽選可能です。";
	mes "現在は ^0000FF" + '@maxdraw_ct + "回^000000 分のコインをお持ちです。";
	next;

	switch(select("抽選に参加する:やめる")) {
		case 1:
			if('@maxdraw_ct < 1) {
				mes '@npcname$;
				mes "ロックリッジコインが足りません。";
				close;
			}
			
			mes '@npcname$;
			mes "抽選回数を入力して下さい。";
			mes "(最大 " + '@maxdraw_ct + " 回)";
			next;
			input '@draw_count;

			// 入力値のバリデーションと50回制限の適用
			if('@draw_count <= 0) {
				mes '@npcname$; mes "キャンセルされました。"; close;
			}
			if('@draw_count > '@maxdraw_ct) {
				set '@draw_count, '@maxdraw_ct;
				mes "※一度の限界数である " + '@draw_count + " 回として受け付けました。";
				next;
			}

			// 出現アイテムと確率（合計150）の設定
			setarray '@pay_items[1], 18163, 28615, 28127, 13340, 26204, 1948, 28738, 20901, 20900, 20899, 15241, 15242, 15243, 15244, 15245, 28554, 28555, 25434, 25435, 25436, 25437, 25438, 25439, 25440, 720, 719, 721, 727, 726, 725, 732, 728, 723, 969, 7228, 7229, 7444, 729;
			setarray '@pay_rate[1],  3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20;

			goto L_Exchange_Main;

		case 2:
			mes '@npcname$; mes "またの機会に。"; close;
	}

L_Exchange_Main:
	set '@success_ct, 0;

	for(set '@i, 0; '@i < '@draw_count; set '@i, '@i + 1) {
		
		delitem '@cost_id, '@cost_num;

		set '@random, rand(1, 150);
		set '@current_sum, 0;
		set '@get_id, 0;

		for(set '@j, 1; '@j < getarraysize('@pay_rate); set '@j, '@j + 1) {
			set '@current_sum, '@current_sum + '@pay_rate['@j];
			if('@random <= '@current_sum) {
				set '@get_id, '@pay_items['@j];
				break;
			}
		}

		if('@get_id > 0) {
			getitem '@get_id, 1;
			set '@success_ct, '@success_ct + 1;
		}

		// 重量90%超過チェック
		if((Weight * 100 / MaxWeight) > 90) {
			mes '@npcname$;
			mes "所持重量が90%を超えたため、";
			mes "抽選を途中で終了しました。";
			mes "実行回数: " + '@success_ct + " / " + '@draw_count + " ";
			close;
		}
	}

	misceffect 12; // 修正: specialeffect2 -> misceffect
	mes '@npcname$;
	mes "合計 " + '@success_ct + " 回の抽選が完了しました。";
	close;
}

harboro1.gat,275,199,4	script	目覚めの息吹#31989	10217,{

	set '@admin, 0; // 管理用モード (0オフ / 1オン)

	set '@npcname$, "[" + strnpcinfo(1) + "]";
	set '@cost_id, 25250;
	set '@cost_num, 5;

	mes '@npcname$;
	mes "よく来た異邦人。";
	mes "私の力が必要か？";
	next;

	switch(select("エンチャントする:説明をする:対象アイテムを聞く:やっぱりやめる")) {
		case 1: break;
		case 2:
			mes '@npcname$;
			mes "" + getitemname('@cost_id) + " を " + '@cost_num + "個使い";
			mes "対象のスロットを1つ選びます。";
			mes "エンチャントはランダムで決定されます。";
			mes "100％成功し、精錬値も維持されます。";
			close;
		case 3:
			mes '@npcname$;
			mes "対象アイテムは";
			mes "ロックリッジコインで交換した";
			mes "装備品になります。";
			close;
		case 4:
			mes '@npcname$;
			mes "また来てくれ。";
			close;
	}

	setarray '@target_ids[1], 18163, 28615, 28127, 13340, 26204, 1948, 28738, 20901, 20900, 20899, 15241, 15242, 15243, 15244, 15245, 28554, 28555;
	setarray '@target_pos[1], 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 2, 2, 2, 2, 2, 7, 7;

	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;

	for(set '@i, 1; '@i <= 10; set '@i, '@i + 1) {
		if (getequipisequiped('@i)) {
			set '@temp_id, getequipid('@i);
			for(set '@j, 1; '@j <= 17; set '@j, '@j + 1) {
				if ('@temp_id == '@target_ids['@j]) {
					set '@match_count, '@match_count + 1;
					set '@match_idx['@match_count], '@i;
					set '@menu_str$, '@menu_str$ + getequipname('@i) + ":";
					break;
				}
			}
		}
	}

	if ('@match_count == 0) { mes '@npcname$; mes "対象装備を身に着けていないようだ。"; close; }

	mes '@npcname$;
	mes "どれにエンチャントを施しますか？";
	next;
	set '@sel, select('@menu_str$);
	set '@i, '@match_idx['@sel];
	set '@current_id, getequipid('@i);

	if (countitem('@cost_id) < '@cost_num) { mes '@npcname$; mes "材料が足りないようだ。"; close; }

	// 部位グループの特定
	for(set '@j, 1; '@j <= 17; set '@j, '@j + 1) {
		if ('@current_id == '@target_ids['@j]) { set '@pos_grp, '@target_pos['@j]; break; }
	}

	// 抽選用乱数
	set '@r, rand(100);

	// --- 部位グループ別・スロット選択 switch ---
	mes '@npcname$;
	mes "強化するスロットを選択するがいい。";
	next;

	if ('@pos_grp == 4) { // 武器
		switch(select("第4スロット:やめる")) {
			case 1:
				set '@slot, 3;
				if ('@r < 1) { setarray '@en[0], 29368, 29368; }
				else if ('@r < 10) { setarray '@en[0], 29367, 4810, 4817, 29136, 4814, 4833, 4872; }
				else if ('@r < 50) { setarray '@en[0], 29366, 4811, 4818, 29135, 4815, 4832, 4869; }
				else { setarray '@en[0], 4704, 4705, 4706, 4734, 4735, 4736, 4744, 4745, 4746, 4714, 4715, 4716, 4724, 4725, 4726, 4754, 4755, 4756; }
				break;
			case 2: mes '@npcname$; mes "中断します。"; close;
		}
	}
	else if ('@pos_grp == 5) { // 鎧
		switch(select("第4スロット:第3スロット:やめる")) {
			case 1: // 第4
				set '@slot, 3;
				if ('@r < 1) { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869; }
				else if ('@r < 10) { setarray '@en[0], 4702, 4732, 4742, 4712, 4722, 4752; }
				else if ('@r < 50) { setarray '@en[0], 4701, 4731, 4741, 4711, 4721, 4751; }
				else { setarray '@en[0], 4700, 4730, 4740, 4710, 4720, 4750; }
				break;
			case 2: // 第3
				set '@slot, 2;
				if ('@r < 25) { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869; }
				else if ('@r < 50) { setarray '@en[0], 29214, 29215, 29216, 29217, 29218, 29219, 29220, 29221, 29222; }
				else if ('@r < 75) { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869; }
				else { setarray '@en[0], 29214, 29215, 29216, 29217, 29218, 29219, 29220, 29221, 29222; }
				break;
			case 3: mes '@npcname$; mes "中断します。"; close;
		}
	}
	else if ('@pos_grp == 2) { // 肩
		switch(select("第4スロット:第3スロット:やめる")) {
			case 1: // 第4
				set '@slot, 3;
				if ('@r < 1) { setarray '@en[0], 4810, 4817, 29136, 4814, 4833; }
				else if ('@r < 10) { setarray '@en[0], 4702, 4732, 4742, 4712, 4722, 4752; }
				else if ('@r < 50) { setarray '@en[0], 4701, 4731, 4741, 4711, 4721, 4751; }
				else { setarray '@en[0], 4700, 4730, 4740, 4710, 4720, 4750; }
				break;
			case 2: // 第3
				set '@slot, 2;
				if ('@r < 50) { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869; }
				else { setarray '@en[0], 29214, 29215, 29216, 29217, 29218, 29219, 29220, 29221, 29222; }
				break;
			case 3: mes '@npcname$; mes "中断します。"; close;
		}
	}
	else if ('@pos_grp == 7) { // アクセサリー
		switch(select("第4スロット:第3スロット:やめる")) {
			case 1: // 第4
				set '@slot, 3;
				if ('@r < 50) { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869, 4805; }
				else { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869, 4805; }
				break;
			case 2: // 第3
				set '@slot, 2;
				if ('@r < 25) { setarray '@en[0], 4810, 4817, 29136, 4814, 4833, 4872, 4850; }
				else { setarray '@en[0], 4811, 4818, 29135, 4815, 4832, 4869, 4805; }
				break;
			case 3: mes '@npcname$; mes "中断します。"; close;
		}
	}

	// 抽選実行
	set '@final_ench, '@en[rand(getarraysize('@en))];

	// 最終確認
	// 管理用モード
	if('@admin == 1) {
	mes '@npcname$;
	mes "結果: ^FF0000" + getitemname('@final_ench) + "^000000";
	mes "よろしいですか？";
	next;
	if (select("付与する:やめる") == 2) close;
	}

	delitem '@cost_id, '@cost_num;
	setequipcardid '@i, '@slot, '@final_ench, 0x1;

	misceffect 102;
	mes '@npcname$;
	mes "エンチャントが完了しました。";
	close;
}