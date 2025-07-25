//2025/05/07 更新

// 巨大なハエの羽
function	script	ItemdbPartyCall	{
	warp "Random",0,0;
	set '@name$,strcharinfo(0);
	if('@name$ == getpartyleader(getcharid(1)) && !getmapxy('@map$,'@x,'@y,0)) {
		getpartymember getcharid(1);
		for(set '@i,0; '@i < $@partymembercount; set '@i,'@i+1) {
			if($@partymembername$['@i] == '@name$)			// 自分は除外
				continue;
			if(getmapname($@partymembername$['@i]) != '@map$)	// MAPが違う
				continue;
			if(attachrid(getcharid(3,$@partymembername$['@i]))) {
				if(!checkdead()) {
					// 死亡してないならリーダーの元へワープ
					warp '@map$,'@x,'@y;
				}
				detachrid;
			}
		}
	}
	return;
}

//============================================================
// キラキラスティック
function	script	ItemdbResetSkill	{
	if(Weight || checkcart() || checkfalcon() || checkriding())
		return;
	set '@lv,getskilllv(1);	// 基本スキル
	resetskill 0;		// クエストスキルはリセットしない
	if('@lv > 0) {
		skill 1,'@lv,0;
		set SkillPoint,SkillPoint - '@lv;
	}
	return;
}

//============================================================
//[ヒール系スキル使用時HP回復量 + n%] 全種一括指定
//{ calllfunc "AddSkillHealRate",'@val; }

function	script	AddSkillHealRate	{
	set '@val,getarg(0);
		bonus2 bAddSkillHealRate,"AL_HEAL",'@val;	/* ヒール */
		bonus2 bAddSkillHealRate,"PR_SANCTUARY",'@val;	/* サンクチュアリ */
		bonus2 bAddSkillHealRate,"AM_POTIONPITCHER",'@val;	/* ポーションピッチャー */
		bonus2 bAddSkillHealRate,"CR_SLIMPITCHER",'@val;	/* スリムポーションピッチャー */
		bonus2 bAddSkillHealRate,"BA_APPLEIDUN",'@val;	/* イドゥンの林檎 */
		bonus2 bAddSkillHealRate,"AB_CHEAL",'@val;	/* コルセオヒール */
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",'@val;	/* ハイネスヒール */
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */

		bonus2 bAddSkillDamageRate,"AL_HEAL",'@val;	/* ヒール */
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",'@val;	/* サンクチュアリ */
		bonus2 bAddSkillDamageRate,"AB_CHEAL",'@val;	/* コルセオヒール */
		bonus2 bAddSkillDamageRate,"AB_HIGHNESSHEAL",'@val;	/* ハイネスヒール */
		bonus2 bAddSkillDamageRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */
	return;
}

//============================================================
//[ヒール系スキルを受けた時のHP回復量 + n%] 全種一括指定
//{ calllfunc "AddSkillSubHealRate",'@val; }

function	script	AddSkillSubHealRate	{
	set '@val,getarg(0);
		bonus2 bAddSkillSubHealRate,"AL_HEAL",'@val;	/* ヒール */
		bonus2 bAddSkillSubHealRate,"PR_SANCTUARY",'@val;	/* サンクチュアリ */
		bonus2 bAddSkillSubHealRate,"AM_POTIONPITCHER",'@val;	/* ポーションピッチャー */
		bonus2 bAddSkillSubHealRate,"CR_SLIMPITCHER",'@val;	/* スリムポーションピッチャー */
		bonus2 bAddSkillSubHealRate,"BA_APPLEIDUN",'@val;	/* イドゥンの林檎 */
		bonus2 bAddSkillSubHealRate,"AB_CHEAL",'@val;	/* コルセオヒール */
		bonus2 bAddSkillSubHealRate,"AB_HIGHNESSHEAL",'@val;	/* ハイネスヒール */
		bonus2 bAddSkillSubHealRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */
		/* bonus2 bAddItemHealRate,'@val;	一部のアイテムの回復量 */
	return;
}

//============================================================
//物理攻撃時[全ての種族]のモンスターに与えるダメージ + '@val% プレイヤーとドラム形除く
//{ callfunc "bAddRace_All",'@val; }

function	script	bAddRace_All	{
	set '@val,getarg(0);
		bonus2 bAddRace,Rct_Formless,'@val;
		bonus2 bAddRace,Rct_Undead,'@val;
		bonus2 bAddRace,Rct_Brute,'@val;
		bonus2 bAddRace,Rct_Plant,'@val;
		bonus2 bAddRace,Rct_Insect,'@val;
		bonus2 bAddRace,Rct_Fish,'@val;
		bonus2 bAddRace,Rct_Demon,'@val;
		bonus2 bAddRace,Rct_Angel,'@val;
		bonus2 bAddRace,Rct_Dragon,'@val;
		bonus2 bAddRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//魔法攻撃時[全ての種族]のモンスターに与えるダメージ + '@val% プレイヤーとドラム形除く
//{ callfunc "bMagicAddRace_All",'@val; }

function	script	bMagicAddRace_All	{
	set '@val,getarg(0);
		bonus2 bMagicAddRace,Rct_Formless,'@val;
		bonus2 bMagicAddRace,Rct_Undead,'@val;
		bonus2 bMagicAddRace,Rct_Brute,'@val;
		bonus2 bMagicAddRace,Rct_Plant,'@val;
		bonus2 bMagicAddRace,Rct_Insect,'@val;
		bonus2 bMagicAddRace,Rct_Fish,'@val;
		bonus2 bMagicAddRace,Rct_Demon,'@val;
		bonus2 bMagicAddRace,Rct_Angel,'@val;
		bonus2 bMagicAddRace,Rct_Dragon,'@val;
		bonus2 bMagicAddRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//一般・ボスモンスターの防御を DEF '@val% 無視
//{ callfunc "IgnoreDefRct_All",'@val; }

function	script	IgnoreDefRct_All	{
	set '@val,getarg(0);
	bonus2 bIgnoreDefRace,Rct_Boss,'@val;
	bonus2 bIgnoreDefRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//一般・ボスモンスターの魔法防御を '@val% 無視
//{ callfunc "IgnoreMDefRct_All",'@val; }

function	script	IgnoreMDefRct_All	{
	set '@val,getarg(0);
	bonus2 bIgnoreMdefRace,Rct_Boss,'@val;
	bonus2 bIgnoreMdefRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//[全ての種族]のモンスターのDEF 防御力 '@val%無視 プレイヤーとドラム形除く
//{ callfunc "bonus2bIgnoreDefRace",'@val; }

function	script	bonus2bIgnoreDefRace	{
	set '@val,getarg(0);
		bonus2 bIgnoreDefRace,Rct_Formless,'@val;
		bonus2 bIgnoreDefRace,Rct_Undead,'@val;
		bonus2 bIgnoreDefRace,Rct_Brute,'@val;
		bonus2 bIgnoreDefRace,Rct_Plant,'@val;
		bonus2 bIgnoreDefRace,Rct_Insect,'@val;
		bonus2 bIgnoreDefRace,Rct_Fish,'@val;
		bonus2 bIgnoreDefRace,Rct_Demon,'@val;
		bonus2 bIgnoreDefRace,Rct_Angel,'@val;
		bonus2 bIgnoreDefRace,Rct_Dragon,'@val;
		bonus2 bIgnoreDefRace,Rct_DemiHuman,'@val;

	return;
}

//============================================================
//[全ての種族]のモンスターのMDEF 魔法防御力'@val%無視 プレイヤーとドラム形除く
//{ callfunc "bonus2bIgnoreMdefRace",'@val; }

function	script	bonus2bIgnoreMdefRace	{
	set '@val,getarg(0);
		bonus2 bIgnoreMdefRace,Rct_Formless,'@val;
		bonus2 bIgnoreMdefRace,Rct_Undead,'@val;
		bonus2 bIgnoreMdefRace,Rct_Brute,'@val;
		bonus2 bIgnoreMdefRace,Rct_Plant,'@val;
		bonus2 bIgnoreMdefRace,Rct_Insect,'@val;
		bonus2 bIgnoreMdefRace,Rct_Fish,'@val;
		bonus2 bIgnoreMdefRace,Rct_Demon,'@val;
		bonus2 bIgnoreMdefRace,Rct_Angel,'@val;
		bonus2 bIgnoreMdefRace,Rct_Dragon,'@val;
		bonus2 bIgnoreMdefRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//[すべての種族]のモンスターから受ける物理ダメージ '@val%減 プレイヤー形とドラム形除く
//{ callfunc "bonus2bSubRace",'@val; }

function	script	bonus2bSubRace	{
	set '@val,getarg(0);
		bonus2 bSubRace,Rct_Formless,'@val;
		bonus2 bSubRace,Rct_Undead,'@val;
		bonus2 bSubRace,Rct_Brute,'@val;
		bonus2 bSubRace,Rct_Plant,'@val;
		bonus2 bSubRace,Rct_Insect,'@val;
		bonus2 bSubRace,Rct_Fish,'@val;
		bonus2 bSubRace,Rct_Demon,'@val;
		bonus2 bSubRace,Rct_Angel,'@val;
		bonus2 bSubRace,Rct_Dragon,'@val;
		bonus2 bSubRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//[すべての種族]のモンスターから受ける魔法ダメージ '@val%減 プレイヤー形とドラム形除く
//{ callfunc "bonus2bMagicSubRace",'@val; }

function	script	bonus2bMagicSubRace	{
	set '@val,getarg(0);
		bonus2 bMagicSubRace,Rct_Formless,'@val;
		bonus2 bMagicSubRace,Rct_Undead,'@val;
		bonus2 bMagicSubRace,Rct_Brute,'@val;
		bonus2 bMagicSubRace,Rct_Plant,'@val;
		bonus2 bMagicSubRace,Rct_Insect,'@val;
		bonus2 bMagicSubRace,Rct_Fish,'@val;
		bonus2 bMagicSubRace,Rct_Demon,'@val;
		bonus2 bMagicSubRace,Rct_Angel,'@val;
		bonus2 bMagicSubRace,Rct_Dragon,'@val;
		bonus2 bMagicSubRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//一部のダメージを反射する効果で受けるダメージ 精錬値*-10%
//精錬値は記述されている装備品を参照するので参照が自身のアイテム以外は記述を抜き出して装備ボーナスに書いて下さい
//主にロイヤル系武器
//{ callfunc "redamage"; }

function	script	redamage	{
	bonus2 bSubSkillDamageRate,"CR_REFLECTSHIELD",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"LG_REFLECTDAMAGE",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"NPC_MAGICMIRROR",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"SL_KAITE",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"SR_CRESCENTELBOW",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"ST_REJECTSWORD",10*getequiprefinerycnt();
	return;
}

//============================================================
//一部のダメージを反射する効果で受けるダメージ
//rate 指定する 
//ロイヤル系武器 以外
//{ callfunc "refskllsubdamagerate",'@rate; }

function	script	refskllsubdamagerate	{
	bonus2 bSubSkillDamageRate,"CR_REFLECTSHIELD",'@rate;
	bonus2 bSubSkillDamageRate,"LG_REFLECTDAMAGE",'@rate;
	bonus2 bSubSkillDamageRate,"NPC_MAGICMIRROR",'@rate;
	bonus2 bSubSkillDamageRate,"SL_KAITE",'@rate;
	bonus2 bSubSkillDamageRate,"SR_CRESCENTELBOW",'@rate;
	bonus2 bSubSkillDamageRate,"ST_REJECTSWORD",'@rate;
	return;
}

//============================================================
//310760#王の神威#セット効果A
//攻撃速度 + 15% プレイヤーから受けるダメージ - 10% [ゴスペル]Lv1使用可能
//{ callfunc "ounosini_A"; }

function	script	ounosini_A	{
if(equippeditem(310760)) {
	bonus bAspdAddRate,15;
	bonus2 bSubRace,Rct_Player,10;
	bonus2 bMagicSubRace,Rct_Player,10;
	skill "PA_GOSPEL",1;
	}
	return;
}

//============================================================
//310760#王の神威#セット効果B
//攻撃速度 + 15% プレイヤーから受けるダメージ - 40% [ゴスペル]Lv1使用可能
//{ callfunc "ounosini_B"; }

function	script	ounosini_B	{
if(equippeditem(310760)) {
	bonus bAspdAddRate,15;
	bonus2 bSubRace,Rct_Player,40;
	bonus2 bMagicSubRace,Rct_Player,40;
	skill "PA_GOSPEL",1;
	}
	return;
}

//============================================================
//300314#理性と記憶の残滓#セット効果A
//Atk + 100 , Matk + 100 プレイヤーから受けるダメージ - 10% [コンセントレイション]Lv5
//{ callfunc "riseikioku_A"; }

function	script	riseikioku_A	{
if(equippeditem(300314)) {
	bonus bBaseAtk,100;
	bonus bMatk,100;
	bonus2 bSubRace,Rct_Player,10;
	bonus2 bMagicSubRace,Rct_Player,10;
	skill "LK_CONCENTRATION",5;
	}
	return;
}

//============================================================
//300314#理性と記憶の残滓#セット効果B
//Atk + 200 , Matk + 200 プレイヤーから受けるダメージ - 40% [コンセントレイション]Lv5
//{ callfunc "riseikioku_B"; }

function	script	riseikioku_B	{
if(equippeditem(300314)) {
	bonus bBaseAtk,200;
	bonus bMatk,200;
	bonus2 bSubRace,Rct_Player,40;
	bonus2 bMagicSubRace,Rct_Player,40;
	skill "LK_CONCENTRATION",5;
	}
	return;
}

//============================================================
//300314#理性と記憶の残滓#セット効果C
//Atk + 100 , Matk + 100 プレイヤーから受けるダメージ - 40% [コンセントレイション]Lv5
//{ callfunc "riseikioku_C"; }

function	script	riseikioku_C	{
if(equippeditem(300314)) {
	bonus bBaseAtk,100;
	bonus bMatk,100;
	bonus2 bSubRace,Rct_Player,40;
	bonus2 bMagicSubRace,Rct_Player,40;
	skill "LK_CONCENTRATION",5;
	}
	return;
}

//============================================================
//312417#増幅された怨望#セット効果A
//{ callfunc "zoufuku_A"; }

function	script	zoufuku_A	{
if(equippeditem(312417)) {
	bonus2 bAddRace,Rct_Boss,5*getequiprefinerycnt();
	bonus2 bAddRace,Rct_NonBoss,5*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Boss,5*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_NonBoss,5*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"CR_REFLECTSHIELD",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"LG_REFLECTDAMAGE",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"NPC_MAGICMIRROR",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"SL_KAITE",10*getequiprefinerycnt();
	bonus2 bSubSkillDamageRate,"SR_CRESCENTELBOW",10*getequiprefinerycnt();
	}
	return;
}
//============================================================
//410028#ワンダーエッグバスケット#
//{ callfunc "Wonder_Egg_Basket_A"; }
function	script	Wonder_Egg_Basket_A	{
	bonus bBaseAtk,200;
	bonus bMatk,200;
	bonus bAllStatus,10;
	return;
}

//{ callfunc "Wonder_Egg_Basket_B"; }
function	script	Wonder_Egg_Basket_B	{
	bonus bBaseAtk,200;
	bonus bMatk,200;
	bonus bAllStatus,10;
	bonus2 bSubSize,Size_Small,10;
	bonus2 bSubSize,Size_Medium,10;
	bonus2 bSubSize,Size_Big,10;
	bonus2 bMagicSubSize,Size_Small,10;
	bonus2 bMagicSubSize,Size_Medium,10;
	bonus2 bMagicSubSize,Size_Big,10;
	return;
}

//{ callfunc "Wonder_Egg_Basket_C"; }
function	script	Wonder_Egg_Basket_C	{
	bonus bBaseAtk,200;
	bonus bMatk,200;
	bonus bDef,150;
	bonus bMdef,15;
	return;
}

//============================================================
//410014 410015 #コル・コアヘッドフォン#
//{ callfunc "Cor_Core_Headset"; }
function	script	Cor_Core_Headset	{
	if(equippeditem(410014) || equippeditem(410015)) {
		bonus bBaseAtk,200;
		bonus bMatk,200;
		}
	return;
}

//============================================================
//bonus3 bAddMonsterDropItem
//{ callfunc "drop",'@id,'@rate; }

function	script	drop	{
	set '@id,getarg(0);
	set '@rate,getarg(1);
		bonus3 bAddMonsterDropItem,'@id,Rct_Boss,'@rate;
		bonus3 bAddMonsterDropItem,'@id,Rct_NonBoss,'@rate;
	return;
}

//============================================================
//19108#ワイルドポリンライダー#
//item_db.txtで書けない場合はこちらを使う
//{ callfunc "head19108"; }

function	script	head19108	{
if(getbaseclass(Class,2) == CLASS_SNV) { 
	bonus3 bAddMonsterDropItem,12709,Rct_NonBoss,50;
}
if(getbaseclass(Class,2) == CLASS_KN) {
	bonus3 bAddMonsterDropItem,714,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7002,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1034,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7069,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7030,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7221,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7210,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7123,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1035,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,518,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7938,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7099,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1048,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1096,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7097,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,716,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_CR) {
	bonus3 bAddMonsterDropItem,536,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,534,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,532,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,531,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_WZ) {
	bonus3 bAddMonsterDropItem,715,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,716,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,717,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_SA) {
	bonus3 bAddMonsterDropItem,947,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,946,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1013,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,904,Rct_NonBoss,50;
}
if(getbaseclass(Class,2) == CLASS_HT) {
	bonus3 bAddMonsterDropItem,12008,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12012,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12010,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12011,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,23061,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_BA || CLASS_DC) {
	bonus3 bAddMonsterDropItem,12008,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12012,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12010,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12011,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,23061,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12014,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_PR) {
	bonus3 bAddMonsterDropItem,523,Rct_NonBoss,50;
	bonus bDef,1000;
}
if(getbaseclass(Class,2) == CLASS_MO) {
	bonus3 bAddMonsterDropItem,605,Rct_NonBoss,50;
}
if(getbaseclass(Class,2) == CLASS_AS) {
	bonus3 bAddMonsterDropItem,7003,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,709,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7155,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7033,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7937,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7936,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7935,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7934,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7933,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7932,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,950,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7565,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,957,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_RG) {
	bonus3 bAddMonsterDropItem,23059,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,23060,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_BS) {
	bonus3 bAddMonsterDropItem,999,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,998,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,7054,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2) == CLASS_AM) {
	bonus3 bAddMonsterDropItem,507,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,508,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,509,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,510,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,511,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,952,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1061,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1017,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2||3) == CLASS_SG) {
	bonus3 bAddMonsterDropItem,994,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,995,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,996,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,997,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1000,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,1001,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2||3) == CLASS_SL) {
	bonus3 bAddMonsterDropItem,748,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,732,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,929,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2||3) == CLASS_NJ) {
	bonus3 bAddMonsterDropItem,12638,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12639,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12640,Rct_NonBoss,50;
	}
if(getbaseclass(Class,2||3) == CLASS_GS) {
	bonus3 bAddMonsterDropItem,12151,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12150,Rct_NonBoss,50;
	bonus3 bAddMonsterDropItem,12637,Rct_NonBoss,50;
	}
	return;
}

//============================================================
//[虐殺]Lv1
//{ callfunc "gyakusatuLv1"; }

function	script	gyakusatuLv1	{
	if(getequiprefinerycnt() >= 7) {
		bonus2 bAddRace,Rct_Human,9;
	}
	if(getequiprefinerycnt() >= 8) {
		bonus2 bAddRace,Rct_Human,16;
	}
	if(getequiprefinerycnt() >= 9) {
		bonus2 bAddRace,Rct_Human,25;
	}
	if(getequiprefinerycnt() >= 10) {
		bonus2 bAddRace,Rct_Human,36;
	}
	return;
}

//============================================================
//[虐殺]Lv2
//{ callfunc "gyakusatuLv2"; }

function	script	gyakusatuLv2	{
	if(getequiprefinerycnt() >= 7) {
		bonus2 bAddRace,Rct_Human,16;
	}
	if(getequiprefinerycnt() >= 8) {
		bonus2 bAddRace,Rct_Human,25;
	}
	if(getequiprefinerycnt() >= 9) {
		bonus2 bAddRace,Rct_Human,36;
	}
	if(getequiprefinerycnt() >= 10) {
		bonus2 bAddRace,Rct_Human,49;
	}
	return;
}

//============================================================
//[破滅]Lv1
//{ callfunc "hametuLv1"; }

function	script	hametuLv1	{
	if(getequiprefinerycnt() >= 7) {
		bonus2 bMagicAddRace,Rct_Human,4;
	}
	if(getequiprefinerycnt() >= 8) {
		bonus2 bMagicAddRace,Rct_Human,6;
	}
	if(getequiprefinerycnt() >= 9) {
		bonus2 bMagicAddRace,Rct_Human,8;
	}
	if(getequiprefinerycnt() >= 10) {
		bonus2 bMagicAddRace,Rct_Human,10;
	}
	return;
}

//============================================================
//[祝福]Lv1
//{ callfunc "shukufukuLv1"; }
//対象スキルは調査して推定

function	script	shukufukuLv1	{
	if(getequiprefinerycnt() >= 7) {
		bonus2 bAddSkillDamageRate,"AL_HEAL",4;
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",4;
		bonus2 bAddSkillHealRate,"AB_CHEAL",4;
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",4;
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",4;
	}
	if(getequiprefinerycnt() >= 8) {
		bonus2 bAddSkillDamageRate,"AL_HEAL",6;
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",6;
		bonus2 bAddSkillHealRate,"AB_CHEAL",6;
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",6;
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",6;
	}
	if(getequiprefinerycnt() >= 9) {
		bonus2 bAddSkillDamageRate,"AL_HEAL",8;
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",8;
		bonus2 bAddSkillHealRate,"AB_CHEAL",8;
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",8;
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",8;
	}
	if(getequiprefinerycnt() >= 10) {
		bonus2 bAddSkillDamageRate,"AL_HEAL",10;
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",10;
		bonus2 bAddSkillHealRate,"AB_CHEAL",10;
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",10;
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",10;
	}
	return;
}

//============================================================
// グレイシア系両手武器
//{ callfunc "Glacier202409"; }
//超越段階の条件が実装できたら効果を追記してください
function	script	Glacier202409	{
	bonus2 bSubRace,Rct_Player,40;
	bonus2 bMagicSubRace,Rct_Player,40;
	bonus2 bAddRace,Rct_Formless,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Undead,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Brute,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Plant,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Fish,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Demon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Angel,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Dragon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_DemiHuman,6*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Formless,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Undead,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Brute,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Plant,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Insect,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Fish,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Demon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Angel,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Dragon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_DemiHuman,3*getequiprefinerycnt();
	if(equippeditem(311439)) {
		bonus2 bIgnoreDefRace,Rct_Formless,100;
		bonus2 bIgnoreDefRace,Rct_Undead,100;
		bonus2 bIgnoreDefRace,Rct_Brute,100;
		bonus2 bIgnoreDefRace,Rct_Plant,100;
		bonus2 bIgnoreDefRace,Rct_Insect,100;
		bonus2 bIgnoreDefRace,Rct_Fish,100;
		bonus2 bIgnoreDefRace,Rct_Demon,100;
		bonus2 bIgnoreDefRace,Rct_Angel,100;
		bonus2 bIgnoreDefRace,Rct_Dragon,100;
		bonus2 bIgnoreDefRace,Rct_DemiHuman,100;
		bonus2 bIgnoreMdefRace,Rct_Formless,100;
		bonus2 bIgnoreMdefRace,Rct_Undead,100;
		bonus2 bIgnoreMdefRace,Rct_Brute,100;
		bonus2 bIgnoreMdefRace,Rct_Plant,100;
		bonus2 bIgnoreMdefRace,Rct_Insect,100;
		bonus2 bIgnoreMdefRace,Rct_Fish,100;
		bonus2 bIgnoreMdefRace,Rct_Demon,100;
		bonus2 bIgnoreMdefRace,Rct_Angel,100;
		bonus2 bIgnoreMdefRace,Rct_Dragon,100;
		bonus2 bIgnoreMdefRace,Rct_DemiHuman,100;
		bonus bBaseAtk,BaseLevel;
		bonus bMatk,BaseLevel;
	}
	return;
}

//============================================================
// ディムグレイシア系両手武器
//{ callfunc "D_Glacier202409"; }
//超越段階の条件が実装できたら効果を追記してください
function	script	D_Glacier202409	{
	bonus2 bSubRace,Rct_Player,40;
	bonus2 bMagicSubRace,Rct_Player,40;
	bonus2 bAddRace,Rct_Formless,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Undead,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Brute,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Plant,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Fish,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Demon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Angel,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Dragon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_DemiHuman,6*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Formless,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Undead,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Brute,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Plant,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Insect,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Fish,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Demon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Angel,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Dragon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_DemiHuman,3*getequiprefinerycnt();
	if(equippeditem(311439)) {
		bonus2 bIgnoreDefRace,Rct_Formless,100;
		bonus2 bIgnoreDefRace,Rct_Undead,100;
		bonus2 bIgnoreDefRace,Rct_Brute,100;
		bonus2 bIgnoreDefRace,Rct_Plant,100;
		bonus2 bIgnoreDefRace,Rct_Insect,100;
		bonus2 bIgnoreDefRace,Rct_Fish,100;
		bonus2 bIgnoreDefRace,Rct_Demon,100;
		bonus2 bIgnoreDefRace,Rct_Angel,100;
		bonus2 bIgnoreDefRace,Rct_Dragon,100;
		bonus2 bIgnoreDefRace,Rct_DemiHuman,100;
		bonus2 bIgnoreMdefRace,Rct_Formless,100;
		bonus2 bIgnoreMdefRace,Rct_Undead,100;
		bonus2 bIgnoreMdefRace,Rct_Brute,100;
		bonus2 bIgnoreMdefRace,Rct_Plant,100;
		bonus2 bIgnoreMdefRace,Rct_Insect,100;
		bonus2 bIgnoreMdefRace,Rct_Fish,100;
		bonus2 bIgnoreMdefRace,Rct_Demon,100;
		bonus2 bIgnoreMdefRace,Rct_Angel,100;
		bonus2 bIgnoreMdefRace,Rct_Dragon,100;
		bonus2 bIgnoreMdefRace,Rct_DemiHuman,100;
		bonus bBaseAtk,BaseLevel;
		bonus bMatk,BaseLevel;
	}
	return;
}

//============================================================
// グレイシアベーシック系片手武器
//{ callfunc "Glacier_B202409"; }
//超越段階の条件が実装できたら効果を追記してください
function	script	Glacier_B202409	{
	bonus2 bSubRace,Rct_Player,10;
	bonus2 bMagicSubRace,Rct_Player,10;
	bonus2 bAddRace,Rct_Formless,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Undead,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Brute,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Plant,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Fish,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Demon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Angel,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Dragon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_DemiHuman,6*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Formless,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Undead,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Brute,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Plant,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Insect,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Fish,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Demon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Angel,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Dragon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_DemiHuman,3*getequiprefinerycnt();
	if(equippeditem(311439)) {
		bonus2 bIgnoreDefRace,Rct_Formless,100;
		bonus2 bIgnoreDefRace,Rct_Undead,100;
		bonus2 bIgnoreDefRace,Rct_Brute,100;
		bonus2 bIgnoreDefRace,Rct_Plant,100;
		bonus2 bIgnoreDefRace,Rct_Insect,100;
		bonus2 bIgnoreDefRace,Rct_Fish,100;
		bonus2 bIgnoreDefRace,Rct_Demon,100;
		bonus2 bIgnoreDefRace,Rct_Angel,100;
		bonus2 bIgnoreDefRace,Rct_Dragon,100;
		bonus2 bIgnoreDefRace,Rct_DemiHuman,100;
		bonus2 bIgnoreMdefRace,Rct_Formless,100;
		bonus2 bIgnoreMdefRace,Rct_Undead,100;
		bonus2 bIgnoreMdefRace,Rct_Brute,100;
		bonus2 bIgnoreMdefRace,Rct_Plant,100;
		bonus2 bIgnoreMdefRace,Rct_Insect,100;
		bonus2 bIgnoreMdefRace,Rct_Fish,100;
		bonus2 bIgnoreMdefRace,Rct_Demon,100;
		bonus2 bIgnoreMdefRace,Rct_Angel,100;
		bonus2 bIgnoreMdefRace,Rct_Dragon,100;
		bonus2 bIgnoreMdefRace,Rct_DemiHuman,100;
		bonus bBaseAtk,BaseLevel;
		bonus bMatk,BaseLevel;
	}
	return;
}

//============================================================
// ディムグレイシアグレイシアベーシック系片手武器
//{ callfunc "D_Glacier_B202409"; }
//超越段階の条件が実装できたら効果を追記してください
function	script	D_Glacier_B202409	{
	bonus2 bSubRace,Rct_Player,10;
	bonus2 bMagicSubRace,Rct_Player,10;
	bonus2 bAddRace,Rct_Formless,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Undead,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Brute,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Plant,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Fish,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Demon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Angel,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_Dragon,6*getequiprefinerycnt();
	bonus2 bAddRace,Rct_DemiHuman,6*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Formless,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Undead,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Brute,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Plant,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Insect,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Fish,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Demon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Angel,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_Dragon,3*getequiprefinerycnt();
	bonus2 bMagicAddRace,Rct_DemiHuman,3*getequiprefinerycnt();
	if(equippeditem(311439)) {
		bonus2 bIgnoreDefRace,Rct_Formless,100;
		bonus2 bIgnoreDefRace,Rct_Undead,100;
		bonus2 bIgnoreDefRace,Rct_Brute,100;
		bonus2 bIgnoreDefRace,Rct_Plant,100;
		bonus2 bIgnoreDefRace,Rct_Insect,100;
		bonus2 bIgnoreDefRace,Rct_Fish,100;
		bonus2 bIgnoreDefRace,Rct_Demon,100;
		bonus2 bIgnoreDefRace,Rct_Angel,100;
		bonus2 bIgnoreDefRace,Rct_Dragon,100;
		bonus2 bIgnoreDefRace,Rct_DemiHuman,100;
		bonus2 bIgnoreMdefRace,Rct_Formless,100;
		bonus2 bIgnoreMdefRace,Rct_Undead,100;
		bonus2 bIgnoreMdefRace,Rct_Brute,100;
		bonus2 bIgnoreMdefRace,Rct_Plant,100;
		bonus2 bIgnoreMdefRace,Rct_Insect,100;
		bonus2 bIgnoreMdefRace,Rct_Fish,100;
		bonus2 bIgnoreMdefRace,Rct_Demon,100;
		bonus2 bIgnoreMdefRace,Rct_Angel,100;
		bonus2 bIgnoreMdefRace,Rct_Dragon,100;
		bonus2 bIgnoreMdefRace,Rct_DemiHuman,100;
		bonus bBaseAtk,BaseLevel;
		bonus bMatk,BaseLevel;
	}
	return;
}

//============================================================
//[全ての種族]のモンスターのMres 特性魔法防御力'@val%無視 プレイヤーとドラム形除く
//{ callfunc "bonus2bIgnoreMresRace",'@val; }

function	script	bonus2bIgnoreMresRace	{
	set '@val,getarg(0);
		bonus2 bIgnoreMresRace,Rct_Formless,'@val;
		bonus2 bIgnoreMresRace,Rct_Undead,'@val;
		bonus2 bIgnoreMresRace,Rct_Brute,'@val;
		bonus2 bIgnoreMresRace,Rct_Plant,'@val;
		bonus2 bIgnoreMresRace,Rct_Insect,'@val;
		bonus2 bIgnoreMresRace,Rct_Fish,'@val;
		bonus2 bIgnoreMresRace,Rct_Demon,'@val;
		bonus2 bIgnoreMresRace,Rct_Angel,'@val;
		bonus2 bIgnoreMresRace,Rct_Dragon,'@val;
		bonus2 bIgnoreMresRace,Rct_DemiHuman,'@val;
	return;
}

//============================================================
//18133#迅雷弓# 18142#無双弓# 18144#一碧弓# 18152#猟乱弓#のセット効果の属性付与を有効にする場合 ここから
//矢[1750]-[1774]全部全種に追記
//{ callfunc "arrow_ele"; }
//対象の弓装備時、矢の属性を[SC_WindWeapon][SC_GroundWeapon][SC_WaterWeapon][SC_FireWeapon]にし、装備していない場合は元の属性[bonus bAtkEle,属性;]が有効になる
//属性の設定がない矢にも追記し、その他の装備効果は残す
//例
//1750,ammo,矢,10,1,,1,25:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; }
//1751,ammo,銀の矢,10,3,,2,30:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; }
//1760,ammo,フラッシュアロー,10,10,,3,1:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; bonus2 bAddEff,Eff_Blind,2000; }

function	script	arrow_ele	{
	if((equippeditem(18133) == 0) || (equippeditem(18142) == 0) || (equippeditem(18144) == 0) || (equippeditem(18152) == 0)) {
		if(getequipid(11) == 1751) { bonus bAtkEle,Ele_Holy; }
		if(getequipid(11) == 1752) { bonus bAtkEle,Ele_Fire; }
		if(getequipid(11) == 1754) { bonus bAtkEle,Ele_Water; }
		if(getequipid(11) == 1755) { bonus bAtkEle,Ele_Wind; }
		if(getequipid(11) == 1756) { bonus bAtkEle,Ele_Earth; }
		if(getequipid(11) == 1757) { bonus bAtkEle,Ele_Ghost; }
		if(getequipid(11) == 1759) { bonus bAtkEle,Ele_Water; }
		if(getequipid(11) == 1762) { bonus bAtkEle,Ele_Poison; }
		if(getequipid(11) == 1763) { bonus bAtkEle,Ele_Poison; }
		if(getequipid(11) == 1766) { bonus bAtkEle,Ele_Holy; }
		if(getequipid(11) == 1767) { bonus bAtkEle,Ele_Dark; }
		if(getequipid(11) == 1772) { bonus bAtkEle,Ele_Holy; }
		}
	if(equippeditem(18133)) { sc_start SC_WindWeapon,10800000,1; }
	if(equippeditem(18142)) { sc_start SC_GroundWeapon,10800000,1; }
	if(equippeditem(18144)) { sc_start SC_WaterWeapon,10800000,1; }
	if(equippeditem(18152)) { sc_start SC_FireWeapon,10800000,1; }
	return;
}

//18133#迅雷弓# 18142#無双弓# 18144#一碧弓# 18152#猟乱弓# を外したときにセット効果の属性付与を消す記述
//{ callfunc "arrow_off"; } 対象弓に追記
function	script	arrow_off	{
if((getequipid(11) >= 1750) || (getequipid(11) <= 1774)) {
	if(equippeditem(18133)) {
		bonus bAutoStatusCalcPc,SC_WindWeapon;
		sc_end SC_WindWeapon;
		}
	if(equippeditem(18142)) {
		bonus bAutoStatusCalcPc,SC_GroundWeapon;
		sc_end SC_GroundWeapon;
		}
	if(equippeditem(18144)) {
		bonus bAutoStatusCalcPc,SC_WaterWeapon;
		sc_end WaterWeapon;
		}
	if(equippeditem(18152)) {
		bonus bAutoStatusCalcPc,SC_FireWeapon;
		sc_end SC_FireWeapon;
		}
	}
	return;
}

//18133#迅雷弓# 18142#無双弓# 18144#一碧弓# 18152#猟乱弓#のセット効果の属性付与を有効にする場合 ここまで

//============================================================
//13130#迅雷銃# 13133#無双銃# 13139#一碧銃# 13143#猟乱銃#のセット効果の属性付与を有効にする場合 ここから
//弾[13200]-[13232]全部全種に追記
//スフィア系 13201 13202 実装廃止されています
//{ callfunc "ammo_ele"; }

function	script	ammo_ele	{
	if((equippeditem(13130) == 0) || (equippeditem(13133) == 0) || (equippeditem(13139) == 0) || (equippeditem(13143) == 0)) {
		if(getequipid(11) == 13216) { bonus bAtkEle,Ele_Fire; }
		if(getequipid(11) == 13217) { bonus bAtkEle,Ele_Water; }
		if(getequipid(11) == 13218) { bonus bAtkEle,Ele_Wind; }
		if(getequipid(11) == 13219) { bonus bAtkEle,Ele_Earth; }
		if(getequipid(11) == 13220) { bonus bAtkEle,Ele_Holy; }
		if(getequipid(11) == 13221) { bonus bAtkEle,Ele_Holy; }
		if(getequipid(11) == 13228) { bonus bAtkEle,Ele_Fire; }
		if(getequipid(11) == 13229) { bonus bAtkEle,Ele_Wind; }
		if(getequipid(11) == 13230) { bonus bAtkEle,Ele_Water; }
		if(getequipid(11) == 13231) { bonus bAtkEle,Ele_Poison; }
		if(getequipid(11) == 13232) { bonus bAtkEle,Ele_Dark; }
		}
	if(equippeditem(13130)) { sc_start SC_WindWeapon,10800000,1; }
	if(equippeditem(13133)) { sc_start SC_GroundWeapon,10800000,1; }
	if(equippeditem(13139)) { sc_start SC_WaterWeapon,10800000,1; }
	if(equippeditem(13143)) { sc_start SC_FireWeapon,10800000,1; }
	return;
}

//13130#迅雷銃# 13133#無双銃# 13139#一碧銃# 13143#猟乱銃#
//{ callfunc "ammo_off"; } 対象弓に追記

function	script	ammo_off	{
if((getequipid(11) >= 13200) || (getequipid(11) <= 13132)) {
	if(equippeditem(13130)) {
		bonus bAutoStatusCalcPc,SC_WindWeapon;
		sc_end SC_WindWeapon;
		}
	if(equippeditem(13133)) {
		bonus bAutoStatusCalcPc,SC_GroundWeapon;
		sc_end SC_GroundWeapon;
		}
	if(equippeditem(13139)) {
		bonus bAutoStatusCalcPc,SC_WaterWeapon;
		sc_end WaterWeapon;
		}
	if(equippeditem(13143)) {
		bonus bAutoStatusCalcPc,SC_FireWeapon;
		sc_end SC_FireWeapon;
		}
	}
	return;
}

//13130#迅雷銃# 13133#無双銃# 13139#一碧銃# 13143#猟乱銃#のセット効果の属性付与を有効にする場合 ここまで
