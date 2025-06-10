//2025/06/10 アップデート
//スペシャルアイテムのチケット交換NPC
//イベントなどの一時的な要素ではなく恒久的な要素です
//利用回数保存フラグ必要

//管理用NPC開始

izlude.gat,143,150,3	shop	管理用チケット販売		10545,1002223,1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200


//izlude.gat,142,142,3	script	管理用チケットNPC	70,{

-	script	CashTicketExchange	{
	
	mes "["+strnpcinfo(1)+"]";
	mes "消しました";
	clearitem;
	gmcommand "@itemreset";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002199)+"入手";
	getitem 1002199,1;
	getitem 1002200,1;
	getitem 1002223,1;
	close;
}
izlude.gat,143,150,3	duplicate(CashTicketExchange)	TicketSeller	70
//prontera.gat,150,160,2	duplicate(CashTicketExchange)	TicketSeller	70

//管理用NPCここまで

izlude.gat,150,142,3	script	ミスティア	91,{

	setarray '@main[0],1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200;

	if((Weight*100/MaxWeight) > 50) { mes "["+strnpcinfo(1)+"]"; mes "所持重量を50%以上空けて下さい。"; close; }

	mes "["+strnpcinfo(1)+"]";
	mes "各種チケットの引換を";
	mes "担当しております。";
	mes "本日はいかがなさいますか？";
	next;
	switch(select(
		"やめる",
		""+getitemname('@main[0])+"",
		""+getitemname('@main[1])+"",
		""+getitemname('@main[2])+"",
		""+getitemname('@main[3])+"",
		""+getitemname('@main[4])+"",
		""+getitemname('@main[5])+"",
		""+getitemname('@main[6])+"",
		""+getitemname('@main[7])+"",
		""+getitemname('@main[8])+"",
		""+getitemname('@main[9])+"",
		""+getitemname('@main[10])+"",
		""+getitemname('@main[11])+"",
		""+getitemname('@main[12])+"",
		""+getitemname('@main[13])+"",
		""+getitemname('@main[14])+" 実装",
		""+getitemname('@main[15])+" 実装",
		"クエストボーナスAチケット追加報酬")) {

	case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
	case 2:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 3:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 4:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 5:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 6:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 7:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 8:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 9:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 10:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 11:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 12:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 13:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 14:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;
	case 15:	mes "["+strnpcinfo(1)+"]"; mes "今後実装予定";	close;

	/* 4次職・拡張4次職ボーナスチケット */
	case 16:
	setarray '@itemA[0],1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221;
	setarray '@itemB[0],1002201,1002202,1002203,1002206,1002204,1002205,1002208,1002209,1002210,1002211,1002207,1002212,1002213,1002217,1002214,1002216,1002216,1002215,1002219,1002218;
	set '@limA,14374;

		if(countitem('@main[14]) == 0) {	mes ""+getitemname('@main[14])+"が";	mes "1個必要です";	close; }
		mes ""+getitemname('@main[14])+"は";
		mes "選択した職業の交換回数によって";
		mes "受け取るアイテムが異なります";
		mes "※交換回数はゲームアカウント内で共通です。";
		mes "※蜃気楼と不知火は交換回数が共通です";
		mes "_";
		mes "※交換回数要素は未実装です";
		next;
		mes "^ff0000●1回目の交換";
		mes ""+getitemname('@itemA[0])+"1個、";
		mes "選択した職業のクエストボーナスAチケット 1個";
		mes "_";
		mes "・対応職業";
		mes "ドラゴンナイト";
		mes "アークメイジ";
		mes "ウインドホーク";
		mes "カーディナル";
		mes "マイスター";
		mes "シャドウクロス";
		mes "インペリアルガード";
		mes "エレメンタルマスター";
		mes "トルバドゥール";
		mes "トルヴェール";
		mes "インクイジター";
		mes "バイオロジスト";
		mes "アビスチェイサー";
		mes "天帝";
		mes "ソウルアセティック";
		mes "蜃気楼";
		mes "不知火";
		mes "ナイトウォッチ";
		mes "ハイパーノービス";
		mes "スピリットハンドラー^000000";
		next;
		mes "^ff0000●2回目以降の交換";
		mes ""+getitemname('@limA)+"1個^000000";
		next;
		mes "["+strnpcinfo(1)+"]";
		mes "どの職業にしますか？";
		next;
		switch(select(
			"やめる",
			"ドラゴンナイト（交換 FLAG 回目）",
			"アークメイジ（交換 FLAG 回目）",
			"ウインドホーク（交換 FLAG 回目）",
			"カーディナル（交換 FLAG 回目）",
			"マイスター（交換 FLAG 回目）",
			"シャドウクロス（交換 FLAG 回目）",
			"インペリアルガード（交換 FLAG 回目）",
			"エレメンタルマスター（交換 FLAG 回目）",
			"トルバドゥール（交換 FLAG 回目）",
			"トルヴェール（交換 FLAG 回目）",
			"インクイジター（交換 FLAG 回目）",
			"バイオロ（交換 FLAG 回目）",
			"アビスチェイサー（交換 FLAG 回目）",
			"天帝（交換 FLAG 回目）",
			"ソウルアセティック（交換 FLAG 回目）",
			"蜃気楼（交換 FLAG 回目）",
			"不知火（交換 FLAG 回目）",
			"ナイトウォッチ（交換 FLAG 回目）",
			"ハイパーノービス（交換 FLAG 回目）",
			"スピリットハンドラー（交換 FLAG 回目）")) {

			case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
			case 2:	set '@itemC,'@itemA[0];	set '@itemD,'@itemB[0];	break;
			case 3:	set '@itemC,'@itemA[1];	set '@itemD,'@itemB[1];	break;
			case 4:	set '@itemC,'@itemA[2];	set '@itemD,'@itemB[2];	break;
			case 5:	set '@itemC,'@itemA[3];	set '@itemD,'@itemB[3];	break;
			case 6:	set '@itemC,'@itemA[4];	set '@itemD,'@itemB[4];	break;
			case 7:	set '@itemC,'@itemA[5];	set '@itemD,'@itemB[5];	break;
			case 8:	set '@itemC,'@itemA[6];	set '@itemD,'@itemB[6];	break;
			case 9:	set '@itemC,'@itemA[7];	set '@itemD,'@itemB[7];	break;
			case 10:	set '@itemC,'@itemA[8];	set '@itemD,'@itemB[8];	break;
			case 11:	set '@itemC,'@itemA[9];	set '@itemD,'@itemB[9];	break;
			case 12:	set '@itemC,'@itemA[10];	set '@itemD,'@itemB[10];	break;
			case 13:	set '@itemC,'@itemA[11];	set '@itemD,'@itemB[11];	break;
			case 14:	set '@itemC,'@itemA[12];	set '@itemD,'@itemB[12];	break;
			case 15:	set '@itemC,'@itemA[13];	set '@itemD,'@itemB[13];	break;
			case 16:	set '@itemC,'@itemA[14];	set '@itemD,'@itemB[14];	break;
			case 17:	set '@itemC,'@itemA[15];	set '@itemD,'@itemB[15];	break;
			case 18:	set '@itemC,'@itemA[16];	set '@itemD,'@itemB[16];	break;
			case 19:	set '@itemC,'@itemA[17];	set '@itemD,'@itemB[17];	break;
			case 20:	set '@itemC,'@itemA[18];	set '@itemD,'@itemB[18];	break;
			case 21:	set '@itemC,'@itemA[19];	set '@itemD,'@itemB[19];	break;
			}
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[14])+"を";
			mes "1個消費して";
			mes ""+getitemname('@itemC)+"";
			mes ""+getitemname('@itemD)+"";
			mes "受け取ります。";
			mes "交換してもよろしいですか？";
			next;
			switch(select(
				"やめる",
				"交換する")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				/* set FLAG_CAA,FLAG_CAA + 1; */
				getitem '@itemC,1;	getitem '@itemD,1;	delitem '@main[14],1;
				mes "["+strnpcinfo(1)+"]";
				mes "交換しました";
				close;
		}

	/* セレスティアルシリーズ装備セットチケット */
	case 17:
		if(countitem('@main[15]) == 0) {	mes ""+getitemname('@main[15])+"が";	mes "1個必要です";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@main[15])+"";
		mes "を1個で";
		mes "「ドラゴンナイト」セット";
		mes "「アークメイジ」セット";
		mes "「ウインドホーク」セット";
		mes "「カーディナル」セット";
		mes "「マイスター」セット";
		mes "「シャドウクロス」セット";
		mes "「インペリアルガード」セット";
		mes "「エレメンタルマスター」セット";
		mes "「トルバドゥール」セット";
		mes "「トルヴェール」セット";
		mes "「インクイジター」セット";
		mes "「バイオロ」セット";
		mes "「アビスチェイサー」セット";
		mes "「天帝」セット";
		mes "「ソウルアセティック」セット";
		mes "「蜃気楼・不知火」セット";
		mes "「ナイトウォッチ」セット";
		mes "「ハイパーノービス」セット";
		mes "「スピリットハンドラー」セット";
		mes "のどれか1セットと交換します。";
		next;
		mes "["+strnpcinfo(1)+"]";
		mes "どの職業セットと交換しますか？";
		next;
		switch(select(
			"やめる",
			"ドラゴンナイト",
			"アークメイジ",
			"ウインドホーク",
			"カーディナル",
			"マイスター",
			"シャドウクロス",
			"インペリアルガード",
			"エレメンタルマスター",
			"トルバドゥール",
			"トルヴェール",
			"インクイジター",
			"バイオロ",
			"アビスチェイサー",
			"天帝",
			"ソウルアセティック",
			"蜃気楼・不知火",
			"ナイトウォッチ",
			"ハイパーノービス",
			"スピリットハンドラー")) {
			case 1:	mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
			case 2:	/*ドラゴンナイト*/
				mes "["+strnpcinfo(1)+"]";
				mes "ドラゴンナイトですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","ドラゴンナイトⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 630056,1,1,4,0,0,4853,314138,311899,0;
				getitem2 400907,1,1,4,0,0,29436,314138,312040,0;
				getitem2 450462,1,1,4,0,0,29307,314138,0,0;
				getitem2 480592,1,1,4,0,0,314165,314138,0,0;
				getitem2 470351,1,1,4,0,0,29509,314138,0,0;
				getitem2 490745,1,1,0,0,0,29649,314138,312949,0;	break;
				case 3:	break;	}
				break;
			case 3:	/*アークメイジ*/
				mes "["+strnpcinfo(1)+"]";
				mes "アークメイジですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","アークメイジⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 640063,1,1,4,0,0,4856,314117,311891,0;
				getitem2 400907,1,1,4,0,0,4876,314117,312031,0;
				getitem2 450462,1,1,4,0,0,29307,314117,0,0;
				getitem2 480592,1,1,4,0,0,314165,314117,0,0;
				getitem2 470351,1,1,4,0,0,29371,314117,0,0;
				getitem2 490745,1,1,0,0,0,29650,314117,312473,0;	break;
				case 3:	break;	}
				break;
			case 4:	/*ウインドホーク*/
				mes "["+strnpcinfo(1)+"]";
				mes "ウインドホークですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","ウインドホークⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314126,311895,0;
				getitem2 400907,1,1,4,0,0,4879,314126,312036,0;
				getitem2 450462,1,1,4,0,0,29307,314126,0,0;
				getitem2 480592,1,1,4,0,0,314165,314126,0,0;
				getitem2 470351,1,1,4,0,0,29509,314126,0,0;
				getitem2 490745,1,1,0,0,0,29649,314126,312918,0;	break;
				case 3:	break;	}
				break;
			case 5:	/*カーディナル*/
				mes "["+strnpcinfo(1)+"]";
				mes "カーディナルですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","カーディナルⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314130,311897,0;
				getitem2 400907,1,1,4,0,0,4876,314130,312645,0;
				getitem2 450462,1,1,4,0,0,29307,314130,0,0;
				getitem2 480592,1,1,4,0,0,314165,314130,0,0;
				getitem2 470351,1,1,4,0,0,29371,314130,0,0;
				getitem2 490745,1,1,0,0,0,29650,314130,312038,0;	break;
				case 3:	break;	}
				break;
			case 6:	/*マイスター*/
				mes "["+strnpcinfo(1)+"]";
				mes "マイスターですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","マイスターⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 620052,1,1,4,0,0,4853,314151,311903,0;
				getitem2 400907,1,1,4,0,0,29436,314151,312978,0;
				getitem2 450462,1,1,4,0,0,29307,314151,0,0;
				getitem2 480592,1,1,4,0,0,314165,314151,0,0;
				getitem2 470351,1,1,4,0,0,29509,314151,0,0;
				getitem2 490745,1,1,0,0,0,29649,314151,313198,0;	break;
				case 3:	break;	}
				break;
			case 7:	/*シャドウクロス*/
				mes "["+strnpcinfo(1)+"]";
				mes "シャドウクロスですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","シャドウクロスⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 610081,1,1,4,0,0,4853,314132,311898,0;
				getitem2 400907,1,1,4,0,0,29436,314132,313283,0;
				getitem2 450462,1,1,4,0,0,29307,314132,0,0;
				getitem2 480592,1,1,4,0,0,314165,314132,0,0;
				getitem2 470351,1,1,4,0,0,29509,314132,0,0;
				getitem2 490745,1,1,0,0,0,29649,314132,312948,0;	break;
				case 3:	break;	}
				break;
			case 8:	/*インペリアルガード*/
				mes "["+strnpcinfo(1)+"]";
				mes "インペリアルガードですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","インペリアルガードⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 530070,1,1,4,0,0,4853,314124,311894,0;
				getitem2 400907,1,1,4,0,0,29436,314124,312917,0;
				getitem2 450462,1,1,4,0,0,29307,314124,0,0;
				getitem2 480592,1,1,4,0,0,314165,314124,0,0;
				getitem2 470351,1,1,4,0,0,29509,314124,0,0;
				getitem2 490745,1,1,0,0,0,29649,314124,312936,0;	break;
				case 3:	break;	}
				break;
			case 9:	/*エレメンタルマスター*/
				mes "["+strnpcinfo(1)+"]";
				mes "エレメンタルマスターですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","エレメンタルマスターⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4856,314129,311896,0;
				getitem2 400907,1,1,4,0,0,4876,314129,312942,0;
				getitem2 450462,1,1,4,0,0,29307,314129,0,0;
				getitem2 480592,1,1,4,0,0,314165,314129,0,0;
				getitem2 470351,1,1,4,0,0,29371,314129,0,0;
				getitem2 490745,1,1,0,0,0,29650,314129,312303,0;	break;
				case 3:	break;	}
				break;
			case 10: /*トルバドゥール*/
				mes "["+strnpcinfo(1)+"]";
				mes "トルバドゥールですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","トルバドゥールⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 570082,1,1,4,0,0,4857,314141,311900,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,0,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,0,0,0,29649,314141,312952,0;	break;
				case 3:	break;	}
				break;
			case 11: /*トルヴェール*/
				mes "["+strnpcinfo(1)+"]";
				mes "トルヴェールですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","トルヴェールⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 580082,1,1,4,0,0,4857,314141,311901,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,0,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,4,0,0,29649,314141,312952,0;	break;
				case 3:	break;	}
				break;
			case 12: /*インクイジター*/
				mes "["+strnpcinfo(1)+"]";
				mes "インクイジターですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","インクイジターⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 560076,1,1,4,0,0,4853,314122,311893,0;
				getitem2 400907,1,1,4,0,0,29436,314122,312933,0;
				getitem2 450462,1,1,4,0,0,29307,314122,0,0;
				getitem2 480592,1,1,4,0,0,314165,314122,0,0;
				getitem2 470351,1,1,4,0,0,29509,314122,0,0;
				getitem2 490745,1,1,0,0,0,29649,314122,312034,0;	break;
				case 3:	break;	}
				break;
			case 13: /*バイオロ*/
				mes "["+strnpcinfo(1)+"]";
				mes "バイオロですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","バイオロⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 500115,1,1,4,0,0,4853,314145,311902,0;
				getitem2 400907,1,1,4,0,0,29436,314145,312043,0;
				getitem2 450462,1,1,4,0,0,29307,314145,0,0;
				getitem2 480592,1,1,4,0,0,314165,314145,0,0;
				getitem2 470351,1,1,4,0,0,29509,314145,0,0;
				getitem2 490745,1,1,0,0,0,29649,314145,312301,0;	break;
				case 3:	break;	}
				break;
			case 14: /*アビスチェイサー*/
				mes "["+strnpcinfo(1)+"]";
				mes "アビスチェイサーですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","アビスチェイサーⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314119,311892,0;
				getitem2 400907,1,1,4,0,0,4879,314119,312931,0;
				getitem2 450462,1,1,4,0,0,29307,314119,0,0;
				getitem2 480592,1,1,4,0,0,314165,314119,0,0;
				getitem2 470351,1,1,4,0,0,29509,314119,0,0;
				getitem2 490745,1,1,0,0,0,29649,314119,312930,0;	break;
				case 3:	break;	}
				break;
			case 15: /*天帝*/
				mes "["+strnpcinfo(1)+"]";
				mes "天帝ですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","天帝Ⅰセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4853,314153,300499,0;
				getitem2 400907,1,1,4,0,0,29436,314153,312965,0;
				getitem2 450462,1,1,4,0,0,29307,314153,0,0;
				getitem2 480592,1,1,4,0,0,314165,314153,0,0;
				getitem2 470351,1,1,4,0,0,29509,314153,0,0;
				getitem2 490745,1,1,0,0,0,29649,314153,312964,0;	break;
				case 3:	break;	}
				break;
			case 16: /*ソウルアセティック*/
				mes "["+strnpcinfo(1)+"]";
				mes "ソウルアセティックですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","ソウルアセティックⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314136,312923,0;
				getitem2 400907,1,1,4,0,0,4876,314136,312968,0;
				getitem2 450462,1,1,4,0,0,29307,314136,0,0;
				getitem2 480592,1,1,4,0,0,314165,314136,0,0;
				getitem2 470351,1,1,4,0,0,29371,314136,0,0;
				getitem2 490745,1,1,0,0,0,29650,314136,312966,0;	break;
				case 3:	break;	}
				break;
			case 17: /*蜃気楼・不知火*/
				mes "["+strnpcinfo(1)+"]";
				mes "蜃気楼・不知火ですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","蜃気楼・不知火Ⅰセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 510181,1,1,4,0,0,4853,314155,312925,0;
				getitem2 400907,1,1,4,0,0,29436,314155,312973,0;
				getitem2 450462,1,1,4,0,0,29307,314155,0,0;
				getitem2 480592,1,1,4,0,0,314165,314155,0,0;
				getitem2 470351,1,1,4,0,0,29509,314155,0,0;
				getitem2 490745,1,1,0,0,0,29649,314155,313480,0;	break;
				case 3:	break;	}
				break;
			case 18: /*ナイトウォッチ*/
				mes "["+strnpcinfo(1)+"]";
				mes "ナイトウォッチですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","ナイトウォッチⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 810047,1,1,4,0,0,4857,314143,312924,0;
				getitem2 400907,1,1,4,0,0,4879,314143,312970,0;
				getitem2 450462,1,1,4,0,0,29307,314143,0,0;
				getitem2 480592,1,1,4,0,0,314165,314143,0,0;
				getitem2 470351,1,1,4,0,0,29509,314143,0,0;
				getitem2 490745,1,1,0,0,0,29649,314143,313477,0;	break;
				case 3:	break;	}
				break;
			case 19: /*ハイパーノービス*/
				mes "["+strnpcinfo(1)+"]";
				mes "ハイパーノービスですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","ハイパーノービスⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 590097,1,1,4,0,0,4856,314148,312922,0;
				getitem2 400907,1,1,4,0,0,4876,314148,313274,0;
				getitem2 450462,1,1,4,0,0,29307,314148,0,0;
				getitem2 480592,1,1,4,0,0,314165,314148,0,0;
				getitem2 470351,1,1,4,0,0,29371,314148,0,0;
				getitem2 490745,1,1,0,0,0,29650,314148,312962,0;	break;
				case 3:	break;	}
				break;
			case 20: /*スピリットハンドラー*/
				mes "["+strnpcinfo(1)+"]";
				mes "スピリットハンドラーですね";
				mes "受け取る装備セットをお選び下さい。";
				next;
				switch(select("やめる","スピリットハンドラーⅠセット","追加予定枠")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550173,1,1,4,0,0,4853,314134,312926,0;
				getitem2 400907,1,1,4,0,0,29436,314134,312975,0;
				getitem2 450463,1,1,4,0,0,29307,314134,0,0;
				getitem2 480592,1,1,4,0,0,314165,314134,0,0;
				getitem2 470351,1,1,4,0,0,29509,314134,0,0;
				getitem2 490745,1,1,0,0,0,29649,314134,313483,0;	break;
				case 3:	break;	}
				break;
			}
			mes "["+strnpcinfo(1)+"]";
			mes "お受け取り下さい。";
			close;
	case 18:	mes "["+strnpcinfo(1)+"]"; mes "対象クエストが実装されていません";	close;	/* クエストボーナスAチケット 分岐あり */
	}
	mes "["+strnpcinfo(1)+"]";
	mes "スクリプト終了";
	close;
}
