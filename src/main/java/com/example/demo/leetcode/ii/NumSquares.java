package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/perfect-squares
 *
 * @author Zeti
 * @date 2023/5/26 15:06
 */
public class NumSquares {
    public static void main(String[] args) {
        int n1 = 12;
        System.err.println(numSquares(n1)); // 3 => 12 = 4 + 4 + 4

        int n2 = 13;
        System.err.println(numSquares(n2)); // 2  => 13 = 4 + 9

    }

    // DP—完全背包
    public static int numSquares(int n) {
        // 完全背包 装满背包最小物品个数
        // 开平方最大整数
        int max = (int)Math.sqrt(n);
        // 凑成 j 的完全平方数的最小数量为 dp[j]
        int[] dp = new int[n + 1];
        // 初始化：除了第一个元素，其他下标元素初始化为最大值，防止获取后面值时被小值覆盖
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 平方数【物品重量】
        for(int i = 1; i <= max; i++){
            // 平方数
            int weight = i * i;
            // 背包容量
            for(int j = weight; j <= n; j++){
                // 如果数量为初始值直接跳过
                if(dp[j - weight] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - weight] + 1);
                }
            }
        }
        return dp[n];
    }

    // 四平方和定理
    // 四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和。这给出了本题的答案的上界。
    public static int numSquares2(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    private static boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    private static boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }


}
