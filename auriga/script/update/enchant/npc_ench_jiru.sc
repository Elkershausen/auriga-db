//2025/05/07 �A�b�v�f�[�g
//���� �X���b�g�ʒu:��<-['@slotD/'@slotDcard(��1�X��/��4�G���`��)]<-['@slotC/'@slotCcard(��2�X��/��3�G���`��)]<-['@slotB/'@slotBcard(��3�X��/��2�G���`��)]<-['@slotA/'@slotAcard(��4�X��/��1�G���`��)]<-�E����J�n
//�G���`�����g4�܂� �J�[�h�����p���Ȃ� ���B�����Ȃ� �A�C�e���������� �R�X�g�A�C�e��1��100��
//[19443 ���̊��[0] -> 19444 ���̊��[1]][19445 �������̊��[0] -> 19446 �������̊��[1]]

enchant01.gat,176,60,3	script	�W��	559,{

	/* ���ʏ����ݒ� */
	setarray '@main[0],	19443,19445;	//�G���`�����g������A�C�e��
	setarray '@slotnum[0],	0,	0;
	setarray '@changeid[0],	19444,19446;	//�X���b�g�G���`�����g
	set '@costAid,7510;								//�K�v�ȃA�C�e�� 7510 ���@���n���̉�
	set '@costAnum,100;								//�K�v�ȃA�C�e���̐� 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}	//�擪�ɋ��ʏ��������ݑS�̂��ȑf������
	/* ���ʏ����ݒ肱���܂� */

	mes "["+strnpcinfo(1)+"]";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" �� �K�v";
	mes "�ǂ̑����ɃG���`�����g���܂����H";
	next;
	switch(select(
		"��߂�",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]")) {/* �A�C�e���I���J�n */
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;

	/* 19443 ���̊��[0] �J�n */
	case 2:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,9;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[0]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		//set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

	/* ��1�G���`�����g�����J�n */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "+"+getequiprefinerycnt('@pos)+""+getitemname('@main[0])+" ";
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
			""+getitemname('@slotA[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;	}
		/* ���j���[�����I�� */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}
	/* ��1�G���`�����g�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	[1]	[2]	[3]	[4]	*/
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;

		/* ���j���[�����J�n */
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
		/* ���j���[�����I�� */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; 								close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotC[0],	29241,	29238,	29240,	4942,	29012,	29243;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;

		/* ���j���[�����J�n */
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
		/* ���j���[�����I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
				}
		/* �G���`�����g3�I���̍ŏI�����I�� */
		}
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	95,	0;	/* �X���b�g�G���`�����g�I���Ŏ��s��95���Z */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			"�X���b�g�G���`�����g������",
			"�X���b�g�G���`�����g�����Ȃ�")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "��1�X���b�g: �X���b�g�G���`�����g"; }
			if('@en1 == 0) { mes "��1�X���b�g: ���I�� "; } 
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//�X���b�g�G���`�����g������
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@slotD[0] == 1 ) { if('@changerate >= '@winD[0]) { misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�听�����܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@changeid[0],1,1,0,0,0,0,0,0,0;	close;	} }
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}	//�X���b�g�G���`�����g��I�΂Ȃ��ꍇ��3�̃G���`�����g����
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 19443 ���̊��[0] �I�� */

	/* 19445 �������̊��[0] �J�n */
	case 3:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,9;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[1]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		//set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */

		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotA[0],	4701,	4711,	4721,	4731,	4741,	4751;
		setarray '@winA[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winA[0],	0,	0,	0,	0,	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

	/* ��1�G���`�����g�����J�n */

		/* ���j���[�����J�n */
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
			""+getitemname('@slotA[5])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;
			case 4:	set '@en4,'@slotA[2];	set '@winArate,'@winA[2];	break;
			case 5:	set '@en4,'@slotA[3];	set '@winArate,'@winA[3];	break;
			case 6:	set '@en4,'@slotA[4];	set '@winArate,'@winA[4];	break;
			case 7:	set '@en4,'@slotA[5];	set '@winArate,'@winA[5];	break;	}
		/* ���j���[�����I�� */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,0,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; 								close; }
			}
		/* �G���`�����g1�I���̍ŏI�����I�� */
		}
	/* ��1�G���`�����g�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	[1]	[2]	[3]	[4]	*/
		setarray '@slotB[0],	4818,	29135,	4811,	4832,	4815;
		setarray '@winB[0],	10,	10,	10,	10,	10;
		//setarray '@winB[0],	0,	0,	0,	0,	0;

		/* ���j���[�����J�n */
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
		/* ���j���[�����I�� */

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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,0,'@en3,'@en4,0;	close; }
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; 								close; }
			}
		/* �G���`�����g2�I���̍ŏI�����I�� */
		}
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	*/
		setarray '@slotC[0],	29241,	29238,	29240,	4942,	29012,	29243;
		setarray '@winC[0],	10,	10,	10,	10,	10,	10;
		//setarray '@winC[0],	0,	0,	0,	0,	0,	0;
		/* ���j���[�����J�n */

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
		/* ���j���[�����I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
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
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1;									close;	}
				}
		/* �G���`�����g3�I���̍ŏI�����I�� */
		}
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	1,	0;
		setarray '@winD[0],	95,	0;	/* �X���b�g�G���`�����g�I���Ŏ��s��95���Z */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: - "; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			"�X���b�g�G���`�����g������",
			"�X���b�g�G���`�����g�����Ȃ�")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+":"+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+":"+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+":"+getitemname('@en2)+" ";
			if('@en1 == 1) { mes "��1�X���b�g: �X���b�g�G���`�����g"; }
			if('@en1 == 0) { mes "��1�X���b�g: ���I�� "; } 
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				set '@changerate,rand(1,100);			//�X���b�g�G���`�����g������
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@slotD[0] == 1 ) { if('@changerate >= '@winD[0]) { misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�听�����܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@changeid[0],1,1,0,0,0,0,0,0,0;	close;  } }
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@slotDcard,'@en2,'@en3,'@en4,0;	close;	}	//�X���b�g�G���`�����g��I�΂Ȃ��ꍇ��3�̃G���`�����g����
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1;									close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 19445 �������̊��[0] �I�� */
	}
}
