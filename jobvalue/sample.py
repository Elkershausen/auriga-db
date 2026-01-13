import customtkinter as ctk
import json
import os

class JobSelectorApp(ctk.CTk):
    def __init__(self):
        super().__init__()

        self.title("使用可能な職業を選択")
        self.geometry("480x700") # 画像に近いサイズ感に調整
        
        # 外観モード（ライト/ダーク）をシステムに合わせる
        ctk.set_appearance_mode("system") 

        self.jobs = self.load_config("classnum.json")
        self.check_vars = [] 

        self.setup_ui()

    def load_config(self, filename):
        if os.path.exists(filename):
            with open(filename, "r", encoding="utf-8") as f:
                return json.load(f)
        return []

    def setup_ui(self):
        # ウィンドウ全体のパディング
        self.grid_columnconfigure(0, weight=1)
        self.main_container = ctk.CTkFrame(self, fg_color="transparent")
        self.main_container.pack(padx=15, pady=15, fill="both", expand=True)

        # --- 1. 最上部：設定値とボタン ---
        top_row = ctk.CTkFrame(self.main_container, fg_color="transparent")
        top_row.pack(fill="x", pady=(0, 10))

        ctk.CTkLabel(top_row, text="設定値").pack(side="left", padx=(0, 5))
        self.val_entry = ctk.CTkEntry(top_row, width=100)
        self.val_entry.pack(side="left", padx=5)
        self.val_entry.insert(0, "0")

        self.btn_cancel = ctk.CTkButton(top_row, text="キャンセル", width=80, fg_color="white", text_color="black", border_width=1, hover_color="#eeeeee", command=self.reset_selection)
        self.btn_cancel.pack(side="right", padx=5)

        self.btn_ok = ctk.CTkButton(top_row, text="決定", width=80, border_width=1, command=self.copy_to_clipboard)
        self.btn_ok.pack(side="right", padx=5)

        # --- 2. グループ選択エリア ---
        group_box = ctk.CTkFrame(self.main_container, border_width=1, border_color="gray")
        group_box.pack(fill="x", pady=10)
        
        ctk.CTkLabel(group_box, text="グループ選択", font=("Arial", 11)).place(x=10, y=-12) # 枠線の上にラベルを被せる演出

        group_inner = ctk.CTkFrame(group_box, fg_color="transparent")
        group_inner.pack(padx=10, pady=15)

        # グループチェックボックス（2列3行）
        self.group_options = [
            ("すべての職業", "all", 0, 0), ("ノービスを除くすべての職業", "no_novice", 0, 1),
            ("すべての一次職", "1st", 1, 0), ("特殊一次職を除くすべての一次職", "no_sp_1st", 1, 1),
            ("すべての二次職", "2nd", 2, 0), ("特殊二次職を除くすべての二次職", "no_sp_2nd", 2, 1)
        ]

        for text, tag, r, c in self.group_options:
            var = ctk.BooleanVar()
            cb = ctk.CTkCheckBox(group_inner, text=text, variable=var, font=("Arial", 11), 
                                 command=lambda t=tag, v=var: self.toggle_group(t, v))
            cb.grid(row=r, column=c, padx=15, pady=5, sticky="w")

        # --- 3. 個別選択エリア ---
        individual_box = ctk.CTkFrame(self.main_container, border_width=1, border_color="gray")
        individual_box.pack(fill="both", expand=True, pady=(15, 0))

        ctk.CTkLabel(individual_box, text="個別選択", font=("Arial", 11)).place(x=10, y=-12)

        # スクロール内側
        scroll_frame = ctk.CTkScrollableFrame(individual_box, fg_color="transparent")
        scroll_frame.pack(fill="both", expand=True, padx=5, pady=10)

        for i, job in enumerate(self.jobs):
            var = ctk.IntVar(value=0)
            cb = ctk.CTkCheckBox(
                scroll_frame, 
                text=job["name"], 
                variable=var, 
                font=("Arial", 11),
                command=self.update_total_value
            )
            cb.grid(row=i // 3, column=i % 3, padx=8, pady=4, sticky="w")
            self.check_vars.append({"var": var, "value": job["value"], "group": job.get("group", "")})

    def toggle_group(self, tag, master_var):
        """グループ選択のロジック（拡張用）"""
        is_checked = master_var.get()
        for item in self.check_vars:
            # 簡単なロジック例（"all" の場合のみ全選択）
            if tag == "all":
                item["var"].set(1 if is_checked else 0)
            elif tag == item["group"]:
                item["var"].set(1 if is_checked else 0)
        
        self.update_total_value()

    def update_total_value(self):
        total = sum(item["value"] for item in self.check_vars if item["var"].get() == 1)
        self.val_entry.delete(0, "end")
        self.val_entry.insert(0, str(total))

    def copy_to_clipboard(self):
        self.clipboard_clear()
        self.clipboard_append(self.val_entry.get())
        self.btn_ok.configure(text="コピー完了", fg_color="green")
        self.after(1000, lambda: self.btn_ok.configure(text="決定", fg_color=("#3a7ebf", "#1f538d")))

    def reset_selection(self):
        for item in self.check_vars:
            item["var"].set(0)
        self.update_total_value()

if __name__ == "__main__":
    app = JobSelectorApp()
    app.mainloop()