// 2026/04/21 アップデート
// [フランツ] 成功テーブルに [加算される場合] [乗算される場合] を記述し、選べるように追記(標準は乗算)

//=====================================================================
// 精錬NPC [ホルグレン] プロンテラ
// cutin あり
//---------------------------------------------------------------------

prt_in.gat,63,60,0	script	ホルグレン#25548	85,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	// --- 稼働開始時に表示 ---
	cutin "hollgrehenn_01",2;

	mes '@npcname$;
	mes "俺は武器と防具を精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "精錬したいのかい？";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "何を精錬しろと言うんだ？";
		mes "他のアイテムの事かい？";
		close2; cutin "hollgrehenn_01",255;
		end;
	}

	// リストの末尾にキャンセル用選択肢を追加
	set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes '@npcname$;
		mes "おう、またな。";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}

	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) { // 精錬設定なし
		mes '@npcname$;
		mes "このアイテムは精錬不可能だ。";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}
	if(getequipisidentify('@i) == 0) { // 未鑑定状態
		mes '@npcname$;
		mes "これは未鑑定だから精錬できない。";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}
	
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) { // 精錬値が設定の最大値
		mes '@npcname$;
		mes "これ以上は精錬できないぞ。";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}

	// --- 武器レベル 0/1/2/3/4 設定 ---
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000; // 精錬手数料
	setarray '@itemids, 985, 1010, 1011, 984, 984;   // 精錬コスト
	setarray '@min_refs, 4, 7, 6, 5, 4; // 精錬条件

	// --- コスト設定 ---
	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	// --- シャドウ装備 コスト上書き ---
	if ('@i >= 17) {
		set '@cost_zeny, 10000;
		set '@cost_item, 1001190;
		set '@min_limit, 4;
	}

	// --- 安全圏一括精錬ロジック ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes '@npcname$;
		mes "この装備をどうするんだ？";
		mes "安全圏内は一気に精錬出来るぜ。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;
		
		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes '@npcname$;
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには"; }
				else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だ。";
				mes "精錬を続けるかい？";
				next;
				if(select("はい","いいえ") == 2) { mes '@npcname$; mes "君が嫌なら仕方がないだろう…"; close2; cutin "hollgrehenn_01",255; end; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes '@npcname$;
					mes "それが君が持ってる全部かい？";
					mes "残念だが、材料が足りないんじゃ";
					mes "仕方がないな。";
					mes "俺はただでやってやるほど";
					mes "心が広くないからな。";
					close2; 
					cutin "hollgrehenn_01",255;
					end;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				cutin "hollgrehenn_01",255;

				// 連続精錬処理
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end;
					set '@ref_count, '@ref_count - 1;
				}
				cutin "hollgrehenn_02",2;
				mes '@npcname$;
				mes "さあ出来たぞ。";
				mes "持っていくと良い。";
				close2;
				cutin "hollgrehenn_02",255;
				end;
			case 3:
				mes '@npcname$;
				mes "君が嫌なら仕方がないだろう…";
				close2;
				cutin "hollgrehenn_01",255;
				end;
		}
	}

	// 成功率テーブル定義
	switch('@wlv) {
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  60000,  50000,  20000,  20000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
	}

	mes '@npcname$;
	// メッセージ分岐
	if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
	} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }
	
	mes "^000080" + getitemname('@cost_item) + "^000000と";
	mes "手数料^000080" + '@cost_zeny + "Zeny^000000が必要だな。";
	mes "続けるかい？";
	next;

	if(select("はい","いいえ") == 2) {
		mes '@npcname$;
		mes "君が嫌なら仕方がないだろう…";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}

	if ('@rate['@current_ref] < 100000) {
		mes '@npcname$;
		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
		mes "おおっと！この" + '@type$ + "はもうたくさんの";
		mes "精錬をしてきたみたいだな…これ以上";
		mes "精錬したら" + '@type$ + "が壊れるかも";
		mes "しれないぞ。" + '@type$ + "が壊れたら";
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのかい？";
		next;
		if(select("はい","いいえ") == 2) {
			mes '@npcname$;
			mes "良い選択だな。";
			mes "俺も無理して他人の" + '@type$ + "を壊したら";
			mes "気分が悪くなるからさ…";
			close2;
			cutin "hollgrehenn_01",255;
			end;
		}
	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes '@npcname$;
		mes "それが君が持ってる全部かい？";
		mes "残念だが、材料が足りないんじゃ";
		mes "仕方がないな。";
		mes "俺はただでやってやるほど";
		mes "心が広くないからな。";
		close2;
		cutin "hollgrehenn_01",255;
		end;
	}

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		cutin "hollgrehenn_01",255;
		successrefitem '@i;
		emotion 21;
		mes '@npcname$;
		mes "カン！ カン！ カン!!";
		next;
		cutin "hollgrehenn_02",2;
		mes '@npcname$;
		mes "さあ、出来上ったよ！";
		mes "久々に良い物ができた。";
		mes "武具が強くなって君も嬉しいだろ？";
	} else {
		// 失敗
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		cutin "hollgrehenn_01",255;
		failedrefitem '@i;
		emotion 23;
		mes '@npcname$;
		mes "カン！ カン！ カン!!";
		next;
		cutin "hollgrehenn_03",2;
		mes '@npcname$;
		mes "クホホホホ…";
		next;
		mes '@npcname$;
		mes "すまん！";
		mes "精錬中に武具が壊れてしまったな…";
		mes "ほ、ほら、俺がやめろって";
		mes "最初に言っただろう？";
	}
	close2;
	cutin "hollgrehenn_02",255;
	cutin "hollgrehenn_03",255;
}

