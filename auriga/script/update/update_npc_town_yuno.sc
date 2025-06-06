//ジュノーNPC関連スクリプト 20240515 アップデート
//20191029 20200907 20201013 20201027 不審なボトル おいしい魚 美味しいお肉 綿の玉 豪華なペットフード 販売追加
//npc_town_yuno.sc 上書き

//shop
yuno_in01.gat,112,26,4	shop	防具商人	101,2628,2101,2107,2401,2501,2230,2301,2303,2305,2321,2332
yuno_in01.gat,103,35,2	shop	武器商人	49,1750,1751,1101,1701,1201,1204,1207,1210,1213,1216,1601,1604,1607,1610
yuno_in01.gat,25,34,4	shop	道具商人	83,1750,611,501,502,503,504,506,645,656,601,602
yuno.gat,163,187,4	shop	魔法商人	90,717,1601,1604,1607,1610,2232,2321,2332
yuno.gat,218,97,4	shop	道具商人	84,1750,611,501,502,503,504,506,645,656,601,602
yuno.gat,226,107,4	shop	道具商人	83,911,910,912
yuno.gat,205,103,4	shop	王窓商会	125,2340,2341,2411,2222,2230,1721
yuno.gat,197,114,4	shop	テイミング商人	124,537,643,10013,10014,6095,6096,6097,6098,6099,6100,6104,6105,6106,6107,6108,6109,6110,6111,6112,579,11616,25231,25233,25377

//============================================================
// ジュノーNPC
//------------------------------------------------------------
yuno.gat,334,182,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "「カウンターダガー」という";
	mes "武器があります。";
	mes "セージだけが装備可能な短剣で、";
	mes "高い確率でクリティカルが発生する";
	mes "魅力的な武器です。";
	close;
}

yuno.gat,263,320,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "「神の使者」と呼ばれる";
	mes "クルセイダー専用の";
	mes "神聖な盾が存在します。";
	next;
	mes "[ジュノー兵士]";
	mes "長細い盾の中央に、天使の羽を象徴する";
	mes "イメージが銘じられています。";
	mes "特に悪魔型のモンスターと相対する時に";
	mes "その真価を発揮するでしょう。";
	close;
}

yuno.gat,228,291,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "ジュノー近所には天使を装った";
	mes "「フェイクエンジェル」というやつが";
	mes "存在します。";
	next;
	mes "[ジュノー兵士]";
	mes "祝福を与える真似をして、";
	mes "油断した旅人を襲うモンスターです。";
	mes "美しい姿に目が眩んでしまっては、";
	mes "大変な事になるでしょう。";
	close;
}

yuno.gat,165,283,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "「ジオグラファー」";
	mes "昔、地理学者がモンスターに食われ、";
	mes "そのような姿になってしまったと";
	mes "伝えられています。";
	next;
	mes "[ジュノー兵士]";
	mes "周辺の硬い岩にさえ根を広げているため";
	mes "離れていても油断は禁物です。";
	close;
}

yuno.gat,150,283,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "溶岩はその熱で、鉄の鎧や武器さえ";
	mes "溶かしてしまいます。";
	mes "「ラーヴァゴーレム」と言う奴は";
	mes "その溶岩により心臓が強化され";
	mes "魔法的な力が増幅されています。";
	next;
	mes "[ジュノー兵士]";
	mes "考えなしに飛びかかっては、膨大な";
	mes "ダメージとともに、武器防具の損失を";
	mes "受けるかもしれません。";
	close;
}

yuno.gat,165,228,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "高く険しい山地に、モンスター化した";
	mes "山羊が棲息しております。";
	next;
	mes "[ジュノー兵士]";
	mes "その岩より堅い頭角にやられれば";
	mes "どんな人でも頭を割られてしまうほどで";
	mes "更に、山の絶壁に鍛えられた足は";
	mes "恐ろしい速度で獲物を探し、飛び掛って";
	mes "くるといわれています。";
	close;
}

yuno.gat,150,228,4	script	ジュノー兵士	852,{
	mes "[ジュノー兵士]";
	mes "ここは高度な知識が息づく";
	mes "賢者の都市ジュノーであります。";
	mes "ジュノーにいらした皆様を";
	mes "我々は歓迎いたします。";
	next;
	mes "[ジュノー兵士]";
	mes "見たんです！";
	mes "ゼロピーです！すごく大きいゼロピー！";
	mes "！";
	mes "非常に大きくて、やたらとピカピカした";
	mes "光を出す大きなゼロピーだったんです！";
	close;
}

yuno.gat,184,173,4	script	ジュノー民	729,{
	mes "[イフレット]";
	mes "賢者の都市^3152FF「ジュノー」^000000は";
	mes "三種の島で構成されています。";
	next;
	mes "[イフレット]";
	mes "^0000ff「機能の中心を担うソロモン島」^000000";
	mes "^ff0000「居住地区のミネタ島」^000000";
	mes "^00ff00「知識が集中するスノトラ島」^000000";
	mes "です。";
	next;
	mes "[イフレット]";
	mes "それぞれの島の位置関係は";
	mes "北西 : ソロモン";
	mes "北東 : スノトラ";
	mes "南 : ミネタ";
	mes "となっています。";
	close;
}

yuno.gat,343,68,4	script	絶対者	730,{
	mes "[ニノ]";
	mes "エジプト王であり、";
	mes "太陽神の息子と呼ばれ";
	mes "一王朝を支配した王";
	mes "^3152FF「ファラオ」^000000";
	next;
	mes "[ニノ]";
	mes "呪術において優れた能力を発揮したと";
	mes "知られ、人に沈黙を言い付け、";
	mes "呪いをかけ、その威力は";
	mes "おびただしいと聞いています。";
	next;
	mes "[ニノ]";
	mes "それほど悪質的な能力を";
	mes "いったい、どうやって……";
	mes "　";
	mes "あなたはファラオに会って";
	mes "みたことがありますか？";
	close;
}

yuno.gat,328,239,4	script	武道家	732,{
	mes "[セラプラブ]";
	mes "私はフォゼル=オラクルに仕えている";
	mes "ジュノーの武道家";
	mes "セラプラブと申します。";
	next;
	mes "[セラプラブ]";
	mes "あなたに上級レベルのペコペコである";
	mes "^3152FFグランドペコ^000000の話をして上げましょう。";
	next;
	mes "[セラプラブ]";
	mes "グランドペコは、ペコペコより";
	mes "ずっと早く、攻撃的であります。";
	mes "力強いくちばしを利用した";
	mes "攻撃を主な武器とし、";
	mes "数匹のペコペコを連れて";
	mes "現れるといいます。";
	next;
	mes "[セラプラブ]";
	mes "……どうやら、時間のようです。";
	mes "では、あなたの願う事が";
	mes "無事成し遂げられますように……";
	close;
}

yuno.gat,337,227,4	script	預言者	103,{
	mes "[フォゼル=オラクル]";
	mes "よく来たのぉ……";
	mes "私は何でも予知する";
	mes "ジュノーの賢者婆さんじゃね。";
	mes "ずいぶんと前からジュノー周辺で";
	mes "暴れておる巨大なモンスターの";
	mes "名前をご存知かや？";
	next;
	mes "[フォゼル=オラクル]";
	mes "^ff5533「ロードオブデス」^000000";
	mes "生命そのものを恨み、どこぞ遠い";
	mes "世界からやって来たと言うことじゃ。";
	mes "彼は……もう死んでおる。";
	next;
	mes "[フォゼル=オラクル]";
	mes "多くのモンスターを率いて現れ、";
	mes "命ある全てのものを打ち、";
	mes "あの世へと導く……";
	next;
	mes "[フォゼル=オラクル]";
	mes "お前はロードオブデスと相対するか否か";
	mes "選択することとなろう。";
	mes "どうしてそうするのか、しなければ";
	mes "ならなかったのか……";
	mes "理解できれば良いがの……";
	close;
}

yuno.gat,157,205,4	script	物知りじいさん	54,{
	mes "[物知りじいさん]";
	mes "もぐもぐ　もきゅもきゅ";
	mes "お元気かね〜？";
	mes "私はジュノーの";
	mes "いろ〜んなアイテムの";
	mes "職人精神を受け継ぐ年寄りじゃ。";
	mes "何か知りたいかね？";
	next;
	switch(select("強い装備に関して","珍しいアイテムに関して","珍しい食べ物に関して","話しをやめる")) {
	case 1:
		mes "[物知りじいさん]";
		mes "^3152FF「ホーリーガード」^000000と";
		mes "^3152FF「ホーリーアヴェンジャー」^000000";
		mes "クルセーダー専用の";
		mes "神聖な装備じゃ。";
		mes "どっちもとても軽くて、";
		mes "攻撃、防御力が高い。";
		next;
		mes "[物知りじいさん]";
		mes "注目すべき点は";
		mes "神聖な力が付属されているので";
		mes "幽霊系のモンスターに";
		mes "その威力を発揮することじゃろう。";
		next;
		mes "[物知りじいさん]";
		mes "とても貴重な品なので";
		mes "選ばれたクルセーダーのみ";
		mes "装備できるのじゃ……………";
		close;
	case 2:
		mes "[物知りじいさん]";
		mes "丸い中にまたまん丸……";
		mes "そして六芒星の魔方陣。";
		mes "^FF5533「古い魔法陣」^000000は";
		mes "古く見えるが、非常に几帳面に";
		mes "布陣された魔方陣の一種として";
		mes "たくさんの賢者たちに";
		mes "研究されておる。";
		next;
		mes "[物知りじいさん]";
		mes "高度な魔法を覚えるときに使うらしいとのことじゃ〜。";
		close;
	case 3:
		mes "[物知りじいさん]";
		mes "^3152FF「氷菓子」^000000!!";
		mes "それはロマン！";
		mes "長い長い間愛され続け、";
		mes "伝統を忘れず、受け継がれてきた";
		mes "昔から変わらぬその味！";
		next;
		mes "[物知りじいさん]";
		mes "ああ、氷菓子！";
		mes "一口でもいい、食べたいの〜〜";
		mes "もきゅもきゅ……";
		close;
	case 4:
		mes "[物知りじいさん]";
		mes "「ジュノー」は賢者達の都市じゃが";
		mes "平凡な人々も一緒に暮らしおる。";
		mes "ジュノーだけの独特な魅力を";
		mes "たっぷり見ていって欲しいの〜。";
		close;
	}
}

//============================================================
// 空間転送NPC
//------------------------------------------------------------
yuno.gat,165,111,4	script	賢者	123,{
	if(rand(100)) {
		mes "[リモルピオス]";
		mes "^3152FF「アポカリプス」^000000";
		mes "それは忘れられてしまった古代文明。";
		mes "ジュノーの門番として";
		mes "治安を任されたヒューマノイド……";
		next;
		mes "[リモルピオス]";
		mes "ロボットに似ているといいますが";
		mes "彼の人工知能は、長い歳月の間に";
		mes "台無しになり、我々と敵を";
		mes "識別できなくなってしまった。";
		next;
		mes "[リモルピオス]";
		mes "今では、無差別攻撃を行う";
		mes "化け物になってしまったと";
		mes "言われています。";
		close;
	}
	//低確率でワープイベント発生
	if(Zeny<5000) {
		mes "[リモルピオス]";
		mes "あなたは大きな幸運を";
		mes "逃したのです……あなたには";
		mes "運はあるが、それを";
		mes "活かせるだけの器量がないらしい……";
		mes "それでは、さようなら……";
		close;
	}
	mes "[リモルピオス]";
	mes "さぁ、私の手のには";
	mes "二つのハーブがあります。";
	mes "^3152FF一つはすべてを忘れて";
	mes "仮想現実世界に残る";
	mes "青ハーブ^000000";
	next;
	mes "[リモルピオス]";
	mes "そしてもう一つは";
	mes "^FF3152真実を明らかにする";
	mes "赤ハーブです^000000";
	mes "どちらも^3152FF5000 zeny^000000を";
	mes "消費しなければなりません";
	mes "さぁ、選択なさい……";
	next;
	switch(select("^FF3152赤ハーブ^000000を選択する","^3152FF青ハーブ^000000を選択する")) {
	case 1:
		mes "[リモルピオス]";
		mes "あなたはすべてを忘れて";
		mes "仮想現実世界に";
		mes "残るでしょう……";
		getitem 507,1;
		warp "prontera.gat",182,206;
		break;
	case 2:
		mes "[リモルピオス]";
		mes "あなたは真実を";
		mes "見れるようになるはずです……";
		getitem 510,1;
		warp "pay_dun03.gat",200,222;
		break;
	}
	set Zeny,Zeny-5000;
	end;
}

//============================================================
// バーンとバジン兄弟クエストNPC
//- Registry -------------------------------------------------
// YUNO_1QUE -> 0〜1
//------------------------------------------------------------
yuno_in01.gat,103,157,3	script	バーン	98,{
	if(YUNO_1QUE == 0) {
		mes "[バーン]";
		mes "私はアルケミスト。";
		mes "弟と共にホムンクルスの";
		mes "研究をしています。";
		mes "過去に、自然の物質と";
		mes "金属を調合して、";
		next;
		mes "[バーン]";
		mes "自分の意思を持つ";
		mes "ホムンクルスを作ったという";
		mes "記録があったみたいです。";
		mes "でも、そんなものがあったら";
		mes "私たちもこんなに苦労しないと";
		mes "思うんですけどね……";
		next;
		mes "[バーン]";
		mes "今は材料不足で研究がすっかり";
		mes "止まっています。";
		mes "そのへんのアルケミスト達は";
		mes "どんな材料を集めるのかすら";
		mes "知らないし、";
		next;
		mes "[バーン]";
		mes "中にはモンスターを倒さないと";
		mes "手に入らない材料があるから";
		mes "まったくお手上げですよ……";
		next;
		if(select("私が集めてきます","頑張ってください")==2) {
			mes "[バーン]";
			mes "あなたのような気ままに暮らす";
			mes "旅人がうらやましい……";
			close;
		}
		mes "[バーン]";
		mes "おおお！";
		mes "なんと親切な人だ！";
		mes "あなたが私たちの研究に";
		mes "光を与えてくれるのですね！";
		mes "では、必要な物を教えます。";
		next;
		mes "[バーン]";
		mes "^ff0000混合剤^000000 1本";
		mes "^ff0000携帯用溶鉱炉^000000 5個";
		mes "^ff0000燃えた木^000000 5個";
		mes "^ff0000石炭^000000 5個";
		mes "^ff0000きれいな砂^000000 5個";
		next;
		mes "[バーン]";
		mes "^ff0000エルニウム原石^000000 3個";
		mes "^ff0000オリデオコン原石^000000 3個";
		next;
		mes "[バーン]";
		mes "そして一緒に混ぜる2000Zenyが";
		mes "必要です。";
		mes "小銭を混ぜると良いんですよ。";
		mes "ではお願いしますね。";
		set YUNO_1QUE,1;
		close;
	}
	if(countitem(974) < 1 || countitem(7068) < 5 || countitem(7043) < 5 || countitem(756) < 3 ||
					countitem(757) < 3 || countitem(612) < 3 || countitem(1003) < 5) {
		mes "[バーン]";
		mes "また忘れるかもしれないですから";
		mes "もう一度材料を読みます。";
		mes "メモでも取りながら覚えて";
		mes "くださいね。";
		next;
		mes "[バーン]";
		mes "^FF0000混合剤^000000 1本";
		mes "^FF0000携帯用溶鉱炉^000000 3個";
		mes "^FF0000燃えた木^000000 5個";
		mes "^FF0000石炭^000000 5個";
		mes "^FF0000きれいな砂^000000 5個";
		next;
		mes "[バーン]";
		mes "^FF0000エルニウム原石^000000 3個";
		mes "^FF0000オリデオコン原石^000000 3個";
		next;
		mes "[バーン]";
		mes "そして一緒に混ぜる2000Zenyが";
		mes "必要です。";
		mes "ではお願いしますね。";
		close;
	}
	delitem 974,1;
	delitem 7068,5;
	delitem 7043,5;
	delitem 756,3;
	delitem 757,3;
	delitem 612,3;
	delitem 1003,5;
	mes "[バーン]";
	mes "おお、必要な材料を";
	mes "全部集めてきてくれましたか。";
	mes "本当にありがとう！";
	mes "よし、それでは合成を始めましょう。";
	mes "少し待っててください。";
	next;
	mes "-グイーン ガリガリガリ-";
	next;
	mes "-ジジジジ ゴゥンゴゥン-";
	next;
	mes "-シャカシャカ ポン！-";
	next;
	mes "[バーン]";
	mes "ホイッと。";
	mes "合成は終わりました。";
	set '@rand,rand(10);
	switch('@rand) {
	default:
		mes "そしてなぜか^FF0000鉄鉱石^000000も";
		mes "5個できました。";
		break;
	case 6:
	case 7:
	case 8:
		mes "そしてなぜか^FF0000ルビー^000000も";
		mes "5個できました。";
		break;
	case 9:
		mes "そしてなぜか^FF0000黄金^000000も";
		mes "3個できました。";
		break;
	}
	next;
	mes "[バーン]";
	mes "結果がわかったので";
	mes "これは私には必要ありません。";
	mes "あげます。";
	next;
	mes "[バーン]";
	mes "協力してくれてありがとう。";
	mes "それではよい旅を〜";
	close2;
	switch('@rand) {
	default:
		getitem 1002,5;
		break;
	case 6:
	case 7:
	case 8:
		getitem 723,5;
		break;
	case 9:
		getitem 969,3;
		break;
	}
	if(CHANGE_AM == 12)	//アルケミスト転職試験用
		set CHANGE_AM,13;
	close;
}

