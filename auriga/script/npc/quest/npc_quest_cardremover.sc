// 2026/04/07 アップデート (AI実装)
// 座標変更
// boss_card_list.csv(dbフォルダ) 実装
// AIによる要点説明：この方法であれば、boss_card_list.csvファイルに新しいカードIDを1行追加するだけで、NPCの判定ロジックと表示リストの両方が自動的に更新されるようになります

iz_gimlet.gat,38,73,4	script	ツーニャ#31653	555,{

	function PowerOfDHA {
		for(set '@i,0; '@i<20; set '@i,'@i+1){
			if('@i < 10)
				set '@progress1$,'@progress1$+ (DHA_POWER > '@i? "■": "□");
			else
				set '@progress2$,'@progress2$+ (DHA_POWER > '@i? "■": "□");
		}
		mes "DHAパワー:(" +DHA_POWER+ " / 20)";
		mes '@progress1$;
		mes '@progress2$;
	}

	if(@talk == 0 && DHA_POWER == 0) {
		emotion 16;
		mes "[ツーニャ]";
		mes "お腹すいたニャ……";
		mes "冒険者のお役に立ちたいのに";
		mes "力が出ないニャ……";
		next;
		mes "[ツーニャ]";
		mes "でもグルメなネコは";
		mes "カリカリなんか食べないニャ……";
		mes "はぁ……^FF0000特選ネコ缶(マグロ)^000000";
		mes "あれは美味しかったニャ～。";
		next;
		if(select("声をかける","立ち去る") == 2) {
			emotion 28;
			mes "[ツーニャ]";
			mes "お腹が空き過ぎて";
			mes "野生も目覚めないニャ……";
			close;
		}
		mes "[ツーニャ]";
		mes "はっ、冒険者さんニャ！";
		mes "お役に立つニャ!!";
		next;
		menu "何が出来るの？",-;
		mes "[ツーニャ]";
		mes "武器や防具に装着したカードを分離して";
		mes "お手元に戻すことができるニャ！";
		mes "もちろん、武器や防具はそのまま";
		mes "残るニャ!!";
		next;
		mes "[ツーニャ]";
		mes "ただ、カードを分離するには";
		mes "特別な力……「^FF0000DHAパワー^000000」が";
		mes "必要ニャ。";
		next;
		mes "[ツーニャ]";
		mes "それが豊富に含まれている";
		mes "「^FF0000特選ネコ缶(マグロ)^000000」";
		mes "これをくれれば、お役に立てるニャ！";
		mes "持っていたら食べさせて欲しいニャ。";
		set @talk,1;
		next;
	}
	mes "[ツーニャ]";
	mes "何をするニャ？";
	PowerOfDHA;
	next;
	switch(select("特選ネコ缶(マグロ)をあげる","カード分離","何が出来るの？","立ち去る")) {
	case 1:
		mes "^FF0000‐インフォメーション‐";
		mes "・DHAパワーは最大20まで貯められます。";
		mes "・貯めたDHAパワーは現在ログイン中の";
		mes "　キャラクター専用です。";
		mes "　他のキャラクターで使用する事は";
		mes "　できません。";
		mes "・DHAパワーを使いたいキャラクターで";
		mes "　特選ネコ缶(マグロ)を";
		mes "　与えて下さい。";
		next;
		if(countitem(25308) < 1) {
			mes "[ツーニャ]";
			mes "やったニャ！　くれるのニャ？";
			mes "って持ってないニャ？";
			mes "……い、イジワルするのは";
			mes "やめるのニャ～～！";
			close;
		}
		emotion 37;
		mes "[ツーニャ]";
		mes "本当にくれるのニャ？";
		next;
		if(select("いいえ","はい") == 1) {
			emotion 28;
			mes "[ツーニャ]";
			mes "おあずけかニャー！";
			close;
		}
		if(DHA_POWER >= 20) {	// 未調査
			emotion 28;
			mes "[ツーニャ]";
			mes "今はちょっとおなか一杯ニャ";
			mes "DHAパワー満タンニャ～！";
			close;
		}
		if(countitem(25308) < 1) {
			mes "[ツーニャ]";
			mes "やったニャ！　くれるのニャ？";
			mes "って持ってないニャ？";
			mes "……い、イジワルするのは";
			mes "やめるのニャ～～！";
			close;
		}
		delitem 25308,1;
		set DHA_POWER,DHA_POWER + 1;
		emotion 38;
		mes "[ツーニャ]";
		mes "いっただっきミャ～～す！";
		mes "おいしいニャ！";
		mes "幸せだニャ～！";
		next;
		mes "[ツーニャ]";
		mes "DHAパワーが充填されていくニャ！";
		PowerOfDHA;
		next;
		emotion 32;
		mes "[ツーニャ]";
		mes "ご馳走様ニャ。";
		mes "カード分離をするなら";
		mes "いつでも言ってニャ！";
		close;
	case 2:
		mes "[ツーニャ]";
		mes "装備しているアイテムの中で";
		mes "カードを分離したいものを";
		mes "選ぶニャ！";
		next;
		set '@part,select(
				getequipid(1)? "^nItemID^"+getequipid(1): "",
				getequipid(2)? "^nItemID^"+getequipid(2): "",
				getequipid(3)? "^nItemID^"+getequipid(3): "",
				getequipid(4)? "^nItemID^"+getequipid(4): "",
				getequipid(5)? "^nItemID^"+getequipid(5): "",
				getequipid(6)? "^nItemID^"+getequipid(6): "",
				getequipid(7)? "^nItemID^"+getequipid(7): "",
				getequipid(8)? "^nItemID^"+getequipid(8): "",
				getequipid(9)? "^nItemID^"+getequipid(9): "",
				getequipid(10)? "^nItemID^"+getequipid(10): "",
				"やっぱりやめる");
		if('@part == 11) {
			mes "[ツーニャ]";
			mes "また来るニャ。";
			close;
		}
		set '@max,getiteminfo(getequipid('@part),10);
		if('@max == 0) {
			emotion 1;
			mes "[ツーニャ]";
			mes "そのアイテムに";
			mes "スロットは無いニャよ？";
			close;
		}
		set '@slot,0;
		if('@max > 1) {
			set '@slot,select(
				"止める",
				'@max>=1? "スロット1": "",
				'@max>=2? "スロット2": "",
				'@max>=3? "スロット3": "",
				'@max>=4? "スロット4": "")-2;
			if('@slot < 0) {
				mes "[ツーニャ]";
				mes "また来るニャ。";
				close;
			}
		}
		set '@cardid,getequipcardid('@part,'@slot);
		if('@cardid == 0) {
			emotion 1;
			mes "[ツーニャ]";
			mes "そこにカードは無いニャよ？";
			next;
			mes "[ツーニャ]";
			mes "また来るニャ。";
			close;
		}

		// --- 分離コスト判定部分の修正案ここから ---
		set '@cost, 1; // 基本コスト
		set '@file$, "db/boss_card_list.csv"; // ファイルパス（Aurigaディレクトリ以下 ）
		set '@rows, csvgetrows('@file$); // csvの行数を取得 

		for(set '@i, 0; '@i < '@rows; set '@i, '@i + 1) {
		// 数値型の変数 @id に直接代入することで文字列から数値へ変換される 
		set '@id, csvread('@file$, '@i, 0); 

			if ('@cardid == '@id) { 
			set '@cost, 5; // リストにあればコスト5
			break;
			}
		}
		// --- 分離コスト判定部分の修正案ここまで ---

		mes "[ツーニャ]";
		mes "そのカードニャら……";
		mes "DHAパワー[^FF0000" +'@cost+ "^000000]で分離できるニャ！";
		mes "やるかニャ？";
		PowerOfDHA;
		next;
		if(select("止める","分離する") == 1) {
			mes "[ツーニャ]";
			mes "また来るニャ。";
			close;
		}
		if(DHA_POWER < '@cost) {
			emotion 17;
			mes "[ツーニャ]";
			mes "DHAパワーが足りないニャ……";
			mes "今のままではカードを分離できないニャ。";
			mes "ごめんなさいだニャ……";
			close;
		}
		emotion 52;
		mes "[ツーニャ]";
		mes "まかせるニャ！";
		next;
		set DHA_POWER,DHA_POWER-'@cost;
		successremovecards '@part,'@slot+1;
		misceffect 567,"";
		mes "[ツーニャ]";
		mes "ふぃ～";
		mes "いい仕事したニャ！";
		close;
	case 3:
		mes "[ツーニャ]";
		mes "DHAパワーを消費して";
		mes "装備品に装着したカードを";
		mes "分離してあげるニャ！";
		next;
		switch(select("DHAパワー？","装備品？","カード？","立ち去る")) {
		case 1:
			mes "[ツーニャ]";
			mes "お魚の栄養がたっぷり詰まった";
			mes "猫の活力源ニャ。";
			mes "ガッチリくっついている";
			mes "カードを分離するのに";
			mes "欠かせないパワーニャ。";
			next;
			mes "[ツーニャ]";
			mes "^FF0000特選ネコ缶(マグロ)^0000001個で";
			mes "^0000FFDHAパワー^000000が[1]溜まるニャ！";
			mes "そして、溜まった^0000FFDHAパワー^000000を";
			mes "消費して、カードを分離するニャ！";
			next;
			mes "^FF0000‐インフォメーション‐";
			mes "・DHAパワーは最大20まで貯められます。";
			mes "・貯めたDHAパワーは現在ログイン中の";
			mes "　キャラクター専用です。";
			mes "　他のキャラクターで使用する事は";
			mes "　できません。";
			mes "・DHAパワーを使いたいキャラクターで";
			mes "　特選ネコ缶(マグロ)を";
			mes "　与えて下さい。";
			close;
		case 2:
			mes "[ツーニャ]";
			mes "今、装備している装備品で";
			mes "カードが装着してある装備品なら";
			mes "武器でも防具でもアクセサリーでも";
			mes "OKニャ！";
			next;
			mes "[ツーニャ]";
			mes "分離したカードと一緒に、";
			mes "カードを分離した装備品は";
			mes "傷一つ付けずにお返しするニャよ！";
			mes "ただ……取り扱えない装備品も";
			mes "あるニャ………";
			next;
			mes "^FF0000‐インフォメーション‐";
			mes "・ツーニャに話しかけた時に";
			mes "　装備している装備品が";
			mes "　対象となります。";
			mes "・スロットの表記がない装備品は";
			mes "　対象外となります。";
			mes "・装備品の精錬値、";
			mes "　他のスロットのカード、";
			mes "　エンチャント、ランダムオプションは";
			mes "　元の状態が保持されます。";
			close;
		case 3:
			switch(select("説明を聞く","必要DHAパワーを見る","立ち去る")) {
			case 1:
				mes "[ツーニャ]";
				mes "DHAパワーを消費して";
				mes "今、装備している装備品から";
				mes "カードを分離するニャ！";
				mes "分離したカードは装備品と一緒に";
				mes "お返しするニャよ！";
				next;
				mes "[ツーニャ]";
				mes "ただ……大概のカードは";
				mes "DHAパワー[1]消費で";
				mes "分離できるニャけど";
				mes "中には粘着力が強くて";
				mes "DHAパワーを沢山消費する";
				mes "カードもあるニャ……";
				next;
				mes "^FF0000‐インフォメーション‐";
				mes "・ツーニャに話しかけた時に";
				mes "　装備している装備品に";
				mes "　装着されているカードが";
				mes "　対象となります。";
				mes "・分離できるのは[カード]のみとなり";
				mes "　[エンチャント]は分離できません。";
				mes "　アイテムの詳細の中で";
				mes "　[系列]がカードと記載されている";
				mes "　アイテムは分離の対象となります。";
				mes "・[カード]によって、消費する";
				mes "　DHAパワーの量が異なります。";
				close;
			// --- メッセージ表示部分の修正案ここから ---
			case 2:
				mes "‐必要DHAパワー‐";
				mes "『消費[^FF00005^000000]リスト』";

					set '@file$, "db/boss_card_list.csv";
					set '@rows, csvgetrows('@file$);
					for(set '@i, 0; '@i < '@rows; set '@i, '@i + 1) {
						set '@id, csvread('@file$, '@i, 0); // 数値として読み込み 
				// IDからアイテム名をDB（item_db.txt）より取得して表示 [cite: 66]

				mes "・" + getitemname('@id);
				}
			// --- メッセージ表示部分の修正案ここまで ---
				next;
				mes "『消費[1]リスト』";
				mes "・その他のカード";
				close;
			case 3:
				mes "[ツーニャ]";
				mes "もう行っちゃうのかニャ……";
				mes "ま、また来るといいニャ！";
				close;
			}
		case 4:
			mes "[ツーニャ]";
			mes "もう行っちゃうのかニャ……";
			mes "ま、また来るといいニャ！";
			close;
		}
	case 4:
		mes "[ツーニャ]";
		mes "もう行っちゃうのかニャ……";
		mes "ま、また来るといいニャ！";
		close;
	}
}
