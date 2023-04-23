package com.example.demo.leetcode.ii;

/**
 * Description: 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/22 16:59
 */
public class DP_CoinChange {
    public static void main(String[] args) {
        int[] c1 = {1, 2, 5};
        int a1 = 11;
        System.err.println(coinChange(c1, a1)); // 3

        int[] c2 = {2};
        int a2 = 3;
        System.err.println(coinChange(c2, a2)); // -1

        int[] c3 = {1};
        int a3 = 0;
        System.err.println(coinChange(c3, a3)); // 0

        int[] c4 = {2};
        int a4 = 1;
        System.err.println(coinChange(c4, a4)); // -1

        int[] c5 = {2,5,10,1};
        int a5 = 27;
        System.err.println(coinChange(c5, a5)); // 4



    }

    //    1  2  3  4  5 ... 11
    // 0  0  0  0  0  0 ... 0
    // 1  1  2  3  4  5 ... 11
    // 2  1  1  2  2  3 ...
    // 5
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length+1][amount+1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        // i:需要凑成的目标金额
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount] > 0 && dp[coins.length][amount] != Integer.MAX_VALUE-1 ? dp[coins.length][amount] : -1;
    }

}
