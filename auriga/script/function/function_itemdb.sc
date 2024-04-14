//20240415 19108#���C���h�|�������C�_�[#�ǉ�
//============================================================
// ����ȃn�G�̉H
//------------------------------------------------------------
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
//------------------------------------------------------------
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

//[�q�[���n�X�L���g�p��HP�񕜗� + n%] �Ɏg��
//{ callfunc "ItemdbAlmightyHeal",����,��%; }
//[1�q�[��][2�T���N�`���A��][4�|�[�V�����s�b�`���[][8�X�����|�[�V�����s�b�`���[]
//[16�C�h�D���̗ь�][32�R���Z�I�q�[��][64�n�C�l�X�q�[��]
//�Ώۂɂ����������𑫂�[1�q�[��]��[32�R���Z�I�q�[��]��5%������ { callfunc "ItemdbAlmightyHeal",33,5; }
//[�q�[���n�X�L���g�p��HP�񕜗� +30%] { callfunc "ItemdbAlmightyHeal",127,5; }16�i���ŋL�q { callfunc "ItemdbAlmightyHeal",0x7F,5; }

function	script	ItemdbAlmightyHeal	{
	set '@flag,getarg(0);
	set '@val,getarg(1);
	if('@flag&1) {
		bonus2 bAddSkillHealRate,28,'@val;	/* �q�[�� */
		bonus2 bAddSkillDamageRate,28,'@val;
	}
	if('@flag&2) {
		bonus2 bAddSkillHealRate,70,'@val;	/* �T���N�`���A�� */
		bonus2 bAddSkillDamageRate,70,'@val;
	}
	if('@flag&4)
		bonus2 bAddSkillHealRate,231,'@val;	/* �|�[�V�����s�b�`���[ */
	if('@flag&8)
		bonus2 bAddSkillHealRate,478,'@val;	/* �X�����|�[�V�����s�b�`���[ */
	if('@flag&16)
		bonus2 bAddSkillHealRate,322,'@val;	/* �C�h�D���̗ь� */
	if('@flag&32) {
		bonus2 bAddSkillHealRate,2043,'@val;	/* �R���Z�I�q�[�� */
		bonus2 bAddSkillDamageRate,2043,'@val;
	}
	if('@flag&64) {
		bonus2 bAddSkillHealRate,2051,'@val;	/* �n�C�l�X�q�[�� */
		bonus2 bAddSkillDamageRate,2051,'@val;
	}
	return;
}

//[�q�[���n�X�L�����󂯂�����HP�񕜗� + n%] �Ɏg��
//{ callfunc "ItemdbAlmightySubHeal",����,��%; }
//�����͏�L�Ɠ���

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
	return;
}

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