yuno_in01.gat,100,153,7	script	バジン	47,{
	if(YUNO_1QUE == 0) {
		mes "[バジン]";
		mes "私はアルケミストのバジンです。";
		mes "兄と一緒に研究しています。";
		mes "私たちの夢はホムンクルスを";
		mes "作ることですが、私は兄と";
		mes "一緒に研究することが";
		mes "大好きなんです。";
		next;
		mes "[バジン]";
		mes "しかし今は材料不足で研究に";
		mes "遅れが出てしまっています……";
		mes "こんなに熱心にやっているのに";
		mes "運が無いです……";
		next;
		if(select("私が集めてきます","元気出してください")==2) {
			mes "[バジン]";
			mes "私もたまには兄と旅に出たい";
			mes "ものですよ……";
			close;
		}
		mes "[バジン]";
		mes "おおお！";
		mes "なんと親切な人だ！";
		mes "あなたが私たちの研究に";
		mes "光を与えてくれるのですね！";
		mes "では、必要な物を教えます。";
		next;
		mes "[バジン]";
		mes "^FF0000混合剤^000000 1本";
		mes "^FF0000携帯用溶鉱炉^000000 3個";
		mes "^FF0000燃えた木^000000 5個";
		mes "^FF0000石炭^000000 5個";
		mes "^FF0000きれいな砂^000000 5個";
		next;
		mes "[バジン]";
		mes "^FF0000エルニウム原石^000000 3個";
		mes "^FF0000オリデオコン原石^000000 3個";
		next;
		mes "[バジン]";
		mes "そして一緒に混ぜる2000Zenyが";
		mes "必要です。";
		mes "小銭を混ぜると良いんです。";
		mes "ではお願いしますね。";
		set YUNO_1QUE,1;
		close;
	}
	if(countitem(974) < 1 || countitem(7068) < 5 || countitem(7043) < 5 || countitem(756) < 3 ||
					countitem(757) < 3 || countitem(612) < 3 || countitem(1003) < 5) {
		mes "[バジン]";
		mes "あらら、材料を忘れてしまいましたか。";
		mes "また読んであげますから";
		mes "しっかり覚えてくださいね。";
		next;
		mes "[バジン]";
		mes "^ff0000混合剤^000000 1本";
		mes "^ff0000携帯用溶鉱炉^000000 5個";
		mes "^ff0000燃えた木^000000 5個";
		mes "^ff0000石炭^000000 5個";
		mes "^ff0000きれいな砂^000000 5個";
		next;
		mes "[バジン]";
		mes "^ff0000エルニウム原石^000000 3個";
		mes "^ff0000オリデオコン原石^000000 3個";
		next;
		mes "[バジン]";
		mes "そして一緒に混ぜる2000Zenyが";
		mes "必要です。";
		mes "全部揃えるのは大変でしょうけれど";
		mes "よろしくおねがいします。";
		close;
	}
	delitem 974,1;
	delitem 7068,5;
	delitem 7043,5;
	delitem 756,3;
	delitem 757,3;
	delitem 612,3;
	delitem 1003,5;
	mes "[バジン]";
	mes "おお、必要な材料を";
	mes "全部集めてきてくれましたか。";
	mes "本当にありがとう！";
	mes "よし、それでは合成を始めましょう。";
	mes "少し待っててください。";
	next;
	mes "-グイーン ガリガリガリ-";
	next;
	mes "-ジジジジ ゴゥンゴゥン-";
	next;
	mes "-シャカシャカ ポン！-";
	next;
	set '@rand,rand(10);
	mes "[バジン]";
	mes "よし、合成は成功！";
	mes "なぜだかわからないけど";
	switch('@rand) {
	default:
		mes "^FF0000鉄鉱石^000000が5個できました。";
		break;
	case 6:
	case 7:
	case 8:
		mes "^FF0000エメラルド^000000が5個できました。";
		break;
	case 9:
		mes "^FF0000オリデオコン^000000が3個できました。";
		break;
	}
	next;
	mes "[バジン]";
	mes "とりあえず結果がわかったから";
	mes "こいつは要りません。";
	mes "まだまだ研究を続けたいので";
	mes "材料がそろったらまた来てください。";
	switch('@rand) {
	default:
		getitem 1002,5;
		break;
	case 6:
	case 7:
	case 8:
		getitem 721,5;
		break;
	case 9:
		getitem 984,3;
		break;
	}
	if(CHANGE_AM == 12)	//アルケミスト転職試験用
		set CHANGE_AM,13;
	close;
}

//============================================================
// メトの研究妨害クエストNPC
//- Registry -------------------------------------------------
// YUNO_2QUE -> 0〜9
//------------------------------------------------------------
yuno_in01.gat,17,30,4	script	ウェイコン	85,{
	switch(YUNO_2QUE) {
	case 0:
		mes "[ウェイコン]";
		mes "ご存知の通り、";
		mes "我が都市は非常に発達した科学";
		mes "の上に成り立っています。";
		mes "これも先人の偉業あってこそ。";
		next;
		mes "[ウェイコン]";
		mes "研究は都市から推奨されており、";
		mes "努力する研究者にはそれなりの";
		mes "手当ても付くのです。";
		mes "しかしそれを良いことに、";
		mes "自分の都合だけで研究をする";
		mes "科学者が出るようになりました。";
		next;
		mes "[ウェイコン]";
		mes "彼らはマッドサイエンティストと";
		mes "呼ばれ、中でも^ff0000メト^000000という者が";
		mes "問題視されている。";
		next;
		mes "[ウェイコン]";
		mes "彼は自分の研究に打ち込んで、";
		mes "公共施設破壊・騒音・公害等";
		mes "迷惑の限りをつくしてます。";
		mes "いくら研究に没頭する科学者でも";
		mes "こうは酷くない。なんとかやめさせ";
		mes "られないものか……";
		next;
		if(select("私に任せてください","天運を祈ります")==2) {
			mes "[ウェイコン]";
			mes "そう、祈らなければ……";
			mes "そういえばメトも天運という";
			mes "ものを非常に信じているらしいです。";
			mes "それを利用すればひょっとして";
			mes "なんとかなるかもしれません……";
			close;
		}
		mes "[ウェイコン]";
		mes "おお！";
		mes "あなたが対処してくれますか！";
		mes "助かります……";
		mes "して……なにか策はあるのでしょうか？";
		next;
		if(select("もちろんです","これから考えます")==1) {
			mes "[ウェイコン]";
			mes "頼もしいですね！";
			mes "彼は運命を信じる人だから";
			mes "それを利用すると良いかもしれません。";
			mes "ま、自身のあるあなたに";
			mes "とやかく言うのもなんですね。";
			mes "それでは幸運を祈ります。";
		}
		else {
			mes "[ウェイコン]";
			mes "う〜ん……";
			mes "いっそこれで……";
			mes "あ、いやなんでもないです。";
			mes "メトは運命を信じるから";
			mes "彼に知れず色々工作して";
			mes "研究の邪魔をできれば、";
			next;
			mes "[ウェイコン]";
			mes "それを天運が無くなったと";
			mes "勘違いして諦める可能性が";
			mes "あるでしょう。";
			mes "あと、初対面の人には何でも";
			mes "べらべらしゃべる癖がありますから";
			mes "これを利用するのも良いでしょう。";
			mes "では、健闘を祈ります。";
		}
		set YUNO_2QUE,1;
		close;
	default:	//1〜7のとき
		mes "[ウェイコン]";
		mes "メトをおとなしくさせなくては……";
		close;
	case 8:
		mes "[ウェイコン]";
		mes "ありがとうございます！";
		mes "あなたのおかげで頭痛の種";
		mes "であったマッドサイエンティスト";
		mes "メトをおとなしくさせることが";
		mes "できました。";
		next;
		mes "[ウェイコン]";
		mes "これで我が街も少しは平和に";
		mes "なるでしょう……";
		next;
		getitem 717,(rand(2))? 5: 10;
		set YUNO_2QUE,9;
		mes "[ウェイコン]";
		mes "それではあなたの未来に";
		mes "幸運がありますように。";
		close;
	case 9:
		mes "[ウェイコン]";
		mes "あなたの未来に幸運が";
		mes "ありますように。";
		close;
	}
}