//=====================================================================
// 武具精錬NPCセリフ変化パターン1 アルベルタ・アインブロック
// callfunc "Refine1","NPC名",成功Emotion ID,失敗Emotion ID;
//--------------------------------------------------------------------
function	script	Refine1	{

	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "精錬したいのかい？";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "["+getarg(0)+"]";
		mes "何を精錬しろと言うんだ？";
		mes "他のアイテムの事かい？";
		return;
	}

	// リストの末尾にキャンセル用選択肢を追加
	set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes "["+getarg(0)+"]";
		mes "おう、またな。";
		return;
	}

	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "このアイテムは精錬不可能だ。";
		return;
	}
	if(getequipisidentify('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "これは未鑑定だから精錬できない。";
		return;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes "["+getarg(0)+"]";
		mes "これ以上は精錬できないぞ。";
		return;
	}

	// 武器レベル別設定 [cite: 18]
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 985, 1010, 1011, 984, 984;
	setarray '@min_refs, 4, 7, 6, 5, 4;

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if ('@i >= 17) { // シャドウ装備
		set '@cost_zeny, 10000;
		set '@cost_item, 1001190;
		set '@min_limit, 4;
	}

	// --- 安全圏一括精錬 ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes "["+getarg(0)+"]";
		mes "この装備をどうするんだ？";
		mes "安全圏内は一気に精錬出来るぜ。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;

		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes "["+getarg(0)+"]";
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
				} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だ。";
				mes "精錬を続けるかい？";
				next;
				if(select("はい","いいえ") == 2) { mes "["+getarg(0)+"]"; mes "君が嫌なら仕方がないだろう…"; return; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes "["+getarg(0)+"]";
					mes "それが君が持ってる全部かい？";
					mes "残念だが、材料が足りないんじゃ";
					mes "仕方がないな。";
					mes "俺はただでやってやるほど";
					mes "心が広くないからな。";
					return;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end; 
					set '@ref_count, '@ref_count - 1;
				}
				mes "["+getarg(0)+"]";
				mes "さあ出来たぞ。";
				mes "持っていくと良い。";
				return;
			case 3:
				mes "["+getarg(0)+"]";
				mes "君が嫌なら仕方がないだろう…";
				return;
		}
	}

	// 成功率テーブル定義
	switch('@wlv) {
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  60000,  50000,  20000,  20000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
	}

	mes "["+getarg(0)+"]";
	// メッセージ分岐
	if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
	} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

	mes "^000080" + getitemname('@cost_item) + "^000000と";
	mes "手数料^000080" + '@cost_zeny + "Zeny^000000が必要だな。";
	mes "続けるかい？";
	next;

	if(select("はい","いいえ") == 2) {
		mes "["+getarg(0)+"]";
		mes "君が嫌なら仕方がないだろう…";
		return;
	}

	if ('@rate['@current_ref] < 100000) {
		mes "["+getarg(0)+"]";
		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
		mes "おおっと！この" + '@type$ + "はもうたくさんの";
		mes "精錬をしてきたみたいだな…これ以上";
		mes "精錬したら" + '@type$ + "が壊れるかも";
		mes "しれないぞ。" + '@type$ + "が壊れたら";
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのかい？";
		next;
		if(select("はい","いいえ") == 2) {
			mes "["+getarg(0)+"]";
			mes "良い選択だな。";
			mes "俺も無理して他人の" + '@type$ + "を壊したら";
			mes "気分が悪くなるからさ…";
			return;
		}
	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes "["+getarg(0)+"]";
		mes "それが君が持ってる全部かい？";
		mes "残念だが、材料が足りないんじゃ";
		mes "仕方がないな。";
		mes "俺はただでやってやるほど";
		mes "心が広くないからな。";
		return;
	}

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		successrefitem '@i;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "さあ、出来上ったよ！";
		mes "久々に良い物ができた。";
		mes "武具が強くなって君も嬉しいだろ？";
	} else {
		// 失敗
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		failedrefitem '@i;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "クホホホホ…";
		next;
		mes "["+getarg(0)+"]";
		mes "すまん！";
		mes "精錬中に武具が壊れてしまったな…";
		mes "ほ、ほら、俺がやめろって";
		mes "最初に言っただろう？";
	}
	return;
}

//=====================================================================
// 武具精錬NPCセリフ変化パターン2 フェイヨン・ジュノー
// callfunc "Refine2","NPC名",成功Emotion ID,失敗Emotion ID;
//--------------------------------------------------------------------

