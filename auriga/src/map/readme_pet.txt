ペット 定義拡張説明書(2025/04/29現在)

* pet.h 記述確認

ペットの卵の実装最大数を3.2万まで増やす

#define MAX_PET_DB	32767

ペットに関するIDをshort型からint型に拡張し、桁数を増やします

	int itemID;
	int EggID;
	int AcceID;
	int FoodID;
