//map_conf.txt�Ƀ}�b�v�̒ǋL
////�T�����p�[�N
//map: jp_ev_alb.gat
//map: jp_ev_pro.gat
//map: jp_ev_yun.gat
//map: jp_ev_mor.gat
//map: jp_ev_gef.gat
//map: jp_ev_pay.gat
//map: jp_ev_pay2.gat

-	script	���H�[�O#summonpark00	-1,{

	mes "[���H�[�O]";
	mes "�T�����p�[�N��";
	mes "�s���܂����H";
	next;
	switch(select("�͂�","������")) {
	case 1:
		mes "[���H�[�O]";
		mes "�}�b�v��I��ł�������";
		next;
		switch(select("jp_ev_pro.gat 117 77","jp_ev_alb.gat 117 56","jp_ev_yun.gat 142 174","jp_ev_mor.gat 164 93","jp_ev_gef.gat 120 100","jp_ev_pay.gat 90 155","jp_ev_pay2.gat 90 155")) {
		case 1: warp "jp_ev_pro",117,77;	end;
		case 2: warp "jp_ev_alb",117,56;	end;
		case 3: warp "jp_ev_yun",142,174;	end;
		case 4: warp "jp_ev_mor",164,93;	end;
		case 5: warp "jp_ev_gef",120,100;	end;
		case 6: warp "jp_ev_pay",90,155;	end;
		case 7: warp "jp_ev_pay2",90,155;	end;
		}
	case 2:
	mes "[���H�[�O]";
	mes "�����p�����҂����Ă��܂�";
	close;
	}
}

prontera.gat,123,83,3		duplicate(���H�[�O#summonpark00)	���H�[�O#00	735
alberta.gat,119,65,3		duplicate(���H�[�O#summonpark00)	���H�[�O#01	735
yuno.gat,143,183,3		duplicate(���H�[�O#summonpark00)	���H�[�O#02	735
morocc.gat,165,103,3		duplicate(���H�[�O#summonpark00)	���H�[�O#03	735
geffen.gat,127,104,3		duplicate(���H�[�O#summonpark00)	���H�[�O#04	735
payon.gat,172,62,3		duplicate(���H�[�O#summonpark00)	���H�[�O#05	735

-	script	���H�[�O#summonpark01	-1,{
	mes "[���H�[�O]";
	mes "�T�����p�[�N����";
	mes "�o�܂����H";
	next;
	switch(select("�͂�","������")) {
	case 1:
		mes "[���H�[�O]";
		mes "�}�b�v��I��ł�������";
		next;
		switch(select("prontera.gat 117 77","alberta.gat 117 56","yuno.gat 142 174","morocc.gat 164 93","geffen.gat 120 100","payon.gat 166 58")) {
		case 1: warp "prontera",117,77;	end;
		case 2: warp "alberta",117,56;	end;
		case 3: warp "yuno",142,174;	end;
		case 4: warp "morocc",164,93;	end;
		case 5: warp "geffen",120,100;	end;
		case 6: warp "payon",166,58;	end;
		}
	case 2:
	mes "[���H�[�O]";
	mes "`���C�����Ă����p������";
	close;
	}
}

jp_ev_pro.gat,123,83,3		duplicate(���H�[�O#summonpark01)	���H�[�O#06	735
jp_ev_alb.gat,119,65,3		duplicate(���H�[�O#summonpark01)	���H�[�O#07	735
jp_ev_yun.gat,143,183,3		duplicate(���H�[�O#summonpark01)	���H�[�O#08	735
jp_ev_mor.gat,165,103,3		duplicate(���H�[�O#summonpark01)	���H�[�O#09	735
jp_ev_gef.gat,127,104,3		duplicate(���H�[�O#summonpark01)	���H�[�O#10	735
jp_ev_pay.gat,90,160,3		duplicate(���H�[�O#summonpark01)	���H�[�O#11	735
jp_ev_pay2.gat,90,160,3		duplicate(���H�[�O#summonpark01)	���H�[�O#12	735
