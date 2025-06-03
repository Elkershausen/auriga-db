//アイテム確認スクリプト

rwc01.gat,45,67,4	script	アイテム指定実装確認	478,{
	
	mes "[アイテム実装確認]";
	mes "何番から確認しますか？";
	mes "それとも一つづつ確認しますか？";
	next;
	menu "一気に見る",L_ITEM0000,"1個づつ見る",L_ITEM0001;

	mes "[アイテム実装確認]";
	mes "始めます。";
	next;
	set '@itemnum,0;
	goto L_ITEM0000;

L_ITEM0000:
	mes "番号を入力してください";
	input '@item;
	goto L_ITEM0004;

L_ITEM0004:
	set '@itemnum,'@itemnum+1;
	if ('@itemnum == 101 ) goto L_END;

	getitem '@item,1;
	mes "アイテム番号" + '@item + " " + getitemname('@item) + "";
	set '@item,'@item+1;
	goto L_ITEM0004;

L_ITEM0001:
	mes "最初の番号を入れてください。";
	next;
	input '@item2;
	goto L_ITEM0002;

L_ITEM0002:
	getitem '@item2,1;
	mes "アイテム番号" + '@item2 + " " + getitemname('@item2) + "";
	mes "次の番号にしますか？";
	next;
	menu "指定の番号",L_ITEM0001,"次の番号",L_ITEM0003,"やめる",L_END;

L_ITEM0003:

	set '@item2,'@item2+1;
	goto L_ITEM0002;

L_END:
	close;
}

rwc01.gat,48,67,4	script	アイテム連番実装確認	533,{

	mes "[アイテム実装確認]";
	mes "何番から確認しますか？";
	mes "それとも一つづつ確認しますか？";
	next;
	menu "一気に見る",L_ITEM0000,"1個づつ見る",L_ITEM0001;

	mes "[アイテム実装確認]";
	mes "始めます。";
	next;
	set '@itemnum,0;
	goto L_ITEM0000;

L_ITEM0000:
	mes "番号を入力してください";
	input '@item;
	goto L_ITEM0004;

L_ITEM0004:
	set '@itemnum,'@itemnum+1;
	if ('@itemnum == 101 ) goto L_END;

	getitem '@item,1;
	mes "アイテム番号" + '@item + " " + getitemname('@item) + "";
	set '@item,'@item+1;
	goto L_ITEM0004;

L_ITEM0001:
	mes "最初の番号を入れてください。";
	input '@item2;
	goto L_ITEM0002;

L_ITEM0002:
	getitem '@item2,1;
	mes "アイテム番号" + '@item2 + " " + getitemname('@item2) + "";
	mes "次の番号にしますか？";
	next;
	menu "次の番号",L_ITEM0003,"やめる",L_END;

L_ITEM0003:

	set '@item2,'@item2+1;
	goto L_ITEM0002;

L_END:
	close;

}

rwc01.gat,51,67,4	script	HPSPコーマ	533,{

	percentheal -99,-99;

}

rwc01.gat,54,67,4	script	アイテムリセット	533,{

	clearitem;
	gmcommand "@itemreset";
}

x_prt.gat,66,57,4	script	アイテム指定実装確認	10343,{
	
	mes "[アイテム実装確認]";
	mes "何番から確認しますか？";
	mes "それとも一つづつ確認しますか？";
	next;
	menu "一気に見る",L_ITEM0000,"1個づつ見る",L_ITEM0001;

	mes "[アイテム実装確認]";
	mes "始めます。";
	next;
	set '@itemnum,0;
	goto L_ITEM0000;

L_ITEM0000:
	mes "番号を入力してください";
	input '@item;
	goto L_ITEM0004;

L_ITEM0004:
	set '@itemnum,'@itemnum+1;
	if ('@itemnum == 101 ) goto L_END;

	getitem '@item,1;
	mes "アイテム番号" + '@item + " " + getitemname('@item) + "";
	set '@item,'@item+1;
	goto L_ITEM0004;

L_ITEM0001:
	mes "最初の番号を入れてください。";
	next;
	input '@item2;
	goto L_ITEM0002;

L_ITEM0002:
	getitem '@item2,1;
	mes "アイテム番号" + '@item2 + " " + getitemname('@item2) + "";
	mes "次の番号にしますか？";
	next;
	menu "指定の番号",L_ITEM0001,"次の番号",L_ITEM0003,"やめる",L_END;

L_ITEM0003:

	set '@item2,'@item2+1;
	goto L_ITEM0002;

L_END:
	close;

}

