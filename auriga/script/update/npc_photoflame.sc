//2025/06/10 装備アイテム一覧表示システム アップデート
//2024年以降の環境でないと表示ウインドウの拡張命令 [messize] が使えません
//表示ウインドウは30秒経過で[close;]してカットインフレームが残るのでリログして下さい
//エンチャント状況で変わる文字色(緑青黄) フォント太字装飾 未実装

izlude.gat,139,129,4	script	撮影監督#38417	10494,{

	mes "["+strnpcinfo(1)+"]";
	mes "わいの最新カメラで";
	mes "あんさんの強い姿を写真に残さないか？";
	mes "オリジナルフレームと一緒に";
	mes "装備一覧も写してやるぞ。";
	next;
	if(select("お願いする","遠慮する") == 2) {
	mes "["+strnpcinfo(1)+"]";
	mes "いつでも声をかけてくれ。";
	close;	}
	messize 480,640;	//表示ウインドウ拡張
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

	mes "== 装備一覧 == (※ランダムオプションや補助装備を除く)";
	mes "【兜上段】";
	mes "+"+getequiprefinerycnt(1)+" "+getequipname(1)+"( "+'@head_topA$+" , "+'@head_topB$+" , "+'@head_topC$+" , "+'@head_topD$+" )";
	mes "【兜中段】";
	mes ""+getequipname(9)+"( "+'@head_midA$+" , "+'@head_midB$+" , "+'@head_midC$+" , "+'@head_midD$+" )";
	mes "【兜下段】";
	mes ""+getequipname(10)+"( "+'@head_lowA$+" , "+'@head_lowB$+" , "+'@head_lowC$+" , "+'@head_lowD$+" )";
	mes "【鎧】";
	mes "+ "+getequiprefinerycnt(2)+" "+getequipname(2)+"( "+'@armorA$+" , "+'@armorB$+" , "+'@armorC$+" , "+'@armorD$+" )";
	mes "【右手】";
	mes "+ "+getequiprefinerycnt(4)+" "+getequipname(4)+"( "+'@rightA$+" , "+'@rightB$+" , "+'@rightC$+" , "+'@rightD$+" )";
	mes "【左手】";
	mes "+ "+getequiprefinerycnt(3)+" "+getequipname(3)+"( "+'@leftA$+" , "+'@leftB$+" , "+'@leftC$+" , "+'@leftD$+" )";
	mes "【肩にかけるもの】";
	mes "+ "+getequiprefinerycnt(5)+" "+getequipname(5)+"( "+'@robeA$+" , "+'@robeB$+" , "+'@robeC$+" , "+'@robeD$+" )";
	mes "【靴】";
	mes "+"+getequiprefinerycnt(6)+" "+getequipname(6)+"( "+'@shoesA$+" , "+'@shoesB$+" , "+'@shoesC$+" , "+'@shoesD$+" )";
	mes "【アクセサリー(1)】";
	mes ""+getequipname(7)+"( "+'@accrA$+" , "+'@accrB$+" , "+'@accrC$+" , "+'@accrD$+" )";
	mes "【アクセサリー(2)】";
	mes ""+getequipname(8)+"( "+'@acclA$+" , "+'@acclB$+" , "+'@acclC$+" , "+'@acclD$+" )";
	cutin "twitter_photo.bmp",1;
	close2;
	cutin "twitter_photo.bmp",255;
	end;
}