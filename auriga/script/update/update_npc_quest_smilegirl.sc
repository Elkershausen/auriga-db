//2025/06/03 �A�b�v�f�[�g
//�z�u���W���C�� �v�����e������폜
//npc_quest_smilegirl.sc �ɏ㏑��

-	script	SmileGirl	92,{
	mes "[�X�}�C���K�[��]";
	mes "����ɂ��́`";
	mes "�X�}�C���K�[���ł��B";
	mes "��������`�����܂��傤���H";
	next;
	switch (select("^3355ff�X�}�C���}�X�N^000000�ɂ���","^3355ff�X�}�C���}�X�N^000000�𐻍�","��b���I��")) {
	case 1:
		mes "[�X�}�C���K�[��]";
		mes "^3355ff�g���X�^���R��^000000�����É��̖��߂ɂ��";
		mes "���邢�~�b�h�K�b�c��������邽��";
		mes "���{���̃C�x���g�ł��B";
		mes "^3355ff�u�����ɏΊ���I�v^000000";
		mes "�T�[�r�X�S����";
		mes "^3355ff�u�X�}�C���K�[���v^000000�ł��B";
		next;
		mes "[�X�}�C���K�[��]";
		mes "�ȒP�ȍޗ���";
		mes "�F�l��^3355ff�u�X�}�C���}�X�N�v^000000��";
		mes "����č����グ�܂��B";
		mes "�K�v�ȍޗ��͈ȉ��̒ʂ�ł��B";
		next;
		mes "[�X�}�C���K�[��]";
		mes "^3355ff�[���s�[ 10 ��";
		mes "�Ȗ� 10 ��";
		mes "�N���[�o�[ 10 ��^000000";
		next;
		mes "[�X�}�C���K�[��]";
		mes "���̃C�x���g�����������ɁA";
		mes "�������łȂ��A�݂Ȃ���";
		mes "�Ί�Ő����Ă�����";
		mes "���E�����܂��傤�B";
		close;
	case 2:
		if(countitem(909)<10 || countitem(914)<10 || countitem(705)<10) {
			mes "[�X�}�C���K�[��]";
			mes "���A�c�O�ł���";
			mes "�X�}�C���}�X�N����ɕK�v��";
			mes "�A�C�e�����s�����Ă��܂��B";
			mes "^3355ff�[���s�[ 10 ��";
			mes "�Ȗ� 10 ��";
			mes "�N���[�o�[ 10 ��^000000";
			mes "���K�v�ł��B";
			close;
		}
		mes "[�X�}�C���K�[��]";
		mes "�͂��A�o���オ��ł��I";
		mes "�X�}�C���}�X�N���ǂ����`";
		delitem 909,10;
		delitem 914,10;
		delitem 705,10;
		getitem 2278,1;
		next;
		mes "[�X�}�C���K�[��]";
		mes "�g���X�^��3���É���";
		mes "���邢�~�b�h�K�b�c��������邽��";
		mes "�����őP��s�������Ƃ�";
		mes "�񑩂��Ă��������܂����B";
		next;
		mes "[�X�}�C���K�[��]";
		mes "�ȏ�";
		mes "�~�b�h�K�b�c�L�񂩂��";
		mes "���m�点�ł����B";
		close;
	case 3:
		mes "[�X�}�C���K�[��]";
		mes "�����p���肪�Ƃ��������܂��B";
		mes "���B�̃��[���~�b�h�K�b�c������";
		mes "�������邢����n��グ�邽��";
		mes "����܂ʓw�͂����ĎQ��܂��B";
		next;
		mes "[�X�}�C���K�[��]";
		mes "�����̊F����̂����͂�";
		mes "���肢�\���グ�܂��B";
		mes "�ȏ�";
		mes "�~�b�h�K�b�c�L�񂩂�ł����I";
		close;
	}
}
alberta.gat,113,53,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
aldebaran.gat,136,135,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
geffen.gat,119,107,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
izlude.gat,102,139,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
morocc.gat,158,97,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
payon.gat,186,104,5	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
payon_p.gat,84,158,4	duplicate(SmileGirl)	�X�}�C���}�X�N�E��	92
