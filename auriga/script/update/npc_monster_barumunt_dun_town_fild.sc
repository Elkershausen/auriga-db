//2022-11-10 EPISODE�FILUSION�`���҂̈�Y [�o�������g�@][��P���͔��d���A����������][�}���� �L���̉�L][��s�D������][�B���ꂽ�ԉ�]
//[����ꃍ�X�g�o���[][�h��][�J�t�F�e���A][�H��][�D����][�����Ƀ^���^���X][]��Q���͔��d��][�嗁�ꃁ�f�B�^�e�B�I]
//=============================================================
//= �嗁�ꃁ�f�B�^�e�B�I ba_bath.gat ba_bath_j.gat
//=============================================================
//Map Flag
ba_bath.gat	mapflag	nomemo	dummy
ba_bath_j.gat	mapflag	nomemo	dummy

//warp
ba_bath.gat,290,70,0		warp	medi_040001	1,1,prontera.gat,138,166
ba_bath_j.gat,290,70,0		warp	medi_040002	1,1,prontera.gat,138,166

//mob
ba_bath.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�^	20633,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�T�^	20634,55,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���t�F��		20643,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���}���N		20644,10,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���\�[�h�t�B�b�V��	20645,60,5000,0,0
ba_bath.gat,0,0,0,0	monster	�M���s���j�A		20646,60,5000,0,0

ba_bath_j.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�^	20633,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�̏Ⴕ�����|�^���T�T�^	20634,55,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���t�F��		20643,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���}���N		20644,10,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���\�[�h�t�B�b�V��	20645,60,5000,0,0
ba_bath_j.gat,0,0,0,0	monster	�M���s���j�A		20646,60,5000,0,0

//NPC
prontera.gat,124,169,3		script	�e�X�g�}�b�v	10353,{
mes "[4_EP17_MASTER_A]";
mes "�ǂ��ɍs���܂����H";
mes "prontera.gat npc pos(124,169)";
mes "";
next;
switch(select("�A�r�X���C�N�n�����A04[1]","�A�r�X���C�N�n�����A04[2]","�嗁�ꃁ�f�B�^�e�B�I[1]","�嗁�ꃁ�f�B�^�e�B�I[2]")) {

case 1:
	warp "abyss_04.gat",165,163;
	end;
case 2:
	warp "abyss_04_j.gat",165,163;
	end;
case 3:
	warp "ba_bath.gat",165,163;
	end;
case 4:
	warp "ba_bath_j.gat",165,163;
	end;}
}
