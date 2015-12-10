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

import java.util.Scanner;

/**
 * 使用者玩家。繼承Player。
 *
 * @see Player
 * @see StringClass
 * @see Talk
 * @see Tools
 * @author 幻嵐
 */
public class UserPlayer extends Player {

    // -----物件變數-----
    private final Scanner sc = new Scanner(System.in);

    // -----建構子-----
    /**
     * 建構子(有多載)。傳入使用者玩家的名稱。
     *
     * @param inputName 傳入使用者玩家的名稱
     */
    public UserPlayer(final String inputName) {
	setName(inputName); //設定名稱
	setGuessTimes(0); //已猜次數歸零
    }

    /**
     * 建構子(有多載)。沒有參數為電腦助猜模式
     */
    public UserPlayer() { //建構子，無參數
	setName(StringClass.userName); //設定名稱
	setGuessTimes(-999); //設定已猜次數為負數
    }

    //-------------------------實作抽象-------------------------
    /**
     * 輸出語句
     *
     * @param sentence 傳入Talk特徵
     */
    @Override
    public void talk(final Talk sentence) { //輸出語句
	switch (sentence) {
	    case START:
		if (getGuessTimes() >= 0) {
		    System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.USER_ASKER_APPEAR));
		} else {
		    System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.USER_SERVICE));
		}
		break;
	    case FINISH:
		if (getGuessTimes() >= 0) {
		    System.out.print(StringClass.SHOW_MAKE_QUESTION);
		} else {
		    System.out.print(StringClass.SHOW_SERVICE_HELP);
		}
		sc.nextLine();
		break;
	    case GUESS:
		if (getGuessTimes() >= 0) {
		    System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.START_GUESS));
		}
		break;
	    case BYE:
		System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, getName(), Tools.getStringArrayRandom(StringClass.USER_BYE));
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
	System.out.printf(StringClass.SHOW_TALK_NAME, getName());
	String typeHint = sc.nextLine();
	while (checkHint(typeHint) == false) { //如果輸入有誤
	    System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, respondent.getName(), Tools.getStringArrayRandom(StringClass.COMPUTER_HINT_TYPE_ERROR));
	    System.out.printf(StringClass.SHOW_TALK_NAME, getName());
	    typeHint = sc.nextLine();
	}
	setLastHint(typeHint);
    }

    /**
     * 回答問題。用getLastGuess()方法來取得結果。
     *
     * @param asker 傳入回答對象(猜題者要猜出題者的數字)
     */
    @Override
    public void respondQuestion(final Player asker) {
	System.out.printf(StringClass.SHOW_TALK_NAME, getName());
	String inputNumber = sc.nextLine();
	while (checkAnswer(inputNumber) == false) { //如果輸入有誤
	    System.out.printf(StringClass.SHOW_TALK_NAME_SENTENCE, asker.getName(), Tools.getStringArrayRandom(StringClass.COMPUTER_HINT_TYPE_ERROR));
	    System.out.printf(StringClass.SHOW_TALK_NAME, getName());
	    inputNumber = sc.nextLine();
	}
	setGuessTimes(getGuessTimes() + 1); //已猜次數加一
	setLastGuess(inputNumber);
    }

    /**
     * 思考提示。USER沒必要。
     *
     * @param inputHint 接收提示
     */
    @Override
    public void thinkHint(final String inputHint) {
	//無動作
    }

    /**
     * 傳回猜中機率。USER無效。
     *
     * @return 傳回猜中機率
     */
    @Override
    public double getGuessPercent() {
	return -1; //無法計算猜中機率
    }
}
