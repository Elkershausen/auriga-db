//2025/05/07 �A�b�v�f�[�g
//�Ȉ�4���E�]�E�X�N���v�g

-	script	4thJobChange		10461,{
	if(getbaseclass(Class) == CLASS_SUM) {	mes "["+strnpcinfo(1)+"]";	mes "�l�Ԍ`�v���C���[��p�ł�";	close;	}
	if(Upper == UPPER_BABY) {	mes "["+strnpcinfo(1)+"]";	mes "�{�q�E��4���E�ɓ]�E�ł��܂���B";	close;	}
	if(BaseLevel != 200) {	mes "["+strnpcinfo(1)+"]";	mes "BaseLevel 200 ���K�v�ł��B";	close;	}
	if(JobLevel < 70) {	mes "["+strnpcinfo(1)+"]";	mes "JobLevel 70 �ȏオ�K�v�ł��B";	close;	}
	if(SkillPoint != 0) {	mes "["+strnpcinfo(1)+"]";	mes "�X�L���|�C���g�͎c���Ȃ��ŉ������B";	close;	}
	if(checkriding() || checkcart() || checkfalcon() || sc_ison(SC_ALL_RIDING)) {	mes "["+strnpcinfo(1)+"]";	mes "�y�R�y�R�n �J�[�g";	mes "�� �t�@���R�� �E�H�[�O�A�R��p��j";	mes "�S���O���ĉ������B";	close;	}
	//if(Weight) { 	mes "["+strnpcinfo(1)+"]";	mes "�����d�ʂ�0�ɂ��ĉ������B";	close;	}	//�����d�ʏ����s�v
	mes "["+strnpcinfo(1)+"]";
	mes ""+strcharinfo(0)+"�����";
	mes "�ǂ̐E�Ƃɓ]�E���܂����H";
	next;
	switch(select(
	"�h���S���i�C�g",		//case 1
	"�A�[�N���C�W",
	"�E�C���h�z�[�N",
	"�J�[�f�B�i��",
	"�}�C�X�^�[",
	"�V���h�E�N���X",
	"�C���y���A���K�[�h",
	"�G�������^���}�X�^�[",
	"�g���o�h�D�[��(�j)",
	"�g�����F�[��(��)",
	"�C���N�C�W�^�[",		//case 11
	"�o�C�I���W�X�g",
	"�A�r�X�`�F�C�T�[",
	"�V��",
	"�\�E���A�Z�e�B�b�N",
	"凋C�O(�j)",
	"�s�m��(��)",
	"�i�C�g�E�H�b�`",
	"�n�C�p�[�m�[�r�X",
	"��߂�"			//case 20
	))
		{
	case 1:	if(Job != Job_RuneKnight) {	mes "["+strnpcinfo(1)+"]";	mes "���[���i�C�g��p�ł�";	close;	}
		setlook 7,0;			//���F��W����
		setlook 13,0;			//�Z�J���h�R�X�`���[������
		jobchange Job_DRAGONKNIGHT;	//�]�E����
		break;				//�X�N���v�g�I��
	case 2:	if(Job != Job_Warlock) {	mes "["+strnpcinfo(1)+"]";	mes "�E�H�[���b�N��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ARCHMAGE;
		break;
	case 3:	if(Job != Job_Ranger) {	mes "["+strnpcinfo(1)+"]";	mes "�����W���[��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_WINDHAWK;
		break;
	case 4:	if(Job != Job_ArchBishop) {	mes "["+strnpcinfo(1)+"]";	mes "�A�[�N�r�V���b�v��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_CARDINAL;
		break;
	case 5:	if(Job != Job_Mechanic) {	mes "["+strnpcinfo(1)+"]";	mes "���J�j�b�N��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_MEISTER;
		break;
	case 6:	if(Job != Job_Guillotine) {	mes "["+strnpcinfo(1)+"]";	mes "�M���`���N���X��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHADOWCROSS;
		break;
	case 7:	if(Job != Job_RoyalGuard) {	mes "["+strnpcinfo(1)+"]";	mes "���C�����K�[�h��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_IMPERIALGUARD;
		break;
	case 8:	if(Job != Job_Sorcerer) {	mes "["+strnpcinfo(1)+"]";	mes "�\�[�T���[��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ELEMENTALMASTER;
		break;
	case 9:	if(Job != Job_Minstrel) {	mes "["+strnpcinfo(1)+"]";	mes "�~���X�g����(�j)��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_TROUBADOUR;
		break;
	case 10:	if(Job != Job_Wanderer) {	mes "["+strnpcinfo(1)+"]";	mes "�����_���[(��)��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_TROUVERE;
		break;
	case 11:	if(Job != Job_Shura) {	mes "["+strnpcinfo(1)+"]";	mes "�C����p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_INQUISITOR;
		break;
	case 12:	if(Job != Job_Genetic) {	mes "["+strnpcinfo(1)+"]";	mes "�W�F�l�e�B�b�N��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_BIOLO;
		break;
	case 13:	if(Job != Job_ShadowChaser) {	mes "["+strnpcinfo(1)+"]";	mes "�V���h�E�`�F�C�T�[��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_ABYSSCHASER;
		break;
	case 14:	if(Job != Job_StarEmperor) {	mes "["+strnpcinfo(1)+"]";	mes "�����p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SKYEMPEROR;
		break;
	case 15:	if(Job != Job_Soulreaper) {	mes "["+strnpcinfo(1)+"]";	mes "�\�E�����[�p�[��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SOULASCETIC;
		break;
	case 16:	if(Job != Job_Kagerou) {	mes "["+strnpcinfo(1)+"]";	mes "�e�T(�j)��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHINKIRO;
		break;
	case 17:	if(Job != Job_Oboro) {	mes "["+strnpcinfo(1)+"]";	mes "�O(��)��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_SHIRANUI;
		break;
	case 18:	if(Job != Job_Rebellion) {	mes "["+strnpcinfo(1)+"]";	mes "���x���I����p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_NIGHTWATCH;
		break;
	case 19:	if(Job != Job_ExpandedSuperNovice) {	mes "["+strnpcinfo(1)+"]";	mes "�X�[�p�[�m�[�r�X(���E�˔j)��p�ł�";	close;	}
		setlook 7,0;
		setlook 13,0;
		jobchange Job_HYPERNOVICE;
		break;
	case 20:	mes "[" +strnpcinfo(1)+ "]";	mes "�]�E�����𒆎~���܂�";	close;
		}
	mes "[" +strnpcinfo(1)+ "]";
	mes "�]�E���������܂���";	//�X�L���E�X�e�[�^�X�̃��Z�b�g�Ȃ�
	close;
}

-	script	4thJobChangeDoram		10461,{
	if(Job != Job_Summoner) {	mes "["+strnpcinfo(1)+"]";	mes "�T���i�[��p�ł�";	close;	}
	if(Upper == UPPER_BABY) {	mes "["+strnpcinfo(1)+"]";	mes "�{�q�E��4���E�ɓ]�E�ł��܂���B";	close;	}
	if(BaseLevel != 200) {	mes "["+strnpcinfo(1)+"]";	mes "BaseLevel 200���K�v�ł��B";	close;	}
	if(JobLevel < 70) {	mes "["+strnpcinfo(1)+"]";	mes "JobLevel 70�ȏオ�K�v�ł��B";	close;	}
	if(SkillPoint != 0) {	mes "["+strnpcinfo(1)+"]";	mes "�X�L���|�C���g�͎c���Ȃ��ŉ������B";	close;	}
	if(checkriding() || checkcart() || checkfalcon() || sc_ison(SC_ALL_RIDING)) {	mes "["+strnpcinfo(1)+"]";	mes "�y�R�y�R�n�A���{�A�J�[�g";	mes "�� �t�@���R�� �E�H�[�O�A�R��p��j";	mes "�S���O���ĉ������B";	close;	}
	//if(Weight) { 	mes "["+strnpcinfo(1)+"]";	mes "�����d�ʂ�0�ɂ��ĉ������B";	close;	}	//�����d�ʏ����s�v
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+strcharinfo(0)+"�����";
	mes "�X�s���b�g�n���h���[�ɓ]�E���܂����H";
	next;
	switch(select(
	"����ς��߂�",
	"�X�s���b�g�n���h���[�ɓ]�E����"
	))
		{
	case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�]�E�����𒆎~���܂�";	close;
	case 2:	setlook 7,0;	setlook 13,0;	jobchange Job_Spirit_Handler;	break;
	mes "[" +strnpcinfo(1)+ "]";
	mes "�]�E���������܂���";	//�X�L���E�X�e�[�^�X�̃��Z�b�g�Ȃ�
	close;
	}
}
//�C�ӂ̃}�b�v�E���W�ɐݒu
prontera.gat,150,160,2	duplicate(4thJobChange)	4���]�ENPC	10461
prontera.gat,150,150,3	duplicate(4thJobChangeDoram)	�X�s���b�g�n���h���[�]�ENPC	10461

//��������J���җpNPC
//4���E�X�N���v�g

-	script	4thJOBtest		10461,{
	if(getbaseclass(Class) == CLASS_SUM) {mes "["+strnpcinfo(1)+"]";	mes "�l�ԑ���p�ł�";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+strcharinfo(0)+"�����";
	mes "�ǂ̐E�Ƃɂ��܂����H";
	skill 142,1,0;				//�N�G�X�g�X�L��
	skill 143,1,0;				//�N�G�X�g�X�L��
	cutin "update_event01.bmp",3;
	next;
	switch(select(
	"�h���S���i�C�g",		//case 1
	"�A�[�N���C�W",
	"�E�C���h�z�[�N",
	"�J�[�f�B�i��",
	"�}�C�X�^�[",
	"�V���h�E�N���X",
	"�C���y���A���K�[�h",
	"�G�������^���}�X�^�[",
	"�g���o�h�D�[��(�j)",
	"�g�����F�[��(��)",
	"�C���N�C�W�^�[",		//case 11
	"�o�C�I���W�X�g",
	"�A�r�X�`�F�C�T�[",
	"�V��",
	"�\�E���A�Z�e�B�b�N",
	"凋C�O(�j)",
	"�s�m��(��)",
	"�i�C�g�E�H�b�`",
	"�n�C�p�[�m�[�r�X",
	"�X�s���b�g�n���h���[",
	"�X�e�[�^�X�E�X�L�����Z�b�g",	//case 21
	"���]���m�[�r�X�ɖ߂�",		//case 22
	"�t���X���b�g�����o����",	//case 23
	"��߂�"			//case 24
	))
		{
	case 1:
	if(Job != Job_RuneKnight) {	mes "["+strnpcinfo(1)+"]";	mes "���[���i�C�g��p�ł�";	close;	}
		setlook 7,0;				//���F���f�t�H���g�ɖ߂�
		setlook 13,0;				//�Z�J���h�R�X�`���[����߂�
		set StatusPoint,100;			//�ǉ��]���X�e�[�^�X�|�C���g
		jobchange Job_DRAGONKNIGHT;		//�E��(3��4���E�͖��]���E�ɑ���)
		set BaseLevel,260;			//4���E�̍ő�BaseLevel
		set JobLevel,55;			//4���E�̍ő�JobLevel
		set Skillpoint,0;			//�X�L���|�C���g��0�ɂ���
		gmcommand "@allskill";			//���ׂẴX�L�����o����
		skill 144,1,0;				//�N�G�X�g�X�L��
		skill 145,1,0;				//�N�G�X�g�X�L��
		skill 146,1,0;				//�N�G�X�g�X�L��
		skill 1001,1,0;				//�N�G�X�g�X�L��
		break;

	case 2:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
		//skill 2544,1,0;	//�J�[�h�f�R���[�V����
		break;

	case 6:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
		//skill 2544,1,0;	//�J�[�h�f�R���[�V����
		break;

	case 13:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�l�ԑ���p�ł�";
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
	mes "�h��������p�ł�";
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
		setlook 7,0;				//���F���f�t�H���g�ɖ߂�
		setlook 13,0;				//�Z�J���h�R�X�`���[����߂�
		resetskill;				//�X�L�����Z�b�g
		resetstatus;				//�X�e�[�^�X���Z�b�g
		set Skillpoint,0;			//�X�L���|�C���g��0�ɕύX
		set StatusPoint,0;			//�X�e�[�^�X�|�C���g��0�ɕύX
		break;

	case 22:
	if(getbaseclass(Class) == CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "�l�ԑ���p�ł�";
	cutin "update_event01.bmp",255;
	close;
	}
		setlook 7,0;
		setlook 13,0;
		set upper_job,0;			//���]���m�[�r�X�̃t���O
		jobchange Job_Novice,0;
		set JobLevel,1;
		set BaseLevel,1;
		resetskill;
		set Skillpoint,0;
		resetstatus;
		set StatusPoint,0;
		skill 142,1,0;				//���}�蓖
		skill 143,1,0;				//���񂾂ӂ�
		break;

	case 23:
		skill 5071,1,0;				//EVT_FULL_THROTTLE�t���X���b�g��
		break;

	case 24:
		mes "[" +strnpcinfo(1)+ "]";
		mes "�]�E�����𒆎~���܂�";
		cutin "update_event01.bmp",255;
		close;
		}

	mes "[" +strnpcinfo(1)+ "]";
	mes "�]�E���������܂���";
	cutin "update_event01.bmp",255;
	close;
}

-	script	doramreset4th		10461,{

	if(getbaseclass(Class) != CLASS_SUM) {
	mes "["+strnpcinfo(1)+"]";
	mes "�h��������p�ł�";
	close;
	}
	
	mes "["+strnpcinfo(1)+"]";
	mes "�T���i�[�ɖ߂�܂����H";
	cutin "ep19_tamarin01.png",2;
	next;
	switch(select(
		"��߂�",		//case 1
		"�T���i�[�ɖ߂�",	//case 2
		)) {
		case 1:
		mes "["+strnpcinfo(1)+"]";
		mes "�]�E�����𒆎~���܂�";
		cutin "ep19_tamarin01.png",255;
		close;

		case 2:

		if(Job == Job_Summoner) {
		mes "["+strnpcinfo(1)+"]";
		mes "���Ȃ��͂��łɃT���i�[��";
		mes "�߂��Ă��܂�";
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
		skill 142,1,0;				//���}�蓖
		skill 143,1,0;				//���񂾂ӂ�
		break;
		}
	mes "[" +strnpcinfo(1)+ "]";
	mes "�]�E���������܂���";
	cutin "ep19_tamarin01.png",255;
	close;
}

//prontera.gat,150,160,2	duplicate(4thJOBtest)	4���]�ENPC	10461
//prontera.gat,150,150,3	duplicate(doramreset4th)	�T���i�[�߂�NPC	10461