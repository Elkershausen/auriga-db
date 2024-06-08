//20240607 汎用npc作成用の学習スクリプト 001
//エンチャント・アイテム交換・メモリアルダンジョン・クエスト関連NPCを標準化するための学習スクリプトです
//特定の開発者に属人化されている(生殺与奪状態にある)NPCを誰でも70点程度の品質で作れるようになるのを目標としています
//完全なもの、表示や挙動の詳細までこだわるのはできないので、目標となる動作を実現するのを到達点にします(20年前のNPCを今になって修正する状況です)
//今後更新をしてできることを増やしていきます(私も共に学びます)
//どの関数で何をしているのかを学んで下さい

// callfunc "呼び出し定義","呼び出したNPCに使う"+getarg(0)+",呼び出したNPCに使う成功エモーションID,呼び出したNPCに使う失敗エモーション
// プロンテラ
prontera.gat,150,150,4	script	ミミミエンチャ	554,{
	callfunc "mimimiA","prt_ench",21,23;
	close;
}

// アルベルタ
alberta.gat,91,76,4	script	ミミミエンチャ	555,{
	callfunc "mimimiA","alb_ench",21,23;
	close;
}

function	script	mimimiA	{
	while(1) {
	mes "["+getarg(0)+"]";
	mes "どちらにしますか？";
	mes "選んで下さい";
		next;
		switch(select("選択1","選択2")) {
		case 1:
			mes "["+getarg(0)+"]";
			mes "選択1";
			mes "whileに戻る";
			next;
			continue;
		case 2:
			mes "["+getarg(0)+"]";
			mes "選択2";
			mes "終了する";
		close;
		}
	}
}

//ステータス表示
prontera.gat,155,150,4	script	ステータス表示	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "アイテム所持数 : "+countitem(501)+"個";
	mes "最大所持重量 : "+(MaxWeight/10)+"";
	mes "現所持重量 : "+(Weight)/10+"";
	mes "所持残重量 : "+(MaxWeight - Weight)/10+"";
	mes "所持ゼニー : "+Zeny+" Zeny";
	mes "BaseLevel : "+BaseLevel+"";
	mes "Str : "+readparam(bStr)+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "頭上段装備のステータス";
	mes "アイテム名 : "+getequipname(1)+"";
	mes "アイテムID : "+getitemid(getequipname(1))+"";
	mes "精錬可否 : ["+getequipisenableref(1)+"] 1 : 可 2 : 不可";
	mes "精錬値 : +"+getequiprefinerycnt(1)+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+getequipname(1)+" ID : "+getitemid(getequipname(1))+" ";
	mes ""+getequipname(9)+" ID : "+getitemid(getequipname(9))+" ";
	mes ""+getequipname(10)+" ID : "+getitemid(getequipname(10))+" ";
	mes ""+getequipname(2)+" ID : "+getitemid(getequipname(2))+" ";
	mes ""+getequipname(3)+" ID : "+getitemid(getequipname(3))+" ";
	mes ""+getequipname(4)+" ID : "+getitemid(getequipname(4))+" ";
	mes ""+getequipname(5)+" ID : "+getitemid(getequipname(5))+" ";
	mes ""+getequipname(6)+" ID : "+getitemid(getequipname(6))+" ";
	mes ""+getequipname(7)+" ID : "+getitemid(getequipname(7))+" ";
	mes ""+getequipname(8)+" ID : "+getitemid(getequipname(8))+" ";
	mes "終了";
	close;
}
prontera.gat,153,150,4	script	エンチャントテスト	70,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "対象装備のIDを入力";
	next;
	input '@item;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "精錬値を選択";
	next;
	input '@ref;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第1エンチャント(第4スロット)を選択";
	next;
	input '@ench4;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第2エンチャント(第3スロット)を選択";
	next;
	input '@ench3;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第3エンチャント(第2スロット)を選択";
	next;
	input '@ench2;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "第4エンチャント(第1スロット)を選択";
	next;
	input '@ench1;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" 精錬値:+"+'@ref+"";
	mes "第4スロット:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "第3スロット:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "第2スロット:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "第1スロット:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "完成しました";
	next;
	getitem2 '@item,1,1,'@ref,0,'@ench1,'@ench2,'@ench3,'@ench4,0;
	close;
}

prontera.gat,151,150,4	script	実装アイテム	70,{
	mes "[" +strnpcinfo(1)+ "]";
//20240604実装アイテム
getitem 200409,1;
getitem 200410,1;
getitem 200421,1;
getitem 311906,1;
getitem 313327,1;
getitem 313328,1;
getitem 31975,1;
getitem 400668,1;
getitem 400669,1;
getitem 400670,1;
getitem 410322,1;
getitem 410323,1;
getitem 410324,1;
getitem 410325,1;
getitem 410328,1;
getitem 410340,1;
getitem 410341,1;
getitem 420334,1;
getitem 420335,1;
getitem 420336,1;
getitem 420339,1;
getitem 420340,1;
getitem 420341,1;
getitem 450372,1;
getitem 470278,1;
getitem 480429,1;
getitem 480442,1;
getitem 480443,1;
getitem 480444,1;
getitem 480450,1;
close;
}

