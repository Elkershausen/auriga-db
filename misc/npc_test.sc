//=============================================================
//= アビスレイク地下洞窟 04 abyss_04.gat abyss_04_j.gat
//=============================================================
//Map Flag
abyss_04.gat	mapflag	nomemo	dummy
abyss_04_j.gat	mapflag	nomemo	dummy

//warp
prontera.gat,133,169,0		warp	abyss_040001	1,1,hugel.gat,100,150
hugel.gat,100,155,0		warp	abyss_040002	1,1,prontera.gat,133,166
abyss_04.gat,168,166,0		warp	abyss_040003	1,1,abyss_04_j.gat,165,163
abyss_04_j.gat,168,166,0	warp	abyss_040004	1,1,abyss_04.gat,165,163

//mob
abyss_04.gat,0,0,0,0	monster	パープルペロス		20612,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	トレジャーミミック	20613,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	ブラックオシドス	20614,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	シルバーオシドス	20615,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	ボーンペロス		20616,110,5000,0,0
abyss_04.gat,0,0,0,0	monster	ボーンオシドス		20617,110,5000,0,0
abyss_04.gat,0,0,0,0	monster	ボーンデータルザウルス	20618,1,3600000,0,0

abyss_04_j.gat,0,0,0,0	monster	パープルペロス		20612,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	トレジャーミミック	20613,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	ブラックオシドス	20614,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	シルバーオシドス	20615,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	ボーンペロス		20616,110,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	ボーンオシドス		20617,110,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	ボーンデータルザウルス	20618,1,3600000,0,0

//NPC
prontera.gat,133,172,3	script	フィゲル方面	837,{
waitingroom "フィゲル方面",0;
}
hugel.gat,100,158,3	script	プロンテラ方面	837,{
waitingroom "プロンテラ方面",0;
}

hugel.gat,102,148,3	script	[テラーダンジョン]#abyss04_01	893,{
mes "[民俗学者マリーゴールド]";
mes "何を手伝っていただけますか？";
mes "hugel.gat npc pos(102,148)";
mes "";
next;
switch(select("手伝う","現地へ移動","事情を再確認する","拒否する")) {
	case 1:
	mes "[民俗学者マリーゴールド]";
	mes "手伝う";
	mes "未実装";
	mes "";
	mes "";
	mes "";
	close;

	case 2:
	mes "[民俗学者マリーゴールド]";
	mes "現場に向かいますか？";
	next;
		switch(select("アビスレイク地下洞窟 04の前に移動","考え直す")){
		case 1:
		mes "[民俗学者マリーゴールド]";
		mes "それでは、現場まで転送いたしますね。";
		misceffect 35,"";
		misceffect 240,"";
		next;
		warp "abyss_03.gat",87,107;
		end;
		
		case 2:
		mes "[民俗学者マリーゴールド]";
		mes "考え直す";
		mes "また来て下さい。";
		mes "";
		close;
		}

	case 3:
	mes "[民俗学者マリーゴールド]";
	mes "事情を再確認する";
	mes "未実装";
	mes "";
	mes "";
	mes "";
	close;

	case 4:
	mes "[民俗学者マリーゴールド]";
	mes "拒否する";
	mes "未実装";
	mes "";
	mes "";
	mes "";
	close;}
}

abyss_03.gat,91,110,3	script	テラーダンジョン[看板]#board_01		837,{
mes "-どちらに向かおうか？-";
mes "";
mes "";
next;
switch(select("アビスレイク地下洞窟 04[1]","アビスレイク地下洞窟 04[2]","hugel.gatに戻る")){
	case 1:
	warp "abyss_04.gat",168,160;
	end;

	case 2:
	warp "abyss_04_j.gat",168,160;
	end;
	
	case 3:
	warp "hugel.gat",102,146;
	end;}
}

abyss_04.gat,168,166,3	script	テラーダンジョン[看板]#board_02		837,{
mes "-どちらに向かおうか？-";
mes "";
mes "";
	switch(select("hugel.gatに戻る","アビスレイク地下洞窟 04[2]")){

	case 1:
	warp "hugel.gat",102,146;
	end;

	case 2:
	warp "abyss_04_j.gat",168,165;
	end;}
}

//=============================================================
//= 大浴場メディタティオ ba_bath.gat ba_bath_j.gat
//=============================================================
//Map Flag
ba_bath.gat	mapflag	nomemo	dummy
ba_bath_j.gat	mapflag	nomemo	dummy

//warp
ba_bath.gat,290,70,0		warp	medi_040001	1,1,prontera.gat,138,166
ba_bath_j.gat,290,70,0		warp	medi_040002	1,1,prontera.gat,138,166

//mob
ba_bath.gat,0,0,0,0	monster	故障した清掃型βⅠ型	20633,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	故障した清掃型βⅠⅠ型	20634,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	熱湯フェン		20643,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	熱湯マルク		20644,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	熱湯ソードフィッシュ	20645,60,5000,0,0
ba_bath.gat,0,0,0,0	monster	熱湯ピラニア		20646,60,5000,0,0

ba_bath_j.gat,0,0,0,0	monster	故障した清掃型βⅠ型	20633,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	故障した清掃型βⅠⅠ型	20634,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	熱湯フェン		20643,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	熱湯マルク		20644,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	熱湯ソードフィッシュ	20645,60,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	熱湯ピラニア		20646,60,5000,0,0

//NPC
prontera.gat,124,169,3		script	テストマップ	10353,{
mes "[4_EP17_MASTER_A]";
mes "どこに行きますか？";
mes "prontera.gat npc pos(124,169)";
mes "";
next;
switch(select("アビスレイク地下洞窟04[1]","アビスレイク地下洞窟04[2]","大浴場メディタティオ[1]","大浴場メディタティオ[2]")) {

case 1:
	warp "abyss_04.gat",165,163;
	end;
case 2:
	warp "abyss_04_j.gat",165,163;
	end;
case 3:
	warp "ba_bath.gat",165,163;
	end;
case 4:
	warp "ba_bath_j.gat",165,163;
	end;}
}