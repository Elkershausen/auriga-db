//2025/06/10 �A�b�v�f�[�g
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
	//if(countitem('@main[0])	< 100) {	mes ""+getitemname('@main[0])+" ��100�ȏ�K�v�ł�";	close;	}
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
4th_lib.gat,34,67,3	script	�Z���X	803,{
	/* ���ʏ����ݒ� */
	setarray '@main,	610081,	620052,	630056,	640063,	700115,	810047,	500115,	510181,	530070,	540103,	550172,	550173,	560076,	570082,	580082,	590097,	400907,	450462,	450463,	480592,	470351,	490745,	490746;	//�G���`�����g������A�C�e��
	setarray '@Lefthand,	0,	0,	0,	0,	0,	0,	500115,	510181,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	//�Z�� �Ў茕 �Ў蕀�̍��葕������
	
	set '@costAid,1002223;				//�K�v�ȃA�C�e�� 1002223 �Z���X�e�B�A���V���[�Y�G���`�����g���_��
	set '@costAnum,1;				//�K�v�ȃA�C�e���̐� 1
	set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
	set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
	set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
	set '@refD,99;					//'@slotD�̐��B�l����(��2�G���`���̂�)
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}	//�擪�ɋ��ʏ��������ݑS�̂��ȑf������
	/* ���ʏ����ݒ肱���܂� */

	/* �X�N���v�g�J�n */
	mes "["+strnpcinfo(1)+"]";
	mes "�Z���X�e�B�A�V���[�Y��";
	mes "�G���`�����g�����܂��B";
	mes "�G���`�����g���鑕����";
	mes "�I��ŉ������B";
	next;
	switch(select(
		"��߂�",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]",
		""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]",
		""+getitemname('@main[10])+"["+getiteminfo('@main[10],10)+"]",
		""+getitemname('@main[11])+"["+getiteminfo('@main[11],10)+"]",
		""+getitemname('@main[12])+"["+getiteminfo('@main[12],10)+"]",
		""+getitemname('@main[13])+"["+getiteminfo('@main[13],10)+"]",
		""+getitemname('@main[14])+"["+getiteminfo('@main[14],10)+"]",
		""+getitemname('@main[15])+"["+getiteminfo('@main[15],10)+"]",
		""+getitemname('@main[16])+"["+getiteminfo('@main[16],10)+"]",
		""+getitemname('@main[17])+"["+getiteminfo('@main[17],10)+"]",
		""+getitemname('@main[18])+"["+getiteminfo('@main[18],10)+"]",
		""+getitemname('@main[19])+"["+getiteminfo('@main[19],10)+"]",
		""+getitemname('@main[20])+"["+getiteminfo('@main[20],10)+"]",
		""+getitemname('@main[21])+"["+getiteminfo('@main[21],10)+"]",
		""+getitemname('@main[22])+"["+getiteminfo('@main[22],10)+"]")) {

	case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;
	/* ����16�� ��`�J�n */
	case 2:	set '@wp,0;	break;
	case 3:	set '@wp,1;	break;
	case 4:	set '@wp,2;	break;
	case 5:	set '@wp,3;	break;
	case 6:	set '@wp,4;	break;
	case 7:	set '@wp,5;	break;
	case 8:	set '@wp,6;	break;
	case 9:	set '@wp,7;	break;
	case 10:	set '@wp,8;	break;
	case 11:	set '@wp,9;	break;
	case 12:	set '@wp,10;	break;
	case 13:	set '@wp,11;	break;
	case 14:	set '@wp,12;	break;
	case 15:	set '@wp,13;	break;
	case 16:	set '@wp,14;	break;
	case 17:	set '@wp,15;	break;
	/* ����16�� ��`�I�� */
	/* 400907 �Z���X�e�B�A���_�C�A�f�� �J�n */
	case 18:
		/* ���������ݒ� */
		set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[16]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[16])+" ["+getiteminfo('@main[16],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[16]) != 1)		{ mes ""+getitemname('@main[16])+"["+getiteminfo('@main[16],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	29436,	4876,	4879,	29509,	29371;
		setarray '@winC[0],	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[16],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 400907 �Z���X�e�B�A���_�C�A�f�� �I�� */

	/* 450462 �Z���X�e�B�A���A�[�}�[ �J�n */
	case 19:
		/* ���������ݒ� */
		set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[17]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[17])+" ["+getiteminfo('@main[17],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[17]) != 1)		{ mes ""+getitemname('@main[17])+"["+getiteminfo('@main[17],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	29305,	29302,	29303,	29304,	29307,	29306,	310320,	29309,	29308;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[17],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 450462 �Z���X�e�B�A���A�[�}�[ �I�� */

	/* 450463 �Z���X�e�B�A���X�[�c �J�n */
	case 20:
		/* ���������ݒ� */
		set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[18]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[18])+" ["+getiteminfo('@main[18],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[18]) != 1)		{ mes ""+getitemname('@main[18])+"["+getiteminfo('@main[18],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	29305,	29302,	29303,	29304,	29307,	29306,	310320,	29309,	29308;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[18],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 450463 �Z���X�e�B�A���X�[�c �I�� */

	/* 480592 �Z���X�e�B�A���}���g �J�n */
	case 21:
		/* ���������ݒ� */
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[19]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[19])+" ["+getiteminfo('@main[19],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[19]) != 1)		{ mes ""+getitemname('@main[19])+"["+getiteminfo('@main[19],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	314163,	314164,	314165,	314166;
		setarray '@winC[0],	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[19],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 480592 �Z���X�e�B�A���}���g �I�� */

	/* 470351 �Z���X�e�B�A���u�[�c �J�n */
	case 22:
		/* ���������ݒ� */
		set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[20]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[20])+" ["+getiteminfo('@main[20],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[20]) != 1)		{ mes ""+getitemname('@main[20])+"["+getiteminfo('@main[20],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[20],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 470351 �Z���X�e�B�A���u�[�c �I�� */

	/* 490745 �Z���X�e�B�A�������O[0] �X���b�g�G���`�����g �J�n */
	case 23:
		/* ���������ݒ� */
		set '@pos,7;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��


		//if(countitem('@main[21]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[21])+" ["+getiteminfo('@main[21],10)+"] �𑕔����ĉ�����";	close;	}
		if(getequipisequiped(8) == 1) 			{ mes "�A�N�Z�T��(2)���O���ĉ�����";	close;	}
		if(equippeditem('@main[21]) != 1)		{ mes ""+getitemname('@main[21])+"["+getiteminfo('@main[21],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* ���j���[�����I�� */

		/* �X���b�g�G���`�����g�J�n */
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	50,	0;	/* �X���b�g�G���`�����g�I���Ŏ��s�����Z */
		set '@changeid,490746;			//�X���b�g�G���`�����g

			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "^FFFFFF_^000000";
			mes "��1�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			"�X���b�g�G���`�����g����",
			"�X���b�g�G���`�����g���Ȃ�")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "��1�X���b�g: �X���b�g�G���`�����g"; }
			if('@en1 == 0) { mes "��1�X���b�g: ���I�� "; } 
			mes "^FFFFFF_^000000";
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//�X���b�g�G���`�����g������
				if('@en1 == 1) {
					if('@changerate >= '@winD[0]) {
						misceffect 154,"";
						mes "[" +strnpcinfo(1)+ "]";
						mes "�听�����܂���";
						delitem '@costAid,'@costAnum;
						delequip '@pos;
						getitem2 '@changeid,1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
						else 
						{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; close; }	}
				if('@en1 == 0) {
					if('@winrate >= '@result) {
						 misceffect 154,"";
						 mes "[" +strnpcinfo(1)+ "]";
						 mes "�������܂���";
						 delitem '@costAid,'@costAnum;
						 delequip '@pos;
						 getitem2 '@main[21],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
						 else
						 { misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; close; }	}
		}
	/* 490745 �Z���X�e�B�A�������O[0] �X���b�g�G���`�����g �I�� */

	/* 490746 �Z���X�e�B�A�������O[1] �J�n */
	case 24:
		/* ���������ݒ� */
		set '@pos,7;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main[22]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[22])+" ["+getiteminfo('@main[22],10)+"] �𑕔����ĉ�����";	close;	}
		if(getequipisequiped(8) == 1) 			{ mes "�A�N�Z�T��(2)���O���ĉ�����";	close;	}
		if(equippeditem('@main[22]) != 1)		{ mes ""+getitemname('@main[22])+"["+getiteminfo('@main[22],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	314158,	310318,	29649,	29650;
		setarray '@winC[0],	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main[22],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
	/* 490746 �Z���X�e�B�A�������O[1] �I�� */
	}

	if('@wp <= 15) {/* ����J�n */
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@main['@wp])+"["+getiteminfo('@main['@wp],10)+"]";
	mes "����G���`���J�n";
	next;
		/* ���������ݒ� */
		set '@pos,4;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		set '@slotAcard,getequipcardid('@pos,3);	//�J�[�h�X���b�g1�̃J�[�hID��ۑ�(��������)
		set '@slotBcard,getequipcardid('@pos,2);	//�J�[�h�X���b�g2�̃J�[�hID��ۑ�(��������)
		set '@slotCcard,getequipcardid('@pos,1);	//�J�[�h�X���b�g3�̃J�[�hID��ۑ�(��������)
		set '@slotDcard,getequipcardid('@pos,0);	//�J�[�h�X���b�g4�̃J�[�hID��ۑ�(��������)
		set '@ref,getequiprefinerycnt('@pos);		//�A�C�e���̐��B�l���G���`�����g��Ɉ����p��
		
		//if(countitem('@main['@wp]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";	close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main['@wp])+" ["+getiteminfo('@main['@wp],10)+"] �𑕔����ĉ�����";	close;	}
		if(getitemid(getequipname(3)) == '@Lefthand['@wp])	{ mes ""+getitemname('@Lefthand['@wp])+" �͍���ɑ������Ȃ��ŉ������B";	close;	}
		if(equippeditem('@main['@wp]) != 1)		{ mes ""+getitemname('@main['@wp])+"["+getiteminfo('@main['@wp],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";		close;	}
		/* ���������ݒ肱���܂� */
	/* �G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	4853,	4854,	4855,	4856,	4857,	4858,	29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname('@slotAcard)+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname('@slotBcard)+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname('@slotCcard)+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname('@slotDcard)+" "; }
		mes "^FFFFFF_^000000";
		mes "��2�X���b�g�̃G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"",
			""+getitemname('@slotC[7])+"",
			""+getitemname('@slotC[8])+"",
			""+getitemname('@slotC[9])+"",
			""+getitemname('@slotC[10])+"",
			""+getitemname('@slotC[11])+"",
			""+getitemname('@slotC[12])+"",
			""+getitemname('@slotC[13])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2: set '@en2,'@slotC[0]; set '@winCrate,'@winC[0]; break;
			case 3: set '@en2,'@slotC[1]; set '@winCrate,'@winC[1]; break;
			case 4: set '@en2,'@slotC[2]; set '@winCrate,'@winC[2]; break;
			case 5: set '@en2,'@slotC[3]; set '@winCrate,'@winC[3]; break;
			case 6: set '@en2,'@slotC[4]; set '@winCrate,'@winC[4]; break;
			case 7: set '@en2,'@slotC[5]; set '@winCrate,'@winC[5]; break;
			case 8: set '@en2,'@slotC[6]; set '@winCrate,'@winC[6]; break;
			case 9: set '@en2,'@slotC[7]; set '@winCrate,'@winC[7]; break;
			case 10: set '@en2,'@slotC[8]; set '@winCrate,'@winC[8]; break;
			case 11: set '@en2,'@slotC[9]; set '@winCrate,'@winC[9]; break;
			case 12: set '@en2,'@slotC[10]; set '@winCrate,'@winC[10]; break;
			case 13: set '@en2,'@slotC[11]; set '@winCrate,'@winC[11]; break;
			case 14: set '@en2,'@slotC[12]; set '@winCrate,'@winC[12]; break;
			case 15: set '@en2,'@slotC[13]; set '@winCrate,'@winC[13]; break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g�̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 	getitem2 '@main['@wp],1,1,'@ref,0,'@slotDcard,'@en2,'@slotBcard,'@slotAcard,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;											close;	}
			}
		}
		/* �G���`�����g�I���̍ŏI�����I�� *//* ���B�����I�� */
/* ����I�� */}
	mes "["+strnpcinfo(1)+"]";
	mes "�X�N���v�g�ŉ��i";
	close;
}

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