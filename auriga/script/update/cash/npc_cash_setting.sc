// 2026/04/07 アップデート
// map :iz_gimlet.gat 追加
// マップフラグ追加

// イズルード -> ギムレット部屋
izlude.gat,122,151,3	script	アイテム配布係#26517	833,{

	mes "["+strnpcinfo(1)+"]";
	mes "こんにちは！"; mes "私は、アイテム配布係の"; mes "ギムレットと申します。";
	mes "各種キャンペーンや"; mes "サービスをご利用でしょうか？？";
	next;
	if(select("いいえ","はい(iz_gimlet.gat)") == 1) { mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています。"; close; }
	warp "iz_gimlet",43,87;
	end;
}

// ギムレット部屋 -> イズルード
iz_gimlet.gat,43,90,3	script	アイテム配布係#26520	833,{

	mes "["+strnpcinfo(1)+"]";
	mes "イズルードに戻りますか？";
	next;
	if(select("いいえ","はい") == 1) { mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています。"; close; }
	warp "izlude",122,149;
	end;
}

//マップフラグここから
iz_gimlet.gat	mapflag	nosave		SavePoint
iz_gimlet.gat	mapflag	nomemo		dummy
iz_gimletason01.gat	mapflag	noteleport	dummy
iz_gimlet.gat	mapflag	nobranch	dummy
iz_gimlet.gat	mapflag	monster_noteleport	dummy
iz_gimlet.gat	mapflag	noicewall	dummy
iz_gimlet.gat	mapflag	noabra		dummy