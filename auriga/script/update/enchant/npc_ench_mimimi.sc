//2025/06/03 �A�b�v�f�[�g
//���̓G���`�����g�`�P�b�g �t���O�̐ݒ� ������
//�G���`�����g�p�^�[�� ���B�����Ȃ� �S�X���b�g�G���`�� �X���b�g�G���`�����g�Ȃ�

//prontera.gat,160,115,4	script	���͐E�l�E����	815,{
yuno.gat,211,291,3	script	���͐E�l�E����	815,{

	/* ���ʏ����ݒ� */
				//[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]
	setarray '@main[0],	400012,	22235,	20974,	20977,	20978,	20979,	32268,	32269,	400013;	//�G���`�����g������A�C�e��
	setarray '@slotnum[0],	0,	0;
	//setarray '@changeid[0],	19444,19446;	//�X���b�g�G���`�����g
	set '@costAid,7347;								//�K�v�ȃA�C�e�� ���̓G���`�����g�`�P�b�g -> ���ݒ� 7347 �����L�^
	set '@costAnum,100;								//�K�v�ȃt���O�̐� 100
	if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}	//�擪�ɋ��ʏ��������ݑS�̂��ȑf������
	//if('@costAid <= ('@costAnum - 1))	{ mes "���̓G���`�����g�`�P�b�g�� "+'@costAnum+" ���K�v�ł�";	close;	}	//�擪�ɋ��ʏ��������ݑS�̂��ȑf������
	/* ���ʏ����ݒ肱���܂� */

	/* �X�N���v�g�J�n */
	mes "["+strnpcinfo(1)+"]";
	mes "���́A�Ƃ��錤�����˗����󂯂�";
	mes "�`���҂���̎�`�������Ă��܂��B";
	mes "�G���`�����g�˗��ł����H";
	mes "���̓G���`�����g�`�P�b�g : "+'@costAnum+" ��";
	mes ""+getitemname('@costAid)+" "+'@costAnum+" �� �K�v";
	next;
	if(select("�G���`�����g���˗�����","��b����߂܂�") == 2) { mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;	}

	mes "["+strnpcinfo(1)+"]";
	mes "�ǂ̑����ɃG���`�����g���܂����H";
	next;
	switch(select(
		"����ς��߂�",
		""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]",	/* "�A�C�e����""[�X���b�g]" */
		""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]",
		""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]",
		""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]",
		""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]",
		""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]",
		""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]",
		""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]",
		""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]")) {
	case 1:	mes "["+strnpcinfo(1)+"]"; mes "�����p���҂����Ă��܂�";	close;

	/* '@main[0] 400012 �t���̃}�W�F�X�e�B�b�N�S�[�g[0] �J�n *//* ���B�������݃T���v�� */
	case 2:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[0]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[0])+" ["+getiteminfo('@main[0],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[0]) != 1)		{ mes ""+getitemname('@main[0])+"["+getiteminfo('@main[0],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� �S�X���b�g�G���`�����g�̏ꍇ�͖��� */
		//set '@ref,0;					/* �A�C�e���̐��B�l��0�ɂ��� */
		//set '@slotDcard,0;				/* ��1�X���b�g�̃J�[�h������ */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotA[0],	29372;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g: ����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g1�I���̍ŏI�����J�n */	/* ���B�����J�n */
		if(getequiprefinerycnt('@pos) < '@refB) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
			if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
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
		}
		/* �G���`�����g1�I���̍ŏI�����I�� */ /* ���B�����I�� */
	/* ��1�G���`�����g�����I�� */

	/* ��2�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotB[0],	27412;
		setarray '@winB[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */
		
		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g: ����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];		break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g2�I���̍ŏI�����J�n */	/* ���B�����J�n */
		if(getequiprefinerycnt('@pos) < '@refC) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
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
		}
		/* �G���`�����g2�I���̍ŏI�����I�� */	/* ���B�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotC[0],	300229,	310650;
		//setarray '@winC[0],	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */
		
		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g: ����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;
			case 3:	set '@en2,'@slotC[1];		set '@winCrate,'@winC[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g3�I���̍ŏI�����J�n */	/* ���B�����J�n */
			if(getequiprefinerycnt('@pos) < '@refD) {
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
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
			}
		/* �G���`�����g3�I���̍ŏI�����I�� */	/* ���B�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
		/* �G���`�����gID�ƌʐ������ݒ�J�n */
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ�I�� */

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g: ����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select("��߂�","�G���`�����g����")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1; getitem2 '@main[0],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;		close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[0],1;									close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 400012 �t���̃}�W�F�X�e�B�b�N�S�[�g[0] �I�� */

	/* '@main[1] 22235 ��̖є�̃V���[�Y[0] �J�n */
	case 3:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[1]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[1])+" ["+getiteminfo('@main[1],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[1]) != 1)		{ mes ""+getitemname('@main[1])+"["+getiteminfo('@main[1],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	[1]	*/
		setarray '@slotA[0],	29373,	311421;
		setarray '@winA[0],	0,	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"",
			""+getitemname('@slotA[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;
			case 3:	set '@en4,'@slotA[1];	set '@winArate,'@winA[1];	break;	}
		/* ���j���[�����I�� */
		/* �G���`�����g1�I���̍ŏI�����J�n */	/* ���B�����J�n */
		/* �G���`�����g1�I���̍ŏI�����I�� */	/* ���B�����I�� */
	/* ��1�G���`�����g�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	[1]	*/
		setarray '@slotB[0],	29373,	311421;
		setarray '@winB[0],	0,	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"",
			""+getitemname('@slotB[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;
			case 3:	set '@en3,'@slotB[1];	set '@winBrate,'@winB[1];	break;	}
		/* ���j���[�����I�� */
		/* �G���`�����g2�I���̍ŏI�����J�n */	/* ���B�����J�n */
		/* �G���`�����g2�I���̍ŏI�����I�� */	/* ���B�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
		/* �G���`�����g3�I���̍ŏI�����J�n */	/* ���B�����J�n */
		/* �G���`�����g3�I���̍ŏI�����I�� */	/* ���B�����I�� */
	/* ��3�G���`�����g�����I�� */

	/* ��4�G���`�����g�����J�n */
				/*	[0]	[1]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */
	/* ��4�G���`�����g�����I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1; getitem2 '@main[1],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[1],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 22235 ��̖є�̃V���[�Y[0] �I�� */

	/* '@main[2] 20974 �s�I�j�[�}�~�[�̃t�[�h[0] �J�n */
	case 4:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[2]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[2])+" ["+getiteminfo('@main[2],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[2]) != 1)		{ mes ""+getitemname('@main[2])+"["+getiteminfo('@main[2],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29214;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[2],1; getitem2 '@main[2],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[2],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 20974 �s�I�j�[�}�~�[�̃t�[�h[0] �I�� */

	/* '@main[3] 20977 �X�m�[�t���b�v�̃t�[�h[0] �J�n */
	case 5:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[3]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[3])+" ["+getiteminfo('@main[3],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[3]) != 1)		{ mes ""+getitemname('@main[3])+"["+getiteminfo('@main[3],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29216;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[3],1; getitem2 '@main[3],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[3],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 20977 �X�m�[�t���b�v�̃t�[�h[0] �I�� */

	/* '@main[4] 20978 ���E���̂ق���̃t�[�h[0] �J�n */
	case 6:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[4]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[4])+" ["+getiteminfo('@main[4],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[4]) != 1)		{ mes ""+getitemname('@main[4])+"["+getiteminfo('@main[4],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29215;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[4],1; getitem2 '@main[4],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[4],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* 20978 ���E���̂ق���̃t�[�h[0] �I�� */

	/* '@main[5] 20979 �҂����n�[�u�̃t�[�h[0] �J�n */
	case 7:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[5]) >= 2) 		{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[5])+" ["+getiteminfo('@main[5],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[5]) != 1)		{ mes ""+getitemname('@main[5])+"["+getiteminfo('@main[5],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29217;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	27397;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	29373,	311422;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[5],1; getitem2 '@main[5],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[5],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* '@main[5] 20979 �҂����n�[�u�̃t�[�h[0] �I�� */

	/* '@main[6] 32268 �J���j�E�������O[0] �J�n */
	case 8:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,7;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[6]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�A�N�Z�T��(1) �� "+getitemname('@main[6])+" ["+getiteminfo('@main[6],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[6]) != 1)		{ mes ""+getitemname('@main[6])+"["+getiteminfo('@main[6],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29373;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	311421;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[6],1; getitem2 '@main[6],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[6],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* '@main[6] 32268 �J���j�E�������O[0] �I�� */

	/* '@main[7] 32269 �J���j�E���C�������O[0] �J�n */
	case 9:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,8;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[7]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�A�N�Z�T��(2) �� "+getitemname('@main[7])+" ["+getiteminfo('@main[7],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[7]) != 1)		{ mes ""+getitemname('@main[7])+"["+getiteminfo('@main[7],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	29373;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	311421;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	27412;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	300229,	310650;
		setarray '@winD[0],	0,	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"",
			""+getitemname('@slotD[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;
			case 3:	set '@en1,'@slotD[1];		set '@winDrate,'@winD[1];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[7],1; getitem2 '@main[7],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[7],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* '@main[7] 32269 �J���j�E���C�������O[0] �I�� */
	
	/* '@main[8] 400013 ���킦���`���R�X�e�B�b�N[0] �J�n */
	case 10:
		/* ���������ݒ� */
		set '@refA,0;					//'@slotA�̐��B�l����(���g�p)
		set '@refB,0;					//'@slotB�̐��B�l����(���g�p)
		set '@refC,0;					//'@slotC�̐��B�l����(���g�p)
		set '@refD,0;					//'@slotD�̐��B�l����(���g�p)
		set '@pos,10;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
		if(countitem('@main[8]) >= 2) 			{ mes "�����A�C�e���������Ă��܂�";							close;	}
		if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@main[8])+" ["+getiteminfo('@main[8],10)+"] �𑕔����ĉ�����";	close;	}
		if(equippeditem('@main[8]) != 1)		{ mes ""+getitemname('@main[8])+"["+getiteminfo('@main[8],10)+"]��1�������ĉ�����";	close;	}
		if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
		/* ���������ݒ肱���܂� */

		/* �����p���ݒ� */
		set '@ref,getequiprefinerycnt('@pos);		/* �A�C�e���̐��B�l���G���`�����g��Ɉ����p�� */
		//set '@slotDcard,getequipcardid('@pos,0);	/* ��1�X���b�g�̃J�[�h���G���`�����g��Ɉ����p�� */
		/* �����p���ݒ肱���܂� */


	/* ��1�G���`�����g�����J�n */
		/* �G���`�����gID�ƌʐ������ݒ� */
				/*	[0]	*/
		setarray '@slotA[0],	4949;
		setarray '@winA[0],	0;
		/* �G���`�����gID�ƌʐ������ݒ肱���܂� */

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		if(getequipcardid('@pos,3) == 0) { mes "��4�X���b�g:����"; } else { mes "��4�X���b�g:"+getitemname(getequipcardid('@pos,3))+" "; }
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��1�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotA[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en4,'@slotA[0];	set '@winArate,'@winA[0];	break;	}
		/* ���j���[�����I�� */

	/* ��2�G���`�����g�����J�n */
				/*	[0]	*/
		setarray '@slotB[0],	4815;
		setarray '@winB[0],	0;

		/* ���j���[�����J�n */
		mes "["+strnpcinfo(1)+"]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		if(getequipcardid('@pos,2) == 0) { mes "��3�X���b�g:����"; } else { mes "��3�X���b�g:"+getitemname(getequipcardid('@pos,2))+" "; }
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��2�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotB[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en3,'@slotB[0];	set '@winBrate,'@winB[0];	break;	}
		/* ���j���[�����I�� */
	/* ��2�G���`�����g�����I�� */

	/* ��3�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotC[0],	4869;
		setarray '@winC[0],	0;
		/* ���j���[�����J�n */

		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		if(getequipcardid('@pos,1) == 0) { mes "��2�X���b�g:����"; } else { mes "��2�X���b�g:"+getitemname(getequipcardid('@pos,1))+" "; }
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��3�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotC[0])+"",
			""+getitemname('@slotC[1])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en2,'@slotC[0];		set '@winCrate,'@winC[0];	break;	}
		/* ���j���[�����I�� */
	/* ��3�G���`�����g�I�������I�� */

	/* ��4�G���`�����g�I�������J�n */
				/*	[0]	*/
		setarray '@slotD[0],	4900;
		setarray '@winD[0],	0;

		/* ���j���[�����J�n */
		mes "[" +strnpcinfo(1)+ "]";
		mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
		mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
		mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
		if(getequipcardid('@pos,0) == 0) { mes "��1�X���b�g:����"; } else { mes "��1�X���b�g:"+getitemname(getequipcardid('@pos,0))+" "; }
		mes "��4�G���`����I��ŉ�����";
			next;
			switch(select(
			"��߂�",
			""+getitemname('@slotD[0])+"")) {
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:	set '@en1,'@slotD[0];		set '@winDrate,'@winD[0];	break;	}
		/* ���j���[�����I�� */

		/* �G���`�����g4�I���̊m�F�J�n */
			mes "[" +strnpcinfo(1)+ "]";
			mes "��4�X���b�g: "+'@en4+" : "+getitemname('@en4)+" ";
			mes "��3�X���b�g: "+'@en3+" : "+getitemname('@en3)+" ";
			mes "��2�X���b�g: "+'@en2+" : "+getitemname('@en2)+" ";
			mes "��1�X���b�g: "+'@en1+" : "+getitemname('@en1)+" ";
			mes "����ł�낵���ł����H";
		/* �G���`�����g4�I���̊m�F�I�� */

		/* �G���`�����g�A�C�e���擾�����J�n */
			next;
			switch(select(
			"��߂�",
			"�G���`�����g����"))	{
			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
			case 2:
				set '@winrate,(100 - ('@winArate + '@winBrate + '@winCrate + '@winDrate));
				set '@result,rand(1,100);
				mes "[" +strnpcinfo(1)+ "]";
				mes "�X���b�g���s�� : "+'@changerate+" ";
				mes "�G���`�����s�� : "+('@winArate + '@winBrate + '@winCrate + '@winDrate)+" ";
				mes "�X���b�g�G���`�����g�ݒ萬���� : "+'@winD[0]+" ";
				next;
				if('@winrate >= '@result)	{ misceffect 154,""; mes "[" +strnpcinfo(1)+ "]"; mes "�������܂���"; delitem '@costAid,'@costAnum; delitem '@main[8],1; getitem2 '@main[8],1,1,'@ref,0,'@en1,'@en2,'@en3,'@en4,0;	close;	}	//��1�X���b�g�ɃG���`�����g����ꍇ�� ['@slotDcard] -> ['@en1] �ύX
				else				{ misceffect 155,""; mes "[" +strnpcinfo(1)+ "]"; mes "���s���܂���"; delitem '@costAid,'@costAnum; delitem '@main[8],1;								close;	}
			}
		/* �G���`�����g�A�C�e���擾�����I�� */
	/* '@main[8] 400013 ���킦���`���R�X�e�B�b�N[0] �I�� */

	}
}
