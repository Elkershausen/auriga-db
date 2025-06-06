//フェイヨンNPC関連スクリプト 20240515 アップデート
//20191029 20200907 20201013 20201027 不審なボトル おいしい魚 美味しいお肉 綿の玉 豪華なペットフード 販売追加
//npc_town_payon 上書き

//shop
payon.gat,159,96,4	shop	道具商人	88,1750,501,645,601,602
payon_in01.gat,5,49,6	shop	道具商人	88,1750,611,501,502,503,504,506,645,656,601,602,1065
payon_in01.gat,15,120,5	shop	武器商人	77,1750,1751,1101,1104,1107,1201,1204,1207,1601,1701,1704,1707,1710,1713,1714,1718
payon_in01.gat,7,120,5	shop	防具商人	76,2401,2403,2405,2501,2503,2505,2208,2211,2212,2301,2303,2305,2321,2328,2332,2309,2330,2628
payon.gat,177,131,4	shop	テイミング商人	125,537,643,10013,10014,6095,6096,6097,6098,6099,6100,6104,6105,6106,6107,6108,6109,6110,6111,6112,579,11616,25231,25233,25377
payon_in02.gat,87,34,6	shop	道具商人	75,1750,1751,611,501,502,503,504,506,645,656,601,602,1065
payon_in01.gat,5,129,6	shop	武器商人	703,1146,1245

//============================================================
// フェイヨンNPC
//------------------------------------------------------------
payon.gat,246,154,0	script	お嬢さん	90,{
	mes "[お嬢さん]";
	mes "昔ね、この町で生活するのも";
	mes "大変だった時期があったんです。";
	mes "その時は人が亡くなっても";
	mes "埋葬するお金がなくて、死体を";
	mes "隣の洞窟に捨てていたの。";
	next;
	mes "[お嬢さん]";
	mes "そうしたら、その洞窟では";
	mes "死体たちがあの世にいけなくて";
	mes "現世をさまよってるらしいの。怖いわ〜";
	close;
}

payon.gat,249,156,1	script	おばさん	66,{
	mes "[おばさん]";
	mes "よくきたわね〜。あの森を";
	mes "通り抜けるのは大変だったでしょう。";
	mes "最近は、モンスターが増えたせいで";
	mes "フェイヨンを訪れる人が減って";
	mes "しまったのよ。寂しいことだわ。";
	next;
	mes "[おばさん]";
	mes "それに私も町の奥様方もか弱いでしょ。";
	mes "腕っぷしが強い人ならいいけど、";
	mes "私達にとってはちょっと怖いのよね〜。";
	mes "おほほほ〜。";
	next;
	mes "[おばさん]";
	mes "でも……";
	mes "何でこんなにモンスターが";
	mes "多いのかしらね？";
	if(Sex==0) {
		mes "……お嬢さんもモンスター退治が";
		mes "したいの？じゃあ、化粧品代の足しに";
		mes "なるような、狩場を教えてあげるわ。";
		next;
		mes "[おばさん]";
		mes "私達の町の近くにモンスターが";
		mes "たくさんいる洞窟があるのよ。";
		mes "もし興味があるなら、一度";
		mes "行ってみたらどうかしら？";
		next;
		mes "[おばさん]";
		mes "町を北の方へ抜けて森を通り、";
		mes "更に北西へ行くとあるわよ。";
		mes "近くに行けばすぐ分かるわ。";
		mes "モンスターの気持ち悪い臭いが";
		mes "鼻につくからね。";
	}
	else {
		mes "……力試しにモンスター退治が";
		mes "したいの？じゃあ、すぐ近くにある";
		mes "ちょうどいい狩場を教えてあげるわ。";
	}
	next;
	switch(select("危ないですね","準備が必要ですね","おばさんの服は珍しいですね")) {
	case 1:
		mes "[おばさん]";
		mes "そうなのよ〜。";
		mes "やっぱり町のすぐ近くに";
		mes "モンスターがいるなんてねぇ〜。";
		mes "でも町の安全を守るために";
		mes "その洞窟の近くに弓手村があるから";
		mes "大丈夫だとは思うけどねぇ。";
		close;
	case 2:
		mes "[おばさん]";
		mes "そうよ。だからそこの道具屋さんで";
		mes "必要なものを買っていくといいわよ。";
		mes "なんせその店は私の主人が……";
		mes "こほんこほん。";
		mes "町の人が経営しているお店ですのよ。";
		mes "おほほ、おほほほほほ……";
		close;
	case 3:
		mes "[おばさん]";
		mes "まあ〜！わかる？";
		mes "これはプロンテラの最新の流行なのよ。";
		mes "町内の奥様方はちょっと手が届かない";
		mes "でしょうけどね。主人が子ども達用に";
		mes "くれたお金があったからちょうど……";
		mes "こほんこほん。おほほほ……";
		close;
	}
}

