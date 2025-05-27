//ペットデバッグ用スクリプト

prontera.gat,190,162,0	shop	ペットアクセ商人	548,10001,10002,10003,10004,10005,10006,10007,10008,10009,10010,10011,10012,10013,10014,10015,10016,10017,10018,10019,10020,10022,10023,10024,10025,10026,10027,10028,10029,10030,10031,10032,10033,10034,10035,10036,10042,10043,10044,10046,10047
prontera.gat,192,162,0	shop	ペット餌商人	548,504,507,508,511,512,518,528,529,531,532,534,535,537,711,716,911,929,934,1002,6095,6096,6097,6098,6099,6100,6104,6105,6106,6107,6108,6109,6110,6111,6112,6115,6115,7005,7821,7822,11616,25231,25232,25232,25233,25377,1000227,1000552

prontera.gat,194,162,0	script	ペット卵作成	70,{
	mes "["+strnpcinfo(1)+"]";
	mes "作りたいペットの卵IDを";
	mes "入力して下さい";
	next;
	input '@count;
	if('@count < 9000) { mes "範囲外です"; close; }
	if('@count > 9191) { mes "範囲外です"; close; }
	makepet '@count;
	getitem 643,10;
if('@count == 9001) { getitem 10013,1; getitem 531,5; getitem 619,10; }
if('@count == 9002) { getitem 10013,1; getitem 508,5; getitem 620,10; }
if('@count == 9003) { getitem 10013,1; getitem 511,5; getitem 621,10; }
if('@count == 9004) { getitem 10007,1; getitem 534,5; getitem 622,10; }
if('@count == 9005) { getitem 10012,1; getitem 507,5; getitem 623,10; }
if('@count == 9006) { getitem 10002,1; getitem 537,5; getitem 624,10; }
if('@count == 9007) { getitem 10002,1; getitem 1002,5; getitem 625,10; }
if('@count == 9008) { getitem 10002,1; getitem 716,5; getitem 626,10; }
if('@count == 9009) { getitem 10015,1; getitem 537,5; getitem 627,10; }
if('@count == 9010) { getitem 10003,1; getitem 537,5; getitem 628,10; }
if('@count == 9011) { getitem 10014,1; getitem 537,5; getitem 629,10; }
if('@count == 9012) { getitem 10017,1; getitem 537,5; getitem 630,10; }
if('@count == 9013) { getitem 10017,1; getitem 537,5; getitem 631,10; }
if('@count == 9014) { getitem 10010,1; getitem 537,5; getitem 632,10; }
if('@count == 9015) { getitem 10019,1; getitem 537,5; getitem 633,10; }
if('@count == 9016) { getitem 10018,1; getitem 532,5; getitem 634,10; }
if('@count == 9017) { getitem 10009,1; getitem 537,5; getitem 635,10; }
if('@count == 9018) { getitem 10008,1; getitem 537,5; getitem 636,10; }
if('@count == 9019) { getitem 10005,1; getitem 537,5; getitem 637,10; }
if('@count == 9020) { getitem 10016,1; getitem 537,5; getitem 638,10; }
if('@count == 9021) { getitem 10006,1; getitem 537,5; getitem 639,10; }
if('@count == 9022) { getitem 10011,1; getitem 537,5; getitem 640,10; }
if('@count == 9023) { getitem 10004,1; getitem 711,5; getitem 641,10; }
if('@count == 9024) { getitem 10001,1; getitem 518,5; getitem 642,10; }
if('@count == 9025) { getitem 10020,1; getitem 537,5; getitem 659,10; }
if('@count == 9026) { getitem 501,1; getitem 929,5; getitem 660,10; }
if('@count == 9027) { getitem 501,1; getitem 504,5; getitem 661,10; }
if('@count == 9028) { getitem 501,1; getitem 511,5; getitem 501,10; }
if('@count == 9029) { getitem 501,1; getitem 911,5; getitem 12225,10; }
if('@count == 9030) { getitem 501,1; getitem 6115,5; getitem 501,10; }
if('@count == 9032) { getitem 501,1; getitem 7821,5; getitem 14569,10; }
if('@count == 9035) { getitem 501,1; getitem 7822,5; getitem 501,10; }
if('@count == 9037) { getitem 501,1; getitem 7005,5; getitem 14574,10; }
if('@count == 9038) { getitem 501,1; getitem 6115,5; getitem 501,10; }
if('@count == 9040) { getitem 10022,1; getitem 6095,5; getitem 12358,10; }
if('@count == 9041) { getitem 10023,1; getitem 6096,5; getitem 12359,10; }
if('@count == 9042) { getitem 10024,1; getitem 6097,5; getitem 12360,10; }
if('@count == 9043) { getitem 10025,1; getitem 6098,5; getitem 12361,10; }
if('@count == 9044) { getitem 10026,1; getitem 6099,5; getitem 12362,10; }
if('@count == 9045) { getitem 10027,1; getitem 6100,5; getitem 12363,10; }
if('@count == 9046) { getitem 10028,1; getitem 6104,5; getitem 12364,10; }
if('@count == 9047) { getitem 10029,1; getitem 6105,5; getitem 12365,10; }
if('@count == 9048) { getitem 10030,1; getitem 6106,5; getitem 12366,10; }
if('@count == 9049) { getitem 10031,1; getitem 6107,5; getitem 12367,10; }
if('@count == 9050) { getitem 10032,1; getitem 6108,5; getitem 12368,10; }
if('@count == 9051) { getitem 10033,1; getitem 6109,5; getitem 12369,10; }
if('@count == 9052) { getitem 10034,1; getitem 6110,5; getitem 12370,10; }
if('@count == 9053) { getitem 10035,1; getitem 6111,5; getitem 12371,10; }
if('@count == 9054) { getitem 10036,1; getitem 6112,5; getitem 12372,10; }
if('@count == 9055) { getitem 501,1; getitem 6110,5; getitem 12373,10; }
if('@count == 9056) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9057) { getitem 501,1; getitem 512,5; getitem 501,10; }
if('@count == 9059) { getitem 501,1; getitem 528,5; getitem 12699,10; }
if('@count == 9060) { getitem 501,1; getitem 535,5; getitem 501,10; }
if('@count == 9069) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9074) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9075) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9076) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9077) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9078) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9079) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9080) { getitem 501,1; getitem 512,5; getitem 501,10; }
if('@count == 9087) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9088) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9095) { getitem 501,1; getitem 25231,5; getitem 23187,10; }
if('@count == 9096) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9099) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9100) { getitem 501,1; getitem 25232,5; getitem 23188,10; }
if('@count == 9102) { getitem 501,1; getitem 934,5; getitem 501,10; }
if('@count == 9103) { getitem 501,1; getitem 537,5; getitem 23257,10; }
if('@count == 9105) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9106) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9107) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9108) { getitem 501,1; getitem 25233,5; getitem 501,10; }
if('@count == 9109) { getitem 501,1; getitem 529,5; getitem 501,10; }
if('@count == 9111) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9112) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9113) { getitem 10042,1; getitem 11616,5; getitem 501,10; }
if('@count == 9115) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9116) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9117) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9118) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9119) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9120) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9121) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9122) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9123) { getitem 10043,1; getitem 1000227,5; getitem 501,10; }
if('@count == 9124) { getitem 10044,1; getitem 1000227,5; getitem 501,10; }
if('@count == 9126) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9128) { getitem 501,1; getitem 1000552,5; getitem 100796,10; }
if('@count == 9130) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9132) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9135) { getitem 10046,1; getitem 537,5; getitem 100797,10; }
if('@count == 9136) { getitem 10047,1; getitem 25377,5; getitem 501,10; }
if('@count == 9137) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9139) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9143) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9145) { getitem 501,1; getitem 537,5; getitem 102202,10; }
if('@count == 9146) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9147) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9148) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9153) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9154) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9155) { getitem 501,1; getitem 518,5; getitem 102723,10; }
if('@count == 9156) { getitem 501,1; getitem 511,5; getitem 501,10; }
if('@count == 9158) { getitem 501,1; getitem 537,5; getitem 103825,10; }
if('@count == 9159) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9160) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9185) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9186) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9187) { getitem 501,1; getitem 537,5; getitem 103218,10; }
if('@count == 9188) { getitem 501,1; getitem 25377,5; getitem 501,10; }
if('@count == 9189) { getitem 501,1; getitem 537,5; getitem 501,10; }
if('@count == 9190) { getitem 501,1; getitem 25232,5; getitem 103219,10; }
	close;
}

prontera.gat,196,162,0	script	餌入手	70,{
	mes "["+strnpcinfo(1)+"]";
	mes "親密度と孵化アイテム";
	gmcommand "@petfriendly 1000";
	getitem 643,10;
	next;
	if(getpetinfo(0) == 0) { 	mes "["+strnpcinfo(1)+"]";	mes "ペットがいません"; close; }
	mes "["+strnpcinfo(1)+"]";
	mes "餌とアクセをどうぞ";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes "終了";
	close;
}

prontera.gat,198,162,0	script	ペット削除	70,{
	mes "["+strnpcinfo(1)+"]";
	mes "消しました";
	clearitem;
	gmcommand "@itemreset";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes "孵化アイテム入手";
	getitem 643,10;
	close;
close;
}
