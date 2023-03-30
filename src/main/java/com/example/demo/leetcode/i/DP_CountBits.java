package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 338. 比特位计数
 *  给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * @author Zeti
 * @date 2023/3/30 17:43
 */
public class DP_CountBits {
    public static void main(String[] args) {
        int n1= 2;  // [0,1,1]
        // 0    0000
        // 1    0001
        // 2    0010
        System.err.println(Arrays.toString(countBits(n1)));

        int n2= 5;  // [0,1,1,2,1,2]
        // 0    0000
        // 1    0001
        // 2    0010
        // 3    0011
        // 4    0100
        // 5    0101
        System.err.println(Arrays.toString(countBits(n2)));

    }

    public static int[] countBits(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i % 2 + dp[i / 2];
        }
        return dp;
    }

}
