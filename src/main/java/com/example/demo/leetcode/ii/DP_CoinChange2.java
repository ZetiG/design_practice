package com.example.demo.leetcode.ii;


/**
 * Description: 518. 零钱兑换 II
 *
 *  给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *  请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *  假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 * @author Zeti
 * @date 2024/3/25 10:15
 */
public class DP_CoinChange2 {
    public static void main(String[] args) {
        // coins = [], amount = 11
        // 输出：3
        // 解释：11 = 5 + 5 + 1
        int[] c1 = {1, 2, 5};
        int a1 = 11;
        System.err.println(coinChange(c1, a1)); // 3


    }


    //   0  1 2 3 4 5 6 7 8 9 10 11
    // 0 0
    // 1    1 2
    // 2    1 1
    // 5    1 1
    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i < coin) {
                    continue;
                }
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[amount];
    }

}