function	script	Refine2	{

	mes "["+getarg(0)+"]";
	mes "来たか。まあとにかく";
	mes "精錬したい装備を出せ。";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "["+getarg(0)+"]";
		mes "何を精錬しろと言うんだ？";
		mes "他のアイテムの事かい？";
		return;
	}

	// リストの末尾にキャンセル用選択肢を追加
	set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes "["+getarg(0)+"]";
		mes "お前が嫌なら仕方がないだろう…";
		return;
	}

	set '@i, '@match_idx['@sel];
	if(getequipisenableref('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "これは精錬できない。";
		mes "他を当たってくれ。";
		return;
	}
	if(getequipisidentify('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "わけのわからない物を";
		mes "精錬する趣味は無い…";
		return;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes "["+getarg(0)+"]";
		mes "これ以上手を加えるところが";
		mes "無いぞ！";
		return;
	}

	// 武器レベル別設定 [cite: 18]
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 985, 1010, 1011, 984, 984;
	setarray '@min_refs, 4, 7, 6, 5, 4;

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if ('@i >= 17) { // シャドウ装備
		set '@cost_zeny, 10000;
		set '@cost_item, 1001190;
		set '@min_limit, 4;
	}

	// --- 安全圏一括精錬 ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes "["+getarg(0)+"]";
		mes "この装備をどうするんだ？";
		mes "安全圏内は一気に精錬出来るぜ。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;

		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes "["+getarg(0)+"]";
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "お前が選んだ装備を精錬するには";
				} else { mes "レベル" + '@wlv + "の武器を精錬したいのか？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だな。";

				// メッセージ分岐
				if ('@wlv == 0 || '@wlv == 1 || '@wlv == 2 || '@i >= 17) { mes "ビタ1Zeny負けられない。"; }
				else
				if ('@wlv == 3) { mes "久しぶりに俺の実力を見せてやるか。"; }
				else { mes "レベル4の武器か…興奮するぜ！"; }
				next;

				if(select("はい","いいえ") == 2) { mes "["+getarg(0)+"]"; mes "遊びじゃないんだよ！"; return; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes "["+getarg(0)+"]";
					mes "1Zenyも負けられないから";
					mes "精錬したければお金を持ってきな。";
					return;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end; 
					set '@ref_count, '@ref_count - 1;
				}
				mes "["+getarg(0)+"]";
				mes "バッチリだ！";
				mes "また来てくれ。";
				return;
			case 3:
				mes "["+getarg(0)+"]";
				mes "遊びじゃないんだよ！";
				return;
		}
	}

	// 成功率テーブル定義
	switch('@wlv) {
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  60000,  50000,  20000,  20000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
	}

	mes "["+getarg(0)+"]";
	// メッセージ分岐
	if ('@i >= 17 || '@wlv == 0) { mes "お前が選んだ装備を精錬するには";
	} else { mes "レベル" + '@wlv + "の武器を精錬したいのか？"; }

	mes "^000080" + getitemname('@cost_item) + "^000000と";
	mes "手数料^000080" + '@cost_zeny + "Zeny^000000が必要だな。";
	
	// メッセージ分岐
	if ('@wlv == 0 || '@wlv == 1 || '@wlv == 2 || '@i >= 17) { mes "ビタ1Zeny負けられない。"; }
	else
	if ('@wlv == 3) { mes "久しぶりに俺の実力を見せてやるか。"; }
	else { mes "レベル4の武器か…興奮するぜ！"; }
	next;

	if(select("はい","いいえ") == 2) {
		mes "["+getarg(0)+"]";
		mes "お前が嫌なら仕方がないだろう…";
		return;
	}

	if ('@rate['@current_ref] < 100000) {
		mes "["+getarg(0)+"]";
		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
		mes "く…どこからこんな厄介な物を";
		mes "持ってきたんだ…。";
		mes "これ以上の精錬は危険だ。";
		mes "それを承知でやるというのか？";
		next;
		if(select("はい","いいえ") == 2) {
			mes "["+getarg(0)+"]";
			mes "つまらん…";
			mes "俺は忙しい、帰ってくれ。";
			return;
		}
	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes "["+getarg(0)+"]";
		mes "1Zenyも負けられないから";
		mes "精錬したければお金を持ってきな。";
		return;
	}

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		successrefitem '@i;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "バッチリだ！";
		mes "また来てくれ。";
	} else {
		// 失敗
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		failedrefitem '@i;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "ふ…";
		next;
		mes "["+getarg(0)+"]";
		mes "残念だ…";
		mes "まあ人生こういうこともある。";
		mes "落ち込むなよ…";
	}
	return;
}

//=====================================================================
// 武具精錬NPCセリフ変化パターン3 モロク
// callfunc "Refine3","NPC名",成功Emotion ID,失敗Emotion ID;
//--------------------------------------------------------------------

function	script	Refine3	{

	mes "["+getarg(0)+"]";
	mes "私は武器と防具を精錬する鍛冶屋。";
	mes "汝が装備しているアイテムの中で";
	mes "好きなものを精錬できる。";
	mes "どの装備アイテムを";
	mes "精錬したいのか？";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "["+getarg(0)+"]";
		mes "何を精錬しろと言うのか？";
		mes "他のアイテムの事か？";
		return;
	}

	// リストの末尾にキャンセル用選択肢を追加
	set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes "["+getarg(0)+"]";
		mes "汝がやめるなら仕方がない…";
		return;
	}

	set '@i, '@match_idx['@sel];
	if(getequipisenableref('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "このアイテムは精錬不可能。";
		return;
	}
	if(getequipisidentify('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "これは未鑑定だから精錬できない。";
		return;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes "["+getarg(0)+"]";
		mes "これ以上は精錬できない。";
		return;
	}

	// 武器レベル別設定 [cite: 18]
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 985, 1010, 1011, 984, 984;
	setarray '@min_refs, 4, 7, 6, 5, 4;

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if ('@i >= 17) { // シャドウ装備
		set '@cost_zeny, 10000;
		set '@cost_item, 1001190;
		set '@min_limit, 4;
	}

	// --- 安全圏一括精錬 ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes "["+getarg(0)+"]";
		mes "この装備をどうするのか？";
		mes "安全圏内は一気に精錬出来る。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;

		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes "["+getarg(0)+"]";
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "汝が選んだ装備を精錬するには";
				} else { mes "レベル" + '@wlv + "の武器を精錬したいのか？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だ。";
				mes "続けるか？";
				next;

				if(select("はい","いいえ") == 2) { mes "["+getarg(0)+"]"; mes "汝がやめるなら仕方がない…"; return; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes "["+getarg(0)+"]";
					mes "それが汝が持ってる全部か？";
					mes "残念だが、材料が足りないならば";
					mes "仕方がない。";
					mes "私はただでやってさしあげるほど";
					mes "心が広くない。";
					return;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end; 
					set '@ref_count, '@ref_count - 1;
				}
				mes "["+getarg(0)+"]";
				mes "さあ、出来た！";
				mes "久々に良い物ができたな。";
				mes "武具が強くなって汝も嬉しかろう？";
				return;
			case 3:
				mes "["+getarg(0)+"]";
				mes "汝がやめるなら仕方がない…";
				return;
		}
	}

	// 成功率テーブル定義
	switch('@wlv) {
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  60000,  50000,  20000,  20000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
	}

	mes "["+getarg(0)+"]";
	// メッセージ分岐
	if ('@i >= 17 || '@wlv == 0) { mes "汝が選んだ装備を精錬するには";
	} else { mes "レベル" + '@wlv + "の武器を精錬したいのか？"; }

	mes "^000080" + getitemname('@cost_item) + "^000000と";
	mes "手数料^000080" + '@cost_zeny + "Zeny^000000が必要だな。";
	mes "続けるか？";
	next;

	if(select("はい","いいえ") == 2) {
		mes "["+getarg(0)+"]";
		mes "汝が嫌なら仕方がないだろう…";
		return;
	}

	if ('@rate['@current_ref] < 100000) {
		mes "["+getarg(0)+"]";
		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
		mes "ふむ…この" + '@type$ + "はもうたくさんの";
		mes "精錬をしてきたみたいだな…これ以上";
		mes "精錬したら" + '@type$ + "が壊れるかも";
		mes "しれない。" + '@type$ + "が壊れたら";
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのか？";
		next;
		if(select("はい","いいえ") == 2) {
			mes "["+getarg(0)+"]";
			mes "良い選択だ。";
			mes "私も無理して他人の武器を壊したら";
			mes "気分が悪くなるから…";
			return;
		}
	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes "["+getarg(0)+"]";
		mes "それが汝が持ってる全部か？";
		mes "残念だが、材料が足りないならば";
		mes "仕方がない。";
		mes "私はただでやってさしあげるほど";
		mes "心が広くない。";
		return;
	}

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		successrefitem '@i;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "さあ、出来た！";
		mes "久々に良い物ができたな。";
		mes "武具が強くなって汝も嬉しかろう？";
	} else {
		// 失敗
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		failedrefitem '@i;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "ふ…";
		next;
		mes "["+getarg(0)+"]";
		mes "すまない…";
		mes "精錬中に武具が壊れてしまった…";
		mes "しかし、最初に忠告はしたぞ？";
	}
	return;
}

//=====================================================================
// 濃縮系精錬 [フランツ] プロンテラ
// callfunc "Refine4","NPCName",SuccessEmotion,FalureEmotion;
//---------------------------------------------------------------------

function	script	Refine4	{

	// messize 300, 280; 2022環境互換性のため表示ウインドウ拡張 未使用

	mes "["+getarg(0)+"]";
	mes "俺は鍛冶屋だ！";
	mes "お前が装備しているアイテムを";
	mes "精錬できるってわけだ。ただし、";
	mes " ";
	mes "■武器";
	mes "<ITEM>濃縮オリデオコン<INFO>7620</INFO></ITEM>1個";
	mes " ";
	mes "■防具";
	mes "<ITEM>濃縮エルニウム<INFO>7619</INFO></ITEM>1個";
	mes " ";
	mes "■シャドウ装備";
	mes "<ITEM>濃縮シャドウダイト<INFO>1001812</INFO></ITEM>1個";
	mes " ";
	mes "と、手数料が必要だぞ。";
	next;
	switch(select("精錬を依頼する:立ち去る")) {
		case 1: break;
		case 2:
			mes "["+getarg(0)+"]";
			mes "やめるなら仕方がないな。";
			close;
	}

	mes "["+getarg(0)+"]";
	mes "それで、お前はどの装備アイテムを";
	mes "精錬したい？";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "["+getarg(0)+"]";
		mes "何を精錬しろと言うんだ？";
		mes "他のアイテムの事かい？";
		return;
	}

	// リストの末尾にキャンセル用選択肢を追加(未使用)
	// set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes "["+getarg(0)+"]";
		mes "おう、またな。";
		return;
	}

	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "ふむ、これは精錬できる";
		mes "アイテムじゃないんだぜ……";
		return;
	}
	if(getequipisidentify('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "未鑑定だから精錬できないな。";
		return;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes "["+getarg(0)+"]";
		mes "これ以上は精錬できないぞ。";
		return;
	}

	// 武器レベル別設定 [cite: 18]
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 7619, 7620, 7620, 7620, 7620;
	setarray '@min_refs, 0, 0, 0, 0, 0; // 精錬値条件 0

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if('@wlv == 0) { set '@str$, "<ITEM>濃縮エルニウム<INFO>7619</INFO></ITEM>"; }
	else { set '@str$, "<ITEM>濃縮オリデオコン<INFO>7620</INFO></ITEM>"; }


	// シャドウ装備(17-22)の場合のコストとメッセージ上書き
	if ('@i >= 17) {
		set '@cost_zeny, 10000;
		set '@cost_item, 1001812;
		set '@min_limit, 0; // 精錬値条件 0
		set '@str$, "<ITEM>濃縮シャドウダイト<INFO>1001812</INFO></ITEM>";
	}

	// --- 安全圏一括精錬('@min_refs に設定したら有効になります) ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes "["+getarg(0)+"]";
		mes "この装備をどうするんだ？";
		mes "安全圏内は一気に精錬出来るぜ。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;

		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes "["+getarg(0)+"]";
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
				} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だ。";
				mes "精錬を続けるかい？";
				next;
				if(select("はい","いいえ") == 2) { mes "["+getarg(0)+"]"; mes "君が嫌なら仕方がないだろう…"; return; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes "["+getarg(0)+"]";
					mes "これがお前が持ってるすべてか？";
					mes "残念だけど、材料が足りないと";
					mes "精錬してあげられないぜ。";
					mes "俺も仕事をした代価くらい";
					mes "貰わないとな……。";
					return;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end; 
					set '@ref_count, '@ref_count - 1;
				}
				mes "["+getarg(0)+"]";
				mes "さ！ 無事に精錬が終わったぜ。";
				mes "俺の腕はまだ使えるぜ！";
				mes "自分で言うのもなんだが、";
				mes "なかなか良い出来じゃないか！";
				return;
			case 3:
				mes "["+getarg(0)+"]";
				mes "お前がいやだったら仕方ないしな。";
				return;
		}
	}
	// --- 安全圏一括精錬ここまで ---

	// 成功率テーブル定義
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

	mes "["+getarg(0)+"]";
	mes "お前が選んだ装備を精錬するには";
	mes "" + '@str$ + "1個と";
	mes "手数料 " + '@cost_zeny + "Zenyが必要だ。";
	mes "精錬するか？";
	next;

	if(select("はい","いいえ") == 2) {
		mes "["+getarg(0)+"]";
		mes "お前がいやだったら仕方ないしな。";
		return;
	}
	// 過剰精錬前提なので不要
