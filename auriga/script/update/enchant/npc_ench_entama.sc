//2025/05/07 アップデート
//共通 スロット位置:左<-['@slotD/'@slotDcard(第1スロ/第4エンチャ)]<-['@slotC/'@slotCcard(第2スロ/第3エンチャ)]<-['@slotB/'@slotBcard(第3スロ/第2エンチャ)]<-['@slotA/'@slotAcard(第4スロ/第1エンチャ)]<-右から開始
//エンチャント3つまで 精錬条件あり コストアイテム1種100個
//[14thアニバーサリーパッケージ][サマーパッケージ2017] 10種実装

enchant01.gat,176,73,3	script	エンタマ#36399	553,{
	/* 共通条件設定 */
	setarray '@main[0],19172,22129,15191,19174,19173,19272,20854,15209,19273,19274;	//エンチャントをつけるアイテム10個
	set '@costAid,6919;								//必要なアイテム 6919 王家貢献の証
	set '@costAnum,100;								//必要なアイテムの数 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";			close;	}	//先頭に共通条件を挟み全体を簡素化する
	/* 共通条件設定ここまで */

	/* スクリプト開始 */
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" 個 必要";
	mes "精錬値と防具のカードは維持されます";
	mes "エンチャントは上書きされます";
	mes "同じ装備は消える可能性があるので";
	mes "倉庫に預け、持たないで下さい";
	mes "どの装備にエンチャントしますか？";
	next;
	switch(select(
		"やめる",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",	/* "アイテム名""[スロット]" */
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]",
		""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]")) {
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;

	/* 19172 お座り教皇(私服)[1] 開始 */
	case 2:
		/* 初期条件設定 */
		set '@refA,6;					//'@slotAの精錬値条件(6以上)
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,99;					//'@slotCの精錬値条件(未使用)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//set '@addflagAid,9999;			//エンチャ別に何か設定したい場合 追加アイテム 成功率変化 S付き入手
		//if(countitem('@main[0]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		setarray '@slotA[0],	29012,	29248,	4900,	4801,	4946,	4944,	4767,	4897,	4817,	29136,	4810,	4833,	4814,	4872;	/* エンチャントID */
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* 成功率減少(1/100) 個別設定 大きいほど成功率が減る */
		//setarray '@addflagAnum[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* エンチャ別に何か設定したい場合 追加アイテム 成功率変化 S付き入手 */
		/* エンチャントIDと個別成功率設定ここまで */

		/* 第1エンチャント選択処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[0])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "第4スロット:無し"; } else { mes "第4スロット:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "第3スロット:無し"; } else { mes "第3スロット:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "第2スロット:無し"; } else { mes "第2スロット:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }	//カード有無でmes変更
		mes "第1エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"",
			""+getitemname('@slotA[12])+"",
			""+getitemname('@slotA[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;
			case 14:	set '@en4,'@slotA[12];	set '@winArate,'@winA[12];	break;
			case 15:	set '@en4,'@slotA[13];	set '@winArate,'@winA[13];	break;	}
		/* 第1エンチャント選択処理終了 */

		/* エンチャント1つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refB) {	//精錬値条件
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}

		/* 第2エンチャント選択処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		setarray '@slotB[0],	29012,	29248,	4900,	4801,	4946,	4944,	4767,	4897,	4817,	29136,	4810,	4833,	4814,	4872;	/* エンチャントID */
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* 成功率減少(1/100) 個別設定 大きいほど成功率が減る */
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
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"",
			""+getitemname('@slotB[12])+"",
			""+getitemname('@slotB[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;
			case 14:	set '@en3,'@slotB[12];	set '@winBrate,'@winB[12];	break;
			case 15:	set '@en3,'@slotB[13];	set '@winBrate,'@winB[13];	break;	}
		/* 第2エンチャント選択処理終了 */

		/* エンチャント2つ選択の最終処理開始 */
		if(getequiprefinerycnt('@pos) < '@refC) {	//精錬値条件
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}

		/* 第3エンチャント選択処理開始 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	[14]	[15]	[16]	*/
		setarray '@slotC[0],	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999;	/* エンチャントID */
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* 成功率減少(1/100) 個別設定 大きいほど成功率が減る */
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
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"",
			""+getitemname('@slotC[11])+"",
			""+getitemname('@slotC[12])+"",
			""+getitemname('@slotC[13])+"",
			""+getitemname('@slotC[14])+"",
			""+getitemname('@slotC[15])+"",
			""+getitemname('@slotC[16])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;
			case 14:	set '@en2,'@slotC[12];		set '@winCrate,'@winC[12];	break;
			case 15:	set '@en2,'@slotC[13];		set '@winCrate,'@winC[13];	break;
			case 16:	set '@en2,'@slotC[14];		set '@winCrate,'@winC[14];	break;
			case 17:	set '@en2,'@slotC[15];		set '@winCrate,'@winC[15];	break;
			case 18:	set '@en2,'@slotC[16];		set '@winCrate,'@winC[16];	break;	}
		/* 第3エンチャント選択処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* エンチャント3つ選択の最終処理終了 */
			}
	/* 19172 お座り教皇(私服)[1] 終了 */

	/* 22129 勇者の靴[1] 開始 */
	case 3:
		/* 初期条件設定 */
		set '@refA,6;					//'@slotAの精錬値条件(6以上)
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,99;					//'@slotCの精錬値条件(未使用)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8

		//if(countitem('@main[1]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
		setarray '@slotA[0],	29012,	29244,	4900,	4801,	4950,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* 第1エンチャント選択処理開始 */
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"",
			""+getitemname('@slotA[12])+"",
			""+getitemname('@slotA[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;
			case 14:	set '@en4,'@slotA[12];	set '@winArate,'@winA[12];	break;
			case 15:	set '@en4,'@slotA[13];	set '@winArate,'@winA[13];	break;	}
		/* 第1エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}

		/* 第2エンチャント選択処理開始 */
		setarray '@slotB[0],	29012,	29244,	4900,	4801,	4950,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"",
			""+getitemname('@slotB[12])+"",
			""+getitemname('@slotB[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;
			case 14:	set '@en3,'@slotB[12];	set '@winBrate,'@winB[12];	break;
			case 15:	set '@en3,'@slotB[13];	set '@winBrate,'@winB[13];	break;	}
		/* 第2エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}

		/* 第3エンチャント選択処理開始 */
		setarray '@slotC[0],	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"",
			""+getitemname('@slotC[11])+"",
			""+getitemname('@slotC[12])+"",
			""+getitemname('@slotC[13])+"",
			""+getitemname('@slotC[14])+"",
			""+getitemname('@slotC[15])+"",
			""+getitemname('@slotC[16])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;
			case 14:	set '@en2,'@slotC[12];		set '@winCrate,'@winC[12];	break;
			case 15:	set '@en2,'@slotC[13];		set '@winCrate,'@winC[13];	break;
			case 16:	set '@en2,'@slotC[14];		set '@winCrate,'@winC[14];	break;
			case 17:	set '@en2,'@slotC[15];		set '@winCrate,'@winC[15];	break;
			case 18:	set '@en2,'@slotC[16];		set '@winCrate,'@winC[16];	break;	}
		/* 第3エンチャント選択処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* エンチャント3つ選択の最終処理終了 */
			}
	/* 22129 勇者の靴[1] 終了 */

	/* 15191 カーリッツバーグ騎士団の鎧[1] 開始 */
	case 4:
		/* 初期条件設定 */
		set '@refA,6;					//'@slotAの精錬値条件(6以上)
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,10;					//'@slotCの精錬値条件(10以上)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[2]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[2])+" ["+getiteminfo('@main[2],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[2]) != 1)		{ mes ""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
		setarray '@slotA[0],	29012,	29246,	4900,	4801,	29242,	29235,	4818,	29135,	4811,	4832,	4815,	4869;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* 第1エンチャント選択処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[2])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
		/* 第1エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}

		/* 第2エンチャント選択処理開始 */
		setarray '@slotB[0],	29012,	29246,	4900,	4801,	29242,	29235,	4818,	29135,	4811,	4832,	4815,	4869;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
		/* 第2エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}

		/* 第3エンチャント選択処理開始 */
		setarray '@slotC[0],	4879;
		setarray '@winC[0],	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* 第3エンチャント選択処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* エンチャント3つ選択の最終処理終了 */
			}
	/* 15191 カーリッツバーグ騎士団の鎧[1] 終了 */

	/* 19174 小型偵察機[0] 開始 */
	case 5:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,9;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[3]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[3])+" ["+getiteminfo('@main[3],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[3]) != 1)		{ mes ""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
		setarray '@slotA[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* 第1エンチャント選択処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[3])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;	}
		/* 第1エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}

		/* 第2エンチャント選択処理開始 */
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;	}
		/* 第2エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}

		/* 第3エンチャント選択処理開始 */
		setarray '@slotC[0],	4902,	4901,	29241,	29238,	29240,	4942,	29012,	4807,	4900,	4801,	29243,	29247;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"",
			""+getitemname('@slotC[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;	}
		/* 第3エンチャント選択処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* エンチャント3つ選択の最終処理終了 */
			}
	/* 19174 小型偵察機[0] 終了 */

	/* 19173 浮遊する氷[0] 開始 */
	case 6:
		/* 初期条件設定 */
		set '@refA,0;					//'@slotAの精錬値条件(未使用)
		set '@refB,0;					//'@slotBの精錬値条件(未使用)
		set '@refC,0;					//'@slotCの精錬値条件(未使用)
		set '@refD,0;					//'@slotDの精錬値条件(未使用)
		set '@pos,10;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[4]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[4])+" ["+getiteminfo('@main[4],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[4]) != 1)		{ mes ""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
		/* 初期条件設定ここまで */

		/* 引き継ぎ設定 */
		set '@ref,getequiprefinerycnt('@pos);		/* アイテムの精錬値をエンチャント後に引き継ぐ */
		set '@slotDcard,getequipcardid('@pos,0);	/* 第1スロットのカードをエンチャント後に引き継ぐ */
		//set '@ref,0;					/* アイテムの精錬値を0にする */
		//set '@slotDcard,0;				/* 第1スロットのカードを消す */
		/* 引き継ぎ設定ここまで */

		/* エンチャントIDと個別成功率設定 */
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0;
		/* エンチャントIDと個別成功率設定ここまで */

		/* 第1エンチャント選択処理開始 */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[4])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;	}
		/* 第1エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* エンチャント1つ選択の最終処理終了 */
		}

		/* 第2エンチャント選択処理開始 */
		setarray '@slotB[0],	4793,	4788,	29237,	29239,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;
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
		/* 第2エンチャント選択処理終了 */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* エンチャント2つ選択の最終処理終了 */
		}

		/* 第3エンチャント選択処理開始 */
		setarray '@slotC[0],	4867,	4801,	4767,	4897,	29236,	29243,	29245;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0;
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
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;	}
		/* 第3エンチャント選択処理終了 */

		/* エンチャント3つ選択の最終処理開始 */
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* エンチャント3つ選択の最終処理終了 */
			}
	/* 19173 浮遊する氷[0] 終了 */

	/* 19272 ガーデンオブエデン[1] 開始 */
	case 7:	
		set '@refA,6;					//'@slotAの精錬値条件(6以上)初期条件
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,10;					//'@slotCの精錬値条件(10以上)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[5]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[5])+" ["+getiteminfo('@main[5],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[5]) != 1)		{ mes ""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	29248,	4947,	4950,	29243,	4815,	4814,	4869,	4872,	4944,	4900,	29372;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[5])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	29248,	4947,	4950,	29243,	4815,	4814,	4869,	4872,	4944,	4900,	29372;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第3スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19272 ガーデンオブエデン[1] 終了 */

	/* 20854 メディックケープ[1] 開始 */
	case 8:	
		set '@refA,6;					//'@slotAの精錬値条件(6以上)初期条件
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,99;					//'@slotCの精錬値条件(未使用)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[6]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[6])+" ["+getiteminfo('@main[6],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[6]) != 1)		{ mes ""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	4946,	4949,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[6])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	4946,	4949,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
			mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
			mes "第3スロット: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "これでよろしいですか？";
			next;
			switch(select("やめる","エンチャントする")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 20854 メディックケープ[1] 終了 */

	/* 15209 ドレイクコート[1] 開始 */
	case 9:	
		set '@refA,6;					//'@slotAの精錬値条件(6以上)初期条件
		set '@refB,8;					//'@slotBの精錬値条件(8以上)
		set '@refC,99;					//'@slotCの精錬値条件(未使用)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[7]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[7])+" ["+getiteminfo('@main[7],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[7]) != 1)		{ mes ""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	29246,	4947,	4950,	29242,	4818,	29135,	4811,	4832,	4815,	4869,	4900;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[7])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	29246,	4947,	4950,	29242,	4818,	29135,	4811,	4832,	4815,	4869,	4900;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット: "+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: "+'@en3+":"+getitemname('@en3)+" ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第3エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 15209 ドレイクコート[1] 終了 */

	/* 19273 ジェミニ-S58の目(赤)[0] 開始 */
	case 10:	
		set '@refA,0;					//'@slotAの精錬値条件(0以上)初期条件
		set '@refB,0;					//'@slotBの精錬値条件(0以上)
		set '@refC,0;					//'@slotCの精錬値条件(0以上)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,9;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[8]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[8])+" ["+getiteminfo('@main[8],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[8]) != 1)		{ mes ""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}

		//set '@ref,getequiprefinerycnt('@pos);
		//set '@slotDcard,getequipcardid('@pos,0);
		set '@ref,0;
		set '@slotDcard,0;

		setarray '@slotA[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[8])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	4902,	4901,	29241,	29238,	29240,	4942,	4807,	4900,	4801,	29373,	29374;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
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
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;	}

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19273 ジェミニ-S58の目(赤)[0] 終了 */

	/* 19274 オープンエアヘッドフォン[0] 開始 */
	case 11:
		set '@refA,0;					//'@slotAの精錬値条件(0以上)初期条件
		set '@refB,0;					//'@slotBの精錬値条件(0以上)
		set '@refC,0;					//'@slotCの精錬値条件(0以上)
		set '@refD,99;					//'@slotDの精錬値条件(未使用)
		set '@pos,10;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
		//if(countitem('@main[9]) >= 2) 		{ mes "同じアイテムを持っています";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@main[9])+" ["+getiteminfo('@main[9],10)+"] を装備して下さい";	close;	}
		if(equippeditem('@main[9]) != 1)		{ mes ""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]を1つ装備して下さい";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}

		//set '@ref,getequiprefinerycnt('@pos);
		//set '@slotDcard,getequipcardid('@pos,0);
		set '@ref,0;
		set '@slotDcard,0;

		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[9])+" ";
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
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10;
		mes "["+strnpcinfo(1)+"]";
		mes "第4スロット: "+'@en4+":"+getitemname('@en4)+" ";
		mes "第3スロット: 未選択 ";
		mes "第2スロット: 未選択 ";
		if(getequipcardid('@pos,0) == 0) { mes "第1スロット: - "; } else { mes "第1スロット:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "第2エンチャを選んで下さい";
			next;
			switch(select(
			"やめる",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;	}
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	4867,	4801,	29012,	4807,	4767,	4897;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "成功しました"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "失敗しました"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19274 オープンエアヘッドフォン[0] 終了 */
	}
}
