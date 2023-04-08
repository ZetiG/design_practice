package com.example.demo.leetcode.ii;

/**
 * Description: 714. 买卖股票的最佳时机含手续费
 *  给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 *
 * @author Zeti
 * @date 2023/4/8 15:54
 */
public class DP_MaxProfit_price {

    public static void main(String[] args) {
        int[] n1 = {1, 3, 2, 8, 4, 9};
        int f1 = 2;
        System.err.println(maxProfit(n1, f1));  // 8

        int[] n2 = {1,3,7,5,10,3};
        int f2 = 3;
        System.err.println(maxProfit(n2, f2));  // 6

        int[] n3 = {1,3,7,5,10,3};
        int f3 = 3;
        System.err.println(maxProfit(n3, f3));  // 6

        int[] n4 = {9,8,7,1,2};
        int f4 = 3;
        System.err.println(maxProfit(n4, f4));  // 0


    }

    // DP
    public static int maxProfit(int[] prices, int fee) {
        int res = 0;    // 最大收益
        int buy = -prices[0];   // buy为收益金额，初次购买，则收益为负

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, buy + prices[i] - fee); // buy + prices[i] - 2 代表当前收益，
            buy = Math.max(buy, res - prices[i]);   // 当到达某个点收益最高时卖出，可保证收益最大化
        }
        return res;
    }

}
