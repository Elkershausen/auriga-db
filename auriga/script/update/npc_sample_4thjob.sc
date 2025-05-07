//2025/05/07 アップデート
//簡易4次職転職スクリプト

-	script	4thJobChange		10461,{
	if(getbaseclass(Class) == CLASS_SUM) {	mes "["+strnpcinfo(1)+"]";	mes "人間形プレイヤー専用です";	close;	}
	if(Upper == UPPER_BABY) {	mes "["+strnpcinfo(1)+"]";	mes "養子職は4次職に転職できません。";	close;	}
	if(BaseLevel != 200) {	mes "["+strnpcinfo(1)+"]";	mes "BaseLevel 200 が必要です。";	close;	}
	if(JobLevel < 70) {	mes "["+strnpcinfo(1)+"]";	mes "JobLevel 70 以上が必要です。";	close;	}
	if(SkillPoint != 0) {	mes "["+strnpcinfo(1)+"]";	mes "スキルポイントは残さないで下さい。";	close;	}
	if(checkriding() || checkcart() || checkfalcon() || sc_ison(SC_ALL_RIDING)) {	mes "["+strnpcinfo(1)+"]";	mes "ペコペコ系 カート";	mes "鷹 ファルコン ウォーグ、騎乗用手綱";	mes "全部外して下さい。";	close;	}
	//if(Weight) { 	mes "["+strnpcinfo(1)+"]";	mes "所持重量を0にして下さい。";	close;	}	//所持重量条件不要
	mes "["+strnpcinfo(1)+"]";
	mes ""+strcharinfo(0)+"さんは";
	mes "どの職業に転職しますか？";
	next;
	switch(select(
	"ドラゴンナイト",		//case 1
	"アークメイジ",
	"ウインドホーク",
	"カーディナル",
	"マイスター",
	"シャドウクロス",
	"インペリアルガード",
	"エレメンタルマスター",
	"トルバドゥール(男)",
	"トルヴェール(女)",
	"インクイジター",		//case 11
	"バイオロジスト",
	"アビスチェイサー",
	"天帝",
	"ソウルアセティック",
	"蜃気楼(男)",
	"不知火(女)",
	"ナイトウォッチ",
	"ハイパーノービス",
	"やめる"			//case 20
	))
		{
	case 1:	if(Job != Job_RuneKnight) {	mes "["+strnpcinfo(1)+"]";	mes "ルーンナイト専用です";	close;	}
		setlook 7,0;			//服色を標準化
		setlook 13,0;			//セカンドコスチューム解除
		jobchange Job_DRAGONKNIGHT;	//転職処理
		break;				//スクリプト終了
	case 2:	if(Job != Job_Warlock) {	mes "["+strnpcinfo(1)+"]";	mes "ウォーロック専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ARCHMAGE;
		break;
	case 3:	if(Job != Job_Ranger) {	mes "["+strnpcinfo(1)+"]";	mes "レンジャー専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_WINDHAWK;
		break;
	case 4:	if(Job != Job_ArchBishop) {	mes "["+strnpcinfo(1)+"]";	mes "アークビショップ専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_CARDINAL;
		break;
	case 5:	if(Job != Job_Mechanic) {	mes "["+strnpcinfo(1)+"]";	mes "メカニック専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_MEISTER;
		break;
	case 6:	if(Job != Job_Guillotine) {	mes "["+strnpcinfo(1)+"]";	mes "ギロチンクロス専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHADOWCROSS;
		break;
	case 7:	if(Job != Job_RoyalGuard) {	mes "["+strnpcinfo(1)+"]";	mes "ロイヤルガード専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_IMPERIALGUARD;
		break;
	case 8:	if(Job != Job_Sorcerer) {	mes "["+strnpcinfo(1)+"]";	mes "ソーサラー専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ELEMENTALMASTER;
		break;
	case 9:	if(Job != Job_Minstrel) {	mes "["+strnpcinfo(1)+"]";	mes "ミンストレル(男)専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_TROUBADOUR;
		break;
	case 10:	if(Job != Job_Wanderer) {	mes "["+strnpcinfo(1)+"]";	mes "ワンダラー(女)専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_TROUVERE;
		break;
	case 11:	if(Job != Job_Shura) {	mes "["+strnpcinfo(1)+"]";	mes "修羅専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_INQUISITOR;
		break;
	case 12:	if(Job != Job_Genetic) {	mes "["+strnpcinfo(1)+"]";	mes "ジェネティック専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_BIOLO;
		break;
	case 13:	if(Job != Job_ShadowChaser) {	mes "["+strnpcinfo(1)+"]";	mes "シャドウチェイサー専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ABYSSCHASER;
		break;
	case 14:	if(Job != Job_StarEmperor) {	mes "["+strnpcinfo(1)+"]";	mes "星帝専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SKYEMPEROR;
		break;
	case 15:	if(Job != Job_Soulreaper) {	mes "["+strnpcinfo(1)+"]";	mes "ソウルリーパー専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SOULASCETIC;
		break;
	case 16:	if(Job != Job_Kagerou) {	mes "["+strnpcinfo(1)+"]";	mes "影狼(男)専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHINKIRO;
		break;
	case 17:	if(Job != Job_Oboro) {	mes "["+strnpcinfo(1)+"]";	mes "朧(女)専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHIRANUI;
		break;
	case 18:	if(Job != Job_Rebellion) {	mes "["+strnpcinfo(1)+"]";	mes "リベリオン専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_NIGHTWATCH;
		break;
	case 19:	if(Job != Job_ExpandedSuperNovice) {	mes "["+strnpcinfo(1)+"]";	mes "スーパーノービス(限界突破)専用です";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_HYPERNOVICE;
		break;
	case 20:	mes "[" +strnpcinfo(1)+ "]";	mes "転職処理を中止します";	close;
		}
	mes "[" +strnpcinfo(1)+ "]";
	mes "転職が完了しました";	//スキル・ステータスのリセットなし
	close;
}

-	script	4thJobChangeDoram		10461,{
	if(Job != Job_Summoner) {	mes "["+strnpcinfo(1)+"]";	mes "サモナー専用です";	close;	}
	if(Upper == UPPER_BABY) {	mes "["+strnpcinfo(1)+"]";	mes "養子職は4次職に転職できません。";	close;	}
	if(BaseLevel != 200) {	mes "["+strnpcinfo(1)+"]";	mes "BaseLevel 200が必要です。";	close;	}
	if(JobLevel < 70) {	mes "["+strnpcinfo(1)+"]";	mes "JobLevel 70以上が必要です。";	close;	}
	if(SkillPoint != 0) {	mes "["+strnpcinfo(1)+"]";	mes "スキルポイントは残さないで下さい。";	close;	}
	if(checkriding() || checkcart() || checkfalcon() || sc_ison(SC_ALL_RIDING)) {	mes "["+strnpcinfo(1)+"]";	mes "ペコペコ系、ロボ、カート";	mes "鷹 ファルコン ウォーグ、騎乗用手綱";	mes "全部外して下さい。";	close;	}
	//if(Weight) { 	mes "["+strnpcinfo(1)+"]";	mes "所持重量を0にして下さい。";	close;	}	//所持重量条件不要
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+strcharinfo(0)+"さんは";
	mes "スピリットハンドラーに転職しますか？";
	next;
	switch(select(
	"やっぱりやめる",
	"スピリットハンドラーに転職する"
	))
		{
	case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "転職処理を中止します";	close;
	case 2:	setlook 7,0;	setlook 13,0;	jobchange Job_Spirit_Handler;	break;
	mes "[" +strnpcinfo(1)+ "]";
	mes "転職が完了しました";	//スキル・ステータスのリセットなし
	close;
	}
}
//任意のマップ・座標に設置
prontera.gat,150,160,2	duplicate(4thJobChange)	4次転職NPC	10461
prontera.gat,150,150,3	duplicate(4thJobChangeDoram)	スピリットハンドラー転職NPC	10461

//ここから開発者用NPC
//4次職スクリプト

-	script	4thJOBtest		10461,{
	if(getbaseclass(Class) == CLASS_SUM) {mes "["+strnpcinfo(1)+"]";	mes "人間族専用です";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+strcharinfo(0)+"さんは";
	mes "どの職業にしますか？";
	skill 142,1,0;				//クエストスキル
	skill 143,1,0;				//クエストスキル
	cutin "update_event01.bmp",3;
	next;
	switch(select(
	"ドラゴンナイト",		//case 1
	"アークメイジ",
	"ウインドホーク",
	"カーディナル",
	"マイスター",
	"シャドウクロス",
	"インペリアルガード",
	"エレメンタルマスター",
	"トルバドゥール(男)",
	"トルヴェール(女)",
	"インクイジター",		//case 11
	"バイオロジスト",
	"アビスチェイサー",
	"天帝",
	"ソウルアセティック",
	"蜃気楼(男)",
	"不知火(女)",
	"ナイトウォッチ",
	"ハイパーノービス",
	"スピリットハンドラー",
	"ステータス・スキルリセット",	//case 21
	"未転生ノービスに戻る",		//case 22
	"フルスロットルを覚える",	//case 23
	"やめる"			//case 24
	))
		{
	case 1:
	if(Job != Job_RuneKnight) {	mes "["+strnpcinfo(1)+"]";	mes "ルーンナイト専用です";	close;	}
		setlook 7,0;				//服色をデフォルトに戻す
		setlook 13,0;				//セカンドコスチュームを戻す
		set StatusPoint,100;			//追加転生ステータスポイント
		jobchange Job_DRAGONKNIGHT;		//職業(3次4次職は未転生職に相当)
		set BaseLevel,260;			//4次職の最大BaseLevel
		set JobLevel,55;			//4次職の最大JobLevel
		set Skillpoint,0;			//スキルポイントを0にする
		gmcommand "@allskill";			//すべてのスキルを覚える
		skill 144,1,0;				//クエストスキル
		skill 145,1,0;				//クエストスキル
		skill 146,1,0;				//クエストスキル
		skill 1001,1,0;				//クエストスキル
		break;

	case 2:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_ARCHMAGE;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 157,1,0;
		skill 1006,1,0;
		break;

	case 3:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_WINDHAWK;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 147,1,0;
		skill 148,1,0;
		skill 1009,1,0;
		break;

	case 4:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_CARDINAL;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 156,1,0;
		skill 1014,1,0;
		break;

	case 5:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_MEISTER;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 153,1,0;
		skill 154,1,0;
		skill 155,1,0;
		skill 1012,1,0;
		skill 1013,1,0;
		//skill 2544,1,0;	//カードデコレーション
		break;

	case 6:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_SHADOWCROSS;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 149,1,0;
		skill 150,1,0;
		skill 151,1,0;
		skill 152,1,0;
		skill 1003,1,0;
		skill 1004,1,0;
		break;

	case 7:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_IMPERIALGUARD;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 144,1,0;
		skill 145,1,0;
		skill 146,1,0;
		skill 1002,1,0;
		break;

	case 8:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_ELEMENTALMASTER;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 157,1,0;
		skill 1007,1,0;
		skill 1008,1,0;
		skill 1017,1,0;
		skill 1018,1,0;
		skill 1019,1,0;
		break;

	case 9:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_TROUBADOUR;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 147,1,0;
		skill 148,1,0;
		skill 1010,1,0;
		break;

	case 10:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_TROUVERE;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 147,1,0;
		skill 148,1,0;
		skill 1011,1,0;
		break;

	case 11:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_INQUISITOR;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 156,1,0;
		skill 238,1,0;
		skill 1015,1,0;
		skill 1016,1,0;
		break;

	case 12:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_BIOLO;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 153,1,0;
		skill 154,1,0;
		skill 155,1,0;
		skill 238,1,0;
		//skill 2544,1,0;	//カードデコレーション
		break;

	case 13:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set StatusPoint,100;
		jobchange Job_ABYSSCHASER;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		skill 149,1,0;
		skill 150,1,0;
		skill 151,1,0;
		skill 152,1,0;
		skill 1005,1,0;
		break;

	case 14:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SKYEMPEROR;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 15:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SOULASCETIC;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 16:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHINKIRO;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 17:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHIRANUI;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 18:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_NIGHTWATCH;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 19:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_HYPERNOVICE;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 20:
	if(getbaseclass(Class) != CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "ドラム族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SPIRITHANDLER;
		set BaseLevel,260;
		set JobLevel,55;
		set Skillpoint,0;
		gmcommand "@allskill";
		break;

	case 21:
		setlook 7,0;				//服色をデフォルトに戻す
		setlook 13,0;				//セカンドコスチュームを戻す
		resetskill;				//スキルリセット
		resetstatus;				//ステータスリセット
		set Skillpoint,0;			//スキルポイントを0に変更
		set StatusPoint,0;			//ステータスポイントを0に変更
		break;

	case 22:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "人間族専用です";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set upper_job,0;			//未転生ノービスのフラグ
		jobchange Job_Novice,0;
		set JobLevel,1;
		set BaseLevel,1;
		resetskill;
		set Skillpoint,0;
		resetstatus;
		set StatusPoint,0;
		skill 142,1,0;				//応急手当
		skill 143,1,0;				//死んだふり
		break;

	case 23:
		skill 5071,1,0;				//EVT_FULL_THROTTLEフルスロットル
		break;

	case 24:
		mes "[" +strnpcinfo(1)+ "]";
		mes "転職処理を中止します";
		cutin "update_event01.bmp",255;
		close;
		}

	mes "[" +strnpcinfo(1)+ "]";
	mes "転職が完了しました";
	cutin "update_event01.bmp",255;
	close;
}

-	script	doramreset4th		10461,{

	if(getbaseclass(Class) != CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "ドラム族専用です";
	close;
	}
	
	mes "["+strnpcinfo(1)+"]";
	mes "サモナーに戻りますか？";
	cutin "ep19_tamarin01.png",2;
	next;
	switch(select(
		"やめる",		//case 1
		"サモナーに戻る",	//case 2
		)) {
		case 1:
		mes "["+strnpcinfo(1)+"]";
		mes "転職処理を中止します";
		cutin "ep19_tamarin01.png",255;
		close;

		case 2:

		if(Job == Job_Summoner) {
		mes "["+strnpcinfo(1)+"]";
		mes "あなたはすでにサモナーに";
		mes "戻っています";
		cutin "ep19_tamarin01.png",255;
		close;
		}

		setlook 7,0;
		setlook 13,0;
		jobchange Job_Summoner;
		set JobLevel,1;
		set BaseLevel,1;
		resetskill;
		set Skillpoint,0;
		resetstatus;
		set StatusPoint,0;
		skill 142,1,0;				//応急手当
		skill 143,1,0;				//死んだふり
		break;
		}
	mes "[" +strnpcinfo(1)+ "]";
	mes "転職が完了しました";
	cutin "ep19_tamarin01.png",255;
	close;
}

//prontera.gat,150,160,2	duplicate(4thJOBtest)	4次転職NPC	10461
//prontera.gat,150,150,3	duplicate(doramreset4th)	サモナー戻しNPC	10461