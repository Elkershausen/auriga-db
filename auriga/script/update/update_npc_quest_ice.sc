//20240515 �A�b�v�f�[�g
//20140819 �A�b�v�f�[�g�Ή� [�A�C�X�N���[��] �w�������500�ɑ���
//npc_quest_ice.sc �㏑��

-	script	IceBuyer	85,{
	mes "[�A�C�X�N���[�����l]";
	if(strnpcinfo(2) == "moc") {
		mes "�����A�����N����ς�";
		mes "�������炱��";
		mes "�₽���A�C�X�N���[���I";
		mes "^3355FF100 Zeny^000000��";
		mes "�g���S���u�₩�Ƀ��t���b�V���I";
		mes "�����ւ̊��͂ɂ������ł����I";
	}
	else if(strnpcinfo(2) == "moc_") {
		mes "�����A�v�킸�H�ׂ����Ȃ�";
		mes "�₽���A�C�X�N���[���I";
		mes "^3355FF100 Zeny^000000��";
		mes "�g���S���u�₩�ɁI";
	}
	if(strnpcinfo(2) == "bra") {
		mes "�����A���`���u���W���X��";
		mes "�߂��`���A�C�X�N���[���͂������I";
		mes "�₽���A�C�X�N���[���I";
		mes "^3355FF100 Zeny^000000��";
		mes "�g���S���u�₩�Ƀ��t���b�V���I";
		mes "����������I";
	}
	else {
		mes "�₽���ĊÁ`��";
		mes "�A�C�X�N���[���I";
		mes "^3355FF100 Zeny^000000��";
		mes "�g���S���u�₩�ɁI";
	}
	next;
	switch(select("�A�C�X�N���[�������������I","�A�C�X�N���[���ɂ���","�������߂�")) {
	case 1:
		mes "[�A�C�X�N���[�����l]";
		if(strnpcinfo(2) == "moc") {
			mes "���肪�Ƃ��������܂�!!";
			mes "���̃L�����v�Ɉړ]�����̂�";
			mes "���������ɐ������𑝂₵���̂�";
			mes "���X�ł͈�x��500�܂�";
			mes "���������߂��������܂��I";
			set '@max,500;
		}
		else if(strnpcinfo(2) == "moc_") {
			mes "�₽���ĊÂ��A�C�X�N���[����";
			mes "����ȍ����ł͖{���ɑ厖��";
			mes "�⋋���B��x��500�܂�";
			mes "���������߂��������܂��B";
			set '@max,500;
		}
		else if(strnpcinfo(2) == "bra") {
			mes "���肪�Ƃ��������܂�!!";
			mes "�����u���W���X�ł�";
			mes "�ō��̃A�C�X�N���[�������@��";
			mes "�������Ă���܂��̂ŁA���X�ł�";
			mes "��x��500�܂�";
			mes "���������߂��������܂��I";
			set '@max,500;
		}
		else {
			mes "�A�C�X�N���[����";
			mes "����ɂ҂�����I";
			mes "��x��500�܂�";
			mes "���������߂��������܂��B";
			set '@max,500;
		}
		while(1) {
			next;
			input '@num;
			if('@num > '@max) {
				mes "[�A�C�X�N���[�����l]";
				mes "���H";
				mes "������Ƒ������ł��B";
				mes "��x�ɔ̔��ł���̂�";
				mes '@max+ "�܂łł��B";
				mes "���܂�H�׉߂����";
				mes "�������󂵂܂���`�B";
				continue;
			}
			break;
		}
		if('@num <= 0) {
			mes "[�A�C�X�N���[�����l]";
			mes "����H";
			mes "�����̒��q���ǂ��Ȃ��̂ł����H";
			close;
		}
		if(Zeny<'@num*100) {
			mes "[�A�C�X�N���[�����l]";
			mes "���q����A����������Ȃ��ł��c";
			mes "��� ^3355FF100 Zeny^000000�ł���I";
			close;
		}
		if(checkweight(536,'@num)==0) {
			mes "[�A�C�X�N���[�����l]";
			mes "���q����A������Ɖו���";
			mes "�������܂��ˁB";
			mes "�A�C�X�N���[���𗎂Ƃ��Ă��܂��܂��B";
			mes "�����������炵�Ă��痈�ĉ������`�B";
			close;
		}
		set Zeny,Zeny-'@num*100;
		getitem 536,'@num;
		mes "[�A�C�X�N���[�����l]";
		mes "�͂��A" +'@num+ "�ˁB";
		mes "���肪�Ƃ��������܂����[�B";
		close;
	case 2:
		mes "[�A�C�X�N���[�����l]";
		mes "�u�A�C�X�N���[���v�͂ł��ˁc";
		mes "�����E�����i�̎��b��";
		mes "�������Ō`�����匴���ɁA";
		mes "�����E�����E����܁E������";
		mes "�F�f�Ȃǂ������č������A";
		next;
		mes "[�A�C�X�N���[�����l]";
		mes "�A���Ăē����������H�ו��ł��B";
		mes "�ׂ��������ƁA";
		mes "���Ō`��15%�ȏ�";
		mes "���������b8%�ȏ�";
		mes "�̂��̂ł��ˁB";
		next;
		mes "[�A�C�X�N���[�����l]";
		mes "�G�l���M�[�Ɖh�{���L�x��";
		mes "�ƂĂ�����������ł����A";
		mes "������ƌ����ĐH�׉߂����";
		mes "�������󂵂܂���I";
		close;
	case 3:
		mes "[�A�C�X�N���[�����l]";
		mes "�����̋@��𓦂���";
		mes "�������키���Ƃ�";
		mes "�ł��Ȃ��Ȃ邩������܂����H";
		mes "�����A�����A�������ł����`�H";
		close;
	}
}

//morocc.gat,160,143,4	duplicate(IceBuyer)	�A�C�X�N���[�����l#moc	85
moc_ruins.gat,81,155,4	duplicate(IceBuyer)	�A�C�X�N���[�����l#moc	85
alberta.gat,107,73,4	duplicate(IceBuyer)	�A�C�X�N���[�����l#alb	85
moc_fild16.gat,88,304,4	duplicate(IceBuyer)	�A�C�X�N���[�����l#moc_	85
brasilis.gat,189,225,3	duplicate(IceBuyer)	�A�C�X�N���[�����l#bra	85
