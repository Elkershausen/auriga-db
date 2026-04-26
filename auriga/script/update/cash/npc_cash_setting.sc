// 2026/04/07 アップデート
// map :iz_gimlet.gat 追加
// マップフラグ追加

// イズルード -> ギムレット部屋
izlude.gat,122,151,3	script	アイテム配布係#26517	833,{

	set '@npcname$, "[" + strnpcinfo(1) + "]";

	mes '@npcname$;
	mes "こんにちは！"; mes "私は、アイテム配布係の"; mes "ギムレットと申します。";
	mes "各種キャンペーンや"; mes "サービスをご利用でしょうか？？";
	next;
	if(select("はい(iz_gimlet.gat)","いいえ、違います") == 2) { mes '@npcname$; mes "ご利用お待ちしています。"; close; }
	mes '@npcname$; mes "それでは、部屋へご案内いたします。"; close2; warp "iz_gimlet",43,86; end;
}

// ワープで戻る (118,153)
iz_gimlet.gat,49,86,1		warp	gim001	1,1,izlude.gat,122,149

// 仮置き
iz_gimlet.gat,43,95,3	script	カプラ職員#26520	117,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,43,90,3	script	アイテム配布係#26521	833,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,42,77,3	script	リース#30062	62,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,38,77,3	script	タメシーニャ#31061	555,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,34,73,3	script	石片収集家#31670	900,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,26,97,3	script	ヴァルキリーの使者#33582	124,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,30,97,3	script	転職チケット員#33597	125,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,43,99,3	script	ジメジメ少女#34344	693,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,13,85,3	script	エリートブリーダー#34722	124,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,17,97,3	script	プレミィ#36237	10209,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,34,97,3	script	レベルアップチケット員#37017	859,{ mes "npc_test_setting"; mes "仮置き";close; }
iz_gimlet.gat,13,89,3	script	アッキーラ教授#37186	749,{ mes "npc_test_setting"; mes "仮置き";close; }

//マップフラグここから
//iz_gimlet.gat	mapflag	nosave		SavePoint
//iz_gimlet.gat	mapflag	nomemo		dummy
iz_gimletason01.gat	mapflag	noteleport	dummy
iz_gimlet.gat	mapflag	nobranch	dummy
iz_gimlet.gat	mapflag	monster_noteleport	dummy
iz_gimlet.gat	mapflag	noicewall	dummy
iz_gimlet.gat	mapflag	noabra		dummy