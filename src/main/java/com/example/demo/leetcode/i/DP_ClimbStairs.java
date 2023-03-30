package com.example.demo.leetcode.i;

/**
 * Description: 70. 爬楼梯
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author Zeti
 * @date 2023/3/30 17:02
 */
public class DP_ClimbStairs {

    public static void main(String[] args) {
        int n1 = 2;
        System.err.println(climbStairs(n1));

        int n2 = 3;
        System.err.println(climbStairs(n2));

    }

    // 递推方程: fn = f(n-1) + f(n-2)
    // 边界：f(0) = 1  f(1) = 1
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
