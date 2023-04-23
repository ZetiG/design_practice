package com.example.demo.leetcode.ii;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/4/22 15:50
 */
public class DP_01Backpack {

    public static void main(String[] args) {
        int w = 4;
        int[] wt = {2, 1, 3}, val = {4, 2, 3};
        System.err.println(t1(w, wt, val));
    }

    // N = 3, W = 4
    //wt = [2, 1, 3]
    //val = [4, 2, 3]
    // 返回可容纳的最大价值
    //
    // 2
    // 1
    // 3
    public static int t1(int w, int[] wt, int[] val) {
        int[][] dp = new int[wt.length+1][w+1]; // dp[i][j]表示 前i个物品(任意数量)中 容量为j时的最大价值
        dp[0][0] = 0;
        // 第i个物品
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i-1] > j) {
                    // 当前i物品重量大于j，不选
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[wt.length][w];
    }

}