x_prt.gat,68,57,4	script	アイテム連番実装確認	10353,{

	mes "[アイテム実装確認]";
	mes "何番から確認しますか？";
	mes "それとも一つづつ確認しますか？";
	next;
	menu "一気に見る",L_ITEM0000,"1個づつ見る",L_ITEM0001;

	mes "[アイテム実装確認]";
	mes "始めます。";
	next;
	set '@itemnum,0;
	goto L_ITEM0000;

L_ITEM0000:
	mes "番号を入力してください";
	input '@item;
	goto L_ITEM0004;

L_ITEM0004:
	set '@itemnum,'@itemnum+1;
	if ('@itemnum == 101 ) goto L_END;

	getitem '@item,1;
	mes "アイテム番号" + '@item + " " + getitemname('@item) + "";
	set '@item,'@item+1;
	goto L_ITEM0004;

L_ITEM0001:
	mes "最初の番号を入れてください。";
	input '@item2;
	goto L_ITEM0002;

L_ITEM0002:
	getitem '@item2,1;
	mes "アイテム番号" + '@item2 + " " + getitemname('@item2) + "";
	mes "次の番号にしますか？";
	next;
	menu "次の番号",L_ITEM0003,"やめる",L_END;

L_ITEM0003:

	set '@item2,'@item2+1;
	goto L_ITEM0002;

L_END:
	close;

}

x_prt.gat,70,57,4	script	HPSPコーマ	10545,{
	percentheal -99,-99;
}

x_prt.gat,72,57,4	script	アイテムリセット	10173,{
	clearitem;
	gmcommand "@itemreset";
}

prontera.gat,159,151,4	script	最新アイテム	70,{
	mes "[" +strnpcinfo(1)+ "]";
getitem 400907,1;
getitem 450462,1;
getitem 450463,1;
getitem 470351,1;
getitem 480592,1;
getitem 490745,1;
getitem 490746,1;
getitem 610081,1;
getitem 620052,1;
getitem 630056,1;
getitem 640063,1;
getitem 700115,1;
getitem 200652,1;
getitem 200653,1;
getitem 200654,1;
getitem 810047,1;
getitem 500115,1;
getitem 510181,1;
getitem 530070,1;
getitem 540103,1;
getitem 550172,1;
getitem 550173,1;
getitem 560076,1;
getitem 570082,1;
getitem 580082,1;
getitem 590097,1;
getitem 200658,1;
getitem 10579,1;
getitem 103307,1;
getitem 103320,1;
getitem 200650,1;
getitem 200651,1;
close;
}

function	script	vipticket	70,{
	setarray '@mainitem[0],200010,10527,10518,10521,200007,200021,200016,10501,10504,200024,10530,200018,17995,200057,200060,25626;
	//mes "どれにしますか？";
		switch(select(
		"やめる",
		""+getitemname('@mainitem[0])+"",
		""+getitemname('@mainitem[1])+"",
		""+getitemname('@mainitem[2])+"",
		""+getitemname('@mainitem[3])+"",
		""+getitemname('@mainitem[4])+"",
		""+getitemname('@mainitem[5])+"",
		""+getitemname('@mainitem[6])+"",
		""+getitemname('@mainitem[7])+"",
		""+getitemname('@mainitem[8])+"",
		""+getitemname('@mainitem[9])+"",
		""+getitemname('@mainitem[10])+"",
		""+getitemname('@mainitem[11])+"",
		""+getitemname('@mainitem[12])+"",
		""+getitemname('@mainitem[13])+"",
		""+getitemname('@mainitem[14])+"",
		""+getitemname('@mainitem[15])+""
		))
		{
	case 1:
		getitem 501,1;	break;
	case 2:
		getitem '@mainitem[0],1;	break;
	case 3:
		getitem '@mainitem[1],1;	break;
	case 4:
		getitem '@mainitem[2],1;	break;
	case 5:
		getitem '@mainitem[3],1;	break;
	case 6:
		getitem '@mainitem[4],1;	break;
	case 7:
		getitem '@mainitem[5],1;	break;
	case 8:
		getitem '@mainitem[6],1;	break;
	case 9:
		getitem '@mainitem[7],1;	break;
	case 10:
		getitem '@mainitem[8],1;	break;
	case 11:
		getitem '@mainitem[9],1;	break;
	case 12:
		getitem '@mainitem[10],1;	break;
	case 13:
		getitem '@mainitem[11],1;	break;
	case 14:
		getitem '@mainitem[12],1;	break;
	case 15:
		getitem '@mainitem[13],1;	break;
	case 16:
		getitem '@mainitem[14],1;	break;
	case 17:
		getitem '@mainitem[15],1;	break;
		}
	close;
}