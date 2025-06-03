prontera.gat,150,140,4	script	衣装装備	10439,{

	set '@getcount,100;
	mes "[" +strnpcinfo(1)+ "]";
	mes "衣装の番号を";
	mes "入力して下さい";
	mes "一度に最大100個出ます";
	next;
	input '@id;
	while('@getcount > 0) {
	if(getiteminfo('@id,13) == 1024 || getiteminfo('@id,13) == 2048 || getiteminfo('@id,13) == 3072 || getiteminfo('@id,13) == 4096 || getiteminfo('@id,13) == 5120 || getiteminfo('@id,13) == 6144 || getiteminfo('@id,13) == 7168 || getiteminfo('@id,13) == 8192) { getitem '@id,1; set '@getcount,'@getcount - 1; } else {  }
	set '@id,'@id + 1;
	}
	mes "終了します";
	close;
}

prontera.gat,150,130,4	script	選衣装装備	10439,{

	set '@getcount,100;
	mes "[" +strnpcinfo(1)+ "]";
	mes "衣装部位を";
	mes "選んで下さい";
	mes "一度に最大100個出ます";
		next;
	switch(select(
		"やめる",
		"衣装上段 1024",
		"衣装中段 2048",
		"衣装下段 4096",
		"衣装上中段 3072",
		"衣装上下段 5120",
		"衣装中下段 6144",
		"衣装上中下段 7168",
		"衣装肩 8192",
		"アイテムを消す")) {

	case 1: mes "[" +strnpcinfo(1)+ "]"; mes "やめました"; close;
	case 2: set '@tmp,1024; break;
	case 3: set '@tmp,2048; break;
	case 4: set '@tmp,4096; break;
	case 5: set '@tmp,3072; break;
	case 6: set '@tmp,5120; break;
	case 7: set '@tmp,6144; break;
	case 8: set '@tmp,7168; break;
	case 9: set '@tmp,8192; break;
	case 10: clearitem; gmcommand "@itemreset"; close;
	}
	input '@id;
	while('@getcount > 0) {
	if(getiteminfo('@id,0) == 6000) { mes "6000番になったので中止します"; close; }
	if(getiteminfo('@id,0) == 16000) { mes "16000番になったので中止します"; close; }
	if(getiteminfo('@id,0) == 20800) { mes "20800番になったので中止します"; close; }
	if(getiteminfo('@id,13) == '@tmp) { getitem '@id,1; set '@getcount,'@getcount - 1; } else {  }
	set '@id,'@id + 1;
	}
	mes "終了します";
	close;
}