payon.gat,246,158,5	script	おばさん	66,{
	mes "[餅屋おばさん]";
	mes "あら、フェイヨン以外の言葉も";
	mes "たまにはいいわね。旅人さんを";
	mes "見ると大騒ぎする人が多いけど、";
	mes "フェイヨンの人全てがそうって";
	mes "わけじゃないから安心しなさい。";
	next;
	mes "[餅屋おばさん]";
	mes "占い師さんの時もちょっと騒ぎに";
	mes "なってたけどね。あら？";
	mes "あなたと会うのは初めてかしら……";
	next;
	mes "[餅屋おばさん]";
	if(Sex==0) {
		mes "まあ！";
		mes "若いお嬢さんが何て格好してるの!?";
		mes "ちょっと派手なんじゃない？";
		mes "それじゃ、ろくに家事ができないわよ。";
	}
	else {
		mes "まあ！頼もしそうな方ね。";
		mes "あとでちょっとお時間いいかしら？";
		mes "ちょうど美味しいお餅があるのよ。";
		mes "え？いらない？";
		mes "それは残念だわ〜。";
	}
	next;
	if(select("占い師のこと知ってます？","……さようなら")==2) {
		mes "[餅屋おばさん]";
		mes "あらまあ〜。やぁね〜。";
		mes "もう少しくらい話をしてっても";
		mes "いいのに〜。";
		close;
	}
	mes "[餅屋おばさん]";
	mes "ええ、あの占い師さんでしょ？";
	mes "あの人は腕がよかったわね。";
	mes "中央宮にいたみたいだけど……";
	mes "今はどこにいるかわからないわ。";
	next;
	mes "[餅屋おばさん]";
	mes "私も見てもらったんだけど";
	mes "「次の月に良い男性に巡り合う」";
	mes "ですって。おほほほほ〜！";
	close;
}

payon.gat,134,211,4	script	青年	59,{
	mes "[青年]";
	mes "かたい皮に被われたモンスターには";
	mes "物理的な力が通用しないんだ。";
	mes "それらを効果的に退治できるのは";
	mes "「気」または「魔法」と言う";
	mes "精神的な力だけだ。";
	close;
}

payon.gat,173,82,0	script	青年	88,{
	mes "[青年]";
	mes "昔、亡くなったお爺さんに";
	mes "聞いたことがあるんだ。";
	mes "死んだ人が動き出す";
	mes "恐ろしい力を持ったお札があるって。";
	next;
	mes "[青年]";
	mes "本当かどうかわからないけど、";
	mes "そんな物があるなら俺の爺さんに";
	mes "使ったらどうなるかな？";
	close;
}

payon.gat,132,235,4	script	モンスター学者	98,{
	mes "[モンスター学者ビコック]";
	mes "こんにちは。";
	mes "私はルーンミッドガッツ";
	mes "モンスター研究会所属の学者";
	mes "ビコックと申します。";
	mes "何かモンスターについて";
	mes "知りたいことがあります？";
	next;
	switch(select("最近の動向","アンデッドモンスター","モンスター研究会")) {
	case 1:
		mes "[モンスター学者ビコック]";
		mes "フェイヨンは、山の奥深くに";
		mes "位置するため、常にモンスターの";
		mes "脅威にさらされている地域です。";
		mes "町の隣にダンジョンがある";
		mes "くらいですしね。";
		next;
		mes "[モンスター学者ビコック]";
		mes "ダンジョンでは、アンデッド系列の";
		mes "モンスターが多数出没します。";
		mes "この特徴は、学界の関心を";
		mes "集めています。そして私の任務も";
		mes "そのアンデッド系列のモンスターの";
		mes "特性を研究することなんです。";
		close;
	case 2:
		mes "[モンスター学者ビコック]";
		mes "ダンジョンに出没するアンデッド";
		mes "モンスターの特徴は、その根源に";
		mes "あります。これらは……本来";
		mes "永遠の安らぎを得ているはずの";
		mes "フェイヨンの住人なんです。";
		next;
		mes "[モンスター学者ビコック]";
		mes "でもそれが、今では魂を失い";
		mes "人の世を彷徨っている……";
		mes "その成れの果てと考えられています。";
		next;
		mes "[モンスター学者ビコック]";
		mes "元は生命体であったものが";
		mes "モンスターに変異することとは";
		mes "まるで異なります。国王陛下は";
		mes "このゾンビ類に対し格別の関心を";
		mes "持っていらっしゃいます。";
		mes "彼らは元は同じ国民でしたからね。";
		next;
		mes "[モンスター学者ビコック]";
		mes "国王トリスタン三世陛下は";
		mes "これ以上、アンデッドモンスターが";
		mes "生まれないことを、深く望んで";
		mes "いらっしゃいます。それで、私どもの";
		mes "研究会を支援してくださっています。";
		next;
		mes "[モンスター学者ビコック]";
		mes "国王陛下と遺族の願いを叶えるために";
		mes "私どもモンスター研究会は、最善の";
		mes "努力を尽くし、一刻も早くアンデッド";
		mes "モンスターの謎を解明するつもりです。";
		mes "必ず！";
		close;
	case 3:
		mes "[モンスター学者ビコック]";
		mes "モンスター研究会は、絶えず発生する";
		mes "モンスター関連の問題に対応するための";
		mes "トリスタン三世陛下によって発足された";
		mes "研究組織です。";
		next;
		mes "[モンスター学者ビコック]";
		mes "ルーンミッドガッツ内の有能な人材が";
		mes "集まり、研究と探険を通じ";
		mes "モンスターの根源に近付こうと";
		mes "日夜研究を重ねています。";
		next;
		mes "[モンスター学者ビコック]";
		mes "もちろん、モンスターを研究することは";
		mes "容易ではありません。私たちは命がけで";
		mes "ダンジョンやフィールドにいる";
		mes "モンスターを研究しています。";
		next;
		mes "[モンスター学者ビコック]";
		mes "その過程で命を落としたり、大怪我を";
		mes "した学者は数え切れないほどいます。";
		mes "しかし私たちは、研究を止めるわけには";
		mes "いきません。皆さん、ひいては";
		mes "ルーンミッドガッツ全体のために";
		mes "必要なことだからです！";
		next;
		mes "[モンスター学者ビコック]";
		mes "はっ……";
		mes "つい興奮してしまいました。";
		mes "申し訳ありません。";
		next;
		mes "[モンスター学者ビコック]";
		mes "ごほんごほん……";
		mes "とにかく、そういうわけなので";
		mes "もしモンスター学者に会ったら";
		mes "親切にしてくださいね。";
		mes "私どもは皆さんのために";
		mes "研究しているんですから。";
		close;
	}
}

