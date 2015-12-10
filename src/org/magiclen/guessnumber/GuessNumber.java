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
 * <p>
 * 猜數字文字版！GuessNumber。
 * </p>
 * <p>
 * 這是文字版的猜數字遊戲，有分以下幾種玩法模式：
 * </p>
 * <ul>
 * <li>
 * 電腦出題使用者猜
 * </li>
 * <li>
 * 使用者出題電腦猜
 * </li>
 * <li>
 * 電腦互猜(教學及測試用)
 * </li>
 * <li>
 * 電腦助猜
 * </li>
 * <li>
 * 人機大戰
 * </li>
 * </ul>
 *
 * @see StringClass
 * @see Menu
 * @author Magic Len
 */
public class GuessNumber {

    // -----類別方法-----
    /**
     * 程式進入點。
     *
     * @param args 若有輸入一筆字串資料就直接拿來作為使用者名稱
     * @see MenuMethod
     */
    public static void main(final String[] args) {
	welcomeMessage();  //顯示歡迎訊息

	// 判斷是否有輸入args，若有則跳過讓使用者輸入名稱的步驟，直接作為使用者名稱
	if (args.length == 1) { //若args有一筆資料
	    StringClass.userName = args[0];
	} else {
	    setUserName();
	}
	System.out.printf(StringClass.SHOW_USER_WELCOME, StringClass.userName);

	// 顯示清單。程式進入點結束任務了
	Menu.show();
    }

    /**
     * 設定使用者名稱。(若args沒有輸入則不會被執行)。
     */
    private static void setUserName() {
	final Scanner sc = new Scanner(System.in);

	System.out.print(StringClass.SHOW_TYPE_USER_NAME);
	String userName = sc.nextLine();
	while (userName.equals("") || userName.charAt(0) == ' ') { //如果沒有輸入，就一直讓使用者輸入名稱
	    System.out.print(StringClass.SHOW_TYPE_USER_NAME_ERROR);
	    userName = sc.nextLine();
	}
	StringClass.userName = userName;
    }

    /**
     * 顯示歡迎訊息。
     */
    private static void welcomeMessage() {
	System.out.print(StringClass.SHOW_WELCOME);
    }
}