yuno_in03.gat,26,39,4	script	メト	709,{
	switch(YUNO_2QUE) {
	case 0:
		mes "[メト]";
		mes "今日も研究、明日も研究";
		mes "明後日も研究……";
		mes "研究研究研究……";
		mes "カカカカカ！";
		next;
		mes "[メト]";
		mes "いつか新しいジュノーを創って";
		mes "私だけの国にするぞ！";
		mes "この島を浮かせている技術さえ";
		mes "究明することができれば";
		mes "私の国を創るのも夢ではない！";
		next;
		mes "[メト]";
		mes "しかし^ff0000ウェイコン^000000め……";
		mes "やつは私の研究をいつもバカに";
		mes "する……";
		mes "しかし！私には神がついている。";
		mes "私の研究は絶対に成功する！";
		close;
	case 1:
		mes "[メト]";
		mes "私は同僚の科学者^ff0000ステンクル^000000を";
		mes "訪ねてみて、今私がしている";
		mes "研究について話してみる";
		mes "つもりだ。";
		mes "頼りになりそうなのは";
		mes "奴くらいだからな……";
		mes "明るい結果が見たければ";
		mes "君も神様にお祈りしなさい。";
		set YUNO_2QUE,2;
		close;
	case 2:
	case 4:
	case 6:
		mes "[メト]";
		mes "そろそろ働きに行かなければ……";
		mes "私は準備があるからそのうち";
		mes "ここを出る。";
		mes "君は先に出てなさい。";
		close;
	case 3:
		mes "[メト]";
		mes "ぐあっ！";
		mes "ステンクルの奴が急に私と";
		mes "会議するのが嫌だと言い出した……";
		mes "これでは私の研究に相当な";
		mes "遅れが出てしまう……";
		mes "どうしたもんか……";
		next;
		mes "[メト]";
		mes "ふふ……";
		mes "だかしかし！";
		mes "保険はしっかりあるのだよ！";
		mes "科学者^ff0000カブト^000000に";
		mes "今の研究に必要な合金";
		mes "「グレートＺ」を貰えば";
		next;
		mes "[メト]";
		mes "私の研究は続行できる。";
		mes "ステンクルと組めばもっと";
		mes "完璧にいったと思うが……";
		mes "まぁこの際仕方がない。";
		next;
		mes "[メト]";
		mes "君も期待していろよ！";
		mes "よし！クックックック……";
		set YUNO_2QUE,4;
		close;
	case 5:
		mes "[メト]";
		mes "ぬおおおお!?";
		mes "な……こここ……………";
		mes "なんてこった!!!";
		mes "私の研究に必要なグレートＺが";
		mes "壊れてしまった！";
		next;
		mes "[メト]";
		mes "ぐふふ……";
		mes "しかし私の運はまだ残っている。";
		mes "研究に遅れは出るが";
		mes "^ff0000ジジ^000000博士のライドエンジン理論を";
		mes "応用すれば……";
		mes "なんとかなる！";
		next;
		mes "[メト]";
		mes "私にはまだ天運がある。";
		mes "クヒヒヒヒヒヒヒ！";
		set YUNO_2QUE,6;
		close;
	case 7:
		mes "[メト]";
		mes "……";
		next;
		mes "[メト]";
		mes "…………";
		mes "どどどどうして……";
		mes "同じようなことが３回も続く……";
		mes "起きてみたら大事な理論を";
		mes "すっかり忘れてしまった……";
		next;
		mes "[メト]";
		mes "どうしよう……";
		mes "一生を賭けた研究も";
		mes "もうここまでなのか……？";
		next;
		mes "[メト]";
		mes "私の研究に期待してくれた君、";
		mes "もう忘れてくれ……";
		mes "天運が尽きたようだ……";
		next;
		mes "[メト]";
		mes "ちょっと疲れたな……";
		mes "休暇を取ろう……";
		mes "もう研究なんか二度としない";
		mes "予定だから期待しないで……";
		set YUNO_2QUE,8;
		close;
	case 8:
	case 9:
		mes "[メト]";
		mes "少し考えてみたんだが、";
		mes "ずっとこの仕事を続けるより";
		mes "アルケミストやモンクが";
		mes "よさそうだね……";
		mes "ま、科学者はもうやめ。";
		close;
	}
}

yuno_in01.gat,17,95,4	script	ステンクル	99,{
	switch(YUNO_2QUE) {
	case 0:
	case 1:
		mes "[ステンクル]";
		mes "私はこの街に住む科学者";
		mes "ステンクルという。";
		mes "名前を覚えておいて";
		mes "損はしないぞ。";
		close;
	case 2:
		mes "[ステンクル]";
		mes "ん？何の用だ？";
		mes "仲間のメトが来て打ち合わせを";
		mes "する予定だから時間が無い。";
		mes "用件だけ言いたまえ。";
		next;
		if(select("(研究の邪魔をする)","特に用は無いです")==2) {
			mes "[ステンクル]";
			mes "用が無いなら出て行ってくれ。";
			mes "忙しいからな。";
			close;
		}
		mes "[ステンクル]";
		mes "……………";
		next;
		mes "[ステンクル]";
		mes "……………";
		next;
		mes "[ステンクル]";
		mes "……………";
		next;
		mes "[ステンクル]";
		mes "なに？それは本当か？";
		mes "メトは私のことを仲間などと";
		mes "思わず、研究のための道具にし、";
		mes "成果が出たら全て自分の功績に";
		mes "しようとしていると？";
		next;
		mes "[ステンクル]";
		mes "く……";
		mes "あのマッドサイエンティストめ！";
		next;
		mes "[ステンクル]";
		mes "いつも研究に打ち込み";
		mes "常に暴走ばかりしている奴だが";
		mes "中身もそんなだとは……";
		mes "もう奴の顔も見たくない。";
		set YUNO_2QUE,3;
		close;
	default:	//3〜9のとき
		mes "[ステンクル]";
		mes "もうメトとは会っていない。";
		mes "マッドサイエンティストとは";
		mes "縁を切った";
		close;
	}
}

yuno_in01.gat,19,183,4	script	カブト	55,{
	switch(YUNO_2QUE) {
	case 0:
	case 1:
	case 2:
	case 3:
		mes "[カブト]";
		mes "私はカブト。";
		mes "機械工学が専門だ。";
		mes "私の研究の成果である。";
		mes "グレートZという特殊合金は";
		mes "傑作中の傑作だ。";
		close;
	case 4:
		mes "[カブト]";
		mes "私は機械のように冷徹な男。";
		mes "しかし研究に関しては熱い";
		mes "情熱を燃やしている。";
		mes "私に何の用だ？";
		next;
		if(select("(研究の邪魔をする)","挨拶する")==2) {
			mes "[カブト]";
			mes "……………";
			mes "くだらん……";
			close;
		}
		mes "[カブト]";
		mes "なに？私のグレートZが";
		mes "ステンクルの研究より役に";
		mes "立たないだと？";
		mes "奴は前々から信用ならんやつ";
		mes "だったが、これでわかったな。";
		next;
		mes "[カブト]";
		mes "そんなやつにこのグレートZを";
		mes "使われたくはない。";
		mes "メトに渡すグレートZは";
		mes "壊さねば……";
		next;
		mes "[カブト]";
		mes "言いにくい助言をわざわざ";
		mes "しにきてくれてありがとう。";
		set YUNO_2QUE,5;
		close;
	default:	//5〜9のとき
		mes "[カブト]";
		mes "私は、人間が乗ることも可能な";
		mes "巨大な人間型の機械を作るために";
		mes "研究を重ねている。";
		mes "それはたやすいことではないが、";
		mes "この特殊合金があれば";
		mes "いつかできる日がくるだろう……";
		next;
		mes "[カブト]";
		mes "いつかシュバルツバルドに巨人が";
		mes "現れたら、私が作ったものだと";
		mes "思いなさい。";
		close;
	}
}

yuno_in03.gat,178,43,4	script	ジジ	121,{
	if(YUNO_2QUE >= 7) {
		mes "[ジジ]";
		mes "う〜む……";
		mes "ライドエンジン理論を具現化";
		mes "するための材料が足りない……";
		mes "う〜〜む……";
		close;
	}
	mes "[ジジ]";
	mes "私の名はジジ！";
	mes "この街の３大頭脳と言われる";
	mes "科学者のうちの一人である。";
	next;
	mes "[ジジ]";
	mes "この街に科学者が多いのは";
	mes "知っているかと思うが、その中";
	mes "でも３大頭脳と呼ばれるように";
	mes "なるにはホント苦労したぞ。";
	if(YUNO_2QUE < 6)
		close;
	next;
	mes "[ジジ]";
	mes "あ、で何の用？";
	next;
	if(select("(研究の邪魔をする)","挨拶する")==2) {
		mes "[ジジ]";
		mes "なんだ、暇人か？";
		mes "暇人に付き合えるほど";
		mes "暇じゃない。";
		close;
	}
	mes "[ジジ]";
	mes "ふむ……メトが私の";
	mes "ライドエンジン理論など必要ないと";
	mes "言ったのか……";
	mes "暇があれば奴を捕まえて私の";
	mes "研究の素晴らしさをいやというほど";
	mes "教えてやりたいが";
	next;
	mes "[ジジ]";
	mes "やらなければならないことが";
	mes "あってね……";
	mes "ま、結局メトがそんなことを";
	mes "言わなくてもライドエンジン理論";
	mes "を具現化させる材料が足りない";
	mes "から同じことだけどな。";
	next;
	mes "[ジジ]";
	mes "それにしてもメトの考えが";
	mes "わかった以上これから";
	mes "研究を共にしたくはないね。";
	mes "よく教えてくれた。";
	set YUNO_2QUE,7;
	close;
}

