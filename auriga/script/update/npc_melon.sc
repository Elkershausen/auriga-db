//20240515 �~�~�~�~�b�V�����֘ANPC �A�b�v�f�[�g
//�W���m�[�̖k���ɔz�u
//�~�~�~�~�b�V����NPC �~�b�V�����]����NPC �X�L���X�e�[�^�X���Z�b�gNPC ���̓G���`�����gNPC ���͐��BNPC �]�E�E�]���T�|�[�g��NPC �~�b�V�����]����NPC�̓y��Ƃ��Ď���

yuno.gat,201,325,5	script	���������L	10164,{
	set '@max,100;
	set '@costitem,7347;
	set '@getitemA,23935;
	set '@getitemB,23936;
	mes "[���������L]";
	mes "��������Ⴂ�܂��`�B";
	mes "����������";
	mes "��񋟂��Ă��܂��ɂ�B";
	//�����͓���m�F�p
	mes "����"+getitemname('@costitem)+" "+countitem('@costitem)+"��";
	mes "�����Ώ�A"+getitemname('@getitemA)+"";
	mes "�����Ώ�B"+getitemname('@getitemB)+"";
	//�����܂�
	next;
	mes "[���������L]";
	mes "�u^0000ff����������^000000�v��";
	mes "�u^0000ff�����������̔�^000000�v�ɂ���";
	mes "�������Ă����ɂ�`�B";
	next;
	mes "[���������L]";
	mes "�u�����������̔��v��";
	mes "50����̂��̂�";
	mes "150����̂��̂�����ɂ�B";
	mes "�d�ʂ� 150 �� 450 �ɂ�B";
	next;
	mes "[���������L]";
	mes "�`���҂̊F����";
	mes "�_���W�����̒����ɂ����̂�";
	mes "�����������Ƃ����Ȃ��������";
	mes "������̐l�B��";
	mes "���X���o���Ȃ�������";
	mes "���肢���ꂽ�̂ɂ�B";
	next;
	mes "[���������L]";
	mes "�{���̓j���[�������������̂�����";
	mes "�d���ꂪ���ӂ�����";
	mes "�o�����Ƃɂ����̂ɂ�B";
	mes "�����ł��Ȃ����A�u�����L�^�v��";
	mes "����Ƃ��Ă��������Ă���ɂ��B";
	next;
	mes "[���������L]";
	mes "�u�����������v�̌��ʂ�";
	mes "���̒ʂ�ɂ�`�B";
	next;
	mes "-^0000ff����������^000000-";
	mes "�\�\�\�\�\�\�\�\�\�\�\�\�\";
	mes "HP�ESP��3%�񕜂���";
	mes "�\�\�\�\�\�\�\�\�\�\�\�\�\";
	mes "NPC���p�E�q�ɂւ̈ړ��̂�";
	mes "�\�ł�";
	mes "�\�\�\�\�\�\�\�\�\�\�\�\�\";
	mes "�d�ʁF3";
	next;
	mes "[���������L]";
	mes "�u�����������̔��v��";
	mes "�u�����������v�ɂ�";
	mes "�u^ff0000�ܖ�����^000000�v������ɂ�B";
	mes "�u�q�Ɂv���ł����Ă��������߂����";
	mes "^ff0000���o���Ƃ��ɏ���^000000����ɂ�B";
	mes "�C��t���Ă��傤�����ɂ�`�B";
	next;
	mes "�y�C���t�H���[�V�����z";
	mes "-�u�����������̔��v��";
	mes " ������o�Ă���";
	mes " �u�����������v��";
	mes " �����ԂŎ����I�ɏ��ł��܂�-";
	next;
	mes "[���������L]";
	mes "�����͈ȏ�ɂ�`�B";
	next;
	switch(select("�u�����������v���ق���","�����������̐����𕷂�","�b����߂�")) {
	case 1:
		switch(select(""+getitemname('@getitemA)+"",""+getitemname('@getitemB)+"","����ς��߂�")) {
			case 1:
				mes "[���������L]";
				mes "�u"+getitemname('@getitemA)+"�v��";
				mes "1�Z�b�g�ɂ�";
				mes "�u^0000ff"+getitemname('@costitem)+"^000000�v��3�K�v�ɂ�B";
				mes "��x��100�Z�b�g�܂�";
				mes "�n�����Ƃ��ł���ɂ�B";
				mes "�u0�v�Z�b�g�Ȃ�A����͏I���ɂ���ɂ�B";
				next;
				input '@num;
				set '@Weight,'@num*150;
				set '@Price,'@num*3;
				set '@Gain,'@num;
				if('@num > '@max) {
					mes "[���������L]";
					mes "���H";
					mes "������Ƒ������ł��B";
					close;
				}
				if('@num <= 0) {
					mes "[���������L]";
					mes "�܂��̂����p";
					mes "���҂����Ă��܂��ɂ�`";
					close;
				}
				if(countitem('@costitem) < '@Price) {
					mes "[���������L]";
					mes "^0000ff"+getitemname('@costitem)+"^000000��";
					mes "����Ȃ��ɂ�`";
				close;
				}
				if(((MaxWeight - Weight)/10) <= '@Weight) {
					mes "[���������L]";
					mes "^0000ff"+getitemname('@getitemA)+"^000000��";
 					mes "�d�ʂ̋�" + ('@Weight) + "�K�v�ɂ�`�B";
					mes "�ו��̐��������Ă��痈�Ăɂ�`�B";
					close;
				}
				delitem '@costitem,'@price;
				getitem2 '@getitemA,'@Gain,1,0,0,0,0,0,0,259200;
				mes "[���������L]";
				mes "�܂��̂����p";
				mes "���҂����Ă��܂��ɂ�`";
				close;
			case 2:
				mes "[���������L]";
				mes "�u"+getitemname('@getitemB)+"�v��";
				mes "1�Z�b�g�ɂ�";
				mes "�u^0000ff"+getitemname('@costitem)+"^000000�v��9�K�v�ɂ�B";
				mes "��x��100�Z�b�g�܂�";
				mes "�n�����Ƃ��ł���ɂ�B";
				mes "�u0�v�Z�b�g�Ȃ�A����͏I���ɂ���ɂ�B";
				next;
				input '@num;
				set '@Weight,'@num*150;
				set '@Price,'@num*9;
				set '@Gain,'@num;
				if('@num > '@max) {
					mes "[���������L]";
					mes "���H";
					mes "������Ƒ������ɂ�`�B";
				close;
				}
					if('@num <= 0) {
					mes "[���������L]";
					mes "�܂��̂����p";
					mes "���҂����Ă��܂��ɂ�`";
				close;
				}
				if(countitem('@costitem) < '@Price) {
					mes "[���������L]";
					mes "^0000ff"+getitemname('@costitem)+"^000000��";
					mes "����Ȃ��ɂ�`";
				close;
				}
				if(((MaxWeight - Weight)/10) <= '@Weight) {
					mes "[���������L]";
					mes "^0000ff"+getitemname('@getitemB)+"^000000��";
 					mes "�d�ʂ̋�" + ('@Weight) + "�K�v�ɂ�`�B";
					mes "�ו��̐��������Ă��痈�Ăɂ�`�B";
				close;
				}
				delitem '@costitem,'@price;
				getitem2 '@getitemB,'@Gain,1,0,0,0,0,0,0,259200;
				mes "[���������L]";
				mes "�܂��̂����p";
				mes "���҂����Ă��܂��ɂ�`";
				close;
			case 3:
				mes "[���������L]";
				mes "�܂��̂����p";
				mes "���҂����Ă��܂��ɂ�`";
				close;
			}
	case 2:
		mes "[���������L]";
		mes "�����������̐����𕷂�";
		mes "�H�ׂ�ƌ��C�ɂȂ�";
		mes "�����������ɂ�B";
		mes "�^�_�Ƃ����킯�ɂ�";
		mes "�����Ȃ��̂�����ǂ�";
		mes "�����ɋ��͂��Ă�����";
		mes "�����������ƌ������Ă����܂��ɂ�B";
		next;
		mes "�������C���i�b�v����";
		mes "��"+getitemname('@getitemA)+"";
		mes "�y^ff0000"+getitemname('@costitem)+"^000000�z��";
		mes "3��";
		mes "��"+getitemname('@getitemB)+"";
		mes "�y^ff0000"+getitemname('@costitem)+"^000000�z��";
		mes "9��";
		close;	
	case 3:
		mes "[���������L]";
		mes "�b����߂�";
		mes "�܂��̂����p";
		mes "���҂����Ă��܂��ɂ�`";
		close;
	}
}
//�R��͖�����

//yuno.gat,202,302,4	script	�q��	464,{//npc_signboard.sc�Ɏ���//}
yuno.gat,205,316,4	script	�J�v���E��	112,{
	cutin "kafra_06",2;
	set '@code,8;
	set '@price,1200;
	callfunc "KafraMain",0,0x1ff,"yuno.gat",205,316,"NULL",0,0,40,800,'@code,'@price;
	close2;
	cutin "kafra_05",255;
	end;
}
yuno.gat,214,316,3	script	�����̎��Ît	569,{
	mes "[�����̎��Ît]";
	mes "������HP��SP��";
	mes "�񕜃T�[�r�X�ł��B";
	next;
	mes "[�����̎��Ît]";
	mes "^0000ff���x����99�ȉ�^000000��";
	mes "�v���C���[�͖�����";
	mes "^0000ff100�ȏ��^000000�ꍇ��";
	mes "^ff00005000�[�j�[^000000�����������܂��B";
	mes "�T�[�r�X�𗘗p���܂����H";
	next;
	switch(select("�񕜃T�[�r�X���󂯂�","����ς��߂�")) {
	case 1:
		if(BaseLevel <= 99) {
		mes "[�����̎��Ît]";
		mes "�񕜂��܂��B";
		next;
		mes "[�����̎��Ît]";
		mes "�܂��̂����p";
		mes "���҂����Ă��܂��B";
		misceffect 14,1;
		percentheal 100,100;
		close;
		} else {
			if(Zeny < 5000) {
			mes "[�����̎��Ît]";
			mes "�[�j�[������܂���";
			close;
			}
			mes "[�����̎��Ît]";
			mes "�񕜂��܂��B";
			next;
			mes "[�����̎��Ît]";
			mes "�܂��̂����p";
			mes "���҂����Ă��܂��B";
			set Zeny,Zeny-5000;
			misceffect 14,1;
			percentheal 100,100;
			close;
			}
	case 2:
		mes "[�����̎��Ît]";
		mes "�܂��̂����p";
		mes "���҂����Ă��܂��B";
		close;
	}
}
//�~�~�~�����̕��͐��B�ɉ��C�\��
yuno.gat,197,291,3	script	�z���O����	85,{
	callfunc "Refine1","�z���O����",21,23;
	close;
}
yuno.gat,192,291,4	shop	����l	84,1750,611,501,502,503,504,506,645,656,601,602

//������ƒ�
yuno.gat,205,307,4	script	�R�惌���^��	105,{

	set '@Falcon,2500;
	mes "[�R�惌���^��]";
	mes "�����ł͊e���蕨��";
	mes "�����^�����܂�";
	next;
	switch(select("�t�@���R��","�y�R�y�R�����^��","�E�H�[�O","�����M�A")) {
	
	}
	close;
}
