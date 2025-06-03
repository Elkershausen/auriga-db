//=============================================================
// ニブルヘイムダンジョン(亡者の宴会場) nif_dun01
// ニブルヘイムダンジョン(崩れたオペラハウス) nif_dun02

//Map Flag
nif_dun01.gat	mapflag	nomemo	dummy
nif_dun01.gat	mapflag	nosave	SavePoint
nif_dun02.gat	mapflag	nomemo	dummy
nif_dun02.gat	mapflag	nosave	SavePoint

//warp
1@pag.gat,100,100,0		warp	test0001	1,1,prontera.gat,133,166
1@par.gat,152,109,0		warp	test0002	1,1,prontera.gat,133,166

//mob
nif_dun01.gat,0,0,0,0	monster	ガンキャン		20935,50,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ブルータルマーダー	20937,50,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ゴーストキューブ	20938,55,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ルードガル		20939,55,5000,0,0
				
nif_dun02.gat,0,0,0,0	monster	ディスガイザー		20936,120,5000,0,0
nif_dun02.gat,0,0,0,0	monster	ブルームーンロリルリ	20940,60,5000,0,0
nif_dun02.gat,0,0,0,0	monster	グロート		20941,120,5000,0,0
nif_dun02.gat,0,0,0,0	monster	ピエロゾイスト		20942,60,5000,0,0
nif_dun02.gat,0,0,0,0	monster	死の大魔女		20943,1,46800000,0,0