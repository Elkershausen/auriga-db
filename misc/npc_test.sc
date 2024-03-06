//=============================================================
//= �A�r�X���C�N�n�����A 04 abyss_04.gat abyss_04_j.gat
//=============================================================
//Map Flag
abyss_04.gat	mapflag	nomemo	dummy
abyss_04_j.gat	mapflag	nomemo	dummy

//warp
prontera.gat,133,169,0		warp	abyss_040001	1,1,hugel.gat,100,150
hugel.gat,100,155,0		warp	abyss_040002	1,1,prontera.gat,133,166
abyss_04.gat,168,166,0		warp	abyss_040003	1,1,abyss_04_j.gat,165,163
abyss_04_j.gat,168,166,0	warp	abyss_040004	1,1,abyss_04.gat,165,163

//mob
abyss_04.gat,0,0,0,0	monster	�p�[�v���y���X		20612,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	�g���W���[�~�~�b�N	20613,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	�u���b�N�I�V�h�X	20614,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	�V���o�[�I�V�h�X	20615,5,5000,0,0
abyss_04.gat,0,0,0,0	monster	�{�[���y���X		20616,110,5000,0,0
abyss_04.gat,0,0,0,0	monster	�{�[���I�V�h�X		20617,110,5000,0,0
abyss_04.gat,0,0,0,0	monster	�{�[���f�[�^���U�E���X	20618,1,3600000,0,0

abyss_04_j.gat,0,0,0,0	monster	�p�[�v���y���X		20612,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�g���W���[�~�~�b�N	20613,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�u���b�N�I�V�h�X	20614,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�V���o�[�I�V�h�X	20615,5,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�{�[���y���X		20616,110,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�{�[���I�V�h�X		20617,110,5000,0,0
abyss_04_j.gat,0,0,0,0	monster	�{�[���f�[�^���U�E���X	20618,1,3600000,0,0

//NPC
prontera.gat,133,172,3	script	�t�B�Q������	837,{
waitingroom "�t�B�Q������",0;
}
hugel.gat,100,158,3	script	�v�����e������	837,{
waitingroom "�v�����e������",0;
}

hugel.gat,102,148,3	script	[�e���[�_���W����]#abyss04_01	893,{
mes "[�����w�҃}���[�S�[���h]";
mes "������`���Ă��������܂����H";
mes "hugel.gat npc pos(102,148)";
mes "";
next;
switch(select("��`��","���n�ֈړ�","������Ċm�F����","���ۂ���")) {
	case 1:
	mes "[�����w�҃}���[�S�[���h]";
	mes "��`��";
	mes "������";
	mes "";
	mes "";
	mes "";
	close;

	case 2:
	mes "[�����w�҃}���[�S�[���h]";
	mes "����Ɍ������܂����H";
	next;
		switch(select("�A�r�X���C�N�n�����A 04�̑O�Ɉړ�","�l������")){
		case 1:
		mes "[�����w�҃}���[�S�[���h]";
		mes "����ł́A����܂œ]���������܂��ˁB";
		misceffect 35,"";
		misceffect 240,"";
		next;
		warp "abyss_03.gat",87,107;
		end;
		
		case 2:
		mes "[�����w�҃}���[�S�[���h]";
		mes "�l������";
		mes "�܂����ĉ������B";
		mes "";
		close;
		}

	case 3:
	mes "[�����w�҃}���[�S�[���h]";
	mes "������Ċm�F����";
	mes "������";
	mes "";
	mes "";
	mes "";
	close;

	case 4:
	mes "[�����w�҃}���[�S�[���h]";
	mes "���ۂ���";
	mes "������";
	mes "";
	mes "";
	mes "";
	close;}
}

abyss_03.gat,91,110,3	script	�e���[�_���W����[�Ŕ�]#board_01		837,{
mes "-�ǂ���Ɍ����������H-";
mes "";
mes "";
next;
switch(select("�A�r�X���C�N�n�����A 04[1]","�A�r�X���C�N�n�����A 04[2]","hugel.gat�ɖ߂�")){
	case 1:
	warp "abyss_04.gat",168,160;
	end;

	case 2:
	warp "abyss_04_j.gat",168,160;
	end;
	
	case 3:
	warp "hugel.gat",102,146;
	end;}
}

abyss_04.gat,168,166,3	script	�e���[�_���W����[�Ŕ�]#board_02		837,{
mes "-�ǂ���Ɍ����������H-";
mes "";
mes "";
	switch(select("hugel.gat�ɖ߂�","�A�r�X���C�N�n�����A 04[2]")){

	case 1:
	warp "hugel.gat",102,146;
	end;

	case 2:
	warp "abyss_04_j.gat",168,165;
	end;}
}

//=============================================================
//= �嗁�ꃁ�f�B�^�e�B�I ba_bath.gat ba_bath_j.gat
//=============================================================
//Map Flag
ba_bath.gat	mapflag	nomemo	dummy
ba_bath_j.gat	mapflag	nomemo	dummy

//warp
ba_bath.gat,290,70,0		warp	medi_040001	1,1,prontera.gat,138,166
ba_bath_j.gat,290,70,0		warp	medi_040002	1,1,prontera.gat,138,166

//mob
ba_bath.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�^	20633,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�T�^	20634,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���t�F��		20643,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���}���N		20644,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���\�[�h�t�B�b�V��	20645,60,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���s���j�A		20646,60,5000,0,0

ba_bath_j.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�^	20633,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�T�^	20634,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���t�F��		20643,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���}���N		20644,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���\�[�h�t�B�b�V��	20645,60,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���s���j�A		20646,60,5000,0,0

//NPC
prontera.gat,124,169,3		script	�e�X�g�}�b�v	10353,{
mes "[4_EP17_MASTER_A]";
mes "�ǂ��ɍs���܂����H";
mes "prontera.gat npc pos(124,169)";
mes "";
next;
switch(select("�A�r�X���C�N�n�����A04[1]","�A�r�X���C�N�n�����A04[2]","�嗁�ꃁ�f�B�^�e�B�I[1]","�嗁�ꃁ�f�B�^�e�B�I[2]")) {

case 1:
	warp "abyss_04.gat",165,163;
	end;
case 2:
	warp "abyss_04_j.gat",165,163;
	end;
case 3:
	warp "ba_bath.gat",165,163;
	end;
case 4:
	warp "ba_bath_j.gat",165,163;
	end;}
}