//	if ('@rate['@current_ref] < 100000) {
//		mes "["+getarg(0)+"]";
//		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
//		mes "あらら！";
//		mes "この" + '@type$ + "はもう";
//		mes "何回も精錬されちゃったね。";
//		mes "これ以上精錬すると";
//		mes "" + '@type$ + "が壊れちゃう";
//		mes "恐れがある……";
//		next;
//		mes "["+getarg(0)+"]";
//		mes "" + '@type$ + "が壊れちゃうと";
//		mes "二度と使えないんだぜ?!";
//		mes "中に打ち込まれたカードも特性も";
//		mes "^FF0000すべてが消えちゃう^000000んだからね。";
//		mes "^FF0000" + '@type$ + "自体が消えちゃう^000000ってわけだ。";
//		mes "それでも精錬するつもりか？";
//		next;
//		if(select("はい","いいえ") == 2) {
//			mes "["+getarg(0)+"]";
//			mes "そうだな、物は大切に扱うべきだからな。";
//			return;
//		}
//	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes "["+getarg(0)+"]";
		mes "これがお前が持ってるすべてか？";
		mes "残念だけど、材料が足りないと";
		mes "精錬してあげられないぜ。";
		mes "俺も仕事をした代価くらい";
		mes "貰わないとな……。";
		return;
	}

	// --- 共通コストロジック ---
	delitem '@cost_item, 1;
	set Zeny, Zeny - '@cost_zeny;
	showmessage "カン！カン！カン！";

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		successrefitem '@i;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "さ！ 無事に精錬が終わったぜ。";
		mes "俺の腕はまだ使えるぜ！";
		mes "自分で言うのもなんだが、";
		mes "なかなか良い出来じゃないか！";
	} else {
		// 失敗
		// messize 300, 280;	// 表示ウインドウ拡張
		failedrefitem '@i;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "ウアアアアアアアアアアッ!!!!";
		mes " ";
		mes "あ、あら……";
		mes "失敗しちゃった。ご、ごめん……";
		mes "装備が壊れちゃったな……";
		mes " ";
		mes "だ、だからさ……";
		mes "危ないって言ったじゃないか……";
		mes "俺を恨まないでくれ……";
	}
	return;
}

