//2022-11-10 EPISODE：ILUSION～賢者の遺産 [バルムント邸][第１魔力発電所、下水処理場][図書館 記憶の回廊][飛行船発着場][隠された花園]
//[飼育場ロストバレー][宿舎][カフェテリア][食堂][船着場][貯蔵庫タルタロス][]第２魔力発電所][大浴場メディタティオ]
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
