// 2026/04/07 ロックリッジコイン抽選NPC (AI実装)
// 未実装要素：メッセージ未調査 / 最大試行回数制限 / インベントリ最大種類 / 出現率

harboro1.gat,275,206,4	script	ハワード	899,{

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