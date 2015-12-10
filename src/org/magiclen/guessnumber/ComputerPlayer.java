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

import java.util.ArrayList;

/**
 * 電腦玩家。繼承Player。
 *
 * @see Player
 * @see StringClass
 * @see Talk
 * @see Tools
 * @author Magic Len
 */
public final class ComputerPlayer extends Player {

    // -----物件變數-----
    private String correctAnswer; //正確答案
    private final ArrayList n_form = new ArrayList(); //猜數字表格

    // -----類別方法-----
    /**
     * 產生一個電腦玩家的名稱。
     *
     * @return 傳回產生出來的電腦玩家名稱
     */
    public static String creatOneComputer() {
	return Tools.getStringArrayRandom(StringClass.COMPUTER_NAMES);
    }

    /**
     * 產生兩個電腦玩家的名稱。
     *
     * @return 傳回產生出來的電腦玩家名稱陣列
     */
    public static String[] creatTwoComputer() {
	final String name[] = new String[2];
	name[0] = Tools.getStringArrayRandom(StringClass.COMPUTER_NAMES); //先產生第一個名稱
	do {
	    name[1] = Tools.getStringArrayRandom(StringClass.COMPUTER_NAMES); //先產生第二個名稱
	} while (name[0].equals(name[1])); //如果產生結果相同，就再產生一次第二個名稱
	return name;
    }

    // -----建構子-----
    /**
     * 建構子(有多載)。傳入電腦玩家的名稱和身份，決定是否要出題或是建立表格。
     *
     * @param inputName 電腦玩家的名稱
     * @param isAsker 電腦玩家的身份
     */
    public ComputerPlayer(final String inputName, final boolean isAsker) {
	setName(inputName); //設定名稱
	if (isAsker) { //如果是出題者
	    creatQuestion(); //出題
	} else { //如果是回答者
	    creatForm(); //建立表格
	    setGuessTimes(0); //已猜次數歸零
	}
    }

    /**
     * 建構子(有多載)。傳入電腦玩家的名稱。
     *
     * @param inputName 電腦玩家的名稱
     */
    public ComputerPlayer(final String inputName) { //建構子。只傳入電腦玩家的名稱
	setName(inputName); //設定名稱
	creatQuestion(); //出題
	creatForm(); //建立表格
	setGuessTimes(0); //已猜次數歸零
    }

