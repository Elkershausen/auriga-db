// 2026/03/31 アップデート
// [神秘の館] 移動NPC マップフラグ設定
// 実装情報
// 追加必要 map: ev_season01.gat
// NPC [13 甘い匂いのする男] 実装

// プロンテラ -> 神秘の館
prontera.gat,86,63,5	script	神秘の館の案内人	711,{

	mes "["+strnpcinfo(1)+"]";
	mes "季節イベント系の様々な"; mes "エンチャントやアイテム交換等が"; mes "いつでもできる………";
	mes "神秘の館へご案内致します。"; mes "おいでになりますか？";
	next;
	if(select("いいえ","はい") == 1) { mes "["+strnpcinfo(1)+"]"; mes "ご利用お待ちしています。"; close; }
	warp "ev_season01",27,95;
	end;
}
// 神秘の館 -> プロンテラ
ev_season01.gat,27,90,1		warp	sinpi001	1,1,prontera.gat,86,60

//マップフラグここから
ev_season01.gat	mapflag	nosave		SavePoint
ev_season01.gat	mapflag	nomemo		dummy
ev_season01.gat	mapflag	noteleport	dummy
ev_season01.gat	mapflag	nobranch	dummy
ev_season01.gat	mapflag	monster_noteleport	dummy
ev_season01.gat	mapflag	noicewall	dummy
ev_season01.gat	mapflag	noabra		dummy