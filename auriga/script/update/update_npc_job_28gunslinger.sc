//2025/05/07 アップデート
//ショップNPC更新 / バレット交換NPC更新 / 箱詰めNPC更新 / スラッグ弾交換NPC実装
//ショップ[シルバーバレット][ブラッドバレット] -> [シルバーバレットC][ブラッドバレットC] 変更 / 新種バレット追加
//npc_job_28gunslinger.sc 上書き

//= 永久フラグ ===================================================================
// CHANGE_GS -> 0〜5
//============================================================
// ショップ スフィア廃止 / バレット販売に変更 2025/05/07 アップデート
//------------------------------------------------------------
que_ng.gat,179,91,3	shop	武器商人・シバス	900,13150,13102,13151,13154,13155,13163,13165,13168
que_ng.gat,180,79,3	shop	武器商人・ウィコ	900,13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232
alberta.gat,176,81,3	shop	貿易商人	900,13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232,13150,13102,13151,13154,13155,13163,13165,13168
//============================================================
// 試験申請
//------------------------------------------------------------
que_ng.gat,152,167,3	script	マスターミラー	901,{
	if(Job == Job_Gunslinger) {
		mes "[マスターミラー]";
		mes "久しぶりだな。";
		mes "銃は大切に扱うんだぞ。";
		next;
		mes "[マスターミラー]";
		mes "そうだ。";
		mes "ガンスリンガーになったのなら、";
		mes "冒険者アカデミーを";
		mes "訪れてみるといい。";
		next;
		mes "[マスターミラー]";
		mes "この建物を出ると、";
		mes "冒険者アカデミーでサポートを";
		mes "行っている人がいるだろうから、";
		mes "送ってもらうといい。";
		close;
	}
	if(Upper == Upper_BABY) {
		mes "[マスターミラー]";
		mes "……何故ここに子供が……";
		next;
		mes "[マスターミラー]";
		mes "お母さんの元に帰りなさい。";
		mes "ここは危ない。";
		close;
	}
	if(Job != Job_Novice || Upper == Upper_HIGH) {
		mes "[マスターミラー]";
		mes "私と目を合わせないでくれ。";
		mes "ここはお店じゃないんだ。";
		close;
	}
	switch(CHANGE_GS) {
	case 0:
		if(getskilllv(1) < 9) {
			mes "[マスターミラー]";
			mes "ふむ……";
			mes "私の目が確かなら、";
			mes "君は十分な可能性を秘めている。";
			mes "しかし、足りないものがあるようだ。";
			next;
			mes "[マスターミラー]";
			mes "JobLvを10にまで成長させ、";
			mes "^0000FF「基本スキル」のレベルを9　^000000に";
			mes "したまえ。";
			mes "^0000FF「基本スキル」^000000のレベルは";
			mes "^0000FF「スキルリスト」^000000ウィンドウで";
			mes "上げることができる。";
			next;
			mes "[マスターミラー]";
			mes "^0000FF「スキルリスト」^000000ウィンドウは";
			mes "^0000FF「基本情報」^000000ウィンドウ内の";
			mes "^0000FF「Skill」^000000ボタンで表示される。";
			next;
			mes "[マスターミラー]";
			mes "スキルのレベルを上げるには、";
			mes "スキルポイントを割り振った後、";
			mes "^FF0000「確定」^000000ボタンが必要となる。";
			mes "注意するように。";
			next;
			mes "[マスターミラー]";
			mes "更なる努力を重ね、";
			mes "基本的な技術を磨いたら";
			mes "もう一度来るといい。";
			close2;
			cutin "start_020_jp.bmp",4;
			end;
		}
		mes "[マスターミラー]";
		mes "私はセルレナお嬢さんの";
		mes "警護主任であり、";
		mes "ガンスリンガー訓練教官でもある";
		mes "マスターミラー。";
		next;
		mes "[マスターミラー]";
		mes "一時も無駄にできないこの私に";
		mes "声を掛けた理由は何だね？";
		next;
		if(select("べつに……","ガンスリンガーになりたいです")==1) {
			mes "[マスターミラー]";
			mes "私の貴重な時間を";
			mes "無駄にさせるとは……";
			mes "今すぐ私の前から消えろ。";
			close;
		}
		mes "[マスターミラー]";
		mes "ほほぅ……";
		mes "まだ幼いが、";
		mes "なかなか良い目をしている。";
		next;
		mes "[マスターミラー]";
		mes "ふむ……よかろう。";
		mes "本気でガンスリンガーになりたいなら";
		mes "まず簡単な手続きが必要。";
		mes "その後、面接と教育がある。";
		next;
		mes "[マスターミラー]";
		mes "その覚悟はあるかね？";
		next;
		if(select("少し考えてみます","あります")==1) {
			mes "[マスターミラー]";
			mes "む……そうか。";
			mes "だが、この職業は";
			mes "慎重な者でなければ勤まらん。";
			mes "決心がついてから";
			mes "また来るといい。";
			close;
		}
		mes "[マスターミラー]";
		mes "よかろう。";
		mes "では、この手紙を持って";
		mes "フェイヨンにいらっしゃる";
		mes "ファンソプル様を";
		mes "訪ねなさい。";
		next;
		mes "[マスターミラー]";
		mes "その方が君を、";
		mes "ガンスリンガーとして";
		mes "相応しい人間なのか";
		mes "判断してくださる。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "はい！　わかりました。";
		set CHANGE_GS,1;
		setquest 6020;
		close;
	case 1:
		mes "[マスターミラー]";
		mes "はやく行きなさい。";
		mes "ファンソプル様は";
		mes "フェイヨンにいらっしゃる。";
		close;
	case 2:
		mes "[マスターミラー]";
		mes "ファンソプル様が";
		mes "印の材料と？";
		mes "…………";
		next;
		mes "[マスターミラー]";
		mes "どうやらファンソプル様は、";
		mes "君の事が気に入られたようだな。";
		close;
	case 3:
		mes "[マスターミラー]";
		mes "頼まれごとをされたのか？";
		mes "ファンソプル様によっぽど";
		mes "気に入られたらしいな。";
		close;
	case 4:
		mes "[マスターミラー]";
		mes "君には期待している。";
		mes "早くファンソプル様の元へ";
		mes "行くといい。";
		close;
	case 5:
		mes "[マスターミラー]";
		mes "ファンソプル様から";
		mes "印を受け取ってきたな。";
		mes "……本当に久しぶりだ。";
		mes "普通はそう簡単には";
		mes "印はもらえないのだがな。";
		next;
		mes "[マスターミラー]";
		mes "よし、いいだろう。";
		mes "ファンソプル様に許されたなら";
		mes "私が拒否する理由は無い。";
		next;
		mes "[マスターミラー]";
		mes "では、私は君を";
		mes "ガンスリンガーとして任命する。";
		mes "だがその前に、";
		mes "ガンスリンガーについて";
		mes "重要な説明をしよう。";
		next;
		mes "[マスターミラー]";
		mes "武器と実弾の購入は、";
		mes "各地にいるガンスリンガーギルドの";
		mes "関係者を通して行う。";
		next;
		mes "[マスターミラー]";
		mes "面倒だとは思うだろうが、";
		mes "この武器を悪用されないため、";
		mes "悪人の手に渡らないための処置だ。";
		mes "理解してくれ。";
		next;
		mes "[マスターミラー]";
		mes "他にも様々な理由がある。";
		mes "だが、これらの規定は全て、";
		mes "何時か君もお会いするだろう、";
		mes "このギルドの責任者である";
		mes "セルレナお嬢様の指示だ。";
		next;
		mes "[マスターミラー]";
		mes "時がくれば、";
		mes "君に与えられる任務とともに";
		mes "お嬢様の意思が理解できるだろう。";
		next;
		mes "[マスターミラー]";
		mes "では、私はそろそろ別の用があるので。";
		mes "大地の加護が君と共にあるのを祈り、";
		mes "この武器と、";
		mes "ガンスリンガーの指南書である";
		mes "ガンスリンガーの書を君に授けよう。";
		unequip;
		jobchange Job_Gunslinger;
		set CHANGE_GS,0;
		chgquest 6024,50550;
		getitem 11049,1;
		getitem 13100,1;
		getitem 12149,5;
		close;
	}
OnInit:
	waitingroom "転職",0;
	end;
}

