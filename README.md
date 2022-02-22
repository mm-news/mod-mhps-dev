# 學逼minecraft模組社範例用github儲存庫
本儲存庫用於儲存minecraft模組研究中所需的程式，
以及minecraft模組社的範例程式。
## 事前準備
> 工欲善其事，必先利其器，
> 要做出一個好的模組，得先有開發它的工具，
> 以下是開發模組所需的工具：

工具 | 功能 | 下載位置
:----: | :------------ | :----------------------
JDK    | 編譯你所寫的程式 | [按我下載](https://www.java.com/zh-TW/download/)
Forge MDK | 讓你可以在 Java 裡使用 Forge 的函式庫 | [按我下載](https://adfoc.us/serve/sitelinks/?id=271228&url=https://maven.minecraftforge.net/net/minecraftforge/forge/1.18.1-39.0.79/forge-1.18.1-39.0.79-mdk.zip)
VSCode | 讓你可以方便的編輯程式 | [下載VSCode](https://code.visualstudio.com/Download)
最重要的 Minecraft | 不用講了吧？ | 自己付 800 塊！

全部都下載好後，新增一個裝模組的資料夾，然後把 MDK 右鍵全部解壓縮到你的資料夾裡，
接著按 Windows + R，再輸入 cmd 並按下 Enter（如果是 Mac 作業系統，按 command 或 control + 空格），
並輸入以下指令：
`cd `，並把開啟檔案總管，把資料夾拖進 cmd 中，注意路徑會出現在命令列中，並按下 Enter，
接著輸入：
`gradlew genVSCoderuns`，程式大概會跑 10~20 分鐘。
完成後，把[從這裡下載下來的zip檔](https://github.com/mm-news/mod-mhps/archive/refs/heads/main.zip)裡面的 `mod-mhps-main` 資料夾，
然後把裡面的東西全部貼去 `src\main` 資料夾，再用 VSCode打開裡面的 Main.java ，
下載完 VSCode 所要求的延伸工具後...
