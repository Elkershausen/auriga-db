//2025/06/10 �����A�C�e���ꗗ�\���V�X�e�� �A�b�v�f�[�g
//2024�N�ȍ~�̊��łȂ��ƕ\���E�C���h�E�̊g������ [messize] ���g���܂���
//�\���E�C���h�E��30�b�o�߂�[close;]���ăJ�b�g�C���t���[�����c��̂Ń����O���ĉ�����
//�G���`�����g�󋵂ŕς�镶���F(�ΐ�) �t�H���g�������� ������

izlude.gat,139,129,4	script	�B�e�ē�#38417	10494,{

	mes "["+strnpcinfo(1)+"]";
	mes "�킢�̍ŐV�J������";
	mes "���񂳂�̋����p���ʐ^�Ɏc���Ȃ����H";
	mes "�I���W�i���t���[���ƈꏏ��";
	mes "�����ꗗ���ʂ��Ă�邼�B";
	next;
	if(select("���肢����","��������") == 2) {
	mes "["+strnpcinfo(1)+"]";
	mes "���ł����������Ă���B";
	close;	}
	messize 480,640;	//�\���E�C���h�E�g��
	set '@head_topA$,getitemname(getequipcardid(1,0)); if(getequipcardid(1,0) == 0) { set '@head_topA$," - "; }
	set '@head_topB$,getitemname(getequipcardid(1,1)); if(getequipcardid(1,1) == 0) { set '@head_topB$," - "; }
	set '@head_topC$,getitemname(getequipcardid(1,2)); if(getequipcardid(1,2) == 0) { set '@head_topC$," - "; }
	set '@head_topD$,getitemname(getequipcardid(1,3)); if(getequipcardid(1,3) == 0) { set '@head_topD$," - "; }

	set '@head_midA$,getitemname(getequipcardid(9,0)); if(getequipcardid(9,0) == 0) { set '@head_midA$," - "; }
	set '@head_midB$,getitemname(getequipcardid(9,1)); if(getequipcardid(9,1) == 0) { set '@head_midB$," - "; }
	set '@head_midC$,getitemname(getequipcardid(9,2)); if(getequipcardid(9,2) == 0) { set '@head_midC$," - "; }
	set '@head_midD$,getitemname(getequipcardid(9,3)); if(getequipcardid(9,3) == 0) { set '@head_midD$," - "; }

	set '@head_lowA$,getitemname(getequipcardid(10,0)); if(getequipcardid(10,0) == 0) { set '@head_lowA$," - "; }
	set '@head_lowB$,getitemname(getequipcardid(10,1)); if(getequipcardid(10,1) == 0) { set '@head_lowB$," - "; }
	set '@head_lowC$,getitemname(getequipcardid(10,2)); if(getequipcardid(10,2) == 0) { set '@head_lowC$," - "; }
	set '@head_lowD$,getitemname(getequipcardid(10,3)); if(getequipcardid(10,3) == 0) { set '@head_lowD$," - "; }

	set '@armorA$,getitemname(getequipcardid(2,0)); if(getequipcardid(2,0) == 0) { set '@armorA$," - "; }
	set '@armorB$,getitemname(getequipcardid(2,1)); if(getequipcardid(2,1) == 0) { set '@armorB$," - "; }
	set '@armorC$,getitemname(getequipcardid(2,2)); if(getequipcardid(2,2) == 0) { set '@armorC$," - "; }
	set '@armorD$,getitemname(getequipcardid(2,3)); if(getequipcardid(2,3) == 0) { set '@armorD$," - "; }

	set '@rightA$,getitemname(getequipcardid(4,0)); if(getequipcardid(4,0) == 0) { set '@rightA$," - "; }
	set '@rightB$,getitemname(getequipcardid(4,1)); if(getequipcardid(4,1) == 0) { set '@rightB$," - "; }
	set '@rightC$,getitemname(getequipcardid(4,2)); if(getequipcardid(4,2) == 0) { set '@rightC$," - "; }
	set '@rightD$,getitemname(getequipcardid(4,3)); if(getequipcardid(4,3) == 0) { set '@rightD$," - "; }

	set '@leftA$,getitemname(getequipcardid(3,0)); if(getequipcardid(3,0) == 0) { set '@leftA$," - "; }
	set '@leftB$,getitemname(getequipcardid(3,1)); if(getequipcardid(3,1) == 0) { set '@leftB$," - "; }
	set '@leftC$,getitemname(getequipcardid(3,2)); if(getequipcardid(3,2) == 0) { set '@leftC$," - "; }
	set '@leftD$,getitemname(getequipcardid(3,3)); if(getequipcardid(3,3) == 0) { set '@leftD$," - "; }

	set '@robeA$,getitemname(getequipcardid(5,0)); if(getequipcardid(5,0) == 0) { set '@robeA$," - "; }
	set '@robeB$,getitemname(getequipcardid(5,1)); if(getequipcardid(5,1) == 0) { set '@robeB$," - "; }
	set '@robeC$,getitemname(getequipcardid(5,2)); if(getequipcardid(5,2) == 0) { set '@robeC$," - "; }
	set '@robeD$,getitemname(getequipcardid(5,3)); if(getequipcardid(5,3) == 0) { set '@robeD$," - "; }

	set '@shoesA$,getitemname(getequipcardid(6,0)); if(getequipcardid(6,0) == 0) { set '@shoesA$," - "; }
	set '@shoesB$,getitemname(getequipcardid(6,1)); if(getequipcardid(6,1) == 0) { set '@shoesB$," - "; }
	set '@shoesC$,getitemname(getequipcardid(6,2)); if(getequipcardid(6,2) == 0) { set '@shoesC$," - "; }
	set '@shoesD$,getitemname(getequipcardid(6,3)); if(getequipcardid(6,3) == 0) { set '@shoesD$," - "; }

	set '@accrA$,getitemname(getequipcardid(7,0)); if(getequipcardid(7,0) == 0) { set '@accrA$," - "; }
	set '@accrB$,getitemname(getequipcardid(7,1)); if(getequipcardid(7,1) == 0) { set '@accrB$," - "; }
	set '@accrC$,getitemname(getequipcardid(7,2)); if(getequipcardid(7,2) == 0) { set '@accrC$," - "; }
	set '@accrD$,getitemname(getequipcardid(7,3)); if(getequipcardid(7,3) == 0) { set '@accrD$," - "; }

	set '@acclA$,getitemname(getequipcardid(8,0)); if(getequipcardid(8,0) == 0) { set '@acclA$," - "; }
	set '@acclB$,getitemname(getequipcardid(8,1)); if(getequipcardid(8,1) == 0) { set '@acclB$," - "; }
	set '@acclC$,getitemname(getequipcardid(8,2)); if(getequipcardid(8,2) == 0) { set '@acclC$," - "; }
	set '@acclD$,getitemname(getequipcardid(8,3)); if(getequipcardid(8,3) == 0) { set '@acclD$," - "; }

	mes "== �����ꗗ == (�������_���I�v�V������⏕����������)";
	mes "�y����i�z";
	mes "+"+getequiprefinerycnt(1)+" "+getequipname(1)+"( "+'@head_topA$+" , "+'@head_topB$+" , "+'@head_topC$+" , "+'@head_topD$+" )";
	mes "�y�����i�z";
	mes ""+getequipname(9)+"( "+'@head_midA$+" , "+'@head_midB$+" , "+'@head_midC$+" , "+'@head_midD$+" )";
	mes "�y�����i�z";
	mes ""+getequipname(10)+"( "+'@head_lowA$+" , "+'@head_lowB$+" , "+'@head_lowC$+" , "+'@head_lowD$+" )";
	mes "�y�Z�z";
	mes "+ "+getequiprefinerycnt(2)+" "+getequipname(2)+"( "+'@armorA$+" , "+'@armorB$+" , "+'@armorC$+" , "+'@armorD$+" )";
	mes "�y�E��z";
	mes "+ "+getequiprefinerycnt(4)+" "+getequipname(4)+"( "+'@rightA$+" , "+'@rightB$+" , "+'@rightC$+" , "+'@rightD$+" )";
	mes "�y����z";
	mes "+ "+getequiprefinerycnt(3)+" "+getequipname(3)+"( "+'@leftA$+" , "+'@leftB$+" , "+'@leftC$+" , "+'@leftD$+" )";
	mes "�y���ɂ�������́z";
	mes "+ "+getequiprefinerycnt(5)+" "+getequipname(5)+"( "+'@robeA$+" , "+'@robeB$+" , "+'@robeC$+" , "+'@robeD$+" )";
	mes "�y�C�z";
	mes "+"+getequiprefinerycnt(6)+" "+getequipname(6)+"( "+'@shoesA$+" , "+'@shoesB$+" , "+'@shoesC$+" , "+'@shoesD$+" )";
	mes "�y�A�N�Z�T���[(1)�z";
	mes ""+getequipname(7)+"( "+'@accrA$+" , "+'@accrB$+" , "+'@accrC$+" , "+'@accrD$+" )";
	mes "�y�A�N�Z�T���[(2)�z";
	mes ""+getequipname(8)+"( "+'@acclA$+" , "+'@acclB$+" , "+'@acclC$+" , "+'@acclD$+" )";
	cutin "twitter_photo.bmp",1;
	close2;
	cutin "twitter_photo.bmp",255;
	end;
}