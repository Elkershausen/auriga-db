//2025/06/17 �A�b�v�f�[�g
//�X�y�V�����A�C�e���̃`�P�b�g����NPC
//�C�x���g�Ȃǂ̈ꎞ�I�ȗv�f�ł͂Ȃ��P�v�I�ȗv�f�ł�
//���p�񐔕ۑ��t���O�K�v

//�Ǘ��pNPC�J�n

izlude.gat,143,150,3	shop	�Ǘ��p�`�P�b�g�̔�		10545,1002223,1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200

-	script	CashTicketExchange	{
	
	mes "["+strnpcinfo(1)+"]";
	mes "�����܂���";
	clearitem;
	gmcommand "@itemreset";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(25584)+"����";
	getitem 25584,100;
	close;
}
izlude.gat,143,150,3	duplicate(CashTicketExchange)	TicketSeller	70
//prontera.gat,150,160,2	duplicate(CashTicketExchange)	TicketSeller	70

//�Ǘ��pNPC�����܂�

izlude.gat,150,142,3	script	�~�X�e�B�A	91,{

	setarray '@main,1000203,1000204,1000206,25584,25913,1000531,1000534,1000472,1001268,1001271,1001279,1001681,1001683,1002063,1002199,1002200;

	if((Weight*100/MaxWeight) > 50) { mes "["+strnpcinfo(1)+"]"; mes "�����d�ʂ�50%�ȏ�󂯂ĉ������B"; close; }

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
		""+getitemname('@main[3])+" ����",
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
	case 2:	set '@ticket,0;	mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 3:	set '@ticket,1; mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 4:	set '@ticket,2; mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;

	case 5:	/*25584�E�ƃX�y�V�����`�P�b�g*/
	/* �E�ƕʃX�^�[�^�[�`�P�b�g[***VIP�`�P�b�g]�̏ꍇ��[3���E�}�X�^�[�v���O����]�ɂȂ� */
	set '@cost,1;
	set '@ref,7;
	if(countitem('@main[3]) == 0) {	mes ""+getitemname('@main[3])+"��";	mes ""+'@cost+"�� �K�v�ł�";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@main[3])+" "+'@cost+"��";
		mes "�E�Ƃɉ����������i�̃Z�b�g��";
		mes ""+getitemname(1000310)+" 3�Ɍ������܂��B";
		mes "�����i�͐��B�l + "+'@ref+" �ł��n�����܂��B";
		mes "�ǂ̃Z�b�g�ƌ������܂����H";
		next;
		switch(select(
			"��߂�",
			"���[���i�C�g",
			"�E�H�[���b�N",
			"�����W���[",
			"�A�[�N�r�V���b�v",
			"���J�j�b�N",
			"�M���`���N���X",
			"���C�����K�[�h",
			"�\�[�T���[",
			"�~���X�g����(�j)",
			"�����_���[(��)",
			"�C��",
			"�W�F�l�e�B�b�N",
			"�V���h�E�`�F�C�T�[",
			"����",
			"�\�E�����[�p�[",
			"�e�T",
			"�O",
			"���x���I��",
			"�X�[�p�[�m�[�r�X(���E�˔j)",
			"�T���i�[")) {
		case 1: mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;
		case 2:
			mes "["+strnpcinfo(1)+"]";	mes "���[���i�C�g�ł�낵���ł����H";
			next;
			if(select("������","���[���i�C�g�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 1150,1,1,'@ref,0,0,0,0,0,0;	//�V���{�̃N���X�i��
			getitem2 15418,1,1,'@ref,0,0,0,0,0,0;	//�V���{�̃��C��
			getitem2 19468,1,1,'@ref,0,0,0,0,0,0;	//�V���{�̃_�C�A�f��
			getitem2 20970,1,1,'@ref,0,0,0,0,0,0;	//�V���{�̃}���g
			getitem2 22227,1,1,'@ref,0,0,0,0,0,0;	//�V���{�̃V���[�Y
			getitem2 32261,1,1,0,0,0,0,0,0,0;	//�V���{�̃����O
			close;
		case 3:
			mes "["+strnpcinfo(1)+"]";	mes "�E�H�[���b�N�ł�낵���ł����H";
			next;
			if(select("������","�E�H�[���b�N�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 15426,1,1,'@ref,0,0,0,0,0,0;	//��r�{�̃��C��
			getitem2 19496,1,1,'@ref,0,0,0,0,0,0;	//��r�{�̃N���E��
			getitem2 20972,1,1,'@ref,0,0,0,0,0,0;	//��r�{�̃}���g
			getitem2 22231,1,1,'@ref,0,0,0,0,0,0;	//��r�{�̃V���[�Y
			getitem2 26167,1,1,'@ref,0,0,0,0,0,0;	//��r�{�̃X�^�b�t
			getitem2 32266,1,1,0,0,0,0,0,0,0;	//��r�{�̃����O
			close;
		case 4:
			mes "["+strnpcinfo(1)+"]";	mes "�����W���[�ł�낵���ł����H";
			next;
			if(select("������","�����W���[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5739,1,1,'@ref,0,0,0,0,0,0;	//�l�n�{�̃N���E��
			getitem2 450140,1,1,'@ref,0,0,0,0,0,0;	//�l�n�{�̃��C��
			getitem2 470045,1,1,'@ref,0,0,0,0,0,0;	//�l�n�{�̃V���[�Y
			getitem2 480050,1,1,'@ref,0,0,0,0,0,0;	//�l�n�{�̃}���g
			getitem2 700010,1,1,'@ref,0,0,0,0,0,0;	//�l�n�{�̃n���^�[�{�E
			getitem2 490041,1,1,0,0,0,0,0,0,0;	//�l�n�{�̃����O
			close;
		case 5:
			mes "["+strnpcinfo(1)+"]";	mes "�A�[�N�r�V���b�v�ł�낵���ł����H";
			next;
			if(select("������","�A�[�N�r�V���b�v�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5599,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃_�C�A�f��
			getitem2 450015,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃��C��
			getitem2 470014,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃V���[�Y
			getitem2 480009,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃}���g
			getitem2 640002,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃f�B�o�C���N���X
			getitem2 490010,1,1,0,0,0,0,0,0,0;	//�����{�̃����O
			close;
		case 6:
			mes "["+strnpcinfo(1)+"]";	mes "���J�j�b�N�ł�낵���ł����H";
			next;
			if(select("������","���J�j�b�N�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 1335,1,1,'@ref,0,0,0,0,0,0;	//���I�{�̃A�b�N�X
			getitem2 15412,1,1,'@ref,0,0,0,0,0,0;	//���I�{�̃��C��
			getitem2 19449,1,1,'@ref,0,0,0,0,0,0;	//���I�{�̃N���E��
			getitem2 20954,1,1,'@ref,0,0,0,0,0,0;	//���I�{�̃}���g
			getitem2 22216,1,1,'@ref,0,0,0,0,0,0;	//���I�{�̃V���[�Y
			getitem2 32253,1,1,0,0,0,0,0,0,0;	//���I�{�̃����O
			close;
		case 7:
			mes "["+strnpcinfo(1)+"]";	mes "�M���`���N���X�ł�낵���ł����H";
			next;
			if(select("������","�M���`���N���X�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 15424,1,1,'@ref,0,0,0,0,0,0;	//�V噋{�̃��C��
			getitem2 19471,1,1,'@ref,0,0,0,0,0,0;	//�V噋{�̃N���E��
			getitem2 20976,1,1,'@ref,0,0,0,0,0,0;	//�V噋{�̃}���g
			getitem2 22233,1,1,'@ref,0,0,0,0,0,0;	//�V噋{�̃V���[�Y
			getitem2 28047,1,1,'@ref,0,0,0,0,0,0;	//�V噋{�̃J�^�[��
			getitem2 32267,1,1,0,0,0,0,0,0,0;	//�V噋{�̃����O
			close;
		case 8:
			mes "["+strnpcinfo(1)+"]";	mes "���C�����K�[�h�ł�낵���ł����H";
			next;
			if(select("������","���C�����K�[�h�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5546,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃N���E��
			getitem2 32031,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃X�s�A�[
			getitem2 450129,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃��C��
			getitem2 460002,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃V�[���h
			getitem2 470024,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃V���[�Y
			getitem2 480022,1,1,'@ref,0,0,0,0,0,0;	//���r�{�̃}���g
			getitem2 490028,1,1,0,0,0,0,0,0,0;	//���r�{�̃����O
			close;
		case 9:
			mes "["+strnpcinfo(1)+"]";	mes "�\�[�T���[�ł�낵���ł����H";
			next;
			if(select("������","�\�[�T���[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5514,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃_�C�A�f��
			getitem2 450133,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃��C��
			getitem2 470038,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃V���[�Y
			getitem2 480041,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃}���g
			getitem2 640006,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃X�^�b�t�I�u�\�E��
			getitem2 490034,1,1,0,0,0,0,0,0,0;	//�o���{�̃����O
			close;
		case 10:
			mes "["+strnpcinfo(1)+"]";	mes "�~���X�g�����ł�낵���ł����H";
			next;
			if(select("������","�~���X�g�����ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5569,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃_�C�A�f��
			getitem2 450130,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃��C��
			getitem2 470032,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃V���[�Y
			getitem2 480026,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃}���g
			getitem2 570004,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃o�C�I����
			getitem2 490032,1,1,0,0,0,0,0,0,0;	//�o���{�̃����O
			close;
		case 11:
			mes "["+strnpcinfo(1)+"]";	mes "�����_���[�ł�낵���ł����H";
			next;
			if(select("������","�����_���[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 5569,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃_�C�A�f��
			getitem2 450130,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃��C��
			getitem2 470032,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃V���[�Y
			getitem2 480026,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃}���g
			getitem2 580004,1,1,'@ref,0,0,0,0,0,0;	//�o���{�̃��[�v
			getitem2 490032,1,1,0,0,0,0,0,0,0;	//�o���{�̃����O
			close;
		case 12:
			mes "["+strnpcinfo(1)+"]";	mes "�C���ł�낵���ł����H";
			next;
			if(select("������","�C���ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 15408,1,1,'@ref,0,0,0,0,0,0;	//���q�{�̃��C��
			getitem2 16098,1,1,'@ref,0,0,0,0,0,0;	//���q�{�̃��C�X
			getitem2 19447,1,1,'@ref,0,0,0,0,0,0;	//���q�{�̃N���E��
			getitem2 20951,1,1,'@ref,0,0,0,0,0,0;	//���q�{�̃}���g
			getitem2 22213,1,1,'@ref,0,0,0,0,0,0;	//���q�{�̃V���[�Y
			getitem2 32247,1,1,0,0,0,0,0,0,0;	//���q�{�̃����O
			close;
		case 13:
			mes "["+strnpcinfo(1)+"]";	mes "�W�F�l�e�B�b�N�ł�낵���ł����H";
			next;
			if(select("������","�W�F�l�e�B�b�N�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 1100,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃\�[�h
			getitem2 15425,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃��C��
			getitem2 19473,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃_�C�A�f��
			getitem2 20971,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃}���g
			getitem2 22230,1,1,'@ref,0,0,0,0,0,0;	//�����{�̃V���[�Y
			getitem2 32264,1,1,0,0,0,0,0,0,0;	//�����{�̃����O
			close;
		case 14:
			mes "["+strnpcinfo(1)+"]";	mes "�V���h�E�`�F�C�T�[�ł�낵���ł����H";
			next;
			if(select("������","�V���h�E�`�F�C�T�[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			delitem '@main[3],'@cost;
			getitem 1000310,3;			//�W���u�X�g�[��
			getitem2 400015,1,1,'@ref,0,0,0,0,0,0;	//��㹋{�̃_�C�A�f��
			getitem2 450011,1,1,'@ref,0,0,0,0,0,0;	//��㹋{�̃��C��
			getitem2 470010,1,1,'@ref,0,0,0,0,0,0;	//��㹋{�̃V���[�Y
			getitem2 480006,1,1,'@ref,0,0,0,0,0,0;	//��㹋{�̃}���g
			getitem2 700004,1,1,'@ref,0,0,0,0,0,0;	//��㹋{�̃V�[�t�{�E
			getitem2 490009,1,1,0,0,0,0,0,0,0;	//��㹋{�̃����O
			close;
		case 15: /*����*/
			mes "["+strnpcinfo(1)+"]";	mes "����ł�낵���ł����H";
			next;
			if(select("������","����ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			setarray '@tk,	32293,	29716,	29717,	29718;
			set '@cardA,0;
			set '@cardB,0;
			set '@cardC,0;
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@tk[0])+" ��";
			mes "�u"+getitemname('@tk[1])+"�v�u"+getitemname('@tk[2])+"�v�u"+getitemname('@tk[3])+"�v";
			mes "�̂���1�����G���`�����g���\�ł��B";
			mes "�G���`�����g��I��ŉ������B";
			next;
			switch(select(
				"��߂�",
				""+getitemname('@tk[1])+"",
				""+getitemname('@tk[2])+"",
				""+getitemname('@tk[3])+"")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@cardD,'@tk[1];	break;
				case 3: set '@cardD,'@tk[2];	break;
				case 4:	set '@cardD,'@tk[3];	break; }
					delitem '@main[3],'@cost;
					getitem 1000310,3;
					getitem2 2400,1,1,'@ref,0,0,0,0,0,0;	//�|���b�N�X�V���[�Y
					getitem2 15447,1,1,'@ref,0,0,0,0,0,0;	//�|���b�N�X���[�u
					getitem2 15823,1,1,'@ref,0,0,0,0,0,0;	//�|���b�N�X�N���E��
					getitem2 20983,1,1,'@ref,0,0,0,0,0,0;	//�|���b�N�X�}���g
					getitem2 28643,1,1,'@ref,0,0,0,0,0,0;	//�|���b�N�X�u�b�N
					getitem2 32293,1,1,0,0,'@cardA,'@cardB,'@cardC,'@cardD,0;	//�|���b�N�X�����O
			close;
		case 16: /*�\�E�����[�p�[*/
			mes "["+strnpcinfo(1)+"]";	mes "�\�E�����[�p�[�ł�낵���ł����H";
			next;
			if(select("������","�\�E�����[�p�[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			setarray '@sl,	32294,	29719,	29720,	29721;
			set '@cardA,0;
			set '@cardB,0;
			set '@cardC,0;
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@sl[0])+" ��";
			mes "�u"+getitemname('@sl[1])+"�v�u"+getitemname('@sl[2])+"�v�u"+getitemname('@sl[3])+"�v";
			mes "�̂���1�����G���`�����g���\�ł��B";
			mes "�G���`�����g��I��ŉ������B";
			next;
			switch(select(
				"��߂�",
				""+getitemname('@sl[1])+"",
				""+getitemname('@sl[2])+"",
				""+getitemname('@sl[3])+"")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@cardD,'@sl[1];	break;
				case 3: set '@cardD,'@sl[2];	break;
				case 4:	set '@cardD,'@sl[3];	break; }
					delitem '@main[3],'@cost;
					getitem 1000310,3;
					getitem2 15448,1,1,'@ref,0,0,0,0,0,0;	//�v���L�I�����[�u
					getitem2 15824,1,1,'@ref,0,0,0,0,0,0;	//�v���L�I���N���E��
					getitem2 20984,1,1,'@ref,0,0,0,0,0,0;	//�v���L�I���}���g
					getitem2 22242,1,1,'@ref,0,0,0,0,0,0;	//�v���L�I���V���[�Y
					getitem2 28784,1,1,'@ref,0,0,0,0,0,0;	//�v���L�I���_�K�[
					getitem2 32294,1,1,0,0,'@cardA,'@cardB,'@cardC,'@cardD,0;	//�v���L�I�������O
			close;
		case 17:	mes "["+strnpcinfo(1)+"]"; mes "�e�T�ɂ�";		mes "�����\�ȃA�C�e��������܂���B";	close;
		case 18:	mes "["+strnpcinfo(1)+"]"; mes "�O�ɂ�";		mes "�����\�ȃA�C�e��������܂���B";	close;
		case 19:	mes "["+strnpcinfo(1)+"]"; mes "���x���I���ɂ�";	mes "�����\�ȃA�C�e��������܂���B";	close;
		case 20:	mes "["+strnpcinfo(1)+"]"; mes "�X�[�p�[�m�[�r�X(���E�˔j)�ɂ�";	mes "�����\�ȃA�C�e��������܂���B";	close;
		case 21: /*�T���i�[*/
			mes "["+strnpcinfo(1)+"]";	mes "�T���i�[�ł�낵���ł����H";
			next;
			if(select("������","�T���i�[�ɂ���") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;	}
			setarray '@nc,	28577,	28578,	28579;
			setarray '@om,	28589,	28590,	28591;
			mes "["+strnpcinfo(1)+"]";
			mes "�l�b�N���X��I��ŉ������B";
			next;
			switch(select(
				"��߂�",
				""+getitemname('@nc[0])+"",
				""+getitemname('@nc[1])+"",
				""+getitemname('@nc[2])+"")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@accA,'@nc[0];	break;
				case 3: set '@accA,'@nc[1];	break;
				case 4: set '@accA,'@nc[2];	break;	}
			mes "["+strnpcinfo(1)+"]";
			mes "������I��ŉ������B";
			next;
			switch(select(
				"��߂�",
				""+getitemname('@om[0])+"",
				""+getitemname('@om[1])+"",
				""+getitemname('@om[2])+"")) {
				case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@accB,'@om[0];	break;
				case 3: set '@accB,'@om[1];	break;
				case 4: set '@accB,'@om[2];	break;	}
					delitem '@main[3],'@cost;
					getitem 1000310,3;
					getitem2 15277,1,1,'@ref,0,0,0,0,0,0;	//���I�h�����X�[�c
					getitem2 20917,1,1,'@ref,0,0,0,0,0,0;	//���I�h�����P�[�v
					getitem2 22187,1,1,'@ref,0,0,0,0,0,0;	//���I�h�����V���[�Y
					getitem2 19347,1,1,'@ref,0,0,0,0,0,0;	//�������V�����l�R
					getitem '@accA,1;			//�l�b�N���X
					getitem '@accB,1;			//�����
			close;
		}
	case 6: mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 7: mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 8: mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
	case 9: mes "["+strnpcinfo(1)+"]"; mes "��������\��";	close;
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
		if(countitem('@main[15]) == 0) {	mes ""+getitemname('@main[15])+"��";	mes "1�K�v�ł�";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@main[15])+"";
		mes "��1��";
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
		mes "�ǂ̐E�ƃZ�b�g�ƌ������܂����H";
		next;
		switch(select(
			"��߂�",
			"�h���S���i�C�g",
			"�A�[�N���C�W",
			"�E�C���h�z�[�N",
			"�J�[�f�B�i��",
			"�}�C�X�^�[",
			"�V���h�E�N���X",
			"�C���y���A���K�[�h",
			"�G�������^���}�X�^�[",
			"�g���o�h�D�[��",
			"�g�����F�[��",
			"�C���N�C�W�^�[",
			"�o�C�I��",
			"�A�r�X�`�F�C�T�[",
			"�V��",
			"�\�E���A�Z�e�B�b�N",
			"凋C�O�E�s�m��",
			"�i�C�g�E�H�b�`",
			"�n�C�p�[�m�[�r�X",
			"�X�s���b�g�n���h���[")) {
			case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
			case 2:	/*�h���S���i�C�g*/
				mes "["+strnpcinfo(1)+"]";
				mes "�h���S���i�C�g�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�h���S���i�C�g�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 630056,1,1,4,0,0,4853,314138,311899,0;
				getitem2 400907,1,1,4,0,0,29436,314138,312040,0;
				getitem2 450462,1,1,4,0,0,29307,314138,0,0;
				getitem2 480592,1,1,4,0,0,314165,314138,0,0;
				getitem2 470351,1,1,4,0,0,29509,314138,0,0;
				getitem2 490745,1,1,0,0,0,29649,314138,312949,0;	break;
				case 3:	break;	}
				break;
			case 3:	/*�A�[�N���C�W*/
				mes "["+strnpcinfo(1)+"]";
				mes "�A�[�N���C�W�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�A�[�N���C�W�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 640063,1,1,4,0,0,4856,314117,311891,0;
				getitem2 400907,1,1,4,0,0,4876,314117,312031,0;
				getitem2 450462,1,1,4,0,0,29307,314117,0,0;
				getitem2 480592,1,1,4,0,0,314165,314117,0,0;
				getitem2 470351,1,1,4,0,0,29371,314117,0,0;
				getitem2 490745,1,1,0,0,0,29650,314117,312473,0;	break;
				case 3:	break;	}
				break;
			case 4:	/*�E�C���h�z�[�N*/
				mes "["+strnpcinfo(1)+"]";
				mes "�E�C���h�z�[�N�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�E�C���h�z�[�N�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314126,311895,0;
				getitem2 400907,1,1,4,0,0,4879,314126,312036,0;
				getitem2 450462,1,1,4,0,0,29307,314126,0,0;
				getitem2 480592,1,1,4,0,0,314165,314126,0,0;
				getitem2 470351,1,1,4,0,0,29509,314126,0,0;
				getitem2 490745,1,1,0,0,0,29649,314126,312918,0;	break;
				case 3:	break;	}
				break;
			case 5:	/*�J�[�f�B�i��*/
				mes "["+strnpcinfo(1)+"]";
				mes "�J�[�f�B�i���ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�J�[�f�B�i���T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314130,311897,0;
				getitem2 400907,1,1,4,0,0,4876,314130,312645,0;
				getitem2 450462,1,1,4,0,0,29307,314130,0,0;
				getitem2 480592,1,1,4,0,0,314165,314130,0,0;
				getitem2 470351,1,1,4,0,0,29371,314130,0,0;
				getitem2 490745,1,1,0,0,0,29650,314130,312038,0;	break;
				case 3:	break;	}
				break;
			case 6:	/*�}�C�X�^�[*/
				mes "["+strnpcinfo(1)+"]";
				mes "�}�C�X�^�[�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�}�C�X�^�[�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 620052,1,1,4,0,0,4853,314151,311903,0;
				getitem2 400907,1,1,4,0,0,29436,314151,312978,0;
				getitem2 450462,1,1,4,0,0,29307,314151,0,0;
				getitem2 480592,1,1,4,0,0,314165,314151,0,0;
				getitem2 470351,1,1,4,0,0,29509,314151,0,0;
				getitem2 490745,1,1,0,0,0,29649,314151,313198,0;	break;
				case 3:	break;	}
				break;
			case 7:	/*�V���h�E�N���X*/
				mes "["+strnpcinfo(1)+"]";
				mes "�V���h�E�N���X�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�V���h�E�N���X�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 610081,1,1,4,0,0,4853,314132,311898,0;
				getitem2 400907,1,1,4,0,0,29436,314132,313283,0;
				getitem2 450462,1,1,4,0,0,29307,314132,0,0;
				getitem2 480592,1,1,4,0,0,314165,314132,0,0;
				getitem2 470351,1,1,4,0,0,29509,314132,0,0;
				getitem2 490745,1,1,0,0,0,29649,314132,312948,0;	break;
				case 3:	break;	}
				break;
			case 8:	/*�C���y���A���K�[�h*/
				mes "["+strnpcinfo(1)+"]";
				mes "�C���y���A���K�[�h�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�C���y���A���K�[�h�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 530070,1,1,4,0,0,4853,314124,311894,0;
				getitem2 400907,1,1,4,0,0,29436,314124,312917,0;
				getitem2 450462,1,1,4,0,0,29307,314124,0,0;
				getitem2 480592,1,1,4,0,0,314165,314124,0,0;
				getitem2 470351,1,1,4,0,0,29509,314124,0,0;
				getitem2 490745,1,1,0,0,0,29649,314124,312936,0;	break;
				case 3:	break;	}
				break;
			case 9:	/*�G�������^���}�X�^�[*/
				mes "["+strnpcinfo(1)+"]";
				mes "�G�������^���}�X�^�[�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�G�������^���}�X�^�[�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4856,314129,311896,0;
				getitem2 400907,1,1,4,0,0,4876,314129,312942,0;
				getitem2 450462,1,1,4,0,0,29307,314129,0,0;
				getitem2 480592,1,1,4,0,0,314165,314129,0,0;
				getitem2 470351,1,1,4,0,0,29371,314129,0,0;
				getitem2 490745,1,1,0,0,0,29650,314129,312303,0;	break;
				case 3:	break;	}
				break;
			case 10: /*�g���o�h�D�[��*/
				mes "["+strnpcinfo(1)+"]";
				mes "�g���o�h�D�[���ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�g���o�h�D�[���T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 570082,1,1,4,0,0,4857,314141,311900,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,0,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,0,0,0,29649,314141,312952,0;	break;
				case 3:	break;	}
				break;
			case 11: /*�g�����F�[��*/
				mes "["+strnpcinfo(1)+"]";
				mes "�g�����F�[���ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�g�����F�[���T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 580082,1,1,4,0,0,4857,314141,311901,0;
				getitem2 400907,1,1,4,0,0,4879,314141,312919,0;
				getitem2 450462,1,1,4,0,0,29307,314141,0,0;
				getitem2 480592,1,1,4,0,0,314165,314141,0,0;
				getitem2 470351,1,1,4,0,0,29509,314141,0,0;
				getitem2 490745,1,1,4,0,0,29649,314141,312952,0;	break;
				case 3:	break;	}
				break;
			case 12: /*�C���N�C�W�^�[*/
				mes "["+strnpcinfo(1)+"]";
				mes "�C���N�C�W�^�[�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�C���N�C�W�^�[�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 560076,1,1,4,0,0,4853,314122,311893,0;
				getitem2 400907,1,1,4,0,0,29436,314122,312933,0;
				getitem2 450462,1,1,4,0,0,29307,314122,0,0;
				getitem2 480592,1,1,4,0,0,314165,314122,0,0;
				getitem2 470351,1,1,4,0,0,29509,314122,0,0;
				getitem2 490745,1,1,0,0,0,29649,314122,312034,0;	break;
				case 3:	break;	}
				break;
			case 13: /*�o�C�I��*/
				mes "["+strnpcinfo(1)+"]";
				mes "�o�C�I���ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�o�C�I���T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 500115,1,1,4,0,0,4853,314145,311902,0;
				getitem2 400907,1,1,4,0,0,29436,314145,312043,0;
				getitem2 450462,1,1,4,0,0,29307,314145,0,0;
				getitem2 480592,1,1,4,0,0,314165,314145,0,0;
				getitem2 470351,1,1,4,0,0,29509,314145,0,0;
				getitem2 490745,1,1,0,0,0,29649,314145,312301,0;	break;
				case 3:	break;	}
				break;
			case 14: /*�A�r�X�`�F�C�T�[*/
				mes "["+strnpcinfo(1)+"]";
				mes "�A�r�X�`�F�C�T�[�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�A�r�X�`�F�C�T�[�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 700115,1,1,4,0,0,4857,314119,311892,0;
				getitem2 400907,1,1,4,0,0,4879,314119,312931,0;
				getitem2 450462,1,1,4,0,0,29307,314119,0,0;
				getitem2 480592,1,1,4,0,0,314165,314119,0,0;
				getitem2 470351,1,1,4,0,0,29509,314119,0,0;
				getitem2 490745,1,1,0,0,0,29649,314119,312930,0;	break;
				case 3:	break;	}
				break;
			case 15: /*�V��*/
				mes "["+strnpcinfo(1)+"]";
				mes "�V��ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�V��T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 540103,1,1,4,0,0,4853,314153,300499,0;
				getitem2 400907,1,1,4,0,0,29436,314153,312965,0;
				getitem2 450462,1,1,4,0,0,29307,314153,0,0;
				getitem2 480592,1,1,4,0,0,314165,314153,0,0;
				getitem2 470351,1,1,4,0,0,29509,314153,0,0;
				getitem2 490745,1,1,0,0,0,29649,314153,312964,0;	break;
				case 3:	break;	}
				break;
			case 16: /*�\�E���A�Z�e�B�b�N*/
				mes "["+strnpcinfo(1)+"]";
				mes "�\�E���A�Z�e�B�b�N�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�\�E���A�Z�e�B�b�N�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550172,1,1,4,0,0,4856,314136,312923,0;
				getitem2 400907,1,1,4,0,0,4876,314136,312968,0;
				getitem2 450462,1,1,4,0,0,29307,314136,0,0;
				getitem2 480592,1,1,4,0,0,314165,314136,0,0;
				getitem2 470351,1,1,4,0,0,29371,314136,0,0;
				getitem2 490745,1,1,0,0,0,29650,314136,312966,0;	break;
				case 3:	break;	}
				break;
			case 17: /*凋C�O�E�s�m��*/
				mes "["+strnpcinfo(1)+"]";
				mes "凋C�O�E�s�m�΂ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","凋C�O�E�s�m�·T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 510181,1,1,4,0,0,4853,314155,312925,0;
				getitem2 400907,1,1,4,0,0,29436,314155,312973,0;
				getitem2 450462,1,1,4,0,0,29307,314155,0,0;
				getitem2 480592,1,1,4,0,0,314165,314155,0,0;
				getitem2 470351,1,1,4,0,0,29509,314155,0,0;
				getitem2 490745,1,1,0,0,0,29649,314155,313480,0;	break;
				case 3:	break;	}
				break;
			case 18: /*�i�C�g�E�H�b�`*/
				mes "["+strnpcinfo(1)+"]";
				mes "�i�C�g�E�H�b�`�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�i�C�g�E�H�b�`�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 810047,1,1,4,0,0,4857,314143,312924,0;
				getitem2 400907,1,1,4,0,0,4879,314143,312970,0;
				getitem2 450462,1,1,4,0,0,29307,314143,0,0;
				getitem2 480592,1,1,4,0,0,314165,314143,0,0;
				getitem2 470351,1,1,4,0,0,29509,314143,0,0;
				getitem2 490745,1,1,0,0,0,29649,314143,313477,0;	break;
				case 3:	break;	}
				break;
			case 19: /*�n�C�p�[�m�[�r�X*/
				mes "["+strnpcinfo(1)+"]";
				mes "�n�C�p�[�m�[�r�X�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�n�C�p�[�m�[�r�X�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 590097,1,1,4,0,0,4856,314148,312922,0;
				getitem2 400907,1,1,4,0,0,4876,314148,313274,0;
				getitem2 450462,1,1,4,0,0,29307,314148,0,0;
				getitem2 480592,1,1,4,0,0,314165,314148,0,0;
				getitem2 470351,1,1,4,0,0,29371,314148,0,0;
				getitem2 490745,1,1,0,0,0,29650,314148,312962,0;	break;
				case 3:	break;	}
				break;
			case 20: /*�X�s���b�g�n���h���[*/
				mes "["+strnpcinfo(1)+"]";
				mes "�X�s���b�g�n���h���[�ł���";
				mes "�󂯎�鑕���Z�b�g�����I�щ������B";
				next;
				switch(select("��߂�","�X�s���b�g�n���h���[�T�Z�b�g","�ǉ��\��g")) {
				case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
				case 2:
				delitem 1002200,1;
				getitem2 550173,1,1,4,0,0,4853,314134,312926,0;
				getitem2 400907,1,1,4,0,0,29436,314134,312975,0;
				getitem2 450463,1,1,4,0,0,29307,314134,0,0;
				getitem2 480592,1,1,4,0,0,314165,314134,0,0;
				getitem2 470351,1,1,4,0,0,29509,314134,0,0;
				getitem2 490745,1,1,0,0,0,29649,314134,313483,0;	break;
				case 3:	break;	}
				break;
			}
			mes "["+strnpcinfo(1)+"]";
			mes "���󂯎�艺�����B";
			close;
	case 18:	mes "["+strnpcinfo(1)+"]"; mes "�ΏۃN�G�X�g����������Ă��܂���";	close;	/* �N�G�X�g�{�[�i�XA�`�P�b�g ���򂠂� */
	}
	mes "["+strnpcinfo(1)+"]";
	mes "�X�N���v�g�I��";
	close;
}
