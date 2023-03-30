package com.example.demo.leetcode.i;

/**
 * Description: 121. 买卖股票的最佳时机 
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 *
 * @author Zeti
 * @date 2023/3/30 17:19
 */
public class DP_MaxProfit {

    public static void main(String[] args) {
        int[] s1 = {7,1,5,3,6,4};
        System.err.println(maxProfit(s1));

        int[] s2 = {7,6,4,3,1};
        System.err.println(maxProfit(s2));

    }

    // 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    // 递推方程：f(n) = max( f(n-1) ,  [price(n)-minPrice(n-1)]  ))
    public static int maxProfit(int[] prices) {
        int minBuy = prices[0];
        prices[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            prices[i] = Math.max(prices[i] - minBuy, prices[i-1]);
        }
        return prices[prices.length-1];
    }


}
