prontera.gat,1,1,4	script	�����A�C�e���m�F	533,{

	mes "[�����A�C�e���m�F]";
	mes "���Ԃ���m�F���܂����H";
	mes "����Ƃ���Âm�F���܂����H";
	next;
	menu "��C�Ɍ���",L_ITEM0000,"1�Â���",L_ITEM0001;

	mes "[�����A�C�e���m�F]";
	mes "�n�߂܂��B";
	next;
	set '@itemnum,0;
	goto L_ITEM0000;

L_ITEM0000:
	mes "�ԍ�����͂��Ă�������";
	input '@item;
	goto L_ITEM0004;

L_ITEM0004:
	set '@itemnum,'@itemnum+1;
	if ('@itemnum == 101 ) goto L_END;

	getitem '@item,1;
	mes "�A�C�e���ԍ�" + '@item + " " + getitemname('@item) + "";
	set '@item,'@item+1;
	goto L_ITEM0004;

L_ITEM0001:
	mes "�ŏ��̔ԍ������Ă��������B";
	input '@item2;
	goto L_ITEM0002;

L_ITEM0002:
	getitem '@item2,1;
	mes "�A�C�e���ԍ�" + '@item2 + " " + getitemname('@item2) + "";
	mes "���̔ԍ��ɂ��܂����H";
	next;
	menu "���̔ԍ�",L_ITEM0003,"��߂�",L_END;

L_ITEM0003:

	set '@item2,'@item2+1;
	goto L_ITEM0002;

L_END:
	close;
}

prontera.gat,1,1,4	script	�A�C�e�����Z�b�g	533,{
	clearitem;
	gmcommand "@itemreset";
}

prontera.gat,1,1,4	script	�G�t�F�N�g�e�X�g	860,{


	set '@effecter_max,10000;

	mes "[" +strnpcinfo(1)+ "]";
	mes "�G�t�F�N�g�e�X�g���܂��B";
	mes "���l�����Ă��������B";
	mes "0�`10000�܂ł͈̔͂ł��B";
	mes "�ԍ���I��ł�������";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "���Ԃ��猩�n�߂܂����H";
	mes "" +'@effecter_max+ "�Ԃ̎���0�Ԃɖ߂�܂��B";
	input '@effecter_num;
	if('@effecter_num > '@effecter_max ||'@effecter_num < 0){
		mes "[" +strnpcinfo(1)+ "]";
		mes "�͈͊O�ł��B";
		mes "����1�x��蒼���Ă��������B";
		end;
		}
	misceffect '@effecter_num,strcharinfo(0);

	while('@keys == 0){
		if('@effecter_num == 0){
			set '@effecter_num1,'@effecter_num +1;
			set '@effecter_num2,'@effecter_max;
			}
		else if('@effecter_num == '@effecter_max){
			set '@effecter_num1,0;
			set '@effecter_num2,'@effecter_num -1;
			}
		else{
			set '@effecter_num1,'@effecter_num +1;
			set '@effecter_num2,'@effecter_num -1;
			}
	switch(select("���̃G�t�F�N�g�i" +'@effecter_num1+ "�ԁj","�O�̃G�t�F�N�g�i" +'@effecter_num2+ "�ԁj","���̃G�t�F�N�g�i" +'@effecter_num+ "�ԁj","�I��")){
		case 1://���̃G�t�F�N�g
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num1,strcharinfo(0);
			set '@effecter_num,'@effecter_num1;
			continue;

		case 2://�O�̃G�t�F�N�g
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num2,strcharinfo(0);
			set '@effecter_num,'@effecter_num2;
			continue;

		case 3://���̃G�t�F�N�g
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num,strcharinfo(0);
			continue;

		case 4://�I��
			delmisceffect '@effecter_num,strcharinfo(0);
			set '@keys,'@keys +1;
			continue;
		}
	}
	close;
}

prontera.gat,1,1,4	script	HPSP�R�[�}	533,{

	percentheal -99,-99;

}

//--������--
rwc01.gat,47,33,0,0	monster	���ELv1		2510,1,0,0,0
rwc01.gat,45,33,0,0	monster	���ELv1		2511,1,0,0,0
rwc01.gat,43,33,0,0	monster	�n�ELv1		2512,1,0,0,0
rwc01.gat,41,33,0,0	monster	�΁ELv1		2513,1,0,0,0
rwc01.gat,39,33,0,0	monster	���ELv1		2514,1,0,0,0
rwc01.gat,37,33,0,0	monster	�ŁELv1		2515,1,0,0,0
rwc01.gat,35,33,0,0	monster	���ELv1		2516,1,0,0,0
rwc01.gat,33,33,0,0	monster	�ŁELv1		2517,1,0,0,0
rwc01.gat,31,33,0,0	monster	�O�ELv1		2518,1,0,0,0
rwc01.gat,29,33,0,0	monster	�s���ELv1		2519,1,0,0,0

rwc01.gat,47,41,0,0	monster	���Elv4		2520,1,0,0,0
rwc01.gat,45,41,0,0	monster	�n�ELv4		2521,1,0,0,0
rwc01.gat,43,41,0,0	monster	�΁ELv4		2522,1,0,0,0
rwc01.gat,41,41,0,0	monster	���ELv4		2523,1,0,0,0
rwc01.gat,39,41,0,0	monster	�ŁELv4		2524,1,0,0,0
rwc01.gat,37,41,0,0	monster	���ELv4		2525,1,0,0,0
rwc01.gat,35,41,0,0	monster	�ŁELv4		3460,1,0,0,0
rwc01.gat,33,41,0,0	monster	�O�ELv4		3461,1,0,0,0
rwc01.gat,31,41,0,0	monster	�s���ELv4	3462,1,0,0,0