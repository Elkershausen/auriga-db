//2025/06/03 �A�b�v�f�[�g
//�X�y�V�����A�C�e���̃`�P�b�g����NPC
//�C�x���g�Ȃǂ̈ꎞ�I�ȗv�f�ł͂Ȃ��P�v�I�ȗv�f�ł�
//���p�񐔕ۑ��t���O�K�v

//�Ǘ��pNPC�J�n
izlude.gat,143,150,3	shop	�Ǘ��p�`�P�b�g�̔�		10545,1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200

izlude.gat,142,142,3	script	�Ǘ��p�`�P�b�gNPC	70,{
	mes "["+strnpcinfo(1)+"]";
	mes "�����܂���";
	clearitem;
	gmcommand "@itemreset";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002199)+"����";
	getitem 1002199,1;
	getitem 1002200,1;
	close;
}
//�Ǘ��pNPC�����܂�

izlude.gat,150,142,3	script	�~�X�e�B�A	91,{

	setarray '@main[0],1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200;

	mes "["+strnpcinfo(1)+"]";
	mes "�e��`�P�b�g�̈�����";
	mes "�S�����Ă���܂��B";
	mes "�{���͂������Ȃ����܂����H";
	next;
	switch(select(
		"��߂�",
		""+getitemname('@main[0])+"",
		""+getitemname('@main[1])+"",
		""+getitemname('@main[2])+"",
		""+getitemname('@main[3])+"",
		""+getitemname('@main[4])+"",
		""+getitemname('@main[5])+"",
		""+getitemname('@main[6])+"",
		""+getitemname('@main[7])+"",
		""+getitemname('@main[8])+"",
		""+getitemname('@main[9])+"",
		""+getitemname('@main[10])+"",
		""+getitemname('@main[11])+"",
		""+getitemname('@main[12])+"",
		""+getitemname('@main[13])+"",
		""+getitemname('@main[14])+" ����",
		""+getitemname('@main[15])+" ����",
		"�N�G�X�g�{�[�i�XA�`�P�b�g�ǉ���V")) {

	case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
	case 2:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 3:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 4:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 5:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 6:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 7:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 8:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 9:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 10:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 11:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 12:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 13:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 14:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 15:	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;

	/* 4���E�E�g��4���E�{�[�i�X�`�P�b�g */
	case 16:
	setarray '@itemA[0],1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221,1002221;
	setarray '@itemB[0],1002201,1002202,1002203,1002206,1002204,1002205,1002208,1002209,1002210,1002211,1002207,1002212,1002213,1002217,1002214,1002216,1002216,1002215,1002219,1002218;
	set '@limA,14374;

		if(countitem('@main[14]) == 0) {	mes ""+getitemname('@main[14])+"��";	mes "1�K�v�ł�";	close; }
		mes ""+getitemname('@main[14])+"��";
		mes "�I�������E�Ƃ̌����񐔂ɂ����";
		mes "�󂯎��A�C�e�����قȂ�܂�";
		mes "�������񐔂̓Q�[���A�J�E���g���ŋ��ʂł��B";
		mes "��凋C�O�ƕs�m�΂͌����񐔂����ʂł�";
		mes "_";
		mes "�������񐔗v�f�͖������ł�";
		next;
		mes "^ff0000��1��ڂ̌���";
		mes ""+getitemname('@itemA[0])+"1�A";
		mes "�I�������E�Ƃ̃N�G�X�g�{�[�i�XA�`�P�b�g 1��";
		mes "_";
		mes "�E�Ή��E��";
		mes "�h���S���i�C�g";
		mes "�A�[�N���C�W";
		mes "�E�C���h�z�[�N";
		mes "�J�[�f�B�i��";
		mes "�}�C�X�^�[";
		mes "�V���h�E�N���X";
		mes "�C���y���A���K�[�h";
		mes "�G�������^���}�X�^�[";
		mes "�g���o�h�D�[��";
		mes "�g�����F�[��";
		mes "�C���N�C�W�^�[";
		mes "�o�C�I���W�X�g";
		mes "�A�r�X�`�F�C�T�[";
		mes "�V��";
		mes "�\�E���A�Z�e�B�b�N";
		mes "凋C�O";
		mes "�s�m��";
		mes "�i�C�g�E�H�b�`";
		mes "�n�C�p�[�m�[�r�X";
		mes "�X�s���b�g�n���h���[^000000";
		next;
		mes "^ff0000��2��ڈȍ~�̌���";
		mes ""+getitemname('@limA)+"1��^000000";
		next;
		mes "["+strnpcinfo(1)+"]";
		mes "�ǂ̐E�Ƃɂ��܂����H";
		next;
		switch(select(
			"��߂�",
			"�h���S���i�C�g�i���� FLAG ��ځj",
			"�A�[�N���C�W�i���� FLAG ��ځj",
			"�E�C���h�z�[�N�i���� FLAG ��ځj",
			"�J�[�f�B�i���i���� FLAG ��ځj",
			"�}�C�X�^�[�i���� FLAG ��ځj",
			"�V���h�E�N���X�i���� FLAG ��ځj",
			"�C���y���A���K�[�h�i���� FLAG ��ځj",
			"�G�������^���}�X�^�[�i���� FLAG ��ځj",
			"�g���o�h�D�[���i���� FLAG ��ځj",
			"�g�����F�[���i���� FLAG ��ځj",
			"�C���N�C�W�^�[�i���� FLAG ��ځj",
			"�o�C�I���i���� FLAG ��ځj",
			"�A�r�X�`�F�C�T�[�i���� FLAG ��ځj",
			"�V��i���� FLAG ��ځj",
			"�\�E���A�Z�e�B�b�N�i���� FLAG ��ځj",
			"凋C�O�i���� FLAG ��ځj",
			"�s�m�΁i���� FLAG ��ځj",
			"�i�C�g�E�H�b�`�i���� FLAG ��ځj",
			"�n�C�p�[�m�[�r�X�i���� FLAG ��ځj",
			"�X�s���b�g�n���h���[�i���� FLAG ��ځj")) {

			case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@itemC,'@itemA[0];	set '@itemD,'@itemB[0];	break;
			case 3:	set '@itemC,'@itemA[1];	set '@itemD,'@itemB[1];	break;
			case 4:	set '@itemC,'@itemA[2];	set '@itemD,'@itemB[2];	break;
			case 5:	set '@itemC,'@itemA[3];	set '@itemD,'@itemB[3];	break;
			case 6:	set '@itemC,'@itemA[4];	set '@itemD,'@itemB[4];	break;
			case 7:	set '@itemC,'@itemA[5];	set '@itemD,'@itemB[5];	break;
			case 8:	set '@itemC,'@itemA[6];	set '@itemD,'@itemB[6];	break;
			case 9:	set '@itemC,'@itemA[7];	set '@itemD,'@itemB[7];	break;
			case 10:	set '@itemC,'@itemA[8];	set '@itemD,'@itemB[8];	break;
			case 11:	set '@itemC,'@itemA[9];	set '@itemD,'@itemB[9];	break;
			case 12:	set '@itemC,'@itemA[10];	set '@itemD,'@itemB[10];	break;
			case 13:	set '@itemC,'@itemA[11];	set '@itemD,'@itemB[11];	break;
			case 14:	set '@itemC,'@itemA[12];	set '@itemD,'@itemB[12];	break;
			case 15:	set '@itemC,'@itemA[13];	set '@itemD,'@itemB[13];	break;
			case 16:	set '@itemC,'@itemA[14];	set '@itemD,'@itemB[14];	break;
			case 17:	set '@itemC,'@itemA[15];	set '@itemD,'@itemB[15];	break;
			case 18:	set '@itemC,'@itemA[16];	set '@itemD,'@itemB[16];	break;
			case 19:	set '@itemC,'@itemA[17];	set '@itemD,'@itemB[17];	break;
			case 20:	set '@itemC,'@itemA[18];	set '@itemD,'@itemB[18];	break;
			case 21:	set '@itemC,'@itemA[19];	set '@itemD,'@itemB[19];	break;
			}
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[14])+"��";
			mes "1�����";
			mes ""+getitemname('@itemC)+"";
			mes ""+getitemname('@itemD)+"";
			mes "�󂯎��܂��B";
			mes "�������Ă���낵���ł����H";
			next;
			switch(select(
				"��߂�",
				"��������")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				/* set FLAG_CAA,FLAG_CAA + 1; */
				getitem '@itemC,1;	getitem '@itemD,1;	delitem '@main[14],1;
				mes "["+strnpcinfo(1)+"]";
				mes "�������܂���";
				close;
		}

	/* �Z���X�e�B�A���V���[�Y�����Z�b�g�`�P�b�g */
	case 17:
		if(countitem('@main[15]) == 0) {	mes ""+getitemname('@main[14])+"��";	mes "1�K�v�ł�";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@main[15])+"��";
		mes "1�����������";
		mes "�u�h���S���i�C�g�v�Z�b�g";
		mes "�u�A�[�N���C�W�v�Z�b�g";
		mes "�u�E�C���h�z�[�N�v�Z�b�g";
		mes "�u�J�[�f�B�i���v�Z�b�g";
		mes "�u�}�C�X�^�[�v�Z�b�g";
		mes "�u�V���h�E�N���X�v�Z�b�g";
		mes "�u�C���y���A���K�[�h�v�Z�b�g";
		mes "�u�G�������^���}�X�^�[�v�Z�b�g";
		mes "�u�g���o�h�D�[���v�Z�b�g";
		mes "�u�g�����F�[���v�Z�b�g";
		mes "�u�C���N�C�W�^�[�v�Z�b�g";
		mes "�u�o�C�I���v�Z�b�g";
		mes "�u�A�r�X�`�F�C�T�[�v�Z�b�g";
		mes "�u�V��v�Z�b�g";
		mes "�u�\�E���A�Z�e�B�b�N�v�Z�b�g";
		mes "�u凋C�O�E�s�m�΁v�Z�b�g";
		mes "�u�i�C�g�E�H�b�`�v�Z�b�g";
		mes "�u�n�C�p�[�m�[�r�X�v�Z�b�g";
		mes "�u�X�s���b�g�n���h���[�v�Z�b�g";
		mes "�̂ǂꂩ1�Z�b�g�ƌ������܂��B";
		next;
		mes "["+strnpcinfo(1)+"]";
		mes "�ǂ̃Z�b�g�ƌ������܂����H";
		next;
		switch(select(
			"��߂�",
			"�u�h���S���i�C�g�v�Z�b�g",
			"�u�A�[�N���C�W�v�Z�b�g",
			"�u�E�C���h�z�[�N�v�Z�b�g",
			"�u�J�[�f�B�i���v�Z�b�g",
			"�u�}�C�X�^�[�v�Z�b�g",
			"�u�V���h�E�N���X�v�Z�b�g",
			"�u�C���y���A���K�[�h�v�Z�b�g",
			"�u�G�������^���}�X�^�[�v�Z�b�g",
			"�u�g���o�h�D�[���v�Z�b�g",
			"�u�g�����F�[���v�Z�b�g",
			"�u�C���N�C�W�^�[�v�Z�b�g",
			"�u�o�C�I���v�Z�b�g",
			"�u�A�r�X�`�F�C�T�[�v�Z�b�g",
			"�u�V��v�Z�b�g",
			"�u�\�E���A�Z�e�B�b�N�v�Z�b�g",
			"�u凋C�O�E�s�m�΁v�Z�b�g",
			"�u�i�C�g�E�H�b�`�v�Z�b�g",
			"�u�n�C�p�[�m�[�r�X�v�Z�b�g",
			"�u�X�s���b�g�n���h���[�v�Z�b�g")) {
			case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
			case 2:	/*�h���S���i�C�g*/
				delitem 1002200,1;
				getitem2 630056,1,1,4,0,0,4853,314138,311899,0;
				getitem2 400907,1,1,4,0,0,29436,314138,312040,0;
				getitem2 450462,1,1,4,0,0,29307,314138,0,0;
				getitem2 480592,1,1,4,0,0,314165,314138,0,0;
				getitem2 470351,1,1,4,0,0,29509,314138,0,0;
				getitem2 490745,1,1,0,0,0,29649,314138,312949,0;
				break;
			case 3:	/*�A�[�N���C�W*/
				delitem 1002200,1;
				getitem2 640063,1,1,4,0,0,4856,314117,311891,0;
				getitem2 400907,1,1,4,0,0,4876,314117,312031,0;
				getitem2 450462,1,1,4,0,0,29307,314117,0,0;
				getitem2 480592,1,1,4,0,0,314165,314117,0,0;
				getitem2 470351,1,1,4,0,0,29371,314117,0,0;
				getitem2 490745,1,1,0,0,0,29650,314117,312473,0;
				break;
			case 4:	/*�E�C���h�z�[�N*/
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314126,311895,0;
				getitem2 400907,1,1,4,0,0,4879,314126,312036,0;
				getitem2 450462,1,1,4,0,0,29307,314126,0,0;
				getitem2 480592,1,1,4,0,0,314165,314126,0,0;
				getitem2 470351,1,1,4,0,0,29509,314126,0,0;
				getitem2 490745,1,1,0,0,0,29649,314126,312918,0;
				break;
			case 5:	/*�J�[�f�B�i��*/
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314130,311897,0;
				getitem2 400907,1,1,4,0,0,4876,314130,312645,0;
				getitem2 450462,1,1,4,0,0,29307,314130,0,0;
				getitem2 480592,1,1,4,0,0,314165,314130,0,0;
				getitem2 470351,1,1,4,0,0,29371,314130,0,0;
				getitem2 490745,1,1,0,0,0,29650,314130,312038,0;
				break;
			case 6:	/*�}�C�X�^�[*/
				delitem 1002200,1;
				getitem2 620052,1,1,4,0,0,4853,314151,311903,0;
				getitem2 400907,1,1,4,0,0,29436,314151,312978,0;
				getitem2 450462,1,1,4,0,0,29307,314151,0,0;
				getitem2 480592,1,1,4,0,0,314165,314151,0,0;
				getitem2 470351,1,1,4,0,0,29509,314151,0,0;
				getitem2 490745,1,1,0,0,0,29649,314151,313198,0;
				break;
			case 7:	/*�V���h�E�N���X*/
				delitem 1002200,1;
				getitem2 610081,1,1,4,0,0,4853,314132,311898,0;
				getitem2 400907,1,1,4,0,0,29436,314132,313283,0;
				getitem2 450462,1,1,4,0,0,29307,314132,0,0;
				getitem2 480592,1,1,4,0,0,314165,314132,0,0;
				getitem2 470351,1,1,4,0,0,29509,314132,0,0;
				getitem2 490745,1,1,0,0,0,29649,314132,312948,0;
				break;
			case 8:	/*�C���y���A���K�[�h*/
				delitem 1002200,1;
				getitem2 530070,1,1,4,0,0,4853,314124,311894,0;
				getitem2 400907,1,1,4,0,0,29436,314124,312917,0;
				getitem2 450462,1,1,4,0,0,29307,314124,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314124,0,0;
				getitem2 470351,1,1,4,0,0,29509,314124,0,0;
				getitem2 490745,1,1,0,0,0,29649,314124,312936,0;
				break;
			case 9:	/*�G�������^���}�X�^�[*/
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4856,314129,311896,0;
				getitem2 400907,1,1,4,0,0,4876,314129,312942,0;
				getitem2 450462,1,1,4,0,0,29307,314129,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314129,0,0;
				getitem2 470351,1,1,4,0,0,29371,314129,0,0;
				getitem2 490745,1,1,0,0,0,29650,314129,312303,0;
				break;
			case 10:	/*�g���o�h�D�[��*/
				delitem 1002200,1;
				getitem2 570082,1,1,4,0,0,4857,314141,311900,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,0,0,0,29649,314141,312952,0;
				break;
			case 11:	/*�g�����F�[��*/
				delitem 1002200,1;
				getitem2 580082,1,1,4,0,0,4857,314141,311901,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,0,0,0,29649,314141,312952,0;
				break;
			case 12:	/*�C���N�C�W�^�[*/
				delitem 1002200,1;
				getitem2 560076,1,1,4,0,0,4853,314122,311893,0;
				getitem2 400907,1,1,4,0,0,29436,314122,312933,0;
				getitem2 450462,1,1,4,0,0,29307,314122,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314122,0,0;
				getitem2 470351,1,1,4,0,0,29509,314122,0,0;
				getitem2 490745,1,1,0,0,0,29649,314122,312034,0;
				break;
			case 13:	/*�o�C�I��*/
				delitem 1002200,1;
				getitem2 500115,1,1,4,0,0,4853,314145,311902,0;
				getitem2 400907,1,1,4,0,0,29436,314145,312043,0;
				getitem2 450462,1,1,4,0,0,29307,314145,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314145,0,0;
				getitem2 470351,1,1,4,0,0,29509,314145,0,0;
				getitem2 490745,1,1,0,0,0,29649,314145,312301,0;
				break;
			case 14:	/*�A�r�X�`�F�C�T�[*/
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314119,311892,0;
				getitem2 400907,1,1,4,0,0,4879,314119,312931,0;
				getitem2 450462,1,1,4,0,0,29307,314119,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314119,0,0;
				getitem2 470351,1,1,4,0,0,29509,314119,0,0;
				getitem2 490745,1,1,0,0,0,29649,314119,312930,0;
				break;
			case 15:	/*�V��*/
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4853,314153,300499,0;
				getitem2 400907,1,1,4,0,0,29436,314153,312965,0;
				getitem2 450462,1,1,4,0,0,29307,314153,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314153,0,0;
				getitem2 470351,1,1,4,0,0,29509,314153,0,0;
				getitem2 490745,1,1,0,0,0,29649,314153,312964,0;
				break;
			case 16:	/*�\�E���A�Z�e�B�b�N*/
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314136,312923,0;
				getitem2 400907,1,1,4,0,0,4876,314136,312968,0;
				getitem2 450462,1,1,4,0,0,29307,314136,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314136,0,0;
				getitem2 470351,1,1,4,0,0,29371,314136,0,0;
				getitem2 490745,1,1,0,0,0,29650,314136,312966,0;
				break;
			case 17:	/*凋C�O�E�s�m��*/
				delitem 1002200,1;
				getitem2 510181,1,1,4,0,0,4853,314155,312925,0;
				getitem2 400907,1,1,4,0,0,29436,314155,312973,0;
				getitem2 450462,1,1,4,0,0,29307,314155,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314155,0,0;
				getitem2 470351,1,1,4,0,0,29509,314155,0,0;
				getitem2 490745,1,1,0,0,0,29649,314155,313480,0;
				break;
			case 18:	/*�i�C�g�E�H�b�`*/
				delitem 1002200,1;
				getitem2 810047,1,1,4,0,0,4857,314143,312924,0;
				getitem2 400907,1,1,4,0,0,4879,314143,312970,0;
				getitem2 450462,1,1,4,0,0,29307,314143,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314143,0,0;
				getitem2 470351,1,1,4,0,0,29509,314143,0,0;
				getitem2 490745,1,1,0,0,0,29649,314143,313477,0;
				break;
			case 19:	/*�n�C�p�[�m�[�r�X*/
				delitem 1002200,1;
				getitem2 590097,1,1,4,0,0,4856,314148,312922,0;
				getitem2 400907,1,1,4,0,0,4876,314148,313274,0;
				getitem2 450462,1,1,4,0,0,29307,314148,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314148,0,0;
				getitem2 470351,1,1,4,0,0,29371,314148,0,0;
				getitem2 490745,1,1,0,0,0,29650,314148,312962,0;
				break;
			case 20:	/*�X�s���b�g�n���h���[*/
				delitem 1002200,1;
				getitem2 550173,1,1,4,0,0,4853,314134,312926,0;
				getitem2 400907,1,1,4,0,0,29436,314134,312975,0;
				getitem2 450463,1,1,4,0,0,29307,314134,25672,0;
				getitem2 480592,1,1,4,0,0,314165,314134,0,0;
				getitem2 470351,1,1,4,0,0,29509,314134,0,0;
				getitem2 490745,1,1,0,0,0,29649,314134,313483,0;
				break;
			}
			mes "["+strnpcinfo(1)+"]";
			mes "�ǂ���";
			close;
	case 18:	mes "["+strnpcinfo(1)+"]"; mes "�ΏۃN�G�X�g����������Ă��܂���";	close;	/* �N�G�X�g�{�[�i�XA�`�P�b�g ���򂠂� */
	}
	mes "["+strnpcinfo(1)+"]";
	mes "�X�N���v�g�I��";
	close;
}
