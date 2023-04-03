package com.example.demo.leetcode.i;

/**
 * Description: 746. 使用最小花费爬楼梯
 *  给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *  你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *  请你计算并返回达到楼梯顶部的最低花费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 *
 * @author Zeti
 * @date 2023/4/3 09:56
 */
public class DP_MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] c1 = {10, 15, 20};    // 15
        System.err.println(minCostClimbingStairs(c1));

        int[] c2 = {1,100,1,1,1,100,1,1,100,1}; // 6
        System.err.println(minCostClimbingStairs(c2));

    }

    // 输入：cost = [10,15,20]
    //输出：15
    //解释：你将从下标为 1 的台阶开始。
    //- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
    //总花费为 15 。
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i]=Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[cost.length];
    }

}