    // -----物件方法-----
    /**
     * 輸出語句。
     *
     * @param sentence 傳入Talk特徵
     */
    @Override //覆寫
    public void talk(final Talk sentence) {
	switch (sentence) {
	    case START:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.COMPUTER_ASKER_APPEAR));
		break;
	    case FINISH:
		System.out.printf(StringClass.SHOW_COMPUTER_FINISH_PROBLEM, getName());
		break;
	    case GUESS:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.START_GUESS));
		break;
	    case GUESS_FAIL:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.COMPUTER_GUESS_FAIL));
		break;
	    case BYE:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.COMPUTER_BYE));
		break;
	    case HINT:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), getLastHint());
		break;
	    case RESPOND:
		Tools.delay(1000); //延遲一秒
		System.out.printf(StringClass.SHOW_TALK_NAME, getName());
		System.out.printf(Tools.getStringArrayRandom(StringClass.COMPUTER_GUESS), getLastGuess());
		System.out.println(); //換行
		Tools.delay(1000); //延遲一秒
		break;
	    case HELP_GUESS:
		System.out.printf(StringClass.SHOW_TALK_NAME, getName());
		System.out.printf(Tools.getStringArrayRandom(StringClass.COMPUTER_HELP_GUESS), getLastGuess(), getGuessPercent() * 100);
		System.out.println(); //換行
		break;
	}
    }

    /**
     * 回答提示。用getLastHint()方法來取得結果。
     *
     * @param respondent 傳入提示對象(出題者要提示猜題者)
     */
    @Override
    public void replyHint(final Player respondent) {
	if (checkAnswer(respondent.getLastGuess())) { //若回答格式正確
	    setLastHint(compareHint(respondent.getLastGuess(), correctAnswer));  //儲存XAXB
	    talk(Talk.HINT);
	} else { //若回答格式錯誤
	    setLastHint("");//清除上一次的紀錄
	}
    }

    /**
     * 回答問題。用getLastGuess()方法來取得結果。
     *
     * @param asker 傳入回答對象(猜題者要猜出題者的數字)
     */
    @Override
    public void respondQuestion(final Player asker) {
	setGuessTimes(getGuessTimes() + 1); //已猜次數加一
	setLastGuess(n_form.get((int) (Math.random() * n_form.size())).toString());
	if (asker.getGuessTimes() >= 0) {
	    talk(Talk.RESPOND);
	} else {
	    talk(Talk.HELP_GUESS);
	}
    }

    /**
     * 思考提示。COM需要藉此方法來進行數字表格的整理。
     *
     * @param inputHint 接收提示
     */
    @Override
    public void thinkHint(final String inputHint) {
	if (checkHint(inputHint)) { //若提示格式正確
	    for (int i = 0; i < n_form.size(); i++) {
		if (compareHint(n_form.get(i).toString(), getLastGuess()).equals(inputHint) == false) { //若XAYB結果不相同，則刪除該表格項目
		    n_form.remove(i);
		    i--;
		}
	    }
	}
    }

    /**
     * 傳回猜中機率。只有COM有效。當傳回0時表示輸入的提示有問題，導致數字表的內容全部不符。
     *
     * @return 傳回猜中機率
     */
    @Override
    public double getGuessPercent() { //傳回猜中機率
	if (n_form.size() > 0) {
	    return Math.pow(n_form.size(), -1); //目前數量的倒數
	} else { //若為零
	    return 0;
	}
    }

    /**
     * 建立表格(共5040個項目，每個字串項目內存放一組4個數皆不同的數字)
     */
    private void creatForm() {
	for (int a = 0; a <= 9; a++) {
	    for (int b = 0; b <= 9; b++) {
		if (b == a) {
		    continue;
		}
		for (int c = 0; c <= 9; c++) {
		    if (c == a || c == b) {
			continue;
		    }
		    for (int d = 0; d <= 9; d++) {
			if (d == a || d == b || d == c) {
			    continue;
			}
			n_form.add(String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d)); //存入陣列
		    }
		}
	    }
	}
    }

    /**
     * 設定正確答案。
     *
     * @param intputCorrectAnswer 輸入整數型態的正確答案，將轉為字串儲存。
     */
    private void setCorrectAnswer(final int intputCorrectAnswer) {
	/*
	 * 判斷輸入值的正確性
	 * 1.必須為四位數或三位數
	 * 2.數字不能重複
	 */
	boolean isCorrect = true; //假設輸入值為正確格式
	if (intputCorrectAnswer / 100 > 0 && intputCorrectAnswer / 100 < 100) { //若是四位數或三位數(從百位數算起要為1~99)
	    String bufferInt = String.valueOf(intputCorrectAnswer); //將輸入值轉成字串存入bufferInt暫存
	    for (int i = 0; i < bufferInt.length(); i++) {
		if (bufferInt.length() == 3 && bufferInt.charAt(i) == '0') { //三位數前面必補零，故若三位數中有出現零則為錯誤格式
		    isCorrect = false;
		    break;
		}
		for (int k = i + 1; k < bufferInt.length(); k++) {
		    if (bufferInt.charAt(i) == bufferInt.charAt(k)) { //若找到相同值
			isCorrect = false;
			i = bufferInt.length() - 1;
			break;
		    }
		}
	    }
	    if (bufferInt.length() == 4) { //若為四位數
		correctAnswer = "";
	    } else { //若不是四位數(三位數)
		correctAnswer = "0";
	    }
	} else { //若不是四位數
	    isCorrect = false;
	}
	if (isCorrect == true) { //若格式正確
	    correctAnswer += String.valueOf(intputCorrectAnswer); //將輸入值轉成字串正式存入correctAnswer暫存
	} else { //若格式錯誤
	    correctAnswer = "-答案格式錯誤-";
	}
    }

    /**
     * 轉換提示。
     *
     * @param inputAnswer 回答
     * @param referenceAnswer 參考答案
     * @return 輸出依據參考答案和回答所得的XAYB提示
     */
    private String compareHint(final String inputAnswer, final String referenceAnswer) {
	int a = 0, b = 0; //儲存A,B數量
	for (int i = 0; i < 4; i++) {
	    for (int k = 0; k < 4; k++) {
		if (inputAnswer.charAt(i) == referenceAnswer.charAt(k)) {
		    if (i == k) {
			a++;
		    } else {
			b++;
		    }
		}
	    }
	}
	return a + "A" + b + "B";

    }

    /**
     * 出題。
     */
    private void creatQuestion() {
	/*
	 * 出一組4個數字皆不同的整數四位數或三位數(首數為0)
	 */
	final int buffer[] = new int[4];
	buffer[0] = (int) (Math.random() * 10); //存入0~9亂數
	int result = buffer[0] * 1000; //結果
	for (int i = 1; i < 4; i++) {
	    buffer[i] = (int) (Math.random() * 10); //存入0~9亂數

	    boolean isRepeat = false;
	    for (int k = 0; k < i; k++) {
		if (buffer[i] == buffer[k]) { //若重複
		    i--;
		    isRepeat = true;
		    break;
		}
	    }

	    if (isRepeat == false) { //若沒有重複
		result += (int) (buffer[i] * Math.pow(10, 3 - i));
	    }
	}
	setCorrectAnswer(result); //設定正確答案
    }
}
