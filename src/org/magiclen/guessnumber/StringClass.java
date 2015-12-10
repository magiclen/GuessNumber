/*
 *
 * Copyright 2015 magiclen.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.magiclen.guessnumber;

/**
 * 字串常數集。
 *
 * @author Magic Len
 */
public class StringClass {

    /**
     * 儲存玩家名稱(此類別唯一的變數)。
     */
    public static String userName = "玩家"; //變數
    /**
     * 提示輸入使用者名稱。
     */
    public static final String SHOW_TYPE_USER_NAME = "請先輸入您的大名：";
    /**
     * 提示輸入的使用者名稱有誤。
     */
    public static final String SHOW_TYPE_USER_NAME_ERROR = "未輸入大名，請重新輸入：";
    /**
     * 歡迎玩猜數字遊戲的訊息。
     */
    public static final String SHOW_WELCOME = "\n\t歡迎來玩猜數字遊戲\n\n";
    /**
     * 歡迎使用者的訊息。
     */
    public static final String SHOW_USER_WELCOME = "%s 您好！\n"; //printf
    /**
     * 主選單的頂端。
     */
    public static final String SHOW_MENU_TOP = "********************主選單********************\n";
    /**
     * 主選單項目的顯示格式。
     */
    public static final String SHOW_MENU_TYPE = "\t%d.%s\n"; //printf
    /**
     * 主選單中的項目。
     */
    public static final String SHOW_MENU_ITEMS[] = {"由電腦出題讓使用者猜", "由使用者出題讓電腦猜", "電腦互猜(教學及測試用)", "電腦助猜", "人機大戰", "猜數字玩法說明", "離開選單"};
    /**
     * 主選單的底端。
     */
    public static final String SHOW_MENU_END = "*********************************************\n";
    /**
     * 提示輸入主選單的項目值。
     */
    public static final String SHOW_TYPE_MENU_ITEM = "請輸入您要的功能[1-" + SHOW_MENU_ITEMS.length + "]：";
    /**
     * 提示輸入的主選單項目值有誤。
     */
    public static final String SHOW_TYPE_MENU_ITEM_ERROR = "輸入有誤，請重新輸入[1-" + SHOW_MENU_ITEMS.length + "]：";
    /**
     * 是否關閉程式的訊息。
     */
    public static final String SHOW_EXIT_MENU = "離開選單等於關閉程式，您確定嗎？[Y/N]：";
    /**
     * 取消關閉程式的訊息。
     */
    public static final String SHOW_WELCOME_BACK = "歡迎回來！";
    /**
     * 關閉程式的訊息。
     */
    public static final String SHOW_EXIT = "掰掰 %s ，歡迎下次再來挑戰！\n"; //printf
    /**
     * Y或N輸入錯誤的訊息。
     */
    public static final String SHOW_EXIT_ERROR = "輸入有誤，請重新輸入[Y/N]：";
    /**
     * 電腦名稱。
     */
    public static final String[] COMPUTER_NAMES = {"「狂獅」鐵戰", "「血手」杜殺", "「不男不女」屠嬌嬌", "「笑裡藏刀」哈哈兒", "「不吃人頭」李大嘴", "「惡賭鬼」軒轅三光", "「迷死人不賠命」蕭咪咪", "「半人半鬼」陰九幽", "「損人不利己」白開心", "「電腦不難」幻嵐", "「電腦不難」幻冽", "「電腦很難」幻難"};
    /**
     * 猜題次數少。
     */
    public static final String SHOW_GUESS_TIMES_BEST[] = {"太厲害了！您只猜了%d次！", "塞郎！居然只猜了%d次！", "好賽啊！居然猜%d次就猜出來了！", "神手啊！猜%d次就猜出來了！", "您只猜了%d次！"}; //printf
    /**
     * 猜題次數中。
     */
    public static final String SHOW_GUESS_TIMES_GOOD[] = {"厲害！您猜了%d次。", "高手！您猜了%d次。", "強人，只猜了%d次。", "神，您只猜了%d次。", "您猜了%d次！"}; //printf
    /**
     * 猜題次數多。
     */
    public static final String SHOW_GUESS_TIMES_BAD[] = {"好遜喔！您猜了%d次！", "真是不好意思，我太高估您了！您居然猜了%d次！", "爛死了，不會玩猜數字喔？您知道您猜了%d次嗎？", "您是第一次玩猜數字嗎？您猜了%d次！", "您猜了%d次，還要再多練習喔！"}; //printf
    /**
     * 玩家名稱和冒號。
     */
    public static final String SHOW_TALK_NAME = "%s："; //printf
    /**
     * 玩家名稱：說話語句。
     */
    public static final String SHOW_TALK_NAME_SENTENCE = "%s：%s\n";
    /**
     * 電腦出題者剛出現時的語句。
     */
    public static final String[] COMPUTER_ASKER_APPEAR = {"就由我來當您的對手吧！", "先等等，讓我出個題目。", "唔？開始了嗎？", "換我上場了嗎？", "有客人上門了？", "該我上場了嗎？", "您好。", "安安。", "安安，您好。", "安。", "又有不自量力的人來了。", "您看起來很弱。", "您看起來很強。"};
    /**
     * 使用者出題者剛出現時的語句。
     */
    public static final String[] USER_ASKER_APPEAR = {"來猜猜看我心裡所想的數字吧！不過要等等，讓我先出個題目。", "Let's battle! 等我出題。", "由我先攻！", "我以考倒電腦為樂。", "電腦不足為懼。"};
    /**
     * 電腦出題者出完題目的語句。
     */
    public static final String SHOW_COMPUTER_FINISH_PROBLEM = "%s 已經出好題目了。\n"; //printf
    /**
     * 出題者出完題目的語句。
     */
    public static final String[] START_GUESS = {"您可以開始猜了！", "好，開始猜吧！", "說出您要猜的數字吧！", "請猜出一組四個不重複的數字。", "有了！您絕對猜不到！", "開始瞎猜吧！", "我好了，您開始猜吧！", "快猜吧！", "可以開始猜了。"};
    /**
     * 使用者亂輸入提示造成電腦判斷失敗的語句。
     */
    public static final String[] COMPUTER_GUESS_FAIL = {"別以為我不知道你在唬我！這回合就這樣結束吧！", "您的提示有錯啦！這回合就這樣結束吧！", "X的！別唬爛啦！這回合就這樣結束吧！", "您的提示有錯，讓我猜不下去，這回合就這樣結束吧！", "您亂提示，我想結束這個回合。", "我看您是來亂的，我想結束這個回合。", "您圖謀不軌啦！", "猜不出來，您是亂給提示吧？"};
    /**
     * 電腦玩家的掰掰語句。
     */
    public static final String[] COMPUTER_BYE = {"掰掰！", "88", "86", "下次再來。", "886", "881", "再見啦！", "再會啦！", "有緣再見。"};
    /**
     * 使用者玩家的掰掰語句。
     */
    public static final String[] USER_BYE = {"我不玩了，掰掰依！", "先閃啦，掰掰！", "我先下了，掰掰！", "不想玩了，掰掰。"};
    /**
     * 輸入格式有誤的語句。
     */
    public static final String[] COMPUTER_HINT_TYPE_ERROR = {"其實這個並不好笑。", "您在說什麼？", "蛤？", "蝦米？", "飯可以亂吃，話不可以亂說。", "聽不懂。", "再說一次。", "別跟我開玩笑。", "有沒有新花樣？", "這招玩過了喔！", "您的愚蠢輸入已經上傳至網路上。", "您快上新聞了。", "拜託認真點。", "我好想睡覺...zzZ", "旁邊看你玩的人快要發瘋了", "這樣好笑嗎?你開心就好(無奈)", "不知道怎麼輸入不會去看說明嗎？文盲喔？", "不會玩就來這招？", "我懷疑您沒逛過MagicLen。", "天快下紅雨了..", "歡迎光臨MagicLen！http://magiclen.org", "呆子。", "笨蛋。", "白癡。", "唧哩呱啦。"};
    /**
     * 電腦猜題者猜題的語句。
     */
    public static final String[] COMPUTER_GUESS = {"我猜%s。", "我猜...%s。", "%s？沒頭緒，隨便猜。", "一定是%s啦！哈哈哈！亂猜的。", "不會是%s吧？", "難道是%s？", "%s。", "不知道，%s嗎？", "1234...？不對，我猜%s好了。", "5678...？不對，我猜%s好了。", "0123...？不對，我猜%s好了。", "2345...？不對，我猜%s好了。", "3456...？不對，我猜%s好了。", "4567...？不對，我猜%s好了。", "幸運女神來眷顧我吧！我猜%s！！", "%s？真難猜。", "毫無頭緒，我就猜%s吧！", "幸運之神來眷顧我吧！我猜%s！！", "%s嗎？", "%s。就決定是你了！", "我聽到神的旨意了，祂說%s。"}; //printf
    /**
     * 電腦猜題者猜題幫助使用者的語句。
     */
    public static final String[] COMPUTER_HELP_GUESS = {"您可以猜%s，有%2.0f％的猜中機率。", "猜%s吧！有%2.0f％的猜中機率。", "我會猜%s，有%2.0f％的猜中機率", "猜%s，%2.0f％的機率會中。", "如果是我我會猜%s，因為有%2.2f％的機率會中。", "猜%s吧，精確算了一下，有%2.5f％的機率會中。"};//printf
    /**
     * 使用者向電腦求助幫忙猜數字的語句。
     */
    public static final String[] USER_SERVICE = {"誰能幫我猜數字...", "有請電腦幫我猜數字！", "拜託幫我猜數字！", "可以幫我猜數字嗎？", "你馬幫幫忙，幫我猜數字。", "為了猜數字而苦惱...", "猜~猜~幫我猜數子！"};
    /**
     * 提示哪兩個玩家在猜題。
     */
    public static final String COMPUTERS_VS = "%s VS %s\n";
    /**
     * 提示回合。
     */
    public static final String SHOW_COMPUTERS_START = "第%d回合由 %s 出題。\n";
    /**
     * 遊戲結束訊息。
     */
    public static final String SHOW_GAME_EXIT = "\n遊戲已結束，要繼續嗎？[Y/N]：";
    /**
     * 玩家出題訊息。
     */
    public static final String SHOW_MAKE_QUESTION = "玩家請先在心中出題，想好後按下Enter繼續... ";
    /**
     * 玩家回答提示訊息。
     */
    public static final String SHOW_SERVICE_HELP = "這個模式玩家只要針對電腦給的數字進行XAYB的回答就行了。按下Enter繼續... ";
    /**
     * Enter鍵訊息。
     */
    public static final String SHOW_TYPE_ENTER = "(按下Enter繼續...) ";
    /**
     * 人機大戰結果訊息。
     */
    public static final String SHOW_CONTEST_WINNER = "本局由 %s 取得勝利！只猜了%d次！";
}
