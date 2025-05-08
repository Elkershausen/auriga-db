//2025/05/07 アップデート
//共通 スロット位置:左<-['@slotD/'@slotDcard(第1スロ/第4エンチャ)]<-['@slotC/'@slotCcard(第2スロ/第3エンチャ)]<-['@slotB/'@slotBcard(第3スロ/第2エンチャ)]<-['@slotA/'@slotAcard(第4スロ/第1エンチャ)]<-右から開始
//エンチャント4つまで カード引き継ぎなし 精錬条件なし アイテム交換あり コストアイテム1種100個
//[19443 星の眼帯[0] -> 19444 星の眼帯[1]][19445 負傷兵の眼帯[0] -> 19446 負傷兵の眼帯[1]]

enchant01.gat,176,60,3	script	ジル	559,{

	/* 共通条件設定 */
	setarray '@main[0],	19443,19445;	//エンチャントをつけるアイテム
	setarray '@slotnum[0],	0,	0;
	setarray '@changeid[0],	19444,19446;	//スロットエンチャント
	set '@costAid,7510;								//必要なアイテム 7510 ヴァルハラの花
	set '@costAnum,100;								//必要なアイテムの数 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}	//先頭に共通条件を挟み全体を簡素化する
	/* 共通条件設定ここまで */

	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" 個 必要";
	mes "どの装備にエンチャントしますか？";
	next;
	switch(select(
		"やめる",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]")) {/* アイテム選択開始 */
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;

	/* 19443 星の眼帯[0] 開始 */
	case 2:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,9;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[0]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		//set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		set '@ref,0;					/* アイテムの精錬値を0にする */
		set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

	/* 第1エンチャント処理開始 */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[0])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;	}
		/* メニュー処理終了 */

		/* エンチャント1つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: 未選択 ";
			mes "第2スロット: 未選択 ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}
	/* 第1エンチャント処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	*/
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;	}
		/* メニュー処理終了 */

		/* エンチャント2つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: 未選択 ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; 								close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotC[0],	29241,	29238,	29240,	4942,	29012,	29243;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;	}
		/* メニュー処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
				}
		/* エンチャント3つ選択の最終処理終了 */
		}
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	95,	0;	/* スロットエンチャント選択で失敗率95加算 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			"スロットエンチャントをする",
			"スロットエンチャントをしない")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "第1スロット: スロットエンチャント"; }
			if('@en1 == 0) { mes "第1スロット: 未選択 "; } 
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//スロットエンチャント成功率
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "設定成功率 : "+'@winD[0]+" ";
				next;
				if('@slotD[0] == 1 ) { if('@changerate >= '@winD[0]) { misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "大成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@changeid[0],1,1,0,0,0,0,0,0,0;	close;	} }
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}	//スロットエンチャントを選ばない場合は3つのエンチャント判定
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 19443 星の眼帯[0] 終了 */

	/* 19445 負傷兵の眼帯[0] 開始 */
	case 3:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,9;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[1]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		//set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		set '@ref,0;					/* アイテムの精錬値を0にする */
		set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

	/* 第1エンチャント処理開始 */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[1])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;	}
		/* メニュー処理終了 */

		/* エンチャント1つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: 未選択 ";
			mes "第2スロット: 未選択 ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}
	/* 第1エンチャント処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	*/
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;	}
		/* メニュー処理終了 */

		/* エンチャント2つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: 未選択 ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; 								close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotC[0],	29241,	29238,	29240,	4942,	29012,	29243;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;	}
		/* メニュー処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1;									close;	}
				}
		/* エンチャント3つ選択の最終処理終了 */
		}
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	95,	0;	/* スロットエンチャント選択で失敗率95加算 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			"スロットエンチャントをする",
			"スロットエンチャントをしない")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "第1スロット: スロットエンチャント"; }
			if('@en1 == 0) { mes "第1スロット: 未選択 "; } 
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//スロットエンチャント成功率
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "設定成功率 : "+'@winD[0]+" ";
				next;
				if('@slotD[0] == 1 ) { if('@changerate >= '@winD[0]) { misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "大成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@changeid[0],1,1,0,0,0,0,0,0,0;	close;  } }
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}	//スロットエンチャントを選ばない場合は3つのエンチャント判定
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1;									close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 19445 負傷兵の眼帯[0] 終了 */
	}
}
