//20240515 ミミミミッション関連NPC アップデート
//ジュノーの北東に配置
//ミミミミッションNPC ミッション転送員NPC スキルステータスリセットNPC 分析エンチャントNPC 分析精錬NPC 転職・転生サポート員NPC ミッション転送員NPCの土台として実装

yuno.gat,201,325,5	script	調査風来猫	10164,{
	set '@max,100;
	set '@costitem,7347;
	set '@getitemA,23935;
	set '@getitemB,23936;
	mes "[調査風来猫]";
	mes "いらっしゃいませ～。";
	mes "王級メロン";
	mes "を提供していますにゃ。";
	//ここは動作確認用
	mes "所持"+getitemname('@costitem)+" "+countitem('@costitem)+"個";
	mes "交換対象A"+getitemname('@getitemA)+"";
	mes "交換対象B"+getitemname('@getitemB)+"";
	//ここまで
	next;
	mes "[調査風来猫]";
	mes "「^0000ff王級メロン^000000」と";
	mes "「^0000ff王級メロンの箱^000000」について";
	mes "説明しておくにゃ～。";
	next;
	mes "[調査風来猫]";
	mes "「王級メロンの箱」は";
	mes "50個入りのものと";
	mes "150個入りのものがあるにゃ。";
	mes "重量は 150 と 450 にゃ。";
	next;
	mes "[調査風来猫]";
	mes "冒険者の皆さんが";
	mes "ダンジョンの調査にいくのに";
	mes "お腹がすくといけないからって";
	mes "研究会の人達に";
	mes "お店を出さないかって";
	mes "お願いされたのにゃ。";
	next;
	mes "[調査風来猫]";
	mes "本当はニャーも調査したいのだけど";
	mes "仕入れが得意だから";
	mes "出すことにしたのにゃ。";
	mes "調査できない分、「研究記録」を";
	mes "お代としていただいているにゃん。";
	next;
	mes "[調査風来猫]";
	mes "「王級メロン」の効果は";
	mes "次の通りにゃ～。";
	next;
	mes "-^0000ff王級メロン^000000-";
	mes "―――――――――――――";
	mes "HP・SPを3%回復する";
	mes "―――――――――――――";
	mes "NPC売却・倉庫への移動のみ";
	mes "可能です";
	mes "―――――――――――――";
	mes "重量：3";
	next;
	mes "[調査風来猫]";
	mes "「王級メロンの箱」と";
	mes "「王級メロン」には";
	mes "「^ff0000賞味期限^000000」があるにゃ。";
	mes "「倉庫」内であっても期限が過ぎると";
	mes "^ff0000取り出すときに消滅^000000するにゃ。";
	mes "気を付けてちょうだいにゃ～。";
	next;
	mes "【インフォメーション】";
	mes "-「王級メロンの箱」と";
	mes " 中から出てくる";
	mes " 「王級メロン」は";
	mes " 一定期間で自動的に消滅します-";
	next;
	mes "[調査風来猫]";
	mes "説明は以上にゃ～。";
	next;
	switch(select("「王級メロン」がほしい","王級メロンの説明を聞く","話をやめる")) {
	case 1:
		switch(select(""+getitemname('@getitemA)+"",""+getitemname('@getitemB)+"","やっぱりやめる")) {
			case 1:
				mes "[調査風来猫]";
				mes "「"+getitemname('@getitemA)+"」は";
				mes "1セットにつき";
				mes "「^0000ff"+getitemname('@costitem)+"^000000」が3個必要にゃ。";
				mes "一度に100セットまで";
				mes "渡すことができるにゃ。";
				mes "「0」セットなら、取引は終わりにするにゃ。";
				next;
				input '@num;
				set '@Weight,'@num*150;
				set '@Price,'@num*3;
				set '@Gain,'@num;
				if('@num > '@max) {
					mes "[調査風来猫]";
					mes "え？";
					mes "ちょっと多すぎです。";
					close;
				}
				if('@num <= 0) {
					mes "[調査風来猫]";
					mes "またのご利用";
					mes "お待ちしていますにゃ～";
					close;
				}
				if(countitem('@costitem) < '@Price) {
					mes "[調査風来猫]";
					mes "^0000ff"+getitemname('@costitem)+"^000000が";
					mes "足りないにゃ～";
				close;
				}
				if(((MaxWeight - Weight)/10) <= '@Weight) {
					mes "[調査風来猫]";
					mes "^0000ff"+getitemname('@getitemA)+"^000000は";
 					mes "重量の空き" + ('@Weight) + "必要にゃ～。";
					mes "荷物の整理をしてから来てにゃ～。";
					close;
				}
				delitem '@costitem,'@price;
				getitem2 '@getitemA,'@Gain,1,0,0,0,0,0,0,259200;
				mes "[調査風来猫]";
				mes "またのご利用";
				mes "お待ちしていますにゃ～";
				close;
			case 2:
				mes "[調査風来猫]";
				mes "「"+getitemname('@getitemB)+"」は";
				mes "1セットにつき";
				mes "「^0000ff"+getitemname('@costitem)+"^000000」が9個必要にゃ。";
				mes "一度に100セットまで";
				mes "渡すことができるにゃ。";
				mes "「0」セットなら、取引は終わりにするにゃ。";
				next;
				input '@num;
				set '@Weight,'@num*150;
				set '@Price,'@num*9;
				set '@Gain,'@num;
				if('@num > '@max) {
					mes "[調査風来猫]";
					mes "え？";
					mes "ちょっと多すぎにゃ～。";
				close;
				}
					if('@num <= 0) {
					mes "[調査風来猫]";
					mes "またのご利用";
					mes "お待ちしていますにゃ～";
				close;
				}
				if(countitem('@costitem) < '@Price) {
					mes "[調査風来猫]";
					mes "^0000ff"+getitemname('@costitem)+"^000000が";
					mes "足りないにゃ～";
				close;
				}
				if(((MaxWeight - Weight)/10) <= '@Weight) {
					mes "[調査風来猫]";
					mes "^0000ff"+getitemname('@getitemB)+"^000000は";
 					mes "重量の空き" + ('@Weight) + "必要にゃ～。";
					mes "荷物の整理をしてから来てにゃ～。";
				close;
				}
				delitem '@costitem,'@price;
				getitem2 '@getitemB,'@Gain,1,0,0,0,0,0,0,259200;
				mes "[調査風来猫]";
				mes "またのご利用";
				mes "お待ちしていますにゃ～";
				close;
			case 3:
				mes "[調査風来猫]";
				mes "またのご利用";
				mes "お待ちしていますにゃ～";
				close;
			}
	case 2:
		mes "[調査風来猫]";
		mes "王級メロンの説明を聞く";
		mes "食べると元気になる";
		mes "王級メロンにゃ。";
		mes "タダというわけには";
		mes "いかないのだけれども";
		mes "調査に協力してくれれば";
		mes "王級メロンと交換してあげますにゃ。";
		next;
		mes "＜＜ラインナップ＞＞";
		mes "■"+getitemname('@getitemA)+"";
		mes "【^ff0000"+getitemname('@costitem)+"^000000】を";
		mes "3個";
		mes "■"+getitemname('@getitemB)+"";
		mes "【^ff0000"+getitemname('@costitem)+"^000000】を";
		mes "9個";
		close;	
	case 3:
		mes "[調査風来猫]";
		mes "話をやめる";
		mes "またのご利用";
		mes "お待ちしていますにゃ～";
		close;
	}
}
//騎乗は未実装

//yuno.gat,202,302,4	script	倉庫	464,{//npc_signboard.scに実装//}
yuno.gat,205,316,4	script	カプラ職員	112,{
	cutin "kafra_06",2;
	set '@code,8;
	set '@price,1200;
	callfunc "KafraMain",0,0x1ff,"yuno.gat",205,316,"NULL",0,0,40,800,'@code,'@price;
	close2;
	cutin "kafra_05",255;
	end;
}
yuno.gat,214,316,3	script	流しの治療師	569,{
	mes "[流しの治療師]";
	mes "ここはHPとSPの";
	mes "回復サービスです。";
	next;
	mes "[流しの治療師]";
	mes "^0000ffレベルが99以下^000000の";
	mes "プレイヤーは無料で";
	mes "^0000ff100以上の^000000場合は";
	mes "^ff00005000ゼニー^000000をいただきます。";
	mes "サービスを利用しますか？";
	next;
	switch(select("回復サービスを受ける","やっぱりやめる")) {
	case 1:
		if(BaseLevel <= 99) {
		mes "[流しの治療師]";
		mes "回復します。";
		next;
		mes "[流しの治療師]";
		mes "またのご利用";
		mes "お待ちしています。";
		misceffect 14,1;
		percentheal 100,100;
		close;
		} else {
			if(Zeny < 5000) {
			mes "[流しの治療師]";
			mes "ゼニーが足りません";
			close;
			}
			mes "[流しの治療師]";
			mes "回復します。";
			next;
			mes "[流しの治療師]";
			mes "またのご利用";
			mes "お待ちしています。";
			set Zeny,Zeny-5000;
			misceffect 14,1;
			percentheal 100,100;
			close;
			}
	case 2:
		mes "[流しの治療師]";
		mes "またのご利用";
		mes "お待ちしています。";
		close;
	}
}
//ミミミ装備の分析精錬に改修予定
yuno.gat,197,291,3	script	ホルグレン	85,{
	callfunc "Refine1","ホルグレン",21,23;
	close;
}
yuno.gat,192,291,4	shop	道具商人	84,1750,611,501,502,503,504,506,645,656,601,602

//実装作業中
yuno.gat,205,307,4	script	騎乗レンタル	105,{

	set '@Falcon,2500;
	mes "[騎乗レンタル]";
	mes "ここでは各種乗り物を";
	mes "レンタルします";
	next;
	switch(select("ファルコン","ペコペコレンタル","ウォーグ","魔導ギア")) {
	
	}
	close;
}
