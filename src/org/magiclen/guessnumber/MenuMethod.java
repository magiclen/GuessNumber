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
 * 程式功能選單所搭配連結的方法。
 *
 * @see StringClass
 * @see Menu
 * @author Magic Len
 */
public class MenuMethod {

    // -----類別方法-----
    /**
     * 將從清單(Menu)傳來的選項值利用switch關鍵字套用至對應的方法。
     *
     * @param index 輸入清單選項值
     * @return 傳回0表示方法的結束
     * @see Player
     * @see ComputerPlayer
     * @see UserPlayer
     * @see Stage
     * @see StringClass
     * @see Menu
     * @see Tools
     */
    public static int methods(final int index) {
	/*
	 * 宣告變數參考至Player
	 */
	Player com, user;
	Player coms[] = new ComputerPlayer[2];

	/*
	 * 選擇要執行的方法
	 */
	switch (index) {
	    case 1: //電腦出題讓使用者猜
		do {
		    com = new ComputerPlayer(ComputerPlayer.creatOneComputer(), true);
		    user = new UserPlayer(StringClass.userName);
		} while (Stage.play(com, user));
		break;
	    case 2: //使用者出題讓電腦猜
		do {
		    com = new ComputerPlayer(ComputerPlayer.creatOneComputer(), false);
		    user = new UserPlayer(StringClass.userName);
		} while (Stage.play(user, com));
		break;
	    case 3: //電腦互猜
		String names[] = ComputerPlayer.creatTwoComputer();
		System.out.printf(StringClass.COMPUTERS_VS, names[0], names[1]);
		Tools.delay(1000); //延遲一秒
		int asker = 0; //設asker%2為出題者。非出題者為1-asker%2。
		do {
		    coms[0] = new ComputerPlayer(names[asker % 2], true);
		    coms[1] = new ComputerPlayer(names[1 - asker % 2], false);
		    System.out.printf(StringClass.SHOW_COMPUTERS_START, asker + 1, names[asker % 2]);
		    Tools.delay(1000); //延遲一秒
		    asker++;
		} while (Stage.play(coms[0], coms[1]));
		break;
	    case 4: //電腦助猜
		do {
		    com = new ComputerPlayer(ComputerPlayer.creatOneComputer(), false);
		    user = new UserPlayer();
		} while (Stage.play(user, com));
		break;
	    case 5: //人機大戰
		do {
		    com = new ComputerPlayer(ComputerPlayer.creatOneComputer());
		    user = new UserPlayer(StringClass.userName);
		} while (Stage.contest(user, com));
		break;
	    case 6: //猜數字玩法說明
		Explain.show();
		break;
	    case 7: //離開選單
		System.out.print(StringClass.SHOW_EXIT_MENU);
		if (Tools.typeYorN()) { //若輸入y
		    System.out.printf(StringClass.SHOW_EXIT, StringClass.userName); //顯示結束訊息
		    Tools.delay(1000); //延遲一秒
		    return 0; //結束方法
		} else { //若輸入n
		    System.out.println(StringClass.SHOW_WELCOME_BACK);
		}
	}
	Menu.show(); //顯示選單
	return 0; //結束方法
    }
}
