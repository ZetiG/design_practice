package com.example.demo.leetcode.ii;

/**
 * Description: 312. 戳气球
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或
 * i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * @author Zeti
 * @date 2024/11/11 14:48
 */
public class MaxCoins {

    public static void main(String[] args) {

        int[] n1 = {3,1,5,8};
        System.err.println(maxCoins(n1));   // 167

        int[] n2 = {3,1,5};
        // 3 1 5    3 + 5 + 5 = 13
        // 3 5 1    3 + 5 + 1 = 9
        // 1 3 5    15 + 15 + 5 = 35
        // 1 5 3    15 + 15 + 3 = 33
        // 5 1 3    5 + 3 + 3 = 11
        // 5 3 1    5 + 3 = 1 = 9
        System.err.println(maxCoins(n2));   // 35

        int[] n3 = {1,5};
        System.err.println(maxCoins(n3));   // 10

    }

    public static int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 1; i < newNums.length - 1; i++) {
            newNums[i] = nums[i - 1];
        }

        // 3,1,5,8
        int[][] dp = new int[newNums.length][newNums.length];

        // i是区间右边界，j是区间左边界，k是区间内最后一个戳破的气球
        for (int i = 0; i < newNums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j + 1; k < i; k++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][k] + dp[k][i] + newNums[j] * newNums[k] * newNums[i]);
                }
            }
        }

        // 填表
//        for (int i = nums.length; i >= 0; i--) { // i是左边界
//            for (int j = i + 1; j <= nums.length + 1; j++) { // j是右边界
//                // 枚举k作为最后一个戳破的气球
//                for (int k = i + 1; k < j; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
//                }
//            }
//        }
        return dp[0][newNums.length - 1];
    }



}