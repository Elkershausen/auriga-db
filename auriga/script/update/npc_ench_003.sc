//20240610 �ėpnpc�쐬�p�̊w�K�X�N���v�g 003

prontera.gat,150,140,4	script	�ߑ�����	10439,{

	set '@getcount,100;
	mes "[" +strnpcinfo(1)+ "]";
	mes "�ߑ��̔ԍ���";
	mes "���͂��ĉ�����";
	mes "��x�ɍő�100�o�܂�";
	next;
	input '@id;
	while('@getcount > 0) {
	if(getiteminfo('@id,13) == 1024 || getiteminfo('@id,13) == 2048 || getiteminfo('@id,13) == 3072 || getiteminfo('@id,13) == 4096 || getiteminfo('@id,13) == 5120 || getiteminfo('@id,13) == 6144 || getiteminfo('@id,13) == 7168 || getiteminfo('@id,13) == 8192) { getitem '@id,1; set '@getcount,'@getcount - 1; } else {  }
	set '@id,'@id + 1;
	}
	mes "�I�����܂�";
	close;
}

prontera.gat,150,130,4	script	�I�ߑ�����	10439,{

	set '@getcount,100;
	mes "[" +strnpcinfo(1)+ "]";
	mes "�ߑ����ʂ�";
	mes "�I��ŉ�����";
	mes "��x�ɍő�100�o�܂�";
		next;
	switch(select(
		"��߂�",
		"�ߑ���i 1024",
		"�ߑ����i 2048",
		"�ߑ����i 4096",
		"�ߑ��㒆�i 3072",
		"�ߑ��㉺�i 5120",
		"�ߑ������i 6144",
		"�ߑ��㒆���i 7168",
		"�ߑ��� 8192",
		"�A�C�e��������")) {

	case 1: mes "[" +strnpcinfo(1)+ "]"; mes "��߂܂���"; close;
	case 2: set '@tmp,1024; break;
	case 3: set '@tmp,2048; break;
	case 4: set '@tmp,4096; break;
	case 5: set '@tmp,3072; break;
	case 6: set '@tmp,5120; break;
	case 7: set '@tmp,6144; break;
	case 8: set '@tmp,7168; break;
	case 9: set '@tmp,8192; break;
	case 10: clearitem; gmcommand "@itemreset"; close;
	}
	input '@id;
	while('@getcount > 0) {
	if(getiteminfo('@id,0) == 6000) { mes "6000�ԂɂȂ����̂Œ��~���܂�"; close; }
	if(getiteminfo('@id,0) == 16000) { mes "16000�ԂɂȂ����̂Œ��~���܂�"; close; }
	if(getiteminfo('@id,0) == 20800) { mes "20800�ԂɂȂ����̂Œ��~���܂�"; close; }
	if(getiteminfo('@id,13) == '@tmp) { getitem '@id,1; set '@getcount,'@getcount - 1; } else {  }
	set '@id,'@id + 1;
	}
	mes "�I�����܂�";
	close;
}

rwc01.gat,48,55,4	script	�G���`���e�X�g4	553,{
	setarray '@main[0],19172,22129,15191,19174,19173;	//��i �C �Z ���i ���i
	mes "[" +strnpcinfo(1)+ "]";
	mes "�I��ŉ�����";
	next;
	set '@i,select(getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
				getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10));
	if(getequipisequiped('@i)==0) {switch('@i) {
		case 1:	mes "(1) ��i�͑������Ă��܂���";	close;
		case 2:	mes "(2) �Z�͑������Ă��܂���";	close;
		case 3:	mes "(3) ���͑������Ă��܂���";	close;
		case 4:	mes "(4) ����͑������Ă��܂���";	close;
		case 5:	mes "(5) �Z�͑������Ă��܂���";	close;
		case 6:	mes "(6) �C�͑������Ă��܂���";	close;
		case 7:	mes "(7) �A�N�Z2�͑������Ă��܂���";	close;
		case 8:	mes "(8) �A�N�Z1�͑������Ă��܂���";	close;
		case 9:	mes "(9) ���i�������Ă��܂���";	close;
		case 10:	mes "(10) ���i�������Ă��܂���";	close;
		}return;}
		if(getequiprefinerycnt(1) < 6) {mes "���B�l6�ȏォ�痘�p�ł��܂�";	close;}
		if(getitemid(getequipname(1)) != '@main[0]) {mes "[" +strnpcinfo(1)+ "]";mes "�G���`���ΏۊO�ł�";close;}
		mes "[" +strnpcinfo(1)+ "]";
		mes "�G���`���Ώۂł�";
		close;
}

// callfunc "�Ăяo����`","�Ăяo����NPC�Ɏg��"+getarg(0)+",�Ăяo����NPC�Ɏg�������G���[�V����ID,�Ăяo����NPC�Ɏg�����s�G���[�V����
// �v�����e��
prontera.gat,166,125,4	script	�~�~�~�G���`��	554,{
	callfunc "mimimiA","prt_ench",21,23;
	close;
}

// �A���x���^
alberta.gat,91,76,4	script	�~�~�~�G���`��	555,{
	callfunc "mimimiA","alb_ench",21,23;
	close;
}

function	script	mimimiA	{
	while(1) {
	mes "["+getarg(0)+"]";
	mes "�ǂ���ɂ��܂����H";
	mes "�I��ŉ�����";
		next;
		switch(select("�I��1","�I��2")) {
		case 1:
			mes "["+getarg(0)+"]";
			mes "�I��1";
			mes "while�ɖ߂�";
			next;
			continue;
		case 2:
			mes "["+getarg(0)+"]";
			mes "�I��2";
			mes "�I������";
		close;
		}
	}
}

//�X�e�[�^�X�\��
prontera.gat,168,125,4	script	�X�e�[�^�X�\��	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "�A�C�e�������� : "+countitem(501)+"��";
	mes "�ő及���d�� : "+(MaxWeight/10)+"";
	mes "�������d�� : "+(Weight)/10+"";
	mes "�����c�d�� : "+(MaxWeight - Weight)/10+"";
	mes "�����[�j�[ : "+Zeny+" Zeny";
	mes "BaseLevel : "+BaseLevel+"";
	cutin "hollgrehenn_01",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "Str : "+readparam(bStr)+"";
	mes "Agi : "+readparam(bAgi)+"";
	mes "Dex : "+readparam(bDex)+"";
	mes "Vit : "+readparam(bVit)+"";
	mes "Int : "+readparam(bInt)+"";
	mes "Luk : "+readparam(bLuk)+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "����i�����̃X�e�[�^�X";
	mes "�A�C�e���� : "+getequipname(1)+"";
	mes "�A�C�e��ID : "+getitemid(getequipname(1))+"";
	mes "���B�� : ["+getequipisenableref(1)+"] 1 : �� 2 : �s��";
	mes "���B�l : +"+getequiprefinerycnt(1)+"";
	cutin "hollgrehenn_01",255;
	cutin "hollgrehenn_02",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+getequipname(1)+" ID : "+getitemid(getequipname(1))+" ";
	mes ""+getequipname(9)+" ID : "+getitemid(getequipname(9))+" ";
	mes ""+getequipname(10)+" ID : "+getitemid(getequipname(10))+" ";
	mes ""+getequipname(2)+" ID : "+getitemid(getequipname(2))+" ";
	mes ""+getequipname(3)+" ID : "+getitemid(getequipname(3))+" ";
	mes ""+getequipname(4)+" ID : "+getitemid(getequipname(4))+" ";
	mes ""+getequipname(5)+" ID : "+getitemid(getequipname(5))+" ";
	mes ""+getequipname(6)+" ID : "+getitemid(getequipname(6))+" ";
	mes ""+getequipname(7)+" ID : "+getitemid(getequipname(7))+" ";
	mes ""+getequipname(8)+" ID : "+getitemid(getequipname(8))+" ";
	mes "�I��";
	cutin "hollgrehenn_02",255;
	cutin "hollgrehenn_03",2;
	close2;
	cutin "hollgrehenn_03",255;
	end;
}
prontera.gat,170,125,4	script	�G���`�����g�e�X�g1	70,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "�Ώۑ�����ID�����";
	next;
	input '@item;
	
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "���B�l��I��";
	next;
	input '@ref;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��1�G���`�����g(��4�X���b�g)��I��";
	next;
	input '@ench4;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��2�G���`�����g(��3�X���b�g)��I��";
	next;
	input '@ench3;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��3�G���`�����g(��2�X���b�g)��I��";
	next;
	input '@ench2;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��4�G���`�����g(��1�X���b�g)��I��";
	next;
	input '@ench1;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@item+" : "+getitemname('@item)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "�������܂���";
	next;
	getitem2 '@item,1,1,'@ref,0,'@ench1,'@ench2,'@ench3,'@ench4,0;
	close;
}

prontera.gat,172,125,4	script	�G���`�����g�e�X�g2	70,{
	setarray '@mainitem[0],400012,22235,20936,20974,20977,20978,20979,32268,32269,400013;
	setarray '@ench1[0],29372,27412,300229,310650;
	mes "[" +strnpcinfo(1)+ "]";
	mes "�Ώۑ�����I�����Ă�������";
	next;
	switch(select(""+getitemname('@mainitem[0])+"",""+getitemname('@mainitem[1])+"",""+getitemname('@mainitem[2])+"",""+getitemname('@mainitem[3])+"",""+getitemname('@mainitem[4])+"",
			""+getitemname('@mainitem[5])+"",""+getitemname('@mainitem[6])+"",""+getitemname('@mainitem[7])+"",""+getitemname('@mainitem[8])+"",""+getitemname('@mainitem[9])+"")) {
	case 1:
		set '@itemid,'@mainitem[0];	//400012
		break;
	case 2:
		set '@itemid,'@mainitem[1];	//22235
		break;
	case 3:
		set '@itemid,'@mainitem[2];	//20396
		break;
	case 4:
		set '@itemid,'@mainitem[3];
		break;
	case 5:
		set '@itemid,'@mainitem[4];
		break;
	case 6:
		set '@itemid,'@mainitem[5];
		break;
	case 7:
		set '@itemid,'@mainitem[6];
		break;
	case 8:
		set '@itemid,'@mainitem[7];
		break;
	case 9:
		set '@itemid,'@mainitem[8];
		break;
	case 10:
		set '@itemid,'@mainitem[9];
		break;
	}
	mes "[" +strnpcinfo(1)+ "]";
	mes "ID : "+ '@itemid +" : "+ getitemname('@itemid) +" ";
	mes " ";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "���B�l��I��";
	next;
	input '@ref;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��1�G���`�����g(��4�X���b�g)��I��";
	next;
	input '@ench4;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��2�G���`�����g(��3�X���b�g)��I��";
	next;
	input '@ench3;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��3�G���`�����g(��2�X���b�g)��I��";
	next;
	input '@ench2;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "��4�G���`�����g(��1�X���b�g)��I��";
	next;
	input '@ench1;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+'@itemid+" : "+getitemname('@itemid)+" ���B�l:+"+'@ref+"";
	mes "��4�X���b�g:"+'@ench4+":"+getitemname('@ench4)+" ";
	mes "��3�X���b�g:"+'@ench3+":"+getitemname('@ench3)+" ";
	mes "��2�X���b�g:"+'@ench2+":"+getitemname('@ench2)+" ";
	mes "��1�X���b�g:"+'@ench1+":"+getitemname('@ench1)+" ";
	mes "�������܂���";
	next;
	getitem2 '@itemid,1,1,'@ref,0,'@ench1,'@ench2,'@ench3,'@ench4,0;
	close;
}

prontera.gat,174,125,4	script	���ԕ\��	553,{

	setarray 'weekday[gettime(4)],"���j��","���j��","�Ηj��","���j��","�ؗj��","���j��","�y�j��";
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+gettime(7)+"�N";
	mes ""+gettime(6)+"��";
	mes ""+gettime(5)+"��";
	mes ""+gettime(5)+" �j�� 0:���j - 6:�y�j";
	mes ""+gettime(3)+"��";
	mes ""+gettime(2)+"��";
	mes ""+gettime(1)+"�b";
	cutin "2020ver_kafra_do01",2;
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes ""+gettime(7)+"�N "+gettime(6)+"�� "+gettime(5)+"�� "+gettime(3)+"�� "+gettime(2)+"�� "+gettime(1)+"�b";
	mes ""+gettimestr("%Y/%m/%d %p %H:%M:%S",100)+"";
	mes "�I��";
	cutin "2020ver_kafra_do01",255;
	cutin "2020ver_kafra_do02",2;
	next;
	cutin "2020ver_kafra_do02",255;
	cutin "2020ver_kafra_do03",2;
	close2;
	cutin "2020ver_kafra_do03",255;
	end;
}

prontera.gat,176,125,4	script	setarray	553,{
	setarray '@testA[0],8,16,32,64,128;
	setarray '@testB[0],4001,4002,4003,4004,4005,4006;
	mes "[" +strnpcinfo(1)+ "]";
	mes "testA �w��̔ԍ���\��";
	mes "setarray : "+'@testA[0]+"";
	mes "setarray : "+'@testA[1]+"";
	mes "setarray : "+'@testA[2]+"";
	mes "setarray : "+'@testA[3]+"";
	mes "setarray : "+'@testA[4]+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "testB �w��̔ԍ��������_������";
	next;
	getitem '@testB[rand(6)],1;
	close;
}

prontera.gat,178,125,4	script	��������	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "�������Ă���A�C�e����";
	mes "�I��ł�������";
	set '@i,select(getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
				getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10));
		switch('@i) {
		case 1:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case1";
			break;
		case 2:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case2";
			break;
		case 3:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 3";
			break;
		case 4:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 4";
			break;
		case 5:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 5";
			break;
		case 6:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 6";
			break;
		case 7:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 7";
			break;
		case 8:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 8";
			break;
		case 9:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 9";
			break;
		case 10:
			mes "[" +strnpcinfo(1)+ "]";
			mes "case 10";
			break;
	}
	close;
}

prontera.gat,156,150,4	script	�����A�C�e��	70,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "����������������������������������������������������������������������������";
	next;
	showdigit 10000,3;
	close;
}
