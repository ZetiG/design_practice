package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 2578. 最小和分割
 *
 * @author Zeti
 * @date 2023/10/9 10:17
 */
public class SplitNum {
    public static void main(String[] args) {
        int n1 = 4325;
        System.err.println(splitNum(n1));  // 24 + 35 = 59  25 + 34 = 59

        int n2 = 687;
        System.err.println(splitNum(n2));   // 68 + 7 = 75

        int n3 = 11;
        System.err.println(splitNum(n3));   // 1 + 1 = 2

    }

    public static int splitNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        Arrays.sort(cs);
        int a = 0;
        int b = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (i % 2 == 0) {
                a = a * 10 + (cs[i] - '0');
            } else {
                b = b * 10 + (cs[i] - '0');
            }
        }
        return a + b;
    }


}
