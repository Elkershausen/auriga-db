//2025/06/24 �A�b�v�f�[�g
//�����̖��{ ���{�����c�L�����v
//�ǉ��K�v	map :lby_in.gat

//�}�b�v�t���O��������
//lby_in.gat	mapflag	nosave		SavePoint
lby_in.gat	mapflag	nomemo		dummy
lby_in.gat	mapflag	noteleport	dummy
lby_in.gat	mapflag	nobranch	dummy
lby_in.gat	mapflag	monster_noteleport	dummy
lby_in.gat	mapflag	noicewall	dummy
lby_in.gat	mapflag	noabra		dummy

//�q�ɃT�[�r�X
//npc_mimic_storage.sc

//�A�C�e������
lby_in.gat,59,86,4	script	�����T���B��#32193	415,{

	setarray '@main,	25237,783,25662,1000999;
	if((Weight*100/MaxWeight) > 90) { mes "["+strnpcinfo(1)+"]"; mes "�����d�ʂ��������܂��B";	close; }
	mes "["+strnpcinfo(1)+"]";
	mes "�����ł� "+getitemname('@main[0])+" ��";
	mes "�⋋������T�[�r�X�ƌ������܂��B";
	mes "�I��ŉ������B";
	next;
	switch(select(
		"��߂�",
		"�⋋�����ƌ�������",
		"�����A�C�e���ɃZ�b�g���ꂽ�J�[�h�𕪗�����",
		"���{�̃V���[�Y�����𐸘B����",
		""+getitemname('@main[1])+"�ƌ������� ����",
		""+getitemname('@main[2])+"�ň��S�Ȑ��B������",
		"���ʂȖ��{�̖��͌����𕪉����� ����"))	{

		case 1: mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;
		case 2: mes "["+strnpcinfo(1)+"]";	mes "�������ƌ������� �������B";	close;
		case 3: mes "["+strnpcinfo(1)+"]";	mes "�J�[�h���� �������B";	close;
		case 4: mes "["+strnpcinfo(1)+"]";	mes "���{�V���[�Y���B �������B";	close;
		case 5:
			set '@lim,100;
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[1])+"�ƌ������܂��B";
			mes "1���100�܂Ō����ł��܂��B�B";
			mes "����������͂��ĉ������B";
			next;
			input '@count;
			if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "�����𒆎~���܂��B";	close; }
			if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1��Ō����ł���̂� "+'@lim+"�� �܂łł��B";	close; }
			if('@count > countitem('@main[0])) { mes "["+strnpcinfo(1)+"]"; mes "����Ȃ��悤�ł��B";	close; }
			if((countitem('@main[1]) + '@count) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "���Ă�ő吔�𒴂��܂��B";	close; }
			mes "["+strnpcinfo(1)+"]";
			mes "�������܂����B";
			delitem '@main[0],'@count;
			getitem '@main[1],'@count;
			close;

		case 6: mes "["+strnpcinfo(1)+"]";	mes "���S�Ȑ��B �������B";	close;
		case 7:
			mes "["+strnpcinfo(1)+"]";
			mes ""+getitemname('@main[2])+"1��";
			mes ""+getitemname('@main[0])+"5�ɕ������܂��B";
			mes ""+getitemname('@main[3])+"1��";
			mes ""+getitemname('@main[0])+"10�ɕ������܂��B";
			next;
			switch(select(
				"��߂�",
				""+getitemname('@main[2])+"�𕪉�����",
				""+getitemname('@main[3])+"�𕪉�����")) {
				case 1: mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close;
				case 2:
				set '@lim,100;
				mes "["+strnpcinfo(1)+"]";
				mes ""+getitemname('@main[2])+"1��";
				mes ""+getitemname('@main[0])+"5�ɕ������܂��B";
				mes "1���100�܂ŕ����ł��܂��B";
				mes "����������͂��ĉ������B";
				next;
				input '@count;
				if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "�����𒆎~���܂��B";	close; }
				if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1��ŕ����ł���̂� "+'@lim+"�� �܂łł��B";	close; }
				if('@count > countitem('@main[2])) 			{ mes "["+strnpcinfo(1)+"]"; mes "����Ȃ��悤�ł��B";	close; }
				if((countitem('@main[0]) + '@count * 5) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "���Ă�ő吔�𒴂��܂��B";	close; }
				mes "["+strnpcinfo(1)+"]";
				mes "�������܂����B";
				delitem '@main[2],'@count;
				getitem '@main[0],'@count * 5;
				close;

				case 3:	
				set '@lim,100;
				mes "["+strnpcinfo(1)+"]";
				mes ""+getitemname('@main[3])+"1��";
				mes ""+getitemname('@main[0])+"10�ɕ������܂��B";
				mes "1���100�܂ŕ����ł��܂��B";
				mes "����������͂��ĉ������B";
				next;
				input '@count;
				if('@count <= 0) 	{ mes "["+strnpcinfo(1)+"]"; mes "�����𒆎~���܂��B";	close; }
				if('@count > '@lim)	{ mes "["+strnpcinfo(1)+"]"; mes "1��ŕ����ł���̂� "+'@lim+"�� �܂łł��B";	close; }
				if('@count > countitem('@main[3]))			{ mes "["+strnpcinfo(1)+"]"; mes "����Ȃ��悤�ł��B";	close; }
				if((countitem('@main[0]) + '@count * 10) > 30000)	{ mes "["+strnpcinfo(1)+"]"; mes "���Ă�ő吔�𒴂��܂��B";	close; }
				mes "["+strnpcinfo(1)+"]";
				mes "�������܂����B";
				delitem '@main[3],'@count;
				getitem '@main[0],'@count * 10;
				close;
		}
	}
}

//�ړ�
lby_in.gat,48,85,4	script	���{�����c��W��#32199	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "�X�ɖ߂�܂����H";
	next;
	switch(select(
		"�����ɂƂǂ܂�",
		"�v�����e���ɖ߂�",
		"�Q�t�F���ɖ߂�")) {
	case 1:	mes "["+strnpcinfo(1)+"]";	mes "�����͊��ӂ��܂��B";	close;
	case 2:	warp "prontera",116,76;	break;
	case 3:	warp "geffen",128,60;	break;	}
	end;
}

geffen.gat,128,64,4	script	���{�����c��W��#32200	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "�����n�_�܂�";
	mes "�����肢�����܂��傤���H";
	next;
	if(select("������","�͂�") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����͂��҂����Ă��܂��B";	close;	}
	warp "lby_in",48,75;
	end;
}

prontera.gat,111,78,4	script	���{�����c��W��#32205	414,{

	mes "["+strnpcinfo(1)+"]";
	mes "�����n�_�܂�";
	mes "�����肢�����܂��傤���H";
	next;
	if(select("������","�͂�") == 1) {	mes "["+strnpcinfo(1)+"]";	mes "�����͂��҂����Ă��܂��B";	close;	}
	warp "lby_in",48,75;
	end;
}
