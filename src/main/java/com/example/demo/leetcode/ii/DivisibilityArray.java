package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 2575. 找出字符串的可整除数组
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 *
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 *
 * @author Zeti
 * @date 2024/3/7 11:38
 */
public class DivisibilityArray {

    public static void main(String[] args) {
        String w1 = "998244353"; int m1 = 3;
        System.err.println(Arrays.toString(divisibilityArray(w1, m1))); // [1,1,0,0,0,1,1,0,0]

        String w2 = "1010"; int m2 = 10;
        System.err.println(Arrays.toString(divisibilityArray(w2, m2))); // [0,1,0,1]

        String w3 = "529282143571"; int m3 = 4;
        System.err.println(Arrays.toString(divisibilityArray(w3, m3))); // [0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0]

        String w4 = "86217457695827338571"; int m4 = 8;
        System.err.println(Arrays.toString(divisibilityArray(w4, m4))); // [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        String w5 = "8917171717276217174131"; int m5 = 17;
        System.err.println(Arrays.toString(divisibilityArray(w5, m5))); //


    }


    public static int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] ans = new int[s.length];
        long x = 0;
        for (int i = 0; i < s.length; i++) {
            x = (x * 10 + (s[i] - '0')) % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

}
