import customtkinter as ctk
import json
import os
import sys
import tkinter as tk

class ItemSearchApp(ctk.CTk):
    def __init__(self):
        super().__init__()

        self.title("アイテム一括検索アプリ")
        self.geometry("700x750")

        # データの読み込み
        self.items = self.load_items("item_list.json")
        self.last_found_ids = []

        self.setup_ui()

    def load_items(self, filename):
        items = []
        if hasattr(sys, '_MEIPASS'):
            path = os.path.join(sys._MEIPASS, filename)
        else:
            path = filename

        try:
            with open(path, "r", encoding="utf-8") as f:
                for line in f:
                    if line.strip():
                        items.append(json.loads(line))
        except FileNotFoundError:
            print(f"Error: {filename} が見つかりません。")
        return items

    def setup_ui(self):
        self.grid_columnconfigure(0, weight=1)
        self.grid_rowconfigure(5, weight=1)

        # 説明ラベル
        self.label = ctk.CTkLabel(self, text="検索したい「ID」または「名前」を改行区切りで入力")
        self.label.grid(row=0, column=0, padx=20, pady=(10, 0), sticky="w")

        # 入力欄
        self.search_input = ctk.CTkTextbox(self, height=120)
        self.search_input.grid(row=1, column=0, padx=20, pady=10, sticky="ew")

        # 【追加】検索モード選択（ラジオボタン）
        self.radio_frame = ctk.CTkFrame(self, fg_color="transparent")
        self.radio_frame.grid(row=2, column=0, padx=20, pady=5, sticky="w")
        
        self.search_mode_var = ctk.StringVar(value="partial") # 初期値は部分一致
        
        self.radio_partial = ctk.CTkRadioButton(self.radio_frame, text="部分一致", 
                                                variable=self.search_mode_var, value="partial")
        self.radio_partial.pack(side="left", padx=(0, 20))
        
        self.radio_exact = ctk.CTkRadioButton(self.radio_frame, text="完全一致", 
                                              variable=self.search_mode_var, value="exact")
        self.radio_exact.pack(side="left")

        # ボタン配置用のフレーム
        self.button_frame = ctk.CTkFrame(self, fg_color="transparent")
        self.button_frame.grid(row=3, column=0, padx=20, pady=5, sticky="ew")

        # 検索ボタン
        self.search_button = ctk.CTkButton(self.button_frame, text="一括検索実行", command=self.search_bulk)
        self.search_button.pack(side="left", padx=(0, 10))

        # IDコピーボタン
        self.copy_button = ctk.CTkButton(self.button_frame, text="表示中のIDを全てコピー", 
                                         command=self.copy_ids_to_clipboard, fg_color="#2c73d2")
        self.copy_button.pack(side="left", padx=(0, 10))

        # 初期化ボタン
        self.clear_button = ctk.CTkButton(self.button_frame, text="リセット", 
                                          command=self.clear_all, fg_color="#e74c3c", hover_color="#c0392b")
        self.clear_button.pack(side="left")

        # 通知ラベル
        self.info_label = ctk.CTkLabel(self, text="", text_color="green")
        self.info_label.grid(row=4, column=0, padx=20, pady=0)

        # 結果表示エリア
        self.result_box = ctk.CTkTextbox(self)
        self.result_box.grid(row=5, column=0, padx=20, pady=(5, 20), sticky="nsew")
        self.result_box.configure(state="disabled")

    def search_bulk(self):
        raw_text = self.search_input.get("1.0", "end-1c").strip()
        if not raw_text:
            return

        queries = [q.strip() for q in raw_text.split("\n") if q.strip()]
        
        all_results = []
        self.last_found_ids = []
        
        # 検索モードの取得
        mode = self.search_mode_var.get()
        
        for query in queries:
            found_for_this_query = []
            for item in self.items:
                if query.isdigit():
                    # IDは常に完全一致
                    if item["id"] == int(query):
                        found_for_this_query.append(item)
                else:
                    # 名前検索の分岐
                    if mode == "exact":
                        # 完全一致
                        if item["name"] == query:
                            found_for_this_query.append(item)
                    else:
                        # 部分一致（含む検索）
                        if query in item["name"]:
                            found_for_this_query.append(item)
            
            all_results.append((query, found_for_this_query))
            for item in found_for_this_query:
                if str(item["id"]) not in self.last_found_ids:
                    self.last_found_ids.append(str(item["id"]))

        self.display_results(all_results, mode)
        self.info_label.configure(text="")

    def display_results(self, all_results, mode):
        self.result_box.configure(state="normal")
        self.result_box.delete("1.0", "end")
        
        mode_text = "完全一致" if mode == "exact" else "部分一致"
        separator = "-" * 50 + "\n"
        
        for query, results in all_results:
            self.result_box.insert("end", f"【検索キーワード: {query} ({mode_text})】\n")
            if not results:
                self.result_box.insert("end", " -> 該当なし\n")
            else:
                for item in results:
                    line = f" ID: {item['id']} | Name: {item['name']} | Class: {item['class']}\n"
                    self.result_box.insert("end", line)
            self.result_box.insert("end", separator)
        
        self.result_box.configure(state="disabled")

    def copy_ids_to_clipboard(self):
        if not self.last_found_ids:
            self.info_label.configure(text="コピーするIDがありません", text_color="red")
            return
        id_text = "\n".join(self.last_found_ids)
        self.clipboard_clear()
        self.clipboard_append(id_text)
        self.info_label.configure(text=f"{len(self.last_found_ids)}件のIDをコピーしました！", text_color="green")

    def clear_all(self):
        self.search_input.delete("1.0", "end")
        self.result_box.configure(state="normal")
        self.result_box.delete("1.0", "end")
        self.result_box.configure(state="disabled")
        self.last_found_ids = []
        self.info_label.configure(text="リセットしました")

if __name__ == "__main__":
    app = ItemSearchApp()
    app.mainloop()