//============================================================
// 魔剣クエスト - 試練の証編NPC
//- Registry -------------------------------------------------
// MJO_2QUE -> 0〜10
//------------------------------------------------------------
yuno.gat,157,87,4	script	ジュノー住民	102,{
	mes "[イコン=リクチチ]";
	mes "アルデバラン方面へ";
	mes "旅をしていると";
	mes "「エルメスプレート」と呼ばれる";
	mes "溶岩地帯の側を通ると思います。";
	mes "その息も詰まる熱気の中でできた";
	next;
	mes "[イコン=リクチチ]";
	mes "巨大な山脈の頂点に";
	mes "この……";
	mes "学者たちの都市^3152FF「ジュノー」^000000";
	mes "をうかがうことができます。";
	next;
	if(MJO_2QUE == 1) {	//コモド編をクリア時に発行されるフラグ
		mes "[イコン=リクチチ]";
		mes "あ……もしやあなたの持つ";
		mes "その華麗な光を放つ物は……";
		next;
		mes "[イコン=リクチチ]";
		mes "^3152FF「ミョルニールの印」!!^000000";
		mes "本当に驚いた！";
		mes "……";
		mes "ジュノーの入り口から右手に";
		mes "入ると書店通りに出ます。";
		next;
		mes "[イコン=リクチチ]";
		mes "その辺に居るはずの";
		mes "ジュノー三賢者の一人である";
		mes "^3152FF「イクルラ」^000000様に";
		mes "会ってみなさい。";
		next;
		mes "[イコン=リクチチ]";
		mes "何らかのカギがつかめる";
		mes "かもしれません。";
		mes "……";
		mes "それでは君の未来に";
		mes "幸運の光があらんことを……";
		close;
	}
	mes "[イコン=リクチチ]";
	mes "ここ、ジュノーは";
	mes "「中央広場」";
	mes "「ジュノー議事堂」";
	mes "「シュバイチェル魔法アカデミー」";
	mes "「モンスター博物館」のように";
	mes "世界的に有名な名所が";
	next;
	mes "[イコン=リクチチ]";
	mes "たくさんあります。";
	mes "特に高位職業である";
	mes "「セージ」への転職について";
	mes "処理している「セージキャッスル」は";
	mes "ジュノーでしか見ることができません。";
	next;
	mes "[イコン=リクチチ]";
	mes "セージに関して色々と知りたい時は";
	mes "立ち寄ってみると良いでしょう。";
	close;
}

yuno.gat,261,99,4	script	賢者イクルラ	735,{
	switch(MJO_2QUE) {
	default:
		mes "[イクルラ]";
		mes "^3152FFジュピロス^000000 -";
		mes "超古代に「ユミルの心臓」を";
		mes "自由にコントロールする";
		mes "知識を持ったものが集う";
		mes "都市であった。";
		next;
		mes "[イクルラ]";
		mes "しかし、その力に溺れたあげく";
		mes "ユミルの心臓の力を乱用し、";
		mes "自滅に至った者等が";
		mes "存在する場所でもある……";
		next;
		mes "[イクルラ]";
		mes "その大いなる知識を得ようと";
		mes "思うなら、まず、強くなりなさい。";
		mes "無心になればこそ、";
		mes "得られる力もありましょう……";
		close;
	case 1:
		mes "[イクルラ]";
		mes "- !!!!! -";
		next;
		mes "[イクルラ]";
		mes "君が持っている鮮やかな光を";
		mes "放つそれは……";
		mes "^3152FF「ミョルニールの印」^000000";
		mes "ではないか！";
		mes "おお……";
		next;
		mes "[イクルラ]";
		mes "遠い異国の地でも";
		mes "それの噂を耳にしたことがある……";
		mes "伝説のアイテムをこんな";
		mes "近くで見られるとは……";
		next;
		mes "[イクルラ]";
		mes "君はいったい何者だい？";
		next;
		switch(select("……(印を見せる)","天才","あなたが知っている人")) {
		case 1:
			mes "[イクルラ]";
			mes "……私の目を疑わざるを得ないね";
			mes "少数の選ばれた者だけが持つことが";
			mes "出来るという、その印を……";
			mes "うん、うん、うん。";
			next;
			mes "[イクルラ]";
			mes "うん、そうだな。";
			mes "どうやら君はその印について";
			mes "あまり理解していないようだ。";
			next;
			mes "[イクルラ]";
			mes "君が今まで追って来た";
			mes "^3152FF魔剣^000000に関する";
			mes "言葉がジュノーに存在する。";
			next;
			mes "[イクルラ]";
			mes "- 霧の向こう、光が一つ -";
			mes "- 走っても走っても -";
			mes "- 届かない -";
			mes "- 握っても握っても -";
			mes "- つかめない -";
			mes "- 谷間の向こう、光が一つ -";
			next;
			mes "[イクルラ]";
			mes "昔の賢者達が残した、魔剣を";
			mes "手に入れるのがどれだけ大変かを";
			mes "詠ったものらしい。";
			mes "……………";
			next;
			mes "[イクルラ]";
			mes "少し、時間をあげよう。";
			mes "良く考えて、魔剣に対する未練を";
			mes "捨てることができなかったのなら";
			mes "再び私に会いに来なさい。";
			next;
			mes "[イクルラ]";
			mes "君はミョルニールの印を所持した者。";
			mes "大賢者から受け継いできた役目……";
			mes "印を持つ者を導く義務が、私にある！";
			set MJO_2QUE,2;
			set MJO_1QUE,24;	//コモド編の後始末
			close;
		case 2:
			mes "[イクルラ]";
			mes "……私の耳を疑わざるを得ないね。";
			mes "賢者の都市で天才と名乗るなんて";
			mes "見上げた精神だ。";
			next;
			mes "[イクルラ]";
			mes "………感心しませんね。";
			mes "私は少々考えることがありますから";
			mes "一人にしてください。";
			mes "……………";
			close;
		case 3:
			mes "[イクルラ]";
			mes "……私の記憶を疑わざるを得ないね。";
			mes "私は、一度見た顔は忘れるはずなど";
			mes "ないんだが……";
			mes "…………………";
			next;
			mes "[イクルラ]";
			mes "もしかして……";
			mes "プロンテラの酒場で";
			mes "ご一緒した方かな。";
			next;
			mes "[イクルラ]";
			mes "そうだったら、あの時の論争を";
			mes "今ここで続けるつもりかな？";
			mes "だとしたら、私の答えはこうだ。";
			next;
			mes "- 私はあなたが好きではないので -";
			mes "- これ以上対話を試みなかった -";
			close;
		}
	case 2:
	case 3:
		if(MJO_2QUE == 2 || countitem(7030) < 3 || countitem(913) < 10 || countitem(7032) < 1) {
			mes "[イクルラ]";
			mes "………………";
			mes "答えは、出たかい？";
			mes "魔剣に対するすべてを教えよう。";
			next;
			mes "[イクルラ]";
			mes "この賢者の都市ジュノーでは";
			mes "昔から魔剣に対する言葉が";
			mes "暗に受け継がれて来ている。";
			next;
			mes "[イクルラ]";
			mes "^3152FF- 真っ直ぐな心を持った者 -";
			mes "- 光の柱を指し示そう -";
			mes "- 繁栄のミネタ -";
			mes "- 知識のスノトラ -";
			mes "- そして光宮のソロモンよ -";
			next;
			mes "- 真実を導くが定め -";
			mes "- 三賢者が指し示そう -^000000";
			next;
			mes "[イクルラ]";
			mes "君は、このジュノーについて";
			mes "どれだけのことを知っているのかな？";
			next;
			mes "[イクルラ]";
			mes "ジュノーは繁栄の島、知識の島、";
			mes "光宮の島と呼ばれる";
			mes "三つの島から成り立っている。";
			next;
			mes "[イクルラ]";
			mes "三賢者とは、それぞれの島を";
			mes "代表する賢者だ。";
			mes "ジュノーではずいぶん前から";
			mes "優秀な賢者達の中から三人を選び、";
			mes "島に一人ずつ置くようにしてきた。";
			next;
			mes "[イクルラ]";
			mes "そして、私を含み、残り二人の二賢者は";
			mes "大賢者様からさまざまな知識を";
			mes "受け継いできた。その中の、";
			mes "魔剣に係わるものがこれだと思う。";
			next;
			mes "[イクルラ]";
			mes "^3152FF- 賢者は指で -";
			mes "- 銅像の柱を示した -";
			mes "- その所にはわからない -";
			mes "- 意味に陰刻文様が -";
			mes "- 刻まれていた -^000000";
			next;
			mes "[イクルラ]";
			mes "見なさい……";
			mes "あの銅像は三賢者を称えるために";
			mes "作られたとばかり思っていたんだが……";
			mes "柱の下の方を見ると、小さい穴が";
			mes "いくつか開いているのが分かるだろう。";
			next;
			mes "[イクルラ]";
			mes "この穴に、なにかアイテムをはめ込むと";
			mes "魔剣に関係する何かが";
			mes "起きるらしいという話だ。";
			next;
			mes "[イクルラ]";
			mes "大賢者様から聞き得、推理した結果、";
			mes "次のようなアイテムを";
			mes "穴に入れるのではないかという";
			mes "事に突き当たった……";
			next;
			mes "[イクルラ]";
			mes "^3152FF「砂漠狼の爪」";
			mes "「こうもりの牙」";
			mes "「割れた卵のかけら」^000000";
			next;
			mes "[イクルラ]";
			mes "穴を良くみると、深みが違うのが";
			mes "わかるかい？それは、それぞれの穴に";
			mes "入れる数を示しているらしい。";
			mes "砂漠狼の爪は ^FF31523個^000000";
			mes "こうもりの牙は ^FF315210個^000000";
			mes "割れた卵のかけらは ^FF31521個^000000";
			next;
			mes "[イクルラ]";
			mes "これらのアイテムを集めてきなさい。";
			mes "砂漠狼はモロク近辺に。";
			mes "コウモリは世界あちこちの洞窟に。";
			mes "割れた卵のかけらはフェイヨン洞窟に";
			mes "棲息する、硬い卵のモンスターから";
			mes "得られると聞いている。";
			if(MJO_2QUE == 2)
				set MJO_2QUE,3;
			close;
		}
		delitem 7030,3;
		delitem 913,10;
		delitem 7032,1;
		mes "[イクルラ]";
		mes "さぁ、集めてきた材料を";
		mes "その穴に入れてみなさい。";
		mes "理論上は正しいはずだが";
		mes "実際に行ってみるのは初めてなので……";
		mes "ワクワクしますね。";
		next;
		mes "- あなたは…… -";
		mes "- 集めてきたアイテムを -";
		mes "- 穴に入れた -";
		next;
		mes "- ゴットン ガッコン -";
		mes "- ドッタン ガッタン -";
		mes "- 銅像内部で -";
		mes "- 妙な音が聞こえる -";
		next;
		mes "- ウィ〜ン、ウィ〜ン -";
		mes "- がちゃん -";
		next;
		mes "- 銅像の先端部に開かれた -";
		mes "- やや小さい穴から -";
		mes "- ^3152FF` ミョルニールの欠片 '^000000 -";
		mes "- が出てきた！ -";
		next;
		mes "- あなたは…… -";
		mes "- ^3152FFミョルニールの欠片^000000 -";
		mes "- を手に入れた！ -";
		next;
		mes "[イクルラ]";
		mes "やや！";
		mes "その欠片は印にはめ込むことが";
		mes "出来るはずだ。";
		mes "試してみなさい！";
		next;
		mes "- あなたは -";
		mes "- ミョルニールの欠片を -";
		mes "- ミョルニールの印に -";
		mes "- はめ込んだ！ -";
		next;
		mes "- ^3152FF真のミョルニールの印^000000 -";
		mes "- を手に入れた！ -";
		set MJO_2QUE,4;
		next;
		mes "[イクルラ]";
		mes "その印は!!";
		mes "うん、そうか……そうだったのか。";
		mes "いいかい。その印を持って";
		mes "「知識の島スノトラ」へ行きなさい。";
		next;
		mes "[イクルラ]";
		mes "スノトラの島の、スノトラ女神の銅像が";
		mes "ある辺りに行くと、";
		mes "ジュノー三賢者の一人、";
		mes "「シクルラ」賢者が見つかるはずだ。";
		mes "彼にその印を見せなさい。";
		next;
		mes "[イクルラ]";
		mes "それでは君の未来に";
		mes "幸運の光があらんことを……";
		close;
	case 4:
		mes "[イクルラ]";
		mes "その印……";
		mes "いいかい。その印を持って";
		mes "「知識の島スノトラ」へ行きなさい。";
		next;
		mes "[イクルラ]";
		mes "スノトラの島の、スノトラ女神の銅像が";
		mes "ある辺りに行くと、";
		mes "ジュノー三賢者の一人、";
		mes "「シクルラ」賢者が見つかるはずだ。";
		mes "彼にその印を見せなさい。";
		next;
		mes "[イクルラ]";
		mes "それでは君の未来に";
		mes "幸運の光があらんことを……";
		close;
	}
}

