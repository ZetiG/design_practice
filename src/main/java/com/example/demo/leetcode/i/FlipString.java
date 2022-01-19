package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 反转字符串
 * ps1: 输入：s = ["h","e","l","l","o"]    输出：["o","l","l","e","h"]
 *
 * @author Zeti
 * @date 2022/1/18 2:33 PM
 */
public class FlipString {

    public static void main(String[] args) {
        char[] s1 = {'h','e','l','l','o'};

        char[] s2 = {'H','a','n','n','a','h'};

        System.err.println(Arrays.toString(flip(s1)));
        System.err.println(Arrays.toString(flip(s2)));

    }


    // d1 循环length / 2次，首位和末尾替换
    public static char[] flip(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {

            char c1 = s[i];
            char c2 = s[s.length - 1 - i];

            if (c1 != c2) {
                s[s.length - 1 - i] = c1;
                s[i] = c2;
            }
        }
        return s;
    }

}
