//2025/05/07 �A�b�v�f�[�g
//�V���b�vNPC�X�V / �o���b�g����NPC�X�V / ���l��NPC�X�V / �X���b�O�e����NPC����
//�V���b�v[�V���o�[�o���b�g][�u���b�h�o���b�g] -> [�V���o�[�o���b�gC][�u���b�h�o���b�gC] �ύX / �V��o���b�g�ǉ�
//npc_job_28gunslinger.sc �㏑��

//= �i�v�t���O ===================================================================
// CHANGE_GS -> 0�`5
//============================================================
// �V���b�v �X�t�B�A�p�~ / �o���b�g�̔��ɕύX 2025/05/07 �A�b�v�f�[�g
//------------------------------------------------------------
que_ng.gat,179,91,3	shop	���폤�l�E�V�o�X	900,13150,13102,13151,13154,13155,13163,13165,13168
que_ng.gat,180,79,3	shop	���폤�l�E�E�B�R	900,13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232
alberta.gat,176,81,3	shop	�f�Տ��l	900,13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232,13150,13102,13151,13154,13155,13163,13165,13168
//============================================================
// �����\��
//------------------------------------------------------------
que_ng.gat,152,167,3	script	�}�X�^�[�~���[	901,{
	if(Job == Job_Gunslinger) {
		mes "[�}�X�^�[�~���[]";
		mes "�v���Ԃ肾�ȁB";
		mes "�e�͑�؂Ɉ����񂾂��B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�������B";
		mes "�K���X�����K�[�ɂȂ����̂Ȃ�A";
		mes "�`���҃A�J�f�~�[��";
		mes "�K��Ă݂�Ƃ����B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "���̌������o��ƁA";
		mes "�`���҃A�J�f�~�[�ŃT�|�[�g��";
		mes "�s���Ă���l�����邾�낤����A";
		mes "�����Ă��炤�Ƃ����B";
		close;
	}
	if(Upper == Upper_BABY) {
		mes "[�}�X�^�[�~���[]";
		mes "�c�c���̂����Ɏq�����c�c";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "���ꂳ��̌��ɋA��Ȃ����B";
		mes "�����͊�Ȃ��B";
		close;
	}
	if(Job != Job_Novice || Upper == Upper_HIGH) {
		mes "[�}�X�^�[�~���[]";
		mes "���Ɩڂ����킹�Ȃ��ł���B";
		mes "�����͂��X����Ȃ��񂾁B";
		close;
	}
	switch(CHANGE_GS) {
	case 0:
		if(getskilllv(1) < 9) {
			mes "[�}�X�^�[�~���[]";
			mes "�ӂށc�c";
			mes "���̖ڂ��m���Ȃ�A";
			mes "�N�͏\���ȉ\�����߂Ă���B";
			mes "�������A����Ȃ����̂�����悤���B";
			next;
			mes "[�}�X�^�[�~���[]";
			mes "JobLv��10�ɂ܂Ő��������A";
			mes "^0000FF�u��{�X�L���v�̃��x����9�@^000000��";
			mes "�����܂��B";
			mes "^0000FF�u��{�X�L���v^000000�̃��x����";
			mes "^0000FF�u�X�L�����X�g�v^000000�E�B���h�E��";
			mes "�グ�邱�Ƃ��ł���B";
			next;
			mes "[�}�X�^�[�~���[]";
			mes "^0000FF�u�X�L�����X�g�v^000000�E�B���h�E��";
			mes "^0000FF�u��{���v^000000�E�B���h�E����";
			mes "^0000FF�uSkill�v^000000�{�^���ŕ\�������B";
			next;
			mes "[�}�X�^�[�~���[]";
			mes "�X�L���̃��x�����グ��ɂ́A";
			mes "�X�L���|�C���g������U������A";
			mes "^FF0000�u�m��v^000000�{�^�����K�v�ƂȂ�B";
			mes "���ӂ���悤�ɁB";
			next;
			mes "[�}�X�^�[�~���[]";
			mes "�X�Ȃ�w�͂��d�ˁA";
			mes "��{�I�ȋZ�p�𖁂�����";
			mes "������x����Ƃ����B";
			close2;
			cutin "start_020_jp.bmp",4;
			end;
		}
		mes "[�}�X�^�[�~���[]";
		mes "���̓Z�����i���삳���";
		mes "�x���C�ł���A";
		mes "�K���X�����K�[�P�������ł�����";
		mes "�}�X�^�[�~���[�B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ꎞ�����ʂɂł��Ȃ����̎���";
		mes "�����|�������R�͉����ˁH";
		next;
		if(select("�ׂɁc�c","�K���X�����K�[�ɂȂ肽���ł�")==1) {
			mes "[�}�X�^�[�~���[]";
			mes "���̋M�d�Ȏ��Ԃ�";
			mes "���ʂɂ�����Ƃ́c�c";
			mes "���������̑O���������B";
			close;
		}
		mes "[�}�X�^�[�~���[]";
		mes "�قق��c�c";
		mes "�܂��c�����A";
		mes "�Ȃ��Ȃ��ǂ��ڂ����Ă���B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ӂށc�c�悩�낤�B";
		mes "�{�C�ŃK���X�����K�[�ɂȂ肽���Ȃ�";
		mes "�܂��ȒP�Ȏ葱�����K�v�B";
		mes "���̌�A�ʐڂƋ��炪����B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "���̊o��͂��邩�ˁH";
		next;
		if(select("�����l���Ă݂܂�","����܂�")==1) {
			mes "[�}�X�^�[�~���[]";
			mes "�ށc�c�������B";
			mes "�����A���̐E�Ƃ�";
			mes "�T�d�Ȏ҂łȂ���΋΂܂��B";
			mes "���S�����Ă���";
			mes "�܂�����Ƃ����B";
			close;
		}
		mes "[�}�X�^�[�~���[]";
		mes "�悩�낤�B";
		mes "�ł́A���̎莆��������";
		mes "�t�F�C�����ɂ���������";
		mes "�t�@���\�v���l��";
		mes "�K�˂Ȃ����B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "���̕����N���A";
		mes "�K���X�����K�[�Ƃ���";
		mes "���������l�ԂȂ̂�";
		mes "���f���Ă�������B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�͂��I�@�킩��܂����B";
		set CHANGE_GS,1;
		setquest 6020;
		close;
	case 1:
		mes "[�}�X�^�[�~���[]";
		mes "�͂₭�s���Ȃ����B";
		mes "�t�@���\�v���l��";
		mes "�t�F�C�����ɂ���������B";
		close;
	case 2:
		mes "[�}�X�^�[�~���[]";
		mes "�t�@���\�v���l��";
		mes "��̍ޗ��ƁH";
		mes "�c�c�c�c";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ǂ����t�@���\�v���l�́A";
		mes "�N�̎����C�ɓ���ꂽ�悤���ȁB";
		close;
	case 3:
		mes "[�}�X�^�[�~���[]";
		mes "���܂ꂲ�Ƃ����ꂽ�̂��H";
		mes "�t�@���\�v���l�ɂ���ۂ�";
		mes "�C�ɓ���ꂽ�炵���ȁB";
		close;
	case 4:
		mes "[�}�X�^�[�~���[]";
		mes "�N�ɂ͊��҂��Ă���B";
		mes "�����t�@���\�v���l�̌���";
		mes "�s���Ƃ����B";
		close;
	case 5:
		mes "[�}�X�^�[�~���[]";
		mes "�t�@���\�v���l����";
		mes "����󂯎���Ă����ȁB";
		mes "�c�c�{���ɋv���Ԃ肾�B";
		mes "���ʂ͂����ȒP�ɂ�";
		mes "��͂��炦�Ȃ��̂����ȁB";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�悵�A�������낤�B";
		mes "�t�@���\�v���l�ɋ����ꂽ�Ȃ�";
		mes "�������ۂ��闝�R�͖����B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ł́A���͌N��";
		mes "�K���X�����K�[�Ƃ��ĔC������B";
		mes "�������̑O�ɁA";
		mes "�K���X�����K�[�ɂ���";
		mes "�d�v�Ȑ��������悤�B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "����Ǝ��e�̍w���́A";
		mes "�e�n�ɂ���K���X�����K�[�M���h��";
		mes "�֌W�҂�ʂ��čs���B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ʓ|���Ƃ͎v�����낤���A";
		mes "���̕�������p����Ȃ����߁A";
		mes "���l�̎�ɓn��Ȃ����߂̏��u���B";
		mes "�������Ă���B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "���ɂ��l�X�ȗ��R������B";
		mes "�����A�����̋K��͑S�āA";
		mes "�������N��������邾�낤�A";
		mes "���̃M���h�̐ӔC�҂ł���";
		mes "�Z�����i����l�̎w�����B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "��������΁A";
		mes "�N�ɗ^������C���ƂƂ���";
		mes "����l�̈ӎv�������ł��邾�낤�B";
		next;
		mes "[�}�X�^�[�~���[]";
		mes "�ł́A���͂��낻��ʂ̗p������̂ŁB";
		mes "��n�̉��삪�N�Ƌ��ɂ���̂��F��A";
		mes "���̕���ƁA";
		mes "�K���X�����K�[�̎w�쏑�ł���";
		mes "�K���X�����K�[�̏����N�Ɏ����悤�B";
		unequip;
		jobchange Job_Gunslinger;
		set CHANGE_GS,0;
		chgquest 6024,50550;
		getitem 11049,1;
		getitem 13100,1;
		getitem 12149,5;
		close;
	}
OnInit:
	waitingroom "�]�E",0;
	end;
}

//============================================================
// �]�E����
//------------------------------------------------------------
payon.gat,184,65,3	script	�t�@���\�v��	866,{
	if(Job == Job_Gunslinger) {
		mes "[�t�@���\�v��]";
		mes "���ށc�c�v���Ԃ肶��́B";
		mes "������b�ɂȂ�̂��Ⴜ�B";
		close;
	}
	switch(CHANGE_GS) {
	case 0:
		mes "[�t�@���\�v��]";
		mes "�����c�c���������c�c";
		close;
	case 1:
		mes "[�t�@���\�v��]";
		mes "�c�c��c�c";
		mes "�c�c�Ⴂ�I�I�J�~�����������c�c";
		mes "���V�ɉ��̗p���ȁH";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�~���[����̏Љ��";
		mes "�����ɗ��܂����B";
		next;
		mes "[�t�@���\�v��]";
		mes "�~���[�c�c";
		mes "�c�c�����A�����ς�";
		mes "�Љ�ŗ����̂��ˁc�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�ނ͂����l���c�c";
		mes "���Ԃ̂��߂Ȃ疽��";
		mes "�����邱�Ƃ��ł���A";
		mes "���`�̐S�������Ă���B";
		next;
		mes "[�t�@���\�v��]";
		mes "�ނ̏Љ�Ȃ�A";
		mes "���̗p����̂킩��c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�����c�c��������";
		mes "�������ɗ��Ȃ����c�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c�c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "��c�c";
		mes "���񂤂�c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�c�c���炩�Ȗڂ�";
		mes "�P�ǂȐS�c�c������";
		mes "�厖�Ȃ��̂���邱�Ƃ��ł���";
		mes "�ӔC���������Ă���c�c";
		mes "�������c�c�c���c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�܂��o�����s�����Ă���c�c";
		mes "�r��Ƒ�n�̏j����";
		mes "�󂯂邱�Ƃ��ł���c�c";
		mes "������A����̑���ƂȂ�";
		mes "��n�̈������Ă�낤�B";
		next;
		mes "[�t�@���\�v��]";
		mes "�ؗ��峂̔�3�A�؋�1�A";
		mes "��������10�A���炩�Ȗ�3��";
		mes "�W�����S��3�A�΃n�[�u3��";
		mes "�������ė���̂��B";
		next;
		mes "[�t�@���\�v��]";
		mes "�����ō������n�̈��";
		mes "�����ςɌ�����΁A";
		mes "����̊肢�͂��Ȃ����낤�B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-�ؗ��峂̔�3�A�؋�1�A";
		mes "��������10�A���炩�Ȗ�3��";
		mes "�W�����S��3�A�΃n�[�u3��";
		mes "�����ɍs����-";
		set CHANGE_GS,2;
		chgquest 6020,6021;
		close;
	case 2:
		if(countitem(1013) < 3 || countitem(1019) < 1 || countitem(935) < 10 || countitem(949) < 3 || countitem(912) < 3 || countitem(511) < 3) {
			mes "[" +strcharinfo(0)+ "]";
			mes "-�ؗ��峂̔�3�A�؋�1�A";
			mes "��������10�A���炩�Ȗ�3��";
			mes "�W�����S��3�A�΃n�[�u3��";
			mes "�����ɍs����-";
			close;
		}
		mes "[�t�@���\�v��]";
		mes "��c�c�悭�����Ă����ȁB";
		mes "������ɂ͂��΂��̎��Ԃ�";
		mes "�K�v����B";
		mes "���΂炭�҂��Ă���B";
		set CHANGE_GS,3;
		chgquest 6021,6022;
		delitem 1013,3;
		delitem 1019,1;
		delitem 935,10;
		delitem 949,3;
		delitem 912,3;
		delitem 511,3;
		close;
	case 3:
		mes "[�t�@���\�v��]";
		mes "��c�c���傤�ǂ����B";
		mes "���A�������ł����Ƃ��낶��B";
		mes "�P���Ȉ�ł͂��邪�c�c";
		mes "�v���Ԃ肶��c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "������n�߂āA";
		mes "�������\�N�ɂȂ邩�c�c";
		mes "���V�ɂ���n�̐�m�Ƃ��āA";
		mes "���̂悤�Ȉ������";
		mes "����������������c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�Z�����i�̕��ɏo������̂�";
		mes "�����̊Ԃ̂悤����c�c";
		mes "�{���Ɂc�c���ԂƂ������";
		mes "��ɐ������̂悤�ɉ߂�����c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�F�X�Ȏ������������c�c";
		mes "���V������Ă����ӎv��";
		mes "�󂯌p���A��؂ɂ��Ă����";
		mes "�Z�����i�ƍ����ρB";
		mes "�����đ����̎�ҒB��";
		mes "���ӂ��Ă���c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "���V�͘V���āA�����͂������B";
		mes "�₪�đ�n�̌���";
		mes "�A���������ł��낤�c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�c�c�ӂ��B";
		mes "�}�ɔ�ꂪ���������B";
		mes "�������A�Ō�Ɉ����";
		mes "���݂�����񂶂Ⴊ�c�c";
		next;
		mes "[�t�@���\�v��]";
		mes "�̂ǂ������Ắc�c";
		mes "�₽���~���N����t���݂����B";
		next;
		mes "[�t�@���\�v��]";
		mes "�����ڂ�̗��݂�";
		mes "�����Ă��炦�񂩂́B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-���ꂳ��̂��߂�";
		mes "�~���N����{�����Ă��悤-";
		set CHANGE_GS,4;
		chgquest 6022,6023;
		close;
	case 4:
		if(countitem(519) < 1) {
			mes "[" +strcharinfo(0)+ "]";
			mes "-���ꂳ��̂��߂�";
			mes "�~���N����{�����Ă��悤-";
			close;
		}
		set CHANGE_GS,5;
		chgquest 6023,6024;
		delitem 519,1;
		mes "[�t�@���\�v��]";
		mes "���肪�Ƃ��B";
		mes "�{���ɐS�����ꂢ�Ȏ�҂���ȁB";
		next;
		mes "[�t�@���\�v��]";
		mes "�ق�B";
		mes "���ꂪ���V�̍�����󂶂�B";
		mes "����������ςɌ������";
		mes "�K���X�����K�[�ɂȂ�邶��낤�B";
		next;
	case 5:
		mes "[�t�@���\�v��]";
		mes "���`�`��`�Ӂ`��`���`";
		mes "����`��`���`�`�`";
		next;
		mes "[" + strcharinfo(0) + "]";
		mes "�]���ꂳ��́A�ˑR";
		mes "�̂��������񂾁]";
		mes "�]�̎��������̂ɁA";
		mes "�Ȃ񂾂��s�v�c�ȋC�����ɂȂ�]";
		next;
		mes "[" + strcharinfo(0) + "]";
		mes "�]�����A�󂯂Ƃ������";
		mes "�~���[����Ɍ����ɍs�����]";
		close;
	}
}

//============================================================
// �e�ۉ��g�j�[ 2025/05/07 �A�b�v�f�[�g
//------------------------------------------------------------
-	script	SphereShop	86,{

	setarray '@itemA[0],1010,1011,6961;
	setarray '@itemB[0],1010,1011,6832;
	setarray '@rate[0],2,20;
	set '@itemC,25187;

//�E�����L������������
//	if(Job != Job_Gunslinger) {
//		mes "["+strnpcinfo(1)+"]";
//		mes "���̓K���X�����K�[�̕���";
//		mes "�X���b�O�e���������Ă���";
//		mes "�g�j�[�ƌ����܂��B";
//		next;
//		mes "[�P�j�[]";
//		mes "���Ȃ��̓K���X�����K�[�ł͂Ȃ��̂�";
//		mes "�e�ۂ������܂���B";
//		mes "�\���󂠂�܂���B";
//		close;
//	}
//�E�����L���������܂�

	mes "["+strnpcinfo(1)+"]";
	mes "���̓K���X�����K�[�̕���";
	mes "�X���b�O�e���������Ă���";
	mes "�g�j�[�ƌ����܂��B";
	next;
	mes "["+strnpcinfo(1)+"]";
	mes "�A�C�e����"+getitemname('@itemC)+"�Ɍ������܂�";
	mes "A�p�^�[��:"+getitemname('@itemA[2])+" 1��";
	mes ""+getitemname('@itemA[0])+" 1�� "+getitemname('@itemA[1])+" 1��";
	mes ""+getitemname('@itemC)+" "+'@rate[0]+"�g 1�Z�b�g";
	mes "B�p�^�[�� : "+getitemname('@itemB[2])+" 1��";
	mes ""+getitemname('@itemB[0])+" 1�� "+getitemname('@itemB[1])+" 1��";
	mes ""+getitemname('@itemC)+" "+'@rate[1]+"�g 1�Z�b�g";
	mes "�ǂ���ɂ��܂����H";
	next;
	switch(select(
		"��߂�",
		"A�p�^�[��",
		"B�p�^�[��")) {
		case 1: mes "["+strnpcinfo(1)+"]"; mes "�K�v�ɂȂ�����";	mes "�܂����Ă��������B";	close;
		case 2: 
			mes "["+strnpcinfo(1)+"]";
			mes ""+'@rate[0]+"�g�����Z�b�g�������邩���͂��ĉ�����";
			mes "�}�C�i�X�l�Ŏ�����~�ł�";
			next;
			input '@count;
			if('@count < 0) {
			mes "["+strnpcinfo(1)+"]"; mes "����𒆎~���܂�";
			close;
			}
			if('@count > countitem('@itemA[0])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[0])+"������܂���"; close; }
			if('@count > countitem('@itemA[1])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[1])+"������܂���"; close; }
			if('@count > countitem('@itemA[2])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[2])+"������܂���"; close; }

			/* �����d�ʔ��� */
			set '@weA,(getiteminfo('@itemC,6) * '@count * '@rate[0]);							//�X���b�O�e�̑��d�� 60 * 2
			set '@weB,((getiteminfo('@itemA[0],6) + getiteminfo('@itemA[1],6) + getiteminfo('@itemA[2],6)) * '@count);	//�������Č��鑍�d�� 70
			if(('@weA - '@weB) > (MaxWeight - Weight)) { mes "["+strnpcinfo(1)+"]"; mes "�����d�ʒ��߂ł�"; close; }

			delitem '@itemA[0],'@count; delitem '@itemA[1],'@count; delitem '@itemA[2],'@count;
			getitem '@itemC,'@count * '@rate[0]; break;
		case 3:
			mes "["+strnpcinfo(1)+"]"; 
			mes ""+'@rate[1]+"�g�����Z�b�g�������邩���͂��ĉ�����";
			mes "�}�C�i�X�l�Ŏ�����~�ł�";
			next;
			input '@count;
			if('@count < 0) { mes "["+strnpcinfo(1)+"]"; mes "����𒆎~���܂�"; close; }
			if('@count > countitem('@itemB[0])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[0])+"������܂���"; close; }
			if('@count > countitem('@itemB[1])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[1])+"������܂���"; close; }
			if('@count > countitem('@itemB[2])) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemB[2])+"������܂���"; close; }

			/* �����d�ʔ��� */
			set '@weC,(getiteminfo('@itemC,6) * '@count * '@rate[1]);
			set '@weD,((getiteminfo('@itemB[0],6) + getiteminfo('@itemB[1],6) + getiteminfo('@itemB[2],6)) * '@count);
			if(('@weC - '@weD) > (MaxWeight - Weight)) { mes "["+strnpcinfo(1)+"]"; mes "�����d�ʒ��߂ł�"; close; }

			delitem '@itemB[0],'@count; delitem '@itemB[1],'@count; delitem '@itemB[2],'@count;
			getitem '@itemC,'@count * '@rate[1]; break;
			}
		mes "["+strnpcinfo(1)+"]";
		mes "�������܂���";
	close;
}