//============================================================
// 転職試験
//------------------------------------------------------------
payon.gat,184,65,3	script	ファンソプル	866,{
	if(Job == Job_Gunslinger) {
		mes "[ファンソプル]";
		mes "うむ……久しぶりじゃの。";
		mes "賢い野獣になるのじゃぞ。";
		close;
	}
	switch(CHANGE_GS) {
	case 0:
		mes "[ファンソプル]";
		mes "ぐぅ……ぐぅぐぅ……";
		close;
	case 1:
		mes "[ファンソプル]";
		mes "……ん……";
		mes "……若いオオカミが来おった……";
		mes "ワシに何の用かな？";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "ミラーさんの紹介で";
		mes "ここに来ました。";
		next;
		mes "[ファンソプル]";
		mes "ミラー……";
		mes "……あぁ、黒い狐の";
		mes "紹介で来たのかね……";
		next;
		mes "[ファンソプル]";
		mes "彼はいい人だ……";
		mes "仲間のためなら命も";
		mes "かけることができる、";
		mes "正義の心を持っている。";
		next;
		mes "[ファンソプル]";
		mes "彼の紹介なら、";
		mes "何の用か大体わかる……";
		next;
		mes "[ファンソプル]";
		mes "さぁ……もう少し";
		mes "こっちに来なさい……";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "…………";
		next;
		mes "[ファンソプル]";
		mes "ん……";
		mes "うんうん……";
		next;
		mes "[ファンソプル]";
		mes "……清らかな目と";
		mes "善良な心……そして";
		mes "大事なものを守ることができる";
		mes "責任感を持っている……";
		mes "しかし……幼い……";
		next;
		mes "[ファンソプル]";
		mes "まだ経験が不足している……";
		mes "荒野と大地の祝福を";
		mes "受けることができん……";
		mes "だから、お主の代わりとなる";
		mes "大地の印を作ってやろう。";
		next;
		mes "[ファンソプル]";
		mes "華麗な蟲の皮3個、木屑1個、";
		mes "かたい皮10個、やわらかな毛3個";
		mes "ジャルゴン3個、緑ハーブ3個";
		mes "を持って来るのだ。";
		next;
		mes "[ファンソプル]";
		mes "それらで作った大地の印を";
		mes "黒い狐に見せれば、";
		mes "お主の願いはかなうだろう。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-華麗な蟲の皮3個、木屑1個、";
		mes "かたい皮10個、やわらかな毛3個";
		mes "ジャルゴン3個、緑ハーブ3個";
		mes "を取りに行こう-";
		set CHANGE_GS,2;
		chgquest 6020,6021;
		close;
	case 2:
		if(countitem(1013) < 3 || countitem(1019) < 1 || countitem(935) < 10 || countitem(949) < 3 || countitem(912) < 3 || countitem(511) < 3) {
			mes "[" +strcharinfo(0)+ "]";
			mes "-華麗な蟲の皮3個、木屑1個、";
			mes "かたい皮10個、やわらかな毛3個";
			mes "ジャルゴン3個、緑ハーブ3個";
			mes "を取りに行こう-";
			close;
		}
		mes "[ファンソプル]";
		mes "ん……よく持ってきたな。";
		mes "印を作るにはしばしの時間が";
		mes "必要じゃ。";
		mes "しばらく待っておれ。";
		set CHANGE_GS,3;
		chgquest 6021,6022;
		delitem 1013,3;
		delitem 1019,1;
		delitem 935,10;
		delitem 949,3;
		delitem 912,3;
		delitem 511,3;
		close;
	case 3:
		mes "[ファンソプル]";
		mes "ん……ちょうどいい。";
		mes "今、準備ができたところじゃ。";
		mes "単純な印ではあるが……";
		mes "久しぶりじゃ……";
		next;
		mes "[ファンソプル]";
		mes "印を作り始めて、";
		mes "もう数十年になるか……";
		mes "ワシにも大地の戦士として、";
		mes "このような印をつけて";
		mes "戦った時があった……";
		next;
		mes "[ファンソプル]";
		mes "セルレナの父に出会ったのが";
		mes "ついこの間のようじゃ……";
		mes "本当に……時間というやつは";
		mes "空に吹く風のように過ぎ去る……";
		next;
		mes "[ファンソプル]";
		mes "色々な事があったが……";
		mes "ワシが守ってきた意思を";
		mes "受け継ぎ、大切にしてくれる";
		mes "セルレナと黒い狐。";
		mes "そして多くの若者達に";
		mes "感謝している……";
		next;
		mes "[ファンソプル]";
		mes "ワシは老いて、もう力が無い。";
		mes "やがて大地の元へ";
		mes "帰る日が来るであろう……";
		next;
		mes "[ファンソプル]";
		mes "……ふぅ。";
		mes "急に疲れがきおった。";
		mes "悪いが、最後に一つだけ";
		mes "頼みがあるんじゃが……";
		next;
		mes "[ファンソプル]";
		mes "のどが渇いての……";
		mes "冷たいミルクを一杯飲みたい。";
		next;
		mes "[ファンソプル]";
		mes "おいぼれの頼みを";
		mes "聞いてもらえんかの。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-お爺さんのために";
		mes "ミルクを一本買ってこよう-";
		set CHANGE_GS,4;
		chgquest 6022,6023;
		close;
	case 4:
		if(countitem(519) < 1) {
			mes "[" +strcharinfo(0)+ "]";
			mes "-お爺さんのために";
			mes "ミルクを一本買ってこよう-";
			close;
		}
		set CHANGE_GS,5;
		chgquest 6023,6024;
		delitem 519,1;
		mes "[ファンソプル]";
		mes "ありがとう。";
		mes "本当に心がきれいな若者じゃな。";
		next;
		mes "[ファンソプル]";
		mes "ほれ。";
		mes "これがワシの作った印じゃ。";
		mes "これを黒い狐に見せれば";
		mes "ガンスリンガーになれるじゃろう。";
		next;
	case 5:
		mes "[ファンソプル]";
		mes "んん〜〜ん〜ふ〜ん〜らら〜";
		mes "ららる〜ん〜んん〜〜〜";
		next;
		mes "[" + strcharinfo(0) + "]";
		mes "‐お爺さんは、突然";
		mes "歌を口ずさんだ‐";
		mes "‐歌詞も無いのに、";
		mes "なんだか不思議な気持ちになる‐";
		next;
		mes "[" + strcharinfo(0) + "]";
		mes "‐さぁ、受けとった印を";
		mes "ミラーさんに見せに行こう‐";
		close;
	}
}

//============================================================
// 弾丸屋トニー 2025/05/07 アップデート
//------------------------------------------------------------
-	script	SphereShop	86,{

	setarray '@itemA[0],1010,1011,6961;
	setarray '@itemB[0],1010,1011,6832;
	setarray '@rate[0],2,20;
	set '@itemC,25187;

//職制限有効化ここから
//	if(Job != Job_Gunslinger) {
//		mes "["+strnpcinfo(1)+"]";
//		mes "私はガンスリンガーの方に";
//		mes "スラッグ弾を交換している";
//		mes "トニーと言います。";
//		next;
//		mes "[ケニー]";
//		mes "あなたはガンスリンガーではないので";
//		mes "弾丸を扱えません。";
//		mes "申し訳ありません。";
//		close;
//	}
//職制限有効化ここまで

	mes "["+strnpcinfo(1)+"]";
	mes "私はガンスリンガーの方に";
	mes "スラッグ弾を交換している";
	mes "トニーと言います。";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes "アイテムを"+getitemname('@itemC)+"に交換します";
	mes "Aパターン:"+getitemname('@itemA[2])+" 1個";
	mes ""+getitemname('@itemA[0])+" 1個 "+getitemname('@itemA[1])+" 1個";
	mes ""+getitemname('@itemC)+" "+'@rate[0]+"個組 1セット";
	mes "Bパターン : "+getitemname('@itemB[2])+" 1個";
	mes ""+getitemname('@itemB[0])+" 1個 "+getitemname('@itemB[1])+" 1個";
	mes ""+getitemname('@itemC)+" "+'@rate[1]+"個組 1セット";
	mes "どちらにしますか？";
	next;
	switch(select(
		"やめる",
		"Aパターン",
		"Bパターン")) {
		case 1: mes "["+strnpcinfo(1)+"]"; mes "必要になったら";	mes "また来てください。";	close;
		case 2: 
			mes "["+strnpcinfo(1)+"]";
			mes ""+'@rate[0]+"個組を何セット交換するか入力して下さい";
			mes "マイナス値で取引中止です";
			next;
			input '@count;
			if('@count < 0) {
			mes "["+strnpcinfo(1)+"]"; mes "取引を中止します";
			close;
			}
			if('@count > countitem('@itemA[0])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[0])+"が足りません"; close; }
			if('@count > countitem('@itemA[1])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[1])+"が足りません"; close; }
			if('@count > countitem('@itemA[2])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[2])+"が足りません"; close; }

			/* 所持重量判定 */
			set '@weA,(getiteminfo('@itemC,6) * '@count * '@rate[0]);							//スラッグ弾の総重量 60 * 2
			set '@weB,((getiteminfo('@itemA[0],6) + getiteminfo('@itemA[1],6) + getiteminfo('@itemA[2],6)) * '@count);	//交換して減る総重量 70
			if(('@weA - '@weB) > (MaxWeight - Weight)) { mes "["+strnpcinfo(1)+"]"; mes "所持重量超過です"; close; }

			delitem '@itemA[0],'@count; delitem '@itemA[1],'@count; delitem '@itemA[2],'@count;
			getitem '@itemC,'@count * '@rate[0]; break;
		case 3:
			mes "["+strnpcinfo(1)+"]"; 
			mes ""+'@rate[1]+"個組を何セット交換するか入力して下さい";
			mes "マイナス値で取引中止です";
			next;
			input '@count;
			if('@count < 0) { mes "["+strnpcinfo(1)+"]"; mes "取引を中止します"; close; }
			if('@count > countitem('@itemB[0])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[0])+"が足りません"; close; }
			if('@count > countitem('@itemB[1])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[1])+"が足りません"; close; }
			if('@count > countitem('@itemB[2])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[2])+"が足りません"; close; }

			/* 所持重量判定 */
			set '@weC,(getiteminfo('@itemC,6) * '@count * '@rate[1]);
			set '@weD,((getiteminfo('@itemB[0],6) + getiteminfo('@itemB[1],6) + getiteminfo('@itemB[2],6)) * '@count);
			if(('@weC - '@weD) > (MaxWeight - Weight)) { mes "["+strnpcinfo(1)+"]"; mes "所持重量超過です"; close; }

			delitem '@itemB[0],'@count; delitem '@itemB[1],'@count; delitem '@itemB[2],'@count;
			getitem '@itemC,'@count * '@rate[1]; break;
			}
		mes "["+strnpcinfo(1)+"]";
		mes "交換しました";
	close;
}

que_ng.gat,187,156,3	duplicate(SphereShop)	弾丸屋・トニー	86
izlude.gat,171,133,3	duplicate(SphereShop)	トニー	86
//prontera.gat,153,151,3		duplicate(SphereShop)	トニー	86

//============================================================
// 弾丸ケース屋ケニー 2025/05/07 アップデート
//------------------------------------------------------------
//'@itemid_A == 交換先バレットケース 1個 '@itemid_B == 交換元バレット 最小 500個 '@num == 交換ケース数 最大 50個

