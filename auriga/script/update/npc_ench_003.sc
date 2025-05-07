//20240610 汎用npc作成用の学習スクリプト 003

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

rwc01.gat,48,55,4	script	エンチャテスト4	553,{
	setarray '@main[0],19172,22129,15191,19174,19173;	//上段 靴 鎧 中段 下段
	mes "[" +strnpcinfo(1)+ "]";
	mes "選んで下さい";
	next;
	set '@i,select(getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
				getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10));
	if(getequipisequiped('@i)==0) {switch('@i) {
		case 1:	mes "(1) 上段は装備していません";	close;
		case 2:	mes "(2) 鎧は装備していません";	close;
		case 3:	mes "(3) 盾は装備していません";	close;
		case 4:	mes "(4) 武器は装備していません";	close;
		case 5:	mes "(5) 鎧は装備していません";	close;
		case 6:	mes "(6) 靴は装備していません";	close;
		case 7:	mes "(7) アクセ2は装備していません";	close;
		case 8:	mes "(8) アクセ1は装備していません";	close;
		case 9:	mes "(9) 中段装備していません";	close;
		case 10:	mes "(10) 下段装備していません";	close;
		}return;}
		if(getequiprefinerycnt(1) < 6) {mes "精錬値6以上から利用できます";	close;}
		if(getitemid(getequipname(1)) != '@main[0]) {mes "[" +strnpcinfo(1)+ "]";mes "エンチャ対象外です";close;}
		mes "[" +strnpcinfo(1)+ "]";
		mes "エンチャ対象です";
		close;
}

// callfunc "呼び出し定義","呼び出したNPCに使う"+getarg(0)+",呼び出したNPCに使う成功エモーションID,呼び出したNPCに使う失敗エモーション
// プロンテラ
prontera.gat,166,125,4	script	ミミミエンチャ	554,{
	callfunc "mimimiA","prt_ench",21,23;
	close;
}

// アルベルタ
alberta.gat,91,76,4	script	ミミミエンチャ	555,{
	callfunc "mimimiA","alb_ench",21,23;
	close;
}

function	script	mimimiA	{
	while(1) {
	mes "["+getarg(0)+"]";
	mes "どちらにしますか？";
	mes "選んで下さい";
		next;
		switch(select("選択1","選択2")) {
		case 1:
			mes "["+getarg(0)+"]";
			mes "選択1";
			mes "whileに戻る";
			next;
			continue;
		case 2:
			mes "["+getarg(0)+"]";
			mes "選択2";
			mes "終了する";
		close;
		}
	}
}

//ステータス表示
prontera.gat,168,125,4	script	ステータス表示	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "アイテム所持数 : "+countitem(501)+"個";
	mes "最大所持重量 : "+(MaxWeight/10)+"";
	mes "現所持重量 : "+(Weight)/10+"";
	mes "所持残重量 : "+(MaxWeight - Weight)/10+"";
	mes "所持ゼニー : "+Zeny+" Zeny";
	mes "BaseLevel : "+BaseLevel+"";
	cutin "hollgrehenn_01",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "Str : "+readparam(bStr)+"";
	mes "Agi : "+readparam(bAgi)+"";
	mes "Dex : "+readparam(bDex)+"";
	mes "Vit : "+readparam(bVit)+"";
	mes "Int : "+readparam(bInt)+"";
	mes "Luk : "+readparam(bLuk)+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "頭上段装備のステータス";
	mes "アイテム名 : "+getequipname(1)+"";
	mes "アイテムID : "+getitemid(getequipname(1))+"";
	mes "精錬可否 : ["+getequipisenableref(1)+"] 1 : 可 2 : 不可";
	mes "精錬値 : +"+getequiprefinerycnt(1)+"";
	cutin "hollgrehenn_01",255;
	cutin "hollgrehenn_02",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+getequipname(1)+" ID : "+getitemid(getequipname(1))+" ";
	mes ""+getequipname(9)+" ID : "+getitemid(getequipname(9))+" ";
	mes ""+getequipname(10)+" ID : "+getitemid(getequipname(10))+" ";
	mes ""+getequipname(2)+" ID : "+getitemid(getequipname(2))+" ";
	mes ""+getequipname(3)+" ID : "+getitemid(getequipname(3))+" ";
	mes ""+getequipname(4)+" ID : "+getitemid(getequipname(4))+" ";
	mes ""+getequipname(5)+" ID : "+getitemid(getequipname(5))+" ";
	mes ""+getequipname(6)+" ID : "+getitemid(getequipname(6))+" ";
	mes ""+getequipname(7)+" ID : "+getitemid(getequipname(7))+" ";
	mes ""+getequipname(8)+" ID : "+getitemid(getequipname(8))+" ";
	mes "終了";
	cutin "hollgrehenn_02",255;
	cutin "hollgrehenn_03",2;
	close2;
	cutin "hollgrehenn_03",255;
	end;
}
prontera.gat,170,125,4	script	エンチャントテスト1	70,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "対象装備のIDを入力";
	next;
	input '@item;
	
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "精錬値を選択";
	next;
	input '@ref;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第1エンチャント(第4スロット)を選択";
	next;
	input '@ench4;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第2エンチャント(第3スロット)を選択";
	next;
	input '@ench3;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第3エンチャント(第2スロット)を選択";
	next;
	input '@ench2;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第4エンチャント(第1スロット)を選択";
	next;
	input '@ench1;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "完成しました";
	next;
	getitem2 '@item,1,1,'@ref,0,'@ench1,'@ench2,'@ench3,'@ench4,0;
	close;
}

