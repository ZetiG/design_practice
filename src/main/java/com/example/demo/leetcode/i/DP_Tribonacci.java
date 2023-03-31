package com.example.demo.leetcode.i;

/**
 * Description: 1137. 第 N 个泰波那契数
 *  泰波那契序列Tn定义如下：
 *  T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *  给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-th-tribonacci-number
 * 
 * @author Zeti
 * @date 2023/3/31 14:00
 */
public class DP_Tribonacci {

    public static void main(String[] args) {
        int n1 = 4; // 4
        System.err.println(tribonacci(n1));

        int n2 = 15; // 3136
        System.err.println(tribonacci(n2));

        int n3 = 25; // 1389537
        System.err.println(tribonacci(n3));

    }

    // 泰波那契数
    // Tn+3 = Tn + Tn+1 + Tn+2
    // 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103


    // DP-优化空间
    public static int tribonacci(int n) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n <= 2) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i%3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n%3];
    }

    // DP
    public static int tribonacci_dp(int n) {
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n <= 2) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

}
