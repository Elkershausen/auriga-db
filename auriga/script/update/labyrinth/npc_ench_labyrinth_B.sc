//2025/06/24 �A�b�v�f�[�g
//�����̖��{ ���{�����c�L�����v ���r�����X�G���`�����g

lby_in.gat,63,93,4	script	�{�얂�p�t�̏���#32217	893,{

		//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;		//��15��
		//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��
		//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��
		//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��
		//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��
		//setarray '@mainF,	460002;		//��1��
		//setarray '@mainG,	19347,	15277,	20917,	22187;	//�h����
		
	mes "["+strnpcinfo(1)+"]";
	mes "���͓���̕����";
	mes "���z���r�����X�G���`�����g���o���܂��B";
	mes "�����͂ǂ̂悤�Ȃ��p���ł����H";
	next;
	switch(select(
	"���z�X�V������",
	"���z�ς݃G���`�����g",
	"�b����߂�")) {

	case 1:	/* ���z�X�V������ */
		/* �����ݒ� */
		set '@costAid,783;
		set '@costAnum,100;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}
		/* �����ݒ� */
		
		/* �T���i�[�����͕ʘg */
		setarray '@mainG,	19347,	15277,	20917,	22187;
		/* �T���i�[�����͕ʘg */

		mes "["+strnpcinfo(1)+"]";
		mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �����";
		mes "+10 �E�ƃp�b�P�[�W������";
		mes "���z�X�V���G���`�����g���܂����H";
		next;
		if(select("�G���`�����g����","��߂�") == 2) {	mes "["+strnpcinfo(1)+"]";	mes "�����p���҂����Ă��܂��B";	close; }
		mes "["+strnpcinfo(1)+"]";
		mes "�������ʂ�I��ŉ�����";
		next;
		switch(select(
			"��߂�",
			"���� ��3�X���b�g",
			"�� ��1�X���b�g",
			"�Z ��4�X���b�g",
			"�� ��1�X���b�g",
			"�C ��1�X���b�g",
			"�� ��1�X���b�g",
			""+getitemname('@mainG[0])+"",
			""+getitemname('@mainG[1])+"",
			""+getitemname('@mainG[2])+"",
			""+getitemname('@mainG[3])+"")) {/*���z�J�n*/

			case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

			case 2: /*���풴�z*/
			setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;	//��15��
			setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0;	//�Z���Ў茕�Ў蕀
				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,4;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������
				set '@limpos,2;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainA[0])+"",
				""+getitemname('@mainA[1])+"",
				""+getitemname('@mainA[2])+"",
				""+getitemname('@mainA[3])+"",
				""+getitemname('@mainA[4])+"",
				""+getitemname('@mainA[5])+"",
				""+getitemname('@mainA[6])+"",
				""+getitemname('@mainA[7])+"",
				""+getitemname('@mainA[8])+"",
				""+getitemname('@mainA[9])+"",
				""+getitemname('@mainA[10])+"",
				""+getitemname('@mainA[11])+"",
				""+getitemname('@mainA[12])+"",
				""+getitemname('@mainA[13])+"",
				""+getitemname('@mainA[14])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;
					case 16: set '@EQ,14;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(getitemid(getequipname(3)) == '@Lefthand['@EQ])	{ mes ""+getitemname('@Lefthand['@EQ])+" �͍���ɑ������Ȃ��ŉ������B";	close;	}
				if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,0;				/* �������� ��4�X���b�g������*/
				set '@cardC,310323;			/* �������� ��3�X���b�g 310323 �Œ� */
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/

				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*���풴�z*/
			case 3:	/*�����z*/
			setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��

				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//�G���`�����gID�� '@cardA �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,0;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainB[0])+"",
				""+getitemname('@mainB[1])+"",
				""+getitemname('@mainB[2])+"",
				""+getitemname('@mainB[3])+"",
				""+getitemname('@mainB[4])+"",
				""+getitemname('@mainB[5])+"",
				""+getitemname('@mainB[6])+"",
				""+getitemname('@mainB[7])+"",
				""+getitemname('@mainB[8])+"",
				""+getitemname('@mainB[9])+"",
				""+getitemname('@mainB[10])+"",
				""+getitemname('@mainB[11])+"",
				""+getitemname('@mainB[12])+"",
				""+getitemname('@mainB[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;			/* ���B�l +7 */
				set '@cardD,0;			/* �������� ��4�X���b�g������*/
				set '@cardC,0;			/* �������� ��3�X���b�g������*/
				set '@cardB,0;			/* �������� ��2�X���b�g������*/
				set '@cardA,310323;		/* �������� ��1�X���b�g310323 �Œ� */
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�����z*/
			case 4:	/*�Z���z*/
			setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��

				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,3;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainC[0])+"",
				""+getitemname('@mainC[1])+"",
				""+getitemname('@mainC[2])+"",
				""+getitemname('@mainC[3])+"",
				""+getitemname('@mainC[4])+"",
				""+getitemname('@mainC[5])+"",
				""+getitemname('@mainC[6])+"",
				""+getitemname('@mainC[7])+"",
				""+getitemname('@mainC[8])+"",
				""+getitemname('@mainC[9])+"",
				""+getitemname('@mainC[10])+"",
				""+getitemname('@mainC[11])+"",
				""+getitemname('@mainC[12])+"",
				""+getitemname('@mainC[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,310323;			/* �������� ��4�X���b�g310323 �Œ� */
				set '@cardC,0;				/* �������� ��3�X���b�g������*/
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*�Z���z*/
			case 5:	/*�����z*/
			setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��

				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//�G���`�����gID�� '@cardA �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,0;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainD[0])+"",
				""+getitemname('@mainD[1])+"",
				""+getitemname('@mainD[2])+"",
				""+getitemname('@mainD[3])+"",
				""+getitemname('@mainD[4])+"",
				""+getitemname('@mainD[5])+"",
				""+getitemname('@mainD[6])+"",
				""+getitemname('@mainD[7])+"",
				""+getitemname('@mainD[8])+"",
				""+getitemname('@mainD[9])+"",
				""+getitemname('@mainD[10])+"",
				""+getitemname('@mainD[11])+"",
				""+getitemname('@mainD[12])+"",
				""+getitemname('@mainD[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;			/* ���B�l +7 */
				set '@cardD,0;			/* �������� ��4�X���b�g������*/
				set '@cardC,0;			/* �������� ��3�X���b�g������*/
				set '@cardB,0;			/* �������� ��2�X���b�g������*/
				set '@cardA,310323;		/* �������� ��1�X���b�g310323 �Œ� */
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*�Z���z*/
			case 6:	/*�C���z*/
			setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��

				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//�G���`�����gID�� '@cardA �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,0;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainE[0])+"",
				""+getitemname('@mainE[1])+"",
				""+getitemname('@mainE[2])+"",
				""+getitemname('@mainE[3])+"",
				""+getitemname('@mainE[4])+"",
				""+getitemname('@mainE[5])+"",
				""+getitemname('@mainE[6])+"",
				""+getitemname('@mainE[7])+"",
				""+getitemname('@mainE[8])+"",
				""+getitemname('@mainE[9])+"",
				""+getitemname('@mainE[10])+"",
				""+getitemname('@mainE[11])+"",
				""+getitemname('@mainE[12])+"",
				""+getitemname('@mainE[13])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;
					case 3: set '@EQ,1;	break;
					case 4: set '@EQ,2;	break;
					case 5: set '@EQ,3;	break;
					case 6: set '@EQ,4;	break;
					case 7: set '@EQ,5;	break;
					case 8: set '@EQ,6;	break;
					case 9: set '@EQ,7;	break;
					case 10: set '@EQ,8;	break;
					case 11: set '@EQ,9;	break;
					case 12: set '@EQ,10;	break;
					case 13: set '@EQ,11;	break;
					case 14: set '@EQ,12;	break;
					case 15: set '@EQ,13;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] �𑕔����ĉ�����";	close; }
				if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;			/* ���B�l +7 */
				set '@cardD,0;			/* �������� ��4�X���b�g������*/
				set '@cardC,0;			/* �������� ��3�X���b�g������*/
				set '@cardB,0;			/* �������� ��2�X���b�g������*/
				set '@cardA,310323;		/* �������� ��1�X���b�g310323 �Œ� */
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
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
				/*�C���z*/
			case 7:	/*�����z*/
			setarray '@mainF,	460002;		//��

				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,3;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//�G���`�����gID�� '@cardA �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,0;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainF[0])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainF['@EQ])+" ["+getiteminfo('@mainF['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainF['@EQ]) != 1)		{ mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;			/* ���B�l +7 */
				set '@cardD,0;			/* �������� ��4�X���b�g������*/
				set '@cardC,0;			/* �������� ��3�X���b�g������*/
				set '@cardB,0;			/* �������� ��2�X���b�g������*/
				set '@cardA,310323;		/* �������� ��1�X���b�g310323 �Œ� */
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainF['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�����z*/

			case 8: /*�� 19347 �������V�����L[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,3;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainG[0])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,0;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,310323;			/* �������� ��4�X���b�g310323 �Œ� */
				set '@cardC,0;				/* �������� ��3�X���b�g������*/
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�� 19347 �������V�����L[1]*/

			case 9: /*�Z 15277 ���I�h�����X�[�c[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,3;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainG[1])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,1;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,310323;			/* �������� ��4�X���b�g310323 �Œ� */
				set '@cardC,0;				/* �������� ��3�X���b�g������*/
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�Z 15277 ���I�h�����X�[�c[1]*/

			case 10: /*�� 20917 ���I�h�����P�[�v[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,3;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainG[2])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,2;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,310323;			/* �������� ��4�X���b�g310323 �Œ� */
				set '@cardC,0;				/* �������� ��3�X���b�g������*/
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�� 20917 ���I�h�����P�[�v[1]*/

			case 11: /*�C 22187 ���I�h�����V���[�Y[1]*/
				setarray '@mainG,	19347,	15277,	20917,	22187;
				/* �����ݒ� */
				set '@refD,10;					//'@slotD�̐��B�l����
				set '@refC,99;					//'@slotC�̐��B�l����
				set '@refB,99;					//'@slotB�̐��B�l����
				set '@refA,99;					//'@slotA�̐��B�l����
				set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//�G���`�����gID�� '@cardD �Ɏw�肵��2�x�t����������			A B C D
				set '@limpos,3;					//�G���`�����g�J�[�h�X���b�g�� '@limpos �Ɏw�肵��2�x�t����������	0 1 2 3
				/* �����ݒ� */

			switch(select(
				"��߂�",
				""+getitemname('@mainG[3])+""))	{
					case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
					case 2: set '@EQ,3;	break;	}

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}		
				if(getequipcardid('@pos,'@limpos) == 310323) 	{ mes "���łɒ��z�����Ă��܂��B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,7;				/* ���B�l +7 */
				set '@cardD,310323;			/* �������� ��4�X���b�g310323 �Œ� */
				set '@cardC,0;				/* �������� ��3�X���b�g������*/
				set '@cardB,0;				/* �������� ��2�X���b�g������*/
				set '@cardA,getequipcardid('@pos,0);	/* �������� ��1�X���b�g�����p��*/
				/* �����p���ݒ� */

				/* �A�C�e������J�n */
				delequip '@pos;
				delitem '@costAid,'@costAnum;
				getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
				misceffect 154,"";
				mes "[" +strnpcinfo(1)+ "]";
				mes "OK�A�������܂����B";
				mes "���߂łƂ��������܂��B";
				next;
				mes "[" +strnpcinfo(1)+ "]";
				mes "����ł͂܂��A�����p�������B";
				close;
				/* �A�C�e������I�� */
				/*�C 22187 ���I�h�����V���[�Y[1]*/
			/*���z�I��*/}

	case 2:
	//setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;		//��15��
	//setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��
	//setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��
	//setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��
	//setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��
	//setarray '@mainF,	460002;		//��1��

		/* �����ݒ� */
		set '@costAid,783;
		set '@costAnum,10;
		if(countitem('@costAid) <= ('@costAnum - 1))	{ mes ""+getitemname('@costAid)+" �� "+'@costAnum+" �K�v�ł�";	close;	}
		/* �����ݒ� */
		
		/* �T���i�[�����͕ʘg */
		setarray '@mainG,	19347,	15277,	20917,	22187;
		/* �T���i�[�����͕ʘg */

	mes "[" +strnpcinfo(1)+ "]";
	mes "�������ʂ�I�񂾉�����";
	next;
	switch(select(
		"��߂�",
		"���� ��2 4�X���b�g",
		"�� ��2 3 4�X���b�g",
		"�Z ��2 3�X���b�g",
		"�� ��2 3 4�X���b�g",
		"�C ��2 3 4�X���b�g",
		"�� ��2 3 4�X���b�g",
		""+getitemname('@mainG[0])+"",
		""+getitemname('@mainG[1])+"",
		""+getitemname('@mainG[2])+"",
		""+getitemname('@mainG[3])+"")) {
		case 1:	mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

		case 2:
		setarray '@mainA,	1335,	1100,	16098,	640002,	700010,	640006,	570004,	580004,	28047,	1150,	32031,	28784,	26167,	28643,	700004;	//��15��
		setarray '@Lefthand,	1335,	1100,	0,	0,	0,	0,	0,	0,	0,	0,	0,	28784,	0,	0,	0;	//�Z���Ў茕�Ў蕀�̍��蔻��

		switch(select(
			"��߂�",
			""+getitemname('@mainA[0])+"",
			""+getitemname('@mainA[1])+"",
			""+getitemname('@mainA[2])+"",
			""+getitemname('@mainA[3])+"",
			""+getitemname('@mainA[4])+"",
			""+getitemname('@mainA[5])+"",
			""+getitemname('@mainA[6])+"",
			""+getitemname('@mainA[7])+"",
			""+getitemname('@mainA[8])+"",
			""+getitemname('@mainA[9])+"",
			""+getitemname('@mainA[10])+"",
			""+getitemname('@mainA[11])+"",
			""+getitemname('@mainA[12])+"",
			""+getitemname('@mainA[13])+"",
			""+getitemname('@mainA[14])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;
				case 16: set '@EQ,14;	break;	}

				/* �����ݒ� */
				set '@refD,9;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,99;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,4;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardC,310323;				//��3�X���b�g�͏��310323
				set '@limpos,2;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,1;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,0;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainA['@EQ])+" ["+getiteminfo('@mainA['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainA['@EQ]) != 1)		{ mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainA['@EQ])+"["+getiteminfo('@mainA['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g",
					"��3�X���b�g�ɃG���`�����g �ł��܂���",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {

					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;
					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4709,	4739,	4749,	4719,	4729,	4759,	29690,	29691,	29692,	29693,	29694,	29695,	29696,	29697,	4853,	4856,	4857,	4854,	4855,	4858,	29368,	29447,	29588,	29590;
					set '@cardD,'@slotD[rand(0,23)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardC,'@slotC[rand(0,6)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,4879,	4875,	4876,	29436,	29509,	29371;
					set '@cardB,'@slotB[rand(0,5)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 3:
		setarray '@mainB,	19449,	19473,	19447,	5599,	5739,	5514,	5569,	19468,	19471,	5546,	15824,	19496,	15823,	400015;		//��14��
		switch(select(
			"��߂�",
			""+getitemname('@mainB[0])+"",
			""+getitemname('@mainB[1])+"",
			""+getitemname('@mainB[2])+"",
			""+getitemname('@mainB[3])+"",
			""+getitemname('@mainB[4])+"",
			""+getitemname('@mainB[5])+"",
			""+getitemname('@mainB[6])+"",
			""+getitemname('@mainB[7])+"",
			""+getitemname('@mainB[8])+"",
			""+getitemname('@mainB[9])+"",
			""+getitemname('@mainB[10])+"",
			""+getitemname('@mainB[11])+"",
			""+getitemname('@mainB[12])+"",
			""+getitemname('@mainB[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* �����ݒ� */
				set '@refD,9;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//��1�X���b�g�͏��310323
				set '@limpos,0;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,1;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainB['@EQ])+" ["+getiteminfo('@mainB['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainB['@EQ]) != 1)		{ mes ""+getitemname('@mainB['@EQ])+"["+getiteminfo('@mainB['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
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
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,29214,	29215,	29216,	29217,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,21)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222,	310319,	4881,	29374,	29373,	27412,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardC,'@slotC[rand(0,25)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,4879,	4876,	29436,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainB['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */


		case 4:
		setarray '@mainC,	15412,	15425,	15408,	450015,	450140,	450133,	450130,	15418,	15424,	450129,	15448,	15426,	15447,	450011;		//�Z14��
		switch(select(
			"��߂�",
			""+getitemname('@mainC[0])+"",
			""+getitemname('@mainC[1])+"",
			""+getitemname('@mainC[2])+"",
			""+getitemname('@mainC[3])+"",
			""+getitemname('@mainC[4])+"",
			""+getitemname('@mainC[5])+"",
			""+getitemname('@mainC[6])+"",
			""+getitemname('@mainC[7])+"",
			""+getitemname('@mainC[8])+"",
			""+getitemname('@mainC[9])+"",
			""+getitemname('@mainC[10])+"",
			""+getitemname('@mainC[11])+"",
			""+getitemname('@mainC[12])+"",
			""+getitemname('@mainC[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* �����ݒ� */
				set '@refD,99;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//��4�X���b�g�͏��310323
				set '@limpos,3;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,0;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainC['@EQ])+" ["+getiteminfo('@mainC['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainC['@EQ]) != 1)		{ mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainC['@EQ])+"["+getiteminfo('@mainC['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g �ł��܂���",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,29214,	29215,	29216,	29217,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,21)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29649,	29650,	29305,	29302,	29303,	29304,	29309,	29306,	29307,	29308,	310320,	4853,	4856,	4857,	4854,	4855,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,24)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,4879,	29436,	4876,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 5:
		setarray '@mainD,	20954,	20971,	20951,	480009,	480050,	480041,	480026,	20970,	20976,	480022,	20984,	20972,	20983,	480006;		//��14��
		switch(select(
			"��߂�",
			""+getitemname('@mainD[0])+"",
			""+getitemname('@mainD[1])+"",
			""+getitemname('@mainD[2])+"",
			""+getitemname('@mainD[3])+"",
			""+getitemname('@mainD[4])+"",
			""+getitemname('@mainD[5])+"",
			""+getitemname('@mainD[6])+"",
			""+getitemname('@mainD[7])+"",
			""+getitemname('@mainD[8])+"",
			""+getitemname('@mainD[9])+"",
			""+getitemname('@mainD[10])+"",
			""+getitemname('@mainD[11])+"",
			""+getitemname('@mainD[12])+"",
			""+getitemname('@mainD[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* �����ݒ� */
				set '@refD,9;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//��1�X���b�g�͏��310323
				set '@limpos,0;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,1;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainD['@EQ])+" ["+getiteminfo('@mainD['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainD['@EQ]) != 1)		{ mes ""+getitemname('@mainD['@EQ])+"["+getiteminfo('@mainD['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
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
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,29649,	29650,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardD,'@slotD[rand(0,19)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardC,'@slotC[rand(0,11)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,27408,	27409,	27410,	27411,	311066,	311067,	311068,	311065;
					set '@cardB,'@slotB[rand(0,7)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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
		case 6:
		setarray '@mainE,	22216,	22230,	22213,	470014,	470045,	470038,	470032,	22227,	22233,	470024,	22242,	22231,	2400,	470010;		//�C14��
		switch(select(
			"��߂�",
			""+getitemname('@mainE[0])+"",
			""+getitemname('@mainE[1])+"",
			""+getitemname('@mainE[2])+"",
			""+getitemname('@mainE[3])+"",
			""+getitemname('@mainE[4])+"",
			""+getitemname('@mainE[5])+"",
			""+getitemname('@mainE[6])+"",
			""+getitemname('@mainE[7])+"",
			""+getitemname('@mainE[8])+"",
			""+getitemname('@mainE[9])+"",
			""+getitemname('@mainE[10])+"",
			""+getitemname('@mainE[11])+"",
			""+getitemname('@mainE[12])+"",
			""+getitemname('@mainE[13])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;
				case 3: set '@EQ,1;	break;
				case 4: set '@EQ,2;	break;
				case 5: set '@EQ,3;	break;
				case 6: set '@EQ,4;	break;
				case 7: set '@EQ,5;	break;
				case 8: set '@EQ,6;	break;
				case 9: set '@EQ,7;	break;
				case 10: set '@EQ,8;	break;
				case 11: set '@EQ,9;	break;
				case 12: set '@EQ,10;	break;
				case 13: set '@EQ,11;	break;
				case 14: set '@EQ,12;	break;
				case 15: set '@EQ,13;	break;	}

				/* �����ݒ� */
				set '@refD,9;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//��1�X���b�g�͏��310323
				set '@limpos,0;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,1;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainE['@EQ])+" ["+getiteminfo('@mainE['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainE['@EQ]) != 1)		{ mes ""+getitemname('@mainE['@EQ])+"["+getiteminfo('@mainE['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
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
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardD,'@slotD[rand(0,13)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,310193,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardC,'@slotC[rand(0,12)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,29591,	29509,	29371;
					set '@cardB,'@slotB[rand(0,2)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
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

		case 7:
		setarray '@mainF,	460002;		//��1��
		switch(select(
			"��߂�",
			""+getitemname('@mainF[0])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;	}

				/* �����ݒ� */
				set '@refD,9;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,3;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardA,310323;				//��1�X���b�g�͏��310323
				set '@limpos,0;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,1;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainF['@EQ])+" ["+getiteminfo('@mainF['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainF['@EQ]) != 1)		{ mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainF['@EQ])+"["+getiteminfo('@mainF['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4881,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardD,'@slotD[rand(0,13)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29373,	4709,	4739,	4749,	4719,	4729,	4759,	4853,	4854,	4855,	4856,	4857,	4858,	27412;
					set '@cardC,'@slotC[rand(0,13)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,310193,	300229,	310650,	310651,	310648,	310649,	310652;
					set '@cardB,'@slotB[rand(0,6)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainF['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
		case 8:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"��߂�",
			""+getitemname('@mainG[0])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,0;	break;}

				/* �����ݒ� */
				set '@refD,99;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,1;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//��4�X���b�g�͏��310323
				set '@limpos,3;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,0;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g �ł��܂���",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29649,	29650,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	4879,	4876,	29436,	29509,	29371;
					set '@cardC,'@slotC[rand(0,18)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,27402,	27402,	27402,	27402,	27402,	27402,	27402;
					set '@cardB,'@slotB[rand(0,6)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
		case 9:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"��߂�",
			""+getitemname('@mainG[1])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,1;	break;}

				/* �����ݒ� */
				set '@refD,99;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,2;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//��4�X���b�g�͏��310323
				set '@limpos,3;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,0;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g �ł��܂���",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29649,	29650,	29305,	29302,	29303,	29304,	29309,	29306,	29307,	29308,	310320,	4853,	4856,	4857,	4854,	4855,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,24)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,4879,	29436,	4876,	29509,	29371;
					set '@cardB,'@slotB[rand(0,4)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */

		case 10:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"��߂�",
			""+getitemname('@mainG[2])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,2;	break;}

				/* �����ݒ� */
				set '@refD,99;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,5;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//��4�X���b�g�͏��310323
				set '@limpos,3;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,0;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g �ł��܂���",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29649,	29650,	27397,	29214,	29215,	29216,	29217,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	27412;
					set '@cardC,'@slotC[rand(0,19)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,27408,	27409,	27410,	27411,	311066,	311067,	311068,	311065;
					set '@cardB,'@slotB[rand(0,7)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
		case 11:
		//setarray '@mainG,	19347,	15277,	20917,	22187;
		switch(select(
			"��߂�",
			""+getitemname('@mainG[3])+""))	{
				case 1: mes "[" +strnpcinfo(1)+ "]"; mes "�����p���҂����Ă��܂�"; close;
				case 2: set '@EQ,3;	break;}

				/* �����ݒ� */
				set '@refD,99;					//�������� '@slotD ��4�X���b�g ���B�l����
				set '@refC,9;					//�������� '@slotC ��3�X���b�g ���B�l����
				set '@refB,10;					//�������� '@slotB ��2�X���b�g ���B�l����
				set '@refA,99;					//�������� '@slotA ��1�X���b�g ���B�l����
				set '@pos,6;					//����1	����9	����10	�Z2	����3	�E��4	��5	�C6	���A(1)7	�E�A(2)8
				set '@cardD,310323;				//��4�X���b�g�͏��310323
				set '@limpos,3;					//�G���`�����g '@limpos �J�[�h���݂�ݒ�	0 1 2 3
				/* �X���b�g�ʃG���`�����g�� */		//A B C D
				set '@noslotD,0;				//�������� �G���`�����g��:1 ��:0 ��4�X���b�g
				set '@noslotC,1;				//�������� �G���`�����g��:1 ��:0 ��3�X���b�g
				set '@noslotB,1;				//�������� �G���`�����g��:1 ��:0 ��2�X���b�g
				set '@noslotA,0;				//�������� �G���`�����g��:1 ��:0 ��1�X���b�g
				/* �����ݒ� */

				/* �G���`�����g��{���� */
				if(getequipisequiped('@pos) == 0) 		{ mes "�w�蕔�ʂ� "+getitemname('@mainG['@EQ])+" ["+getiteminfo('@mainG['@EQ],10)+"] �𑕔����ĉ�����";	close;	}
				if(equippeditem('@mainG['@EQ]) != 1)		{ mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"]��1�������ĉ�����";	close;	}
				if(getequipcardid('@pos,'@limpos) != 310323) 	{ mes "���z�����Ă܂���B";	close;	}
				/* �G���`�����g��{���� */

				/* �����p���ݒ� */
				set '@ref,getequiprefinerycnt('@pos);	/* ���B�l�������p�� */
				set '@cardD,getequipcardid('@pos,3);	/* �J�[�h�������p���������� */
				set '@cardC,getequipcardid('@pos,2);	/* �J�[�h�������p���������� */
				set '@cardB,getequipcardid('@pos,1);	/* �J�[�h�������p���������� */
				set '@cardA,getequipcardid('@pos,0);	/* �J�[�h�������p���������� */
				/* �����p���ݒ� */

				mes "[" +strnpcinfo(1)+ "]";
				mes ""+getitemname('@mainG['@EQ])+"["+getiteminfo('@mainG['@EQ],10)+"] ";
				mes "�ł��ˁH";
				mes "����ł̓G���`�����g������";
				mes "�X���b�g��I��ŉ������B";
				next;
				switch(select(
					"��߂�",
					"��4�X���b�g�ɃG���`�����g �ł��܂���",
					"��3�X���b�g�ɃG���`�����g",
					"��2�X���b�g�ɃG���`�����g",
					"��1�X���b�g�ɃG���`�����g �ł��܂���")) {
					case 1: mes "[" +strnpcinfo(1)+ "]";	mes "�����p���҂����Ă��܂�";	close;

					case 2: /* ��4�X���b�g�J�n */
					if('@noslotD == 0) {	mes "��4�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refD)		{ mes "���B�l "+'@refD+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotD,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardD,'@slotD[rand(0,6)];
					break; /* ��4�X���b�g�I�� */

					case 3: /* ��3�X���b�g�J�n */
					if('@noslotC == 0) {	mes "��3�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refC)		{ mes "���B�l "+'@refC+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotC,29649,	29650,	310193,	29214,	29215,	29216,	29217,	29218,	29219,	29220,	29221,	29222,	4853,	4854,	4855,	4856,	4857,	4858,	300229,	310650,	310651,	310648,	310649,	310652,	310198,	310203;
					set '@cardC,'@slotC[rand(0,25)];
					break; /* ��3�X���b�g�I�� */

					case 4: /* ��2�X���b�g�J�n */
					if('@noslotB == 0) {	mes "��2�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refB)		{ mes "���B�l "+'@refB+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotB,29591,	29509,	29371;
					set '@cardB,'@slotB[rand(0,2)];
					break; /* ��2�X���b�g�I�� */

					case 5: /* ��1�X���b�g�J�n */
					if('@noslotA == 0) {	mes "��1�X���b�g�ɂ�";	mes "�G���`�����g�ł��܂���B";	close; }
					if(getequiprefinerycnt('@pos) < '@refA)		{ mes "���B�l "+'@refA+" �ȏォ�痘�p�ł��܂�";	close;	}
					setarray '@slotA,4701,	4701,	4701,	4701,	4701,	4701,	4701;
					set '@cardA,'@slotA[rand(0,6)];
					break; /* ��1�X���b�g�I�� */
					}

					/* �A�C�e������J�n */
					delequip '@pos;
					delitem '@costAid,'@costAnum;
					getitem2 '@mainG['@EQ],1,1,'@ref,0,'@cardA,'@cardB,'@cardC,'@cardD,0;
					misceffect 154,"";
					mes "[" +strnpcinfo(1)+ "]";
					mes "OK�A�������܂����B";
					mes "���߂łƂ��������܂��B";
					next;
					mes "[" +strnpcinfo(1)+ "]";
					mes "����ł͂܂��A�����p�������B";
					close;
					/* �A�C�e������I�� */
		}
	case 3:
		mes "["+strnpcinfo(1)+"]";
		mes "�����p���҂����Ă��܂��B";
		close;
	}
}