prontera.gat,172,125,4	script	エンチャントテスト2	70,{
	setarray '@mainitem[0],400012,22235,20936,20974,20977,20978,20979,32268,32269,400013;
	setarray '@ench1[0],29372,27412,300229,310650;
	mes "[" +strnpcinfo(1)+ "]";
	mes "対象装備を選択してください";
	next;
	switch(select(""+getitemname('@mainitem[0])+"",""+getitemname('@mainitem[1])+"",""+getitemname('@mainitem[2])+"",""+getitemname('@mainitem[3])+"",""+getitemname('@mainitem[4])+"",
			""+getitemname('@mainitem[5])+"",""+getitemname('@mainitem[6])+"",""+getitemname('@mainitem[7])+"",""+getitemname('@mainitem[8])+"",""+getitemname('@mainitem[9])+"")) {
	case 1:
		set '@itemid,'@mainitem[0];	//400012
		break;
	case 2:
		set '@itemid,'@mainitem[1];	//22235
		break;
	case 3:
		set '@itemid,'@mainitem[2];	//20396
		break;
	case 4:
		set '@itemid,'@mainitem[3];
		break;
	case 5:
		set '@itemid,'@mainitem[4];
		break;
	case 6:
		set '@itemid,'@mainitem[5];
		break;
	case 7:
		set '@itemid,'@mainitem[6];
		break;
	case 8:
		set '@itemid,'@mainitem[7];
		break;
	case 9:
		set '@itemid,'@mainitem[8];
		break;
	case 10:
		set '@itemid,'@mainitem[9];
		break;
	}
	mes "[" +strnpcinfo(1)+ "]";
	mes "ID : "+ '@itemid +" : "+ getitemname('@itemid) +" ";
	mes " ";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "精錬値を選択";
	next;
	input '@ref;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第1エンチャント(第4スロット)を選択";
	next;
	input '@ench4;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第2エンチャント(第3スロット)を選択";
	next;
	input '@ench3;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第3エンチャント(第2スロット)を選択";
	next;
	input '@ench2;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第4エンチャント(第1スロット)を選択";
	next;
	input '@ench1;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "完成しました";
	next;
	getitem2 '@itemid,1,1,'@ref,0,'@ench1,'@ench2,'@ench3,'@ench4,0;
	close;
}

prontera.gat,174,125,4	script	時間表示	553,{

	setarray 'weekday[gettime(4)],"日曜日","月曜日","火曜日","水曜日","木曜日","金曜日","土曜日";
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+gettime(7)+"年";
	mes ""+gettime(6)+"月";
	mes ""+gettime(5)+"日";
	mes ""+gettime(5)+" 曜日 0:日曜 - 6:土曜";
	mes ""+gettime(3)+"時";
	mes ""+gettime(2)+"分";
	mes ""+gettime(1)+"秒";
	cutin "2020ver_kafra_do01",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+gettime(7)+"年 "+gettime(6)+"月 "+gettime(5)+"日 "+gettime(3)+"時 "+gettime(2)+"分 "+gettime(1)+"秒";
	mes ""+gettimestr("%Y/%m/%d %p %H:%M:%S",100)+"";
	mes "終了";
	cutin "2020ver_kafra_do01",255;
	cutin "2020ver_kafra_do02",2;
	next;
	cutin "2020ver_kafra_do02",255;
	cutin "2020ver_kafra_do03",2;
	close2;
	cutin "2020ver_kafra_do03",255;
	end;
}

prontera.gat,176,125,4	script	setarray	553,{
	setarray '@testA[0],8,16,32,64,128;
	setarray '@testB[0],4001,4002,4003,4004,4005,4006;
	mes "[" +strnpcinfo(1)+ "]";
	mes "testA 指定の番号を表示";
	mes "setarray : "+'@testA[0]+"";
	mes "setarray : "+'@testA[1]+"";
	mes "setarray : "+'@testA[2]+"";
	mes "setarray : "+'@testA[3]+"";
	mes "setarray : "+'@testA[4]+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "testB 指定の番号をランダム入手";
	next;
	getitem '@testB[rand(6)],1;
	close;
}

prontera.gat,178,125,4	script	装備部位	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "装備しているアイテムを";
	mes "選んでください";
	set '@i,select(getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
				getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10));
		switch('@i) {
		case 1:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case1";
			break;
		case 2:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case2";
			break;
		case 3:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 3";
			break;
		case 4:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 4";
			break;
		case 5:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 5";
			break;
		case 6:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 6";
			break;
		case 7:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 7";
			break;
		case 8:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 8";
			break;
		case 9:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 9";
			break;
		case 10:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 10";
			break;
	}
	close;
}

prontera.gat,156,150,4	script	実装アイテム	70,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■";
	next;
	showdigit 10000,3;
	close;
}
