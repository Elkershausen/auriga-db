ゼニー保管システム 無効化説明書(2025/07/16現在)

* bank.c 記述確認

	// 取引不可チェック
	if( sd->npc_id != 0 || sd->state.storage_flag || sd->state.store || sd->state.deal_mode != 0 ||
	    sd->state.mail_appending || sd->chatID != 0 )
		return;

	// Zenyチェック
	if(zeny <= 0) {
		clif_bank_deposit(sd, 1);
		return;
	}
という記述があり、取引条件が定義されています

預け処理無効化
	// Zenyチェック
	if(zeny >= 0) {
		clif_bank_deposit(sd, 1);
		return;
	}

所持ゼニーが0以下の場合、取引不可 -> 所持ゼニーが0以上の場合、取引不可

ゼニーを持っている場合に取引出来なくなることで預け処理自体ができなくなります
