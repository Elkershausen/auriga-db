//2025/06/03 �A�b�v�f�[�g
//map :4th_lib.gat �ǉ�

aldebaran.gat,148,96,4	script	�V�̐}���َi��	897,{

	mes "["+strnpcinfo(1)+"]";
	mes "�V�̐}���ق�";
	mes "�ړ����܂����H";
	next;	/* 4th_lib */
	switch(select(
		"��߂�",
		"�ړ�����")) {
		case 1: mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
		case 2: warp "4th_lib",32,57; break;	}
	end;
}

4th_lib.gat,28,57,0		warp	4th_libt001	1,1,aldebaran.gat,148,100

//�A�C�e������
4th_lib.gat,35,47,4	script	����	73,{
	setarray '@main,1000372,1002223;
	if(countitem('@main[0])	< 100) {	mes ""+getitemname('@main[0])+" ��100�ȏ�K�v�ł�";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@main[0])+" 100��";
	mes ""+getitemname('@main[1])+"";
	mes "1�ƌ������܂��B";
	mes "�����������܂����H";
	mes "�������Ȃ��ꍇ��0��";
	mes "���͂��ĉ������B";
	next;
	input '@count;
	if('@count < 1) {	mes "["+strnpcinfo(1)+"]";	mes "����𒆎~���܂�";		close;	}
	if('@count > 300) {	mes "["+strnpcinfo(1)+"]";	mes "�������ł��B";		close;	}
	if(('@count * 100) > countitem('@main[0])) {	mes "["+strnpcinfo(1)+"]";	mes ""+getitemname('@main[0])+" ������܂���B";		close;	}

	delitem '@main[0],'@count * 100;
	getitem '@main[1],'@count;
	mes "["+strnpcinfo(1)+"]";
	mes "�������܂����B";
	close;
}

//�X�e�[�^�X�E�X�L�����Z�b�g
4th_lib.gat,45,48,3	script	���[�V�F	72,{
	if(BaseLevel < 200)		{	mes "["+strnpcinfo(1)+"]";	mes "���x��200�ȏ��4���E�E�g��4���E��p�ł�";	close;	}
	if(countitem(1002220) < 1)	{	mes "["+strnpcinfo(1)+"]";	mes ""+getitemname(1002220)+" ���������Ă���";	mes "�`���Ґ�p�ł��B";	close;	}
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002220)+" ���������Ă���";
	mes "4���E�E�g��4���E�̖`���҂�";
	mes "�����ŃX�e�[�^�X�E�X�L����";
	mes "���Z�b�g�T�[�r�X���s���Ă��܂��B";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname(1002220)+" �͏��Ղ���";
	mes "���x�ł����p�ł��܂��B";
	mes "���Z�b�g���܂����H";
	next;
	switch(select("�X�e�[�^�X���Z�b�g","�X�L�����Z�b�g","����ς��߂�")) {
	case 1:
		resetstatus;
		mes "["+strnpcinfo(1)+"]";
		mes "�X�e�[�^�X���Z�b�g�������܂����B";
		mes "�܂������p�������B";
 		close;
	case 2:
		resetskill;
		mes "["+strnpcinfo(1)+"]";
		mes "�X�L�����Z�b�g�������܂����B";
		mes "�܂������p�������B";
		close;
	case 3:
		mes "["+strnpcinfo(1)+"]";
		mes "�܂��̂����p";
		mes "���҂����Ă��܂��B";
		close;
	}
}

//���ʂȐ��B
4th_lib.gat,48,66,4	script	�A�X�g��	893,{}

//�Z���X�e�B�A�G���`�����g
//4th_lib.gat,34,67,3	script	�Z���X	803,{}


//�Ǘ��pNPC�J�n
4th_lib.gat,39,58,3	shop	�V�̐}����SHOP		10545,1000372,1002223,1002220

//�q�ɃT�[�r�X
4th_lib.gat,39,54,3	script	�q�ɃT�[�r�X	464,{
	if(Zeny < 40) {	mes "�[�j�[������܂���";	close;	}
	set Zeny,Zeny-40;	openstorage;	end;
}

4th_lib.gat,30,69,3	script	�A�C�e���폜	464,{
	mes "["+strnpcinfo(1)+"]";
	mes "�����܂���";
	clearitem;
	gmcommand "@itemreset";
	close;
}
//�Ǘ��pNPC�����܂�

//�}�b�v�t���O��������
//4th_lib.gat	mapflag	nosave		SavePoint
4th_lib.gat	mapflag	nomemo		dummy
4th_lib.gat	mapflag	noteleport	dummy
4th_lib.gat	mapflag	nobranch	dummy
4th_lib.gat	mapflag	monster_noteleport	dummy
4th_lib.gat	mapflag	noicewall	dummy
4th_lib.gat	mapflag	noabra		dummy