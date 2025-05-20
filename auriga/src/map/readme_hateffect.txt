エフェクト装備　定義追加説明書(2025/04/29現在)
* status.h 記述確認

// hat_effectテーブル
enum {
	HAT_EF_MIN = 0,
	HAT_EF_BLOSSOM_FLUTTERING,
	HAT_EF_MERMAID_LONGING,
	HAT_EF_RL_BANISHING_BUSTER,
という記述があり、ここにエフェクト装備で使う定義を記述します

* 実装サンプル
5914,cos,[衣装] 蝶のはためき,4,20,,0,,0:0,,0,2074075135,2,4096,,1,0,0,{},{ hateffect HAT_EF_FLUTTER_BUTTERFLY,TRUE; },{ hateffect HAT_EF_FLUTTER_BUTTERFLY,FALSE; }

* 定義と番号の調査
luafiles514\lua files\hateffectinfo\hateffectids.lub
HatEFID = {
	HAT_EF_Blossom_Fluttering = 1,
	HAT_EF_MERMAID_LONGING = 2,
	HAT_EF_rl_banishing_buster = 3,
	HAT_EF_LJOSALFAR = 4,
	HAT_EF_CLOCKING = 5,
	HAT_EF_SNOW = 6,
	HAT_EF_MAKEBLUR = 7,
	HAT_EF_SLEEPATTACK = 8,
	HAT_EF_GUMGANG = 9,
	HAT_EF_TALK_FROSTJOKE = 10,
	HAT_EF_DEMONSTRATION = 11,
	HAT_EF_Flutter_Butterfly = 12,
	HAT_EF_Angel_Fluttering = 13,
	
という記述があり、

[記述用定義] = [ID]

となってます

hateffect HAT_EF_FLUTTER_BUTTERFLY,TRUE; あるいは hateffect 12,TRUE;
[HAT_EF_FLUTTER_BUTTERFLY] が [12番] となります

// hat_effectテーブル の一番下が、今あなたが見ている実装済み定義となります
足りない分をその下に追記してください(sample_status.h参照)

* 2025/04/29現在の状況
HAT_EF_Kung_Fu_Panda = 254
が最新となります

* luaの仕様変更について
2024年秋頃にhateffectのluaが拡張され

effecthatitemtable.lub
footprinteffectinfo.lub
hateffectids.lub

このように拡張されていますが、それより前の環境で使っているのは旧式の[hateffectinfo.lub]となっています
なので今後追加する場合は [hateffectids.lub] -> [hateffectinfo.lub] 記述ルールに従って定義移植する必要があります
定義は共通なのでアップデートで追加される定義はそのままstatus.hに使えます

* const.txt について
//HATEFFECT関連
FALSE				0
TRUE				1
HAT_EF_MIN			0
HAT_EF_BLOSSOM_FLUTTERING	1
HAT_EF_MERMAID_LONGING		2
HAT_EF_RL_BANISHING_BUSTER	3
HAT_EF_LJOSALFAR		4
HAT_EF_CLOCKING			5
HAT_EF_SNOW			6
HAT_EF_MAKEBLUR			7
HAT_EF_SLEEPATTACK		8
HAT_EF_GUMGANG			9
HAT_EF_TALK_FROSTJOKE		10
HAT_EF_DEMONSTRATION		11
HAT_EF_FLUTTER_BUTTERFLY	12
HAT_EF_ANGEL_FLUTTERING		13

という記述があり、記述ルールに従って実装します

* 今後の課題
この技術は使えなくなる可能性があります
luaは仕様変更されるものと考えて下さい
