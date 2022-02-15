package com.example.demo.leetcode;

/**
 * Description: 动态规划
 *
 * @author Zeti
 * @date 2022/2/10 3:45 PM
 */
public class DP {

    public static void main(String[] args) {
        dp2(9);
        dp2_2(9);

        dp3(new int[0][0], 5, 4);
    }

    /**
     * ps1: 多个数字组合求和，已知[1, 5, 11] 三个数字， 求组成15的最优解，用最少的数字
     * 解：result = 3,  (5+5+5=15)需要3位数字  (11+1+1+1+1=15)这里共需要5位数字组合，所以不满足题意最少
     */
    public static int dp1() {

        int[] arr = {2, 5, 7};
        int s = 27;

        //        int[] arr = {1, 5, 11};
        //        int s = 15;
        //
        //        int[] arr = {0, 1, 1};
        //        int s = 2;

        int[][] dp = new int[arr.length][s + 1];

        for (int i = 0; i < dp.length; i++) {

            for (int j = 1; j < s + 1; j++) {

                int val;

                if (arr[i] > 0 && j >= arr[i] && dp[i][j - arr[i]] != Integer.MAX_VALUE) {

                    val = dp[i][j - arr[i]] + 1;

                } else {
                    val = Integer.MAX_VALUE;
                }

                if (i > 0) {
                    val = Math.min(val, dp[i - 1][j]);
                }

                dp[i][j] = val;

            }
        }

        return dp[arr.length - 1][s] == Integer.MAX_VALUE ? -1 : dp[arr.length - 1][s];
    }

    /**
     * ps2: 给定整数n，代表台阶数，1次可以跨2个或者1个台阶，返回有多少种走法。
     * 举例：n=3，可以三次都跨一个台阶；也可以先跨2个台阶，再跨一个台阶；还可以先跨1一个台阶，再跨两个台阶。所以有三种方法。
     */
    public static int dp2(int n) {

        // 状态定义： 设 dp 为一维数组，其中 dp[i] 的值代表 斐波那契数列第 $i$ 个数字 。
        // 转移方程： dp[i + 1] = dp[i] + dp[i - 1]，即对应数列定义 f(n + 1) = f(n) + f(n - 1)；
        // 初始状态： dp[0] = 0, dp[1] = 1 ，即初始化前两个数字；
        // 返回值： dp[n]，即斐波那契数列的第 n 个数字。
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 1000000007 (1e9+7) 取余，保证数字不会溢出int范围，1000000007 是最大的质数
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        System.err.println(dp[n]);
        return dp[n];
    }

    public static int dp2_2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = tmp;
        }

        System.err.println(cur);
        return cur;
    }


    /**
     * 投资问题，m元钱, 投资给x个项目，受益最大化多少钱
     *      x	f1（x）	f2（x）	f3（x）	f4（x）
     *      0	0	    0	    0	    0
     *      1	11	    0	    2	    20
     *      2	12	    5	    10	    21
     *      3	13	    10	    30	    22
     *      4	14	    15	    32	    23
     *      5	15	    20	    40	    24
     *
     * @param arr1   收益比例
     * @param m     m元金钱
     * @param x     x个项目
     * @return      最大收益金额
     */
    public static int dp3(int[][] arr1, int m, int x) {
        //
        int[][] arr = {
        // m->j  0, 1, 2, 3, 4, 5
                {0,11,12,13,14,15},     // x->i 1
                {0,0,5,10,15,20},       // x->i 2
                {0,2,10,30,32,40},      // x->i 3
                {0,20,21,22,23,24}};    // x->i 4

        //
        int[][] dp = new int[x+1][m+1];

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j <= m; j++) {

                dp[i][j] = 0;
                for (int k = 0; k <= j; k++) {
                    if (dp[i][j] < arr[i-1][k]+dp[i-1][j-k])
                        dp[i][j] = arr[i-1][k]+dp[i-1][j-k];
                }
            }
        }
        System.err.println(dp[x][m]);
        return dp[x][m];
    }


}