// ----- アルベルタ -----
alberta_in.gat,28,58,4	script	フレドリック#25545	85,{
	callfunc "Refine1","フレドリックヘルマンソン",18,4;
	close;
}
// ----- アインブロック -----
ein_in01.gat,24,87,5	script	マンダスマン#25563	826,{
	callfunc "Refine1","マンダスマン",18,4;
	close;
}

// ----- フェイヨン -----
payon.gat,144,173,5	script	アントニオ#25556	88,{
	callfunc "Refine2","アントニオ",0,32;
	close;
}
// ----- ジュノー -----
yuno_in01.gat,171,21,4	script	ディスターブ#25560	85,{
	callfunc "Refine2","ディスターブ",9,0;
	close;
}

// ----- モロク -----
morocc_in.gat,73,38,4	script	アラガム#25551	99,{
	callfunc "Refine3","アラガムサレー",30,16;
	close;
}

// ----- プロンテラ -----
prontera.gat,123,65,1	script	フランツ#26411	85,{
	callfunc "Refine4","フランツ",21,23;
	close;
}

//====================================================================
//精錬石販売NPC
//--------------------------------------------------------------------

-	script	BuyStone	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(0)+"]";
	mes "鉄や鋼鉄の武器を精錬する時に";
	mes "使える金属を売っています。";
	mes "1レベルの武器精錬に使える";
	mes "^007777プラコン^000000と";
	mes "2レベルの武器精錬に使える";
	mes "^007777エンベルタコン^000000があります。";
	next;
	mes "["+strnpcinfo(0)+"]";
	mes "プラコンは1個200Zeny、";
	mes "エンベルタコンは";
	mes "1個1000Zenyです。";
	next;
	switch (select("プラコン購入","エンベルタコン購入","他の金属はないか聞いてみる")) {
	case 1:
		set '@price,200;
		set '@itemid,1010;
		break;
	case 2:
		set '@price,1000;
		set '@itemid,1011;
		break;
	case 3:
		mes "["+strnpcinfo(0)+"]";
		mes "1レベルと2レベルの武器より";
		mes "レベルが高い武器を精錬するための";
		mes "金属ですね。";
		mes "もうご存知かもしれませんが、";
		mes "オリデオコンとエルニウムは";
		mes "手に入れるのがすごく難しくてね…";
		close;
	}
	mes "["+strnpcinfo(0)+"]";
	mes "いくつ購入しますか？";
	mes "取り引きを中止したければ";
	mes "「0」でお願いします。";
	while(1) {
		next;
		input '@num;
		if('@num<=0) {
			mes "["+strnpcinfo(0)+"]";
			mes "取引中止ですね。";
			close;
		}
		if('@num>500) {
			mes "["+strnpcinfo(0)+"]";
			mes "500個以下で決めてください。";
			continue;
		}
		break;	//while文抜ける
	}
	if(Zeny<'@price*'@num) {
		mes "["+strnpcinfo(0)+"]";
		mes "あれ？お客さん…";
		mes "お金が足りませんね。";
		mes "すみませんが、うちも商売だから";
		mes "損するわけにはいかないんですよ。";
		close;
	}
	if(checkweight('@itemid,'@num)==0) {
		mes "["+strnpcinfo(0)+"]";
		mes "荷物が多いですね。";
		mes "持ち物を整理してから";
		mes "またおこしください。";
		close;
	}
	set Zeny,Zeny-'@price*'@num;
	getitem '@itemid,'@num;
	mes "["+strnpcinfo(0)+"]";
	mes "ご購入、ありがとうございました。";
	close;
}

alberta_in.gat,13,71,4	duplicate(BuyStone)	カラマンリス	86
prt_in.gat,56,68,4	duplicate(BuyStone)	ブルウェル	86
morocc_in.gat,63,32,0	duplicate(BuyStone)	サド		99
payon.gat,145,178,4	duplicate(BuyStone)	ベグナド	88
yuno_in01.gat,171,27,4	duplicate(BuyStone)	ディルレマ	86
ein_in01.gat,15,87,4	duplicate(BuyStone)	ティルイハース	86


//====================================================================
//精錬石交換NPC
//--------------------------------------------------------------------

