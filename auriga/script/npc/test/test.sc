prontera.gat,1,1,4	script	実装アイテム確認	533,{

	mes "[実装アイテム確認]";
	mes "何番から確認しますか？";
	mes "それとも一つづつ確認しますか？";
	next;
	menu "一気に見る",L_ITEM0000,"1個づつ見る",L_ITEM0001;

	mes "[実装アイテム確認]";
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

prontera.gat,1,1,4	script	アイテムリセット	533,{
	clearitem;
	gmcommand "@itemreset";
}

prontera.gat,1,1,4	script	エフェクトテスト	860,{


	set '@effecter_max,10000;

	mes "[" +strnpcinfo(1)+ "]";
	mes "エフェクトテストします。";
	mes "数値を入れてください。";
	mes "0～10000までの範囲です。";
	mes "番号を選んでください";
	next;
	mes "[" +strnpcinfo(1)+ "]";
	mes "何番から見始めますか？";
	mes "" +'@effecter_max+ "番の次は0番に戻ります。";
	input '@effecter_num;
	if('@effecter_num > '@effecter_max ||'@effecter_num < 0){
		mes "[" +strnpcinfo(1)+ "]";
		mes "範囲外です。";
		mes "もう1度やり直してください。";
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
	switch(select("次のエフェクト（" +'@effecter_num1+ "番）","前のエフェクト（" +'@effecter_num2+ "番）","今のエフェクト（" +'@effecter_num+ "番）","終了")){
		case 1://次のエフェクト
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num1,strcharinfo(0);
			set '@effecter_num,'@effecter_num1;
			continue;

		case 2://前のエフェクト
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num2,strcharinfo(0);
			set '@effecter_num,'@effecter_num2;
			continue;

		case 3://今のエフェクト
			delmisceffect '@effecter_num,strcharinfo(0);
			misceffect '@effecter_num,strcharinfo(0);
			continue;

		case 4://終了
			delmisceffect '@effecter_num,strcharinfo(0);
			set '@keys,'@keys +1;
			continue;
		}
	}
	close;
}

prontera.gat,1,1,4	script	HPSPコーマ	533,{

	percentheal -99,-99;

}

