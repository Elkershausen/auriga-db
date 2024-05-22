//20240522 サインボードを土台に倉庫NPC実装

-	script	倉庫#mimic50z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-50;
	openstorage;
}

//常設 50z
payon.gat,290,67,4	duplicate(倉庫#mimic50z)	倉庫#101	464
morocc.gat,182,56,4	duplicate(倉庫#mimic50z)	倉庫#102	464
aldebaran.gat,172,126,4	duplicate(倉庫#mimic50z)	倉庫#103	464
comodo.gat,165,177,4	duplicate(倉庫#mimic50z)	倉庫#104	464
alberta.gat,147,62,4	duplicate(倉庫#mimic50z)	倉庫#105	464
lighthalzen.gat,169,124,4	duplicate(倉庫#mimic50z)	倉庫#106	464
mid_camp.gat,46,163,4	duplicate(倉庫#mimic50z)	倉庫#107	464
brasilis.gat,177,225,4	duplicate(倉庫#mimic50z)	倉庫#108	464
ref_room01.gat,22,40,4	duplicate(倉庫#mimic50z)	倉庫#109	464
ref_room02.gat,22,40,4	duplicate(倉庫#mimic50z)	倉庫#110	464

-	script	倉庫#mimic40z	464,{
	if(Zeny < 40) {
	mes "ゼニーが足りません";
	close;
	}
	set Zeny,Zeny-40;
	openstorage;
}

//イベント 40z
yuno.gat,202,302,4	duplicate(倉庫#mimic40z)	倉庫#101	464
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