payon.gat,210,110,4	script	酔っ払いおじさん	120,{
	if(Job == Job_Archer) {
		mes "[酔っ払いおじさん]";
		mes "ひゅう〜っ！";
		mes "アーチャーの友よぉ〜！";
		mes "矢を引く手に、ほれ、杯を持てぇ〜！";
		mes "んあ〜、俺におごってくれるのかぁ〜？";
	}
	else {
		mes "[酔っ払いおじさん]";
		mes "んあ！";
		mes "弓すら使えないくせに";
		mes "酒だけは飲むのかぁ？";
		mes "はは！面白いねぇ〜！";
		mes "俺におごってくれるのかぁ？";
	}
	next;
	switch(select("うーん、一杯だけなら……","嫌です！","あ、お酒は嫌いなので……")) {
	case 1:
		if(Zeny < 100)
			set Zeny,0;
		else
			set Zeny,Zeny-100;
		mes "[酔っ払いおじさん]";
		mes "ありがてぇ〜！";
		mes "やっぱ外の人は優しくていいねぇ〜。";
		mes "それに比べ、最近のアーチャーどもは";
		mes "冷たいんだよなぁ〜。がはははっ！";
		next;
		mes "[酔っ払いおじさん]";
		mes "ま、俺も若い時は、そんな感じ";
		mes "だったがなぁ〜。でも俺はぁ〜";
		mes "恋愛に関しては熱かったぞ〜！";
		mes "町にきれいな女の子がいてさ、";
		mes "仲良くなろうと頑張ったさぁ。おう！";
		mes "今でも若い女の子は大好きだぞぅ〜！";
		next;
		mes "[酔っ払いおじさん]";
		mes "ゴクゴクゴックン！";
		mes "くう〜!!うめぇ〜！";
		mes "ありがてぇ〜！ありがてぇ〜！";
		mes "がはははははっ！";
		close;
	case 2:
		mes "[酔っ払いおじさん]";
		mes "チェッ！";
		mes "最近の若者は冷てぇなぁ〜。";
		mes "年長者へのいたわりってものが";
		mes "ないのかねぇ〜？";
		mes "人との食べ飲みを楽しむってのは";
		mes "いいことなんだぞぅ〜。ケッ。";
		close;
	case 3:
		mes "[酔っ払いおじさん]";
		mes "う、うん？";
		mes "なんだぁ〜。";
		close;
	}
}

//============================================================
// フェイヨン室内NPC
//------------------------------------------------------------
payon_in01.gat,180,7,2	script	女性従業員	90,{
	mes "[酒場のお嬢さん]";
	mes "みなさんは弓矢の買い物などで";
	mes "色々な場所に行けますが、";
	mes "私はいつもこの小さなお店の店番。";
	mes "とても憂鬱で退屈です……";
	next;
	mes "[酒場のお嬢さん]";
	mes "体に染みついているこのお酒の";
	mes "臭い、すごく嫌いなんです。";
	mes "帰宅したらすぐに、この嫌な臭いを";
	mes "消す為に何回もシャワーを浴びます。";
	mes "でも、なかなか落ちないんですよね。";
	next;
	mes "[酒場のお嬢さん]";
	mes "誰か、この小さな酒場から";
	mes "私を連れ出してくれる";
	mes "鋼鉄より堅く火山よりも熱い";
	mes "真の男性はいないのでしょうか？";
	mes "ね、お" +(Sex? "兄": "姉")+ "さん？";
	next;
	mes "[酒場のお嬢さん]";
	mes "占い師さんは";
	mes "「やがて良いことがある。」";
	mes "と言ってくれましたが……";
	mes "良いことどころか、毎日がこんな";
	mes "退屈なことの繰り返し……";
	mes "ふぅ〜、なんでこうなんでしょう？";
	next;
	mes "[酒場のお嬢さん]";
	mes "あ、お客さんにこんな話をしたって";
	mes "仕方ないですよね……";
	mes "酒場の従業員らしく";
	mes "きちんと仕事をしなきゃ。";
	next;
	mes "[酒場のお嬢さん]";
	mes "お客さん、何をお手伝いしましょうか？";
	next;
	switch(select("ゾンビについて教えて欲しい","占い師について教えて欲しい","お酒をちょっと飲みたい")) {
	case 1:
		mes "[酒場のお嬢さん]";
		mes "ゾンビ……ですか。";
		mes "それは死んでも、天に召すことが";
		mes "できなかった人達のことです。";
		mes "外部の人々には珍しいようですが";
		mes "フェイヨンではよく見かけるので、";
		mes "日常の一部となっています。";
		next;
		mes "[酒場のお嬢さん]";
		mes "えっと……ゾンビは神聖なものに";
		mes "弱いんですよ。だからフェイヨンの人は";
		mes "ゾンビを攻撃する時、神聖な金属である";
		mes "銀で作られた「銀の矢」を使うんです。";
		next;
		mes "[酒場のお嬢さん]";
		mes "聞いた話ですけど……";
		mes "長老様が若かった頃、お仲間が";
		mes "ゾンビとしてよみがえったことが";
		mes "あったそうです。長老様は深く";
		mes "悲しみながらも、呪いを打ち消す為に";
		mes "「銀の矢」を使いました。";
		next;
		mes "[酒場のお嬢さん]";
		mes "するとゾンビになっていたお仲間は";
		mes "かつての肉体に一度、魂を取り戻し";
		mes "やっと安らかな眠りにつけたそうです。";
		next;
		mes "[酒場のお嬢さん]";
		mes "最終的には消滅させる相手に";
		mes "余計なことかもしれませんが。";
		mes "それでも安らかな眠りを与えようと";
		mes "するのは……亡き者に対しても";
		mes "礼儀を尽くす人の心ならではですね。";
		next;
		mes "[酒場のお嬢さん]";
		mes "私のお爺さんも……";
		mes "長老様のおかげで";
		mes "永遠の安らぎを得たそうです。";
		break;
	case 2:
		mes "[酒場のお嬢さん]";
		mes "ああ、占い師さんですね。";
		mes "本当に気がきくよい方ですよ。";
		mes "でも、今はここにいないんです。";
		next;
		mes "[酒場のお嬢さん]";
		mes "占い師さんは最初、この酒場に寝泊り";
		mes "しながら、占いをしていたんですよ。";
		mes "すると長老様が、その神通力を";
		mes "高くお買いになって、中央宮へ";
		mes "お呼びになったそうです。";
		next;
		mes "[酒場のお嬢さん]";
		mes "けれども、その後の消息は誰も";
		mes "知らないみたいです。";
		mes "一時期、アマツに滞在していた";
		mes "なんて話もあるそうですが……";
		break;
	case 3:
		mes "[酒場のお嬢さん]";
		mes "ごめんなさい。";
		mes "最近、モンスターが多いので";
		mes "なかなかお酒を作りに";
		mes "行けないんですよ。そのせいで";
		mes "良いお酒はきらしちゃってるんです。";
		next;
		mes "[酒場のお嬢さん]";
		mes "しかもマスターに、本当に良い";
		mes "お酒しか売っちゃだめだよって";
		mes "言われているので……";
		next;
		mes "[酒場のお嬢さん]";
		mes "だから今度、またきてください。";
		mes "申し訳ありません〜。";
		break;
	}
	next;
	mes "[酒場のお嬢さん]";
	mes "それでは、お客さんにとって";
	mes "素敵な一日になりますように。";
	mes "ふぅ〜、それにしても";
	mes "私の人生はいつ開けるのかしら……";
	close;
}