yuno.gat,305,207,4	script	賢者シクルラ	735,{
	switch(MJO_2QUE) {
	default:
		mes "[シクルラ]";
		mes "賢者の都市ジュノーのどこかに";
		mes "ずいぶんと前から、珍妙な研究をして";
		mes "周辺に迷惑をかける人物が";
		mes "いるらしいのです。";
		next;
		mes "[シクルラ]";
		mes "「マッドサイエンティスト」と";
		mes "呼ばれる彼は、一般人には";
		mes "理解することの出来ない";
		mes "奇妙な研究に、熱心に取り組んでいる";
		mes "らしいのです。";
		next;
		mes "[シクルラ]";
		mes "ジュノー周辺でよく見られると言う";
		mes "「ブレイザー」と言うモンスターを";
		mes "ご存知かしら？火炎の球の形をしていて";
		mes "ファイアーボルトやファイアーボール";
		mes "などの恐ろしい魔法を使って、";
		mes "人間を見れば即座に飛び掛ってくる……";
		next;
		mes "[シクルラ]";
		mes "そやつは、その";
		mes "マッドサイエンティストが";
		mes "生み出したのではないかと";
		mes "巷では囁かれておる……";
		close;
	case 4:
		mes "[シクルラ]";
		mes "………………";
		mes "おや、その印は……";
		mes "それはミョルニールの印かしら……";
		mes "………………";
		next;
		mes "[シクルラ]";
		mes "貴方、私が何かしてくれるのを";
		mes "待っているような目をしていること。";
		mes "………………";
		mes "ブホホホホホホ";
		next;
		mes "[シクルラ]";
		mes "プフフ、変な顔をするでない。";
		mes "冗談じゃ、冗談。";
		mes "三賢者が一人「イクルラ」から";
		mes "話は聞いておりますよ。";
		next;
		mes "[シクルラ]";
		mes "ミョルニールの印は";
		mes "持ち主を選びおる。";
		mes "しかし、珍しい……";
		mes "私達三賢者でさえ、";
		mes "真の印を見るのは初めて……";
		next;
		mes "[シクルラ]";
		mes "イクルラから話は聞いております。";
		mes "ミョルニールの印にある文様ですが";
		mes "私が管理しておる";
		mes "^3152FF「スノトラ女神像」^000000";
		mes "にも見られる。";
		mes "貴方も、自分の目で見てみなさい。";
		next;
		mes "- あなたはスノトラ女神像の -";
		mes "- 柱に刻まれている文様が -";
		mes "- 真のミョルニールの印の文様と -";
		mes "- 一致することを確認した。 -";
		next;
		mes "[シクルラ]";
		mes "ここで、思い当たることがあります。";
		mes "私が若かった時、大賢者から";
		mes "特別な朱肉、すなわち";
		mes "はんこを押す時につけるインクについて";
		mes "教わったことがあります。";
		next;
		mes "[シクルラ]";
		mes "ミョルニールの印と、直接関係があると";
		mes "聞いたわけではないのですが……";
		next;
		mes "[シクルラ]";
		mes "この朱肉を作る方法ですが、";
		mes "かなり難しいものでして。";
		mes "一度も作ってみたことはないですが……";
		mes "貴方が材料を集めてきてくれたなら";
		mes "作ってみましょう。";
		next;
		mes "[シクルラ]";
		mes "プホホ……その顔は";
		mes "「ここまで来たのに、何でまた」";
		mes "「どこかに行かされるんだ。」";
		mes "「やることが増えるばかりだ。」";
		mes "とでも思っておるのでしょう。";
		mes "ま、覚悟するのですね。プホホ。";
		next;
		mes "[シクルラ]";
		mes "それでは次の物を集め、";
		mes "私に持ってくれるように。";
		next;
		mes "[シクルラ]";
		mes "赤い色を出すのに必要な";
		mes "^3152FF「赤ハーブ 20個」^000000";
		mes "朱肉の本体を作るのに必要な";
		mes "^3152FF「石 5個」";
		mes "「岩の心臓 1個」^000000";
		next;
		mes "[シクルラ]";
		mes "物によっては、求めるのが難しいやも";
		mes "しれませんが、貴方ならすぐに集めてく";
		mes "る";
		mes "そんな予感がします。それでは、幸運を";
		mes "！";
		mes "プホホホホ";
		set MJO_2QUE,5;
		close;
	case 5:
		if(countitem(507) < 20 || countitem(7049) < 5 || countitem(953) < 1) {
			mes "[シクルラ]";
			mes "それでは次の物を集め、";
			mes "私に持ってくれるように。";
			next;
			mes "[シクルラ]";
			mes "赤い色を出すのに必要な";
			mes "^3152FF「赤ハーブ 20個」^000000";
			mes "朱肉の本体を作るのに必要な";
			mes "^3152FF「石 5個」";
			mes "「岩の心臓 1個」^000000";
			mes "以上。";
			close;
		}
		delitem 507,20;
		delitem 7049,5;
		delitem 953,1;
		mes "[シクルラ]";
		mes "プホホ、やはり貴方にとって";
		mes "これらを集めるのは、さほど";
		mes "難しくなかったようですね。";
		mes "プホホ　プホホ　それでは……";
		next;
		mes "[シクルラ]";
		mes "………………";
		mes "朱肉を作るのにそれほど時間は";
		mes "かからないでしょう。";
		mes "すぐ完成するはずです。";
		mes "待っていなさい。";
		next;
		mes "- 賢者シクルラは -";
		mes "- 石と岩の心臓を砕いて -";
		mes "- 模様を描いた後 -";
		mes "- 赤いハーブをその上に置いた -";
		next;
		mes "- 賢者シクルラは -";
		mes "- 懐より、妙な入れ物を取り出し -";
		mes "- その中の液体を振り撒くと -";
		mes "- 呪文を覚え始めた -";
		next;
		mes "- おぉ……………… -";
		mes "- ダンダダダダン タダダンダン！ -";
		mes "- ダンダダダダンダダンダ！ -";
		mes "- ミョルニールの別荘へ…… -";
		mes "- 道を示せ！運べ！導け！ -";
		mes "- スォオオオォオオー!! -";
		next;
		mes "- ^3152FF「ミョルニールの朱肉」^000000 -";
		mes "- が完成した！ -";
		mes "- 賢者シクルラから -";
		mes "- ^3152FF「ミョルニールの朱肉」^000000 -";
		mes "- を受け取った！ -";
		set MJO_2QUE,6;
		next;
		mes "[シクルラ]";
		mes "さぁ、これでミョルニールの印を";
		mes "使うことが出来るようになったはず。";
		mes "伝説のアイテムである故、";
		mes "どこでも使えるものではないと";
		mes "思うのだが……";
		next;
		mes "[シクルラ]";
		mes "印の使い道について、貴方に";
		mes "助言してくれるはずの人物がいます。";
		mes "すでに貴方にも予想は出来ている";
		mes "ことでしょう。";
		next;
		mes "[シクルラ]";
		mes "三賢者が一人「光宮の島ソロモン」の";
		mes "賢者^3152FF「エスクラ」^000000に会うがよろしい。";
		mes "三賢者の中で一番気難しい故、";
		mes "心して行きなさい。";
		close;
	case 6:
		mes "[シクルラ]";
		mes "印の使い道について、貴方に";
		mes "助言してくれるはずの人物がいます。";
		mes "すでに貴方にも予想は出来ている";
		mes "ことでしょう。";
		next;
		mes "[シクルラ]";
		mes "三賢者が一人「光宮の島ソロモン」の";
		mes "賢者^3152FF「エスクラ」^000000に会うがよろしい。";
		mes "三賢者の中で一番気難しい故、";
		mes "心して行きなさい。";
		close;
	}
}

