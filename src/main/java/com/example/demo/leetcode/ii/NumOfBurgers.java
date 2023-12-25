package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1276. 不浪费原料的汉堡制作方案
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 *  1. 巨无霸汉堡：4 片番茄和 1 片奶酪
 *  2. 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 *
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 *
 * @author Zeti
 * @date 2023/12/25 09:19
 */
public class NumOfBurgers {

    public static void main(String[] args) {
        int t1 = 16, c1 = 7;
        System.err.println(numOfBurgers(t1, c1));   // [1,6]

        int t2 = 17, c2 = 4;
        System.err.println(numOfBurgers(t2, c2));   // []

        int t3 = 4, c3 = 17;
        System.err.println(numOfBurgers(t3, c3));   // []

        int t4 = 0, c4 = 0;
        System.err.println(numOfBurgers(t4, c4));   // [0,0]

        int t5 = 2, c5 = 1;
        System.err.println(numOfBurgers(t5, c5));   // [0,1]


    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices*2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }

        List<Integer> integers = new ArrayList<>();
        integers.add(tomatoSlices/2 - cheeseSlices);
        integers.add(cheeseSlices*2 - tomatoSlices/2);
        return integers;
    }

}
