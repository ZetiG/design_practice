package com.example.demo.leetcode.i;

/**
 * Description: 509. 斐波那契数
 *  斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fibonacci-number
 *
 * @author Zeti
 * @date 2023/3/31 11:33
 */
public class DP_Fib {
    public static void main(String[] args) {
        int n1 = 1;
        System.err.println(fib(n1));

        int n2 = 5;
        System.err.println(fib(n2));

        int n3 = 8;
        System.err.println(fib(n3));

    }

    // 通项公式; 斐波那契数 F(n) 是齐次线性递推，根据递推方程
    public static int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    // 0  1  1  2  3  5  8
    //  f(n) = f(n-1) + f(n-2)
    public static int fib_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