yuno.gat,213,298,4	script	賢者エスクラ	735,{
	switch(MJO_2QUE) {
	default:
		mes "[エスクラ]";
		mes "いつか見たことがあるんだ。";
		mes "ひらひらした紙が風に飛ばされててね。";
		mes "風に飛ばされてしまった書類で、";
		mes "誰も取れないでいるのかな〜と";
		mes "思っていたら";
		next;
		mes "[エスクラ]";
		mes "プハハッ！";
		mes "不意に攻撃してきたんだよ！";
		mes "よりによって、ジュノーの";
		mes "三賢者の一人である、この僕をね！";
		next;
		mes "[エスクラ]";
		mes "セージ出身である僕が、たかが";
		mes "紙切れ一枚に本気で相手をして";
		mes "やることもないと思って、";
		mes "剣で対面してやったんだが……";
		mes "紙やつ……小癪でね。";
		mes "身体が薄いのを利用して";
		next;
		mes "[エスクラ]";
		mes "刃ぎりぎりで剣をかわしたり、";
		mes "ひらりと身をかわしたりする";
		mes "戦術を心得ていてさ。";
		mes "それに切れたは切れたんだけど、";
		mes "なんていうか、手ごたえが";
		mes "ほとんど感じられなくってさ。";
		next;
		mes "[エスクラ]";
		mes "結局我慢できなくて魔法で";
		mes "倒しちゃったけどね。";
		mes "なかなか強いモンスターだった。";
		next;
		mes "[エスクラ]";
		mes "後で他の賢者たちに";
		mes "聞いてみたら、そいつの名前は";
		mes "^3152FF「一反木綿」^000000と言って、ジュノーの";
		mes "長年の知恵を記された古書から";
		mes "抜け出した紙のモンスターなんだって。";
		mes "変なこともあるもんだね……";
		close;
	case 6:
		mes "[エスクラ]";
		mes "ふーん。貴様が三賢者中二賢者が";
		mes "認めたっていう、ミョルニールの印を";
		mes "手に入れた奴か。フンッ。";
		next;
		mes "[エスクラ]";
		mes "つまらない顔なのに。";
		mes "その程度の顔で伝説のアイテムを";
		mes "手に入れたなんて、なまいきだね！";
		mes "フンッ。";
		next;
		mes "[エスクラ]";
		mes "^3152FF「ミョルニールの印」^000000は";
		mes "言葉通り選ばれた者だけに与えられる";
		mes "苦行の結晶体！";
		mes "そういう訳で、君の血と汗と涙は";
		mes "最後の一滴まで絞りだしてみせるよ!!";
		next;
		mes "[エスクラ]";
		mes "- ニヤリ -";
		mes "ミョルニールの印を";
		mes "完成させる最後の難関はこれからだ！";
		next;
		mes "[エスクラ]";
		mes "いいかい。それじゃ、これから";
		mes "^3152FF「ミョルニール」^000000と言う";
		mes "はんこ職人について話してやろう。";
		next;
		mes "[エスクラ]";
		mes "遥か昔、ミョルニール山脈のどこかに";
		mes "様々な模様の探求と創作に情熱をかけ";
		mes "一切人との接触を拒み、一人黙々と";
		mes "修行をしていた者があった。";
		mes "そいつの名前がミョルニールだ。";
		next;
		mes "[エスクラ]";
		mes "長い長い間……美しい柄、";
		mes "美しい模様を研究していた彼は";
		mes "ある日、他の次元へと連結出来る";
		mes "魔法を発見したんだ。";
		next;
		mes "[エスクラ]";
		mes "それは高等魔法師や賢者達が使う";
		mes "魔法陣とは、また少し違った";
		mes "ものだった……なんとそれは、";
		mes "「魔界の物体」を召還する模様";	//召喚じゃないのは本鯖仕様
		mes "だったんだ！";
		next;
		mes "[エスクラ]";
		mes "魔界の物体を召還するには緻密な計算…";
		mes "すなわち召還陣に対する精密度が";
		mes "要求されるが……場所によって";
		mes "正確度が変わるとも言われている。";
		next;
		mes "[エスクラ]";
		mes "ミョルニールは長い歳月の末";
		mes "その重要な地点を探しあてた。";
		mes "^3152FF「ミョルニールの別荘」^000000";
		mes "と呼ばれるその場所に行きたいなら";
		mes "^3152FF「ミョルニールの羅針盤」^000000";
		mes "が必要さ。";
		next;
		mes "[エスクラ]";
		mes "気付いたかな……";
		mes "まさに！俺がその";
		mes "ミョルニールの羅針盤を";
		mes "作ることの出来る唯一の人物！";
		next;
		mes "[エスクラ]";
		mes "ふん。その顔。";
		mes "言わなくても、顔に書いてあるよ。";
		mes "「ミョルニールの羅針盤」を";
		mes "作るのに、また複雑なクエストが";
		mes "待っているんだなぁーって";
		mes "思っているのだろう？";
		next;
		mes "[エスクラ]";
		mes "魔剣一つのために";
		mes "何故こんなに複雑なことをしなければ";
		mes "いけないんだろう。";
		next;
		mes "[エスクラ]";
		mes "長くてうんざりするクエストに";
		mes "イライラし始めて来てる頃かな〜。";
		mes "ツッツッツッツッツッ";
		mes "甘いね〜!!";
		next;
		mes "[エスクラ]";
		mes "魔剣が子供のおもちゃだとでも";
		mes "思ってるのかい？";
		mes "世界で数少ない、ごく一握りの";
		mes "選ばれた者だけが所有できる「魔剣」を";
		mes "平凡なお前が触るなんて夢見るだけでも";
		mes "とてつもなく恵まれてると思わなきゃ！";
		next;
		mes "[エスクラ]";
		mes "一度だけ話してあげるから";
		mes "よく聞いてるんだね。";
		mes "^3152FF「ミョルニールの羅針盤」^000000";
		mes "を製作するのに必要な";
		mes "アイテムとは……";
		next;
		mes "[エスクラ]";
		mes "^3152FF鉄鉱石 2個";
		mes "どんぐり 10個";
		mes "亡者の爪 5個^000000";
		next;
		mes "[エスクラ]";
		mes "どう？ クソ生意気だって噂が立った";
		mes "この大賢者様の注文としては";
		mes "思ってたより簡単そうだろう？";
		mes "さぁ！行って来な！";
		mes "何をボサァ〜っとしてるんだよ！";
		mes "さっさと行って来いったら！";
		set MJO_2QUE,7;
		close;
	case 7:
		if(countitem(1002) < 2 || countitem(1026) < 10 || countitem(957) < 5) {
			mes "[エスクラ]";
			mes "一度だけ話してあげるから";
			mes "よく聞いてるんだね。";
			mes "^3152FF「ミョルニールの羅針盤」^000000";
			mes "を製作するのに必要な";
			mes "アイテムとは……";
			next;
			mes "[エスクラ]";
			mes "^3152FF鉄鉱石 2個";
			mes "どんぐり 10個";
			mes "亡者の爪 5個^000000";
			close;
		}
		delitem 1002,2;
		delitem 1026,10;
		delitem 957,5;
		mes "[エスクラ]";
		mes "どれどれ、見せてみろ。";
		mes "鉄鉱石 2個";
		mes "どんぐり 10個";
		mes "亡者の爪 5個……";
		mes "よし、受け取ったぞ。";
		next;
		mes "[エスクラ]";
		mes "いちおう、魔剣を追って";
		mes "海千山千経験したらしいね。";
		mes "そこそこ早く、集めてきたもんだ。";
		mes "さぁ、これで羅針盤の本体を作るから";
		mes "その間に、次の材料を集めてきな！";
		next;
		mes "[エスクラ]";
		mes "………………クック";
		mes "ウハッハ！またそんな表情を。";
		mes "さぁさぁ、また行って来〜い来い！";
		next;
		mes "[エスクラ]";
		mes "^3152FFブリガン 2個";
		mes "プラコン 1個^000000";
		mes "簡単だね！";
		mes "ハッハッハッハッハ";
		mes "ウッヘッヘッ";
		set MJO_2QUE,8;
		close;
	case 8:
		if(countitem(7054) < 2 || countitem(1010) < 1) {
			mes "[エスクラ]";
			mes "行って来い〜行って来い〜";
			mes "^3152FFブリガン 2個";
			mes "プラコン 1個^000000";
			mes "簡単だね！";
			mes "ハッハッハッハッハ";
			mes "ウッヘッヘッ";
			close;
		}
		delitem 7054,2;
		delitem 1010,1;
		mes "[エスクラ]";
		mes "ほら、さっさと渡しな。";
		mes "ブリガン 2個に……";
		mes "プラコンが1個と……";
		mes "OK OK";
		mes "これからこれを砕いて";
		mes "こことここにばら撒いて。";
		next;
		mes "[エスクラ]";
		mes "こっちをこうして";
		mes "あっちをああして";
		mes "えっこら よっこら どっこいしょっと";
		next;
		mes "- 賢者エスクラは -";
		mes "- ^3152FF「ミョルニールの羅針盤」^000000を -";
		mes "- 完成させた！ -";
		mes "- あなたは -";
		mes "- ^3152FF「ミョルニールの羅針盤」^000000を -";
		mes "- 手に入れた！ -";
		set MJO_2QUE,9;
		next;
		mes "- 羅針盤が示す方向に -";
		mes "- 次のような文字が刻まれている -";
		mes "^3152FF- ミョルニール山脈 -";
		mes "- mjolnir_02 170 193 -^000000";
		next;
		mes "[エスクラ]";
		mes "羅針盤の針を良く見ろ。";
		mes "その示す方角に、君の";
		mes "求めるものがあるはずだ！";
		mes "行くがいい！";
		mes "そして、君の未来に";
		mes "幸運の光があらんことを……";
		close;
	case 9:
		mes "- あなたは…… -";
		mes "- 「ミョルニールの羅針盤」を -";
		mes "- 覗き込んだ -";
		next;
		mes "- 羅針盤が示す方向に -";
		mes "- 次のような文字が刻まれている -";
		mes "^3152FF- ミョルニール山脈 -";
		mes "- mjolnir_02 170 193 -^000000";
		close;
	}
}

