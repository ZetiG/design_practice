package com.example.demo.leetcode.ii;

/**
 * Description: 309. 最佳买卖股票时机含冷冻期 
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 1. 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
 *
 * @author Zeti
 * @date 2023/4/7 16:47
 */
public class DP_maxProfit_cool {

    public static void main(String[] args) {

        // 示例 1:
        //
        //输入: prices = [1,2,3,0,2]
        //输出: 3
        //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
        //示例 2:
        //
        //输入: prices = [1]
        //输出: 0

        //
        int[] n1 = {1,2,3,0,2}; // 3
        System.err.println(maxProfit(n1));

        int[] n2 = {1}; // 0
        System.err.println(maxProfit(n2));

        int[] n3 = {1,2}; // 1
        System.err.println(maxProfit(n3));

        int[] n4 = {1,2,4}; // 3
        System.err.println(maxProfit(n4));

    }

    public static int maxProfit(int[] prices) {
        // 0 无股票
        // 1 有股票
        // 2 冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;           // 第一天未持有，收益0；当天买且当天卖，未产生收益
        dp[0][1] = -prices[0];  // 第一天持有股票（买入）， 收益为负，负的金额为当天的股票价格
        dp[0][2] = 0;           // 第一天冷冻期，收益0；同一时间只能持有一份股票得知，当天冷冻期时，未有收益

        // 1,2,3,0,2
        for (int i = 1; i < prices.length; i++) {
            // 第i天，未持有股票；两种情况：1.昨天卖了，今天冷冻期；2.之前未持有，今天也未买入
            dp[i][0] = Math.max(dp[i-1][2], dp[i-1][0]);

            // 第i天，持有股票；两种情况：1.当天刚买入；2.之前买入未卖出
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);

            // 第i天，冷冻期；一种情况：1.昨天持有且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // 最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
    }


}
