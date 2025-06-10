//2025/06/10 アップデート
//map :4th_lib.gat 追加

aldebaran.gat,148,96,4	script	天体図書館司書	897,{

	mes "["+strnpcinfo(1)+"]";
	mes "天体図書館に";
	mes "移動しますか？";
	next;	/* 4th_lib */
	switch(select(
		"やめる",
		"移動する")) {
		case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
		case 2: warp "4th_lib",32,57; break;	}
	end;
}

4th_lib.gat,28,57,0		warp	4th_libt001	1,1,aldebaran.gat,148,100

//アイテム交換
4th_lib.gat,35,47,4	script	ララ	73,{
	setarray '@main,1000372,1002223;
	//if(countitem('@main[0])	< 100) {	mes ""+getitemname('@main[0])+" が100個以上必要です";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@main[0])+" 100個で";
	mes ""+getitemname('@main[1])+"";
	mes "1個と交換します。";
	mes "いくつ交換しますか？";
	mes "交換しない場合は0を";
	mes "入力して下さい。";
	next;
	input '@count;
	if('@count < 1) {	mes "["+strnpcinfo(1)+"]";	mes "取引を中止します";		close;	}
	if('@count > 300) {	mes "["+strnpcinfo(1)+"]";	mes "多すぎです。";		close;	}
	if(('@count * 100) > countitem('@main[0])) {	mes "["+strnpcinfo(1)+"]";	mes ""+getitemname('@main[0])+" が足りません。";		close;	}

	delitem '@main[0],'@count * 100;
	getitem '@main[1],'@count;
	mes "["+strnpcinfo(1)+"]";
	mes "交換しました。";
	close;
}

//ステータス・スキルリセット
4th_lib.gat,45,48,3	script	リーシェ	72,{
	if(BaseLevel < 200)		{	mes "["+strnpcinfo(1)+"]";	mes "レベル200以上の4次職・拡張4次職専用です";	close;	}
	if(countitem(1002220) < 1)	{	mes "["+strnpcinfo(1)+"]";	mes ""+getitemname(1002220)+" を所持している";	mes "冒険者専用です。";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002220)+" を所持している";
	mes "4次職・拡張4次職の冒険者に";
	mes "無料でステータス・スキルの";
	mes "リセットサービスを行っています。";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002220)+" は消耗せず";
	mes "何度でも利用できます。";
	mes "リセットしますか？";
	next;
	switch(select("ステータスリセット","スキルリセット","やっぱりやめる")) {
	case 1:
		resetstatus;
		mes "["+strnpcinfo(1)+"]";
		mes "ステータスリセット完了しました。";
		mes "またご利用下さい。";
 		close;
	case 2:
		resetskill;
		mes "["+strnpcinfo(1)+"]";
		mes "スキルリセット完了しました。";
		mes "またご利用下さい。";
		close;
	case 3:
		mes "["+strnpcinfo(1)+"]";
		mes "またのご利用";
		mes "お待ちしています。";
		close;
	}
}

//特別な精錬
4th_lib.gat,48,66,4	script	アストロ	893,{}

//セレスティアエンチャント
4th_lib.gat,34,67,3	script	セレス	803,{
	/* 共通条件設定 */
	setarray '@main,	610081,	620052,	630056,	640063,	700115,	810047,	500115,	510181,	530070,	540103,	550172,	550173,	560076,	570082,	580082,	590097,	400907,	450462,	450463,	480592,	470351,	490745,	490746;	//エンチャントをつけるアイテム
	setarray '@Lefthand,	0,	0,	0,	0,	0,	0,	500115,	510181,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	//短剣 片手剣 片手斧の左手装備制限
	
	set '@costAid,1002223;				//必要なアイテム 1002223 セレスティアルシリーズエンチャントメダル
	set '@costAnum,1;				//必要なアイテムの数 1
	set '@refA,0;					//'@slotAの精錬値条件(未使用)
	set '@refB,0;					//'@slotBの精錬値条件(未使用)
	set '@refC,0;					//'@slotCの精錬値条件(未使用)
	set '@refD,99;					//'@slotDの精錬値条件(第2エンチャのみ)
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}	//先頭に共通条件を挟み全体を簡素化する
	/* 共通条件設定ここまで */

	/* スクリプト開始 */
	mes "["+strnpcinfo(1)+"]";
	mes "セレスティアシリーズの";
	mes "エンチャントをします。";
	mes "エンチャントする装備を";
	mes "選んで下さい。";
	next;
	switch(select(
		"やめる",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]",
		""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]",
		""+getitemname('@main[10])+"["+getiteminfo('@main[10],10)+"]",
		""+getitemname('@main[11])+"["+getiteminfo('@main[11],10)+"]",
		""+getitemname('@main[12])+"["+getiteminfo('@main[12],10)+"]",
		""+getitemname('@main[13])+"["+getiteminfo('@main[13],10)+"]",
		""+getitemname('@main[14])+"["+getiteminfo('@main[14],10)+"]",
		""+getitemname('@main[15])+"["+getiteminfo('@main[15],10)+"]",
		""+getitemname('@main[16])+"["+getiteminfo('@main[16],10)+"]",
		""+getitemname('@main[17])+"["+getiteminfo('@main[17],10)+"]",
		""+getitemname('@main[18])+"["+getiteminfo('@main[18],10)+"]",
		""+getitemname('@main[19])+"["+getiteminfo('@main[19],10)+"]",
		""+getitemname('@main[20])+"["+getiteminfo('@main[20],10)+"]",
		""+getitemname('@main[21])+"["+getiteminfo('@main[21],10)+"]",
		""+getitemname('@main[22])+"["+getiteminfo('@main[22],10)+"]")) {

	case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
	/* 武器16種 定義開始 */
	case 2:	set '@wp,0;	break;
	case 3:	set '@wp,1;	break;
	case 4:	set '@wp,2;	break;
	case 5:	set '@wp,3;	break;
	case 6:	set '@wp,4;	break;
	case 7:	set '@wp,5;	break;
	case 8:	set '@wp,6;	break;
	case 9:	set '@wp,7;	break;
	case 10:	set '@wp,8;	break;
	case 11:	set '@wp,9;	break;
	case 12:	set '@wp,10;	break;
	case 13:	set '@wp,11;	break;
	case 14:	set '@wp,12;	break;
	case 15:	set '@wp,13;	break;
	case 16:	set '@wp,14;	break;
	case 17:	set '@wp,15;	break;
	/* 武器16種 定義終了 */
	/* 400907 セレスティアルダイアデム 開始 */
	case 18:
		/* 初期条件設定 */
		set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[16]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[16])+" ["+getiteminfo('@main[16],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[16]) != 1)		{ mes ""+getitemname('@main[16])+"["+getiteminfo('@main[16],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	29436,	4876,	4879,	29509,	29371;
		setarray '@winC[0],	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[16],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 400907 セレスティアルダイアデム 終了 */

	/* 450462 セレスティアルアーマー 開始 */
	case 19:
		/* 初期条件設定 */
		set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[17]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[17])+" ["+getiteminfo('@main[17],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[17]) != 1)		{ mes ""+getitemname('@main[17])+"["+getiteminfo('@main[17],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	29305,	29302,	29303,	29304,	29307,	29306,	310320,	29309,	29308;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[17],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 450462 セレスティアルアーマー 終了 */

	/* 450463 セレスティアルスーツ 開始 */
	case 20:
		/* 初期条件設定 */
		set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[18]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[18])+" ["+getiteminfo('@main[18],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[18]) != 1)		{ mes ""+getitemname('@main[18])+"["+getiteminfo('@main[18],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	29305,	29302,	29303,	29304,	29307,	29306,	310320,	29309,	29308;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[18],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 450463 セレスティアルスーツ 終了 */

	/* 480592 セレスティアルマント 開始 */
	case 21:
		/* 初期条件設定 */
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[19]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[19])+" ["+getiteminfo('@main[19],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[19]) != 1)		{ mes ""+getitemname('@main[19])+"["+getiteminfo('@main[19],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	314163,	314164,	314165,	314166;
		setarray '@winC[0],	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[19],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 480592 セレスティアルマント 終了 */

	/* 470351 セレスティアルブーツ 開始 */
	case 22:
		/* 初期条件設定 */
		set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[20]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[20])+" ["+getiteminfo('@main[20],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[20]) != 1)		{ mes ""+getitemname('@main[20])+"["+getiteminfo('@main[20],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[20],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 470351 セレスティアルブーツ 終了 */

	/* 490745 セレスティアルリング[0] スロットエンチャント 開始 */
	case 23:
		/* 初期条件設定 */
		set '@pos,7;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ


		//if(countitem('@main[21]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[21])+" ["+getiteminfo('@main[21],10)+"] を装備して下さい";	close;	}
		if(getequipisequiped(8) == 1) 			{ mes "アクセサリ(2)を外して下さい";	close;	}
		if(equippeditem('@main[21]) != 1)		{ mes ""+getitemname('@main[21])+"["+getiteminfo('@main[21],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* メニュー処理終了 */

		/* スロットエンチャント開始 */
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	50,	0;	/* スロットエンチャント選択で失敗率加算 */
		set '@changeid,490746;			//スロットエンチャント

			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "^FFFFFF_^000000";
			mes "第1スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			"スロットエンチャントする",
			"スロットエンチャントしない")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
			mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "第1スロット: スロットエンチャント"; }
			if('@en1 == 0) { mes "第1スロット: 未選択 "; } 
			mes "^FFFFFF_^000000";
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//スロットエンチャント成功率
				if('@en1 == 1) {
					if('@changerate >= '@winD[0]) {
						misceffect 154,"";
						mes "[" +strnpcinfo(1)+ "]";
						mes "大成功しました";
						delitem '@costAid,'@costAnum;
						delequip '@pos;
						getitem2 '@changeid,1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
						else 
						{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; close; }	}
				if('@en1 == 0) {
					if('@winrate >= '@result) {
						 misceffect 154,"";
						 mes "[" +strnpcinfo(1)+ "]";
						 mes "成功しました";
						 delitem '@costAid,'@costAnum;
						 delequip '@pos;
						 getitem2 '@main[21],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
						 else
						 { misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; close; }	}
		}
	/* 490745 セレスティアルリング[0] スロットエンチャント 終了 */

	/* 490746 セレスティアルリング[1] 開始 */
	case 24:
		/* 初期条件設定 */
		set '@pos,7;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main[22]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[22])+" ["+getiteminfo('@main[22],10)+"] を装備して下さい";	close;	}
		if(getequipisequiped(8) == 1) 			{ mes "アクセサリ(2)を外して下さい";	close;	}
		if(equippeditem('@main[22]) != 1)		{ mes ""+getitemname('@main[22])+"["+getiteminfo('@main[22],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[22],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
	/* 490746 セレスティアルリング[1] 終了 */
	}

	if('@wp <= 15) {/* 武器開始 */
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@main['@wp])+"["+getiteminfo('@main['@wp],10)+"]";
	mes "武器エンチャ開始";
	next;
		/* 初期条件設定 */
		set '@pos,4;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//カードスロット1のカードIDを保存(◯◯◯●)
		set '@slotBcard,getequipcardid('@pos,2);	//カードスロット2のカードIDを保存(◯◯●◯)
		set '@slotCcard,getequipcardid('@pos,1);	//カードスロット3のカードIDを保存(◯●◯◯)
		set '@slotDcard,getequipcardid('@pos,0);	//カードスロット4のカードIDを保存(●◯◯◯)
		set '@ref,getequiprefinerycnt('@pos);		//アイテムの精錬値をエンチャント後に引き継ぐ
		
		//if(countitem('@main['@wp]) >= 2) 		{ mes "同じアイテムを持っています";	close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main['@wp])+" ["+getiteminfo('@main['@wp],10)+"] を装備して下さい";	close;	}
		if(getitemid(getequipname(3)) == '@Lefthand['@wp])	{ mes ""+getitemname('@Lefthand['@wp])+" は左手に装備しないで下さい。";	close;	}
		if(equippeditem('@main['@wp]) != 1)		{ mes ""+getitemname('@main['@wp])+"["+getiteminfo('@main['@wp],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";		close;	}
		/* 初期条件設定ここまで */
	/* エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	4853,	4854,	4855,	4856,	4857,	4858,	29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "第2スロットのエンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"",
			""+getitemname('@slotC[11])+"",
			""+getitemname('@slotC[12])+"",
			""+getitemname('@slotC[13])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;
			case 11: set '@en2,'@slotC[9]; set '@winCrate,'@winC[9]; break;
			case 12: set '@en2,'@slotC[10]; set '@winCrate,'@winC[10]; break;
			case 13: set '@en2,'@slotC[11]; set '@winCrate,'@winC[11]; break;
			case 14: set '@en2,'@slotC[12]; set '@winCrate,'@winC[12]; break;
			case 15: set '@en2,'@slotC[13]; set '@winCrate,'@winC[13]; break;	}
		/* メニュー処理終了 */

		/* エンチャントの最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main['@wp],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* エンチャント選択の最終処理終了 *//* 精錬条件終了 */
/* 武器終了 */}
	mes "["+strnpcinfo(1)+"]";
	mes "スクリプト最下段";
	close;
}

//管理用NPC開始
4th_lib.gat,39,58,3	shop	天体図書館SHOP		10545,1000372,1002223,1002220

//倉庫サービス
4th_lib.gat,39,54,3	script	倉庫サービス	464,{
	if(Zeny < 40) {	mes "ゼニーが足りません";	close;	}
	set Zeny,Zeny-40;	openstorage;	end;
}

4th_lib.gat,30,69,3	script	アイテム削除	464,{
	mes "["+strnpcinfo(1)+"]";
	mes "消しました";
	clearitem;
	gmcommand "@itemreset";
	close;
}
//管理用NPCここまで

//マップフラグここから
//4th_lib.gat	mapflag	nosave		SavePoint
4th_lib.gat	mapflag	nomemo		dummy
4th_lib.gat	mapflag	noteleport	dummy
4th_lib.gat	mapflag	nobranch	dummy
4th_lib.gat	mapflag	monster_noteleport	dummy
4th_lib.gat	mapflag	noicewall	dummy
4th_lib.gat	mapflag	noabra		dummy