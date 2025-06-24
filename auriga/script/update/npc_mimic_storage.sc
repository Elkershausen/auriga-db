//2025/06/24 アップデート
//メイン倉庫1サブ倉庫3 [openstorage] 拡張が必要

-	script	メイン倉庫#mainmimic50z	464,{
	if(Zeny < 50) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

-	script	メイン倉庫#mainmimic40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

-	script	サブ倉庫1#submimicA50z	464,{
	if(Zeny < 50) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

-	script	サブ倉庫2#submimicB50z	464,{
	if(Zeny < 50) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

-	script	サブ倉庫3#submimicC50z	464,{
	if(Zeny < 50) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

-	script	サブ倉庫1#submimicA40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

-	script	サブ倉庫2#submimicB40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

-	script	サブ倉庫3#submimicC40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

alberta.gat,144,61,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#27294	464
alberta.gat,146,61,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#27295		464
alberta.gat,148,61,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#27296		464
alberta.gat,150,61,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#27297		464

aldebaran.gat,169,125,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#27284	464
aldebaran.gat,171,125,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#27285		464
aldebaran.gat,173,125,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#27286		464
aldebaran.gat,175,125,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#27287		464

brasilis.gat,174,224,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#27279	464
brasilis.gat,176,224,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#27280		464
brasilis.gat,178,224,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#27281		464
brasilis.gat,180,224,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#27282		464

cmd_fild07.gat,40,268,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#36327	464
cmd_fild07.gat,42,268,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#36328		464
cmd_fild07.gat,44,268,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#36329		464
cmd_fild07.gat,46,268,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#36330		464

comodo.gat,162,176,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#27259	464
comodo.gat,164,176,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#27260		464
comodo.gat,166,176,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#27261		464
comodo.gat,168,176,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#27262		464

enchant01.gat,186,48,5	duplicate(メイン倉庫#mainmimic40z)	メイン倉庫#36422	464
enchant01.gat,184,48,3	duplicate(サブ倉庫1#submimicA40z)	サブ倉庫1#36423		464
enchant01.gat,184,46,3	duplicate(サブ倉庫2#submimicB40z)	サブ倉庫2#36424		464
enchant01.gat,184,44,3	duplicate(サブ倉庫3#submimicC40z)	サブ倉庫3#36425		464

lasagna.gat,325,240,5	duplicate(メイン倉庫#mainmimic40z)	メイン倉庫#32810	464
lasagna.gat,327,240,3	duplicate(サブ倉庫1#submimicA40z)	サブ倉庫1#32811		464
lasagna.gat,329,240,3	duplicate(サブ倉庫2#submimicB40z)	サブ倉庫2#32812		464
lasagna.gat,331,240,3	duplicate(サブ倉庫3#submimicC40z)	サブ倉庫3#32813		464

lighthalzen.gat,166,123,5	duplicate(メイン倉庫#mainmimic50z)	メイン倉庫#27299	464
lighthalzen.gat,168,123,3	duplicate(サブ倉庫1#submimicA50z)	サブ倉庫1#27300		464
lighthalzen.gat,170,123,3	duplicate(サブ倉庫2#submimicB50z)	サブ倉庫2#27301		464
lighthalzen.gat,172,123,3	duplicate(サブ倉庫3#submimicC50z)	サブ倉庫3#27302		464

//lounge00_jp.gat,84,89,5	duplicate(メイン倉庫#mainmimic40z)	メイン倉庫#15388	464
//lounge00_jp.gat,87,89,3	duplicate(サブ倉庫1#submimicA40z)	サブ倉庫1#15389		464
//lounge00_jp.gat,90,89,3	duplicate(サブ倉庫2#submimicB40z)	サブ倉庫2#15390		464
//lounge00_jp.gat,93,89,3	duplicate(サブ倉庫3#submimicC40z)	サブ倉庫2#15391		464

yuno.gat,199,299,5	duplicate(メイン倉庫#mainmimic40z)	メイン倉庫#31706	464
yuno.gat,201,299,3	duplicate(サブ倉庫1#submimicA40z)	サブ倉庫1#31707		464
yuno.gat,203,299,3	duplicate(サブ倉庫2#submimicB40z)	サブ倉庫2#31708		464
yuno.gat,205,299,3	duplicate(サブ倉庫3#submimicC40z)	サブ倉庫3#31709		464

//夢幻の迷宮
lby_in.gat,39,86,5	duplicate(メイン倉庫#mainmimic40z)	メイン倉庫#32210	464
lby_in.gat,41,86,3	duplicate(サブ倉庫1#submimicA40z)	サブ倉庫1#32211		464
lby_in.gat,43,86,3	duplicate(サブ倉庫2#submimicB40z)	サブ倉庫2#32212		464
lby_in.gat,45,86,3	duplicate(サブ倉庫3#submimicC40z)	サブ倉庫3#32213		464