payon_in01.gat,66,64,5	script	アーチャー ジャック	88,{
	mes "[アーチャー ジャック]";
	mes "俺の友達は無駄話ばっかりして心配だ。";
	mes "弓の腕前はかなり良いのに";
	mes "あの口数の多さは……";
	mes "長老様もあいつのおしゃべりには";
	mes "呆れてるしな。";
	next;
	switch(select("アーチャー？","長老様？","おしゃべりな人？")) {
	case 1:
		mes "[アーチャー ジャック]";
		mes "ああ、友達は俺と同じ服を着ているが";
		mes "フェイヨン一の腕前を持つ";
		mes "アーチャーだ。弓手村の近くで若い";
		mes "アーチャーの指導をしている。";
		mes "一度話をしてみるといいよ。";
		close;
	case 2:
		mes "[アーチャー ジャック]";
		mes "長老様は中央宮にいらっしゃる。";
		mes "俺ら町の皆を導いてくれるお方だ。";
		mes "若い頃は強い弓を片手に、森を";
		mes "駆けていたそうだ。俺がまだ幼い時";
		mes "その勇姿を見たことがあるよ。";
		mes "今は、年老いてしまったが……";
		next;
		mes "[アーチャー ジャック]";
		mes "それでもその目つきは、狙った標的を";
		mes "決して逃さなかった当時のままだよ。";
		mes "俺が心から尊敬しているお方だ。";
		close;
	case 3:
		mes "[アーチャー ジャック]";
		mes "おしゃべりとは、果てしなく口を開き";
		mes "言葉を紡ぎ続けるってことだ。";
		mes "まさに俺の友達がそうなんだよ。";
		mes "本当に終わりがないんだ。";
		next;
		mes "[アーチャー ジャック]";
		mes "以前、川辺で服を洗っている時に";
		mes "しゃべり始めたんだが……";
		mes "話し終わった時には、服どころか";
		mes "靴下まで洗い終えてたんだよ。";
		next;
		mes "[アーチャー ジャック]";
		mes "そういうこともあって、そいつは";
		mes "みんなに「口で矢を放つ奴」や";
		mes "「人間スピーカー」とか";
		mes "「口裂けモンスター」なんて";
		mes "言われてる。";
		next;
		mes "[アーチャー ジャック]";
		mes "俺は今まで、このフェイヨンを始め";
		mes "色々な街に行ったが、あいつほど";
		mes "話し好きな人は見たことがない。";
		mes "それは他の人も……";
		mes "ああ、君にとっても同じだろう。";
		next;
		mes "[アーチャー ジャック]";
		mes "あいつに会ったら、他の人は";
		mes "みんな無口に見える。";
		mes "口数は少ない方が賢明だよ、やっぱり。";
		next;
		mes "[アーチャー ジャック]";
		mes "うん？そいつが誰かって？";
		mes "ああ、俺の友達のボルトのことだよ。";
		mes "ボルトは旅館で寝泊りしてるよ。";
		mes "今なら起きてるんじゃないかな。";
		mes "一度会ってみたら？";
		close;
	}
}