mjolnir_02.gat,170,193,0	script	ミョルニールの別荘	111,{
	switch(MJO_2QUE) {
	default:
		mes "- 「ミョルニールの別荘」 -";
		mes "- 家の中と外に -";
		mes "- 誰のだか分からない -";
		mes "- 人の名前が -";
		mes "- 書かれている -";
		close;
	case 9:
		mes "- 木で出来た小屋の床に -";
		mes "- ミョルニールの文様が -";
		mes "- 数個置かれている -";
		next;
		mes "- あなたは -";
		mes "^3152FF- 「真のミョルニールの印」^000000と -";
		mes "^3152FF- 「ミョルニールの朱肉」^000000を -";
		mes "- 文様に一致するように押してみた -";
		next;
		mes "^3152FF- ズゥゥゥゥゥウウン…… -^000000";
		next;
		mes "- どこからか、途切れ途切れに -";
		mes "- 人の声が聞こえてきた…… -";
		next;
		mes "[ミョルニールの話]";
		mes "- ズゥウウウン…… -";
		mes "未来の人物よ……私は過去の人間";
		mes "ミョルニール……";
		mes "多くの難関を経て、この険しい";
		mes "ミョルニール山脈まで来れたこと";
		mes "感謝します……";
		next;
		mes "[ミョルニールの話]";
		mes "魔剣とは、おびただしい力を持つもの。";
		mes "主人の力量と裁量を試さなくては……";
		mes "むやみに渡してはいけないと";
		mes "思ったんです……";
		next;
		mes "[ミョルニールの話]";
		mes "私はその時から、ジュノーの";
		mes "大賢者様たちと意見を分かち、";
		mes "さまざまな魔法と装置を研究して";
		mes "後世にまで私の魂を残し……";
		mes "話を伝えられるよう努力しました。";
		next;
		mes "[ミョルニールの話]";
		mes "あなたがこの話を";
		mes "聞くことができているなら……";
		mes " ";
		mes "私の努力が";
		mes "実を結んだと言うことですね";
		mes "………………";
		next;
		mes "[ミョルニールの話]";
		mes "君が何を願っているのか、";
		mes "分かっています。";
		mes "魔剣……それは私達の人間にとって";
		mes "あまりにも巨大な力……";
		mes "悪しき者が手に入れてしまえば";
		mes "とてつもなく深刻な問題です。";
		next;
		mes "[ミョルニールの話]";
		mes "未来の貴方から見れば……";
		mes "私の話は、おろかなものと";
		mes "聞こえているかも知れませんね……";
		mes "フフッ…………";
		next;
		mes "[ミョルニールの話]";
		mes "急ぎなさい……………";
		next;
		mes "[ミョルニールの話]";
		mes "試練を受けるのならば";
		mes "広い世界の空の下、";
		mes "蒸し暑い日々が去り";
		mes "落ち葉が舞い始め";
		mes "涼しい風が吹く";
		mes "その時を待ちなさい。";
		next;
		mes "[ミョルニールの話]";
		mes "あぁ……私の話はこれで終わりました。";
		mes "時が訪れるまで、話を聞いてくれた証を";
		mes "与え、今日は終わりとしましょう……";
		next;
		mes "[ミョルニールの話]";
		mes "忘れないで……風が吹き、落ち葉が舞う";
		mes "その時……再びこの場所を";
		mes "訪ねなさい……";
		mes "その時まで…さらば……";
		next;
		mes "- バアァッ!! -";
		mes "- カッシャーーン…… -";
		next;
		mes "- ミョルニールの印と朱肉 -";
		mes "- そして羅針盤が割れると -";
		mes "- その欠片の中から -";
		mes "- 小さな物がきらめいて現れた -";
		next;
		mes "- あなたは -";
		mes "- ^3152FF「試練の証」^000000 -";
		mes "- を手に入れた！ -";
		set MJO_2QUE,10;
		close;
	case 10:	//この続きは未実装
		mes "- どこからか、途切れ途切れに -";
		mes "- 人の声が聞こえてきた…… -";
		next;
		mes "[ミョルニールの話]";
		mes "忘れないで……風が吹き、落ち葉が舞う";
		mes "その時……再びこの場所を";
		mes "訪ねなさい……";
		mes "その時まで…さらば……";
		close;
	}
}
