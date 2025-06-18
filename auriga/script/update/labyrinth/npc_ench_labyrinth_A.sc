//2025/06/17 アップデート
//夢幻の迷宮 迷宮調査団キャンプ ラビリンスエンチャント

lby_in.gat,60,93,4	script	迷宮調査研究員	805,{/*0-0*/

	mes "["+strnpcinfo(1)+"]";
	mes "私は特定の武具に";
	mes "ラビリンスエンチャントが出来ます。";
	mes "今日はどのようなご用件ですか？";
	next;
	switch(select(
	"グループ1",
	"グループ2",
	"話をやめる")) {/*1-0*/

	case 1:	/* グループ1 */
		/* 初期設定 */
		set '@costAid,25662;
		set '@costAnum,1;
		setarray '@mainF,19451,19452;
		set '@pos,9;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}	//先頭に共通条件
		if(getequipisequiped('@pos) == 0) { mes "指定部位に "+getitemname('@mainF[0])+" ["+getiteminfo('@mainF[0],10)+"] を装備して下さい"; close; }
		if(equippeditem('@mainF[0]) != 1) { mes ""+getitemname('@mainF[0])+"["+getiteminfo('@mainF[0],10)+"]を1つ装備して下さい";	close; }
		/* 初期設定 */

		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@mainF[0])+"に";
		mes "スロットエンチャントしますか？";
		next;
		if(select("はい","やめる") == 2) {
			mes "["+strnpcinfo(1)+"]";
			mes "ご利用お待ちしています。";
			close; }
		set '@change,rand(0,99);
		if('@change > 95) {
			misceffect 622,"";
			delitem '@costAid,'@costAnum;
			delequip '@pos;
			getitem '@mainF[1],1;
			mes "["+strnpcinfo(1)+"]";
			mes "成功しました。";
			close;	} else {
			misceffect 155,"";
			delitem '@costAid,'@costAnum;
			mes "["+strnpcinfo(1)+"]"; mes "失敗しました。";
			close;	}

	case 2: /* グループ2 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	[14]	[15]	*/
		//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004,	460002;		//武15種 + 盾1種
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]		[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,		19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種
		//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,		15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種
		//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,		20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種
		//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,		22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種
		set '@costBid,783;
		set '@costBnum,10;
		if(countitem('@costBid) <= ('@costBnum - 1))	{ mes ""+getitemname('@costBid)+" が "+'@costBnum+" 個必要です";	close;	}

		switch(select(
		"装備を選ぶ",
		"説明を詳しく聞く",
		"話をやめる")) {/*2-0*/
			case 1:
			setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004,	460002;		//武15種 + 盾1種
			setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0,	0,;		//短剣 片手槍 片手斧 左手制限
			switch(select(
				"やめる",
				""+getitemname('@mainA[0])+"["+getiteminfo('@mainA[0],10)+"]",
				""+getitemname('@mainA[1])+"["+getiteminfo('@mainA[1],10)+"]",
				""+getitemname('@mainA[2])+"["+getiteminfo('@mainA[2],10)+"]",
				""+getitemname('@mainA[3])+"["+getiteminfo('@mainA[3],10)+"]",
				""+getitemname('@mainA[4])+"["+getiteminfo('@mainA[4],10)+"]",
				""+getitemname('@mainA[5])+"["+getiteminfo('@mainA[5],10)+"]",
				""+getitemname('@mainA[6])+"["+getiteminfo('@mainA[6],10)+"]",
				""+getitemname('@mainA[7])+"["+getiteminfo('@mainA[7],10)+"]",
				""+getitemname('@mainA[8])+"["+getiteminfo('@mainA[8],10)+"]",
				""+getitemname('@mainA[9])+"["+getiteminfo('@mainA[9],10)+"]",
				""+getitemname('@mainA[10])+"["+getiteminfo('@mainA[10],10)+"]",
				""+getitemname('@mainA[11])+"["+getiteminfo('@mainA[11],10)+"]",
				""+getitemname('@mainA[12])+"["+getiteminfo('@mainA[12],10)+"]",
				""+getitemname('@mainA[13])+"["+getiteminfo('@mainA[13],10)+"]",
				""+getitemname('@mainA[14])+"["+getiteminfo('@mainA[14],10)+"]",
				"頭装備を選ぶ")) {/*2-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	set '@EQ,14;	break;	/*武器盾ここまで*/
				case 17:	set '@EQ,15;	break;	/*2-1*/}

				if('@EQ <= 13) {/* 武器開始 */
					/* 初期設定 */
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,4;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* 初期設定 */

					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] を装備して下さい";	close;	}
					if(getitemid(getequipname(3)) == '@Lefthand['@EQ])	{ mes ""+getitemname('@Lefthand['@EQ])+" は左手に装備しないで下さい。";	close;	}
					if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					/*	管理用ここから mes "[" +strnpcinfo(1)+ "]";
					mes "引き継ぎ情報";
					mes "精錬値 : + "+'@ref+" ";
					mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
					mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
					mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
					mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
					next;	管理用ここまで*/
					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*2-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardD,'@slotD[rand(0,13)];
							/*	管理用ここからmes "[" +strnpcinfo(1)+ "]";
							mes "第4スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4709,	4739,	4749,	4719,	4729,	4759,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardC,'@slotC[rand(0,11)];
							/*	管理用ここからmes "[" +strnpcinfo(1)+ "]";
							mes "第3スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4879,	4875,	4876;
							set '@cardB,'@slotB[rand(0,2)];
							/*	管理用ここからmes "[" +strnpcinfo(1)+ "]";
							mes "第2スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break; /* 第2スロット終了 */
						/*2-2*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainA['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
				/* 武器終了 */}

				if('@EQ == 14) {/* 盾開始 */
				/* 初期設定 */
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,3;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* 初期設定 */

					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";						close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					/*	管理用ここから mes "[" +strnpcinfo(1)+ "]";
					mes "引き継ぎ情報";
					mes "精錬値 : + "+'@ref+" ";
					mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
					mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
					mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
					mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
					next;	*/
					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*2-3*/
						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2:
							setarray '@slotD,4881,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,6)];
							/*	管理用ここから mes "[" +strnpcinfo(1)+ "]";
							mes "第4スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break;

						case 3:
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29373,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,6)];
							/*	管理用ここから mes "[" +strnpcinfo(1)+ "]";
							mes "第3スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break;

						case 4:
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotC,	310193,	310193;
							set '@cardC,'@slotC[rand(0,1)];
							/*	管理用ここから mes "[" +strnpcinfo(1)+ "]";
							mes "第2スロット選択結果";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	管理用ここまで*/
						break;

						/*2-3*/}
					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainA['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
				/* 盾 終了*/}
/*---------------------------------------------------------------------------------*/
			/* 頭装備開始 */
			setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種

				switch(select(
				"やめる",
				""+getitemname('@mainB[0])+"["+getiteminfo('@mainB[0],10)+"]",
				""+getitemname('@mainB[1])+"["+getiteminfo('@mainB[1],10)+"]",
				""+getitemname('@mainB[2])+"["+getiteminfo('@mainB[2],10)+"]",
				""+getitemname('@mainB[3])+"["+getiteminfo('@mainB[3],10)+"]",
				""+getitemname('@mainB[4])+"["+getiteminfo('@mainB[4],10)+"]",
				""+getitemname('@mainB[5])+"["+getiteminfo('@mainB[5],10)+"]",
				""+getitemname('@mainB[6])+"["+getiteminfo('@mainB[6],10)+"]",
				""+getitemname('@mainB[7])+"["+getiteminfo('@mainB[7],10)+"]",
				""+getitemname('@mainB[8])+"["+getiteminfo('@mainB[8],10)+"]",
				""+getitemname('@mainB[9])+"["+getiteminfo('@mainB[9],10)+"]",
				""+getitemname('@mainB[10])+"["+getiteminfo('@mainB[10],10)+"]",
				""+getitemname('@mainB[11])+"["+getiteminfo('@mainB[11],10)+"]",
				""+getitemname('@mainB[12])+"["+getiteminfo('@mainB[12],10)+"]",
				""+getitemname('@mainB[13])+"["+getiteminfo('@mainB[13],10)+"]",
				"鎧を選ぶ")) {/*3-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

				case 2:	set '@EQ,0;	/*19449巨蟹宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-2*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 3:	set '@EQ,1;	/*19473金牛宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-3*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,9)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-3*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 4:	set '@EQ,2; /*19447獅子宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-4*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,310319,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-4*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 5:	set '@EQ,3; /*5599処女宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-5*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29374,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-5*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 6:	set '@EQ,4; /*5739人馬宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-6*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29373,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4879,	4879;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-6*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 7:	set '@EQ,5; /*5514双魚宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-7*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4719,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4876,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-7*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 8:	set '@EQ,6; /*5569双児宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-8*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29374,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4879,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-8*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 9:	set '@EQ,7; /*19468天秤宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-9*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,27412,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-9*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 10:	set '@EQ,8; /*19471天蝎宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-10*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4825,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-10*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 11:	set '@EQ,9; /*5546白羊宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-11*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-11*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 12:	set '@EQ,10; /*15824プロキオンクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-12*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4719,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-12*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 13:	set '@EQ,11; /*19496宝瓶宮のクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-13*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-13*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 14:	set '@EQ,12; /*15823ポルックスクラウン*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-14*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4825,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-14*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 15:	set '@EQ,13; /*400015磨羯宮のダイアデム*/
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*3-15*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,4729,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4879,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*3-15*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;

				case 16:	break;	/*3-1*/}
/*---------------------------------------------------------------------------------*/
			/* 鎧開始 */
			setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種
				switch(select(
				"やめる",
				""+getitemname('@mainC[0])+"["+getiteminfo('@mainC[0],10)+"]",
				""+getitemname('@mainC[1])+"["+getiteminfo('@mainC[1],10)+"]",
				""+getitemname('@mainC[2])+"["+getiteminfo('@mainC[2],10)+"]",
				""+getitemname('@mainC[3])+"["+getiteminfo('@mainC[3],10)+"]",
				""+getitemname('@mainC[4])+"["+getiteminfo('@mainC[4],10)+"]",
				""+getitemname('@mainC[5])+"["+getiteminfo('@mainC[5],10)+"]",
				""+getitemname('@mainC[6])+"["+getiteminfo('@mainC[6],10)+"]",
				""+getitemname('@mainC[7])+"["+getiteminfo('@mainC[7],10)+"]",
				""+getitemname('@mainC[8])+"["+getiteminfo('@mainC[8],10)+"]",
				""+getitemname('@mainC[9])+"["+getiteminfo('@mainC[9],10)+"]",
				""+getitemname('@mainC[10])+"["+getiteminfo('@mainC[10],10)+"]",
				""+getitemname('@mainC[11])+"["+getiteminfo('@mainC[11],10)+"]",
				""+getitemname('@mainC[12])+"["+getiteminfo('@mainC[12],10)+"]",
				""+getitemname('@mainC[13])+"["+getiteminfo('@mainC[13],10)+"]",
				"肩にかけるものを選ぶ")) {/*4-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	break;	/*4-1*/}

				if('@EQ <= 13) {/* 鎧開始 */
					/* 初期設定 */
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* 初期設定 */

					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*4-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,11)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,29305,	29302,	29303,	29304,	29309,	29306,	29307,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardC,'@slotC[rand(0,12)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,4879,	29436,	4876;
							set '@cardB,'@slotB[rand(0,2)];
						break; /* 第2スロット終了 */
						/*4-2*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainC['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
				/* 鎧終了 */}
/*---------------------------------------------------------------------------------*/
			/* 肩開始 */
			setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種
				switch(select(
				"やめる",
				""+getitemname('@mainD[0])+"["+getiteminfo('@mainD[0],10)+"]",
				""+getitemname('@mainD[1])+"["+getiteminfo('@mainD[1],10)+"]",
				""+getitemname('@mainD[2])+"["+getiteminfo('@mainD[2],10)+"]",
				""+getitemname('@mainD[3])+"["+getiteminfo('@mainD[3],10)+"]",
				""+getitemname('@mainD[4])+"["+getiteminfo('@mainD[4],10)+"]",
				""+getitemname('@mainD[5])+"["+getiteminfo('@mainD[5],10)+"]",
				""+getitemname('@mainD[6])+"["+getiteminfo('@mainD[6],10)+"]",
				""+getitemname('@mainD[7])+"["+getiteminfo('@mainD[7],10)+"]",
				""+getitemname('@mainD[8])+"["+getiteminfo('@mainD[8],10)+"]",
				""+getitemname('@mainD[9])+"["+getiteminfo('@mainD[9],10)+"]",
				""+getitemname('@mainD[10])+"["+getiteminfo('@mainD[10],10)+"]",
				""+getitemname('@mainD[11])+"["+getiteminfo('@mainD[11],10)+"]",
				""+getitemname('@mainD[12])+"["+getiteminfo('@mainD[12],10)+"]",
				""+getitemname('@mainD[13])+"["+getiteminfo('@mainD[13],10)+"]",
				"靴を選ぶ")) {/*5-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	break;	/*5-1*/}

				if('@EQ <= 13) {/* 肩開始 */
					/* 初期設定 */
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* 初期設定 */

					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*5-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,11)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,10)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,27408,	27409,	27410,	27411;
							set '@cardB,'@slotB[rand(0,3)];
						break; /* 第2スロット終了 */
						/*5-2*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainD['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
				/* 肩終了 */}
/*---------------------------------------------------------------------------------*/
			/* 靴開始 */
			setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種
				switch(select(
				"やめる",
				""+getitemname('@mainE[0])+"["+getiteminfo('@mainE[0],10)+"]",
				""+getitemname('@mainE[1])+"["+getiteminfo('@mainE[1],10)+"]",
				""+getitemname('@mainE[2])+"["+getiteminfo('@mainE[2],10)+"]",
				""+getitemname('@mainE[3])+"["+getiteminfo('@mainE[3],10)+"]",
				""+getitemname('@mainE[4])+"["+getiteminfo('@mainE[4],10)+"]",
				""+getitemname('@mainE[5])+"["+getiteminfo('@mainE[5],10)+"]",
				""+getitemname('@mainE[6])+"["+getiteminfo('@mainE[6],10)+"]",
				""+getitemname('@mainE[7])+"["+getiteminfo('@mainE[7],10)+"]",
				""+getitemname('@mainE[8])+"["+getiteminfo('@mainE[8],10)+"]",
				""+getitemname('@mainE[9])+"["+getiteminfo('@mainE[9],10)+"]",
				""+getitemname('@mainE[10])+"["+getiteminfo('@mainE[10],10)+"]",
				""+getitemname('@mainE[11])+"["+getiteminfo('@mainE[11],10)+"]",
				""+getitemname('@mainE[12])+"["+getiteminfo('@mainE[12],10)+"]",
				""+getitemname('@mainE[13])+"["+getiteminfo('@mainE[13],10)+"]")) {/*6-1*/
				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;	/*6-1*/}

				if('@EQ <= 13) {/* 靴開始 */
					/* 初期設定 */
					set '@refA,8;					//'@slotAの精錬値条件(8以上)初期条件
					set '@refB,9;					//'@slotBの精錬値条件(9以上)
					set '@refC,10;					//'@slotCの精錬値条件(10以上)
					set '@refD,99;					//'@slotDの精錬値条件(未使用)
					set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
					/* 初期設定 */

					/* エンチャント基本条件 */
					if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] を装備して下さい";	close;	}
					if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]を1つ装備して下さい";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					/* エンチャント基本条件 */

					/* 引き継ぎ設定 */
					set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
					set '@cardA,getequipcardid('@pos,0);	/* ■□□□ */
					set '@cardB,getequipcardid('@pos,1);	/* □■□□ */
					set '@cardC,getequipcardid('@pos,2);	/* □□■□ */
					set '@cardD,getequipcardid('@pos,3);	/* □□□■ */
					/* 引き継ぎ設定 */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"] ";
					mes "ですね？";
					mes "それではエンチャントしたい";
					mes "スロットを選んで下さい。";
					next;
					switch(select(
						"やめる",
						"第4スロットにエンチャント",
						"第3スロットにエンチャント",
						"第2スロットにエンチャント")) {/*6-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

						case 2: /* 第4スロット開始 */
							setarray '@slotD,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,7)];
						break; /* 第4スロット終了 */

						case 3: /* 第3スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
							setarray '@slotC,310193,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,6)];
						break; /* 第3スロット終了 */

						case 4: /* 第2スロット開始 */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
							setarray '@slotB,29591,	29591;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* 第2スロット終了 */
						/*6-2*/}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainE['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
				/* 靴終了 */}

			case 2:
				mes "[" +strnpcinfo(1)+ "]";
				mes "精錬値でエンチャントできるスロットが増えます。";
				mes "エンチャントは必ず成功します。";
				mes "エンチャント内容は抽選で決まります。";
				mes "エンチャントは上書きされます。";
				close;

			case 3:
				mes "[" +strnpcinfo(1)+ "]";
				mes "ご利用お待ちしています。";
				mes "2-0 末端";
				close;
			/*2-0*/}

	case 3:	break;
		close;
	/*1-0*/}
/*0-0*/}