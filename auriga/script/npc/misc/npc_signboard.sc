//20240522 サインボードを土台に倉庫NPC実装
//20240613 ミミック倉庫を1箇所に4つ設置（見た目重視で機能は変わりません） セキュアログインボーナス基礎NPC設置

//倉庫NPC-------------------------------------------------------------------------
-	script	倉庫#mimic50z	464,{
	if(Zeny < 50) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

//常設 50z-------------------------------------------------------------------------
payon.gat,177,67,5	duplicate(倉庫#mimic50z)	倉庫#1001	464
payon.gat,179,67,3	duplicate(倉庫#mimic50z)	倉庫#1002	464
payon.gat,181,67,3	duplicate(倉庫#mimic50z)	倉庫#1003	464
payon.gat,183,67,3	duplicate(倉庫#mimic50z)	倉庫#1004	464

morocc.gat,179,56,5	duplicate(倉庫#mimic50z)	倉庫#1005	464
morocc.gat,181,56,3	duplicate(倉庫#mimic50z)	倉庫#1006	464
morocc.gat,183,56,3	duplicate(倉庫#mimic50z)	倉庫#1007	464
morocc.gat,185,56,3	duplicate(倉庫#mimic50z)	倉庫#1008	464

aldebaran.gat,167,122,5	duplicate(倉庫#mimic50z)	倉庫#1009	464
aldebaran.gat,169,124,3	duplicate(倉庫#mimic50z)	倉庫#1010	464
aldebaran.gat,171,126,3	duplicate(倉庫#mimic50z)	倉庫#1011	464
aldebaran.gat,173,128,3	duplicate(倉庫#mimic50z)	倉庫#1012	464

comodo.gat,162,177,5	duplicate(倉庫#mimic50z)	倉庫#1013	464
comodo.gat,164,177,3	duplicate(倉庫#mimic50z)	倉庫#1014	464
comodo.gat,166,177,3	duplicate(倉庫#mimic50z)	倉庫#1015	464
comodo.gat,168,177,3	duplicate(倉庫#mimic50z)	倉庫#1016	464

alberta.gat,144,62,5	duplicate(倉庫#mimic50z)	倉庫#1017	464
alberta.gat,146,62,3	duplicate(倉庫#mimic50z)	倉庫#1018	464
alberta.gat,148,62,3	duplicate(倉庫#mimic50z)	倉庫#1019	464
alberta.gat,150,62,3	duplicate(倉庫#mimic50z)	倉庫#1020	464

lighthalzen.gat,172,124,5	duplicate(倉庫#mimic50z)	倉庫#1021	464
lighthalzen.gat,170,124,3	duplicate(倉庫#mimic50z)	倉庫#1022	464
lighthalzen.gat,168,124,3	duplicate(倉庫#mimic50z)	倉庫#1023	464
lighthalzen.gat,166,124,3	duplicate(倉庫#mimic50z)	倉庫#1024	464

mid_camp.gat,43,163,5	duplicate(倉庫#mimic50z)	倉庫#1025	464
mid_camp.gat,45,163,3	duplicate(倉庫#mimic50z)	倉庫#1026	464
mid_camp.gat,47,163,3	duplicate(倉庫#mimic50z)	倉庫#1027	464
mid_camp.gat,49,163,3	duplicate(倉庫#mimic50z)	倉庫#1028	464

brasilis.gat,174,225,5	duplicate(倉庫#mimic50z)	倉庫#1029	464
brasilis.gat,176,225,3	duplicate(倉庫#mimic50z)	倉庫#1030	464
brasilis.gat,178,225,3	duplicate(倉庫#mimic50z)	倉庫#1031	464
brasilis.gat,180,225,3	duplicate(倉庫#mimic50z)	倉庫#1032	464

ref_room01.gat,19,40,5	duplicate(倉庫#mimic50z)	倉庫#1033	464
ref_room01.gat,21,40,3	duplicate(倉庫#mimic50z)	倉庫#1034	464
ref_room01.gat,23,40,3	duplicate(倉庫#mimic50z)	倉庫#1035	464
ref_room01.gat,25,40,3	duplicate(倉庫#mimic50z)	倉庫#1036	464

ref_room02.gat,19,40,5	duplicate(倉庫#mimic50z)	倉庫#1037	464
ref_room02.gat,21,40,3	duplicate(倉庫#mimic50z)	倉庫#1038	464
ref_room02.gat,23,40,3	duplicate(倉庫#mimic50z)	倉庫#1039	464
ref_room02.gat,25,40,3	duplicate(倉庫#mimic50z)	倉庫#1040	464

lasagna.gat,325,241,5	duplicate(倉庫#mimic50z)	倉庫#1041	464
lasagna.gat,327,241,3	duplicate(倉庫#mimic50z)	倉庫#1042	464
lasagna.gat,329,241,3	duplicate(倉庫#mimic50z)	倉庫#1043	464
lasagna.gat,331,241,3	duplicate(倉庫#mimic50z)	倉庫#1044	464

//----------------------------------------------------------------------------------
-	script	倉庫#mimic40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

//イベント 40z-------------------------------------------------------------------------
yuno.gat,199,300,5	duplicate(倉庫#mimic40z)	倉庫#1101	464
yuno.gat,201,300,3	duplicate(倉庫#mimic40z)	倉庫#1102	464
yuno.gat,203,300,3	duplicate(倉庫#mimic40z)	倉庫#1103	464
yuno.gat,205,300,3	duplicate(倉庫#mimic40z)	倉庫#1104	464

//val_tea1.gat,290,352,4	duplicate(倉庫#mimic40z)	倉庫#000	464
//march_01.gat,128,37,4	duplicate(倉庫#mimic40z)	倉庫#001	464
//apr_main1.gat,135,64,4	duplicate(倉庫#mimic40z)	倉庫#002	464
//apr_ruins_s.gat,49,73,4	duplicate(倉庫#mimic40z)	倉庫#003	464
//apr_forge1.gat,75,57,4	duplicate(倉庫#mimic40z)	倉庫#004	464
//apr_forge2.gat,75,57,4	duplicate(倉庫#mimic40z)	倉庫#005	464
//apr_forge3.gat,75,57,4	duplicate(倉庫#mimic40z)	倉庫#006	464
//apr_forge4.gat,75,57,4	duplicate(倉庫#mimic40z)	倉庫#007	464
//apr_forge5.gat,75,57,4	duplicate(倉庫#mimic40z)	倉庫#008	464
//melon_f1.gat,128,69,4	duplicate(倉庫#mimic40z)	倉庫#009	464
//melon_f1.gat,136,103,4	duplicate(倉庫#mimic40z)	倉庫#010	464
//apr_rui2_s.gat,18,97,4	duplicate(倉庫#mimic40z)	倉庫#011	464
//melon_que1.gat,227,65,4	duplicate(倉庫#mimic40z)	倉庫#012	464
//melon_que1.gat,218,20,4	duplicate(倉庫#mimic40z)	倉庫#013	464
//melon_que1.gat,229,149,4	duplicate(倉庫#mimic40z)	倉庫#014	464
//apr_rui3_s.gat,54,53,4	duplicate(倉庫#mimic40z)	倉庫#015	464
//hal_fes2.gat,212,171,4	duplicate(倉庫#mimic40z)	倉庫#016	464
//e_june01.gat,177,184,4	duplicate(倉庫#mimic40z)	倉庫#017	464
//apr_rui4_s.gat,69,145,4	duplicate(倉庫#mimic40z)	倉庫#018	464

//リセットNPC-------------------------------------------------------------------------
-	script	リセット職員#reset000	117,{
	if(BaseLevel >= 151) {
	mes "[リセット職員]";
	mes "リセットは";
	mes "BaseLv150までです";
	close;
	}
	mes "[リセット職員]";
	mes "いらっしゃいませ";
	mes "こちらではステータス、スキルの";
	mes "リセットを行えます。";
	mes "BaseLevl150までなら";
	mes "リセットは無料です。";
	next;
	switch(select("ステータスリセット","スキルリセット","やっぱりやめる")) {
	case 1:
		resetstatus;
		mes "[リセット職員]";
		mes "リセット完了しました。";
		mes "またご利用下さい。";
 		close;
	case 2:
		resetskill;
		mes "[リセット職員]";
		mes "リセット完了しました。";
		mes "またご利用下さい。";
		close;
	CASE 3:
		mes "[リセット職員]";
		mes "またののご利用";
		mes "お待ちしています。";
		close;
	}
}

//常設-------------------------------------------------------------------------
yuno.gat,225,324,6	duplicate(リセット職員#reset000)	リセット職員#100	121
lasagna.gat,313,229,6	duplicate(リセット職員#reset000)	リセット職員#101	554
//ev_city.gat,244,324,6	duplicate(リセット職員#reset000)	リセット職員#102	121
//ev_city.gat,116,315,6	duplicate(リセット職員#reset000)	リセット職員#103	121
//ev_city.gat,175,148,6	duplicate(リセット職員#reset000)	リセット職員#104	121

//セキュアログインボーナス------------------------------------------------------

-	script	ｾｷｭｱﾛｸﾞｲﾝﾎﾞｰﾅｽ#login	740,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "特殊NPCによる転送サービス";
	mes "転送可 街36箇所";
	mes "異世界の街6箇所";
	mes "次元の狭間 時の通路01 02";
	mes "フレイムヴァレー";
	mes "平ダンジョン";
	mes "イリュージョンダンジョン";
	mes "テラージョンダンジョン";
	mes "メモリアルダンジョン";
	mes "ビフロストタワー2箇所";
	mes "カミダトンネル";
	mes "イグドラシル中心部";
	mes "修道院とかフィールド9箇所";
	close;
}