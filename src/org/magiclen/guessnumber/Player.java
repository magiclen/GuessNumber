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
 * 玩家抽象類別，被ComputerPlayer、UserPlayer繼承。
 *
 * @see StringClass
 * @see ComputerPlayer
 * @see UserPlayer
 * @see Tools
 * @author Magic Len
 */
public abstract class Player {

    // -----物件變數-----
    private String name; //玩家名稱
    private int respondTimes; //已猜次數
    private String last_guess; //上一次猜的數
    private String last_hint; //上一次的提示

    // -----物件方法-----
    /**
     * 取得玩家名稱。
     *
     * @return 玩家名稱
     */
    public final String getName() {
	return name;
    }

    /**
     * 設定玩家名稱。
     *
     * @param inputName 傳入名稱
     */
    public final void setName(final String inputName) {
	name = inputName;
    }

    /**
     * 設定已猜次數。
     *
     * @param inputNum 傳入猜數字的次數
     */
    public final void setGuessTimes(final int inputNum) {
	respondTimes = inputNum;
    }

    /**
     * 傳回猜數字的次數。每次使用respondQuestion()方法，次數都會加一。若次數為負數，拿來當作特徵，「電腦助猜」模式使用。
     *
     * @return 傳回猜數字的次數
     */
    public final int getGuessTimes() {
	return respondTimes;
    }

    /**
     * 設定上一次猜的數。
     *
     * @param inputString 傳入猜的數
     */
    public final void setLastGuess(final String inputString) {
	last_guess = inputString;
    }

    /**
     * 取得上一次使用respondQuestion()方法或setLastGuess()方法所猜的數字。
     *
     * @return 傳回上一次猜的數
     */
    public final String getLastGuess() {
	return last_guess;
    }

    /**
     * 設定上一次回答的提示。
     *
     * @param inputString 傳入猜的數
     */
    public final void setLastHint(final String inputString) {
	last_hint = inputString;
    }

    /**
     * 取得上一次使用replyHint()方法或是setLastHint()方法所得到的提示。
     *
     * @return 傳回上一次猜的數
     */
    public final String getLastHint() {
	return last_hint;
    }

    /**
     * 檢查回答(1234、5678等4個位數值皆不同的數字)。
     *
     * @param inputString 傳入要檢查的字串
     * @return 若為正確的格式傳回true；否則傳回false
     */
    public boolean checkAnswer(final String inputString) {
	if (inputString.length() == 4) { //若為四位數
	    for (int i = 0; i < 4; i++) {
		if (Character.isDigit(inputString.charAt(i)) == false) { //如果不是數字
		    return false;
		}
		for (int k = i + 1; k < 4; k++) {
		    if (inputString.charAt(i) == inputString.charAt(k)) { //若有重複
			return false;
		    }
		}
	    }
	    if (Character.isDigit(inputString.charAt(3)) == false) { //如果不是數字
		return false;
	    }
	} else { //若不為四位數
	    return false;
	}
	return true;
    }

    /**
     * 檢查提示(XAYB。且X+Y需小於等於4！)。
     *
     * @param inputString 傳入要檢查的字串
     * @return 若為正確的格式傳回true；否則傳回false
     */
    public boolean checkHint(final String inputString) {
	if (inputString.length() == 4 && inputString.charAt(1) == 'A' && inputString.charAt(3) == 'B' && inputString.charAt(0) >= '0' && inputString.charAt(0) <= '4' && inputString.charAt(2) >= '0' && inputString.charAt(2) <= '4') {
	    if (inputString.charAt(0) + inputString.charAt(2) - 96 > 4) { //XAYB。A與B相加需小於等於四！
		return false;
	    }
	} else {
	    return false;
	}
	return true;
    }

    /**
     * 共同的說話方法(多載)。用於遊戲結束時顯示Respondent所猜的次數。
     *
     * @param sentence 傳入猜題次數
     */
    public void talk(final int sentence) {
	final String congratulationMessage; //儲存遊戲結束時電腦玩家要向使用者顯示的句子
	if (sentence < 5) {
	    congratulationMessage = Tools.getStringArrayRandom(StringClass.SHOW_GUESS_TIMES_BEST);
	} else if (sentence < 8) {
	    congratulationMessage = Tools.getStringArrayRandom(StringClass.SHOW_GUESS_TIMES_GOOD);
	} else {
	    congratulationMessage = Tools.getStringArrayRandom(StringClass.SHOW_GUESS_TIMES_BAD);
	}
	System.out.printf(StringClass.SHOW_TALK_NAME, getName());
	System.out.printf(congratulationMessage, sentence);
    }

    // -----抽象方法(需實作)-----
    /**
     * 說話(多載)。
     *
     * @param sentence 傳入句子特徵(enum)
     * @see Talk
     */
    public abstract void talk(final Talk sentence);

    /*
     * 若為出題者(Asker)。
     * 1.COM需要出題(creatQuestion())；User不需藉由程式邏輯來出題。
     * 2.COM需要接收回答者(Respondent)的答案，並且給提示輸出XAXB；USER憑自己大腦來輸入XAXB。
     */
    /**
     * 回答提示。用getLastHint()方法來取得結果。
     *
     * @param respondent 傳入提示對象(出題者要提示猜題者)
     */
    public abstract void replyHint(final Player respondent);

    /*
     * 若為回答者(Respondent)。
     * 1.COM需要先建出完整的猜數字表(creatForm())；USER不需建表。
     * 2.COM需接收出題者的提示刪除表格不可能的項目；USER只需在自己的大腦內工作刪除不可能的項目。
     * 3.COM需從表格中亂數取出一個可能的回答；USER從自己的大腦內取一個可能的數出來回答。
     */
    /**
     * 回答問題。用getLastGuess()方法來取得結果。
     *
     * @param asker 傳入回答對象(猜題者要猜出題者的數字)
     */
    public abstract void respondQuestion(final Player asker);

    /**
     * 思考提示。COM需要藉此方法來進行數字表格的整理；USER不一定要將此方法實作出來。
     *
     * @param inputHint 接收提示
     */
    public abstract void thinkHint(String inputHint);

    /**
     * 傳回猜中機率。只有COM有效，USER永遠傳回負值。當傳回0時表示輸入的提示有問題，導致數字表的內容全部不符。
     *
     * @return 傳回猜中機率
     */
    public abstract double getGuessPercent();
}
