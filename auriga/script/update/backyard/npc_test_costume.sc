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