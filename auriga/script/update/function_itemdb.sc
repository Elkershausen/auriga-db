//202504015 �X�V
//============================================================
// ����ȃn�G�̉H
function	script	ItemdbPartyCall	{
	warp "Random",0,0;
	set '@name$,strcharinfo(0);
	if('@name$ == getpartyleader(getcharid(1)) && !getmapxy('@map$,'@x,'@y,0)) {
		getpartymember getcharid(1);
		for(set '@i,0; '@i < $@partymembercount; set '@i,'@i+1) {
			if($@partymembername$['@i] == '@name$)			// �����͏��O
				continue;
			if(getmapname($@partymembername$['@i]) != '@map$)	// MAP���Ⴄ
				continue;
			if(attachrid(getcharid(3,$@partymembername$['@i]))) {
				if(!checkdead()) {
					// ���S���ĂȂ��Ȃ烊�[�_�[�̌��փ��[�v
					warp '@map$,'@x,'@y;
				}
				detachrid;
			}
		}
	}
	return;
}

//============================================================
// �L���L���X�e�B�b�N
function	script	ItemdbResetSkill	{
	if(Weight || checkcart() || checkfalcon() || checkriding())
		return;
	set '@lv,getskilllv(1);	// ��{�X�L��
	resetskill 0;		// �N�G�X�g�X�L���̓��Z�b�g���Ȃ�
	if('@lv > 0) {
		skill 1,'@lv,0;
		set SkillPoint,SkillPoint - '@lv;
	}
	return;
}

//============================================================
//[�q�[���n�X�L���g�p��HP�񕜗� + n%] �S��ꊇ�w��
//{ calllfunc "AddSkillHealRate",'@val; }

function	script	AddSkillHealRate	{
	set '@val,getarg(0);
		bonus2 bAddSkillHealRate,"AL_HEAL",'@val;	/* �q�[�� */
		bonus2 bAddSkillHealRate,"PR_SANCTUARY",'@val;	/* �T���N�`���A�� */
		bonus2 bAddSkillHealRate,"AM_POTIONPITCHER",'@val;	/* �|�[�V�����s�b�`���[ */
		bonus2 bAddSkillHealRate,"CR_SLIMPITCHER",'@val;	/* �X�����|�[�V�����s�b�`���[ */
		bonus2 bAddSkillHealRate,"BA_APPLEIDUN",'@val;	/* �C�h�D���̗ь� */
		bonus2 bAddSkillHealRate,"AB_CHEAL",'@val;	/* �R���Z�I�q�[�� */
		bonus2 bAddSkillHealRate,"AB_HIGHNESSHEAL",'@val;	/* �n�C�l�X�q�[�� */
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */

		bonus2 bAddSkillDamageRate,"AL_HEAL",'@val;	/* �q�[�� */
		bonus2 bAddSkillDamageRate,"PR_SANCTUARY",'@val;	/* �T���N�`���A�� */
		bonus2 bAddSkillDamageRate,"AB_CHEAL",'@val;	/* �R���Z�I�q�[�� */
		bonus2 bAddSkillDamageRate,"AB_HIGHNESSHEAL",'@val;	/* �n�C�l�X�q�[�� */
		bonus2 bAddSkillDamageRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */
	return;
}

//============================================================
//[�q�[���n�X�L�����󂯂�����HP�񕜗� + n%] �S��ꊇ�w��
//{ calllfunc "AddSkillSubHealRate",'@val; }

function	script	AddSkillSubHealRate	{
	set '@val,getarg(0);
		bonus2 bAddSkillSubHealRate,"AL_HEAL",'@val;	/* �q�[�� */
		bonus2 bAddSkillSubHealRate,"PR_SANCTUARY",'@val;	/* �T���N�`���A�� */
		bonus2 bAddSkillSubHealRate,"AM_POTIONPITCHER",'@val;	/* �|�[�V�����s�b�`���[ */
		bonus2 bAddSkillSubHealRate,"CR_SLIMPITCHER",'@val;	/* �X�����|�[�V�����s�b�`���[ */
		bonus2 bAddSkillSubHealRate,"BA_APPLEIDUN",'@val;	/* �C�h�D���̗ь� */
		bonus2 bAddSkillSubHealRate,"AB_CHEAL",'@val;	/* �R���Z�I�q�[�� */
		bonus2 bAddSkillSubHealRate,"AB_HIGHNESSHEAL",'@val;	/* �n�C�l�X�q�[�� */
		bonus2 bAddSkillSubHealRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */
	return;
}

//============================================================
//�ʂɎw�肷�鎞�̂�
//[�q�[���n�X�L���g�p��HP�񕜗� + n%]
//{ callfunc "ItemdbAlmightyHeal",����,��%; }
//[1�q�[��][2�T���N�`���A��][4�|�[�V�����s�b�`���[][8�X�����|�[�V�����s�b�`���[]
//[16�C�h�D���̗ь�][32�R���Z�I�q�[��][64�n�C�l�X�q�[��][128���f�B�A���{�g�D�� ]
//�Ώۂɂ����������𑫂�[1�q�[��]��[32�R���Z�I�q�[��]��5%������ { callfunc "ItemdbAlmightyHeal",33,5; }
//[�q�[���n�X�L���g�p��HP�񕜗� +30%] { callfunc "ItemdbAlmightyHeal",127,5; }16�i���ŋL�q { callfunc "ItemdbAlmightyHeal",0x7F,5; }

function	script	ItemdbAlmightyHeal	{
	set '@flag,getarg(0);
	set '@val,getarg(1);
	if('@flag&1) {
		bonus2 bAddSkillHealRate,28,'@val;	/* �q�[�� */
		bonus2 bAddSkillDamageRate,28,'@val;	/* �q�[�� */
	}
	if('@flag&2) {
		bonus2 bAddSkillHealRate,70,'@val;	/* �T���N�`���A�� */
		bonus2 bAddSkillDamageRate,70,'@val;	/* �T���N�`���A�� */
	}
	if('@flag&4)
		bonus2 bAddSkillHealRate,231,'@val;	/* �|�[�V�����s�b�`���[ */
	if('@flag&8)
		bonus2 bAddSkillHealRate,478,'@val;	/* �X�����|�[�V�����s�b�`���[ */
	if('@flag&16)
		bonus2 bAddSkillHealRate,322,'@val;	/* �C�h�D���̗ь� */
	if('@flag&32) {
		bonus2 bAddSkillHealRate,2043,'@val;	/* �R���Z�I�q�[�� */
		bonus2 bAddSkillDamageRate,2043,'@val;	/* �R���Z�I�q�[�� */
	}
	if('@flag&64) {
		bonus2 bAddSkillHealRate,2051,'@val;	/* �n�C�l�X�q�[�� */
		bonus2 bAddSkillDamageRate,2051,'@val;	/* �n�C�l�X�q�[�� */
	}
	if('@flag&128) {
		bonus2 bAddSkillHealRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */
		bonus2 bAddSkillDamageRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */
	}
	return;
}

//============================================================
//�ʂɎw�肷�鎞�̂�
//[�q�[���n�X�L�����󂯂�����HP�񕜗� + n%] �Ɏg��
//{ callfunc "ItemdbAlmightySubHeal",����,��%; }

function	script	ItemdbAlmightySubHeal	{
	set '@flag,getarg(0);
	set '@val,getarg(1);
	if('@flag&1)
		bonus2 bAddSkillSubHealRate,28,'@val;	/* �q�[�� */
	if('@flag&2)
		bonus2 bAddSkillSubHealRate,70,'@val;	/* �T���N�`���A�� */
	if('@flag&4)
		bonus2 bAddSkillSubHealRate,231,'@val;	/* �|�[�V�����s�b�`���[ */
	if('@flag&8)
		bonus2 bAddSkillSubHealRate,478,'@val;	/* �X�����|�[�V�����s�b�`���[ */
	if('@flag&16)
		bonus2 bAddSkillSubHealRate,322,'@val;	/* �C�h�D���̗ь� */
	if('@flag&32)
		bonus2 bAddSkillSubHealRate,2043,'@val;	/* �R���Z�I�q�[�� */
	if('@flag&64)
		bonus2 bAddSkillSubHealRate,2051,'@val;	/* �n�C�l�X�q�[�� */
	if('@flag&128)
		bonus2 bAddSkillSubHealRate,"CD_MEDIALE_VOTUM",'@val;	/* ���f�B�A���{�g�D�� */
	return;
}

//============================================================
//�����U���ŗ^����_���[�W + '@val%
//{ callfunc "MeleeRate",'@val; }

function	script	MeleeRate	{
	set '@val,getarg(0);
		bonus2 bAddRace,Rct_Boss,'@val;
		bonus2 bAddRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//���@�U���ŗ^����_���[�W + '@val%
//{ callfunc "MagicRate",'@val; }

function	script	MagicRate	{
	set '@val,getarg(0);
		bonus2 bMagicAddRace,Rct_Boss,'@val;
		bonus2 bMagicAddRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//�����U����[�S�Ă̎푰]�̃����X�^�[�ɗ^����_���[�W + '@val% �v���C���[�ƃh�����`����
//{ callfunc "MeleeRct_All",'@val; }

function	script	MeleeRct_All	{
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
//���@�U����[�S�Ă̎푰]�̃����X�^�[�ɗ^����_���[�W + '@val% �v���C���[�ƃh�����`����
//{ callfunc "MagicRct_All",'@val; }

function	script	MagicRct_All	{
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
//��ʁE�{�X�����X�^�[�̖h��� DEF '@val% ����
//{ callfunc "IgnoreDefRct_All",'@val; }

function	script	IgnoreDefRct_All	{
	set '@val,getarg(0);
	bonus2 bIgnoreDefRace,Rct_Boss,'@val;
	bonus2 bIgnoreDefRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//��ʁE�{�X�����X�^�[�̖��@�h��� '@val% ����
//{ callfunc "IgnoreMDefRct_All",'@val; }

function	script	IgnoreMDefRct_All	{
	set '@val,getarg(0);
	bonus2 bIgnoreMdefRace,Rct_Boss,'@val;
	bonus2 bIgnoreMdefRace,Rct_NonBoss,'@val;
	return;
}

//============================================================
//[�S�Ă̎푰]�̃����X�^�[��DEF �h��� '@val%���� �v���C���[�ƃh�����`����
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
//[�S�Ă̎푰]�̃����X�^�[��MDEF ���@�h���'@val%���� �v���C���[�ƃh�����`����
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
//[���ׂĂ̎푰]�̃����X�^�[����󂯂镨���_���[�W '@val%�� �v���C���[�`�ƃh�����`����
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
//[���ׂĂ̎푰]�̃����X�^�[����󂯂閂�@�_���[�W '@val%�� �v���C���[�`�ƃh�����`����
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
//�ꕔ�̃_���[�W�𔽎˂�����ʂŎ󂯂�_���[�W ���B�l*-10%
//���B�l�͋L�q����Ă��鑕���i���Q�Ƃ���̂ŎQ�Ƃ����g�̃A�C�e���ȊO�͋L�q�𔲂��o���đ����{�[�i�X�ɏ����ĉ�����
//��Ƀ��C�����n����
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
//�ꕔ�̃_���[�W�𔽎˂�����ʂŎ󂯂�_���[�W
//rate �w�肷�� 
//���C�����n���� �ȊO
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
//310760#���̐_��#�Z�b�g����A
//�U�����x + 15% �v���C���[����󂯂�_���[�W - 10% [�S�X�y��]Lv1�g�p�\
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
//310760#���̐_��#�Z�b�g����B
//�U�����x + 15% �v���C���[����󂯂�_���[�W - 40% [�S�X�y��]Lv1�g�p�\
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
//300314#�����ƋL���̎c��#�Z�b�g����A
//Atk + 100 , Matk + 100 �v���C���[����󂯂�_���[�W - 10% [�R���Z���g���C�V����]Lv5
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
//300314#�����ƋL���̎c��#�Z�b�g����B
//Atk + 200 , Matk + 200 �v���C���[����󂯂�_���[�W - 40% [�R���Z���g���C�V����]Lv5
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
//300314#�����ƋL���̎c��#�Z�b�g����C
//Atk + 100 , Matk + 100 �v���C���[����󂯂�_���[�W - 40% [�R���Z���g���C�V����]Lv5
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
//312417#�������ꂽ���]#�Z�b�g����A
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
//410028#�����_�[�G�b�O�o�X�P�b�g#
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
//410014 410015 #�R���E�R�A�w�b�h�t�H��#
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
//19108#���C���h�|�������C�_�[#
//item_db.txt�ŏ����Ȃ��ꍇ�͂�������g��
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
//[�s�E]Lv1
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
//[�s�E]Lv2
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
//[�j��]Lv1
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
//[�j��]Lv1
//{ callfunc "shukufukuLv1"; }
//�ΏۃX�L���͒������Đ���

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
// �O���C�V�A�n���蕐��
//{ callfunc "Glacier202409"; }
//���z�i�K�̏����������ł�������ʂ�ǋL���Ă�������
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
// �f�B���O���C�V�A�n���蕐��
//{ callfunc "D_Glacier202409"; }
//���z�i�K�̏����������ł�������ʂ�ǋL���Ă�������
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
// �O���C�V�A�x�[�V�b�N�n�Ў蕐��
//{ callfunc "Glacier_B202409"; }
//���z�i�K�̏����������ł�������ʂ�ǋL���Ă�������
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
// �f�B���O���C�V�A�O���C�V�A�x�[�V�b�N�n�Ў蕐��
//{ callfunc "D_Glacier_B202409"; }
//���z�i�K�̏����������ł�������ʂ�ǋL���Ă�������
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
//[�S�Ă̎푰]�̃����X�^�[��Mres �������@�h���'@val%���� �v���C���[�ƃh�����`����
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
//18133#�v���|# 18142#���o�|# 18144#��ɋ|# 18152#���|#�̃Z�b�g���ʂ̑����t�^��L���ɂ���ꍇ ��������
//��[1750]-[1774]�S���S��ɒǋL
//{ callfunc "arrow_ele"; }
//�Ώۂ̋|�������A��̑�����[SC_WindWeapon][SC_GroundWeapon][SC_WaterWeapon][SC_FireWeapon]�ɂ��A�������Ă��Ȃ��ꍇ�͌��̑���[bonus bAtkEle,����;]���L���ɂȂ�
//�����̐ݒ肪�Ȃ���ɂ��ǋL���A���̑��̑������ʂ͎c��
//��
//1750,ammo,��,10,1,,1,25:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; }
//1751,ammo,��̖�,10,3,,2,30:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; }
//1760,ammo,�t���b�V���A���[,10,10,,3,1:0,,,,1706056,2,32768,,1,,,{},{ callfunc "arrow_ele"; bonus2 bAddEff,Eff_Blind,2000; }

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

//18133#�v���|# 18142#���o�|# 18144#��ɋ|# 18152#���|# ���O�����Ƃ��ɃZ�b�g���ʂ̑����t�^�������L�q
//{ callfunc "arrow_off"; } �Ώۋ|�ɒǋL
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

//18133#�v���|# 18142#���o�|# 18144#��ɋ|# 18152#���|#�̃Z�b�g���ʂ̑����t�^��L���ɂ���ꍇ �����܂�

//============================================================
//13130#�v���e# 13133#���o�e# 13139#��ɏe# 13143#���e#�̃Z�b�g���ʂ̑����t�^��L���ɂ���ꍇ ��������
//�e[13200]-[13232]�S���S��ɒǋL
//�X�t�B�A�n 13201 13202 �����p�~����Ă��܂�
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

//13130#�v���e# 13133#���o�e# 13139#��ɏe# 13143#���e#
//{ callfunc "ammo_off"; } �Ώۋ|�ɒǋL

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

//13130#�v���e# 13133#���o�e# 13139#��ɏe# 13143#���e#�̃Z�b�g���ʂ̑����t�^��L���ɂ���ꍇ �����܂�
