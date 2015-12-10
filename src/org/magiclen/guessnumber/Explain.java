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
 * 猜數字玩法說明。
 *
 * @see StringClass
 * @author Magic Len
 */
public class Explain {

    // -----類別方法-----
    /**
     * 顯示玩法說明。
     */
    public static void show() {

	System.out.println("　　猜數字可以算是一種益智類小遊戲，一般兩個人玩。遊戲規則也很簡單，但可以考驗人的耐心和細心。");
	type_Enter();
	System.out.println("　　規則就是玩家兩人中某方(以下以甲方代稱)先在心裡想出一組由四個皆不同的數所組成的四位數字(例如：1234、5678、0653)，且每位數的數字範圍都在0到9。而另一方(以下以乙方代稱)則要猜出甲方心裡所想的數字。甲方需以XAYB(例如1A2B)的形式提示乙方猜的答案。XA中的X表示數值正確且位置也正確的數字數量；YB中的Y表示數值正確但位置不正確的數字數量。例如：假設甲方心中的數字為1357，而乙方所猜的數為1234，則甲方要回答提示1A1B給乙方，因為甲方的1與乙方的1位置正確，但甲方的3與乙方的3位置不正確。下面舉個完整的例子↓");
	type_Enter();
	System.out.println("假設乙要猜甲的數字，以下是他們的對話內容：");
	System.out.println("乙：1234");
	System.out.println("甲：0A0B(此時我們可以確定這個4位數字絕對不會是1、2、3、4所組成。)");
	System.out.println("乙：5678(因此繼續猜5678)");
	System.out.println("甲：0A3B");
	System.out.println("乙：7865");
	System.out.println("甲：3A0B");
	System.out.println("乙：7860");
	System.out.println("甲：4A0B");
	System.out.println("直到甲方說出4A0B才算乙方真的猜中甲方的數字！");
	type_Enter();
	System.out.println("怎麼樣？聽起來很難，可是玩久了之後很快就能上手了！");
	type_Enter();
	System.out.println("如果您已經很熟悉猜數字的規則，可以試試看更難的玩法↓");
	type_Enter();
	System.out.println("甲方和乙方同時在心裡想一組數字，接著兩方互猜，最先猜出對方心中數字的就是勝利的一方！");
	type_Enter();
	System.out.println("本猜數字遊戲程式提供了單方面「電腦出題讓使用者猜」、「使用者出題讓電腦猜」和雙方面「使用者和電腦互猜」(也就是選單中的人機大戰)的遊戲模式，另外也有電腦助猜功能。如果您覺得這個遊戲不錯，歡迎造訪我們的網站—MagicLen！");
	type_Enter();
	System.out.println("http://magiclen.org/");
	type_Enter();
    }

    /**
     * 按下Enter繼續閱讀。
     *
     */
    private static void type_Enter() {
	final Scanner sc = new Scanner(System.in);
	System.out.printf(StringClass.SHOW_TYPE_ENTER);
	sc.nextLine();
	System.out.println(); //換行
    }
}
