package com.example.demo.leetcode.ii;

/**
 * Description: 122. 买卖股票的最佳时机 II
 *  给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *  在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *  返回 你能获得的 最大 利润。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 
 * @author Zeti
 * @date 2023/4/7 16:32
 */
public class DP_MaxProfit {

    public static void main(String[] args) {
        int[] n1 = {7,1,5,3,6,4}; // 7
        System.err.println(maxProfit(n1));

        int[] n2 = {1,2,3,4,5}; // 4
        System.err.println(maxProfit(n2));

        int[] n3 = {7,6,4,3,1}; // 0
        System.err.println(maxProfit(n3));

    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res = res + (prices[i] - prices[i-1]);
            }
        }
        return res;
    }

}
