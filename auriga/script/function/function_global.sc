//2025/05/07 アップデート AIを使って最適化実施

//==============================================================================
// アイテム買取・交換用ファンクション
// 　プレイヤーの所持品およびZenyを調べて、目的アイテムの取得可能最大数を返す
//　（比較対象が3つ以上ある場合に利用すること）
//	callfunc "MathMax",ItemID-Array,Amount-Array,Zeny;
//
// ■ 引数の詳細
//	ItemID-Array 	-> 必要アイテムIDを格納した配列
//	Amount-Array 	-> 必要アイテム個数を格納した配列
//	Zeny		-> 必要Zeny（配列ではない）、判定しない場合は0を入れる
//
// ■ 使用例
//	setarray '@itemid,512,602,1010;
//	setarray '@amount,3,1,5;
//	callfunc "MathMax",'@itemid,'@amount,300;
//
//		-> りんご3個、蝶の羽1個、ブラコン5個、300zで目的アイテム1個取得
//------------------------------------------------------------------------------

function	script	MathMax	{
set '@size, getarraysize(getarg(0));
// '@max配列に各アイテムにおける最大数を入れる
for (set '@i, 0; '@i < '@size; set '@i, '@i + 1) {
	set @max['@i], countitem(getelementofarray(getarg(0), '@i)) / getelementofarray(getarg(1), '@i);
}
if (getarg(2))
	set '@max['@size], Zeny / getarg(2); // Zenyを使う場合は末尾に追加
else
	set '@size, '@size - 1; // Zeny判定しないなら末尾分は無視

for (set '@i, 0; '@i < '@size; set '@i, '@i + 1) {
	if ('@max[0] > '@max[1])
		deletearray '@max[0], 1;
	else
		deletearray '@max[1], 1;
}
return '@max[0];
}

//============================================================
//個別に指定する時のみ
//[ヒール系スキル使用時HP回復量 + n%]
//{ callfunc "ItemdbAlmightyHeal",数字,回復%; }
//[1ヒール][2サンクチュアリ][4ポーションピッチャー][8スリムポーションピッチャー]
//[16イドゥンの林檎][32コルセオヒール][64ハイネスヒール][128メディアリボトゥム ]
//対象にしたい数字を足す[1ヒール]と[32コルセオヒール]が5%増える { callfunc "ItemdbAlmightyHeal",33,5; }
//[ヒール系スキル使用時HP回復量 +30%] { callfunc "ItemdbAlmightyHeal",127,5; }16進数で記述 { callfunc "ItemdbAlmightyHeal",0x7F,5; }

function	script	ItemdbAlmightyHeal	{
	set '@flag,getarg(0);
	set '@val,getarg(1);
	if('@flag&1) {
		bonus2 bAddSkillHealRate,28,'@val;	/* ヒール */
		bonus2 bAddSkillDamageRate,28,'@val;	/* ヒール */
	}
	if('@flag&2) {
		bonus2 bAddSkillHealRate,70,'@val;	/* サンクチュアリ */
		bonus2 bAddSkillDamageRate,70,'@val;	/* サンクチュアリ */
	}
	if('@flag&4)
		bonus2 bAddSkillHealRate,231,'@val;	/* ポーションピッチャー */
	if('@flag&8)
		bonus2 bAddSkillHealRate,478,'@val;	/* スリムポーションピッチャー */
	if('@flag&16)
		bonus2 bAddSkillHealRate,322,'@val;	/* イドゥンの林檎 */
	if('@flag&32) {
		bonus2 bAddSkillHealRate,2043,'@val;	/* コルセオヒール */
		bonus2 bAddSkillDamageRate,2043,'@val;	/* コルセオヒール */
	}
	if('@flag&64) {
		bonus2 bAddSkillHealRate,2051,'@val;	/* ハイネスヒール */
		bonus2 bAddSkillDamageRate,2051,'@val;	/* ハイネスヒール */
	}
	if('@flag&128) {
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */
		bonus2 bAddSkillDamageRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */
	}
	return;
}

//============================================================
//個別に指定する時のみ
//[ヒール系スキルを受けた時のHP回復量 + n%] に使う
//{ callfunc "ItemdbAlmightySubHeal",数字,回復%; }

function	script	ItemdbAlmightySubHeal	{
	set '@flag,getarg(0);
	set '@val,getarg(1);
	if('@flag&1)
		bonus2 bAddSkillSubHealRate,28,'@val;	/* ヒール */
	if('@flag&2)
		bonus2 bAddSkillSubHealRate,70,'@val;	/* サンクチュアリ */
	if('@flag&4)
		bonus2 bAddSkillSubHealRate,231,'@val;	/* ポーションピッチャー */
	if('@flag&8)
		bonus2 bAddSkillSubHealRate,478,'@val;	/* スリムポーションピッチャー */
	if('@flag&16)
		bonus2 bAddSkillSubHealRate,322,'@val;	/* イドゥンの林檎 */
	if('@flag&32)
		bonus2 bAddSkillSubHealRate,2043,'@val;	/* コルセオヒール */
	if('@flag&64)
		bonus2 bAddSkillSubHealRate,2051,'@val;	/* ハイネスヒール */
	if('@flag&128)
		bonus2 bAddSkillSubHealRate,"CD_MEDIALE_VOTUM",'@val;	/* メディアリボトゥム */
	return;
}