payon_in01.gat,47,59,2	script	アーチャー ボルト	88,{
	mes "[アーチャー ボルト]";
	mes "日々、弓術の鍛錬を怠ってはならない。";
	mes "少しでもさぼると腕がなまる。";
	mes "おや？初めて見る顔だな？";
	next;
	mes "[アーチャー ボルト]";
	mes "僕はボルト。アーチャーのボルトだ。";
	mes "いきなり質問するが、";
	mes "お前はぶらぶらする方か？";
	next;
	if(select("いいえ","よくぶらぶらします")==1) {
		mes "[アーチャー ボルト]";
		mes "うん……そう？";
		mes "君、アーチャーに向いているね。";
		mes "僕らアーチャーは、一時も訓練を";
		mes "怠ってはいけない。だから";
		mes "ぶらぶらする人はまっぴらごめんだ。";
		next;
		mes "[アーチャー ボルト]";
		mes "アーチャーがどんな訓練を";
		mes "するのかって？ふふ……";
		mes "フェイヨンのアーチャーは他地域の";
		mes "アーチャーのように、のんびり";
		mes "弓遊びなんてことはしない。";
		next;
		mes "[アーチャー ボルト]";
		mes "実戦がすなわち訓練！";
		mes "常に弓矢を身につけ";
		mes "標的を見つけたら、すかさず";
		mes "走りながら矢を射る！それが";
		mes "僕らフェイヨンアーチャーの姿だ！";
		next;
		if(select("弓も大事ですよね","やはり訓練が大事ですよね")==2) {
			mes "[アーチャー ボルト]";
			mes "うん、そうだ。";
			mes "君、アーチャーに向いているね。";
			mes "僕らアーチャーは、一時も訓練を";
			mes "怠ってはいけない。だから";
			mes "ぶらぶらする人はまっぴらごめんだ。";
			next;
			mes "[アーチャー ボルト]";
			mes "何度も同じことを言われると";
			mes "うんざりする？";
			mes "いや、それに耐えることも訓練だ！";
			mes "それが僕らフェイヨンアーチャーの";
			mes "姿なんだ！";
			close;
		}
		mes "[アーチャー ボルト]";
		mes "そう！弓が大事！";
		mes "実はフェイヨンの弓は大陸最強なんだ！";
		mes "フェイヨンの森の木はとても質がよく";
		mes "その木から作られた弓は、軽くて";
		mes "丈夫なんだ。だから良質な弓を";
		mes "たくさん作ることができる。";
		next;
		mes "[アーチャー ボルト]";
		mes "ちなみに僕が使っている弓は";
		mes "クルミの木から作ったんだけど、";
		mes "硬くてよくできているんだ。しかも";
		mes "ハンドルには、滑り止め効果がある";
		mes "黒い塗料をしっかり塗り込んで";
		mes "いるから、握り心地が最高なんだ！";
		next;
		mes "[アーチャー ボルト]";
		mes "フェイヨンの森は、昔から木の質が";
		mes "良いことで有名だった。だがそれが";
		mes "大陸の不吉な気を森へ集める要因に";
		mes "なったのかもしれないね。いつしか";
		mes "木々がモンスターへと変異するように";
		mes "なってしまったんだ。";
		next;
		mes "[アーチャー ボルト]";
		mes "美しい木々が、不気味な悲鳴をあげる";
		mes "モンスターになってしまったのは";
		mes "本当に切ない！だが!!なぜかその";
		mes "モンスターからも、良い木材が出る。";
		mes "だから……その木材で矢を作ることも";
		mes "あるんだ、実は。あはは！";
		next;
		menu "それなら安心ですね",-;
		mes "[アーチャー ボルト]";
		mes "いや、モンスターが出現するのは";
		mes "森だけじゃないから……";
		mes "こんな所に弓手村がある";
		mes "理由と関係があるんだけどね。";
		mes "ここから少し北の方へ行くと";
		mes "洞窟があるだろ。";
		next;
		mes "[アーチャー ボルト]";
		mes "その中では、モンスターが続々と";
		mes "生まれ増え続けている。";
		mes "僕らはそいつらから町を守る為に";
		mes "ここで戦っている。";
		mes "長老様の命を受けてね。";
		next;
		switch(select("ど、洞窟?!","長老様って？","そんな町は嫌だな〜")) {
		case 1:
			mes "[アーチャー ボルト]";
			mes "洞窟は、町から北の方へ行くとあるよ。";
			mes "そこには、コウモリみたいなものから";
			mes "死体みたいなものまで";
			mes "色々な奴がいる。";
			next;
			mes "[アーチャー ボルト]";
			mes "そのまま放置しておくと、そいつらが";
			mes "町中へ入ってきてしまう。だから";
			mes "僕らは定期的に、その中に入って";
			mes "モンスターを片付けているんだ。";
			next;
			mes "[アーチャー ボルト]";
			mes "だが、それには終わりがない。";
			mes "いくら片付けても、次々と";
			mes "生まれてくるからな。";
			next;
			mes "[アーチャー ボルト]";
			mes "……話はこれくらいにしておこう。";
			mes "いくら僕でもこれ以上、";
			mes "話すわけにはいかないし。";
			mes "まあ、洞窟のそばを通る時は";
			mes "気をつけるんだな。";
			close;
		case 2:
			break;	//これだけ抜ける
		case 3:
			mes "[アーチャー ボルト]";
			mes "……シクシク。";
			close;
		}
	}
	else {
		mes "[アーチャー ボルト]";
		mes "うん……僕もたまにぶらぶらすることは";
		mes "好きだ。そう、いろりの傍でのんびり";
		mes "寝るのもいいね。そういや昔";
		mes "うとうとしててふと気づいたら";
		mes "服が焦げててさ。慌てて飛び起きた";
		mes "なんてことがあったよ……あはは。";
		next;
		switch(select("そんな感じで大丈夫なの？","けどその時間に訓練をした方がいいんじゃ？","……さようなら")) {
		case 1:
			mes "[アーチャー ボルト]";
			mes "う〜ん……さすがに遊んで";
			mes "ばかりはいけないけどね。";
			mes "長老様に怒られるし……かといって";
			mes "酒場のおじさんみたいになるわけにも";
			mes "……あはは。";
			next;
			switch(select("長老様？","酒場のおじさん？","もう手遅れじゃ……")) {
			case 1:
				break;	//switch文を全部抜ける
			case 2:
				mes "[アーチャー ボルト]";
				mes "ああ、酒場のおじさんね。";
				mes "たまに小遣いをもらっては";
				mes "お酒を買って飲んでるんだけど……";
				mes "一杯だけにすればいいのに";
				mes "たくさん飲んで、その上騒ぐから";
				mes "ちょっと困り者なんだよ。";
				next;
				mes "[アーチャー ボルト]";
				mes "でも同じ町の人だからさ、気持ちよく";
				mes "お酒を飲んでるところを無理に";
				mes "帰すわけにもね。……けど本当は";
				mes "僕自身、お酒に興味があるんだ。";
				mes "一度酒場に行ってみたいな。";
				mes "じゃ、また今度！";
				close;
			case 3:
				mes "[アーチャー ボルト]";
				mes "……ふん。";
				close;
			}
			break;
		case 2:
			mes "[アーチャー ボルト]";
			mes "うん……そうだ。";
			mes "君、アーチャーに向いてるね。";
			mes "アーチャーは、一時も訓練を";
			mes "怠ってはいけない。";
			mes "だからぶらぶらする人は";
			mes "とても痛い目を見る。";
			next;
			mes "[アーチャー ボルト]";
			mes "なのに僕みたいな怠け者でも";
			mes "不思議なことにアーチャーにはなれる。";
			mes "まあ、人生何があるか";
			mes "わかんないしね。ということで";
			mes "人生を思いっきり楽しもう！";
			close;
		case 3:
			mes "[アーチャー ボルト]";
			mes "……シクシク。";
			close;
		}
	}
	mes "[アーチャー ボルト]";
	mes "長老様？";
	mes "ああ、長老様は本当に立派なお方だ。";
	mes "……僕はよく「おしゃべり!!」って";
	mes "怒られるから、ちょっと苦手だけどね。";
	mes "でも、いつも町のみんなのことを";
	mes "心配していらっしゃる優しいお方だ。";
	next;
	mes "[アーチャー ボルト]";
	mes "最近は中央宮で休まれる日が多いんだ。";
	mes "中央宮へ行くと、警備兵が守っている";
	mes "部屋がある。その部屋の中に";
	mes "長老様がいらっしゃるよ。";
	next;
	mes "[アーチャー ボルト]";
	mes "ああっ!!";
	mes "こんな話を外の人にしたというのが";
	mes "バレたら、また怒られる。あはは……";
	mes "ま、まぁ既にしゃべっちゃったことは";
	mes "仕方ないよね！ということで";
	mes "これ以上は話せないから、また今度！";
	close;
}

