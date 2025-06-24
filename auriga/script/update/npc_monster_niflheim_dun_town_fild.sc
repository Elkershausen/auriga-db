//2025/06/24 アップデート
//ニブルヘイムダンジョン(亡者の宴会場) nif_dun01
//ニブルヘイムダンジョン(崩れたオペラハウス) nif_dun02
//追加 map : nif_dun01.gat	map : nif_dun02.gat

//マップフラグ
nif_dun01.gat	mapflag	nomemo	dummy
nif_dun01.gat	mapflag	nosave	SavePoint
nif_dun02.gat	mapflag	nomemo	dummy
nif_dun02.gat	mapflag	nosave	SavePoint

//移動
nif_dun01.gat,134,33,0		warp	nif_dun0001	1,1,nif_dun02.gat,137,18
nif_dun01.gat,157,33,0		warp	nif_dun0002	1,1,nif_dun02.gat,161,18

nif_dun02.gat,137,14,0		warp	nif_dun0003	1,1,nif_dun01.gat,138,33
nif_dun02.gat,161,14,0		warp	nif_dun0004	1,1,nif_dun01.gat,153,33

nif_dun01.gat,146,83,0		warp	nif_dun0005	1,1,prontera.gat,140,184
prontera.gat,140,180,0		warp	nif_dun0006	1,1,nif_dun01.gat,146,86


//モンスター配置
nif_dun01.gat,0,0,0,0	monster	ガンキャン		20935,50,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ブルータルマーダー	20937,50,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ゴーストキューブ	20938,55,5000,0,0
nif_dun01.gat,0,0,0,0	monster	ルードガル		20939,55,5000,0,0
				
nif_dun02.gat,0,0,0,0	monster	ディスガイザー		20936,120,5000,0,0
nif_dun02.gat,0,0,0,0	monster	ブルームーンロリルリ	20940,60,5000,0,0
nif_dun02.gat,0,0,0,0	monster	グロート		20941,120,5000,0,0
nif_dun02.gat,0,0,0,0	monster	ピエロゾイスト		20942,60,5000,0,0
nif_dun02.gat,0,0,0,0	monster	死の大魔女		20943,1,46800000,0,0
