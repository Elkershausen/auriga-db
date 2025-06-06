//イズルードNPC関連スクリプト 20240515 アップデート
//20191029 20200907 20201013 20201027 不審なボトル おいしい魚 美味しいお肉 綿の玉 豪華なペットフード 販売追加
//npc_town_izlude.sc 上書き

//shop
izlude.gat,94,98,4	shop	果物商人	53,512,513,515,516
izlude.gat,105,99,0	shop	肉商人	54,517
izlude.gat,105,92,7	shop	牛乳商人	90,519
izlude_in.gat,60,127,4	shop	武器商人	72,1750,1751,1701,1601,1201,1204,1207,1101,1104,1107,1116,1151,1154,1157,1160,1301
izlude_in.gat,70,127,4	shop	防具商人	62,2103,2105,2403,2405,2503,2505,2226,2228,2303,2305,2328,2307,2309,2312,2314,2316,2628
izlude_in.gat,115,61,0	shop	道具商人	47,611,501,502,503,504,506,645,656,601,602,1750,1065
izlude_in.gat,121,64,3	shop	貿易商人	900,13200,13201,13202,13150,13102,13151,13154,13155,13163,13165,13168
izlude.gat,164,138,4	shop	テイミング商人	124,537,643,10013,10014,6095,6096,6097,6098,6099,6100,6104,6105,6106,6107,6108,6109,6110,6111,6112,579,11616,25231,25233,25377

//============================================================
// イズルード⇔バイラン島転送NPC
//------------------------------------------------------------
izlude.gat,201,181,2	script	船員	100,{
	mes "[船員]";
	mes "超高速の快速船です！";
	mes "ただし安全は別の問題！";
	mes "さあ〜いらっしゃいませ！";
	next;
	switch(select("バイラン島 -> 150 z","アルベルタ港 -> 500 z","やめる")) {
	case 1: set '@price,150; break;
	case 2: set '@price,500; break;
	case 3: close;
	}
	if(Zeny < '@price) {
		mes "[船員]";
		mes '@price+ "z…" +'@price+ "Zenyです！";
		close;
	}
	set Zeny,Zeny-'@price;
	switch(@menu) {
	case 1: warp "izlu2dun.gat",107,50; break;
	case 2: warp "alberta.gat",188,169; break;
	}
	end;
}

izlu2dun.gat,108,27,0	script	船員	100,{
	mes "[船員]";
	mes "帰りますか？";
	next;
	if(select("帰る","やめる")==2)
		close;
	warp "izlude.gat",176,182;
	end;
}
