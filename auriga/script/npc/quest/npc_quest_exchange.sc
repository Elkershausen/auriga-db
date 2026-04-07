// 2026/04/07 アイテムエクスチェンジ 更新

//商人
-	script	NoviceExchange	-1,{
	if(Weight*100/MaxWeight >= 90) {
		mes "[商人]";
		mes "おいおい！";
		mes "怪力じゃないくせに";
		mes "何でそんなに持ち歩いてるんだ？";
		mes "カプラの倉庫にでも預けてこい。";
		close;
	}
	set '@code,strnpcinfo(5);	//識別子の#以降の文字列を参照して数値に変換
	switch('@code) {
		case 0:	//prontera
			setarray '@need,935,914,909;	//かたい皮、綿毛、ゼロピー
			setarray '@amount,5,10,10;	
			break;
		case 1:	//geffen
			setarray '@need,935,915,909;	//かたい皮、さなぎの皮、ゼロピー
			setarray '@amount,5,6,10;
			break;
		case 2:	//morocc
			setarray '@need,935,916,909;	//かたい皮、鳥の羽毛、ゼロピー
			setarray '@amount,5,7,10;
			break;
		case 3:	//aldebaran
			setarray '@need,955,916,909;	//蟲の皮、鳥の羽毛、ゼロピー
			setarray '@amount,1,7,10;
			break;
		case 4:	//payon
			setarray '@need,902,909;	//木の根、ゼロピー、0
			setarray '@amount,6,10;
			break;
	}
	mes "[商人]";
	mes "こんにちは！";
	mes "あのさ「" +getitemname('@need[0])+ "」や「" +getitemname('@need[1])+ "」";
	mes "というアイテムを持ってないか？";
	if('@code < 4)
		mes "あ、「ゼロピー」でもいいぞ。";
	mes "もし持ってたら、俺に少し";
	mes "分けてくれないか。";
	next;
	mes "[商人]";
	mes "もちろん、ただでもらおうなんて";
	mes "わけじゃない。そうだな……";
	mes "「" +getitemname('@need[0]) + '@amount[0]+ "個」か「" +getitemname('@need[1]) + '@amount[1]+ "個」";
	if('@code < 4)
		mes "または「ゼロピー10個」と";
	mes "「赤ポーション1個」を";
	mes "交換するのはどうだ？";
	next;
	switch (select("いいですよ！","何か損してる気が……","嫌です！")) {
	case 1:
		mes "[商人]";
		mes "「" +getitemname('@need[0])+ "」か「" +getitemname('@need[1])+ "」";
		if('@code < 4)
			mes "もしくは「ゼロピー」。";
		mes "さあ、どれと交換するんだ？";
		next;
		if('@code<4)
			set '@talk$,"「ゼロピー」を「赤ポーション」に";
		//payonの時は3番目の選択肢出ない
		set '@i,select("「"+getitemname('@need[0])+"」を「赤ポーション」に","「"+getitemname('@need[1])+"」を「赤ポーション」に",'@talk$,"やめておきます")-1;
		if('@i==3) {
			mes "[商人]";
			mes "そうか……";
			mes "まあ、気が向いたらまた来な。";
			close;
		}
		set '@have,countitem('@need['@i]);	//交換アイテム所持数
		if('@have < '@amount['@i]) {
			mes "[商人]";
			if('@code < 4 || '@i > 0)		//フェイヨンで木の根を選んだ場合は表示されない。(他の地域は未調査)
				mes "おい！";
			mes getitemname('@need['@i])+ "はどこにあるんだ？";
			mes "いくらなんでも" +getitemname('@need['@i])+ "が" +'@amount['@i]+ "個ないと";
			mes "赤ポーションは渡せないぞ。";
			close;
		}
		mes "[商人]";
		mes "ありがてぇ！";
		mes "それじゃ、何個交換しようか？";
		mes "ちょいと見せてみな。";
		next;
		set '@max,'@have / '@amount['@i];	//交換可能数
		mes "[商人]";
		mes getitemname('@need['@i])+ "は" +'@have+ "個";
		mes "あるのか……そうすると";
		mes "赤ポーションは" +'@max+ "個まで";
		mes "交換できるぞ。";
		next;
		mes "[商人]";
		mes getitemname('@need['@i])+ "を赤ポーションと交換するか？";
		next;
		if(select("交換します","やっぱりやめておきます")==2) {
			mes "[商人]";
			mes "……仕方ねぇな。";
			mes "また、気が向いたら来てくれよ。";
			close;
		}
		mes "[商人]";
		mes "赤ポーションは最大何個もらえるかは";
		mes "さっき教えたから、わかってるな？";
		next;
		mes "[商人]";
		mes "一度に交換できる赤ポーションの数は";
		mes "最小は1個、最大は100個だ。";
		mes "もし交換する気がないなら「0」と";
		mes "言ってくれ。";
		while(1) {
			next;
			input '@val;
			if('@val<0 || '@val>100) {
				mes "[商人]";
				mes "一度に交換できるのは";
				mes "100個までだって言っただろ！";
				mes "仕方ねぇな、もう一回聞いてやる。";
				mes "何個にするんだ？";
				continue;
			}
			break;
		}
		if('@val == 0) {
			mes "[商人]";
			mes "おいおい、そりゃないだろ。";
			mes "期待させるだけさせておいて……";
			mes "仕方ねぇな。気が向いたら";
			mes "また来てくれよ。";
			close;
		}
		if('@val > '@max) {
			mes "[商人]";
			mes "おい！それじゃあ、" +getitemname('@need['@i])+ "が";
			mes "足りないだろ？赤ポーションが";
			mes "何個まで交換できるか、きちんと";
			mes "確認してから来いよ。";
			close;
		}
		delitem '@need['@i],'@amount['@i]*'@val;
		getitem 501,'@val;
		mes "[商人]";
		mes "おし！これが赤ポーションだ。";
		mes "確認してくれ。ありがとよ。";
		mes "がははー！";
		close;
	case 2:
		mes "[商人]";
		mes "損してるかもだって？がははー。";
		mes "全然そんなことはないはずだぞ。";
		mes "どちらかと言えば、俺の方が";
		mes "損になる。まぁ、俺の条件が";
		mes "気にくわないなら仕方ないが。";
		close;
	case 3:
		mes "[商人]";
		mes "……チッ。仕方ねぇな。";
		mes "また気が向いたら来てくれよ。";
		close;
	}
}

