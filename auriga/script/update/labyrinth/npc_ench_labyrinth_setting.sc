//2025/06/24 アップデート
//夢幻の迷宮 迷宮調査団キャンプ
//追加必要	map :lby_in.gat

//マップフラグここから
//lby_in.gat	mapflag	nosave		SavePoint
lby_in.gat	mapflag	nomemo		dummy
lby_in.gat	mapflag	noteleport	dummy
lby_in.gat	mapflag	nobranch	dummy
lby_in.gat	mapflag	monster_noteleport	dummy
lby_in.gat	mapflag	noicewall	dummy
lby_in.gat	mapflag	noabra		dummy

//倉庫サービス
//npc_mimic_storage.sc

//アイテム交換
lby_in.gat,59,86,4	script	隊長サヴィン#32193	415,{

	setarray '@main,	25237,783,25662,1000999;
	if((Weight*100/MaxWeight) > 90) { mes "["+strnpcinfo(1)+"]"; mes "所持重量が多すぎます。";	close; }
	mes "["+strnpcinfo(1)+"]";
	mes "ここでは "+getitemname('@main[0])+" を";
	mes "補給物資やサービスと交換します。";
	mes "選んで下さい。";
	next;
	switch(select(
		"やめる",
		"補給物資と交換する",
		"装備アイテムにセットされたカードを分離する",
		"迷宮のシリーズ装備を精錬する",
		""+getitemname('@main[1])+"と交換する 実装",
		""+getitemname('@main[2])+"で安全な精錬をする",
		"特別な迷宮の魔力結晶を分解する 実装"))	{

		case 1: mes "["+strnpcinfo(1)+"]";	mes "ご利用お待ちしています。";	close;
		case 2: mes "["+strnpcinfo(1)+"]";	mes "給物資と交換する 未実装。";	close;
		case 3: mes "["+strnpcinfo(1)+"]";	mes "カード分離 未実装。";	close;
		case 4: mes "["+strnpcinfo(1)+"]";	mes "迷宮シリーズ精錬 未実装。";	close;
		case 5:
			set '@lim,100;
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[1])+"と交換します。";
			mes "1回に100個まで交換できます。。";
			mes "交換個数を入力して下さい。";
			next;
			input '@count;
			if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "交換を中止します。";	close; }
			if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1回で交換できるのは "+'@lim+"個 までです。";	close; }
			if('@count > countitem('@main[0])) { mes "["+strnpcinfo(1)+"]"; mes "足りないようです。";	close; }
			if((countitem('@main[1]) + '@count) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "持てる最大数を超えます。";	close; }
			mes "["+strnpcinfo(1)+"]";
			mes "交換しました。";
			delitem '@main[0],'@count;
			getitem '@main[1],'@count;
			close;

		case 6: mes "["+strnpcinfo(1)+"]";	mes "安全な精錬 未実装。";	close;
		case 7:
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[2])+"1個で";
			mes ""+getitemname('@main[0])+"5個に分解します。";
			mes ""+getitemname('@main[3])+"1個で";
			mes ""+getitemname('@main[0])+"10個に分解します。";
			next;
			switch(select(
				"やめる",
				""+getitemname('@main[2])+"を分解する",
				""+getitemname('@main[3])+"を分解する")) {
				case 1: mes "["+strnpcinfo(1)+"]";	mes "ご利用お待ちしています。";	close;
				case 2:
				set '@lim,100;
				mes "["+strnpcinfo(1)+"]";
				mes ""+getitemname('@main[2])+"1個で";
				mes ""+getitemname('@main[0])+"5個に分解します。";
				mes "1回に100個まで分解できます。";
				mes "分解個数を入力して下さい。";
				next;
				input '@count;
				if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "分解を中止します。";	close; }
				if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1回で分解できるのは "+'@lim+"個 までです。";	close; }
				if('@count > countitem('@main[2])) 			{ mes "["+strnpcinfo(1)+"]"; mes "足りないようです。";	close; }
				if((countitem('@main[0]) + '@count * 5) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "持てる最大数を超えます。";	close; }
				mes "["+strnpcinfo(1)+"]";
				mes "交換しました。";
				delitem '@main[2],'@count;
				getitem '@main[0],'@count * 5;
				close;

				case 3:	
				set '@lim,100;
				mes "["+strnpcinfo(1)+"]";
				mes ""+getitemname('@main[3])+"1個で";
				mes ""+getitemname('@main[0])+"10個に分解します。";
				mes "1回に100個まで分解できます。";
				mes "分解個数を入力して下さい。";
				next;
				input '@count;
				if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "分解を中止します。";	close; }
				if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1回で分解できるのは "+'@lim+"個 までです。";	close; }
				if('@count > countitem('@main[3]))			{ mes "["+strnpcinfo(1)+"]"; mes "足りないようです。";	close; }
				if((countitem('@main[0]) + '@count * 10) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "持てる最大数を超えます。";	close; }
				mes "["+strnpcinfo(1)+"]";
				mes "交換しました。";
				delitem '@main[3],'@count;
				getitem '@main[0],'@count * 10;
				close;
		}
	}
}

//移動
lby_in.gat,48,85,4	script	迷宮調査団募集員#32199	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "街に戻りますか？";
	next;
	switch(select(
		"ここにとどまる",
		"プロンテラに戻る",
		"ゲフェンに戻る")) {
	case 1:	mes "["+strnpcinfo(1)+"]";	mes "ご協力感謝します。";	close;
	case 2:	warp "prontera",116,76;	break;
	case 3:	warp "geffen",128,60;	break;	}
	end;
}

geffen.gat,128,64,4	script	迷宮調査団募集員#32200	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "調査地点まで";
	mes "お送りいたしましょうか？";
	next;
	if(select("いいえ","はい") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "ご協力お待ちしています。";	close;	}
	warp "lby_in",48,75;
	end;
}

prontera.gat,111,78,4	script	迷宮調査団募集員#32205	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "調査地点まで";
	mes "お送りいたしましょうか？";
	next;
	if(select("いいえ","はい") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "ご協力お待ちしています。";	close;	}
	warp "lby_in",48,75;
	end;
}
