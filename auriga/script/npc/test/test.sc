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

