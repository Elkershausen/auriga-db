//2025/06/03 アップデート
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
	if(countitem('@main[0])	< 100) {	mes ""+getitemname('@main[0])+" が100個以上必要です";	close;	}
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
//4th_lib.gat,34,67,3	script	セレス	803,{}


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