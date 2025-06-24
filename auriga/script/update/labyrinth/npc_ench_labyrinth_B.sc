//2025/06/24 アップデート
//夢幻の迷宮 迷宮調査団キャンプ ラビリンスエンチャント

lby_in.gat,63,93,4	script	宮廷魔術師の助手#32217	893,{

		//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;		//武15種
		//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種
		//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種
		//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種
		//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種
		//setarray '@mainF,	460002;		//盾1種
		//setarray '@mainG,	19347,	15277,	20917,	22187;	//ドラム
		
	mes "["+strnpcinfo(1)+"]";
	mes "私は特定の武具に";
	mes "超越ラビリンスエンチャントが出来ます。";
	mes "今日はどのようなご用件ですか？";
	next;
	switch(select(
	"超越更新をする",
	"超越済みエンチャント",
	"話をやめる")) {

	case 1:	/* 超越更新をする */
		/* 初期設定 */
		set '@costAid,783;
		set '@costAnum,100;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}
		/* 初期設定 */
		
		/* サモナー装備は別枠 */
		setarray '@mainG,	19347,	15277,	20917,	22187;
		/* サモナー装備は別枠 */

		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@costAid)+" を "+'@costAnum+" 個消費して";
		mes "+10 職業パッケージ装備に";
		mes "超越更新しエンチャントしますか？";
		next;
		if(select("エンチャントする","やめる") == 2) {	mes "["+strnpcinfo(1)+"]";	mes "ご利用お待ちしています。";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes "装備部位を選んで下さい";
		next;
		switch(select(
			"やめる",
			"武器 第3スロット",
			"頭 第1スロット",
			"鎧 第4スロット",
			"肩 第1スロット",
			"靴 第1スロット",
			"盾 第1スロット",
			""+getitemname('@mainG[0])+"",
			""+getitemname('@mainG[1])+"",
			""+getitemname('@mainG[2])+"",
			""+getitemname('@mainG[3])+"")) {/*超越開始*/

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

			case 2: /*武器超越*/
			setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;	//武15種
			setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0;	//短剣片手剣片手斧
				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,4;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する
				set '@limpos,2;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainA[0])+"",
				""+getitemname('@mainA[1])+"",
				""+getitemname('@mainA[2])+"",
				""+getitemname('@mainA[3])+"",
				""+getitemname('@mainA[4])+"",
				""+getitemname('@mainA[5])+"",
				""+getitemname('@mainA[6])+"",
				""+getitemname('@mainA[7])+"",
				""+getitemname('@mainA[8])+"",
				""+getitemname('@mainA[9])+"",
				""+getitemname('@mainA[10])+"",
				""+getitemname('@mainA[11])+"",
				""+getitemname('@mainA[12])+"",
				""+getitemname('@mainA[13])+"",
				""+getitemname('@mainA[14])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;
					case 16: set '@EQ,14;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] を装備して下さい";	close;	}
				if(getitemid(getequipname(3)) == '@Lefthand['@EQ])	{ mes ""+getitemname('@Lefthand['@EQ])+" は左手に装備しないで下さい。";	close;	}
				if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,0;				/* □□□■ 第4スロット初期化*/
				set '@cardC,310323;			/* □□■□ 第3スロット 310323 固定 */
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/

				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*武器超越*/
			case 3:	/*頭超越*/
			setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種

				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//エンチャントIDを '@cardA に指定して2度付け制限する			A B C D
				set '@limpos,0;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainB[0])+"",
				""+getitemname('@mainB[1])+"",
				""+getitemname('@mainB[2])+"",
				""+getitemname('@mainB[3])+"",
				""+getitemname('@mainB[4])+"",
				""+getitemname('@mainB[5])+"",
				""+getitemname('@mainB[6])+"",
				""+getitemname('@mainB[7])+"",
				""+getitemname('@mainB[8])+"",
				""+getitemname('@mainB[9])+"",
				""+getitemname('@mainB[10])+"",
				""+getitemname('@mainB[11])+"",
				""+getitemname('@mainB[12])+"",
				""+getitemname('@mainB[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;			/* 精錬値 +7 */
				set '@cardD,0;			/* □□□■ 第4スロット初期化*/
				set '@cardC,0;			/* □□■□ 第3スロット初期化*/
				set '@cardB,0;			/* □■□□ 第2スロット初期化*/
				set '@cardA,310323;		/* ■□□□ 第1スロット310323 固定 */
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*頭超越*/
			case 4:	/*鎧超越*/
			setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種

				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する			A B C D
				set '@limpos,3;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainC[0])+"",
				""+getitemname('@mainC[1])+"",
				""+getitemname('@mainC[2])+"",
				""+getitemname('@mainC[3])+"",
				""+getitemname('@mainC[4])+"",
				""+getitemname('@mainC[5])+"",
				""+getitemname('@mainC[6])+"",
				""+getitemname('@mainC[7])+"",
				""+getitemname('@mainC[8])+"",
				""+getitemname('@mainC[9])+"",
				""+getitemname('@mainC[10])+"",
				""+getitemname('@mainC[11])+"",
				""+getitemname('@mainC[12])+"",
				""+getitemname('@mainC[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,310323;			/* □□□■ 第4スロット310323 固定 */
				set '@cardC,0;				/* □□■□ 第3スロット初期化*/
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*鎧超越*/
			case 5:	/*肩超越*/
			setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種

				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//エンチャントIDを '@cardA に指定して2度付け制限する			A B C D
				set '@limpos,0;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainD[0])+"",
				""+getitemname('@mainD[1])+"",
				""+getitemname('@mainD[2])+"",
				""+getitemname('@mainD[3])+"",
				""+getitemname('@mainD[4])+"",
				""+getitemname('@mainD[5])+"",
				""+getitemname('@mainD[6])+"",
				""+getitemname('@mainD[7])+"",
				""+getitemname('@mainD[8])+"",
				""+getitemname('@mainD[9])+"",
				""+getitemname('@mainD[10])+"",
				""+getitemname('@mainD[11])+"",
				""+getitemname('@mainD[12])+"",
				""+getitemname('@mainD[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;			/* 精錬値 +7 */
				set '@cardD,0;			/* □□□■ 第4スロット初期化*/
				set '@cardC,0;			/* □□■□ 第3スロット初期化*/
				set '@cardB,0;			/* □■□□ 第2スロット初期化*/
				set '@cardA,310323;		/* ■□□□ 第1スロット310323 固定 */
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*鎧超越*/
			case 6:	/*靴超越*/
			setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種

				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//エンチャントIDを '@cardA に指定して2度付け制限する			A B C D
				set '@limpos,0;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainE[0])+"",
				""+getitemname('@mainE[1])+"",
				""+getitemname('@mainE[2])+"",
				""+getitemname('@mainE[3])+"",
				""+getitemname('@mainE[4])+"",
				""+getitemname('@mainE[5])+"",
				""+getitemname('@mainE[6])+"",
				""+getitemname('@mainE[7])+"",
				""+getitemname('@mainE[8])+"",
				""+getitemname('@mainE[9])+"",
				""+getitemname('@mainE[10])+"",
				""+getitemname('@mainE[11])+"",
				""+getitemname('@mainE[12])+"",
				""+getitemname('@mainE[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] を装備して下さい";	close; }
				if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;			/* 精錬値 +7 */
				set '@cardD,0;			/* □□□■ 第4スロット初期化*/
				set '@cardC,0;			/* □□■□ 第3スロット初期化*/
				set '@cardB,0;			/* □■□□ 第2スロット初期化*/
				set '@cardA,310323;		/* ■□□□ 第1スロット310323 固定 */
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*靴超越*/
			case 7:	/*盾超越*/
			setarray '@mainF,	460002;		//盾

				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,3;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//エンチャントIDを '@cardA に指定して2度付け制限する			A B C D
				set '@limpos,0;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainF[0])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainF['@EQ])+" ["+getiteminfo('@mainF['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainF['@EQ]) != 1)		{ mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;			/* 精錬値 +7 */
				set '@cardD,0;			/* □□□■ 第4スロット初期化*/
				set '@cardC,0;			/* □□■□ 第3スロット初期化*/
				set '@cardB,0;			/* □■□□ 第2スロット初期化*/
				set '@cardA,310323;		/* ■□□□ 第1スロット310323 固定 */
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainF['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*盾超越*/

			case 8: /*頭 19347 抱きつきシャム猫[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する			A B C D
				set '@limpos,3;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainG[0])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,0;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,310323;			/* □□□■ 第4スロット310323 固定 */
				set '@cardC,0;				/* □□■□ 第3スロット初期化*/
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*頭 19347 抱きつきシャム猫[1]*/

			case 9: /*鎧 15277 特選ドラムスーツ[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する			A B C D
				set '@limpos,3;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainG[1])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,1;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,310323;			/* □□□■ 第4スロット310323 固定 */
				set '@cardC,0;				/* □□■□ 第3スロット初期化*/
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*鎧 15277 特選ドラムスーツ[1]*/

			case 10: /*肩 20917 特選ドラムケープ[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する			A B C D
				set '@limpos,3;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainG[2])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,2;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,310323;			/* □□□■ 第4スロット310323 固定 */
				set '@cardC,0;				/* □□■□ 第3スロット初期化*/
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*肩 20917 特選ドラムケープ[1]*/

			case 11: /*靴 22187 特選ドラムシューズ[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* 初期設定 */
				set '@refD,10;					//'@slotDの精錬値条件
				set '@refC,99;					//'@slotCの精錬値条件
				set '@refB,99;					//'@slotBの精錬値条件
				set '@refA,99;					//'@slotAの精錬値条件
				set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//エンチャントIDを '@cardD に指定して2度付け制限する			A B C D
				set '@limpos,3;					//エンチャントカードスロットを '@limpos に指定して2度付け制限する	0 1 2 3
				/* 初期設定 */

			switch(select(
				"やめる",
				""+getitemname('@mainG[3])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
					case 2: set '@EQ,3;	break;	}

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "すでに超越がついています。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,7;				/* 精錬値 +7 */
				set '@cardD,310323;			/* □□□■ 第4スロット310323 固定 */
				set '@cardC,0;				/* □□■□ 第3スロット初期化*/
				set '@cardB,0;				/* □■□□ 第2スロット初期化*/
				set '@cardA,getequipcardid('@pos,0);	/* ■□□□ 第1スロット引き継ぎ*/
				/* 引き継ぎ設定 */

				/* アイテム入手開始 */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK、成功しました。";
				mes "おめでとうございます。";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "それではまた、ご利用下さい。";
				close;
				/* アイテム入手終了 */
				/*靴 22187 特選ドラムシューズ[1]*/
			/*超越終了*/}

	case 2:
	//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;		//武15種
	//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種
	//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種
	//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種
	//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種
	//setarray '@mainF,	460002;		//盾1種

		/* 初期設定 */
		set '@costAid,783;
		set '@costAnum,10;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" が "+'@costAnum+" 個必要です";	close;	}
		/* 初期設定 */
		
		/* サモナー装備は別枠 */
		setarray '@mainG,	19347,	15277,	20917,	22187;
		/* サモナー装備は別枠 */

	mes "[" +strnpcinfo(1)+ "]";
	mes "装備部位を選んだ下さい";
	next;
	switch(select(
		"やめる",
		"武器 第2 4スロット",
		"頭 第2 3 4スロット",
		"鎧 第2 3スロット",
		"肩 第2 3 4スロット",
		"靴 第2 3 4スロット",
		"盾 第2 3 4スロット",
		""+getitemname('@mainG[0])+"",
		""+getitemname('@mainG[1])+"",
		""+getitemname('@mainG[2])+"",
		""+getitemname('@mainG[3])+"")) {
		case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

		case 2:
		setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;	//武15種
		setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0;	//短剣片手剣片手斧の左手判定

		switch(select(
			"やめる",
			""+getitemname('@mainA[0])+"",
			""+getitemname('@mainA[1])+"",
			""+getitemname('@mainA[2])+"",
			""+getitemname('@mainA[3])+"",
			""+getitemname('@mainA[4])+"",
			""+getitemname('@mainA[5])+"",
			""+getitemname('@mainA[6])+"",
			""+getitemname('@mainA[7])+"",
			""+getitemname('@mainA[8])+"",
			""+getitemname('@mainA[9])+"",
			""+getitemname('@mainA[10])+"",
			""+getitemname('@mainA[11])+"",
			""+getitemname('@mainA[12])+"",
			""+getitemname('@mainA[13])+"",
			""+getitemname('@mainA[14])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;
				case 16: set '@EQ,14;	break;	}

				/* 初期設定 */
				set '@refD,9;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,99;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,4;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardC,310323;				//第3スロットは常に310323
				set '@limpos,2;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,1;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,0;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント",
					"第3スロットにエンチャント できません",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {

					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;
					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4709,	4739,	4749,	4719,	4729,	4759,	29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697,	4853,	4856,	4857,	4854,	4855,	4858,	29368,	29447,	29588,	29590;
					set '@cardD,'@slotD[rand(0,23)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardC,'@slotC[rand(0,6)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,4879,	4875,	4876,	29436,	29509,	29371;
					set '@cardB,'@slotB[rand(0,5)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 3:
		setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//頭14種
		switch(select(
			"やめる",
			""+getitemname('@mainB[0])+"",
			""+getitemname('@mainB[1])+"",
			""+getitemname('@mainB[2])+"",
			""+getitemname('@mainB[3])+"",
			""+getitemname('@mainB[4])+"",
			""+getitemname('@mainB[5])+"",
			""+getitemname('@mainB[6])+"",
			""+getitemname('@mainB[7])+"",
			""+getitemname('@mainB[8])+"",
			""+getitemname('@mainB[9])+"",
			""+getitemname('@mainB[10])+"",
			""+getitemname('@mainB[11])+"",
			""+getitemname('@mainB[12])+"",
			""+getitemname('@mainB[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* 初期設定 */
				set '@refD,9;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//第1スロットは常に310323
				set '@limpos,0;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,1;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
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
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,29214,	29215,	29216,	29217,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,21)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222,	310319,	4881,	29374,	29373,	27412,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardC,'@slotC[rand(0,25)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,4879,	4876,	29436,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */


		case 4:
		setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//鎧14種
		switch(select(
			"やめる",
			""+getitemname('@mainC[0])+"",
			""+getitemname('@mainC[1])+"",
			""+getitemname('@mainC[2])+"",
			""+getitemname('@mainC[3])+"",
			""+getitemname('@mainC[4])+"",
			""+getitemname('@mainC[5])+"",
			""+getitemname('@mainC[6])+"",
			""+getitemname('@mainC[7])+"",
			""+getitemname('@mainC[8])+"",
			""+getitemname('@mainC[9])+"",
			""+getitemname('@mainC[10])+"",
			""+getitemname('@mainC[11])+"",
			""+getitemname('@mainC[12])+"",
			""+getitemname('@mainC[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* 初期設定 */
				set '@refD,99;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//第4スロットは常に310323
				set '@limpos,3;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,0;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント できません",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,29214,	29215,	29216,	29217,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,21)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29649,	29650,	29305,	29302,	29303,	29304,	29309,	29306,	29307,	29308,	310320,	4853,	4856,	4857,	4854,	4855,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,24)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,4879,	29436,	4876,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 5:
		setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//肩14種
		switch(select(
			"やめる",
			""+getitemname('@mainD[0])+"",
			""+getitemname('@mainD[1])+"",
			""+getitemname('@mainD[2])+"",
			""+getitemname('@mainD[3])+"",
			""+getitemname('@mainD[4])+"",
			""+getitemname('@mainD[5])+"",
			""+getitemname('@mainD[6])+"",
			""+getitemname('@mainD[7])+"",
			""+getitemname('@mainD[8])+"",
			""+getitemname('@mainD[9])+"",
			""+getitemname('@mainD[10])+"",
			""+getitemname('@mainD[11])+"",
			""+getitemname('@mainD[12])+"",
			""+getitemname('@mainD[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* 初期設定 */
				set '@refD,9;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//第1スロットは常に310323
				set '@limpos,0;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,1;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
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
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardD,'@slotD[rand(0,19)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardC,'@slotC[rand(0,11)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,27408,	27409,	27410,	27411,	311066,	311067,	311068,	311065;
					set '@cardB,'@slotB[rand(0,7)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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
		case 6:
		setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//靴14種
		switch(select(
			"やめる",
			""+getitemname('@mainE[0])+"",
			""+getitemname('@mainE[1])+"",
			""+getitemname('@mainE[2])+"",
			""+getitemname('@mainE[3])+"",
			""+getitemname('@mainE[4])+"",
			""+getitemname('@mainE[5])+"",
			""+getitemname('@mainE[6])+"",
			""+getitemname('@mainE[7])+"",
			""+getitemname('@mainE[8])+"",
			""+getitemname('@mainE[9])+"",
			""+getitemname('@mainE[10])+"",
			""+getitemname('@mainE[11])+"",
			""+getitemname('@mainE[12])+"",
			""+getitemname('@mainE[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* 初期設定 */
				set '@refD,9;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//第1スロットは常に310323
				set '@limpos,0;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,1;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
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
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,13)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,310193,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardC,'@slotC[rand(0,12)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,29591,	29509,	29371;
					set '@cardB,'@slotB[rand(0,2)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 7:
		setarray '@mainF,	460002;		//盾1種
		switch(select(
			"やめる",
			""+getitemname('@mainF[0])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;	}

				/* 初期設定 */
				set '@refD,9;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,3;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardA,310323;				//第1スロットは常に310323
				set '@limpos,0;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,1;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainF['@EQ])+" ["+getiteminfo('@mainF['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainF['@EQ]) != 1)		{ mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4881,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardD,'@slotD[rand(0,13)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29373,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardC,'@slotC[rand(0,13)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,310193,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardB,'@slotB[rand(0,6)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainF['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
		case 8:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"やめる",
			""+getitemname('@mainG[0])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,0;	break;}

				/* 初期設定 */
				set '@refD,99;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,1;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//第4スロットは常に310323
				set '@limpos,3;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,0;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント できません",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	4879,	4876,	29436,	29509,	29371;
					set '@cardC,'@slotC[rand(0,18)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,27402,	27402,	27402,	27402,	27402,	27402,	27402;
					set '@cardB,'@slotB[rand(0,6)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
		case 9:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"やめる",
			""+getitemname('@mainG[1])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,1;	break;}

				/* 初期設定 */
				set '@refD,99;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,2;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//第4スロットは常に310323
				set '@limpos,3;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,0;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント できません",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29649,	29650,	29305,	29302,	29303,	29304,	29309,	29306,	29307,	29308,	310320,	4853,	4856,	4857,	4854,	4855,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,24)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,4879,	29436,	4876,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */

		case 10:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"やめる",
			""+getitemname('@mainG[2])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,2;	break;}

				/* 初期設定 */
				set '@refD,99;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,5;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//第4スロットは常に310323
				set '@limpos,3;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,0;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント できません",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29649,	29650,	27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	27412;
					set '@cardC,'@slotC[rand(0,19)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,27408,	27409,	27410,	27411,	311066,	311067,	311068,	311065;
					set '@cardB,'@slotB[rand(0,7)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
		case 11:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"やめる",
			""+getitemname('@mainG[3])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "ご利用お待ちしています"; close;
				case 2: set '@EQ,3;	break;}

				/* 初期設定 */
				set '@refD,99;					//□□□■ '@slotD 第4スロット 精錬値条件
				set '@refC,9;					//□□■□ '@slotC 第3スロット 精錬値条件
				set '@refB,10;					//□■□□ '@slotB 第2スロット 精錬値条件
				set '@refA,99;					//■□□□ '@slotA 第1スロット 精錬値条件
				set '@pos,6;					//頭上1	頭中9	頭下10	鎧2	左盾3	右武4	肩5	靴6	左ア(1)7	右ア(2)8
				set '@cardD,310323;				//第4スロットは常に310323
				set '@limpos,3;					//エンチャント '@limpos カード存在を設定	0 1 2 3
				/* スロット別エンチャント可否 */		//A B C D
				set '@noslotD,0;				//□□□■ エンチャント可:1 否:0 第4スロット
				set '@noslotC,1;				//□□■□ エンチャント可:1 否:0 第3スロット
				set '@noslotB,1;				//□■□□ エンチャント可:1 否:0 第2スロット
				set '@noslotA,0;				//■□□□ エンチャント可:1 否:0 第1スロット
				/* 初期設定 */

				/* エンチャント基本条件 */
				if(getequipisequiped('@pos) == 0) 		{ mes "指定部位に "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] を装備して下さい";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]を1つ装備して下さい";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "超越がついてません。";	close;	}
				/* エンチャント基本条件 */

				/* 引き継ぎ設定 */
				set '@ref,getequiprefinerycnt('@pos);	/* 精錬値を引き継ぐ */
				set '@cardD,getequipcardid('@pos,3);	/* カードを引き継ぐ□□□■ */
				set '@cardC,getequipcardid('@pos,2);	/* カードを引き継ぐ□□■□ */
				set '@cardB,getequipcardid('@pos,1);	/* カードを引き継ぐ□■□□ */
				set '@cardA,getequipcardid('@pos,0);	/* カードを引き継ぐ■□□□ */
				/* 引き継ぎ設定 */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "ですね？";
				mes "それではエンチャントしたい";
				mes "スロットを選んで下さい。";
				next;
				switch(select(
					"やめる",
					"第4スロットにエンチャント できません",
					"第3スロットにエンチャント",
					"第2スロットにエンチャント",
					"第1スロットにエンチャント できません")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "ご利用お待ちしています";	close;

					case 2: /* 第4スロット開始 */
					if('@noslotD == 0) {	mes "第4スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "精錬値 "+'@refD+" 以上から利用できます";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* 第4スロット終了 */

					case 3: /* 第3スロット開始 */
					if('@noslotC == 0) {	mes "第3スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "精錬値 "+'@refC+" 以上から利用できます";	close;	}
					setarray '@slotC,29649,	29650,	310193,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,25)];
					break; /* 第3スロット終了 */

					case 4: /* 第2スロット開始 */
					if('@noslotB == 0) {	mes "第2スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "精錬値 "+'@refB+" 以上から利用できます";	close;	}
					setarray '@slotB,29591,	29509,	29371;
					set '@cardB,'@slotB[rand(0,2)];
					break; /* 第2スロット終了 */

					case 5: /* 第1スロット開始 */
					if('@noslotA == 0) {	mes "第1スロットには";	mes "エンチャントできません。";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "精錬値 "+'@refA+" 以上から利用できます";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* 第1スロット終了 */
					}

					/* アイテム入手開始 */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK、成功しました。";
					mes "おめでとうございます。";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "それではまた、ご利用下さい。";
					close;
					/* アイテム入手終了 */
		}
	case 3:
		mes "["+strnpcinfo(1)+"]";
		mes "ご利用お待ちしています。";
		close;
	}
}