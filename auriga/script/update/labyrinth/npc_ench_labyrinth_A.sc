//2025/06/17 �A�b�v�f�[�g
//�����̖��{ ���{�����c�L�����v ���r�����X�G���`�����g

lby_in.gat,60,93,4	script	���{����������	805,{/*0-0*/

	mes "["+strnpcinfo(1)+"]";
	mes "���͓���̕����";
	mes "���r�����X�G���`�����g���o���܂��B";
	mes "�����͂ǂ̂悤�Ȃ��p���ł����H";
	next;
	switch(select(
	"�O���[�v1",
	"�O���[�v2",
	"�b����߂�")) {/*1-0*/

	case 1:	/* �O���[�v1 */
		/* �����ݒ� */
		set '@costAid,25662;
		set '@costAnum,1;
		setarray '@mainF,19451,19452;
		set '@pos,9;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}	//�擪�ɋ��ʏ���
		if(getequipisequiped('@pos) == 0) { mes "�w�蕔�ʂ� "+getitemname('@mainF[0])+" ["+getiteminfo('@mainF[0],10)+"] �𑕔����ĉ�����"; close; }
		if(equippeditem('@mainF[0]) != 1) { mes ""+getitemname('@mainF[0])+"["+getiteminfo('@mainF[0],10)+"]��1�������ĉ�����";	close; }
		/* �����ݒ� */

		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@mainF[0])+"��";
		mes "�X���b�g�G���`�����g���܂����H";
		next;
		if(select("�͂�","��߂�") == 2) {
			mes "["+strnpcinfo(1)+"]";
			mes "�����p���҂����Ă��܂��B";
			close; }
		set '@change,rand(0,99);
		if('@change > 95) {
			misceffect 622,"";
			delitem '@costAid,'@costAnum;
			delequip '@pos;
			getitem '@mainF[1],1;
			mes "["+strnpcinfo(1)+"]";
			mes "�������܂����B";
			close;	} else {
			misceffect 155,"";
			delitem '@costAid,'@costAnum;
			mes "["+strnpcinfo(1)+"]"; mes "���s���܂����B";
			close;	}

	case 2: /* �O���[�v2 */
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]	[10]	[11]	[12]	[13]	[14]	[15]	*/
		//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004,	460002;		//��15�� + ��1��
				/*	[0]	[1]	[2]	[3]	[4]	[5]	[6]		[7]	[8]	[9]	[10]	[11]	[12]	[13]	*/
		//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,		19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��
		//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,		15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��
		//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,		20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��
		//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,		22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��
		set '@costBid,783;
		set '@costBnum,10;
		if(countitem('@costBid) <= ('@costBnum - 1))	{ mes ""+getitemname('@costBid)+" �� "+'@costBnum+" �K�v�ł�";	close;	}

		switch(select(
		"������I��",
		"�������ڂ�������",
		"�b����߂�")) {/*2-0*/
			case 1:
			setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004,	460002;		//��15�� + ��1��
			setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0,	0,;		//�Z�� �Ў葄 �Ў蕀 ���萧��
			switch(select(
				"��߂�",
				""+getitemname('@mainA[0])+"["+getiteminfo('@mainA[0],10)+"]",
				""+getitemname('@mainA[1])+"["+getiteminfo('@mainA[1],10)+"]",
				""+getitemname('@mainA[2])+"["+getiteminfo('@mainA[2],10)+"]",
				""+getitemname('@mainA[3])+"["+getiteminfo('@mainA[3],10)+"]",
				""+getitemname('@mainA[4])+"["+getiteminfo('@mainA[4],10)+"]",
				""+getitemname('@mainA[5])+"["+getiteminfo('@mainA[5],10)+"]",
				""+getitemname('@mainA[6])+"["+getiteminfo('@mainA[6],10)+"]",
				""+getitemname('@mainA[7])+"["+getiteminfo('@mainA[7],10)+"]",
				""+getitemname('@mainA[8])+"["+getiteminfo('@mainA[8],10)+"]",
				""+getitemname('@mainA[9])+"["+getiteminfo('@mainA[9],10)+"]",
				""+getitemname('@mainA[10])+"["+getiteminfo('@mainA[10],10)+"]",
				""+getitemname('@mainA[11])+"["+getiteminfo('@mainA[11],10)+"]",
				""+getitemname('@mainA[12])+"["+getiteminfo('@mainA[12],10)+"]",
				""+getitemname('@mainA[13])+"["+getiteminfo('@mainA[13],10)+"]",
				""+getitemname('@mainA[14])+"["+getiteminfo('@mainA[14],10)+"]",
				"��������I��")) {/*2-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	set '@EQ,14;	break;	/*���폂�����܂�*/
				case 17:	set '@EQ,15;	break;	/*2-1*/}

				if('@EQ <= 13) {/* ����J�n */
					/* �����ݒ� */
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,4;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �����ݒ� */

					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(getitemid(getequipname(3)) == '@Lefthand['@EQ])	{ mes ""+getitemname('@Lefthand['@EQ])+" �͍���ɑ������Ȃ��ŉ������B";	close;	}
					if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					/*	�Ǘ��p�������� mes "[" +strnpcinfo(1)+ "]";
					mes "�����p�����";
					mes "���B�l : + "+'@ref+" ";
					mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
					mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
					mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
					mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
					next;	�Ǘ��p�����܂�*/
					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*2-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardD,'@slotD[rand(0,13)];
							/*	�Ǘ��p��������mes "[" +strnpcinfo(1)+ "]";
							mes "��4�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4709,	4739,	4749,	4719,	4729,	4759,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardC,'@slotC[rand(0,11)];
							/*	�Ǘ��p��������mes "[" +strnpcinfo(1)+ "]";
							mes "��3�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4879,	4875,	4876;
							set '@cardB,'@slotB[rand(0,2)];
							/*	�Ǘ��p��������mes "[" +strnpcinfo(1)+ "]";
							mes "��2�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break; /* ��2�X���b�g�I�� */
						/*2-2*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainA['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
				/* ����I�� */}

				if('@EQ == 14) {/* ���J�n */
				/* �����ݒ� */
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,3;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �����ݒ� */

					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";						close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					/*	�Ǘ��p�������� mes "[" +strnpcinfo(1)+ "]";
					mes "�����p�����";
					mes "���B�l : + "+'@ref+" ";
					mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
					mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
					mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
					mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
					next;	*/
					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*2-3*/
						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2:
							setarray '@slotD,4881,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,6)];
							/*	�Ǘ��p�������� mes "[" +strnpcinfo(1)+ "]";
							mes "��4�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break;

						case 3:
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29373,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,6)];
							/*	�Ǘ��p�������� mes "[" +strnpcinfo(1)+ "]";
							mes "��3�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break;

						case 4:
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,	310193,	310193;
							set '@cardC,'@slotC[rand(0,1)];
							/*	�Ǘ��p�������� mes "[" +strnpcinfo(1)+ "]";
							mes "��2�X���b�g�I������";
							mes "A "+'@cardA+" "+getitemname('@cardA)+" ";
							mes "B "+'@cardB+" "+getitemname('@cardB)+" ";
							mes "C "+'@cardC+" "+getitemname('@cardC)+" ";
							mes "D "+'@cardD+" "+getitemname('@cardD)+" ";
							next;	�Ǘ��p�����܂�*/
						break;

						/*2-3*/}
					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainA['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
				/* �� �I��*/}
/*---------------------------------------------------------------------------------*/
			/* �������J�n */
			setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��

				switch(select(
				"��߂�",
				""+getitemname('@mainB[0])+"["+getiteminfo('@mainB[0],10)+"]",
				""+getitemname('@mainB[1])+"["+getiteminfo('@mainB[1],10)+"]",
				""+getitemname('@mainB[2])+"["+getiteminfo('@mainB[2],10)+"]",
				""+getitemname('@mainB[3])+"["+getiteminfo('@mainB[3],10)+"]",
				""+getitemname('@mainB[4])+"["+getiteminfo('@mainB[4],10)+"]",
				""+getitemname('@mainB[5])+"["+getiteminfo('@mainB[5],10)+"]",
				""+getitemname('@mainB[6])+"["+getiteminfo('@mainB[6],10)+"]",
				""+getitemname('@mainB[7])+"["+getiteminfo('@mainB[7],10)+"]",
				""+getitemname('@mainB[8])+"["+getiteminfo('@mainB[8],10)+"]",
				""+getitemname('@mainB[9])+"["+getiteminfo('@mainB[9],10)+"]",
				""+getitemname('@mainB[10])+"["+getiteminfo('@mainB[10],10)+"]",
				""+getitemname('@mainB[11])+"["+getiteminfo('@mainB[11],10)+"]",
				""+getitemname('@mainB[12])+"["+getiteminfo('@mainB[12],10)+"]",
				""+getitemname('@mainB[13])+"["+getiteminfo('@mainB[13],10)+"]",
				"�Z��I��")) {/*3-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

				case 2:	set '@EQ,0;	/*19449���I�{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-2*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 3:	set '@EQ,1;	/*19473�����{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-3*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,9)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-3*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 4:	set '@EQ,2; /*19447���q�{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-4*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,310319,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-4*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 5:	set '@EQ,3; /*5599�����{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-5*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29374,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-5*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 6:	set '@EQ,4; /*5739�l�n�{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-6*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29373,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4879,	4879;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-6*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 7:	set '@EQ,5; /*5514�o���{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-7*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4719,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4876,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-7*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 8:	set '@EQ,6; /*5569�o���{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-8*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29374,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4879,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-8*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 9:	set '@EQ,7; /*19468�V���{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-9*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,27412,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29509,	29509;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-9*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 10:	set '@EQ,8; /*19471�V噋{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-10*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4825,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-10*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 11:	set '@EQ,9; /*5546���r�{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-11*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-11*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 12:	set '@EQ,10; /*15824�v���L�I���N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-12*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4719,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-12*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 13:	set '@EQ,11; /*19496��r�{�̃N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-13*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4881,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29371,	29371;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-13*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 14:	set '@EQ,12; /*15823�|���b�N�X�N���E��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-14*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4825,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29436,	29436;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-14*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 15:	set '@EQ,13; /*400015��㹋{�̃_�C�A�f��*/
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*3-15*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,5)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)	{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,4729,	4853,	4854,	4855,	4856,	4857;
							set '@cardC,'@slotC[rand(0,5)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)	{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4879,	4876;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*3-15*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;

				case 16:	break;	/*3-1*/}
/*---------------------------------------------------------------------------------*/
			/* �Z�J�n */
			setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��
				switch(select(
				"��߂�",
				""+getitemname('@mainC[0])+"["+getiteminfo('@mainC[0],10)+"]",
				""+getitemname('@mainC[1])+"["+getiteminfo('@mainC[1],10)+"]",
				""+getitemname('@mainC[2])+"["+getiteminfo('@mainC[2],10)+"]",
				""+getitemname('@mainC[3])+"["+getiteminfo('@mainC[3],10)+"]",
				""+getitemname('@mainC[4])+"["+getiteminfo('@mainC[4],10)+"]",
				""+getitemname('@mainC[5])+"["+getiteminfo('@mainC[5],10)+"]",
				""+getitemname('@mainC[6])+"["+getiteminfo('@mainC[6],10)+"]",
				""+getitemname('@mainC[7])+"["+getiteminfo('@mainC[7],10)+"]",
				""+getitemname('@mainC[8])+"["+getiteminfo('@mainC[8],10)+"]",
				""+getitemname('@mainC[9])+"["+getiteminfo('@mainC[9],10)+"]",
				""+getitemname('@mainC[10])+"["+getiteminfo('@mainC[10],10)+"]",
				""+getitemname('@mainC[11])+"["+getiteminfo('@mainC[11],10)+"]",
				""+getitemname('@mainC[12])+"["+getiteminfo('@mainC[12],10)+"]",
				""+getitemname('@mainC[13])+"["+getiteminfo('@mainC[13],10)+"]",
				"���ɂ�������̂�I��")) {/*4-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	break;	/*4-1*/}

				if('@EQ <= 13) {/* �Z�J�n */
					/* �����ݒ� */
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �����ݒ� */

					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*4-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,11)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,29305,	29302,	29303,	29304,	29309,	29306,	29307,	4853,	4856,	4857,	4854,	4855,	4858;
							set '@cardC,'@slotC[rand(0,12)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,4879,	29436,	4876;
							set '@cardB,'@slotB[rand(0,2)];
						break; /* ��2�X���b�g�I�� */
						/*4-2*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainC['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
				/* �Z�I�� */}
/*---------------------------------------------------------------------------------*/
			/* ���J�n */
			setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��
				switch(select(
				"��߂�",
				""+getitemname('@mainD[0])+"["+getiteminfo('@mainD[0],10)+"]",
				""+getitemname('@mainD[1])+"["+getiteminfo('@mainD[1],10)+"]",
				""+getitemname('@mainD[2])+"["+getiteminfo('@mainD[2],10)+"]",
				""+getitemname('@mainD[3])+"["+getiteminfo('@mainD[3],10)+"]",
				""+getitemname('@mainD[4])+"["+getiteminfo('@mainD[4],10)+"]",
				""+getitemname('@mainD[5])+"["+getiteminfo('@mainD[5],10)+"]",
				""+getitemname('@mainD[6])+"["+getiteminfo('@mainD[6],10)+"]",
				""+getitemname('@mainD[7])+"["+getiteminfo('@mainD[7],10)+"]",
				""+getitemname('@mainD[8])+"["+getiteminfo('@mainD[8],10)+"]",
				""+getitemname('@mainD[9])+"["+getiteminfo('@mainD[9],10)+"]",
				""+getitemname('@mainD[10])+"["+getiteminfo('@mainD[10],10)+"]",
				""+getitemname('@mainD[11])+"["+getiteminfo('@mainD[11],10)+"]",
				""+getitemname('@mainD[12])+"["+getiteminfo('@mainD[12],10)+"]",
				""+getitemname('@mainD[13])+"["+getiteminfo('@mainD[13],10)+"]",
				"�C��I��")) {/*5-1*/

				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;
				case 16:	break;	/*5-1*/}

				if('@EQ <= 13) {/* ���J�n */
					/* �����ݒ� */
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �����ݒ� */

					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*5-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,11)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,10)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,27408,	27409,	27410,	27411;
							set '@cardB,'@slotB[rand(0,3)];
						break; /* ��2�X���b�g�I�� */
						/*5-2*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainD['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
				/* ���I�� */}
/*---------------------------------------------------------------------------------*/
			/* �C�J�n */
			setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��
				switch(select(
				"��߂�",
				""+getitemname('@mainE[0])+"["+getiteminfo('@mainE[0],10)+"]",
				""+getitemname('@mainE[1])+"["+getiteminfo('@mainE[1],10)+"]",
				""+getitemname('@mainE[2])+"["+getiteminfo('@mainE[2],10)+"]",
				""+getitemname('@mainE[3])+"["+getiteminfo('@mainE[3],10)+"]",
				""+getitemname('@mainE[4])+"["+getiteminfo('@mainE[4],10)+"]",
				""+getitemname('@mainE[5])+"["+getiteminfo('@mainE[5],10)+"]",
				""+getitemname('@mainE[6])+"["+getiteminfo('@mainE[6],10)+"]",
				""+getitemname('@mainE[7])+"["+getiteminfo('@mainE[7],10)+"]",
				""+getitemname('@mainE[8])+"["+getiteminfo('@mainE[8],10)+"]",
				""+getitemname('@mainE[9])+"["+getiteminfo('@mainE[9],10)+"]",
				""+getitemname('@mainE[10])+"["+getiteminfo('@mainE[10],10)+"]",
				""+getitemname('@mainE[11])+"["+getiteminfo('@mainE[11],10)+"]",
				""+getitemname('@mainE[12])+"["+getiteminfo('@mainE[12],10)+"]",
				""+getitemname('@mainE[13])+"["+getiteminfo('@mainE[13],10)+"]")) {/*6-1*/
				case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
				case 2:	set '@EQ,0;	break;
				case 3:	set '@EQ,1;	break;
				case 4:	set '@EQ,2;	break;
				case 5:	set '@EQ,3;	break;
				case 6:	set '@EQ,4;	break;
				case 7:	set '@EQ,5;	break;
				case 8:	set '@EQ,6;	break;
				case 9:	set '@EQ,7;	break;
				case 10:	set '@EQ,8;	break;
				case 11:	set '@EQ,9;	break;
				case 12:	set '@EQ,10;	break;
				case 13:	set '@EQ,11;	break;
				case 14:	set '@EQ,12;	break;
				case 15:	set '@EQ,13;	break;	/*6-1*/}

				if('@EQ <= 13) {/* �C�J�n */
					/* �����ݒ� */
					set '@refA,8;					//'@slotA�̐��B�l����(8�ȏ�)��������
					set '@refB,9;					//'@slotB�̐��B�l����(9�ȏ�)
					set '@refC,10;					//'@slotC�̐��B�l����(10�ȏ�)
					set '@refD,99;					//'@slotD�̐��B�l����(���g�p)
					set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
					/* �����ݒ� */

					/* �G���`�����g��{���� */
					if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
					if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]��1�������ĉ�����";	close;	}
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					/* �G���`�����g��{���� */

					/* �����p���ݒ� */
					set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
					set '@cardA,getequipcardid('@pos,0);	/* �������� */
					set '@cardB,getequipcardid('@pos,1);	/* �������� */
					set '@cardC,getequipcardid('@pos,2);	/* �������� */
					set '@cardD,getequipcardid('@pos,3);	/* �������� */
					/* �����p���ݒ� */

					mes "[" +strnpcinfo(1)+ "]";
					mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"] ";
					mes "�ł��ˁH";
					mes "����ł̓G���`�����g������";
					mes "�X���b�g��I��ŉ������B";
					next;
					switch(select(
						"��߂�",
						"��4�X���b�g�ɃG���`�����g",
						"��3�X���b�g�ɃG���`�����g",
						"��2�X���b�g�ɃG���`�����g")) {/*6-2*/

						case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

						case 2: /* ��4�X���b�g�J�n */
							setarray '@slotD,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardD,'@slotD[rand(0,7)];
						break; /* ��4�X���b�g�I�� */

						case 3: /* ��3�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotC,310193,	4853,	4854,	4855,	4856,	4857,	4858;
							set '@cardC,'@slotC[rand(0,6)];
						break; /* ��3�X���b�g�I�� */

						case 4: /* ��2�X���b�g�J�n */
							if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
							setarray '@slotB,29591,	29591;
							set '@cardB,'@slotB[rand(0,1)];
						break; /* ��2�X���b�g�I�� */
						/*6-2*/}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costBid,'@costBnum;
					getitem2 '@mainE['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
				/* �C�I�� */}

			case 2:
				mes "[" +strnpcinfo(1)+ "]";
				mes "���B�l�ŃG���`�����g�ł���X���b�g�������܂��B";
				mes "�G���`�����g�͕K���������܂��B";
				mes "�G���`�����g���e�͒��I�Ō��܂�܂��B";
				mes "�G���`�����g�͏㏑������܂��B";
				close;

			case 3:
				mes "[" +strnpcinfo(1)+ "]";
				mes "�����p���҂����Ă��܂��B";
				mes "2-0 ���[";
				close;
			/*2-0*/}

	case 3:	break;
		close;
	/*1-0*/}
/*0-0*/}