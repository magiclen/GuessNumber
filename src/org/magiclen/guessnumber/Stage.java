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
 * 舞台。為遊戲主體。
 *
 * @see StringClass
 * @see ComputerPlayer
 * @see UserPlayer
 * @see Tools
 * @see Player
 * @see Talk
 * @author Magic Len
 */
public class Stage {

    /**
     * 人機大戰使用的舞台。兩位Player交叉猜對方的數字與互相回答提示。
     *
     * @param user 使用者玩家
     * @param com 電腦玩家
     * @return 傳回true則重新執行此方法；傳回false則回到選單(Menu)
     */
    public static boolean contest(final Player user, final Player com) {
	Player Winner = null; //勝利者
	System.out.printf(StringClass.COMPUTERS_VS, user.getName(), com.getName());
	com.talk(Talk.START); //開始
	Tools.delay(1500); //延遲1.5秒
	com.talk(Talk.FINISH); //完成出題
	user.talk(Talk.FINISH); //完成出題
	com.talk(Talk.GUESS); //開始猜
	do {
	    user.respondQuestion(com); //玩家回答問題
	    com.replyHint(user); //電腦回答提示
	    if (com.getLastHint().equals("4A0B")) {
		Winner = user;
		break;
	    }
	    com.respondQuestion(user); //電腦回答問題
	    user.replyHint(com); //玩家回答提示
	    if (user.getLastHint().equals("4A0B")) {
		Winner = com;
		break;
	    }
	    com.thinkHint(user.getLastHint()); //電腦思考提示
	} while (com.getGuessPercent() != 0);

	if (com.getGuessPercent() == 0) { //如果結果有誤
	    com.talk(Talk.GUESS_FAIL);
	} else if (Winner != null) { //如果無誤，且勝利者存在(應該要存在才對)，輸出勝負和所猜次數
	    System.out.printf(StringClass.SHOW_CONTEST_WINNER, Winner.getName(), Winner.getGuessTimes());
	}

	Tools.delay(2000); //延遲兩秒
	return exit(user, com); //結束程式
    }

    /**
     * 一般猜數字的舞台。Asker為出題者；Respondent為猜題者。
     *
     * @param Asker 出題者
     * @param Respondent 猜題者
     * @return 傳回true則重新執行此方法；傳回false則回到選單(Menu)
     */
    public static boolean play(final Player Asker, final Player Respondent) { //若為true則重複執行；false則跳出
	Asker.talk(Talk.START); //開始
	Tools.delay(1500); //延遲1.5秒
	Asker.talk(Talk.FINISH); //完成出題
	Tools.delay(1000); //延遲一秒
	Asker.talk(Talk.GUESS); //開始猜
	do {
	    Respondent.respondQuestion(Asker); //回答問題
	    Asker.replyHint(Respondent); //回答提示
	    Respondent.thinkHint(Asker.getLastHint());
	} while (Asker.getLastHint().equals("4A0B") == false && Respondent.getGuessPercent() != 0);
	if (Respondent.getGuessPercent() == 0) { //如果結果有誤
	    Respondent.talk(Talk.GUESS_FAIL);
	} else { //如果無誤，輸出次數
	    Asker.talk(Respondent.getGuessTimes());
	}
	Tools.delay(2000); //延遲兩秒

	return exit(Asker, Respondent); //結束程式
    }

    /**
     * 關閉舞台。在使用者玩家優先說掰掰的條件下，讓兩位玩家互相說掰掰。
     *
     * @param player1 玩家1
     * @param player2 玩家2
     * @return 傳回true或false到play()或contest()方法
     */
    private static boolean exit(final Player player1, final Player player2) {
	System.out.print(StringClass.SHOW_GAME_EXIT);
	if (Tools.typeYorN()) { //若輸入y
	    return true; //傳回true。
	} else { //若輸入n
	    Player a, b;
	    /*
	     * 判斷玩家。由使用者玩家優先輸出。
	     */
	    if (player1 instanceof UserPlayer) {
		a = player1;
		b = player2;
	    } else {
		a = player2;
		b = player1;
	    }
	    a.talk(Talk.BYE);
	    Tools.delay(1000); //延遲一秒
	    b.talk(Talk.BYE);
	    Tools.delay(1000); //延遲一秒
	    return false; //傳回false，跳出menu的迴圈
	}
    }
}