prontera.gat,123,102,5	duplicate(NoviceExchange)	商人::NoviceExchange#0	85
geffen.gat,173,88,5	duplicate(NoviceExchange)	商人::NoviceExchange#1	85
morocc.gat,180,259,3	duplicate(NoviceExchange)	商人::NoviceExchange#2	85
aldebaran.gat,152,63,5	duplicate(NoviceExchange)	商人::NoviceExchange#3	85
payon.gat,200,134,5	duplicate(NoviceExchange)	商人::NoviceExchange#4	85


//ペリックス
//  ■ @change_jellopy

alberta.gat,190,173,3	script	ペリックス	85,{
	if(@change_jellopy == 0) {
		mes "[ペリックス]";
		mes "なんだ、俺に何か用か？";
		mes "いくら物欲しそうな顔したって";
		mes "何もやらんぞ。";
		next;
		mes "[ペリックス]";
		mes "何か欲しいなら仕事をしろ、仕事を！";
		mes "ん？仕事がないだって？";
		mes "仕方ねぇな……";
		next;
		mes "[ペリックス]";
		mes "じゃあ、ゼロピーを10個集めてこい。";
		mes "きちんと集めてきたらその報酬として";
		mes "赤ポーションをやろう。";
		next;
		mes "[ペリックス]";
		mes "10個がきついなら、3個でもいいぞ。";
		mes "ゼロピーを3個集めてきたら";
		mes "いもをやろう。";
		next;
		mes "[ペリックス]";
		mes "ゼロピーを手に入れたら";
		mes "またここに来な。";
		if(countitem(909))
			set @change_jellopy,1;
		close;
	}
	mes "[ペリックス]";
	mes "おお、ゼロピーを集めてきたのか。";
	mes "よし！赤ポーションかいも";
	mes "どっちと交換するんだ？";
	next;
	switch (select("赤ポーションをください","いもをください")) {
		case 1:
			set '@amount,10;
			set '@gain,501;
			break;
		case 2:
			set '@amount,3;
			set '@gain,516;
			break;
	}
	mes "[ペリックス]";
	mes "わかった。じゃあ、持ってきた物を";
	mes "見せてくれ。";
	next;
	if(countitem(909) < '@amount) {
		mes "[ペリックス]";
		mes "おい！" +getitemname('@gain)+ "が欲しかったら";
		mes "ゼロピーを" +'@amount+ "個集めてこいと";
		mes "言っただろ？";
		close;
	}
	set '@max,countitem(909) / '@amount;	//交換可能数
	mes "[ペリックス]";
	mes "よし、" +getitemname('@gain)+ "と交換してやろう。";
	mes getitemname('@gain)+ "はいくつ欲しいんだ？";
	next;
	switch (select("できる限り欲しいです","数を指定したいです","やっぱりやめておきます")) {
	case 1:
		set '@val,'@max;
		break;
	case 2:
		mes "[ペリックス]";
		mes "なら100個以下にしてくれ。";
		mes "もしやめるなら「0」と言えばいい。";
		mes "お前の持ってる数だと……";
		mes "最大" +'@max+ "個まで";
		mes getitemname('@gain)+ "をあげられるぞ。";
		while(1) {
			next;
			input '@val;
			if('@val < 0 || '@val > 100) {
				mes "[ペリックス]";
				mes "100個より多いと渡せないだろ。";
				mes "もう一度考えてくれ。";
				continue;
			}
			break;
		}
		if('@val == 0) {
			mes "[ペリックス]";
			mes "そうか。";
			mes "じゃあ、また気が向いたら来な。";
			close;
		}
		if('@val > '@max) {
			mes "[ペリックス]";
			mes "おや？それだとゼロピーが足りないぞ。";
			mes "もう少し集めてから来るんだな。";
			close;
		}
		break;
	case 3:
		mes "[ペリックス]";
		mes "じゃあ、また今度な。";
		close;
	}
	delitem 909,'@amount*'@val;
	getitem '@gain,'@val;
	mes "[ペリックス]";
	mes "ほらよ！";
	mes "約束の" +getitemname('@gain)+ "だ。";
	mes "大事に使うんだぞ。";
	close;
}

// アイテムエクスチェンジNPC
// 2026/03/31 分まで
prontera.gat,80,66,5	script	イセナ	440,{
	set '@npcname$, "[" + strnpcinfo(1) + "]";
	mes '@npcname$;
	mes "こんにちは。";
	mes "　";
	mes "言葉…通じてますか？";
	next;
	mes '@npcname$;
	mes "本当ですか？！";
	mes "　";
	mes "頑張って言葉を覚えたのですが";
	mes "通じなかったらと不安でした。";
	next;
	mes '@npcname$;
	mes "こちらでは";
	mes "アイテムエクスチェンジの";
	mes "受付を行っております。";
	next;
	mes '@npcname$;
	mes "アイテムエクスチェンジとは";
	mes "冒険者様のお持ちの装備品を";
	mes "所縁のある別の装備品に";
	mes "交換するサービスです。";
	next;
	mes '@npcname$;
	mes "交換に失敗はございませんが";
	mes "装備品により手数料に差異が";
	mes "ありますのでご注意ください。";
	next;
	mes '@npcname$;
	mes "さて、交換したい";
	mes "装備品はありますか？";
	next;

	// メニューの階層
	switch(select("説明を詳しく聞く:話をやめる:グループ1:グループ2:グループ3:グループ4:グループ5:グループ6")) {
		case 1:
			mes '@npcname$;
			mes "アイテムエクスチェンジとは、";
			mes "装備品を別の装備品に";
			mes "交換するサービスです。";
			mes "使われた材料は全て消滅します。";
			next;
			mes '@npcname$;
			mes "能力を引き継ぐ事は出来ない為、";
			mes "精錬・カード・属性、";
			mes "ヒドゥンスロットエンチャント等の";
			mes "付与効果は全て消滅します。";
			next;
			mes "[イセナ]";
			mes "そして、気をつけなければならない点が";
			mes "一つあります。";
			mes "例えば……「+7ソードブレイカー[3]」と";
			mes "ただの「ソードブレイカー[3]」を持って、";
			mes "私に装備交換を依頼すると";
			mes "どちらが対象になると思いますか？";
			next;
			mes '@npcname$;
			mes "正解はわからない……";
			mes "つまり、対象のアイテムが";
			mes "どういった物か、私は一切";
			mes "気にせずに作業するという事です。";
			next;
			mes '@npcname$;
			mes "^FF0000装備品の状態は、^000000";
			mes "^FF0000一切関係ありません。^000000";
			mes "^FF0000例え未鑑定だろうが、^000000";
			mes "^FF0000破損していようが、^000000";
			mes "^FF0000装備交換を行います。^000000";
			next;
			mes '@npcname$;
			mes "^FF0000特定のアイテムだけを^000000";
			mes "^FF0000装備交換したい場合、^000000";
			mes "^FF0000同じ名前の^000000";
			mes "^FF0000アイテムを倉庫にでも^000000";
			mes "^FF0000預けておいた方がいいです。^000000";
			next;
			mes '@npcname$;
			mes "この事を忘れ、別のアイテムが";
			mes "装備交換の対象になっても";
			mes "私は一切責任を取りません。";
			mes "十分に注意してください。";
			next;
			mes '@npcname$;
			mes "他に説明する事は特にありません。";
			mes "　";
			mes "気軽に利用してみてください。";
			close;

		case 2:
			mes '@npcname$;
			mes "そうですか……";
			close;

		case 3:
			mes '@npcname$;
			mes "どのアイテムを交換に出しますか？";
			next;
			switch(select("メイルブレイカー[3]","ソードブレイカー[3]","砂漠の風[4]","砂漠の夕暮れ[2]","バイオレットフィアー[2]","紅炎のツインエッジ[3]","蒼炎のツインエッジ[3]","ブラディウムイヤリング[1]","ブラディウムリング[1]","ブラディウムブローチ[1]","オウルデュークのシルクハット[1]","オウルヴァイカウントのシルクハット[1]","セーフリームニルの手袋[1]","アンドフリームニルのマント[1]","やめる")) {
			case 1: //メイルブレイカー[3]
				set '@delid,13032;
				set '@getid,13031;
				break;

			case 2: //ソードブレイカー[3]
				set '@delid,13031;
				set '@getid,13032;
				break;

			case 3: //砂漠の風[4]
				set '@delid,13035;
				set '@getid,13034;
				break;

			case 4: //砂漠の夕暮れ[2]
				set '@delid,13034;
				set '@getid,13035;
				break;

			case 5: //バイオレットフィアー[2]
				set '@delid,1185;
				setarray '@getid,13413,13412;
				break;

			case 6: //紅炎のツインエッジ[3]
				set '@delid,13413;
				set '@getid,13412;
				break;

			case 7: //蒼炎のツインエッジ[3]
				set '@delid,13412;
				set '@getid,13413;
				break;

			case 8: //ブラディウムイヤリング[1]
				set '@delid,2788;
				set '@getid,2789;
				break;

			case 9: //ブラディウムリング[1]
				set '@delid,2789;
				set '@getid,2790;
				break;

			case 10: //ブラディウムブローチ[1]
				set '@delid,2790;
				set '@getid,2788;
				break;

			case 11: //オウルデュークのシルクハット[1]
				set '@delid,18866;
				set '@getid,5943;
				break;

			case 12: //オウルヴァイカウントのシルクハット[1]
				set '@delid,5943;
				set '@getid,18866;
				break;

			case 13: //セーフリームニルの手袋[1]
				set '@delid,2984;
				set '@getid,20770;
				break;

			case 14: //アンドフリームニルのマント[1]
				set '@delid,20770;
				set '@getid,2984;
				break;
			case 15: //やめる
				mes "[イセナ]";
				mes "わかりました。";
				mes "もし興味がわきましたら";
				mes "またお越しください。";
				close;
			}
			mes '@npcname$;
			mes getitemname('@delid)+ " [" +getiteminfo('@delid,10)+ "]";
			mes "ですね。";
			mes "この装備品を交換すると";
			mes getitemname('@getid[0])+ " [" +getiteminfo('@getid[0],10)+ "]";
			if ('@getid[1] > 1) { mes getitemname('@getid[1])+ " [" +getiteminfo('@getid[1],10)+ "]"; }
			mes "に交換されます。";
			next;
			mes '@npcname$;
			mes "この装備品を交換するには";
			mes "^0000FFスプレンディッドコイン^000000を";
			mes "^0000FF10個^000000いただきます。";
			next;
			mes '@npcname$;
			mes "そして、交換に利用した装備品は";
			mes "全て回収致します。";
			mes "その際に、いままでの";
			mes "^FF0000精錬値及び挿していたカード等も";
			mes "回収されてしまいます^000000。";
			next;
			mes '@npcname$;
			mes "交換を行いますか？";
			next;
			if(select("^FF0000今回はやめておく^000000","^0000FFお願いします^000000")==1) {
			mes '@npcname$;
			mes "わかりました。";
			mes "もし興味がわきましたら";
			mes "またお越しください。";
			close;
			}
			if(countitem('@delid) < 1 || countitem(6081) < 10) {
				mes '@npcname$;
				mes "材料かコインが足りません。";
				close;
			}
			delitem '@delid,1;
			delitem 6081,10;
			misceffect 83;
			mes '@npcname$;
			mes "交換完了です。";
			mes "またご利用ください。";
			getitem '@getid[0],1;
			if ('@getid[1] > 1) { getitem '@getid[1],1; }
			close;
		// --- ここから追加 --- //
		case 4:
			// --- グループ2 初期設定 ---
			setarray '@pay_items[1],	2732, 2730, 2731, 2903, 2902, 1309, 13437, 2923, 28362, 2925, 28363, 2924, 28364, 2926, 28365, 2927, 28366, 2928, 28367;
			setarray '@target_items[1],	2730, 2731, 2732, 2902, 2903, 13437, 1309, 28362, 2923, 28363, 2925, 28364, 2924, 28365, 2926, 28366, 2927, 28367, 2928;
			setarray '@cost_num[1], 	10, 10, 10, 10, 10, 10, 10, 100, 10, 100, 10, 100, 10, 100, 10, 100, 10, 100, 10;
			setarray '@en3[1], 		0, 0, 0, 0, 0, 0, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0, 29012, 0; // エンチャント
			set '@cost_id, 6081;
			goto L_Exchange_Main; // 共通処理へジャンプ

		case 5:
			// --- グループ3 初期設定 ---
			setarray '@pay_items[1],	2656, 28373;
			setarray '@target_items[1],	28373, 2656;
			setarray '@cost_num[1], 	10, 10;
			// グループ3はエンチャントなしのため en3 は 0 で初期化 (または未定義でOK)
			cleararray '@en3[0], 0, 128;  // エンチャントなし
			set '@cost_id, 6081;
			goto L_Exchange_Main; // 共通処理へジャンプ

		case 6:
			// --- グループ4 初期設定 ---
			setarray '@pay_items[1],	2900, 2901, 28348, 28347, 13324, 13326, 13325, 18940, 28906, 18941, 28907, 18942, 28908, 18943, 28909, 2998, 22082;
			setarray '@target_items[1],	2901, 2900, 28347, 28348, 13326, 13325, 13324, 28906, 18940, 28907, 18941, 28908, 18942, 28909, 18943, 22082, 2998;
			setarray '@cost_num[1], 	10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10;
			cleararray '@en3[0], 0, 128; // エンチャントなし
			set '@cost_id, 6081;
			goto L_Exchange_Main; // 共通処理へジャンプ

		case 7:
			// --- グループ5 (装備中アイテム交換) ---
			setarray '@pay_items[1], 410322, 410323, 410340, 410341, 410504, 410506, 410505, 410507;
			setarray '@target_items[1], 410340, 410341, 410322, 410323, 410505, 410507, 410504, 410506;
			setarray '@cost_num[1], 10, 10, 10, 10, 10, 10, 10, 10;
			set '@cost_id, 6081;

			// 装備チェック (中段: 9)
			set '@part, 9;
			if (getequipisequiped('@part) == 0) {
				mes '@npcname$; mes "対象の部位（中段）にアイテムを装備していません。"; close;
			}

			// 装備中のアイテムIDがリストにあるか確認
			set '@current_eq_id, getequipid('@part);
			set '@idx, 0;
			for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
				if ('@pay_items['@i] == '@current_eq_id) {
					set '@idx, '@i;
					break;
				}
			}

			if ('@idx == 0) {
				mes '@npcname$; mes "現在装備している " + getitemname('@current_eq_id) + " は交換対象ではありません。"; close;
			}

			// 交換データの確定
			set '@target_id, '@target_items['@idx];
			set '@pay_id, '@pay_items['@idx];
			set '@num, '@cost_num['@idx];
			
			// 精錬値と第0スロットカードの取得
			set '@ref, getequiprefinerycnt('@part);
			set '@en0, getequipcardid('@part, 0);

			mes '@npcname$;
			mes "装備中の";
			mes "^FF0000" + getitemname('@pay_id) + "[" + getiteminfo('@target_id, 10) + "]^000000 を";
			mes "^0000FF" + getitemname('@target_id) + "[" + getiteminfo('@target_id, 10) + "] ^000000 に交換します";
			mes "精錬値(+" + '@ref + ")とカード情報を引き継ぎます。";
			mes "手数料：^FF0000" + getitemname('@cost_id) + " " + '@num + "個^000000";
			next;

			if(select("^0000FFお願いします^000000:^FF0000今回はやめておく^000000") == 2) {
				mes '@npcname$; mes "またの機会に。"; close;
			}

			// 条件チェック
			if(countitem('@cost_id) < '@num) {
				mes '@npcname$; mes "手数料が足りません。"; close;
			}
			if(checkweight('@target_id, 1) == 0) {
				mes '@npcname$; mes "荷物が重すぎて受け取れません。"; close;
			}

			// 実行処理
			delitem '@cost_id, '@num; // 手数料消費
			unequip '@part;           // 装備解除
			delitem '@pay_id, 1;      // 装備していたアイテムを削除

			// 報酬配布 (精錬値、第0スロットカードを適用)
			getitem2 '@target_id, 1, 1, '@ref, 0, '@en0, 0, 0, 0;

			misceffect 83;
			mes '@npcname$; mes "交換が完了しました。";
			close;

		default:
			mes '@npcname$;
			mes "現在準備中です。";
			close;
	}

// --- 交換用共通ロジック ---
L_Exchange_Main:
	mes '@npcname$;
	mes "どのアイテムを交換に出しますか？";
	next;

	set '@menu_str$, "";
	for(set '@i, 1; '@i < getarraysize('@pay_items); set '@i, '@i + 1) {
		set '@p_id, '@pay_items['@i];
		// スロット数を getiteminfo で取得
		set '@menu_str$, '@menu_str$ + getitemname('@p_id) + "[" + getiteminfo('@p_id, 10) + "]:";
	}
	
	set '@idx, select('@menu_str$);
	
	set '@target_id, '@target_items['@idx];
	set '@pay_id, '@pay_items['@idx];
	set '@num, '@cost_num['@idx];
	set '@en_id, '@en3['@idx];

	mes '@npcname$;
	mes "【交換内容の確認】";
	mes "渡すもの：^FF0000" + getitemname('@pay_id) + "[" + getiteminfo('@pay_id, 10) + "] 1個^000000";
	mes "ですね。";
	mes "この装備品を交換すると";
	mes "受け取る：^0000FF" + getitemname('@target_id) + "[" + getiteminfo('@target_id, 10) + "] 1個^000000";
	if ('@en_id > 0) {
		mes "付与効果：^008800" + getitemname('@en_id) + "^000000";
	}
	mes "に交換されます。";
	next;
	mes '@npcname$;
	mes "この装備品を交換するには";
	mes "^FF0000" + getitemname('@cost_id) + " " + '@num + "個^000000いただきます。";
	next;
	if(select("^0000FFお願いします^000000:^FF0000今回はやめておく^000000") == 2) {
		mes '@npcname$;
		mes "わかりました。";
		mes "もし興味がわきましたら";
		mes "またお越しください。"; close;
	}

	// 条件チェック (所持数・重量)
	if(countitem('@pay_id) < 1 || countitem('@cost_id) < '@num) {
		mes '@npcname$; mes "材料、または手数料が足りません。"; close;
	}
	if(checkweight('@target_id, 1) == 0) {
		mes '@npcname$; mes "荷物が重すぎて受け取れません。"; close;
	}

	// 実行処理
	delitem '@pay_id, 1;
	delitem '@cost_id, '@num;

	// エンチャントがある場合は getitem2、ない場合は getitem を使用
	if ('@en_id > 0) {
		getitem2 '@target_id, 1, 1, 0, 0, 0, 0, 0, '@en_id;
	} else {
		getitem '@target_id, 1;
	}

	misceffect 83; // 成功エフェクト
	mes '@npcname$;
	mes "交換が完了しました。";
	close;
}