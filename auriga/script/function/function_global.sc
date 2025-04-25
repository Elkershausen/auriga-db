//==============================================================================
// �T���v���X�N���v�g
//==============================================================================

//==============================================================================
// �A�C�e������E�����p�t�@���N�V����
// �@�v���C���[�̏����i�����Zeny�𒲂ׂāA�ړI�A�C�e���̎擾�\�ő吔��Ԃ�
//�@�i��r�Ώۂ�3�ȏ゠��ꍇ�ɗ��p���邱�Ɓj
//	callfunc "MathMax",ItemID-Array,Amount-Array,Zeny;
//
// �� �����̏ڍ�
//	ItemID-Array 	-> �K�v�A�C�e��ID���i�[�����z��
//	Amount-Array 	-> �K�v�A�C�e�������i�[�����z��
//	Zeny		-> �K�vZeny�i�z��ł͂Ȃ��j�A���肵�Ȃ��ꍇ��0������
//
// �� �g�p��
//	setarray '@itemid,512,602,1010;
//	setarray '@amount,3,1,5;
//	callfunc "MathMax",'@itemid,'@amount,300;
//
//		-> ���3�A���̉H1�A�u���R��5�A300z�ŖړI�A�C�e��1�擾
//------------------------------------------------------------------------------

function	script	MathMax	{
	set '@size,getarraysize(getarg(0));
	//'@max�z��Ɋe�A�C�e���ɂ�����ő吔������
	for(set '@i,0; '@i<'@size; set '@i,'@i+1) {
		set '@max['@i],countitem(getelementofarray(getarg(0),'@i)) / getelementofarray(getarg(1),'@i);
	}
	if(getarg(2))
		set '@max['@i],Zeny / getarg(2);	//������Zeny�ɂ��ő吔������
	else
		set '@size,'@size-1;			//Zeny���肵�Ȃ��Ƃ��̓T�C�Y��1���炷
	for(set '@i,0; '@i<'@size; set '@i,'@i+1) {
		if('@max[0] > '@max[1])			//�v�f0��1�̒l���r���A�傫������delete���ċl�߂�
			deletearray '@max[0],1;
		else
			deletearray '@max[1],1;
	}
	return '@max;	//�Ō�Ɏc�������̂��擾�\�ő吔
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