//ここから下はカード剥がしを実装ベースに書き換えるための研究用
prt_in.gat,28,73,4	script	賢い老女	78,{
	mes "[賢い老女]";
	mes "いい天気だね、若いの。";
	mes "ところで、アタシは武具に装着している";
	mes "カードを取り外す力を持っているけど、";
	mes "力を貸そうかね？";
	next;
	switch(select("お願いします","いくらかかるんですか？","必要ないです")) {
	case 3:
		break;
	case 2:
		mes "[賢い老女]";
		mes "そうだね、";
		mes "まず基本料金として^4040FF200000z^000000。";
		mes "そしてカード１枚につき^4040FF25000z^000000貰うよ。";
		mes "あとは、魔法を使うために^4040FF星のかけら^000000と";
		mes "^4040FFイエロージェムストーン^000000が１つずつ必要だよ。";
		next;
		if(select("お願いします","必要ないです") == 2) {
			break;
		}
		// fall through
	case 1:
		mes "[賢い老女]";
		mes "よしよし。";
		mes "どの武具のカードを取り外すんだね？";
		next;
		set '@part,select("やっぱりやめます",
		                  getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
		                  getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10))-1;
		if('@part == 0)
			break;
		set '@count,getequipcardcnt('@part);
		if('@count <= 0) {
			mes "[賢い老女]";
			mes "若いの、カードがついてないよ。";
			mes "それじゃアタシの出番はないさ。";
			close;
		}
		mes "[賢い老女]";
		mes "この武具には" + '@count + "つカードがついてるね。";
		mes "^0000FF" + ('@count * 25000 + 200000) + "^000000Zenyと^0000FF星のかけら^000000と";
		mes "^0000FFイエロージェムストーン^000000が必要だよ。";
		next;
		if(select("わかりました、お願いします","やっぱりやめます") == 2) {
			break;
		}
		mes "[賢い老女]";
		mes "おっと言い忘れるところだったね。";
		mes "この魔法はとても難しいから、";
		mes "^FF4040失敗するかもしれない^000000のさ。";
		mes "失敗したらカードか武具、あるいは";
		mes "その両方が^FF4040破壊されてしまう^000000かも";
		mes "しれないんだよ。";
		next;
		mes "[賢い老女]";
		mes "失敗しても^FF4040返金はしない^000000から、";
		mes "一応聞いて置くけど、比べるなら";
		mes "カードと武具のどっちが大切だい？";
		next;
		set '@failtype,select("それならやめます","武具の方が大切です","カードの方が大切です")-1;
		if('@failtype == 0)
			break;
		mes "[賢い老女]";
		mes "よし、始めるよ。";
		next;
		if(Zeny < '@count * 25000 + 200000 || countitem(1000) < 1 || countitem(715) < 1) {
			mes "[賢い老女]";
			mes "必要なアイテムが足りないようだね。";
			mes "アイテムを揃えてもう一度来な。";
			close;
		}
		set Zeny,Zeny - ('@count * 25000 + 200000);
		delitem 1000,1;
		delitem 715,1;
		set '@rate,rand(100);
		if('@rate < 2) {
			failedremovecards '@part,0;
			mes "[賢い老女]";
			mes "残念だけど完全に失敗したよ。";
			mes "武具もカードも壊れてしまった。";
			close;
		}
		if('@rate < 6) {
			failedremovecards '@part,'@failtype;
			if('@failtype == 1) {
				mes "[賢い老女]";
				mes "頑張ったけどね、";
				mes "カードのほうは全部壊れてしまったよ。";
				mes "でも武具の方は無事だったよ。";
			}
			else {
				mes "[賢い老女]";
				mes "不運だったね。";
				mes "カードを取り外すのはうまくいったけど";
				mes "武具が壊れてしまったよ。";
			}
			close;
		}
		if('@rate < 10) {
			failedremovecards '@part,3;
			mes "[賢い老女]";
			mes "カードを取り外すのに失敗したよ。";
			mes "でも、不幸中の幸いさ。";
			mes "武具もカードも無事だよ。";
			close;
		}
		successremovecards '@part;
		mes "[賢い老女]";
		mes "うまくいったよ。";
		mes "これらが武具とアイテムさ。じゃあね。";
		close;
	}
	mes "[賢い老女]";
	mes "わかったよ。";
	mes "アタシの力が必要ならいつでも来な。";
	close;
}