payon.gat,158,246,4	script	警備兵	708,3,3,{
	end;
OnTouch:
	mes "[警備兵]";
	mes "こちらはフェイヨンの中央宮です。";
	mes "長老様のお計らいにより";
	mes "一般の方の出入りを許可しておりますが";
	mes "内部では絶対！静粛にしてください。";
	next;
	unequip;
	mes "[警備兵]";
	mes "申し訳ありませんが、安全の為";
	mes "装備を解除させて頂きます。";
	mes "ご了承ください。";
	close;
}

payon_in03.gat,96,116,3	script	警備隊長	708,3,3,{
	end;
OnTouch:
	mes "[警備隊長]";
	mes "誰だ？君は。";
	next;
	mes "[警備隊長]";
	mes "ほう〜、外の人か。";
	mes "ここでは静粛にして欲しい。";
	next;
	unequip;
	mes "[警備隊長]";
	mes "それからすまんが、安全管理の為";
	mes "こちらで武装を解除させてもらう。";
	close;
}

payon_in03.gat,102,185,4	script	警備兵	708,{
	mes "[警備兵]";
	mes "ここへ入ってきてはいけません!!";
	mes "外へ出てください!!";
	close;
}

payon_in03.gat,99,190,4	script	長老	107,2,2,{
	end;
OnTouch:
	if(BaseLevel <= 30) {
		mes "[警備兵]";
		mes "コラッ！";
		mes "長老様にご無礼なことをするな!!";
		close;
	}
	if(rand(2)) {
		mes "[警備兵]";
		mes "長老様はただいまお休みに";
		mes "なっております。";
		mes "次の機会にお立ち寄りください。";
		close;
	}
	mes "[警備兵]";
	mes "コラッ！";
	mes "長老様に……";
	next;
	mes "[長老]";
	mes "いや、そのままで構わぬ。";
	mes "久しぶりに若者と話がしたくなった。";
	next;
	switch(select("フェイヨンについて教えてください","外部との交流について教えてください",
			"町の北の洞窟について教えてください","アーチャーについて教えてください","ハンターについて教えてください")) {
	case 1:
		mes "[長老]";
		mes "フェイヨンは、古くから山のふもとで";
		mes "自給自足の生活を営んできた";
		mes "山岳民族の都市じゃ。";
		mes "わしらのご先祖様は、農民や";
		mes "都市民らのように豊かな文物に接する";
		mes "ことができなかった。";
		next;
		mes "[長老]";
		mes "じゃが、自ら生計を立てていく術は";
		mes "知っておったのじゃ。";
		mes "わしらフェイヨンの民は男女の別なく";
		mes "狩りをし、そこで得た食べ物を焼いて";
		mes "食べるなどをして生活をしてきた。";
		next;
		mes "[長老]";
		mes "都市の若者らは、フィールドや";
		mes "ダンジョンに生息するモンスターを";
		mes "恐れる。じゃが、わしらにとっては";
		mes "モンスターとの戦いすら生活の";
		mes "一部なんじゃよ。";
		next;
		mes "[長老]";
		mes "それでトリスタン三世陛下は、国の";
		mes "若者らにモンスターとの戦闘について";
		mes "教えて欲しい、とフェイヨンの民に";
		mes "頼みなさったのじゃ。";
		break;
	case 2:
		mes "[長老]";
		mes "フェイヨンは昔、外部とは";
		mes "断絶された町じゃった。";
		mes "じゃが、わしの若い頃に";
		mes "プロンテラから役人が派遣される";
		mes "ようになった。王室の軍人や役人、";
		mes "カプラのお嬢さん……";
		next;
		mes "[長老]";
		mes "初めは、文化の違いから";
		mes "争いが絶えなかった。";
		mes "じゃが彼らのおかげで、他地域との";
		mes "交流が活発になったのじゃ。";
		next;
		mes "[長老]";
		mes "今では、フェイヨンへやってきた";
		mes "外部の若者が、そのまま住み着くことも";
		mes "ある。わしの若い頃では想像すら";
		mes "できなかったことじゃ。";
		next;
		mes "[長老]";
		mes "じゃが、内心は嬉しいんじゃ。";
		mes "外部から来た人でも、このフェイヨンを";
		mes "愛してくれるようになったからのう。";
		break;
	case 3:
		mes "[長老]";
		mes "町の北にある洞窟は、わしも";
		mes "若かりし頃によく行ったのう。";
		mes "その時は今よりももっと酷かった。";
		mes "見たこともない邪悪なモンスターらが";
		mes "続々とあふれ出していたんじゃよ。";
		next;
		mes "[長老]";
		mes "今いるモンスターは……";
		mes "わしらが昔、戦った奴らとは";
		mes "異なるがのう。";
		next;
		mes "[長老]";
		mes "おぬしも見たか？";
		mes "洞窟に生息する亡者の数々を……";
		mes "その昔、町を守る為に洞窟へ入ったが";
		mes "生還できなかった若者の悲しみの";
		mes "成れの果てじゃ。";
		next;
		mes "[長老]";
		mes "そんな彼らの亡霊と戦い、";
		mes "また新たな犠牲者が生まれる……";
		mes "この老いぼれにはあまりにも";
		mes "辛い現実じゃ……何とも……";
		next;
		mes "[長老]";
		mes "あの悲惨なダンジョンを";
		mes "なくす方法があるのなら、";
		mes "どんなことでもするんじゃがのう……";
		break;
	case 4:
		mes "[長老]";
		mes "町の四方を取り囲む巨大な森のおかげで";
		mes "わしらは木材を豊富に得られる。";
		mes "この様な環境下で弓の技術が";
		mes "発達するのは当然のことじゃ。森では";
		mes "木々が生い茂っているから、標的を";
		mes "狙いにくいと考えるのは間違いじゃ。";
		next;
		mes "[長老]";
		mes "森では身を隠せるし、直接攻撃するしか";
		mes "脳のない奴の足は鈍る。それに対し";
		mes "アーチャーは、素早い動きで遠くから";
		mes "正確に標的を攻撃することができる。";
		next;
		mes "[長老]";
		mes "また……意外な利点もあるんじゃよ。";
		mes "わしが若かった頃、森の中で";
		mes "モンスターらに追いつめられた";
		mes "ことがあった。ちょうどそんな時";
		mes "草むらの中に矢が落ちているのを";
		mes "見つけたんじゃ。";
		next;
		mes "[長老]";
		mes "そこですかさず、その矢を使って";
		mes "攻撃し、見事に倒したんじゃ。";
		mes "ふぁ、ふぁ、ふぁ……";
		break;
	case 5:
		mes "[長老]";
		mes "フェイヨンに外部の文物が流入し";
		mes "様々な変化が起きた。その中で最も";
		mes "変わったのは、狩りの方式じゃな。";
		mes "特に火薬に関する技術は";
		mes "フェイヨンの民にかなり大きな";
		mes "影響を与えたんじゃ。";
		next;
		mes "[長老]";
		mes "弓矢だけでは物足りなかった者の";
		mes "のどの渇きを見事にうるおして";
		mes "くれたのじゃ。";
		next;
		mes "[長老]";
		mes "そして、モンスターを狩るのに";
		mes "適したトラップを製造する技術が";
		mes "生まれた。先代の長老様は";
		mes "その様な素晴らしい技術を身に付けた";
		mes "彼らに「ハンター」という称号を";
		mes "お与えになった。";
		next;
		mes "[長老]";
		mes "それにより、トラップは民の間で";
		mes "とても流行りだした。じゃが";
		mes "トラップは便利であると同時に";
		mes "危険なものでもある。";
		next;
		mes "[長老]";
		mes "そこでわしらは、若者がむやみに";
		mes "トラップを使用することを禁じ、";
		mes "「ハンター」として認められた者に";
		mes "のみ、その使用を許可した。";
		next;
		mes "[長老]";
		mes "ちなみに、己の責任を己で負える能力を";
		mes "持つ者のみ「ハンター」の試験に";
		mes "挑戦できるんじゃ。";
		break;
	}
	next;
	mes "[長老]";
	mes "少々、疲れたのう……";
	mes "わしはちょっと休ませて頂くよ。";
	mes "それでは、若者。";
	mes "体には気をつけるんじゃよ。";
	close;
}