que_ng.gat,187,156,3	duplicate(SphereShop)	�e�ۉ��E�g�j�[	86
izlude.gat,171,133,3	duplicate(SphereShop)	�g�j�[	86
//prontera.gat,153,151,3		duplicate(SphereShop)	�g�j�[	86

//============================================================
// �e�ۃP�[�X���P�j�[ 2025/05/07 �A�b�v�f�[�g
//------------------------------------------------------------
//'@itemid_A == ������o���b�g�P�[�X 1�� '@itemid_B == �������o���b�g �ŏ� 500�� '@num == �����P�[�X�� �ő� 50��

-	script	BulletboxShop	83,{
	setarray '@ammo[0],	13200,13215,13216,13217,13218,13219,13220,13221,13222,13228,13229,13230,13231,13232;
	setarray '@box[0],	12149,22744,22745,22746,22747,22748,22749,22738,22737,23123,23124,23125,23126,23127;
	set '@cost,500;		//�萔��zeny
	set '@max,50;		//������P�[�X�ő���萔
	set '@rate,500;		//�������K�v�o���b�g��(1�P�[�X500��)

//�E�����L������������
//	if(Job != Job_Gunslinger) {
//		mes "["+strnpcinfo(1)+"]";
//		mes "���̓K���X�����K�[�̕���";
//		mes "�e�ۂƒe�ۃP�[�X���������Ă���";
//		mes "�P�j�[�ƌ����܂��B";
//		next;
//		mes "[�P�j�[]";
//		mes "���Ȃ��̓K���X�����K�[�ł͂Ȃ��̂�";
//		mes "�e�ۂ������܂���B";
//		mes "�\���󂠂�܂���B";
//		close;
//	}
//�E�����L���������܂�

	mes "["+strnpcinfo(1)+"]"; mes "���͒e�ۃP�[�X���̃P�j�[�I"; mes "�e�򂪏d���̂Ȃ�"; mes "���񂲗��p���������B";
	next;
	mes "["+strnpcinfo(1)+"]"; mes "����������e�ۃP�[�X��"; mes "�e�ۂ��C�y�Ɏ���������悤��"; mes "�ł���D����̂ł��B";
	next;
	mes "["+strnpcinfo(1)+"]"; mes "�p�~���ꂽ�X�t�B�A�e�ۂ̌��������Ă��܂�";
	mes "�ǂ���𗘗p���܂����H";
	next;
	switch(select(
		"��߂�",
		"�e�ۃP�[�X�����",
		"�X�t�B�A�e�ۂ̌���������")) {
	case 1: mes "["+strnpcinfo(1)+"]"; mes "�K�v�ɂȂ�����";	mes "�܂����Ă��������B";	close;
	case 2: mes "["+strnpcinfo(1)+"]"; mes "�ǂ̒e�ۃP�[�X�����܂����H"; next;
		switch(select(
			"��߂�",
			""+getitemname('@ammo[0])+"500�� -> "+getitemname('@box[0])+"",
			""+getitemname('@ammo[1])+"500�� -> "+getitemname('@box[1])+"",
			""+getitemname('@ammo[2])+"500�� -> "+getitemname('@box[2])+"",
			""+getitemname('@ammo[3])+"500�� -> "+getitemname('@box[3])+"",
			""+getitemname('@ammo[4])+"500�� -> "+getitemname('@box[4])+"",
			""+getitemname('@ammo[5])+"500�� -> "+getitemname('@box[5])+"",
			""+getitemname('@ammo[6])+"500�� -> "+getitemname('@box[6])+"",
			""+getitemname('@ammo[7])+"500�� -> "+getitemname('@box[7])+"",
			""+getitemname('@ammo[8])+"500�� -> "+getitemname('@box[8])+"",
			""+getitemname('@ammo[9])+"500�� -> "+getitemname('@box[9])+"",
			""+getitemname('@ammo[10])+"500�� -> "+getitemname('@box[10])+"",
			""+getitemname('@ammo[11])+"500�� -> "+getitemname('@box[11])+"",
			""+getitemname('@ammo[12])+"500�� -> "+getitemname('@box[12])+"",
			""+getitemname('@ammo[13])+"500�� -> "+getitemname('@box[13])+"")) {
			case 1: mes "["+strnpcinfo(1)+"]"; mes "�K�v�ɂȂ�����";	mes "�܂����Ă��������B";	close;
			case 2:	set '@itemid_B,'@ammo[0];	set '@itemid_A,'@box[0];	break;
			case 3:	set '@itemid_B,'@ammo[1];	set '@itemid_A,'@box[1];	break;
			case 4:	set '@itemid_B,'@ammo[2];	set '@itemid_A,'@box[2];	break;
			case 5:	set '@itemid_B,'@ammo[3];	set '@itemid_A,'@box[3];	break;
			case 6:	set '@itemid_B,'@ammo[4];	set '@itemid_A,'@box[4];	break;
			case 7:	set '@itemid_B,'@ammo[5];	set '@itemid_A,'@box[5];	break;
			case 8:	set '@itemid_B,'@ammo[6];	set '@itemid_A,'@box[6];	break;
			case 9:	set '@itemid_B,'@ammo[7];	set '@itemid_A,'@box[7];	break;
			case 10:	set '@itemid_B,'@ammo[8];	set '@itemid_A,'@box[8];	break;
			case 11:	set '@itemid_B,'@ammo[9];	set '@itemid_A,'@box[9];	break;
			case 12:	set '@itemid_B,'@ammo[10];	set '@itemid_A,'@box[10];	break;
			case 13:	set '@itemid_B,'@ammo[11];	set '@itemid_A,'@box[11];	break;
			case 14:	set '@itemid_B,'@ammo[12];	set '@itemid_A,'@box[12];	break;
			case 15:	set '@itemid_B,'@ammo[13];	set '@itemid_a,'@box[13];	break;	}
			mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemid_A)+"�́A"; mes ""+getitemname('@itemid_B)+""+'@rate+"����"; mes "�萔��"+'@cost+"Zeny��"; mes "1�����ł��܂��B";
			next;
			mes "["+strnpcinfo(1)+"]"; mes "�w�����鐔����͂��Ă��������B"; mes "��x��"+'@max+"�܂Ō����ł��܂��B"; mes "�������~�߂�Ȃ�"; mes "0����͂��Ă��������B";
			next;
			input '@num;

			if('@num <= 0 || '@num > '@max) 		{ mes "["+strnpcinfo(1)+"]"; mes "�����𒆒f���܂����B"; mes "�܂����Ă��������B"; close; }
			if(countitem('@itemid_B) < '@num*'@rate) 	{ mes "["+strnpcinfo(1)+"]"; mes "�A�C�e��������Ȃ��݂����ł���B"; mes "�ΏۃA�C�e�� : "+getitemname('@itemid_B)+""; mes "������ : "+countitem('@itemid_B)+"��"; mes "��x�m�F���Ă݂Ă��������B"; close; }
			if(Zeny < '@cost*'@num)				{ mes "["+strnpcinfo(1)+"]"; mes "����������Ȃ��݂����ł���B"; mes "�萔����" +('@cost*'@num)+ "Zeny�ł��B"; mes "�����[�j�[ : "+Zeny+" Zeny"; mes "��x�m�F���Ă݂Ă��������B"; close; }

			set Zeny,Zeny-'@cost*'@num;
			delitem '@itemid_B,'@num*'@rate;
			getitem '@itemid_A,'@num;

			mes "["+strnpcinfo(1)+"]";
			mes "�K�v��:"+getitemname('@itemid_B)+""+'@num*'@rate+"��";
			mes "�萔��:"+'@cost*'@num+"Zeny";
			mes "�P�[�X:"+getitemname('@itemid_A)+""+'@num+"��";
			mes "��������ł��B";
			mes "�܂������p���������B";
			close;
	case 3:
		setarray '@itemA[0],13201,13202,13203,13204,13205,13206,13207;
		setarray '@itemB[0],13221,13222,13228,13218,13231,13232,13230;
		if(countitem('@itemA[0]) + countitem('@itemA[1]) + countitem('@itemA[2]) + countitem('@itemA[3]) + countitem('@itemA[4]) + countitem('@itemA[5]) + countitem('@itemA[6]) == 0) { mes "[" +strnpcinfo(1)+ "]"; mes "�����Ώۂ̃A�C�e���������Ă��܂���"; close; }
		mes "[" +strnpcinfo(1)+ "]";
		mes "�ȉ��̌����ΏۃA�C�e���������Ă��܂�";
		mes ""+getitemname('@itemA[0])+": "+countitem('@itemA[0])+"��";
		mes ""+getitemname('@itemA[1])+": "+countitem('@itemA[1])+"��";
		mes ""+getitemname('@itemA[2])+": "+countitem('@itemA[2])+"��";
		mes ""+getitemname('@itemA[3])+": "+countitem('@itemA[3])+"��";
		mes ""+getitemname('@itemA[4])+": "+countitem('@itemA[4])+"��";
		mes ""+getitemname('@itemA[5])+": "+countitem('@itemA[5])+"��";
		mes ""+getitemname('@itemA[6])+": "+countitem('@itemA[6])+"��";
		mes "����̐V�K�o���b�g�Ɍ������܂���(�萔���Ȃ�)";
		next;
		switch(select(
		"��߂�",
		""+getitemname('@itemA[0])+" ����������",
		""+getitemname('@itemA[1])+" ����������",
		""+getitemname('@itemA[2])+" ����������",
		""+getitemname('@itemA[3])+" ����������",
		""+getitemname('@itemA[4])+" ����������",
		""+getitemname('@itemA[5])+" ����������",
		""+getitemname('@itemA[6])+" ����������")) {
			case 1:	 mes "["+strnpcinfo(1)+"]"; mes "�K�v�ɂȂ�����";	mes "�܂����Ă��������B";	close;
			case 2:	set '@numA,countitem('@itemA[0]); if('@numA == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[0])+"�������Ă��܂���"; close; } delitem '@itemA[0],'@numA; getitem '@itemB[0],'@numA; break;
			case 3: set '@numB,countitem('@itemA[1]); if('@numB == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[1])+"�������Ă��܂���"; close; } delitem '@itemA[1],'@numB; getitem '@itemB[1],'@numB; break;
			case 4: set '@numC,countitem('@itemA[2]); if('@numC == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[2])+"�������Ă��܂���"; close; } delitem '@itemA[2],'@numC; getitem '@itemB[2],'@numC; break;
			case 5: set '@numD,countitem('@itemA[3]); if('@numD == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[3])+"�������Ă��܂���"; close; } delitem '@itemA[3],'@numD; getitem '@itemB[3],'@numD; break;
			case 6: set '@numE,countitem('@itemA[4]); if('@numE == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[4])+"�������Ă��܂���"; close; } delitem '@itemA[4],'@numE; getitem '@itemB[4],'@numE; break;
			case 7: set '@numF,countitem('@itemA[5]); if('@numF == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[5])+"�������Ă��܂���"; close; } delitem '@itemA[5],'@numF; getitem '@itemB[5],'@numF; break;
			case 8: set '@numG,countitem('@itemA[6]); if('@numG == 0) { mes "["+strnpcinfo(1)+"]"; mes ""+getitemname('@itemA[6])+"�������Ă��܂���"; close; } delitem '@itemA[6],'@numG; getitem '@itemB[6],'@numG; break; }
			mes "[" +strnpcinfo(1)+ "]"; 
			mes "��������ł��B";
			mes "�܂������p���������B";
		close;
	}
}

que_ng.gat,187,149,3	duplicate(BulletboxShop)	�e�ۃP�[�X���E�P�j�[	83
izlude.gat,171,127,3	duplicate(BulletboxShop)	�e�ۃP�[�X���E�P�j�[	83
//prontera.gat,153,151,3	duplicate(BulletboxShop)	�e�ۃP�[�X���E�P�j�[	83


//============================================================
// �K���X������
//- Registry -------------------------------------------------
// GUN_1QUE -> 0�`5
//------------------------------------------------------------
que_ng.gat,182,85,3	script	�K���X��	109,{

	if(Job != Job_Gunslinger) {
		mes "[�K���X��]";
		mes "���Ȃ��̓K���X�����K�[�ł�";
		mes "����܂���ˁB";
		mes "���ɗp�͖����Ǝv���̂ł����H";
		close;
	}
	if(BaseLevel < 55) {
		mes "[�K���X��]";

		mes "���̖��̓K���X���B";
		mes "�����āA���̐��삵���e��";
		mes "���̂悤�Ɋ����Ȃ̂�";
		mes "�������K���X���ƌ����܂��B";
		next;
		mes "[�K���X��]";
		mes "���ɃK���X����";
		mes "����˗������܂����ȁH";
		next;
		mes "[�K���X��]";
		mes "�K���X�������ɂ�";
		mes "�|�S50�A�G���j�E��3�A";
		mes "�I���f�I�R��1�A�ΒY50�A";
		mes "�K�т��l�W20��";
		mes "3��Zeny���K�v�ł��B";
		next;
		callsub L_Routine;
	}
	switch(GUN_1QUE) {
	case 0:
		if(countitem(13104) < 1)
			break;
		mes "[�K���X��]";
		mes "��c�c���q�l�ł����H";
		mes "���킪�����p�ł��傤���H";
		next;
		switch(select("�K���X�����K�v�ł�","�����A�ʂɁc�c","��b����߂�")) {
		case 1:
			break;
		case 2:
			mes "[�K���X��]";
			mes "�ӂށB";
			mes "���ɔC���������悤�ł��ˁB";
			mes "���������Ԃ�����΁A";
			mes "���̂��肢�𕷂��Ă��炦�܂����ȁH";
			next;
			mes "[" +strcharinfo(0)+ "]";
			mes "���ł��傤���H";
			next;
			mes "[�K���X��]";
			mes "�͂��c�c����";
			mes "�ŋߎ������삵�A�̔�����";
			mes "�V�b�N�X�V���[�^�[�Ƃ����e��";
			mes "�s�Ǖi���������Ƃ���";
			mes "�N���[���̎莆���󂯎���Ă��܂��B";
			next;
			mes "[�K���X��]";
			mes "��Ɋ�����ǂ����߂鎄�ł����A";
			mes "���͂̒ቺ�ɔ����A";
			mes "����������s�Ǖi��";
			mes "�����Ă��܂����̂ł��傤�B";
			next;
			mes "[�K���X��]";
			mes "�����ŁA���̕s�Ǖi��";
			mes "��������V�b�N�X�V���[�^�[��";
			mes "�ޗ����W�߂Ă��Ă��炦�܂����ȁH";
			next;
			mes "[�K���X��]";
			mes "�������̗��݂𕷂�����Ă�������΁A";
			mes "���Ȃ��������Ă���K���X����";
			mes "�X���b�g�𑝂₵�Ă��������܂��B";
			next;
			mes "[�K���X��]";
			mes "�Ȃ��B�X���b�g�𑝂₷����";
			mes "���łɑ������Ă���J�[�h�A";
			mes "���B���x�����������Ă��܂��܂��B";
			mes "�ǂ����܂����H";
			next;
			if(select("���ł�","�킩��܂���")==1) {
				mes "[�K���X��]";
				mes "�����ł����B";
				mes "�c�O�ł����A";
				mes "���̐l��T���Ă݂܂��B";
				close;
			}
			mes "[�K���X��]";
			mes "�{���ɂ��肪�Ƃ��������܂��B";
			mes "�ł́A�܂�";
			mes "�V�b�N�X�V���[�^�[�̍ޗ���";
			mes "�W�߂Ă��Ă��������B";
			next;
			mes "[�K���X��]";
			mes "�ޗ��͍|�S10�A";
			mes "�G���j�E��1�A";
			mes "�G���x���^�R��10�A";
			mes "�ΒY30�A�K�т��l�W10�B";
			mes "�ȏ�ł��B";
			mes "�����ԈႦ�Ȃ��ł��������B";
			set GUN_1QUE,1;
			close;
		case 3:
			mes "[�K���X��]";
			mes "�ł́A";
			mes "�܂����z�����������B";
			close;
		}
		break;
	case 1:
		if(countitem(999) < 10 || countitem(985) < 1 || countitem(1011) < 10 || countitem(1003) < 30 || countitem(7317) < 10) {
			mes "[�K���X��]";
			mes "�ޗ��͍|�S10�A";
			mes "�G���j�E��1�A";
			mes "�G���x���^�R��10�A";
			mes "�ΒY30�A�K�т��l�W10�B";
			mes "�ȏ�ł��B";
			mes "�����ԈႦ�Ȃ��ł��������B";
			close;
		}
		mes "[�K���X��]";
		mes "����A���������ł��ˁB";
		mes "�{���ɂ��肪�Ƃ��������܂��B";
		mes "�c�c���k�ł͂���܂����A";
		mes "��������肢������܂��B";
		next;
		mes "[�K���X��]";
		mes "���̍ޗ��ō�����i��";
		mes "�͂��Ȃ���΂Ȃ�܂��񂪁A";
		mes "���͍��d�������܂�ɂ�������";
		mes "�ƂĂ����̏�𗣂���܂���B";
		next;
		mes "[�K���X��]";
		mes "���݂܂��񂪁A";
		mes "���̑���ɔz�B��";
		mes "���Ă��������Ȃ��ł��傤���H";
		next;
		mes "[�K���X��]";
		mes "���Ȃ����s���Ă���ԂɁA";
		mes "�񑩂����K���X����";
		mes "�X���b�g�t���o�[�W������";
		mes "��鏀�������Ă����܂��B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-���[��c�c�ʓ|������";
		mes "����ɔz�B���Ă����悤-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�킩��܂����B";
		mes "�������󂯂��܂��傤�B";
		next;
		mes "[�K���X��]";
		mes "���肪�Ƃ��������܂��B";
		mes "�ł́A���̕i����";
		mes "���q�^���[���̕n���X�ɂ���";
		mes "���x�Ƃ����l�ɓ͂��Ă��������B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-�K���X�����񂩂�";
		mes "�z�B����i���󂯎����-";
		mes "-���q�^���[���̕n���X��";
		mes "���郉�x�Ƃ����l�܂�";
		mes "�͂��ɍs����-";
		set GUN_1QUE,2;
		delitem 999,10;
		delitem 985,1;
		delitem 1011,10;
		delitem 1003,30;
		delitem 7317,10;
		close;
	case 2:
		mes "[" +strcharinfo(0)+ "]";
		mes "-�K���X�����񂩂�";
		mes "�z�B����i���󂯎����-";
		mes "-���q�^���[���̕n���X��";
		mes "���郉�x�Ƃ����l�܂�";
		mes "�͂��ɍs����-";
		close;
	case 3:
		mes "[�K���X��]";
		mes "����H�@�ǂ����Ȃ����܂������H";
		mes "�{���Ă���������悤�ł����H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�ǂ�������������܂���I";
		mes "�E�����Ƃ��낾������ł��I";
		mes "���̒j�A����";
		mes "����₢�Ȃ�P���Ă�����ł��I";
		next;
		mes "[�K���X��]";
		mes "�����c�c�����������Ƃł����c�c";
		mes "���炭���̎莆�́c�c";
		mes "�������ɓG�΂��Ă���҂�";
		mes "�ق����ÎE�҂�㩂ł��傤�B";
		next;
		mes "[�K���X��]";
		mes "���Ȃ��Ɋ֌W����";
		mes "�댯�ȏ󋵂Ɋ������ތ��ʂ�";
		mes "�Ȃ��Ă��܂��܂����B";
		next;
		mes "[�K���X��]";
		mes "�{���ɐ\���󂠂�܂���B";
		mes "���Ȃ��������m�̒ʂ�A";
		mes "�K���X�����K�[�M���h��";
		mes "�Z�����i���m��_�����}";
		mes "�͔ڗ�ȍ���������Ă��܂��B";
		next;
		mes "[�K���X��]";
		mes "�{���ɐ\���󂠂�܂��񂪁A";
		mes "����̎��͂��Ȃ���";
		mes "�C���ɂȂ����Ƃł��v���Ă��������B";
		mes "���Ȃ������ł�";
		mes "�K���X�����K�[�Ȃ̂ł�����B";
		next;
		mes "[�K���X��]";
		mes "�ł́A�񑩂ǂ��肠�Ȃ���";
		mes "�K���X���ɃX���b�g�𑝂₵�܂��傤�B";
		next;
		if(countitem(13104) < 1) {
			mes "[�K���X��]";
			mes "����H";
			mes "�����ƃK���X���������Ă��܂����H";
			mes "���������ł���̂�";
			mes "�X���b�g�̖����K���X�������ł��B";
			set GUN_1QUE,4;
			close;
		}
		mes "[�K���X��]";
		mes "���c�c������Ǝv���܂���";
		mes "^FF0000�J�[�h�𑕒�������A���B����^000000";
		mes "�K���X����^FF0000����^000000���Ă��܂��񂩁H";
		next;
		mes "[�K���X��]";
		mes "�����������Ƃ�����A";
		mes "�J�[�h�����B�l���x����";
		mes "�����Ȃ��Ă��܂��܂��B";
		mes "�O�̂��߁A����ł����̂Ȃ�";
		mes "^FF0000�K���X��^000000�����������Ă��邩";
		mes "�m�F���Ă��������B";
		next;
		if(select("�m�F���Ă���","�m�F�����B�����ɉ�������")==1) {
			mes "[�K���X��]";
			mes "�킩��܂����B";
			mes "�\���Ɋm�F���Ƃ��Ă��������B";
			set GUN_1QUE,4;
			close;
		}
		mes "[�K���X��]";
		mes "�͂��A�����ł��܂����B";
		mes "�ǂ�����؂Ɉ����Ă��������B";
		set GUN_1QUE,5;
		delitem 13104,1;
		getitem 13105,1;
		close;
	case 4:
		if(countitem(13104) < 1) {
			mes "[�K���X��]";
			mes "����H";
			mes "�����ƃK���X���������Ă��܂����H";
			mes "���������ł���̂�";
			mes "�X���b�g�̏��Ȃ��K���X�������ł��B";
			close;
		}
		mes "[�K���X��]";
		mes "���c�c������Ǝv���܂���";
		mes "^FF0000�J�[�h�𑕒�������A���B����^000000";
		mes "�K���X����^FF0000����^000000���Ă��܂��񂩁H";
		next;
		mes "[�K���X��]";
		mes "�����������Ƃ�����A";
		mes "�J�[�h�����B�l���x����";
		mes "�����Ȃ��Ă��܂��܂��B";
		mes "�O�̂��߁A����ł����̂Ȃ�";
		mes "^FF0000�K���X��^000000�����������Ă��邩";
		mes "�m�F���Ă��������B";
		next;
		if(select("�m�F���Ă���","�m�F�����B�����ɉ�������")==1) {
			mes "[�K���X��]";
			mes "�킩��܂����B";
			mes "�\���Ɋm�F���Ƃ��Ă��������B";
			close;
		}
		mes "[�K���X��]";
		mes "�͂��A�����ł��܂����B";
		mes "�ǂ�����؂Ɉ����Ă��������B";
		set GUN_1QUE,5;
		delitem 13104,1;
		getitem 13105,1;
		close;
	case 5:
		mes "[�K���X��]";
		mes "�悤���������ł��������܂����B";
		mes "�����A�l�X�͊F�A�������߂�I";
		mes "���̖�����������A�K���X����";
		mes "�ō��̒��̍ō��I";
		mes "�����ɂ����p�ł����ȁH";
		next;
		switch(select("�K���X��","�K���X���̃X���b�g����","��b����߂�")) {
		case 1:
			mes "[�K���X��]";
			mes "�K���X�������ɂ�";
			mes "�|�S50�A�G���j�E��3�A";
			mes "�I���f�I�R��1�A�ΒY50�A";
			mes "�K�т��l�W20��";
			mes "3��Zeny���K�v�ł��B";
			mes "��낵���ł����ȁH";
			next;
			callsub L_Routine;
		case 2:
			mes "[�K���X��]";
			mes "�K���X���̃X���b�g�����ɂ�";
			mes "�|�S10�A�G���j�E��1�A";
			mes "�G���x���^�R��10�A";
			mes "�ΒY30�A�K�т��l�W10�B";
			mes "�ȏオ�K�v�ł��B";
			mes "��낵���ł����ȁH";
			next;
			switch(select("�܂����x��","���������Ă�������","��߂�")) {
			case 1:
				mes "[�K���X��]";
				mes "�����ł����B";
				mes "�ł́A�ǂ��l���Ă���";
				mes "���Ԏ������������B";
				close;
			}
			if(countitem(13104) < 1 || countitem(999) < 10 || countitem(985) < 1 || countitem(1011) < 10 || countitem(1003) < 30 || countitem(7317) < 10) {
				mes "[�K���X��]";
				mes "�K���X���̃X���b�g�����ɂ�";
				mes "�|�S10�A�G���j�E��1�A";
				mes "�G���x���^�R��10�A";
				mes "�ΒY30�A�K�т��l�W10�B";
				mes "�ȏオ�K�v�ł��B";
				close;
			}
			if(MaxWeight - Weight <= 5000) {
				mes "[�K���X��]";
				mes "�ו�����t�ł��ˁB";
				mes "��x�������Ă���";
				mes "�܂����z�����������B";
				close;
			}
			mes "[�K���X��]";
			mes "���c�c������Ǝv���܂���";
			mes "^FF0000�J�[�h�𑕒�������A���B����^000000";
			mes "�K���X����^FF0000����^000000���Ă��܂��񂩁H";
			next;
			mes "[�K���X��]";
			mes "�����������Ƃ�����A";
			mes "�J�[�h�����B�l���x����";
			mes "�����Ȃ��Ă��܂��܂��B";
			mes "�O�̂��߁A����ł����̂Ȃ�";
			mes "^FF0000�K���X��^000000�����������Ă��邩";
			mes "�m�F���Ă��������B";
			next;
			if(select("�m�F���Ă���","�m�F�����B�����ɉ�������")==1) {
				mes "[�K���X��]";
				mes "�킩��܂����B";
				mes "�\���Ɋm�F���Ƃ��Ă��������B";
				close;
			}
			mes "[�K���X��]";
			mes "�͂��A�����ł��܂����B";
			mes "�ǂ�����؂Ɉ����Ă��������B";
			delitem 999,10;
			delitem 985,1;
			delitem 1011,10;
			delitem 1003,30;
			delitem 7317,10;
			delitem 13104,1;
			getitem 13105,1;
			close;
		case 3:
			mes "[�K���X��]";
			mes "����ł́A�܂�������܂��傤�B";
			close;
		}
	}
	mes "[�K���X��]";
	mes "�n�b�n�b�n�I";
	mes "�悤���������ł��������܂����B";
	mes "�����A�l�X�͊F�A�������߂�I";
	mes "���̖�����������A�K���X����";
	mes "�ō��̒��̍ō��I";
	mes "�����ɂ����p�ł����ȁH";
	next;
	mes "[�K���X��]";
	mes "�K���X�������ɂ�";
	mes "�|�S50�A�G���j�E��3�A";
	mes "�I���f�I�R��1�A�ΒY50�A";
	mes "�K�т��l�W20��";
	mes "3��Zeny���K�v�ł��B";
	mes "��낵���ł����ȁH";
	next;
L_Routine:
	switch(select("�܂����x��","����������Ă�������","��߂�")) {
	case 1:
		mes "[�K���X��]";
		mes "�����ł����B";
		mes "�ł́A�ǂ��l���Ă���";
		mes "���Ԏ������������B";
		close;
	case 2:
		if(countitem(999) < 50 || countitem(985) < 3 || countitem(984) < 1 || countitem(1003) < 50 || countitem(7317) < 20) {
			mes "[�K���X��]";
			mes "�K���X�������ɂ�";
			mes "�|�S50�A�G���j�E��3�A";
			mes "�I���f�I�R��1�A�ΒY50�A";
			mes "�K�т��l�W20��";
			mes "3��Zeny���K�v�ł��B";
			mes "���Y��ɂȂ�Ȃ��悤�B";
			close;
		}
		if(Zeny < 30000) {
			mes "[�K���X��]";
			mes "����������܂���B";
			close;
		}
		if(MaxWeight - Weight <= 5000) {
			mes "[�K���X��]";
			mes "�ו�����t�ł��ˁB";
			mes "��x�������Ă���";
			mes "�܂����z�����������B";
			close;
		}
		mes "[�K���X��]";
		mes "�ł͂ǂ����B";
		mes "�����炪�K���X���ł��B";
		mes "�܂��K�v�ɂȂ�����";
		mes "���z�����������B";
		delitem 999,50;
		delitem 985,3;
		delitem 984,1;
		delitem 1003,50;
		delitem 7317,20;
		set Zeny,Zeny-30000;
		getitem 13104,1;
		close;
	case 3:
		mes "[�K���X��]";
		mes "����ł́A�܂�������܂��傤�B";
		close;
	}
}

lighthalzen.gat,322,247,5	script	���x	86,{
	switch(GUN_1QUE) {
	default:
		mes "[���x]";
		mes "�E�O�O�c�c";
		mes "�O�O�b�c�c�N�E�c�c";
		mes "�c�c�c�c";
		close;
	case 2:
		mes "[" +strcharinfo(0)+ "]";
		mes "����ɂ��́B";
		mes "�K���X�����K�[�M���h����";
		mes "�s�Ǖi�̌��������Ɂc�c";
		next;
		mes "[���x]";
		mes "�k�I�I�I�b!!";
		mes "�N�I�I�I�b!!";
		mes "�Y�I���A�A�b!!";
		set GUN_1QUE,3;
		percentheal -90,0;
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-���x�Ƃ����j��";
		mes "�����Ȃ莄�ɏP���|������-";
		mes "-�K���X�����K�[�Ƃ���";
		mes "���t�ɔ��������悤���c�c-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-�Ƃɂ��������悤-";
		mes "-�����āA�K���X�������";
		mes "�ǂ��������Ƃ������ɍs����-";
		close;
	case 3:
		mes "[" +strcharinfo(0)+ "]";
		mes "-���x�Ƃ����j��";
		mes "�����Ȃ莄�ɏP���|������-";
		mes "-�K���X�����K�[�Ƃ���";
		mes "���t�ɔ��������悤���c�c-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "-�Ƃɂ��������悤-";
		mes "-�����āA�K���X�������";
		mes "�ǂ��������Ƃ������ɍs����-";
		close;
	}
}

//============================================================
// �h���t�^�[�E�u�b�`���[����
//- Registry -------------------------------------------------
// GUN_2QUE -> 0�`9
//------------------------------------------------------------
que_ng.gat,149,178,4	script	����������	744,{
	switch(GUN_2QUE) {
	case 0:
		mes "[�G�C]";
		mes "���A����ɂ��́B";
		mes "���́A�A�C���u���b�N���������ҁA";
		mes "�G�C�Ƃ����܂��B";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			menu "�b��������",-;
			mes "[�G�C]";
			mes "�����A�m�荇����";
			mes "�K���X�����K�[�̐l��������A";
			mes "���镐��Ɋւ����񂪂���̂�";
			mes "�����ɗ���悤�ɂ�";
			mes "�`���Ă��������B";
			close;
		}
		if(BaseLevel < 56) {
			menu "�b��������",-;
			mes "[�G�C]";
			mes "�c�c�A�ˁc�c";
			mes "�����c�c";
			mes "�c�c180�ȏ�c�c";
			next;
			mes "[�G�C]";
			mes "���A���݂܂���B";
			mes "���͕���̌����ŖZ�����̂ŁB";
			close;
		}
		if(BaseLevel >= 68)
			set '@str$,"����u�u�b�`���[�v�ɂ��ĕ���";
		switch(select('@str$,"����u�h���t�^�[�v�ɂ��ĕ���","�b����߂�")) {
		case 1:
			mes "[�G�C]";
			mes "�ǂ����\�𕷂��Ă����悤�ł��ˁB";
			next;
			mes "[�G�C]";
			mes "^FF0000�u�b�`���[^000000��";
			mes "�䂪�A�C���u���b�N��������";
			mes "�S���𒍂��ō��ꂽ";
			mes "�K�g�����O�K���ł��B";
			next;
			mes "[�G�C]";
			mes "^FF0000�h���t�^�[^000000����������ł����A";
			mes "^FF0000�u�b�`���[^000000�̉Η͂�";
			mes "����ȏゾ�Ǝ��M�������Č����܂��I";
			next;
			mes "[�G�C]";
			mes "���܂�ɂ������Η͂̂���";
			mes "�u�s�E�ҁv�Ƃ������ŌĂ΂�Ă܂��B";
			mes "�����ɁA���Ɉ����ɂ���";
			mes "����ł�����܂��B";
			next;
			mes "[�G�C]";
			mes "���̕�����A�ʂ�����";
			mes "���Ȃ����g�����Ȃ���̂ł��傤���H";
			next;
			if(select("�c�c�킩��Ȃ�","�������I")==1) {
				mes "[�G�C]";
				mes "^FF0000�u�b�`���[^000000�͂����";
				mes "�ǂ��������ȑԓx�ň������";
				mes "�Â��㕨�ł͂���܂���B";
				mes "�����Ɏ��M�����Ă�悤�ɂȂ�����";
				mes "�܂����Ă��������B";
				close;
			}
			mes "[�G�C]";
			mes "���M������悤�ł��ˁB";
			mes "�ł��A���M�����Ȃ�";
			mes "�N�ł��ȒP�ɂ��Ă܂��B";
			mes "���Ȃ��̂��̎��M��";
			mes "�����ؖ��ł��Ȃ��ł��傤���H";
			next;
			mes "[�G�C]";
			mes "���[��c�c�c�c";
			next;
			mes "[�G�C]";
			mes "���I";
			mes "�ǂ��l�����v�������т܂����I";
			next;
			mes "[�G�C]";
			mes "^FF0000�I�[�N�̒�1,000��^000000��";
			mes "^FF0000�X�P���{�[��1,000��^000000��";
			mes "�W�߂Ă��Ă��������B";
			mes "�������W�߂Ă��ꂽ��A";
			mes "���Ȃ���^FF0000�u�b�`���[^000000��";
			mes "�����グ�܂��B";
			next;
			mes "[�G�C]";
			mes "�ǂ��ł��H";
			mes "����ʂȂ��낤�Ǝv����";
			mes "�ł��܂���ˁH";
			mes "���Ȃ��̎��͂������Ă��炢�܂��B";
			mes "�t�t�t�c�c";
			set GUN_2QUE,3;
			close;
		case 2:
			mes "[�G�C]";
			mes "�ǂ����^FF0000�h���t�^�[^000000�̘b��";
			mes "�������悤�ł��ˁB";
			next;
			mes "[�G�C]";
			mes "^FF0000�h���t�^�[^000000�̓Z�����i���m��";
			mes "���삵���ō��̕���̈�B";
			mes "��]�d���^�A���e�ł��B";
			mes "���̘A�ˑ��x�́A";
			mes "�K���X�����K�[�������ł���";
			mes "����̒��ōō��Ƃ����܂��B";
			next;
			mes "[�G�C]";
			mes "�������A�K�g�����O��������X�L����";
			mes "�K�v�s���ł����A�K�g�����O��";
			mes "�葫�̂悤�Ɏ��R�Ɉ�����悤�Ȃ�΁A";
			mes "^FF0000�h���t�^�[^000000�͍ō���";
			mes "�p�[�g�i�[�ɂȂ�͂��ł��B";
			next;
			mes "[�G�C]";
			mes "^FF0000�h���t�^�[^000000���g���Ă݂܂����H";
			next;
			if(select("������","�͂�")==1) {
				mes "[�G�C]";
				mes "�g�����肪�ł�����";
				mes "���ł��܂����Ă��������B";
				close;
			}
			mes "[�G�C]";
			mes "^FF0000�h���t�^�[^000000��";
			mes "�ޗ�����ɓ���ɂ����̂ŁA";
			mes "���������\������Ő��삵�Ă��܂��B";
			mes "�ł����A^FF0000�h���t�^�[^000000��";
			mes "�ޗ��������Ă����";
			mes "�����ɂł�����č����グ�܂��B";
			next;
			mes "[�G�C]";
			mes "�ޗ��������̂ł����ƃ�����";
			mes "����Ă��������B";
			next;
			mes "[�G�C]";
			mes "^FF0000�|�S70�A�G���j�E��5�A";
			mes "�I���f�I�R��3�A�ΒY70�A";
			mes "�K�т��l�W50�B^000000";
			mes "�����Đ����p�Ƃ���";
			mes "^FF000050,000Zeny^000000�K�v�ł��B";
			mes "�S���W�܂�����܂����Ă��������B";
			set GUN_2QUE,1;
			close;
		case 3:
			mes "[�G�C]";
			mes "����Ɋւ����񂪂���̂ł����c�c";
			mes "�ǂ����Z�������ł��ˁB";
			mes "�܂����Ă��������B";
			close;
		}
	case 1:
		if(countitem(999) < 70 || countitem(985) < 5 || countitem(984) < 3 || countitem(1003) < 70 || countitem(7317) < 50 || Zeny < 50000) {
			mes "[�G�C]";
			mes "�܂��ޗ����W�܂��ĂȂ��݂����ł��ˁB";
			mes "������x�����܂���B";
			next;
			mes "[�G�C]";
			mes "^FF0000�|�S70�A�G���j�E��5�A";
			mes "�I���f�I�R��3�A�ΒY70�A";
			mes "�K�т��l�W50�B^000000";
			mes "�����Đ����p�Ƃ���";
			mes "^FF000050,000Zeny^000000�K�v�ł��B";
			mes "�S���W�܂�����܂����Ă��������B";
			next;
			mes "[�G�C]";
			mes "�����K�v�Ȃ��悤�ł�����";
			mes "����˗����L�����Z���ł��܂����B";
			mes "�ǂ����܂����H";
			next;
			if(select("�L�����Z�����Ȃ�","�L�����Z������")==1) {
				mes "[�G�C]";
				mes "�ł́A�ޗ����W�܂�����";
				mes "�܂����Ă��������B";
				close;
			}
			mes "[�G�C]";
			mes "����˗����L�����Z�����܂����B";
			mes "�ł́A�y����������B";
			set GUN_2QUE,0;
			close;
		}
		mes "[�G�C]";
		mes "���A�ޗ����W�܂�܂����ˁB";
		mes "�ł́A����ɓ���܂��B";
		mes "���Ԃ�������̂�";
		mes "�����҂��Ă��Ă��������B";
		delitem 999,70;
		delitem 985,5;
		delitem 984,3;
		delitem 1003,70;
		delitem 7317,50;
		set Zeny,Zeny-50000;
		set GUN_2QUE,2;
		close;
	case 2:
		if(MaxWeight - Weight < 2300) {
			mes "-�����A�C�e���̏d�ʂ���������";
			mes "�A�C�e�����󂯂Ƃ邱�Ƃ��ł��܂���-";
			mes "-�����A�C�e�������炵�Ă���A�ēx";
			mes "�b�������Ă�������-";
			close;
		}
		mes "[�G�C]";
		mes "�h���t�^�[���������܂����B";
		set GUN_2QUE,0;
		getitem 13157,1;
		next;
		mes "[�G�C]";
		mes "�K���X�����K�[�̃X�L���A";
		mes "�K�g�����O�t�B�[�o�[��";
		mes "�}�b�h�l�X�L�����Z���[��";
		mes "�ƂĂ����ɗ����܂��B";
		mes "����o���Ă��������B";
		mes "�ł́A�܂�������܂��傤�B";
		close;
	case 3:
		if(countitem(1043) < 1000 || countitem(932) < 1000) {
			mes "[�G�C]";
			mes "^FF0000�I�[�N�̒�1,000��^000000��";
			mes "^FF0000�X�P���{�[��1,000��^000000��";
			mes "�W�߂�܂����H";
			mes "����悤�ł�����";
			mes "���߂Ă��\���܂����H";
			next;
			if(select("������߂Ȃ�","������߂�")==1) {
				mes "[�G�C]";
				mes "�킩��܂����B";
				mes "���Ȃ��̗͂�M���Ă܂��B";
				close;
			}
			mes "[�G�C]";
			mes "���߂�̂ł����H";
			mes "���[��c�c";
			mes "��������ł͂���܂����A";
			mes "������������Ȃ�����";
			mes "���̕�����������͕s�\�ł��B";
			next;
			mes "[�G�C]";
			mes "�����̗͂�M�����悤�ɂȂ�����";
			mes "�܂����Ă��������B";
			set GUN_2QUE,0;
			close;
		}
		mes "[�G�C]";
		mes "���A�ޗ����W�܂�܂����ˁB";
		mes "�����c�c^FF0000�u�b�`���[^000000����������́A";
		mes "������g����l������̂�";
		mes "�S�z�ł������c�c";
		mes "����������܂łł��I";
		delitem 1043,1000;
		delitem 932,1000;
		set GUN_2QUE,4;
		next;
		mes "[�G�C]";
		mes "�ł́A^FF0000�u�b�`���[^000000�̐�����n�߂܂����A";
		mes "�܂��̓Z�����i���m��";
		mes "�u�b�`���[�̐��싖�A�g�p����";
		mes "�����Ȃ��Ă͂Ȃ�܂���B";
		next;
		mes "[�G�C]";
		mes "�g�p���͎��������܂��̂ŁA";
		mes "�u�b�`���[�̐����p��";
		mes "���葱���̎萔���ł���";
		mes "10��Zeny��p�ӂ��Ă����Ă��������B";
		close;
	case 4:
		mes "[�G�C]";
		mes "�Z�����i���m����";
		mes "�u�b�`���[�̎g�p���𒸂��܂����B";
		mes "10��Zeny�𕥂��Ē������";
		mes "�����ɂł��u�b�`���[�������グ�܂��B";
		mes "��낵���ł����H";
		next;
		if(select("������","�͂�")==1) {
			mes "[�G�C]";
			mes "�����̗p�ӂ��ł�����";
			mes "���ł��܂����Ă��������B";
			close;
		}
		if(Zeny < 100000) {
			mes "[�G�C]";
			mes "����������Ȃ��悤�ł��B";
			mes "������x�m�F���Ă݂Ă��������B";
			close;
		}
		if(MaxWeight - Weight < 2500) {
			mes "-�����A�C�e���̏d�ʂ���������";
			mes "�A�C�e�����󂯂Ƃ邱�Ƃ��ł��܂���-";
			mes "-�����A�C�e�������炵�Ă���A�ēx";
			mes "�b�������Ă�������-";
			close;
		}
		mes "[�G�C]";
		mes "1�A2�A�c�c�c�c10�I";
		mes "�m�F���܂����B";
		mes "�ł́A^FF0000�u�b�`���[^000000�������グ�܂��I";
		set Zeny,Zeny-100000;
		set GUN_2QUE,0;
		getitem 13158,1;
		next;
		mes "[�G�C]";
		mes "���q�^���[���ɂ���������";
		mes "F.�w���X�����������";
		mes "���̕���̎����C�ɂ��Ă܂����B";
		mes "���Ԃ����鎞�ɂł�";
		mes "��x��ɍs���Ă݂ĉ������B";
		next;
		mes "[�G�C]";
		mes "����͑�؂Ɏg���Ă��������B";
		mes "�ł́A�܂����������";
		mes "������܂��傤�B";
		close;
	case 6:
		mes "[�G�C]";
		mes "���A����ɂ��́B";
		mes "���́A�A�C���u���b�N���������ҁA";
		mes "�G�C�Ƃ����܂��B";
		mes "�������p�ł����H";
		next;
		menu "����������K�v",-;
		mes "[�G�C]";
		mes "���H�@�c�c���I";
		mes "���������΁A���Ȃ��͈ȑO";
		mes "�u�b�`���[�����Ă������l�ł��ˁH";
		mes "�u�b�`���[�͂�����";
		mes "�g���Ă܂����H";
		next;
		mes "[�G�C]";
		mes "�c�c�c�c���āc�c";
		mes "����������āc�c";
		mes "���A���������āA�u�b�`���[��";
		mes "�󂵂���ł����I";
		next;
		mes "[�G�C]";
		mes "���Ȃ���M���Ă��̂ɁI";
		mes "���̐M���𗠐؂�����ł��ˁI";
		mes "���̂��炬����̂��[�I";
		next;
		menu "������������",-;
		mes "[�G�C]";
		mes "�c�c�����ł����B";
		mes "�w���X���������񂪁c�c";
		mes "�^��������Ă��߂�Ȃ����B";
		next;
		mes "[�G�C]";
		mes "��������̓Z�����i���m��";
		mes "�����Ă�������Ⴂ�܂��B";
		mes "�������A���Z�����i���m��";
		mes "����ŁA�ǂ��ɂ���̂�";
		mes "�킩��܂���B";
		next;
		mes "[�G�C]";
		mes "�����T�����ɂ�";
		mes "���A�V������������";
		mes "���ɂ͂���Ȏ��Ԃ������̂ł��B";
		mes "�����e�ۂ̌�����";
		mes "��񂵂ɂ���킯�ɂ�";
		mes "�����Ȃ��̂Łc�c";
		next;
		menu "���Ă���",-;
		mes "[�G�C]";
		mes "��H�@�Ȃ�ł����H";
		next;
		menu "���݂��ɕK�v�ȕ���T���Ă���",-;
		mes "[�G�C]";
		mes "���[��c�c�����ł���I";
		mes "�ł́A�������������T���̂ŁA";
		mes "���Ȃ��͑����e�ۂ�";
		mes "��ɓ���Ă��Ă��������B";
		next;
		mes "[�G�C]";
		mes "^FF0000�|�C�Y���X�t�B�A�A";
		mes "�t�@�C�A�X�t�B�A�A";
		mes "�E�B���h�X�t�B�A�A";
		mes "�_�[�N�X�t�B�A�A";
		mes "�A�C�X�X�t�B�A^000000�B";
		next;
		mes "[�G�C]";
		mes "����5��ނ̒�����";
		mes "���ނ̑����e�ۂ�";
		mes "30�W�߂Ă��Ă��������B";
		set GUN_2QUE,7;
		close;
	case 7:
		mes "[�G�C]";
		mes "^FF0000�|�C�Y���X�t�B�A30�A";
		mes "�t�@�C�A�X�t�B�A30�A";
		mes "�E�B���h�X�t�B�A30�A";
		mes "�_�[�N�X�t�B�A30�A";
		mes "�A�C�X�X�t�B�A30��^000000�B";
		mes "�ǂꂩ�W�܂�܂������H";
		next;
		switch(select("������","�|�C�Y���X�t�B�A","�t�@�C�A�X�t�B�A","�E�B���h�X�t�B�A","�_�[�N�X�t�B�A","�A�C�X�X�t�B�A")) {
		case 1:
			mes "[�G�C]";
			mes "���ނł��W�܂�����";
			mes "�����Ă��Ă��������B";
			close;
		case 2:
			set '@itemid,13205;
			break;
		case 3:
			set '@itemid,13203;
			break;
		case 4:
			set '@itemid,13204;
			break;
		case 5:
			set '@itemid,13206;
			break;
		case 6:
			set '@itemid,13207;
			break;
		}
		if(countitem('@itemid) < 30) {
			mes "[�G�C]";
			mes "�ǂ��ɂ����ł����H";
			mes "�����Ǝ�ɓ���Ă��Ă��������I";
			close;
		}
		mes "[�G�C]";
		mes "�����Ƃ���܂��ˁB";
		mes "�����Z�����i���m��";
		mes "��������T���Č����Ă����܂����B";
		mes "�ł́A�������܂��傤�B";
		delitem '@itemid,30;
		set GUN_2QUE,8;
		next;
		mes "-�G�C�ɑ����e��n���āA";
		mes "����������󂯎����-";
		next;
		mes "[�G�C]";
		mes "�w���X�����������";
		mes "��p�Ȑl�ł�����A";
		mes "�����ƏC���ł���ł��傤�B";
		mes "�ł͂ł́B";
		close;
	case 8:
	case 9:
		mes "[�G�C]";
		mes "�w���X�����������";
		mes "��p�Ȑl�ł�����A";
		mes "�����ƏC���ł���ł��傤�B";
		mes "�ł͂ł́B";
		close;
	}
}

lighthalzen.gat,205,284,5	script	�w���X��	85,{
	switch(GUN_2QUE) {
	default:
		mes "[�w���X��]";
		mes "���[�c�c�ދ����[";
		mes "�����ʔ������ł��Ȃ����Ȃ��c�c";
		if(GUN_2QUE != 0 || Job != Job_Gunslinger || BaseLevel < 68 || countitem(13158) < 1)
			close;
		next;
		mes "[�w���X��]";
		mes "��H";
		mes "���O�A�K���X�����K�[���H";
		mes "�c�c�ɂ��Ă��c�c";
		mes "���߂Č��镐��������Ă���ȁI";
		next;
		mes "[�w���X��]";
		mes "����A������ƌ����Ă�����Ă������H";
		mes "������Ƃ����ł����񂾁B";
		mes "�ȁH�@�ȁH";
		mes "���ނ�B";
		next;
		if(select("�����Ă����Ȃ�","�u�b�`���[��������")==1) {
			mes "[�w���X��]";
			mes "�ӂ�I";
			mes "�����悢����B";
			mes "���O�������������";
			mes "�����Ă���Ǝv���Ȃ�I";
			mes "���ɂ����āA";
			mes "���̃N�����]���{���g������񂾁I";
			close;
		}
		mes "[�w���X��]";
		mes "�����c�c���ꂪ";
		mes "�A�C���u���b�N���������J�������A";
		mes "�N���g�����Ƃ��ł��Ȃ������Ƃ���";
		mes "�u�s�E�҃u�b�`���[�v���I";
		mes "���΂炵���c�c";
		next;
		mes "[�w���X��]";
		mes "���������g���Ă݂Ă�������!?";
		mes "���v�I";
		mes "���͕���̈����ɂ͊���Ă�񂾁I";
		mes "�S�z�Ȃ����āI�@�ȁI";
		mes "-�S�g���b�I-�@�c�c���B";
		close2;
		delitem 13158,1;
		set GUN_2QUE,5;
		end;
	case 5:
		if(MaxWeight - Weight < 450) {
			mes "-�����A�C�e���̏d�ʂ���������";
			mes "�A�C�e�����󂯂Ƃ邱�Ƃ��ł��܂���-";
			mes "-�����A�C�e�������炵�Ă���A�ēx";
			mes "�b�������Ă�������-";
			close;
		}
		mes "[�w���X��]";
		mes "���c�c���c�c����H";
		next;
		mes "[�w���X��]";
		mes "���c�c���c�c���c�c";
		next;
		menu "���������̂��₢������",-;
		mes "[�w���X��]";
		mes "��!?";
		mes "���c�c����c�c���́c�c";
		next;
		mes "[�w���X��]";
		mes "���c�c���ꂪ�ł��ˁc�c";
		mes "�A�c�c�A�n�c�c";
		mes "�A�n�n�n�n�n�n�n�`";
		next;
		mes "[�w���X��]";
		mes "�����ˁc�c�A�n�n�c�c";
		next;
		mes "[�w���X��]";
		mes "����ˁc�c�n�n�c�c�n�c�c";
		next;
		mes "[�w���X��]";
		mes "�Y�_�_�_�_�I";
		mes "���Č��Ƃ��Ƃ����񂾁B";
		mes "�c�c�����Ȃ񂾂�I";
		next;
		mes "[�w���X��]";
		mes "�ł��A�ӊO�Ƃ��ꂪ�d���ĂȁI";
		mes "���������艴�̑@�ׂȎ肪�ȁc�c";
		mes "�A�n�c�c�A�n�n�n�n�b�I";
		next;
		mes "[�w���X��]";
		mes "�c�c�c�c�c�c";
		mes "�c�c���߂�Ȃ����B";
		mes "�󂵂��Ⴂ�܂����B";
		next;
		mes "[�w���X��]";
		mes "���A����I�@���v�I";
		mes "���͂��������āA���͂Ȃ�ł����I";
		mes "���̂����ǁc�c";
		mes "����I�@���Ⴂ����Ȃ�I";
		mes "���ꂮ�炢�������͂ł���I";
		next;
		mes "[�w���X��]";
		mes "�ł��A�C���ɕK�v�ȍޗ��͖������c�c";
		mes "���߂Č���悤�ȕ��i�������āc�c";
		next;
		mes "[�w���X��]";
		mes "�����󂵂Ă����ĉ������ǁc�c";
		mes "�C���ɕK�v�ȍޗ���";
		mes "�W�߂Ă��Ă���Ȃ����H";
		mes "�ޗ����������";
		mes "�����ɒ����Č����邩��I";
		next;
		mes "[�w���X��]";
		mes "����A����ǂ��납";
		mes "�X�y�V���������܂�";
		mes "�����Ⴄ��I�@������ȁI";
		next;
		mes "[�w���X��]";
		mes "�K�v�ȍޗ���^FF0000�|�S10�A";
		mes "�G���j�E��2�A�I���f�I�R��1�A";
		mes "�ΒY20��^000000���B";
		next;
		mes "[�w���X��]";
		mes "�����āA�u�b�`���[��p��";
		mes "^FF0000�������^000000���K�v���B";
		mes "���炭�A���̋�����";
		mes "�Z�����i���m�������Ȃ����낤�B";
		next;
		mes "[�w���X��]";
		mes "�܂��A�Z�����i���m�̏���ł���";
		mes "�u�G�C�v�ɗ���ł݂Ă���B";
		mes "������ƃq�X�e���b�N�Ȏq�����A";
		mes "�b���΂킩���Ă����c�c�����c�c";
		next;
		mes "[�w���X��]";
		mes "����ł������Ǝv���Ă�񂾁B";
		mes "�Ƃ肠�����A�����厖�ɂ��Ă�";
		mes "�u�N�����]���{���g�v�����ɑ݂���";
		mes "�C���ł����炿���ƕԂ��Ă����H";
		mes "�ȁH�@�ȁH";
		close2;
		set GUN_2QUE,6;
		getitem 13102,1;
		end;
	case 6:
	case 7:
		mes "[�w���X��]";
		mes "�K�v�ȍޗ���^FF0000�|�S10�A";
		mes "�G���j�E��2�A�I���f�I�R��1�A";
		mes "�ΒY20��^000000���B";
		next;
		mes "[�w���X��]";
		mes "�����āA�u�b�`���[��p��";
		mes "^FF0000�������^000000���K�v���B";
		mes "���̋����́u�G�C�v�ɗ��߂�";
		mes "��ɓ���c�c�����c�c";
		close;
	case 8:
		if(countitem(999) < 10 || countitem(985) < 2 || countitem(984) < 1 || countitem(1003) < 20) {
			mes "[�w���X��]";
			mes "�K�v�ȍޗ���^FF0000�|�S10�A";
			mes "�G���j�E��2�A�I���f�I�R��1�A";
			mes "�ΒY20��^000000���B";
			next;
			mes "[�w���X��]";
			mes "�����āA�u�b�`���[��p��";
			mes "^FF0000�������^000000���K�v�����A";
			mes "����͎�ɓ������悤���ȁB";
			close;
		}
		mes "[�w���X��]";
		mes "���A�ޗ����W�߂Ă����ȁI";
		if(countitem(13102) < 1) {
			mes "�Ƃ���ŁA�u�N�����]���{���g�v��";
			mes "�ǂ��ɂ���񂾁H";
			mes "�c�c�c�c�c�c";
			mes "���ނ���Ԃ��Ă���c�c";
			close;
		}
		mes "���ꂶ�Ⴀ�A�C�����n�߂邩��";
		mes "�����̊Ԃ����҂��ĂĂ���B";
		delitem 999,10;
		delitem 985,2;
		delitem 984,1;
		delitem 1003,20;
		delitem 13102,1;
		set GUN_2QUE,9;
		close;
	case 9:
		if(MaxWeight - Weight < 2500) {
			mes "-�����A�C�e���̏d�ʂ���������";
			mes "�A�C�e�����󂯂Ƃ邱�Ƃ��ł��܂���-";
			mes "-�����A�C�e�������炵�Ă���A�ēx";
			mes "�b�������Ă�������-";
			close;
		}
		mes "[�w���X��]";
		mes "�ӂ��c�c�Ȃ�Ƃ������C���ł����B";
		mes "�{���ɂ��܂Ȃ������B";
		mes "����ƌ����Ă͂Ȃ񂾂��A";
		mes "�u�b�`���[�̋@�\���������Ă������B";
		mes "��؂Ɏg���Ă���B";
		set GUN_2QUE,0;
		getitem 13159,1;
		close;
	}
}

//============================================================
// �f�X�g���C���[����
//- Registry -------------------------------------------------
// GUN_3QUE -> 0�`2
//------------------------------------------------------------
que_ng.gat,185,180,3	script	�x�l�b�T	726,{
	switch(GUN_3QUE) {
	case 0:
		mes "[�x�l�b�T]";
		mes "�́I�@���₟�I";
		mes "�����I�@�Ƃ�႟�I";
		mes "�����K��";
		mes "���E���̊i���Z��";
		mes "�S���}�X�^�[���邼�I";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			mes "[�x�l�b�T]";
			mes "��H�@���H";
			mes "���K�̎ז��ɂȂ邩��";
			mes "�������s���Ă����H";
			close;
		}
		mes "[�x�l�b�T]";
		mes "��H";
		mes "���񂽃K���X�����K�[���ˁH";
		mes "���K�̎ז��ɂȂ�񂾂��ǁB";
		mes "�����p�Ȃ́H";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����A���K�����Ă��܂����B";
		mes "�������������悩��������c�c";
		next;
		mes "[�x�l�b�T]";
		mes "���I";
		mes "���񂽊i���Z���D���Ȃ́H";
		mes "�Ȃ炱�����֗��Ȃ�B";
		mes "�����Z�������Ă���B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c���H";
		mes "���A����A";
		mes "���C�ɂȂ��炸�ɁB";
		next;
		mes "[�x�l�b�T]";
		mes "���v�A���v�B";
		mes "�ق�I";
		mes "-�V���I�@�V���I-";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�����A�������ɗ��Ȃ��ł��������I";
		mes "��c�c���킟�I";
		mes "-�V���b�V���I-";
		mes "-�Ԃ�I�@�Ԃ���I-";
		next;
		mes "[�x�l�b�T]";
		mes "���Ŕ�����̂�I";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "������O����Ȃ��ł����I";
		mes "��Ȃ��ł��傤���I";
		next;
		mes "[�x�l�b�T]";
		mes "�����B";
		mes "���ꂮ�炢��";
		mes "�тт�Ȃ��ł�B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�킩���Ă����ł����I";
		mes "����������P�K�������ł���I";
		next;
		mes "[�x�l�b�T]";
		mes "�͂��͂��A�����ˁ[";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "��̂����Ȃ�c�c�c�c";
		next;
		mes "[�x�l�b�T]";
		mes "�V�����b�v�I";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c�c�c�c�c";
		next;
		mes "[�x�l�b�T]";
		mes "�͂��B";
		mes "�m���ɂ�肷������ˁB";
		mes "�ꉞ���Ȃ��Ă�̂�B";
		mes "������A���ʂɂ��񂽂̂��߂�";
		mes "���������Ă�������B";
		next;
		mes "[�x�l�b�T]";
		mes "���̓x�l�b�T�E���C�X�B";
		mes "���X�͊i���u�]���������񂾂��ǁA";
		mes "���͂����ŕ��������Ă����B";
		mes "�܁A�������������Ă��Ƃ�B";
		next;
		mes "[�x�l�b�T]";
		mes "�������镐���";
		mes "�f�X�g���C���[�B";
		next;
		mes "[�x�l�b�T]";
		mes "�����i���Z�̑��ɏo�鎞��";
		mes "�g�����O��t���������B";
		mes "�ӂӂӁc�c";
		mes "�f�X�g���C���[�I";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�킠�I";
		mes "������߂Ă����������āI";
		next;
		mes "[�x�l�b�T]";
		mes "�킩���Ă�A�킩���Ă���āB";
		mes "���[";
		mes "�ꉞ�A�f�X�g���C���[�����ɂ�";
		mes "�ޗ����K�v��B";
		next;
		mes "[�x�l�b�T]";
		mes "�ǂ��H";
		mes "����ȋ@��͂��������Ȃ����B";
		mes "����Ă݂�H";
		next;
		if(select("�܂��ɂ��܂�","���肢���܂�")==1) {
			mes "[�x�l�b�T]";
			mes "�����A�c�O�B";
			mes "���񂽂ɂ͗ǂ��@������̂ɁB";
			mes "��Ō�����Ă��m��Ȃ���B";
			mes "����A�΂��΁`���B";
			close;
		}
		mes "[�x�l�b�T]";
		mes "�I�b�P�[�B";
		mes "�f�X�g���C���[�����ɂ�";
		mes "�Â��S��50�A";
		mes "�I���f�I�R��5�A";
		mes "�K�т��l�W70�A";
		mes "�萔����10��Zeny���K�v��B";
		set GUN_3QUE,1;
		close;
	case 1:
		if(countitem(7319) < 50 || countitem(984) < 5 || countitem(7317) < 70) {
			mes "[�x�l�b�T]";
			mes "�f�X�g���C���[�����ɂ�";
			mes "�Â��S��50�A";
			mes "�I���f�I�R��5�A";
			mes "�K�т��l�W70�A";
			mes "�萔����10��Zeny���K�v��B";
			close;
		}
		if(Zeny < 100000) {
			mes "[�x�l�b�T]";
			mes "�ޗ��͏\�������ǁA";
			mes "�萔����10��Zeny������Ȃ����B";
			close;
		}
		if(MaxWeight - Weight <= 1200) {
			mes "[�x�l�b�T]";
			mes "�ו��������ς�����Ȃ��B";
			mes "������Ɛ������Ă��Ă�B";
			close;
		}
		mes "[�x�l�b�T]";
		mes "�I�b�P�[";
		mes "�S��������Ă��ˁB";
		mes "����A���炩���ߍ���Ă�����";
		mes "�f�X�g���C���[��";
		mes "�������Ă�����B";
		delitem 7319,50;
		delitem 984,5;
		delitem 7317,70;
		set GUN_3QUE,2;
		getitem 13160,1;
		next;
		mes "[�x�l�b�T]";
		mes "�����A�܂��K�v�ɂȂ�����";
		mes "���ł����ĂˁB";
		mes "���͑��̊i���p��";
		mes "�����Ă��E���E��B";
		close;
	case 2:
		mes "[�x�l�b�T]";
		mes "���A�܂�������ˁH";
		mes "���C���Ă�H";
		mes "���������A�V�������킪�ł����́B";
		mes "�悩������";
		mes "����Ă�������B";
		next;
		switch(select("�f�X�g���C���[","�X���b�g�t���f�X�g���C���[","��߂Ă���")) {
		case 1:
			mes "[�x�l�b�T]";
			mes "�I�b�P�[�B";
			mes "�f�X�g���C���[�����ɂ�";
			mes "�Â��S��50�A�K�т��l�W70�A";
			mes "�I���f�I�R��5�A";
			mes "�萔����10��Zeny���K�v��B";
			mes "����Ă݂�H";
			next;
			if(select("������ƍl���Ă݂܂�","���肢���܂�")==1) {
				mes "[�x�l�b�T]";
				mes "���A�����B";
				mes "���ꂶ�Ⴀ�������";
				mes "�l���Ă݂Ă�B";
				close;
			}
			if(countitem(7319) < 50 || countitem(984) < 5 || countitem(7317) < 70) {
				mes "[�x�l�b�T]";
				mes "�f�X�g���C���[�����ɂ�";
				mes "�Â��S��50�A";
				mes "�I���f�I�R��5�A";
				mes "�K�т��l�W70�A";
				mes "�萔����10��Zeny���K�v��B";
				close;
			}
			if(Zeny < 100000) {
				mes "[�x�l�b�T]";
				mes "�ޗ��͏\�������ǁA";
				mes "�萔����10��Zeny������Ȃ����B";
				close;
			}
			if(MaxWeight - Weight <= 1200) {
				mes "[�x�l�b�T]";
				mes "�ו��������ς�����Ȃ��B";
				mes "������Ɛ������Ă��Ă�B";
				close;
			}
			mes "[�x�l�b�T]";
			mes "�I�b�P�[";
			mes "�S��������Ă��ˁB";
			mes "����A���炩���ߍ���Ă�����";
			mes "�f�X�g���C���[��";
			mes "�������Ă�����B";
			delitem 7319,50;
			delitem 984,5;
			delitem 7317,70;
			getitem 13160,1;
			next;
			mes "[�x�l�b�T]";
			mes "�����A�܂��K�v�ɂȂ�����";
			mes "���ł����ĂˁB";
			mes "���͑��̊i���p��";
			mes "�����Ă��E���E��B";
			close;
		case 2:
			mes "[�x�l�b�T]";
			mes "�I�b�P�[";
			mes "�X���b�g�t���̃f�X�g���C���[��";
			mes "�����l�I�ɏW�߂Ă���";
			mes "�̂������Ă����";
			mes "�������Ă������B";
			next;
			mes "[�x�l�b�T]";
			mes "��������̂�";
			mes "2�X���b�g����t�B���K�[1�A";
			mes "�I���f�I�R��5�B";
			mes "����Ă݂�H";
			next;
			if(select("������ƍl���Ă݂܂�","���肢���܂�")==1) {
				mes "[�x�l�b�T]";
				mes "���A�����B";
				mes "���ꂶ�Ⴀ�������";
				mes "�l���Ă݂Ă�B";
				close;
			}
			if(countitem(1812) < 1 || countitem(984) < 5) {
				mes "[�x�l�b�T]";
				mes "��������̂�";
				mes "2�X���b�g����t�B���K�[1�A";
				mes "�I���f�I�R��5��B";
				close;
			}
			if(MaxWeight - Weight <= 1200) {
				mes "[�x�l�b�T]";
				mes "�ו��������ς�����Ȃ��B";
				mes "������Ɛ������Ă��Ă�B";
				close;
			}
			mes "[�x�l�b�T]";
			mes "�I�b�P�[";
			mes "�S��������Ă��ˁB";
			mes "����A���炩���ߍ���Ă�����";
			mes "�X���b�g�t���̃f�X�g���C���[��";
			mes "�������Ă�����B";
			delitem 1812,1;
			delitem 984,5;
			getitem 13161,1;
			next;
			mes "[�x�l�b�T]";
			mes "�����A�܂��K�v�ɂȂ�����";
			mes "���ł����ĂˁB";
			mes "���͑��̊i���p��";
			mes "�����Ă��E���E��B";
			close;
		case 3:
			mes "[�x�l�b�T]";
			mes "���A�����B";
			mes "���ꂶ�Ⴀ�������";
			mes "���Ă����Ă�B";
			mes "����Ƃ��A";
			mes "���ƃX�p�[�����O�ł�����H";
			close;
		}
	}
}

//============================================================
// �C���t�F���m����
//- Registry -------------------------------------------------
// GUN_4QUE -> 0�`5
//------------------------------------------------------------
que_ng.gat,187,163,3	script	�C���O���b�h	744,{
	switch(GUN_4QUE) {
	case 0:
		mes "[�C���O���b�h]";
		mes "����ɂ��́I";
		mes "����̐����S�����Ă���";
		mes "�C���O���b�h�ƌ����܂��B";
		mes "��낵�����肢���܂��B";
		next;
		if(getbaseclass(Class) != CLASS_GS) {
			mes "[�C���O���b�h]";
			mes "�ł��A�c�O�Ȃ���";
			mes "�������삷�镐���";
			mes "�K���X�����K�[��p�ł��B";
			next;
			mes "[�C���O���b�h]";
			mes "���q�l��";
			mes "�K���X�����K�[�M���h��";
			mes "�������Ă��Ȃ��̂ŁA";
			mes "���̕�����g�����Ƃ͂ł��܂���B";
			mes "�\���󂠂�܂���B";
			close;
		}
		mes "[�C���O���b�h]";
		mes "�܂��d�����n�߂��΂���ł����A";
		mes "�ꐶ��������΂�܂��I";
		next;
		mes "[�C���O���b�h]";
		mes "�����c�c�ǂ��ǂ����܂��B";
		mes "���͂��q�l�̂��߂�";
		mes "�C���t�F���m�Ƃ��������";
		mes "����Ă��܂��B";
		next;
		mes "[�C���O���b�h]";
		mes "�C���t�F���m��";
		mes "�K���X�����K�[�M���h�̌�������";
		mes "�J�����ꂽ����̒��ł��A";
		mes "�ō��̈�i�ł��B";
		next;
		mes "[�C���O���b�h]";
		mes "�����j��͂�����Ȃ���A";
		mes "�l�̍H�w�I�݌v���l���A";
		mes "��Ɏ��������̈��萫�B";
		mes "���C�̔������ŏ����ɂ���";
		mes "�f���炵������ł��I";
		mes "�ӂӂӂӂӂӁc�c";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c�ڂ�����ł��ˁB";
		next;
		mes "[�C���O���b�h]";
		mes "���R�ł��I";
		mes "���̕���͎����݌v";
		mes "������ł�����B";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "�c�c�Ȃ�قǁc�c";
		next;
		mes "[�C���O���b�h]";
		mes "�c�c���[�A��[";
		mes "���������b��";
		mes "�Ȃ��Ă��܂��܂����ˁB";
		mes "�Z�����i���m�ɔ�ׂ��";
		mes "���Ȃ�āA�܂��܂������ɂ�";
		mes "�y�΂Ȃ��̂Ɂc�c";
		next;
		mes "[�C���O���b�h]";
		mes "���́A�����K���X�����K�[";
		mes "�ɂȂ肽��������ł����A";
		mes "�g���S�����Ă����Ȃ��āA";
		mes "���߂��������ł��B";
		next;
		mes "[�C���O���b�h]";
		mes "�ł��A�����̊ԁA";
		mes "�Z�����i���m��������";
		mes "���̎����C�ɂ��Ă���āA";
		mes "���̂��̎d�����ł���悤��";
		mes "�F�X�Ǝ�`���Ă��ꂽ��ł��B";
		next;
		mes "[�C���O���b�h]";
		mes "�K���X�����K�[�ɂȂ�Ȃ������̂�";
		mes "������Ǝc�O�����ǁA";
		mes "���ƈꏏ�Ɏ������󂯂�";
		mes "���̂��Z������";
		mes "�K���X�����K�[�ɂȂ�܂����B";
		next;
		mes "[�C���O���b�h]";
		mes "���Z����񂾂��ł�";
		mes "�����̖���͂ގ����ł��āA";
		mes "�{���Ɋ������ł��B";
		next;
		mes "[�C���O���b�h]";
		mes "�A�n�n�B";
		mes "���߂�Ȃ����B";
		mes "�Ȃ񂾂���l�ŏ����";
		mes "����ׂ��Ă܂��ˁB";
		next;
		mes "[" +strcharinfo(0)+ "]";
		mes "������ł���B";
		mes "�����������A�C���O���b�h�����";
		mes "�K���X�����K�[�ɂȂ�Ȃ��������ł�";
		mes "�[���A�P���Ă���݂����ł��B";
		next;
		mes "[�C���O���b�h]";
		mes "�t�t�A���肪�Ƃ��������܂��B";
		mes "�{���ɁA���̎d���͊y�����ł��B";
		mes "�c�c���āA�b��߂��܂��傤���B";
		next;
		mes "[�C���O���b�h]";
		mes "�C���t�F���m�̐���ɂ�";
		mes "�Â��S��100�A�K�т��l�W50�A";
		mes "�I���f�I�R��10�A";
		mes "�R���Ă���S��100��";
		mes "�萔��20��Zeny���K�v�ł��B";
		mes "��낵���ł����H";
		next;
		if(select("�����l���Ă݂܂�","���肢���܂�")==1) {
			mes "[�C���O���b�h]";
			mes "�킩��܂����B";
			mes "�ł́A��������";
			mes "�l���Ă݂Ă��������B";
			close;
		}
		mes "[�C���O���b�h]";
		mes "�킩��܂����B";
		mes "�ł́A�ޗ����W�܂�����";
		mes "�܂����Ă��������B";
		next;
		mes "[�C���O���b�h]";
		mes "�C���t�F���m�̐���ɂ�";
		mes "�Â��S��100�A�K�т��l�W50�A";
		mes "�I���f�I�R��10�A";
		mes "�R���Ă���S��100��";
		mes "�萔��20��Zeny���K�v�ł��B";
		mes "�ޗ����ԈႦ�Ȃ��ł��������B";
		set GUN_4QUE,1;
		close;
	case 1:
		if(countitem(7319) < 100 || countitem(7317) < 50 || countitem(984) < 10 || countitem(7097) < 100) {
			mes "[�C���O���b�h]";
			mes "�C���t�F���m�̐���ɂ�";
			mes "�Â��S��100�A�K�т��l�W50�A";
			mes "�I���f�I�R��10�A";
			mes "�R���Ă���S��100��";
			mes "�萔��20��Zeny���K�v�ł��B";
			mes "�ޗ����ԈႦ�Ȃ��ł��������B";
			close;
		}
		if(Zeny < 200000) {
			mes "[�C���O���b�h]";
			mes "�ޗ��͏\���ł����ǁA";
			mes "�萔��������ĂȂ��ł��B";
			mes "20��Zeny�ł��B";
			mes "�ԈႦ�Ȃ��ł��������B";
			close;
		}
		if(MaxWeight - Weight <= 1250) {
			mes "[�C���O���b�h]";
			mes "�ו�����t����Ȃ��ł����H";
			mes "�����������Ă���";
			mes "�܂����Ă��������B";
			close;
		}
		mes "[�C���O���b�h]";
		mes "���A�����W�߂Ă�����ł����H";
		mes "�{���c�c�т�����ł��B";
		mes "�ł́A���������c�c";
		next;
		mes "[�C���O���b�h]";
		mes "�͂��A���ꂪ�C���t�F���m�ł��B";
		mes "�ǂ�����؂Ɏg���Ă��������B";
		delitem 7319,100;
		delitem 7317,50;
		delitem 984,10;
		delitem 7097,100;
		set GUN_4QUE,2;
		getitem 13162,1;
		next;
		mes "[�C���O���b�h]";
		mes "�����A���̂��Z�����ɉ������A";
		mes "�b�����Ă݂Ă��������B";
		mes "���Z�����̖��O�̓C���O�����B";
		mes "�悩������T���Ă݂Ă��������B";
		close;
	case 2:
		mes "[�C���O���b�h]";
		mes "����ɂ��́B";
		mes "�܂���������Ⴂ�܂����ˁB";
		mes "�C���t�F���m���K�v��";
		mes "�Ȃ����̂ł����H";
		next;
		if(select("������","�͂�")==1) {
			mes "[�C���O���b�h]";
			mes "�����ł����B";
			mes "�ł́A��������";
			mes "���Ă����Ă��������B";
			close;
		}
		if(countitem(7319) < 100 || countitem(7317) < 50 || countitem(984) < 10 || countitem(7097) < 100) {
			mes "[�C���O���b�h]";
			mes "�C���t�F���m�̐���ɂ�";
			mes "�Â��S��100�A�K�т��l�W50�A";
			mes "�I���f�I�R��10�A";
			mes "�R���Ă���S��100��";
			mes "�萔��20��Zeny���K�v�ł��B";
			mes "�ޗ����ԈႦ�Ȃ��ł��������B";
			close;
		}
		if(Zeny < 200000) {
			mes "[�C���O���b�h]";
			mes "�ޗ��͏\���ł����ǁA";
			mes "�萔��������ĂȂ��ł��B";
			mes "20��Zeny�ł��B";
			mes "�ԈႦ�Ȃ��ł��������B";
			close;
		}
		if(MaxWeight - Weight <= 1250) {
			mes "[�C���O���b�h]";
			mes "�ו�����t����Ȃ��ł����H";
			mes "�����������Ă���";
			mes "�܂����Ă��������B";
			close;
		}
		mes "[�C���O���b�h]";
		mes "�͂��A���ꂪ�C���t�F���m�ł��B";
		mes "�ǂ�����؂Ɏg���Ă��������B";
		delitem 7319,100;
		delitem 7317,50;
		delitem 984,10;
		delitem 7097,100;
		getitem 13162,1;
		close;
	}
}
