//map_conf.txtにマップの追記
////サモンパーク
//map: jp_ev_alb.gat
//map: jp_ev_pro.gat
//map: jp_ev_yun.gat
//map: jp_ev_mor.gat
//map: jp_ev_gef.gat
//map: jp_ev_pay.gat
//map: jp_ev_pay2.gat

-	script	ヴォーグ#summonpark00	-1,{

	mes "[ヴォーグ]";
	mes "サモンパークに";
	mes "行きますか？";
	next;
	switch(select("はい","いいえ")) {
	case 1:
		mes "[ヴォーグ]";
		mes "マップを選んでください";
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
	mes "[ヴォーグ]";
	mes "ご利用をお待ちしています";
	close;
	}
}

prontera.gat,123,83,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#00	735
alberta.gat,119,65,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#01	735
yuno.gat,143,183,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#02	735
morocc.gat,165,103,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#03	735
geffen.gat,127,104,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#04	735
payon.gat,172,62,3		duplicate(ヴォーグ#summonpark00)	ヴォーグ#05	735

-	script	ヴォーグ#summonpark01	-1,{
	mes "[ヴォーグ]";
	mes "サモンパークから";
	mes "出ますか？";
	next;
	switch(select("はい","いいえ")) {
	case 1:
		mes "[ヴォーグ]";
		mes "マップを選んでください";
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
	mes "[ヴォーグ]";
	mes "`お気をつけてご利用下さい";
	close;
	}
}

jp_ev_pro.gat,123,83,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#06	735
jp_ev_alb.gat,119,65,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#07	735
jp_ev_yun.gat,143,183,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#08	735
jp_ev_mor.gat,165,103,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#09	735
jp_ev_gef.gat,127,104,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#10	735
jp_ev_pay.gat,90,160,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#11	735
jp_ev_pay2.gat,90,160,3		duplicate(ヴォーグ#summonpark01)	ヴォーグ#12	735
