//2025/05/07 �A�b�v�f�[�g
//���� �X���b�g�ʒu:��<-['@slotD/'@slotDcard(��1�X��/��4�G���`��)]<-['@slotC/'@slotCcard(��2�X��/��3�G���`��)]<-['@slotB/'@slotBcard(��3�X��/��2�G���`��)]<-['@slotA/'@slotAcard(��4�X��/��1�G���`��)]<-�E����J�n
//�G���`�����g3�܂� ���B�������� �R�X�g�A�C�e��1��100��
//[14th�A�j�o�[�T���[�p�b�P�[�W][�T�}�[�p�b�P�[�W2017] 10�����

enchant01.gat,176,73,3	script	�G���^�}#36399	553,{
	/* ���ʏ����ݒ� */
	setarray '@main[0],19172,22129,15191,19174,19173,19272,20854,15209,19273,19274;	//�G���`�����g������A�C�e��10��
	set '@costAid,6919;								//�K�v�ȃA�C�e�� 6919 ���ƍv���̏�
	set '@costAnum,100;								//�K�v�ȃA�C�e���̐� 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";			close;	}	//�擪�ɋ��ʏ��������ݑS�̂��ȑf������
	/* ���ʏ����ݒ肱���܂� */

	/* �X�N���v�g�J�n */
	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" �� �K�v";
	mes "���B�l�Ɩh��̃J�[�h�͈ێ�����܂�";
	mes "�G���`�����g�͏㏑������܂�";
	mes "���������͏�����\��������̂�";
	mes "�q�ɂɗa���A�����Ȃ��ŉ�����";
	mes "�ǂ̑����ɃG���`�����g���܂����H";
	next;
	switch(select(
		"��߂�",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",	/* "�A�C�e����""[�X���b�g]" */
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]",
		""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]")) {
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;

	/* 19172 �����苳�c(����)[1] �J�n */
	case 2:
		/* ���������ݒ� */
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,99;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//set '@addflagAid,9999;			//�G���`���ʂɉ����ݒ肵�����ꍇ �ǉ��A�C�e�� �������ω� S�t������
		//if(countitem('@main[0]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		setarray '@slotA[0],	29012,	29248,	4900,	4801,	4946,	4944,	4767,	4897,	4817,	29136,	4810,	4833,	4814,	4872;	/* �G���`�����gID */
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* ����������(1/100) �ʐݒ� �傫���قǐ����������� */
		//setarray '@addflagAnum[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* �G���`���ʂɉ����ݒ肵�����ꍇ �ǉ��A�C�e�� �������ω� S�t������ */
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ��1�G���`�����g�I�������J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[0])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }	//�J�[�h�L����mes�ύX
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"",
			""+getitemname('@slotA[12])+"",
			""+getitemname('@slotA[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;
			case 14:	set '@en4,'@slotA[12];	set '@winArate,'@winA[12];	break;
			case 15:	set '@en4,'@slotA[13];	set '@winArate,'@winA[13];	break;	}
		/* ��1�G���`�����g�I�������I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {	//���B�l����
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}

		/* ��2�G���`�����g�I�������J�n */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		setarray '@slotB[0],	29012,	29248,	4900,	4801,	4946,	4944,	4767,	4897,	4817,	29136,	4810,	4833,	4814,	4872;	/* �G���`�����gID */
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* ����������(1/100) �ʐݒ� �傫���قǐ����������� */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"",
			""+getitemname('@slotB[12])+"",
			""+getitemname('@slotB[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;
			case 14:	set '@en3,'@slotB[12];	set '@winBrate,'@winB[12];	break;
			case 15:	set '@en3,'@slotB[13];	set '@winBrate,'@winB[13];	break;	}
		/* ��2�G���`�����g�I�������I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {	//���B�l����
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}

		/* ��3�G���`�����g�I�������J�n */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	[14]	[15]	[16]	*/
		setarray '@slotC[0],	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999;	/* �G���`�����gID */
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;	/* ����������(1/100) �ʐݒ� �傫���قǐ����������� */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
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
			""+getitemname('@slotC[13])+"",
			""+getitemname('@slotC[14])+"",
			""+getitemname('@slotC[15])+"",
			""+getitemname('@slotC[16])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;
			case 14:	set '@en2,'@slotC[12];		set '@winCrate,'@winC[12];	break;
			case 15:	set '@en2,'@slotC[13];		set '@winCrate,'@winC[13];	break;
			case 16:	set '@en2,'@slotC[14];		set '@winCrate,'@winC[14];	break;
			case 17:	set '@en2,'@slotC[15];		set '@winCrate,'@winC[15];	break;
			case 18:	set '@en2,'@slotC[16];		set '@winCrate,'@winC[16];	break;	}
		/* ��3�G���`�����g�I�������I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* �G���`�����g3�I���̍ŏI�����I�� */
			}
	/* 19172 �����苳�c(����)[1] �I�� */

	/* 22129 �E�҂̌C[1] �J�n */
	case 3:
		/* ���������ݒ� */
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,99;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8

		//if(countitem('@main[1]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
		setarray '@slotA[0],	29012,	29244,	4900,	4801,	4950,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ��1�G���`�����g�I�������J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[1])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"",
			""+getitemname('@slotA[12])+"",
			""+getitemname('@slotA[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;
			case 14:	set '@en4,'@slotA[12];	set '@winArate,'@winA[12];	break;
			case 15:	set '@en4,'@slotA[13];	set '@winArate,'@winA[13];	break;	}
		/* ��1�G���`�����g�I�������I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}

		/* ��2�G���`�����g�I�������J�n */
		setarray '@slotB[0],	29012,	29244,	4900,	4801,	4950,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"",
			""+getitemname('@slotB[12])+"",
			""+getitemname('@slotB[13])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;
			case 14:	set '@en3,'@slotB[12];	set '@winBrate,'@winB[12];	break;
			case 15:	set '@en3,'@slotB[13];	set '@winBrate,'@winB[13];	break;	}
		/* ��2�G���`�����g�I�������I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}

		/* ��3�G���`�����g�I�������J�n */
		setarray '@slotC[0],	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999,	9999;
		setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
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
			""+getitemname('@slotC[13])+"",
			""+getitemname('@slotC[14])+"",
			""+getitemname('@slotC[15])+"",
			""+getitemname('@slotC[16])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;
			case 14:	set '@en2,'@slotC[12];		set '@winCrate,'@winC[12];	break;
			case 15:	set '@en2,'@slotC[13];		set '@winCrate,'@winC[13];	break;
			case 16:	set '@en2,'@slotC[14];		set '@winCrate,'@winC[14];	break;
			case 17:	set '@en2,'@slotC[15];		set '@winCrate,'@winC[15];	break;
			case 18:	set '@en2,'@slotC[16];		set '@winCrate,'@winC[16];	break;	}
		/* ��3�G���`�����g�I�������I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* �G���`�����g3�I���̍ŏI�����I�� */
			}
	/* 22129 �E�҂̌C[1] �I�� */

	/* 15191 �J�[���b�c�o�[�O�R�m�c�̊Z[1] �J�n */
	case 4:
		/* ���������ݒ� */
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[2]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[2])+" ["+getiteminfo('@main[2],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[2]) != 1)		{ mes ""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
		setarray '@slotA[0],	29012,	29246,	4900,	4801,	29242,	29235,	4818,	29135,	4811,	4832,	4815,	4869;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ��1�G���`�����g�I�������J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[2])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
		/* ��1�G���`�����g�I�������I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}

		/* ��2�G���`�����g�I�������J�n */
		setarray '@slotB[0],	29012,	29246,	4900,	4801,	29242,	29235,	4818,	29135,	4811,	4832,	4815,	4869;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
		/* ��2�G���`�����g�I�������I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}

		/* ��3�G���`�����g�I�������J�n */
		setarray '@slotC[0],	4879;
		setarray '@winC[0],	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ��3�G���`�����g�I�������I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[2],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* �G���`�����g3�I���̍ŏI�����I�� */
			}
	/* 15191 �J�[���b�c�o�[�O�R�m�c�̊Z[1] �I�� */

	/* 19174 ���^��@�@[0] �J�n */
	case 5:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,9;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[3]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[3])+" ["+getiteminfo('@main[3],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[3]) != 1)		{ mes ""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
		setarray '@slotA[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ��1�G���`�����g�I�������J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[3])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;	}
		/* ��1�G���`�����g�I�������I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}

		/* ��2�G���`�����g�I�������J�n */
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;	}
		/* ��2�G���`�����g�I�������I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}

		/* ��3�G���`�����g�I�������J�n */
		setarray '@slotC[0],	4902,	4901,	29241,	29238,	29240,	4942,	29012,	4807,	4900,	4801,	29243,	29247;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
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
			""+getitemname('@slotC[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;
			case 13:	set '@en2,'@slotC[11];		set '@winCrate,'@winC[11];	break;	}
		/* ��3�G���`�����g�I�������I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[3],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* �G���`�����g3�I���̍ŏI�����I�� */
			}
	/* 19174 ���^��@�@[0] �I�� */

	/* 19173 ���V����X[0] �J�n */
	case 6:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,10;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[4]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[4])+" ["+getiteminfo('@main[4],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[4]) != 1)		{ mes ""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ��1�G���`�����g�I�������J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[4])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;	}
		/* ��1�G���`�����g�I�������I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}

		/* ��2�G���`�����g�I�������J�n */
		setarray '@slotB[0],	4793,	4788,	29237,	29239,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+""; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;	}
		/* ��2�G���`�����g�I�������I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}

		/* ��3�G���`�����g�I�������J�n */
		setarray '@slotC[0],	4867,	4801,	4767,	4897,	29236,	29243,	29245;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0,	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"",
			""+getitemname('@slotC[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;	}
		/* ��3�G���`�����g�I�������I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[4],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
		/* �G���`�����g3�I���̍ŏI�����I�� */
			}
	/* 19173 ���V����X[0] �I�� */

	/* 19272 �K�[�f���I�u�G�f��[1] �J�n */
	case 7:	
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)��������
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[5]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[5])+" ["+getiteminfo('@main[5],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[5]) != 1)		{ mes ""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	29248,	4947,	4950,	29243,	4815,	4814,	4869,	4872,	4944,	4900,	29372;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[5])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	29248,	4947,	4950,	29243,	4815,	4814,	4869,	4872,	4944,	4900,	29372;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	0;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��3�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[5],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19272 �K�[�f���I�u�G�f��[1] �I�� */

	/* 20854 ���f�B�b�N�P�[�v[1] �J�n */
	case 8:	
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)��������
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,99;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[6]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[6])+" ["+getiteminfo('@main[6],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[6]) != 1)		{ mes ""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	4946,	4949,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[6])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	4946,	4949,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��3�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[6],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 20854 ���f�B�b�N�P�[�v[1] �I�� */

	/* 15209 �h���C�N�R�[�g[1] �J�n */
	case 9:	
		set '@refA,6;					//'@slotA�̐��B�l����(6�ȏ�)��������
		set '@refB,8;					//'@slotB�̐��B�l����(8�ȏ�)
		set '@refC,99;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[7]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[7])+" ["+getiteminfo('@main[7],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[7]) != 1)		{ mes ""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}

		set '@ref,getequiprefinerycnt('@pos);
		set '@slotDcard,getequipcardid('@pos,0);
		//set '@ref,0;
		//set '@slotDcard,0;

		setarray '@slotA[0],	29012,	29246,	4947,	4950,	29242,	4818,	29135,	4811,	4832,	4815,	4869,	4900;
		setarray '@winA[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[7])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"",
			""+getitemname('@slotA[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;
			case 13:	set '@en4,'@slotA[11];	set '@winArate,'@winA[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	29012,	29246,	4947,	4950,	29242,	4818,	29135,	4811,	4832,	4815,	4869,	4900;
		setarray '@winB[0],	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g: "+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"",
			""+getitemname('@slotB[11])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;
			case 13:	set '@en3,'@slotB[11];	set '@winBrate,'@winB[11];	break;	}
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	29371;
		setarray '@winC[0],	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[7],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 15209 �h���C�N�R�[�g[1] �I�� */

	/* 19273 �W�F�~�j-S58�̖�(��)[0] �J�n */
	case 10:	
		set '@refA,0;					//'@slotA�̐��B�l����(0�ȏ�)��������
		set '@refB,0;					//'@slotB�̐��B�l����(0�ȏ�)
		set '@refC,0;					//'@slotC�̐��B�l����(0�ȏ�)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,9;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[8]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[8])+" ["+getiteminfo('@main[8],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[8]) != 1)		{ mes ""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}

		//set '@ref,getequiprefinerycnt('@pos);
		//set '@slotDcard,getequipcardid('@pos,0);
		set '@ref,0;
		set '@slotDcard,0;

		setarray '@slotA[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[8])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"",
			""+getitemname('@slotA[7])+"",
			""+getitemname('@slotA[8])+"",
			""+getitemname('@slotA[9])+"",
			""+getitemname('@slotA[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;
			case 9:	set '@en4,'@slotA[7];	set '@winArate,'@winA[7];	break;
			case 10:	set '@en4,'@slotA[8];	set '@winArate,'@winA[8];	break;
			case 11:	set '@en4,'@slotA[9];	set '@winArate,'@winA[9];	break;
			case 12:	set '@en4,'@slotA[10];	set '@winArate,'@winA[10];	break;	}
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815,	4817,	29136,	4810,	4833,	4814,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"",
			""+getitemname('@slotB[7])+"",
			""+getitemname('@slotB[8])+"",
			""+getitemname('@slotB[9])+"",
			""+getitemname('@slotB[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;
			case 9:	set '@en3,'@slotB[7];	set '@winBrate,'@winB[7];	break;
			case 10:	set '@en3,'@slotB[8];	set '@winBrate,'@winB[8];	break;
			case 11:	set '@en3,'@slotB[9];	set '@winBrate,'@winB[9];	break;
			case 12:	set '@en3,'@slotB[10];	set '@winBrate,'@winB[10];	break;	}
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	4902,	4901,	29241,	29238,	29240,	4942,	4807,	4900,	4801,	29373,	29374;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10,	10,	10,	10,	10,	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
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
			""+getitemname('@slotC[10])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;
			case 8:	set '@en2,'@slotC[6];		set '@winCrate,'@winC[6];	break;
			case 9:	set '@en2,'@slotC[7];		set '@winCrate,'@winC[7];	break;
			case 10:	set '@en2,'@slotC[8];		set '@winCrate,'@winC[8];	break;
			case 11:	set '@en2,'@slotC[9];		set '@winCrate,'@winC[9];	break;
			case 12:	set '@en2,'@slotC[10];		set '@winCrate,'@winC[10];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[8],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19273 �W�F�~�j-S58�̖�(��)[0] �I�� */

	/* 19274 �I�[�v���G�A�w�b�h�t�H��[0] �J�n */
	case 11:
		set '@refA,0;					//'@slotA�̐��B�l����(0�ȏ�)��������
		set '@refB,0;					//'@slotB�̐��B�l����(0�ȏ�)
		set '@refC,0;					//'@slotC�̐��B�l����(0�ȏ�)
		set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,10;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		//if(countitem('@main[9]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[9])+" ["+getiteminfo('@main[9],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[9]) != 1)		{ mes ""+getitemname('@main[9])+"["+getiteminfo('@main[9],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}

		//set '@ref,getequiprefinerycnt('@pos);
		//set '@slotDcard,getequipcardid('@pos,0);
		set '@ref,0;
		set '@slotDcard,0;

		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10,	10;

		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[9])+" ";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"",
			""+getitemname('@slotA[2])+"",
			""+getitemname('@slotA[3])+"",
			""+getitemname('@slotA[4])+"",
			""+getitemname('@slotA[5])+"",
			""+getitemname('@slotA[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;
			case 8:	set '@en4,'@slotA[6];	set '@winArate,'@winA[6];	break;	}
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: ���I�� ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 								close; }
			}
		}

		setarray '@slotB[0],	4701,	4711,	4721,	4731,	4741,	4751,	29012;
		setarray '@winB[0],	10,	10,	10,	10,	10,	10,	10;
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: ���I�� ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"",
			""+getitemname('@slotB[2])+"",
			""+getitemname('@slotB[3])+"",
			""+getitemname('@slotB[4])+"",
			""+getitemname('@slotB[5])+"",
			""+getitemname('@slotB[6])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;
			case 4:	set '@en3,'@slotB[2];	set '@winBrate,'@winB[2];	break;
			case 5:	set '@en3,'@slotB[3];	set '@winBrate,'@winB[3];	break;
			case 6:	set '@en3,'@slotB[4];	set '@winBrate,'@winB[4];	break;
			case 7:	set '@en3,'@slotB[5];	set '@winBrate,'@winB[5];	break;
			case 8:	set '@en3,'@slotB[6];	set '@winBrate,'@winB[6];	break;	}
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: ���I�� ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos; 									close; }
			}
		}

		setarray '@slotC[0],	4867,	4801,	29012,	4807,	4767,	4897;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: ���I�� ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"",
			""+getitemname('@slotC[2])+"",
			""+getitemname('@slotC[3])+"",
			""+getitemname('@slotC[4])+"",
			""+getitemname('@slotC[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;
			case 4:	set '@en2,'@slotC[2];		set '@winCrate,'@winC[2];	break;
			case 5:	set '@en2,'@slotC[3];		set '@winCrate,'@winC[3];	break;
			case 6:	set '@en2,'@slotC[4];		set '@winCrate,'@winC[4];	break;
			case 7:	set '@en2,'@slotC[5];		set '@winCrate,'@winC[5];	break;	}

			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
			mes "����ł�낵���ł����H";
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate));
				set '@result,rand(1,100);
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delequip '@pos; getitem2 '@main[9],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delequip '@pos;									close;	}
			}
	/* 19274 �I�[�v���G�A�w�b�h�t�H��[0] �I�� */
	}
}