//============================================================
// フェイヨン弓手村NPC
//------------------------------------------------------------
pay_arche.gat,77,131,2	script	アーチャー ゾスマ	88,{
	mes "[アーチャー ゾスマ]";
	mes "フェイヨン！良い所です！";
	mes "弓もよし！アーチャーたちが";
	mes "とても優秀です！";
	mes "あなた！フェイヨンのアーチャーが";
	mes "どれだけすごいか、分かっていますか？";
	next;
	switch(select("分かっています！","分かりませんが","……")) {
	case 1:
		mes "[アーチャー ゾスマ]";
		mes "おお！そうですよね！フェイヨンの";
		mes "アーチャー！すっごく素敵です！";
		mes "フェイヨンのアーチャーが";
		mes "射る矢は、いつも百発百中です！";
		mes "たとえ遠く離れていても";
		mes "鳥の心臓を正確に狙えますしね！";
		next;
		if(select("本当に好きなんですね","はは……")==2)
			close;
		mes "[アーチャー ゾスマ]";
		mes "はい！とても大好きです！";
		mes "だからフェイヨンで修行しています！";
		mes "何か、知りたいことがあれば";
		mes "遠慮なく聞いてください。";
		next;
		switch(select("ここの人の服装は珍しいですね","町の中にある大きな建物は何ですか？",
					"あそこでお酒を飲んでいるおじさん……誰ですか？","次の機会に話しましょう")) {
		case 1:
			mes "[アーチャー ゾスマ]";
			mes "フェイヨンの服装は珍しいでしょう？";
			mes "古くから深い森に囲まれ、外部から";
			mes "隔離されているので、他地域とは異なる";
			mes "独特の文化が形成されています。";
			mes "服装もそんな文化に基づくものです！";
			mes "これ、着心地はとてもいいですよ！";
			close;
		case 2:
			mes "[アーチャー ゾスマ]";
			mes "中央宮のことですね。外部の人が";
			mes "入ってはいけない場所です。僕も";
			mes "入ったことはありません。ただ";
			mes "噂によると……そこにはフェイヨンの";
			mes "貴人たちと、彼らが招待した外国人が";
			mes "集まっているそうです。";
			next;
			mes "[アーチャー ゾスマ]";
			mes "いつか入ってみたいです。";
			mes "きっと面白い所に違いないです！";
			close;
		case 3:
			mes "[アーチャー ゾスマ]";
			mes "はい！その人とても有名です！";
			mes "くれぐれもお酒はあげないでください！";
			mes "酒ぐせがすごく悪いから";
			mes "大変なことになります！";
			close;
		case 4:
			mes "[アーチャー ゾスマ]";
			mes "そ、そうですか！";
			mes "さようなら！";
			mes "また今度会いましょう！";
			close;
		}
	case 2:
		mes "[アーチャー ゾスマ]";
		mes "ええ！残念です！";
		mes "フェイヨンのアーチャーの魅力を";
		mes "知らないなんて！もうちょっと";
		mes "修行を積んでからきてください！";
		mes "その時に、その魅力について";
		mes "話しましょう！";
		close;
	case 3:
		mes "[アーチャー ゾスマ]";
		mes "どうしたんですか？";
		mes "なんで笑ってるんですか？";
		mes "うん……変な人ですね！";
		close;
	}
}

