//20240607 �ėpnpc�쐬�p�̊w�K�X�N���v�g 001
//�G���`�����g�E�A�C�e�������E�������A���_���W�����E�N�G�X�g�֘ANPC��W�������邽�߂̊w�K�X�N���v�g�ł�
//����̊J���҂ɑ��l������Ă���(���E�^�D��Ԃɂ���)NPC��N�ł�70�_���x�̕i���ō���悤�ɂȂ�̂�ڕW�Ƃ��Ă��܂�
//���S�Ȃ��́A�\���⋓���̏ڍׂ܂ł������̂͂ł��Ȃ��̂ŁA�ڕW�ƂȂ铮�����������̂𓞒B�_�ɂ��܂�(20�N�O��NPC�����ɂȂ��ďC������󋵂ł�)
//����X�V�����Ăł��邱�Ƃ𑝂₵�Ă����܂�(�������Ɋw�т܂�)
//�ǂ̊֐��ŉ������Ă���̂����w��ŉ�����

// callfunc "�Ăяo����`","�Ăяo����NPC�Ɏg��"+getarg(0)+",�Ăяo����NPC�Ɏg�������G���[�V����ID,�Ăяo����NPC�Ɏg�����s�G���[�V����
// �v�����e��
prontera.gat,150,150,4	script	�~�~�~�G���`��	554,{
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
prontera.gat,155,150,4	script	�X�e�[�^�X�\��	553,{
	mes "[" +strnpcinfo(1)+ "]";
	mes "�A�C�e�������� : "+countitem(501)+"��";
	mes "�ő及���d�� : "+(MaxWeight/10)+"";
	mes "�������d�� : "+(Weight)/10+"";
	mes "�����c�d�� : "+(MaxWeight - Weight)/10+"";
	mes "�����[�j�[ : "+Zeny+" Zeny";
	mes "BaseLevel : "+BaseLevel+"";
	mes "Str : "+readparam(bStr)+"";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "����i�����̃X�e�[�^�X";
	mes "�A�C�e���� : "+getequipname(1)+"";
	mes "�A�C�e��ID : "+getitemid(getequipname(1))+"";
	mes "���B�� : ["+getequipisenableref(1)+"] 1 : �� 2 : �s��";
	mes "���B�l : +"+getequiprefinerycnt(1)+"";
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
	close;
}
prontera.gat,153,150,4	script	�G���`�����g�e�X�g	70,{
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

prontera.gat,151,150,4	script	�����A�C�e��	70,{
	mes "[" +strnpcinfo(1)+ "]";
//20240604�����A�C�e��
getitem 200409,1;
getitem 200410,1;
getitem 200421,1;
getitem 311906,1;
getitem 313327,1;
getitem 313328,1;
getitem 31975,1;
getitem 400668,1;
getitem 400669,1;
getitem 400670,1;
getitem 410322,1;
getitem 410323,1;
getitem 410324,1;
getitem 410325,1;
getitem 410328,1;
getitem 410340,1;
getitem 410341,1;
getitem 420334,1;
getitem 420335,1;
getitem 420336,1;
getitem 420339,1;
getitem 420340,1;
getitem 420341,1;
getitem 450372,1;
getitem 470278,1;
getitem 480429,1;
getitem 480442,1;
getitem 480443,1;
getitem 480444,1;
getitem 480450,1;
close;
}

//�������牺�̓J�[�h�������������x�[�X�ɏ��������邽�߂̌����p
prt_in.gat,28,73,4	script	�����V��	78,{
	mes "[�����V��]";
	mes "�����V�C���ˁA�Ⴂ�́B";
	mes "�Ƃ���ŁA�A�^�V�͕���ɑ������Ă���";
	mes "�J�[�h�����O���͂������Ă��邯�ǁA";
	mes "�͂�݂������ˁH";
	next;
	switch(select("���肢���܂�","�����炩�����ł����H","�K�v�Ȃ��ł�")) {
	case 3:
		break;
	case 2:
		mes "[�����V��]";
		mes "�������ˁA";
		mes "�܂���{�����Ƃ���^4040FF200000z^000000�B";
		mes "�����ăJ�[�h�P���ɂ�^4040FF25000z^000000�Ⴄ��B";
		mes "���Ƃ́A���@���g�����߂�^4040FF���̂�����^000000��";
		mes "^4040FF�C�G���[�W�F���X�g�[��^000000���P���K�v����B";
		next;
		if(select("���肢���܂�","�K�v�Ȃ��ł�") == 2) {
			break;
		}
		// fall through
	case 1:
		mes "[�����V��]";
		mes "�悵�悵�B";
		mes "�ǂ̕���̃J�[�h�����O���񂾂ˁH";
		next;
		set '@part,select("����ς��߂܂�",
		                  getequipname(1),getequipname(2),getequipname(3),getequipname(4),getequipname(5),
		                  getequipname(6),getequipname(7),getequipname(8),getequipname(9),getequipname(10))-1;
		if('@part == 0)
			break;
		set '@count,getequipcardcnt('@part);
		if('@count <= 0) {
			mes "[�����V��]";
			mes "�Ⴂ�́A�J�[�h�����ĂȂ���B";
			mes "���ꂶ��A�^�V�̏o�Ԃ͂Ȃ����B";
			close;
		}
		mes "[�����V��]";
		mes "���̕���ɂ�" + '@count + "�J�[�h�����Ă�ˁB";
		mes "^0000FF" + ('@count * 25000 + 200000) + "^000000Zeny��^0000FF���̂�����^000000��";
		mes "^0000FF�C�G���[�W�F���X�g�[��^000000���K�v����B";
		next;
		if(select("�킩��܂����A���肢���܂�","����ς��߂܂�") == 2) {
			break;
		}
		mes "[�����V��]";
		mes "�����ƌ����Y���Ƃ��낾�����ˁB";
		mes "���̖��@�͂ƂĂ��������A";
		mes "^FF4040���s���邩������Ȃ�^000000�̂��B";
		mes "���s������J�[�h������A���邢��";
		mes "���̗�����^FF4040�j�󂳂�Ă��܂�^000000����";
		mes "����Ȃ��񂾂�B";
		next;
		mes "[�����V��]";
		mes "���s���Ă�^FF4040�ԋ��͂��Ȃ�^000000����A";
		mes "�ꉞ�����Ēu�����ǁA��ׂ�Ȃ�";
		mes "�J�[�h�ƕ���̂ǂ�������؂����H";
		next;
		set '@failtype,select("����Ȃ��߂܂�","����̕�����؂ł�","�J�[�h�̕�����؂ł�")-1;
		if('@failtype == 0)
			break;
		mes "[�����V��]";
		mes "�悵�A�n�߂��B";
		next;
		if(Zeny < '@count * 25000 + 200000 || countitem(1000) < 1 || countitem(715) < 1) {
			mes "[�����V��]";
			mes "�K�v�ȃA�C�e��������Ȃ��悤���ˁB";
			mes "�A�C�e���𑵂��Ă�����x���ȁB";
			close;
		}
		set Zeny,Zeny - ('@count * 25000 + 200000);
		delitem 1000,1;
		delitem 715,1;
		set '@rate,rand(100);
		if('@rate < 2) {
			failedremovecards '@part,0;
			mes "[�����V��]";
			mes "�c�O�����Ǌ��S�Ɏ��s������B";
			mes "������J�[�h�����Ă��܂����B";
			close;
		}
		if('@rate < 6) {
			failedremovecards '@part,'@failtype;
			if('@failtype == 1) {
				mes "[�����V��]";
				mes "�撣�������ǂˁA";
				mes "�J�[�h�̂ق��͑S�����Ă��܂�����B";
				mes "�ł�����̕��͖�����������B";
			}
			else {
				mes "[�����V��]";
				mes "�s�^�������ˁB";
				mes "�J�[�h�����O���̂͂��܂�����������";
				mes "������Ă��܂�����B";
			}
			close;
		}
		if('@rate < 10) {
			failedremovecards '@part,3;
			mes "[�����V��]";
			mes "�J�[�h�����O���̂Ɏ��s������B";
			mes "�ł��A�s�K���̍K�����B";
			mes "������J�[�h����������B";
			close;
		}
		successremovecards '@part;
		mes "[�����V��]";
		mes "���܂���������B";
		mes "����炪����ƃA�C�e�����B���Ⴀ�ˁB";
		close;
	}
	mes "[�����V��]";
	mes "�킩������B";
	mes "�A�^�V�̗͂��K�v�Ȃ炢�ł����ȁB";
	close;
}