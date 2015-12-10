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
 * 程式功能選單。
 *
 * @see StringClass
 * @see MenuMethod
 * @author Magic Len
 */
public class Menu {

    // -----類別方法-----
    /**
     * 顯示選單。
     */
    public static void show() {
	System.out.print(StringClass.SHOW_MENU_TOP);
	for (int i = 0; i < StringClass.SHOW_MENU_ITEMS.length; i++) {
	    System.out.printf(StringClass.SHOW_MENU_TYPE, i + 1, StringClass.SHOW_MENU_ITEMS[i]);
	}
	System.out.print(StringClass.SHOW_MENU_END);
	typeData(); //由使用者輸入資料
    }

    /**
     * 由使用者輸入資料(清單上面的號碼)。
     */
    private static void typeData() {
	final Scanner sc = new Scanner(System.in);
	System.out.print(StringClass.SHOW_TYPE_MENU_ITEM);
	String inputString = sc.nextLine(); //儲存使用者輸入的資料
	while (inputString.length() != 1 || inputString.charAt(0) < '1' || inputString.charAt(0) > StringClass.SHOW_MENU_ITEMS.length + 48) { //如果輸入有誤
	    System.out.print(StringClass.SHOW_TYPE_MENU_ITEM_ERROR);
	    inputString = sc.nextLine();
	}
	MenuMethod.methods(inputString.charAt(0) - 48); //呼叫Menu選單的方法，傳入引數為選單的選項值
    }
}