//============================================================
// ジェムストーン交換NPC
//------------------------------------------------------------
payon.gat,173,238,5	script	ジェード	754,{
	mes "[ジェード]";
	mes "こんにちはー。";
	mes "同じ色のジェムストーンを";
	mes "二個ずつ持ってくれば、すぐに";
	mes "他の色のジェムストーンに";
	mes "交換してあげるよー。";
	next;
	switch(select("ブルーをレッドに交換！","レッドをイエローに交換！","イエローをブルーに交換！")) {
	case 1:
		set '@itemid,717;
		set '@gain,716;
		break;
	case 2:
		set '@itemid,716;
		set '@gain,715;
		break;
	case 3:
		set '@itemid,715;
		set '@gain,717;
		break;
	}
	if(countitem('@itemid)<2) {
		mes "[ジェード]";
		mes "はははー！";
		mes "キミ、冗談が好きだねー。";
		mes getitemname('@itemid)+ "が2個ないと";
		mes getitemname('@gain)+ "には";
		mes "交換してあげられないよー。";
		close;
	}
	set '@max,countitem('@itemid)/2;
	mes "[ジェード]";
	mes "うーん……";
	mes "それだと" +'@max+ "個の";
	mes getitemname('@gain)+ "と";
	mes "交換できるよ。どうする？";
	next;
	switch(select("あるだけ全部交換する","交換する数を決める","やめる")) {
	case 1:
		set '@num,'@max;
		break;
	case 2:
		mes "[ジェード]";
		mes "いくつ欲しい？";
		mes "あ、でも100個以下にしてね。";
		while(1) {
			next;
			input '@num;
			if('@num > 100) {
				mes "[ジェード]";
				mes "うん？";
				mes "100個以下にしてと言ったよね？";
				continue;
			}
			break;	//while文抜ける
		}
		if('@num > '@max)
			close;
		if('@num <= 0) {
			mes "[ジェード]";
			mes "なんだ、いらないのか。";
			close;
		}
		break;
	case 3:
		mes "[ジェード]";
		mes "そっか……";
		mes "もし必要になったら、遠慮なくきてね。";
		mes "いつでも交換してあげるから。";
		close;
	}
	delitem '@itemid,'@num*2;
	getitem '@gain,'@num;
	mes "[ジェード]";
	mes "ほら、ご依頼の";
	mes getitemname('@gain)+ "だよ。";
	mes "また交換して欲しかったら";
	mes "いつでもおいで。";
	mes "……うん？";
	mes "僕の顔に何かついてる？";
	close;
}