-	script	ChangeStone	-1,{
	if(checkitemblank()==0) {
		mes "- 所持アイテムの種類数が -";
		mes "- 多いため、アイテムを受けとる -";
		mes "- ことができません。 -";
		mes "- 所持アイテムを減らしてから -";
		mes "- 再度話しかけてください。 -";
		close;
	}
	mes "["+strnpcinfo(3)+"]";	//識別子を参照
	mes "オリデオコンやエルニウムの原石を";
	mes "僕に持ってきたら、すぐに";
	mes "オリデオコンとエルニウムにしてあげる。";
	mes "但し、原石は各5つ以上持ってくるように。";
	next;
	switch (select("オリデオコンを作る","エルニウムを作る","属性石について聞く")) {
	case 1:
		set '@itemid,756;
		set '@gain,984;
		break;
	case 2:
		set '@itemid,757;
		set '@gain,985;
		break;
	case 3:
		mes "["+strnpcinfo(3)+"]";
		mes "属性石ねえ…";
		mes "私の金属精錬人生20年で";
		mes "話はよく聞いたけど実際には";
		mes "見たことはないな。";
		mes "聞くところによると、金属が";
		mes "火、水、地、風の属性を持つらしい。";
		next;
		mes "["+strnpcinfo(3)+"]";
		mes "その属性石を武器を作る時に";
		mes "混入すれば、属性を持つ武器を";
		mes "作れるという…";
		mes "はは…そんなことができるのは";
		mes "相当な精錬職人だろうね。";
		close;
	}
	if(countitem('@itemid)<5) {
		mes "["+strnpcinfo(3)+"]";
		mes "え？冗談でしょ？";
		mes getitemname('@itemid)+ "が5つ以上無いと";
		mes getitemname('@gain)+ "が作れないと言ったじゃないか。";
		close;
	}
	mes "["+strnpcinfo(3)+"]";
	mes getitemname('@gain)+ "を作る量はどうする？";
	next;
	if(select("1個分だけ作る","作れるだけ作る")==1) {
		if(checkweight('@gain,1)==0) {
			mes "‐所持アイテムの重量が重い為";
			mes "　危険です。";
			mes "　所持アイテムを減らしてから、";
			mes "　再度話しかけてください‐";
			close;
		}
		delitem '@itemid,5;
		getitem '@gain,1;
		mes "["+strnpcinfo(3)+"]";
		mes "ほら、約束の" +getitemname('@gain)+ "だ。";
		mes "いつでもまた来てくれ。";
		close;
	}
	set '@num,countitem('@itemid)/5;
	mes "["+strnpcinfo(3)+"]";
	mes getitemname('@itemid)+ "^FF0000" +('@num*5)+ "^000000個で";
	mes getitemname('@gain)+ "^FF0000" +'@num+ "^000000個作ればいい？";
	next;
	if(select("やっぱりやめます","お願いします")==1) {
		mes "["+strnpcinfo(3)+"]";
		mes "いつでもまた来てくれ。";
		close;
	}
	if(checkweight('@gain,1)==0) {
		mes "‐所持アイテムの重量が重い為";
		mes "　危険です。";
		mes "　所持アイテムを減らしてから、";
		mes "　再度話しかけてください‐";
		close;
	}
	delitem '@itemid,'@num*5;
	getitem '@gain,'@num;
	mes "["+strnpcinfo(3)+"]";
	mes "ほら、約束の" +getitemname('@gain)+ "だ。";
	mes "いつでもまた来てくれ。";
	close;
}

alberta_in.gat,21,63,5	duplicate(ChangeStone)	ゼノフォン::ゼノフォン ゾロタス	84
prt_in.gat,63,69,4	duplicate(ChangeStone)	ディートリヒ		84
morocc_in.gat,72,32,0	duplicate(ChangeStone)	アブドゥル		99
payon.gat,137,178,5	duplicate(ChangeStone)	ハキム			88
yuno_in01.gat,164,27,4	duplicate(ChangeStone)	ティルレイ		84
ein_in01.gat,18,82,5	duplicate(ChangeStone)	マティシュタイン	84


//====================================================================
//武具修理NPC
//--------------------------------------------------------------------

-	script	Repairer	-1,{
	mes "[修理工]";
	mes "そこの旅人、";
	mes "修理したいアイテムはあるか？";
	mes "アイテムの修理は俺に任せてくれ！";
	next;
	if(select("実は修理して欲しいアイテムが……","今は特に無いです")==2) {
		mes "[修理工]";
		mes "ふむ……";
		mes "なら俺に用は無いな。";
		close;
	}
	set '@num,getrepairableitemcount();
	if('@num==0) {
		mes "[修理工]";
		mes "おいおい……";
		mes "修理する必要のあるものなんて";
		mes "一つも持っていないじゃないか。";
		mes "はぁ……";
		mes "お前のようなヤツが増えると";
		mes "俺の商売もあがったりだよ……";
		close;
	}
	set '@price,'@num*5000;
	mes "[修理工]";
	mes "ふむ……";
	mes "お前が持っているアイテムで";
	mes "損傷しているアイテムは";
	mes '@num+ "だな。";
	next;
	mes "[修理工]";
	mes "一つ修理するのに 5000 Zenyだから";
	mes "全て直すと" +'@price+ "Zenyとなる。";
	mes "修理するか？";
	next;
	if(select("お願いします","いいえ")==2) {
		mes "[修理工]";
		mes "俺は、アイテムが傷ついたまま";
		mes "放って置かれるのが";
		mes "たまらなく嫌いなんだ。";
		mes "損傷したアイテムはすぐ直そうぜ。";
		close;
	}
	if(Zeny<'@price) {
		mes "[修理工]";
		mes "お金が足りないようだ";
		close;
	}
	set Zeny,Zeny-'@price;
	repairitem;
	mes "[修理工]";
	mes "OK！";
	mes "直ったな。";
	mes "アイテムにも寿命があるってことを";
	mes "覚えておくんだな。";
	close;
}

alberta_in.gat,31,65,4	duplicate(Repairer)	修理工	86
aldeba_in.gat,38,60,2	duplicate(Repairer)	修理工	86
geffen_in.gat,34,166,2	duplicate(Repairer)	修理工	86
//jor_mbase.gat,312,72,2	duplicate(Repairer)	修理工	10567 // EP21
//jor_mbase.gat,309,75,2	duplicate(Repairer)	修理工	10568 // EP21
//jor_mbase.gat,300,60,2	duplicate(Repairer)	修理工	88 // EP21
lhz_in01.gat,217,121,2	duplicate(Repairer)	修理工	851
moc_ruins.gat,107,94,4	duplicate(Repairer)	修理工	99
morocc_in.gat,68,31,4	duplicate(Repairer)	修理工	99
payon.gat,143,165,7	duplicate(Repairer)	修理工	88
payon_01_q.gat,88,29,7	duplicate(Repairer)	修理工	88
prt_in.gat,63,54,2	duplicate(Repairer)	修理工	86
//ygg_edge.gat,202,204,2	duplicate(Repairer)	修理工	86 // Chapter1：世界樹の詩 ～序曲
yuno_in01.gat,175,28,2	duplicate(Repairer)	修理工	86

//=====================================================================
//鍛冶職人NPC
//  callfunc "BlackSmith","NPCName",SuccessEmotion,FalureEmotion;
//--------------------------------------------------------------------

function	script	BlackSmith	{
	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ。";
	mes "今日はどうしたんだ？";
	next;
	switch(select("精錬する","精錬用品を買う","アイテムを修理する","話をやめる")) {
	case 1:
		break;
	case 2:
		if(checkitemblank()==0) {
			mes "- 所持アイテムの種類数が -";
			mes "- 多いため、アイテムを受けとる -";
			mes "- ことができません。 -";
			mes "- 所持アイテムを減らしてから -";
			mes "- 再度話しかけてください。 -";
			return;
		}
		mes "["+getarg(0)+"]";
		mes "鉄や鋼鉄の武器を精錬する時に";
		mes "使える金属が必要か？";
		mes "1レベルの武器精錬に使える";
		mes "^007777プラコン^000000 と";
		mes "2レベルの武器精錬に使える";
		mes "^007777エンベルタコン^000000 があるぞ。";
		next;
		mes "["+getarg(0)+"]";
		mes "プラコンは1個200Zeny、";
		mes "エンベルタコンは";
		mes "1個1000Zenyだ。";
		next;
		switch(select("プラコン購入","エンベルタコン購入","他の金属はないか聞いてみる")) {
		case 1:
			set '@price,200;
			set '@itemid,1010;
			break;
		case 2:
			set '@price,1000;
			set '@itemid,1011;
			break;
		case 3:
			mes "["+getarg(0)+"]";
			mes "1レベルと2レベルの武器より";
			mes "レベルが高い武器を精錬するための";
			mes "金属だな。";
			mes "もう知っているかもしれないが､ ";
			mes "オリデオコンとエルニウムは";
			mes "手に入れるのがすごく難しくてな…。";
			return;
		}
		mes "["+getarg(0)+"]";
		mes "いくつ購入するんだ？";
		mes "取り引きを中止したければ";
		mes "「0」で頼む。";
		while(1) {
			next;
			input '@num;
			if('@num<=0) {
				mes "["+getarg(0)+"]";
				mes "取引中止だな。";
				return;
			}
			if('@num>500) {
				mes "["+getarg(0)+"]";
				mes "500個以下で決めてくれ。";
				continue;
			}
			break;	//while文抜ける
		}
		if(Zeny<'@price*'@num) {
			mes "["+getarg(0)+"]";
			mes "あれ？　お客さん……";
			mes "お金が足りないね。";
			mes "すまないが、うちも商売だから";
			mes "損するわけにはいかないんだよ。";
			return;
		}
		if(checkweight('@itemid,'@num)==0) {
			mes "["+getarg(0)+"]";
			mes "荷物が多いな。";
			mes "持ち物を整理してから";
			mes "また来てもらえるか？。";
			return;
		}
		set Zeny,Zeny-'@price*'@num;
		getitem '@itemid,'@num;
		mes "["+getarg(0)+"]";
		mes "確かに受け取ったぜ。";
		mes "また来てくれよな。";
		return;
	case 3:
		set '@num,getrepairableitemcount();
		if('@num==0) {
			mes "["+getarg(0)+"]";
			mes "おいおい……";
			mes "修理する必要のあるものなんて";
			mes "一つも持っていないじゃないか。";
			mes "はぁ……";
			mes "お前のようなヤツが増えると";
			mes "俺の商売もあがったりだよ……";
			return;
		}
		set '@price,'@num*5000;
		mes "["+getarg(0)+"]";
		mes "ふむ……";
		mes "お前が持っているアイテムで";
		mes "損傷しているアイテムは";
		mes '@num+ "だな。";
		next;
		mes "["+getarg(0)+"]";
		mes "一つ修理するのに 5000 Zenyだから";
		mes "全て直すと" +'@price+ "Zenyとなる。";
		mes "修理するか？";
		next;
		if(select("お願いします","いいえ")==2) {
			mes "["+getarg(0)+"]";
			mes "俺は、アイテムが傷ついたまま";
			mes "放って置かれるのが";
			mes "たまらなく嫌いなんだ。";
			mes "損傷したアイテムはすぐ直そうぜ。";
			return;
		}
		if(Zeny<'@price) {
			mes "["+getarg(0)+"]";
			mes "お金が足りないようだ";
			return;
		}
		set Zeny,Zeny-'@price;
		repairitem;
		mes "["+getarg(0)+"]";
		mes "OK！";
		mes "直ったな。";
		mes "アイテムにも寿命があるってことを";
		mes "覚えておくんだな。";
		return;
	case 4:
		mes "["+getarg(0)+"]";
		mes "そうかい。残念だな。";
		mes "いつでも来てくれよな。";
		return;
	}
	// 以下武具精練
	mes "["+getarg(0)+"]";
	mes "俺は武器と防具を精錬する鍛冶屋だ。";
	mes "君が装備しているアイテムの中で";
	mes "好きなものを精錬できるのだ。";
	mes "どの装備アイテムを";
	mes "精錬したいのかい？";
	next;

	// 1. 装備スキャン
	set '@menu_str$, "";
	set '@match_count, 0;
	cleararray '@match_idx[0], 0, 128;
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
		mes "["+getarg(0)+"]";
		mes "何を精錬しろと言うんだ？";
		mes "他のアイテムの事かい？";
		return;
	}

	// リストの末尾にキャンセル用選択肢を追加
	set '@menu_str$, '@menu_str$ + "やっぱりやめる";

	// 2. 装備選択
	set '@sel, select('@menu_str$);

	// 「やっぱりやめる」が選択された場合
	if ('@sel > '@match_count) {
		mes "["+getarg(0)+"]";
		mes "また来るんだな。";
		return;
	}

	set '@i, '@match_idx['@sel];

	if(getequipisenableref('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "このアイテムは精錬不可能だ。";
		return;
	}
	if(getequipisidentify('@i) == 0) {
		mes "["+getarg(0)+"]";
		mes "これは未鑑定だから精錬できない。";
		return;
	}
	set '@current_ref, getequiprefinerycnt('@i);
	if('@current_ref >= 10) {
		mes "["+getarg(0)+"]";
		mes "これ以上は精錬できないぞ。";
		return;
	}

	// 武器レベル別設定 [cite: 18]
	set '@wlv, getequipweaponlv('@i);
	setarray '@prices,  5000, 100, 500, 5000, 10000;
	setarray '@itemids, 985, 1010, 1011, 984, 984;
	setarray '@min_refs, 4, 7, 6, 5, 4;

	set '@cost_zeny, '@prices['@wlv];
	set '@cost_item, '@itemids['@wlv];
	set '@min_limit, '@min_refs['@wlv];

	if ('@i >= 17) { // シャドウ装備
		set '@cost_zeny, 10000;
		set '@cost_item, 1001190;
		set '@min_limit, 4;
	}

	// --- 安全圏一括精錬 ---
	if ('@current_ref < '@min_limit) {
		set '@ref_count, ('@min_limit - '@current_ref);
		mes "["+getarg(0)+"]";
		mes "この装備をどうするんだ？";
		mes "安全圏内は一気に精錬出来るぜ。";
		mes "一気に精錬するなら";
		mes "安全圏分の素材とZenyが必要だ。";
		next;

		switch(select("精錬する","一気に精錬する","やめる")) {
			case 1: break;
			case 2:
				mes "["+getarg(0)+"]";
				// メッセージ分岐
				if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
				} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

				mes "^000080" + getitemname('@cost_item) + " " + '@ref_count + "個^000000 と";
				mes "手数料^000080" + ('@cost_zeny * '@ref_count) + "Zeny^000000が必要だ。";
				mes "精錬を続けるかい？";
				next;
				if(select("はい","いいえ") == 2) { mes "["+getarg(0)+"]"; mes "君が嫌なら仕方がないだろう…"; return; }
				
				if(countitem('@cost_item) < '@ref_count || Zeny < ('@cost_zeny * '@ref_count)) {
					mes "["+getarg(0)+"]";
					mes "それが君が持ってる全部かい？";
					mes "残念だが、材料が足りないんじゃ";
					mes "仕方がないな。";
					mes "俺はただでやってやるほど";
					mes "心が広くないからな。";
					return;
				}

				delitem '@cost_item, '@ref_count;
				set Zeny, Zeny - ('@cost_zeny * '@ref_count);
				while('@ref_count > 0) {
					successrefitem '@i;
					if (sleep2(1) == 0) end; 
					set '@ref_count, '@ref_count - 1;
				}
				mes "["+getarg(0)+"]";
				mes "さあ出来たぞ。";
				mes "持っていくと良い。";
				return;
			case 3:
				mes "["+getarg(0)+"]";
				mes "また来るんだな。";
				return;
		}
	}

	// 成功率テーブル定義
	switch('@wlv) {
		case 0: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
		case 1: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  20000; break;
		case 2: setarray '@rate, 100000, 100000, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000; break;
		case 3: setarray '@rate, 100000, 100000, 100000, 100000, 100000,  60000,  50000,  20000,  20000,  20000; break;
		case 4: setarray '@rate, 100000, 100000, 100000, 100000,  60000,  40000,  40000,  20000,  20000,  10000; break;
	}

	mes "["+getarg(0)+"]";
	// メッセージ分岐
	if ('@i >= 17 || '@wlv == 0) { mes "君が選んだ装備を精錬するには";
	} else { mes "レベル" + '@wlv + "の武器を精錬したいのかい？"; }

	mes "^000080" + getitemname('@cost_item) + "^000000と";
	mes "手数料^000080" + '@cost_zeny + "Zeny^000000が必要だな。";
	mes "続けるかい？";
	next;

	if(select("はい","いいえ") == 2) {
		mes "["+getarg(0)+"]";
		mes "また来るんだな。";
		return;
	}

	if ('@rate['@current_ref] < 100000) {
		mes "["+getarg(0)+"]";
		if('@wlv == 0 || '@i >= 17) { set '@type$, "防具"; } else { set '@type$, "武器"; }
		mes "おおっと！この" + '@type$ + "はもうたくさんの";
		mes "精錬をしてきたみたいだな…これ以上";
		mes "精錬したら" + '@type$ + "が壊れるかも";
		mes "しれないぞ。" + '@type$ + "が壊れたら";
		mes "2度と使えなくなる…それでも";
		mes "精錬をする気なのかい？";
		next;
		if(select("はい","いいえ") == 2) {
			mes "["+getarg(0)+"]";
			mes "良い選択だな。";
			mes "俺も無理して他人の" + '@type$ + "を壊したら";
			mes "気分が悪くなるからさ…";
			return;
		}
	}

	if(countitem('@cost_item) < 1 || Zeny < '@cost_zeny) {
		mes "["+getarg(0)+"]";
		mes "それが君が持ってる全部かい？";
		mes "残念だが、材料が足りないんじゃ";
		mes "仕方がないな。";
		mes "俺はただでやってやるほど";
		mes "心が広くないからな。";
		return;
	}

	// --- 精錬実行ロジック ---
	if ('@rate['@current_ref] > rand(100000)) {
		// 成功
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		successrefitem '@i;
		emotion getarg(1);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "さあ、出来上ったよ！";
		mes "久々に良い物ができた。";
		mes "武具が強くなって君も嬉しいだろ？";
	} else {
		// 失敗
		delitem '@cost_item, 1;
		set Zeny, Zeny - '@cost_zeny;
		failedrefitem '@i;
		emotion getarg(2);
		mes "["+getarg(0)+"]";
		mes "カン！ カン！ カン!!";
		next;
		mes "["+getarg(0)+"]";
		mes "クホホホホ…";
		next;
		mes "["+getarg(0)+"]";
		mes "すまん！";
		mes "精錬中に武具が壊れてしまったな…";
		mes "ほ、ほら、俺がやめろって";
		mes "最初に言っただろう？";
	}
	return;
}

//lasagna.gat,289,287,4	script	鍛冶職人#32222	561,{// npc_town_lasagna.sc 定義済み
//	callfunc "BlackSmith","鍛冶職人",21,23;
//	close;
//}

ama_in01.gat,165,184,5	script	鍛冶職人#30991	588,{
	callfunc "BlackSmith","鍛冶職人",21,23;
	close;
}

lby_in.gat,62,86,4	script	鍛冶職人#31647	561,{
	callfunc "BlackSmith","鍛冶職人",21,23;
	close;
}

poring_ad.gat,21,17,4	script	鍛冶職人#33630	561,{
	callfunc "BlackSmith","鍛冶職人",21,23;
	close;
}

yuno.gat,228,343,4	script	鍛冶職人#33917	561,{
	callfunc "BlackSmith","鍛冶職人",21,23;
	close;
}