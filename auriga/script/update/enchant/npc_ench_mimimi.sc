//2025/06/03 アップデート
//分析エンチャントチケット フラグの設定 未実装
//エンチャントパターン 精錬条件なし 全スロットエンチャ スロットエンチャントなし

//prontera.gat,160,115,4	script	分析職人・長女	815,{
yuno.gat,211,291,3	script	分析職人・長女	815,{

	/* 共通条件設定 */
				//[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]
	setarray '@main[0],	400012,	22235,	20974,	20977,	20978,	20979,	32268,	32269,	400013;	//エンチャントをつけるアイテム
	setarray '@slotnum[0],	0,	0;
	//setarray '@changeid[0],	19444,19446;	//スロットエンチャント
	set '@costAid,7347;								//必要なアイテム 分析エンチャントチケット -> 仮設定 7347 研究記録
	set '@costAnum,100;								//必要なフラグの数 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}	//先頭に共通条件を挟み全体を簡素化する
	//if('@costAid <= ('@costAnum - 1))	{ mes "分析エンチャントチケットが "+'@costAnum+" 枚必要です";	close;	}	//先頭に共通条件を挟み全体を簡素化する
	/* 共通条件設定ここまで */

	/* スクリプト開始 */
	mes "["+strnpcinfo(1)+"]";
	mes "私は、とある研究会から依頼を受けて";
	mes "冒険者さんの手伝いをしています。";
	mes "エンチャント依頼ですか？";
	mes "分析エンチャントチケット : "+'@costAnum+" 個";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" 個 必要";
	next;
	if(select("エンチャントを依頼する","会話をやめます") == 2) { mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;	}

	mes "["+strnpcinfo(1)+"]";
	mes "どの装備にエンチャントしますか？";
	next;
	switch(select(
		"やっぱりやめる",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",	/* "アイテム名""[スロット]" */
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]")) {
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;

	/* '@main[0] 400012 黎明のマジェスティックゴート[0] 開始 *//* 精錬条件込みサンプル */
	case 2:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[0]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ 全スロットエンチャントの場合は無効 */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotA[0],	29372;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット: 無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

		/* エンチャント1つ選択の最終処理開始 */	/* 精錬条件開始 */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
			if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
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
		}
		/* エンチャント1つ選択の最終処理終了 */ /* 精錬条件終了 */
	/* 第1エンチャント処理終了 */

	/* 第2エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotB[0],	27412;
		setarray '@winB[0],	0;
		/* エンチャントIDと個別成功率設定終了 */
		
		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット: 無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];		break;	}
		/* メニュー処理終了 */

		/* エンチャント2つ選択の最終処理開始 */	/* 精錬条件開始 */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
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
		}
		/* エンチャント2つ選択の最終処理終了 */	/* 精錬条件終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotC[0],	300229,	310650;
		//setarray '@winC[0],	0,	0;
		/* エンチャントIDと個別成功率設定終了 */
		
		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット: 無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント3つ選択の最終処理開始 */	/* 精錬条件開始 */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
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
			}
		/* エンチャント3つ選択の最終処理終了 */	/* 精錬条件終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
		/* エンチャントIDと個別成功率設定開始 */
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;
		/* エンチャントIDと個別成功率設定終了 */

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: 無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;		close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 400012 黎明のマジェスティックゴート[0] 終了 */

	/* '@main[1] 22235 銀の毛皮のシューズ[0] 開始 */
	case 3:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[1]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	[1]	*/
		setarray '@slotA[0],	29373,	311421;
		setarray '@winA[0],	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;	}
		/* メニュー処理終了 */
		/* エンチャント1つ選択の最終処理開始 */	/* 精錬条件開始 */
		/* エンチャント1つ選択の最終処理終了 */	/* 精錬条件終了 */
	/* 第1エンチャント処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	[1]	*/
		setarray '@slotB[0],	29373,	311421;
		setarray '@winB[0],	0,	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;	}
		/* メニュー処理終了 */
		/* エンチャント2つ選択の最終処理開始 */	/* 精錬条件開始 */
		/* エンチャント2つ選択の最終処理終了 */	/* 精錬条件終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
		/* エンチャント3つ選択の最終処理開始 */	/* 精錬条件開始 */
		/* エンチャント3つ選択の最終処理終了 */	/* 精錬条件終了 */
	/* 第3エンチャント処理終了 */

	/* 第4エンチャント処理開始 */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */
	/* 第4エンチャント処理終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[1],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 22235 銀の毛皮のシューズ[0] 終了 */

	/* '@main[2] 20974 ピオニーマミーのフード[0] 開始 */
	case 4:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[2]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[2])+" ["+getiteminfo('@main[2],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[2]) != 1)		{ mes ""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29214;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[2],1; getitem2 '@main[2],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[2],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 20974 ピオニーマミーのフード[0] 終了 */

	/* '@main[3] 20977 スノーフリップのフード[0] 開始 */
	case 5:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[3]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[3])+" ["+getiteminfo('@main[3],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[3]) != 1)		{ mes ""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29216;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[3],1; getitem2 '@main[3],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[3],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 20977 スノーフリップのフード[0] 終了 */

	/* '@main[4] 20978 世界樹のほこりのフード[0] 開始 */
	case 6:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[4]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[4])+" ["+getiteminfo('@main[4],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[4]) != 1)		{ mes ""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29215;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[4],1; getitem2 '@main[4],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[4],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* 20978 世界樹のほこりのフード[0] 終了 */

	/* '@main[5] 20979 ぴしゃりハーブのフード[0] 開始 */
	case 7:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[5]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[5])+" ["+getiteminfo('@main[5],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[5]) != 1)		{ mes ""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29217;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[5],1; getitem2 '@main[5],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[5],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* '@main[5] 20979 ぴしゃりハーブのフード[0] 終了 */

	/* '@main[6] 32268 カルニウムリング[0] 開始 */
	case 8:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,7;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[6]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "アクセサリ(1) に "+getitemname('@main[6])+" ["+getiteminfo('@main[6],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[6]) != 1)		{ mes ""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29373;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	311421;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[6],1; getitem2 '@main[6],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[6],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* '@main[6] 32268 カルニウムリング[0] 終了 */

	/* '@main[7] 32269 カルニウムイヤリング[0] 開始 */
	case 9:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,8;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[7]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "アクセサリ(2) に "+getitemname('@main[7])+" ["+getiteminfo('@main[7],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[7]) != 1)		{ mes ""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	29373;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	311421;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[7],1; getitem2 '@main[7],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[7],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* '@main[7] 32269 カルニウムイヤリング[0] 終了 */
	
	/* '@main[8] 400013 くわえたチョコスティック[0] 開始 */
	case 10:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,10;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		if(countitem('@main[8]) >= 2) 			{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[8])+" ["+getiteminfo('@main[8],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[8]) != 1)		{ mes ""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		//set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		/* 引き継ぎ設定ここまで */


	/* 第1エンチャント処理開始 */
		/* エンチャントIDと個別成功率設定 */
				/*	[0]	*/
		setarray '@slotA[0],	4949;
		setarray '@winA[0],	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* メニュー処理終了 */

	/* 第2エンチャント処理開始 */
				/*	[0]	*/
		setarray '@slotB[0],	4815;
		setarray '@winB[0],	0;

		/* メニュー処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* メニュー処理終了 */
	/* 第2エンチャント処理終了 */

	/* 第3エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotC[0],	4869;
		setarray '@winC[0],	0;
		/* メニュー処理開始 */

		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* メニュー処理終了 */
	/* 第3エンチャント選択処理終了 */

	/* 第4エンチャント選択処理開始 */
				/*	[0]	*/
		setarray '@slotD[0],	4900;
		setarray '@winD[0],	0;

		/* メニュー処理開始 */
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット:無し"; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第4エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotD[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;	}
		/* メニュー処理終了 */

		/* エンチャント4つ選択の確認開始 */
			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "第2スロット: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "第1スロット: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "これでよろしいですか？";
		/* エンチャント4つ選択の確認終了 */

		/* エンチャントアイテム取得処理開始 */
			next;
			switch(select(
			"やめる",
			"エンチャントする"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "スロット失敗率 : "+'@changerate+" ";
				mes "エンチャ失敗率 : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "スロットエンチャント設定成功率 : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delitem '@main[8],1; getitem2 '@main[8],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//第1スロットにエンチャントする場合は ['@slotDcard] -> ['@en1] 変更
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delitem '@main[8],1;								close;	}
			}
		/* エンチャントアイテム取得処理終了 */
	/* '@main[8] 400013 くわえたチョコスティック[0] 終了 */

	}
}
