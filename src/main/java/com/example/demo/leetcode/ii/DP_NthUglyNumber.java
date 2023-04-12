package com.example.demo.leetcode.ii;

/**
 * Description: 264. 丑数 II
 *  给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *  丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ugly-number-ii
 *
 * @author Zeti
 * @date 2023/4/12 15:31
 */
public class DP_NthUglyNumber {

    public static void main(String[] args) {
        int n1 = 10;
        System.err.println(nthUglyNumber(n1));  // 12

        int n2 = 1;
        System.err.println(nthUglyNumber(n2));  // 1

        int n3 = 100;
        System.err.println(nthUglyNumber(n3));  // 1536

    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        // 定义3个指针
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i< n; i++) {
            int u2 = dp[idx2] * 2;
            int u3 = dp[idx3] * 3;
            int u5 = dp[idx5] * 5;

            // 每次计算取较小值，作为本次计算结果，
            int num = Math.min(u2, Math.min(u3, u5));
            dp[i] = num;
            if (num == u2) idx2++;  // 哪个指针计算出来的结果，哪个指针右移
            if (num == u3) idx3++;
            if (num == u5) idx5++;
        }
        return dp[n-1];
    }


}