-	script	BulletboxShop	83,{
	setarray '@ammo[0],	13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232;
	setarray '@box[0],	12149,22744,22745,22746,22747,22748,22749,22738,22737,23123,23124,23125,23126,23127;
	set '@cost,500;		//手数料zeny
	set '@max,50;		//交換先ケース最大入手数
	set '@rate,500;		//交換元必要バレット数(1ケース500個)

//職制限有効化ここから
//	if(Job != Job_Gunslinger) {
//		mes "["+strnpcinfo(1)+"]";
//		mes "私はガンスリンガーの方に";
//		mes "弾丸と弾丸ケースを交換している";
//		mes "ケニーと言います。";
//		next;
//		mes "[ケニー]";
//		mes "あなたはガンスリンガーではないので";
//		mes "弾丸を扱えません。";
//		mes "申し訳ありません。";
//		close;
//	}
//職制限有効化ここまで

	mes "["+strnpcinfo(1)+"]"; mes "私は弾丸ケース屋のケニー！"; mes "弾薬が重いのなら"; mes "是非ご利用ください。";
	next;
	mes "["+strnpcinfo(1)+"]"; mes "私が作った弾丸ケースは"; mes "弾丸を気楽に持ち歩けるように"; mes "できる優れものです。";
	next;
	mes "["+strnpcinfo(1)+"]"; mes "廃止されたスフィア弾丸の交換もしています";
	mes "どちらを利用しますか？";
	next;
	switch(select(
		"やめる",
		"弾丸ケースを作る",
		"スフィア弾丸の交換をする")) {
	case 1: mes "["+strnpcinfo(1)+"]"; mes "必要になったら";	mes "また来てください。";	close;
	case 2: mes "["+strnpcinfo(1)+"]"; mes "どの弾丸ケースを作りますか？"; next;
		switch(select(
			"やめる",
			""+getitemname('@ammo[0])+"500個 -> "+getitemname('@box[0])+"",
			""+getitemname('@ammo[1])+"500個 -> "+getitemname('@box[1])+"",
			""+getitemname('@ammo[2])+"500個 -> "+getitemname('@box[2])+"",
			""+getitemname('@ammo[3])+"500個 -> "+getitemname('@box[3])+"",
			""+getitemname('@ammo[4])+"500個 -> "+getitemname('@box[4])+"",
			""+getitemname('@ammo[5])+"500個 -> "+getitemname('@box[5])+"",
			""+getitemname('@ammo[6])+"500個 -> "+getitemname('@box[6])+"",
			""+getitemname('@ammo[7])+"500個 -> "+getitemname('@box[7])+"",
			""+getitemname('@ammo[8])+"500個 -> "+getitemname('@box[8])+"",
			""+getitemname('@ammo[9])+"500個 -> "+getitemname('@box[9])+"",
			""+getitemname('@ammo[10])+"500個 -> "+getitemname('@box[10])+"",
			""+getitemname('@ammo[11])+"500個 -> "+getitemname('@box[11])+"",
			""+getitemname('@ammo[12])+"500個 -> "+getitemname('@box[12])+"",
			""+getitemname('@ammo[13])+"500個 -> "+getitemname('@box[13])+"")) {
			case 1: mes "["+strnpcinfo(1)+"]"; mes "必要になったら";	mes "また来てください。";	close;
			case 2:	set '@itemid_B,'@ammo[0];	set '@itemid_A,'@box[0];	break;
			case 3:	set '@itemid_B,'@ammo[1];	set '@itemid_A,'@box[1];	break;
			case 4:	set '@itemid_B,'@ammo[2];	set '@itemid_A,'@box[2];	break;
			case 5:	set '@itemid_B,'@ammo[3];	set '@itemid_A,'@box[3];	break;
			case 6:	set '@itemid_B,'@ammo[4];	set '@itemid_A,'@box[4];	break;
			case 7:	set '@itemid_B,'@ammo[5];	set '@itemid_A,'@box[5];	break;
			case 8:	set '@itemid_B,'@ammo[6];	set '@itemid_A,'@box[6];	break;
			case 9:	set '@itemid_B,'@ammo[7];	set '@itemid_A,'@box[7];	break;
			case 10:	set '@itemid_B,'@ammo[8];	set '@itemid_A,'@box[8];	break;
			case 11:	set '@itemid_B,'@ammo[9];	set '@itemid_A,'@box[9];	break;
			case 12:	set '@itemid_B,'@ammo[10];	set '@itemid_A,'@box[10];	break;
			case 13:	set '@itemid_B,'@ammo[11];	set '@itemid_A,'@box[11];	break;
			case 14:	set '@itemid_B,'@ammo[12];	set '@itemid_A,'@box[12];	break;
			case 15:	set '@itemid_B,'@ammo[13];	set '@itemid_a,'@box[13];	break;	}
			mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemid_A)+"は、"; mes ""+getitemname('@itemid_B)+""+'@rate+"発と"; mes "手数料"+'@cost+"Zenyで"; mes "1個交換できます。";
			next;
			mes "["+strnpcinfo(1)+"]"; mes "購入する数を入力してください。"; mes "一度に"+'@max+"個まで交換できます。"; mes "交換を止めるなら"; mes "0を入力してください。";
			next;
			input '@num;

			if('@num <= 0 || '@num > '@max) 		{ mes "["+strnpcinfo(1)+"]"; mes "交換を中断しました。"; mes "また来てください。"; close; }
			if(countitem('@itemid_B) < '@num*'@rate) 	{ mes "["+strnpcinfo(1)+"]"; mes "アイテムが足りないみたいですよ。"; mes "対象アイテム : "+getitemname('@itemid_B)+""; mes "所持数 : "+countitem('@itemid_B)+"個"; mes "一度確認してみてください。"; close; }
			if(Zeny < '@cost*'@num)				{ mes "["+strnpcinfo(1)+"]"; mes "お金が足りないみたいですよ。"; mes "手数料は" +('@cost*'@num)+ "Zenyです。"; mes "所持ゼニー : "+Zeny+" Zeny"; mes "一度確認してみてください。"; close; }

			set Zeny,Zeny-'@cost*'@num;
			delitem '@itemid_B,'@num*'@rate;
			getitem '@itemid_A,'@num;

			mes "["+strnpcinfo(1)+"]";
			mes "必要数:"+getitemname('@itemid_B)+""+'@num*'@rate+"個";
			mes "手数料:"+'@cost*'@num+"Zeny";
			mes "ケース:"+getitemname('@itemid_A)+""+'@num+"個";
			mes "取引完了です。";
			mes "またご利用ください。";
			close;
	case 3:
		setarray '@itemA[0],13201,13202,13203,13204,13205,13206,13207;
		setarray '@itemB[0],13221,13222,13228,13218,13231,13232,13230;
		if(countitem('@itemA[0]) + countitem('@itemA[1]) + countitem('@itemA[2]) + countitem('@itemA[3]) + countitem('@itemA[4]) + countitem('@itemA[5]) + countitem('@itemA[6]) == 0) { mes "[" +strnpcinfo(1)+ "]"; mes "交換対象のアイテムを持っていません"; close; }
		mes "[" +strnpcinfo(1)+ "]";
		mes "以下の交換対象アイテムを持っています";
		mes ""+getitemname('@itemA[0])+": "+countitem('@itemA[0])+"個";
		mes ""+getitemname('@itemA[1])+": "+countitem('@itemA[1])+"個";
		mes ""+getitemname('@itemA[2])+": "+countitem('@itemA[2])+"個";
		mes ""+getitemname('@itemA[3])+": "+countitem('@itemA[3])+"個";
		mes ""+getitemname('@itemA[4])+": "+countitem('@itemA[4])+"個";
		mes ""+getitemname('@itemA[5])+": "+countitem('@itemA[5])+"個";
		mes ""+getitemname('@itemA[6])+": "+countitem('@itemA[6])+"個";
		mes "同種の新規バレットに交換しますか(手数料なし)";
		next;
		switch(select(
		"やめる",
		""+getitemname('@itemA[0])+" を交換する",
		""+getitemname('@itemA[1])+" を交換する",
		""+getitemname('@itemA[2])+" を交換する",
		""+getitemname('@itemA[3])+" を交換する",
		""+getitemname('@itemA[4])+" を交換する",
		""+getitemname('@itemA[5])+" を交換する",
		""+getitemname('@itemA[6])+" を交換する")) {
			case 1:	 mes "["+strnpcinfo(1)+"]"; mes "必要になったら";	mes "また来てください。";	close;
			case 2:	set '@numA,countitem('@itemA[0]); if('@numA == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[0])+"を持っていません"; close; } delitem '@itemA[0],'@numA; getitem '@itemB[0],'@numA; break;
			case 3: set '@numB,countitem('@itemA[1]); if('@numB == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[1])+"を持っていません"; close; } delitem '@itemA[1],'@numB; getitem '@itemB[1],'@numB; break;
			case 4: set '@numC,countitem('@itemA[2]); if('@numC == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[2])+"を持っていません"; close; } delitem '@itemA[2],'@numC; getitem '@itemB[2],'@numC; break;
			case 5: set '@numD,countitem('@itemA[3]); if('@numD == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[3])+"を持っていません"; close; } delitem '@itemA[3],'@numD; getitem '@itemB[3],'@numD; break;
			case 6: set '@numE,countitem('@itemA[4]); if('@numE == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[4])+"を持っていません"; close; } delitem '@itemA[4],'@numE; getitem '@itemB[4],'@numE; break;
			case 7: set '@numF,countitem('@itemA[5]); if('@numF == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[5])+"を持っていません"; close; } delitem '@itemA[5],'@numF; getitem '@itemB[5],'@numF; break;
			case 8: set '@numG,countitem('@itemA[6]); if('@numG == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[6])+"を持っていません"; close; } delitem '@itemA[6],'@numG; getitem '@itemB[6],'@numG; break; }
			mes "[" +strnpcinfo(1)+ "]"; 
			mes "取引完了です。";
			mes "またご利用ください。";
		close;
	}
}

que_ng.gat,187,149,3	duplicate(BulletboxShop)	弾丸ケース屋・ケニー	83
izlude.gat,171,127,3	duplicate(BulletboxShop)	弾丸ケース屋・ケニー	83
//prontera.gat,153,151,3	duplicate(BulletboxShop)	弾丸ケース屋・ケニー	83


//============================================================
// ガリスン製作
//- Registry -------------------------------------------------
// GUN_1QUE -> 0〜5
//------------------------------------------------------------
que_ng.gat,182,85,3	script	ガリスン	109,{

	if(Job != Job_Gunslinger) {
		mes "[ガリスン]";
		mes "あなたはガンスリンガーでは";
		mes "ありませんね。";
		mes "私に用は無いと思うのですが？";
		close;
	}
	if(BaseLevel < 55) {
		mes "[ガリスン]";

		mes "私の名はガリスン。";
		mes "そして、私の製作した銃は";
		mes "私のように完璧なので";
		mes "同じくガリスンと言います。";
		next;
		mes "[ガリスン]";
		mes "私にガリスンの";
		mes "製作依頼をしますかな？";
		next;
		mes "[ガリスン]";
		mes "ガリスンを作るには";
		mes "鋼鉄50個、エルニウム3個、";
		mes "オリデオコン1個、石炭50個、";
		mes "錆びたネジ20個と";
		mes "3万Zenyが必要です。";
		next;
		callsub L_Routine;
	}
	switch(GUN_1QUE) {
	case 0:
		if(countitem(13104) < 1)
			break;
		mes "[ガリスン]";
		mes "ん……お客様ですか？";
		mes "武器がご入用でしょうか？";
		next;
		switch(select("ガリスンが必要です","いえ、別に……","会話をやめる")) {
		case 1:
			break;
		case 2:
			mes "[ガリスン]";
			mes "ふむ。";
			mes "特に任務も無いようですね。";
			mes "もしお時間があれば、";
			mes "私のお願いを聞いてもらえますかな？";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "何でしょうか？";
			next;
			mes "[ガリスン]";
			mes "はい……実は";
			mes "最近私が製作し、販売した";
			mes "シックスシューターという銃に";
			mes "不良品があったという";
			mes "クレームの手紙を受け取っています。";
			next;
			mes "[ガリスン]";
			mes "常に完璧を追い求める私ですが、";
			mes "視力の低下に伴い、";
			mes "ついうっかり不良品を";
			mes "売ってしまったのでしょう。";
			next;
			mes "[ガリスン]";
			mes "そこで、その不良品と";
			mes "交換するシックスシューターの";
			mes "材料を集めてきてもらえますかな？";
			next;
			mes "[ガリスン]";
			mes "もし私の頼みを聞き入れてくだされば、";
			mes "あなたが持っているガリスンに";
			mes "スロットを増やしてさしあげます。";
			next;
			mes "[ガリスン]";
			mes "なお。スロットを増やす時に";
			mes "すでに装着しているカード、";
			mes "精錬レベルも消失してしまいます。";
			mes "どうしますか？";
			next;
			if(select("嫌です","わかりました")==1) {
				mes "[ガリスン]";
				mes "そうですか。";
				mes "残念ですが、";
				mes "他の人を探してみます。";
				close;
			}
			mes "[ガリスン]";
			mes "本当にありがとうございます。";
			mes "では、まず";
			mes "シックスシューターの材料を";
			mes "集めてきてください。";
			next;
			mes "[ガリスン]";
			mes "材料は鋼鉄10個、";
			mes "エルニウム1個、";
			mes "エンベルタコン10個、";
			mes "石炭30個、錆びたネジ10個。";
			mes "以上です。";
			mes "数を間違えないでください。";
			set GUN_1QUE,1;
			close;
		case 3:
			mes "[ガリスン]";
			mes "では、";
			mes "またお越しください。";
			close;
		}
		break;
	case 1:
		if(countitem(999) < 10 || countitem(985) < 1 || countitem(1011) < 10 || countitem(1003) < 30 || countitem(7317) < 10) {
			mes "[ガリスン]";
			mes "材料は鋼鉄10個、";
			mes "エルニウム1個、";
			mes "エンベルタコン10個、";
			mes "石炭30個、錆びたネジ10個。";
			mes "以上です。";
			mes "数を間違えないでください。";
			close;
		}
		mes "[ガリスン]";
		mes "おや、早かったですね。";
		mes "本当にありがとうございます。";
		mes "……恐縮ではありますが、";
		mes "もう一つお願いがあります。";
		next;
		mes "[ガリスン]";
		mes "その材料で作った品を";
		mes "届けなければなりませんが、";
		mes "私は今仕事があまりにも多くて";
		mes "とてもこの場を離れられません。";
		next;
		mes "[ガリスン]";
		mes "すみませんが、";
		mes "私の代わりに配達を";
		mes "していただけないでしょうか？";
		next;
		mes "[ガリスン]";
		mes "あなたが行っている間に、";
		mes "約束したガリスンの";
		mes "スロット付きバージョンを";
		mes "作る準備をしておきます。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-うーん……面倒だけど";
		mes "代わりに配達してあげよう-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "わかりました。";
		mes "お引き受けしましょう。";
		next;
		mes "[ガリスン]";
		mes "ありがとうございます。";
		mes "では、この品物を";
		mes "リヒタルゼンの貧民街にいる";
		mes "ラベという人に届けてください。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-ガリスンさんから";
		mes "配達する品を受け取った-";
		mes "-リヒタルゼンの貧民街に";
		mes "いるラベという人まで";
		mes "届けに行こう-";
		set GUN_1QUE,2;
		delitem 999,10;
		delitem 985,1;
		delitem 1011,10;
		delitem 1003,30;
		delitem 7317,10;
		close;
	case 2:
		mes "[" +strcharinfo(0)+ "]";
		mes "-ガリスンさんから";
		mes "配達する品を受け取った-";
		mes "-リヒタルゼンの貧民街に";
		mes "いるラベという人まで";
		mes "届けに行こう-";
		close;
	case 3:
		mes "[ガリスン]";
		mes "おや？　どうかなさいましたか？";
		mes "怒っていらっしゃるようですが？";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "どうもこうもありません！";
		mes "殺されるところだったんです！";
		mes "あの男、私を";
		mes "見るやいなや襲ってきたんです！";
		next;
		mes "[ガリスン]";
		mes "ああ……そういうことですか……";
		mes "恐らくあの手紙は……";
		mes "私たちに敵対している者が";
		mes "雇った暗殺者の罠でしょう。";
		next;
		mes "[ガリスン]";
		mes "あなたに関係無い";
		mes "危険な状況に巻き込む結果に";
		mes "なってしまいました。";
		next;
		mes "[ガリスン]";
		mes "本当に申し訳ありません。";
		mes "あなたもご存知の通り、";
		mes "ガンスリンガーギルドと";
		mes "セルレナ博士を狙う悪党";
		mes "は卑劣な策略を練っています。";
		next;
		mes "[ガリスン]";
		mes "本当に申し訳ありませんが、";
		mes "今回の事はあなたの";
		mes "修練になったとでも思ってください。";
		mes "あなたもすでに";
		mes "ガンスリンガーなのですから。";
		next;
		mes "[ガリスン]";
		mes "では、約束どおりあなたの";
		mes "ガリスンにスロットを増やしましょう。";
		next;
		if(countitem(13104) < 1) {
			mes "[ガリスン]";
			mes "おや？";
			mes "ちゃんとガリスンを持っていますか？";
			mes "私が改造できるのは";
			mes "スロットの無いガリスンだけです。";
			set GUN_1QUE,4;
			close;
		}
		mes "[ガリスン]";
		mes "あ……もしやと思いますが";
		mes "^FF0000カードを装着したり、精錬した^000000";
		mes "ガリスンを^FF0000所持^000000していませんか？";
		next;
		mes "[ガリスン]";
		mes "もしそうだとしたら、";
		mes "カードも精錬値レベルも";
		mes "無くなってしまいます。";
		mes "念のため、それでも問題のない";
		mes "^FF0000ガリスン^000000だけを持っているか";
		mes "確認してください。";
		next;
		if(select("確認してくる","確認完了。すぐに改造する")==1) {
			mes "[ガリスン]";
			mes "わかりました。";
			mes "十分に確認をとってください。";
			set GUN_1QUE,4;
			close;
		}
		mes "[ガリスン]";
		mes "はい、改造できました。";
		mes "どうか大切に扱ってください。";
		set GUN_1QUE,5;
		delitem 13104,1;
		getitem 13105,1;
		close;
	case 4:
		if(countitem(13104) < 1) {
			mes "[ガリスン]";
			mes "おや？";
			mes "ちゃんとガリスンを持っていますか？";
			mes "私が改造できるのは";
			mes "スロットの少ないガリスンだけです。";
			close;
		}
		mes "[ガリスン]";
		mes "あ……もしやと思いますが";
		mes "^FF0000カードを装着したり、精錬した^000000";
		mes "ガリスンを^FF0000所持^000000していませんか？";
		next;
		mes "[ガリスン]";
		mes "もしそうだとしたら、";
		mes "カードも精錬値レベルも";
		mes "無くなってしまいます。";
		mes "念のため、それでも問題のない";
		mes "^FF0000ガリスン^000000だけを持っているか";
		mes "確認してください。";
		next;
		if(select("確認してくる","確認完了。すぐに改造する")==1) {
			mes "[ガリスン]";
			mes "わかりました。";
			mes "十分に確認をとってください。";
			close;
		}
		mes "[ガリスン]";
		mes "はい、改造できました。";
		mes "どうか大切に扱ってください。";
		set GUN_1QUE,5;
		delitem 13104,1;
		getitem 13105,1;
		close;
	case 5:
		mes "[ガリスン]";
		mes "ようこそおいでくださいました。";
		mes "そう、人々は皆、私を求める！";
		mes "私の名がついた武器、ガリスンは";
		mes "最高の中の最高！";
		mes "すぐにご入用ですかな？";
		next;
		switch(select("ガリスン","ガリスンのスロット改造","会話をやめる")) {
		case 1:
			mes "[ガリスン]";
			mes "ガリスンを作るには";
			mes "鋼鉄50個、エルニウム3個、";
			mes "オリデオコン1個、石炭50個、";
			mes "錆びたネジ20個と";
			mes "3万Zenyが必要です。";
			mes "よろしいですかな？";
			next;
			callsub L_Routine;
		case 2:
			mes "[ガリスン]";
			mes "ガリスンのスロット改造には";
			mes "鋼鉄10個、エルニウム1個、";
			mes "エンベルタコン10個、";
			mes "石炭30個、錆びたネジ10個。";
			mes "以上が必要です。";
			mes "よろしいですかな？";
			next;
			switch(select("また今度で","今すぐしてください","やめる")) {
			case 1:
				mes "[ガリスン]";
				mes "そうですか。";
				mes "では、良く考えてから";
				mes "お返事をください。";
				close;
			}
			if(countitem(13104) < 1 || countitem(999) < 10 || countitem(985) < 1 || countitem(1011) < 10 || countitem(1003) < 30 || countitem(7317) < 10) {
				mes "[ガリスン]";
				mes "ガリスンのスロット改造には";
				mes "鋼鉄10個、エルニウム1個、";
				mes "エンベルタコン10個、";
				mes "石炭30個、錆びたネジ10個。";
				mes "以上が必要です。";
				close;
			}
			if(MaxWeight - Weight <= 5000) {
				mes "[ガリスン]";
				mes "荷物が一杯ですね。";
				mes "一度整理してから";
				mes "またお越しください。";
				close;
			}
			mes "[ガリスン]";
			mes "あ……もしやと思いますが";
			mes "^FF0000カードを装着したり、精錬した^000000";
			mes "ガリスンを^FF0000所持^000000していませんか？";
			next;
			mes "[ガリスン]";
			mes "もしそうだとしたら、";
			mes "カードも精錬値レベルも";
			mes "無くなってしまいます。";
			mes "念のため、それでも問題のない";
			mes "^FF0000ガリスン^000000だけを持っているか";
			mes "確認してください。";
			next;
			if(select("確認してくる","確認完了。すぐに改造する")==1) {
				mes "[ガリスン]";
				mes "わかりました。";
				mes "十分に確認をとってください。";
				close;
			}
			mes "[ガリスン]";
			mes "はい、改造できました。";
			mes "どうか大切に扱ってください。";
			delitem 999,10;
			delitem 985,1;
			delitem 1011,10;
			delitem 1003,30;
			delitem 7317,10;
			delitem 13104,1;
			getitem 13105,1;
			close;
		case 3:
			mes "[ガリスン]";
			mes "それでは、またお会いしましょう。";
			close;
		}
	}
	mes "[ガリスン]";
	mes "ハッハッハ！";
	mes "ようこそおいでくださいました。";
	mes "そう、人々は皆、私を求める！";
	mes "私の名がついた武器、ガリスンは";
	mes "最高の中の最高！";
	mes "すぐにご入用ですかな？";
	next;
	mes "[ガリスン]";
	mes "ガリスンを作るには";
	mes "鋼鉄50個、エルニウム3個、";
	mes "オリデオコン1個、石炭50個、";
	mes "錆びたネジ20個と";
	mes "3万Zenyが必要です。";
	mes "よろしいですかな？";
	next;
L_Routine:
	switch(select("また今度で","今すぐ作ってください","やめる")) {
	case 1:
		mes "[ガリスン]";
		mes "そうですか。";
		mes "では、良く考えてから";
		mes "お返事をください。";
		close;
	case 2:
		if(countitem(999) < 50 || countitem(985) < 3 || countitem(984) < 1 || countitem(1003) < 50 || countitem(7317) < 20) {
			mes "[ガリスン]";
			mes "ガリスンを作るには";
			mes "鋼鉄50個、エルニウム3個、";
			mes "オリデオコン1個、石炭50個、";
			mes "錆びたネジ20個と";
			mes "3万Zenyが必要です。";
			mes "お忘れにならないよう。";
			close;
		}
		if(Zeny < 30000) {
			mes "[ガリスン]";
			mes "お金が足りません。";
			close;
		}
		if(MaxWeight - Weight <= 5000) {
			mes "[ガリスン]";
			mes "荷物が一杯ですね。";
			mes "一度整理してから";
			mes "またお越しください。";
			close;
		}
		mes "[ガリスン]";
		mes "ではどうぞ。";
		mes "こちらがガリスンです。";
		mes "また必要になったら";
		mes "お越しください。";
		delitem 999,50;
		delitem 985,3;
		delitem 984,1;
		delitem 1003,50;
		delitem 7317,20;
		set Zeny,Zeny-30000;
		getitem 13104,1;
		close;
	case 3:
		mes "[ガリスン]";
		mes "それでは、またお会いしましょう。";
		close;
	}
}

lighthalzen.gat,322,247,5	script	ラベ	86,{
	switch(GUN_1QUE) {
	default:
		mes "[ラベ]";
		mes "ウググ……";
		mes "ググッ……クウ……";
		mes "…………";
		close;
	case 2:
		mes "[" +strcharinfo(0)+ "]";
		mes "こんにちは。";
		mes "ガンスリンガーギルドから";
		mes "不良品の交換をしに……";
		next;
		mes "[ラベ]";
		mes "ヌオオオッ!!";
		mes "クオオオッ!!";
		mes "ズオラアアッ!!";
		set GUN_1QUE,3;
		percentheal -90,0;
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-ラベという男は";
		mes "いきなり私に襲い掛かった-";
		mes "-ガンスリンガーという";
		mes "言葉に反応したようだ……-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-とにかく逃げよう-";
		mes "-そして、ガリスンさんに";
		mes "どういうことか聞きに行こう-";
		close;
	case 3:
		mes "[" +strcharinfo(0)+ "]";
		mes "-ラベという男は";
		mes "いきなり私に襲い掛かった-";
		mes "-ガンスリンガーという";
		mes "言葉に反応したようだ……-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-とにかく逃げよう-";
		mes "-そして、ガリスンさんに";
		mes "どういうことか聞きに行こう-";
		close;
	}
}

//============================================================
// ドリフター・ブッチャー製作
//- Registry -------------------------------------------------
// GUN_2QUE -> 0〜9
//------------------------------------------------------------
que_ng.gat,149,178,4	script	研究所企画者	744,{
	switch(GUN_2QUE) {
	case 0:
		mes "[エイ]";
		mes "あ、こんにちは。";
		mes "私は、アインブロック研究所企画者、";
		mes "エイといいます。";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			menu "話しをする",-;
			mes "[エイ]";
			mes "もし、知り合いに";
			mes "ガンスリンガーの人がいたら、";
			mes "ある武器に関する情報があるので";
			mes "ここに来るようにと";
			mes "伝えてください。";
			close;
		}
		if(BaseLevel < 56) {
			menu "話しをする",-;
			mes "[エイ]";
			mes "……連射……";
			mes "持続……";
			mes "……180以上……";
			next;
			mes "[エイ]";
			mes "あ、すみません。";
			mes "今は武器の研究で忙しいので。";
			close;
		}
		if(BaseLevel >= 68)
			set '@str$,"武器「ブッチャー」について聞く";
		switch(select('@str$,"武器「ドリフター」について聞く","話をやめる")) {
		case 1:
			mes "[エイ]";
			mes "どうやら噂を聞いてきたようですね。";
			next;
			mes "[エイ]";
			mes "^FF0000ブッチャー^000000は";
			mes "我がアインブロック研究所の";
			mes "心血を注いで作られた";
			mes "ガトリングガンです。";
			next;
			mes "[エイ]";
			mes "^FF0000ドリフター^000000もいい武器ですが、";
			mes "^FF0000ブッチャー^000000の火力は";
			mes "それ以上だと自信をもって言えます！";
			next;
			mes "[エイ]";
			mes "あまりにも強い火力のため";
			mes "「虐殺者」という名で呼ばれてます。";
			mes "同時に、非常に扱いにくい";
			mes "武器でもあります。";
			next;
			mes "[エイ]";
			mes "この武器を、果たして";
			mes "あなたが使いこなせるのでしょうか？";
			next;
			if(select("……わからない","もちろん！")==1) {
				mes "[エイ]";
				mes "^FF0000ブッチャー^000000はそんな";
				mes "どっちつかずな態度で扱える程";
				mes "甘い代物ではありません。";
				mes "自分に自信がもてるようになったら";
				mes "また来てください。";
				close;
			}
			mes "[エイ]";
			mes "自信があるようですね。";
			mes "でも、自信だけなら";
			mes "誰でも簡単にもてます。";
			mes "あなたのその自信を";
			mes "何か証明できないでしょうか？";
			next;
			mes "[エイ]";
			mes "うーん…………";
			next;
			mes "[エイ]";
			mes "あ！";
			mes "良い考えが思い浮かびました！";
			next;
			mes "[エイ]";
			mes "^FF0000オークの爪1,000個^000000と";
			mes "^FF0000スケルボーン1,000個^000000を";
			mes "集めてきてください。";
			mes "これらを集めてこれたら、";
			mes "あなたに^FF0000ブッチャー^000000を";
			mes "差し上げます。";
			next;
			mes "[エイ]";
			mes "どうです？";
			mes "これ位ならやろうと思えば";
			mes "できますよね？";
			mes "あなたの実力を見せてもらいます。";
			mes "フフフ……";
			set GUN_2QUE,3;
			close;
		case 2:
			mes "[エイ]";
			mes "どうやら^FF0000ドリフター^000000の話を";
			mes "聞いたようですね。";
			next;
			mes "[エイ]";
			mes "^FF0000ドリフター^000000はセルレナ博士が";
			mes "製作した最高の武器の一つ。";
			mes "回転電動型連発銃です。";
			mes "その連射速度は、";
			mes "ガンスリンガーが装備できる";
			mes "武器の中で最高といえます。";
			next;
			mes "[エイ]";
			mes "もちろん、ガトリングが扱えるスキルが";
			mes "必要不可欠ですが、ガトリングを";
			mes "手足のように自由に扱えるようなれば、";
			mes "^FF0000ドリフター^000000は最高の";
			mes "パートナーになるはずです。";
			next;
			mes "[エイ]";
			mes "^FF0000ドリフター^000000を使ってみますか？";
			next;
			if(select("いいえ","はい")==1) {
				mes "[エイ]";
				mes "使うつもりができたら";
				mes "いつでもまた来てください。";
				close;
			}
			mes "[エイ]";
			mes "^FF0000ドリフター^000000は";
			mes "材料が手に入りにくいので、";
			mes "私たちも予約方式で製作しています。";
			mes "ですが、^FF0000ドリフター^000000の";
			mes "材料を持ってくれば";
			mes "すぐにでも作って差し上げます。";
			next;
			mes "[エイ]";
			mes "材料を言うのでちゃんとメモを";
			mes "取ってください。";
			next;
			mes "[エイ]";
			mes "^FF0000鋼鉄70個、エルニウム5個、";
			mes "オリデオコン3個、石炭70個、";
			mes "錆びたネジ50個。^000000";
			mes "そして製作費用として";
			mes "^FF000050,000Zeny^000000必要です。";
			mes "全部集まったらまた来てください。";
			set GUN_2QUE,1;
			close;
		case 3:
			mes "[エイ]";
			mes "武器に関する情報があるのですが……";
			mes "どうやら忙しそうですね。";
			mes "また来てください。";
			close;
		}
	case 1:
		if(countitem(999) < 70 || countitem(985) < 5 || countitem(984) < 3 || countitem(1003) < 70 || countitem(7317) < 50 || Zeny < 50000) {
			mes "[エイ]";
			mes "まだ材料が集まってないみたいですね。";
			mes "もう一度いいますよ。";
			next;
			mes "[エイ]";
			mes "^FF0000鋼鉄70個、エルニウム5個、";
			mes "オリデオコン3個、石炭70個、";
			mes "錆びたネジ50個。^000000";
			mes "そして製作費用として";
			mes "^FF000050,000Zeny^000000必要です。";
			mes "全部集まったらまた来てください。";
			next;
			mes "[エイ]";
			mes "もう必要ないようでしたら";
			mes "製作依頼をキャンセルできますが。";
			mes "どうしますか？";
			next;
			if(select("キャンセルしない","キャンセルする")==1) {
				mes "[エイ]";
				mes "では、材料が集まったら";
				mes "また来てください。";
				close;
			}
			mes "[エイ]";
			mes "製作依頼をキャンセルしました。";
			mes "では、楽しい一日を。";
			set GUN_2QUE,0;
			close;
		}
		mes "[エイ]";
		mes "あ、材料が集まりましたね。";
		mes "では、製作に入ります。";
		mes "時間がかかるので";
		mes "少し待っていてください。";
		delitem 999,70;
		delitem 985,5;
		delitem 984,3;
		delitem 1003,70;
		delitem 7317,50;
		set Zeny,Zeny-50000;
		set GUN_2QUE,2;
		close;
	case 2:
		if(MaxWeight - Weight < 2300) {
			mes "-所持アイテムの重量が多いため";
			mes "アイテムを受けとることができません-";
			mes "-所持アイテムを減らしてから、再度";
			mes "話しかけてください-";
			close;
		}
		mes "[エイ]";
		mes "ドリフターが完成しました。";
		set GUN_2QUE,0;
		getitem 13157,1;
		next;
		mes "[エイ]";
		mes "ガンスリンガーのスキル、";
		mes "ガトリングフィーバーと";
		mes "マッドネスキャンセラーは";
		mes "とても役に立ちます。";
		mes "是非覚えてください。";
		mes "では、またお会いしましょう。";
		close;
	case 3:
		if(countitem(1043) < 1000 || countitem(932) < 1000) {
			mes "[エイ]";
			mes "^FF0000オークの爪1,000個^000000と";
			mes "^FF0000スケルボーン1,000個^000000は";
			mes "集めれますか？";
			mes "難しいようでしたら";
			mes "諦めても構いませんよ？";
			next;
			if(select("あきらめない","あきらめる")==1) {
				mes "[エイ]";
				mes "わかりました。";
				mes "あなたの力を信じてます。";
				close;
			}
			mes "[エイ]";
			mes "諦めるのですか？";
			mes "うーん……";
			mes "難しい条件ではありますが、";
			mes "それを克服しない限り";
			mes "この武器を扱う事は不可能です。";
			next;
			mes "[エイ]";
			mes "自分の力を信じれるようになったら";
			mes "また来てください。";
			set GUN_2QUE,0;
			close;
		}
		mes "[エイ]";
		mes "あ、材料が集まりましたね。";
		mes "ああ……^FF0000ブッチャー^000000を作った時は、";
		mes "これを使える人がいるのか";
		mes "心配でしたが……";
		mes "それも今日までです！";
		delitem 1043,1000;
		delitem 932,1000;
		set GUN_2QUE,4;
		next;
		mes "[エイ]";
		mes "では、^FF0000ブッチャー^000000の製作を始めますが、";
		mes "まずはセルレナ博士に";
		mes "ブッチャーの製作許可、使用許可を";
		mes "頂かなくてはなりません。";
		next;
		mes "[エイ]";
		mes "使用許可は私が頂きますので、";
		mes "ブッチャーの製作費用と";
		mes "許可手続きの手数料である";
		mes "10万Zenyを用意しておいてください。";
		close;
	case 4:
		mes "[エイ]";
		mes "セルレナ博士から";
		mes "ブッチャーの使用許可を頂きました。";
		mes "10万Zenyを払って頂ければ";
		mes "すぐにでもブッチャーを差し上げます。";
		mes "よろしいですか？";
		next;
		if(select("いいえ","はい")==1) {
			mes "[エイ]";
			mes "お金の用意ができたら";
			mes "いつでもまた来てください。";
			close;
		}
		if(Zeny < 100000) {
			mes "[エイ]";
			mes "お金が足りないようです。";
			mes "もう一度確認してみてください。";
			close;
		}
		if(MaxWeight - Weight < 2500) {
			mes "-所持アイテムの重量が多いため";
			mes "アイテムを受けとることができません-";
			mes "-所持アイテムを減らしてから、再度";
			mes "話しかけてください-";
			close;
		}
		mes "[エイ]";
		mes "1、2、…………10！";
		mes "確認しました。";
		mes "では、^FF0000ブッチャー^000000を差し上げます！";
		set Zeny,Zeny-100000;
		set GUN_2QUE,0;
		getitem 13158,1;
		next;
		mes "[エイ]";
		mes "リヒタルゼンにいらっしゃる";
		mes "F.ヘリスンおじさんは";
		mes "その武器の事を気にしてました。";
		mes "時間がある時にでも";
		mes "一度会いに行ってみて下さい。";
		next;
		mes "[エイ]";
		mes "武器は大切に使ってください。";
		mes "では、また縁があれば";
		mes "お会いしましょう。";
		close;
	case 6:
		mes "[エイ]";
		mes "あ、こんにちは。";
		mes "私は、アインブロック研究所企画者、";
		mes "エイといいます。";
		mes "何かご用ですか？";
		next;
		menu "特殊金属が必要",-;
		mes "[エイ]";
		mes "え？　……あ！";
		mes "そういえば、あなたは以前";
		mes "ブッチャー持っていった人ですね？";
		mes "ブッチャーはちゃんと";
		mes "使ってますか？";
		next;
		mes "[エイ]";
		mes "…………って……";
		mes "特殊金属って……";
		mes "も、もしかして、ブッチャーを";
		mes "壊したんですか！";
		next;
		mes "[エイ]";
		mes "あなたを信じてたのに！";
		mes "私の信頼を裏切ったんですね！";
		mes "このうらぎりものぉー！";
		next;
		menu "事情を説明する",-;
		mes "[エイ]";
		mes "……そうですか。";
		mes "ヘリスンおじさんが……";
		mes "疑っちゃってごめんなさい。";
		next;
		mes "[エイ]";
		mes "特殊金属はセルレナ博士が";
		mes "持っていらっしゃいます。";
		mes "しかし、今セルレナ博士は";
		mes "留守で、どこにあるのか";
		mes "わかりません。";
		next;
		mes "[エイ]";
		mes "それを探そうにも";
		mes "今、新しい研究中で";
		mes "私にはそんな時間が無いのです。";
		mes "属性弾丸の研究を";
		mes "後回しにするわけにも";
		mes "いかないので……";
		next;
		menu "一つ提案する",-;
		mes "[エイ]";
		mes "ん？　なんですか？";
		next;
		menu "お互いに必要な物を探してくる",-;
		mes "[エイ]";
		mes "うーん……いいですよ！";
		mes "では、私が特殊金属を探すので、";
		mes "あなたは属性弾丸を";
		mes "手に入れてきてください。";
		next;
		mes "[エイ]";
		mes "^FF0000ポイズンスフィア、";
		mes "ファイアスフィア、";
		mes "ウィンドスフィア、";
		mes "ダークスフィア、";
		mes "アイススフィア^000000。";
		next;
		mes "[エイ]";
		mes "この5種類の中から";
		mes "一種類の属性弾丸を";
		mes "30個集めてきてください。";
		set GUN_2QUE,7;
		close;
	case 7:
		mes "[エイ]";
		mes "^FF0000ポイズンスフィア30個、";
		mes "ファイアスフィア30個、";
		mes "ウィンドスフィア30個、";
		mes "ダークスフィア30個、";
		mes "アイススフィア30個^000000。";
		mes "どれか集まりましたか？";
		next;
		switch(select("いいえ","ポイズンスフィア","ファイアスフィア","ウィンドスフィア","ダークスフィア","アイススフィア")) {
		case 1:
			mes "[エイ]";
			mes "一種類でも集まったら";
			mes "持ってきてください。";
			close;
		case 2:
			set '@itemid,13205;
			break;
		case 3:
			set '@itemid,13203;
			break;
		case 4:
			set '@itemid,13204;
			break;
		case 5:
			set '@itemid,13206;
			break;
		case 6:
			set '@itemid,13207;
			break;
		}
		if(countitem('@itemid) < 30) {
			mes "[エイ]";
			mes "どこにあるんですか？";
			mes "ちゃんと手に入れてきてください！";
			close;
		}
		mes "[エイ]";
		mes "ちゃんとありますね。";
		mes "私もセルレナ博士の";
		mes "研究室を探して見つけておきました。";
		mes "では、交換しましょう。";
		delitem '@itemid,30;
		set GUN_2QUE,8;
		next;
		mes "-エイに属性弾を渡して、";
		mes "特殊金属を受け取った-";
		next;
		mes "[エイ]";
		mes "ヘリスンおじさんは";
		mes "器用な人ですから、";
		mes "ちゃんと修理できるでしょう。";
		mes "ではでは。";
		close;
	case 8:
	case 9:
		mes "[エイ]";
		mes "ヘリスンおじさんは";
		mes "器用な人ですから、";
		mes "ちゃんと修理できるでしょう。";
		mes "ではでは。";
		close;
	}
}

lighthalzen.gat,205,284,5	script	ヘリスン	85,{
	switch(GUN_2QUE) {
	default:
		mes "[ヘリスン]";
		mes "あー……退屈だー";
		mes "何か面白い事でもないかなぁ……";
		if(GUN_2QUE != 0 || Job != Job_Gunslinger || BaseLevel < 68 || countitem(13158) < 1)
			close;
		next;
		mes "[ヘリスン]";
		mes "ん？";
		mes "お前、ガンスリンガーか？";
		mes "……にしても……";
		mes "初めて見る武器を持っているな！";
		next;
		mes "[ヘリスン]";
		mes "ちょ、ちょっと見せてもらっていいか？";
		mes "ちょっとだけでいいんだ。";
		mes "な？　な？";
		mes "頼むよ。";
		next;
		if(select("見せてあげない","ブッチャーを見せる")==1) {
			mes "[ヘリスン]";
			mes "ふん！";
			mes "いいよいいよ。";
			mes "お前だけいい武器を";
			mes "持っていると思うなよ！";
			mes "俺にだって、";
			mes "このクリムゾンボルトがあるんだ！";
			close;
		}
		mes "[ヘリスン]";
		mes "おぉ……これが";
		mes "アインブロック研究所が開発した、";
		mes "誰も使うことができなかったという";
		mes "「虐殺者ブッチャー」か！";
		mes "すばらしい……";
		next;
		mes "[ヘリスン]";
		mes "少しだけ使ってみてもいいか!?";
		mes "大丈夫！";
		mes "俺は武器の扱いには慣れてるんだ！";
		mes "心配ないって！　な！";
		mes "-ゴトンッ！-　……ぁ。";
		close2;
		delitem 13158,1;
		set GUN_2QUE,5;
		end;
	case 5:
		if(MaxWeight - Weight < 450) {
			mes "-所持アイテムの重量が多いため";
			mes "アイテムを受けとることができません-";
			mes "-所持アイテムを減らしてから、再度";
			mes "話しかけてください-";
			close;
		}
		mes "[ヘリスン]";
		mes "え……あ……あれ？";
		next;
		mes "[ヘリスン]";
		mes "う……ぇ……あ……";
		next;
		menu "何をしたのか問いただす",-;
		mes "[ヘリスン]";
		mes "え!?";
		mes "あ……いや……その……";
		next;
		mes "[ヘリスン]";
		mes "そ……それがですね……";
		mes "ア……アハ……";
		mes "アハハハハハハハ〜";
		next;
		mes "[ヘリスン]";
		mes "俺がね……アハハ……";
		next;
		mes "[ヘリスン]";
		mes "これね……ハハ……ハ……";
		next;
		mes "[ヘリスン]";
		mes "ズダダダダ！";
		mes "って撃とうとしたんだ。";
		mes "……そうなんだよ！";
		next;
		mes "[ヘリスン]";
		mes "でも、意外とこれが重くてな！";
		mes "ついうっかり俺の繊細な手がな……";
		mes "アハ……アハハハハッ！";
		next;
		mes "[ヘリスン]";
		mes "………………";
		mes "……ごめんなさい。";
		mes "壊しちゃいました。";
		next;
		mes "[ヘリスン]";
		mes "ぁ、いや！　大丈夫！";
		mes "俺はこう見えて、実はなんでも屋！";
		mes "自称だけど……";
		mes "いや！　勘違いするなよ！";
		mes "これぐらい直す事はできる！";
		next;
		mes "[ヘリスン]";
		mes "でも、修理に必要な材料は無いし……";
		mes "初めて見るような部品があって……";
		next;
		mes "[ヘリスン]";
		mes "俺が壊しておいて何だけど……";
		mes "修理に必要な材料を";
		mes "集めてきてくれないか？";
		mes "材料さえあれば";
		mes "すぐに直して見せるから！";
		next;
		mes "[ヘリスン]";
		mes "いや、それどころか";
		mes "スペシャル改造まで";
		mes "しちゃうよ！　やったな！";
		next;
		mes "[ヘリスン]";
		mes "必要な材料は^FF0000鋼鉄10個、";
		mes "エルニウム2個、オリデオコン1個、";
		mes "石炭20個^000000だ。";
		next;
		mes "[ヘリスン]";
		mes "そして、ブッチャー専用の";
		mes "^FF0000特殊金属^000000が必要だ。";
		mes "恐らく、この金属は";
		mes "セルレナ博士しか作れないだろう。";
		next;
		mes "[ヘリスン]";
		mes "まず、セルレナ博士の助手である";
		mes "「エイ」に頼んでみてくれ。";
		mes "ちょっとヒステリックな子だが、";
		mes "話せばわかってくれる……かも……";
		next;
		mes "[ヘリスン]";
		mes "これでも悪いと思ってるんだ。";
		mes "とりあえず、俺が大事にしてる";
		mes "「クリムゾンボルト」を代わりに貸すよ";
		mes "修理できたらちゃんと返してくれよ？";
		mes "な？　な？";
		close2;
		set GUN_2QUE,6;
		getitem 13102,1;
		end;
	case 6:
	case 7:
		mes "[ヘリスン]";
		mes "必要な材料は^FF0000鋼鉄10個、";
		mes "エルニウム2個、オリデオコン1個、";
		mes "石炭20個^000000だ。";
		next;
		mes "[ヘリスン]";
		mes "そして、ブッチャー専用の";
		mes "^FF0000特殊金属^000000が必要だ。";
		mes "この金属は「エイ」に頼めば";
		mes "手に入る……かも……";
		close;
	case 8:
		if(countitem(999) < 10 || countitem(985) < 2 || countitem(984) < 1 || countitem(1003) < 20) {
			mes "[ヘリスン]";
			mes "必要な材料は^FF0000鋼鉄10個、";
			mes "エルニウム2個、オリデオコン1個、";
			mes "石炭20個^000000だ。";
			next;
			mes "[ヘリスン]";
			mes "そして、ブッチャー専用の";
			mes "^FF0000特殊金属^000000が必要だが、";
			mes "これは手に入ったようだな。";
			close;
		}
		mes "[ヘリスン]";
		mes "ぉ、材料を集めてきたな！";
		if(countitem(13102) < 1) {
			mes "ところで、「クリムゾンボルト」は";
			mes "どこにあるんだ？";
			mes "………………";
			mes "頼むから返してくれ……";
			close;
		}
		mes "それじゃあ、修理を始めるから";
		mes "少しの間だけ待っててくれ。";
		delitem 999,10;
		delitem 985,2;
		delitem 984,1;
		delitem 1003,20;
		delitem 13102,1;
		set GUN_2QUE,9;
		close;
	case 9:
		if(MaxWeight - Weight < 2500) {
			mes "-所持アイテムの重量が多いため";
			mes "アイテムを受けとることができません-";
			mes "-所持アイテムを減らしてから、再度";
			mes "話しかけてください-";
			close;
		}
		mes "[ヘリスン]";
		mes "ふぅ……なんとか無事修理できた。";
		mes "本当にすまなかった。";
		mes "代わりと言ってはなんだが、";
		mes "ブッチャーの機能を強化しておいた。";
		mes "大切に使ってくれ。";
		set GUN_2QUE,0;
		getitem 13159,1;
		close;
	}
}

//============================================================
// デストロイヤー製作
//- Registry -------------------------------------------------
// GUN_3QUE -> 0〜2
//------------------------------------------------------------
que_ng.gat,185,180,3	script	ベネッサ	726,{
	switch(GUN_3QUE) {
	case 0:
		mes "[ベネッサ]";
		mes "は！　いやぁ！";
		mes "せい！　とりゃぁ！";
		mes "いつか必ず";
		mes "世界中の格闘技を";
		mes "全部マスターするぞ！";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			mes "[ベネッサ]";
			mes "ん？　何？";
			mes "練習の邪魔になるから";
			mes "あっち行ってくれる？";
			close;
		}
		mes "[ベネッサ]";
		mes "ん？";
		mes "あんたガンスリンガーだね？";
		mes "練習の邪魔になるんだけど。";
		mes "何か用なの？";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "いえ、練習を見ていました。";
		mes "すごいかっこよかったから……";
		next;
		mes "[ベネッサ]";
		mes "お！";
		mes "あんた格闘技が好きなの？";
		mes "ならこっちへ来なよ。";
		mes "私が技をかけてやるよ。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "……え？";
		mes "あ、いや、";
		mes "お気になさらずに。";
		next;
		mes "[ベネッサ]";
		mes "大丈夫、大丈夫。";
		mes "ほら！";
		mes "-シュ！　シュ！-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "あわわ、こっちに来ないでください！";
		mes "わ……うわぁ！";
		mes "-シュッシュ！-";
		mes "-ぶん！　ぶぉん！-";
		next;
		mes "[ベネッサ]";
		mes "何で避けるのよ！";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "当たり前じゃないですか！";
		mes "危ないでしょうが！";
		next;
		mes "[ベネッサ]";
		mes "やれやれ。";
		mes "これぐらいで";
		mes "びびらないでよ。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "わかっているんですか！";
		mes "当たったらケガをするんですよ！";
		next;
		mes "[ベネッサ]";
		mes "はいはい、そうねー";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "大体いきなり…………";
		next;
		mes "[ベネッサ]";
		mes "シャラップ！";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "………………";
		next;
		mes "[ベネッサ]";
		mes "はい。";
		mes "確かにやりすぎたわね。";
		mes "一応反省してるのよ。";
		mes "だから、特別にあんたのために";
		mes "武器を作ってあげるわよ。";
		next;
		mes "[ベネッサ]";
		mes "私はベネッサ・ルイス。";
		mes "元々は格闘志望生だったんだけど、";
		mes "今はここで武器を作っているわ。";
		mes "ま、お金が無いってことよ。";
		next;
		mes "[ベネッサ]";
		mes "私が作れる武器は";
		mes "デストロイヤー。";
		next;
		mes "[ベネッサ]";
		mes "私が格闘技の大会に出る時に";
		mes "使う名前を付けた武器よ。";
		mes "ふふふ……";
		mes "デストロイヤー！";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "わあ！";
		mes "もうやめてくださいって！";
		next;
		mes "[ベネッサ]";
		mes "わかってる、わかってるって。";
		mes "もー";
		mes "一応、デストロイヤーを作るには";
		mes "材料が必要よ。";
		next;
		mes "[ベネッサ]";
		mes "どう？";
		mes "こんな機会はそうそうないわよ。";
		mes "作ってみる？";
		next;
		if(select("またにします","お願いします")==1) {
			mes "[ベネッサ]";
			mes "あらら、残念。";
			mes "あんたには良い機会だったのに。";
			mes "後で後悔しても知らないよ。";
			mes "じゃ、ばいば〜い。";
			close;
		}
		mes "[ベネッサ]";
		mes "オッケー。";
		mes "デストロイヤーを作るには";
		mes "古い鉄板50個、";
		mes "オリデオコン5個、";
		mes "錆びたネジ70個、";
		mes "手数料の10万Zenyが必要よ。";
		set GUN_3QUE,1;
		close;
	case 1:
		if(countitem(7319) < 50 || countitem(984) < 5 || countitem(7317) < 70) {
			mes "[ベネッサ]";
			mes "デストロイヤーを作るには";
			mes "古い鉄板50個、";
			mes "オリデオコン5個、";
			mes "錆びたネジ70個、";
			mes "手数料の10万Zenyが必要よ。";
			close;
		}
		if(Zeny < 100000) {
			mes "[ベネッサ]";
			mes "材料は十分だけど、";
			mes "手数料の10万Zenyが足りないわよ。";
			close;
		}
		if(MaxWeight - Weight <= 1200) {
			mes "[ベネッサ]";
			mes "荷物がいっぱいじゃない。";
			mes "ちょっと整理してきてよ。";
			close;
		}
		mes "[ベネッサ]";
		mes "オッケー";
		mes "全部そろってるわね。";
		mes "じゃ、あらかじめ作っておいた";
		mes "デストロイヤーと";
		mes "交換してあげる。";
		delitem 7319,50;
		delitem 984,5;
		delitem 7317,70;
		set GUN_3QUE,2;
		getitem 13160,1;
		next;
		mes "[ベネッサ]";
		mes "もし、また必要になったら";
		mes "いつでも来てね。";
		mes "次は他の格闘術を";
		mes "かけてあ・げ・る。";
		close;
	case 2:
		mes "[ベネッサ]";
		mes "お、また来たわね？";
		mes "元気してる？";
		mes "そうそう、新しい武器ができたの。";
		mes "よかったら";
		mes "作ってあげるわよ。";
		next;
		switch(select("デストロイヤー","スロット付きデストロイヤー","やめておく")) {
		case 1:
			mes "[ベネッサ]";
			mes "オッケー。";
			mes "デストロイヤーを作るには";
			mes "古い鉄板50個、錆びたネジ70個、";
			mes "オリデオコン5個、";
			mes "手数料の10万Zenyが必要よ。";
			mes "作ってみる？";
			next;
			if(select("ちょっと考えてみます","お願いします")==1) {
				mes "[ベネッサ]";
				mes "あ、そう。";
				mes "それじゃあゆっくり";
				mes "考えてみてよ。";
				close;
			}
			if(countitem(7319) < 50 || countitem(984) < 5 || countitem(7317) < 70) {
				mes "[ベネッサ]";
				mes "デストロイヤーを作るには";
				mes "古い鉄板50個、";
				mes "オリデオコン5個、";
				mes "錆びたネジ70個、";
				mes "手数料の10万Zenyが必要よ。";
				close;
			}
			if(Zeny < 100000) {
				mes "[ベネッサ]";
				mes "材料は十分だけど、";
				mes "手数料の10万Zenyが足りないわよ。";
				close;
			}
			if(MaxWeight - Weight <= 1200) {
				mes "[ベネッサ]";
				mes "荷物がいっぱいじゃない。";
				mes "ちょっと整理してきてよ。";
				close;
			}
			mes "[ベネッサ]";
			mes "オッケー";
			mes "全部そろってるわね。";
			mes "じゃ、あらかじめ作っておいた";
			mes "デストロイヤーと";
			mes "交換してあげる。";
			delitem 7319,50;
			delitem 984,5;
			delitem 7317,70;
			getitem 13160,1;
			next;
			mes "[ベネッサ]";
			mes "もし、また必要になったら";
			mes "いつでも来てね。";
			mes "次は他の格闘術を";
			mes "かけてあ・げ・る。";
			close;
		case 2:
			mes "[ベネッサ]";
			mes "オッケー";
			mes "スロット付きのデストロイヤーは";
			mes "私が個人的に集めている";
			mes "のを持ってくれば";
			mes "交換してあげるわ。";
			next;
			mes "[ベネッサ]";
			mes "交換するのは";
			mes "2スロットあるフィンガー1個、";
			mes "オリデオコン5個。";
			mes "作ってみる？";
			next;
			if(select("ちょっと考えてみます","お願いします")==1) {
				mes "[ベネッサ]";
				mes "あ、そう。";
				mes "それじゃあゆっくり";
				mes "考えてみてよ。";
				close;
			}
			if(countitem(1812) < 1 || countitem(984) < 5) {
				mes "[ベネッサ]";
				mes "交換するのは";
				mes "2スロットあるフィンガー1個、";
				mes "オリデオコン5個よ。";
				close;
			}
			if(MaxWeight - Weight <= 1200) {
				mes "[ベネッサ]";
				mes "荷物がいっぱいじゃない。";
				mes "ちょっと整理してきてよ。";
				close;
			}
			mes "[ベネッサ]";
			mes "オッケー";
			mes "全部そろってるわね。";
			mes "じゃ、あらかじめ作っておいた";
			mes "スロット付きのデストロイヤーと";
			mes "交換してあげる。";
			delitem 1812,1;
			delitem 984,5;
			getitem 13161,1;
			next;
			mes "[ベネッサ]";
			mes "もし、また必要になったら";
			mes "いつでも来てね。";
			mes "次は他の格闘術を";
			mes "かけてあ・げ・る。";
			close;
		case 3:
			mes "[ベネッサ]";
			mes "あ、そう。";
			mes "それじゃあゆっくり";
			mes "していってよ。";
			mes "それとも、";
			mes "私とスパーリングでもする？";
			close;
		}
	}
}

//============================================================
// インフェルノ製作
//- Registry -------------------------------------------------
// GUN_4QUE -> 0〜5
//------------------------------------------------------------
que_ng.gat,187,163,3	script	イングリッド	744,{
	switch(GUN_4QUE) {
	case 0:
		mes "[イングリッド]";
		mes "こんにちは！";
		mes "武器の製作を担当している";
		mes "イングリッドと言います。";
		mes "よろしくお願いします。";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			mes "[イングリッド]";
			mes "でも、残念ながら";
			mes "私が制作する武器は";
			mes "ガンスリンガー専用です。";
			next;
			mes "[イングリッド]";
			mes "お客様は";
			mes "ガンスリンガーギルドに";
			mes "加入していないので、";
			mes "私の武器を使うことはできません。";
			mes "申し訳ありません。";
			close;
		}
		mes "[イングリッド]";
		mes "まだ仕事を始めたばかりですが、";
		mes "一生懸命がんばります！";
		next;
		mes "[イングリッド]";
		mes "ああ……どきどきします。";
		mes "私はお客様のために";
		mes "インフェルノという武器を";
		mes "作っています。";
		next;
		mes "[イングリッド]";
		mes "インフェルノは";
		mes "ガンスリンガーギルドの研究所で";
		mes "開発された武器の中でも、";
		mes "最高の一品です。";
		next;
		mes "[イングリッド]";
		mes "高い破壊力を備えながら、";
		mes "人体工学的設計を考え、";
		mes "手に持った時の安定性。";
		mes "発砲の反動を最小限にした";
		mes "素晴らしい武器です！";
		mes "ふふふふふふ……";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "……詳しいんですね。";
		next;
		mes "[イングリッド]";
		mes "当然です！";
		mes "その武器は私が設計";
		mes "したんですから。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "……なるほど……";
		next;
		mes "[イングリッド]";
		mes "……あー、んー";
		mes "ついつい自慢話に";
		mes "なってしまいましたね。";
		mes "セルレナ博士に比べると";
		mes "私なんて、まだまだ足元にも";
		mes "及ばないのに……";
		next;
		mes "[イングリッド]";
		mes "実は、私もガンスリンガー";
		mes "になりたかったんですが、";
		mes "身も心もついていけなくて、";
		mes "諦めちゃったんです。";
		next;
		mes "[イングリッド]";
		mes "でも、試験の間、";
		mes "セルレナ博士がずっと";
		mes "私の事を気にしてくれて、";
		mes "今のこの仕事ができるように";
		mes "色々と手伝ってくれたんです。";
		next;
		mes "[イングリッド]";
		mes "ガンスリンガーになれなかったのは";
		mes "ちょっと残念だけど、";
		mes "私と一緒に試験を受けた";
		mes "私のお兄ちゃんは";
		mes "ガンスリンガーになれました。";
		next;
		mes "[イングリッド]";
		mes "お兄ちゃんだけでも";
		mes "自分の夢を掴む事ができて、";
		mes "本当に嬉しいです。";
		next;
		mes "[イングリッド]";
		mes "アハハ。";
		mes "ごめんなさい。";
		mes "なんだか一人で勝手に";
		mes "しゃべってますね。";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "いいんですよ。";
		mes "私が見る限り、イングリッドさんは";
		mes "ガンスリンガーになれなかった今でも";
		mes "充分、輝いているみたいです。";
		next;
		mes "[イングリッド]";
		mes "フフ、ありがとうございます。";
		mes "本当に、今の仕事は楽しいです。";
		mes "……さて、話を戻しましょうか。";
		next;
		mes "[イングリッド]";
		mes "インフェルノの製作には";
		mes "古い鉄板100個、錆びたネジ50個、";
		mes "オリデオコン10個、";
		mes "燃えている心臓100個と";
		mes "手数料20万Zenyが必要です。";
		mes "よろしいですか？";
		next;
		if(select("少し考えてみます","お願いします")==1) {
			mes "[イングリッド]";
			mes "わかりました。";
			mes "では、ゆっくりと";
			mes "考えてみてください。";
			close;
		}
		mes "[イングリッド]";
		mes "わかりました。";
		mes "では、材料が集まったら";
		mes "また来てください。";
		next;
		mes "[イングリッド]";
		mes "インフェルノの製作には";
		mes "古い鉄板100個、錆びたネジ50個、";
		mes "オリデオコン10個、";
		mes "燃えている心臓100個と";
		mes "手数料20万Zenyが必要です。";
		mes "材料を間違えないでください。";
		set GUN_4QUE,1;
		close;
	case 1:
		if(countitem(7319) < 100 || countitem(7317) < 50 || countitem(984) < 10 || countitem(7097) < 100) {
			mes "[イングリッド]";
			mes "インフェルノの製作には";
			mes "古い鉄板100個、錆びたネジ50個、";
			mes "オリデオコン10個、";
			mes "燃えている心臓100個と";
			mes "手数料20万Zenyが必要です。";
			mes "材料を間違えないでください。";
			close;
		}
		if(Zeny < 200000) {
			mes "[イングリッド]";
			mes "材料は十分ですけど、";
			mes "手数料が足りてないです。";
			mes "20万Zenyです。";
			mes "間違えないでください。";
			close;
		}
		if(MaxWeight - Weight <= 1250) {
			mes "[イングリッド]";
			mes "荷物が一杯じゃないですか？";
			mes "少し整理してから";
			mes "また来てください。";
			close;
		}
		mes "[イングリッド]";
		mes "え、もう集めてきたんですか？";
		mes "本当……びっくりです。";
		mes "では、さっそく……";
		next;
		mes "[イングリッド]";
		mes "はい、これがインフェルノです。";
		mes "どうか大切に使ってください。";
		delitem 7319,100;
		delitem 7317,50;
		delitem 984,10;
		delitem 7097,100;
		set GUN_4QUE,2;
		getitem 13162,1;
		next;
		mes "[イングリッド]";
		mes "もし、私のお兄ちゃんに会ったら、";
		mes "話をしてみてください。";
		mes "お兄ちゃんの名前はイングラム。";
		mes "よかったら探してみてください。";
		close;
	case 2:
		mes "[イングリッド]";
		mes "こんにちは。";
		mes "またいらっしゃいましたね。";
		mes "インフェルノが必要に";
		mes "なったのですか？";
		next;
		if(select("いいえ","はい")==1) {
			mes "[イングリッド]";
			mes "そうですか。";
			mes "では、ゆっくりと";
			mes "していってください。";
			close;
		}
		if(countitem(7319) < 100 || countitem(7317) < 50 || countitem(984) < 10 || countitem(7097) < 100) {
			mes "[イングリッド]";
			mes "インフェルノの製作には";
			mes "古い鉄板100個、錆びたネジ50個、";
			mes "オリデオコン10個、";
			mes "燃えている心臓100個と";
			mes "手数料20万Zenyが必要です。";
			mes "材料を間違えないでください。";
			close;
		}
		if(Zeny < 200000) {
			mes "[イングリッド]";
			mes "材料は十分ですけど、";
			mes "手数料が足りてないです。";
			mes "20万Zenyです。";
			mes "間違えないでください。";
			close;
		}
		if(MaxWeight - Weight <= 1250) {
			mes "[イングリッド]";
			mes "荷物が一杯じゃないですか？";
			mes "少し整理してから";
			mes "また来てください。";
			close;
		}
		mes "[イングリッド]";
		mes "はい、これがインフェルノです。";
		mes "どうか大切に使ってください。";
		delitem 7319,100;
		delitem 7317,50;
		delitem 984,10;
		delitem 7097,100;
		getitem 13162,1;
		close;
	}
}
