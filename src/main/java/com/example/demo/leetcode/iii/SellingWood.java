package com.example.demo.leetcode.iii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2312. 卖木头块
 * 给你两个整数 m 和 n ，分别表示一块矩形木块的高和宽。同时给你一个二维整数数组 prices ，其中 prices[i] = [hi, wi, pricei] 表示你可以以 pricei 元的价格卖一块高为 hi 宽为 wi
 * 的矩形木块。
 *
 * 每一次操作中，你必须按下述方式之一执行切割操作，以得到两块更小的矩形木块：
 *      沿垂直方向按高度 完全 切割木块，或
 *      沿水平方向按宽度 完全 切割木块
 *      在将一块木块切成若干小木块后，你可以根据 prices 卖木块。你可以卖多块同样尺寸的木块。你不需要将所有小木块都卖出去。你 不能 旋转切好后木块来交换它的高度值和宽度值。
 *
 * 请你返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数。
 * 注意你可以切割木块任意次。
 *
 * @author Zeti
 * @date 2024/3/20 09:20
 */
public class SellingWood {

    public static void main(String[] args) {

        int m1 = 3, n1 = 5;
        int[][] p1 = {{1,4,2}, {2,2,7}, {2,1,3}};
        System.err.println(sellingWood(m1, n1, p1));   // 19

        int m2 = 4, n2 = 6;
        int[][] p2 = {{3,2,10}, {1,4,2}, {4,1,3}};
        System.err.println(sellingWood(m2, n2, p2));   // 32

        int m3 = 9, n3 = 7;
        int[][] p3 = {{4,3,2}, {5,3,16}, {4,4,18}, {8,7,6}};
        System.err.println(sellingWood(m3, n3, p3));   // 54

    }

    public static int sellingWood(int m, int n, int[][] prices) {
        // 构建哈希表 memo 用于存储已经计算过的结果
        Map<String, Integer> memo = new HashMap<>();
        return dfs(m, n, prices, memo);
    }

    private static int dfs(int m, int n, int[][] prices, Map<String, Integer> memo) {
        // 如果 memo 中已经有了该状态的计算结果，则直接返回
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxProfit = 0;
        // 遍历价格数组 prices 中的每一个价格
        for (int[] price : prices) {
            int hi = price[0];
            int wi = price[1];
            int pi = price[2];

            // 判断是否能够按照该价格进行切割
            if (hi <= m && wi <= n) {
                // 沿垂直方向切割木块
                int profit1 = dfs(m - hi, n, prices, memo) + dfs(hi, n - wi, prices, memo);
                // 沿水平方向切割木块
                int profit2 = dfs(m, n - wi, prices, memo) + dfs(m - hi, wi, prices, memo);

                maxProfit = Math.max(maxProfit, Math.max(profit1, profit2) + pi);
            }
        }
        // 将计算结果存入 memo 中
        memo.put(key, maxProfit);
        return maxProfit;
    }

    //
    public static long sellingWood3(int m, int n, int[][] prices) {
        // 构建一个哈希表，存储每个木块尺寸对应的价格
        Map<String, Integer> map = new HashMap<>(prices.length);
        for (int[] price : prices) {
            map.put(price[0] + "-" + price[1], price[2]);
        }

        // 创建一个二维数组 dp，用于存储切割木块得到的最大利润
        int[][] dp = new int[m + 1][n + 1];

        // 遍历木块的每个尺寸
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 获取默认价格
                Integer defPrice = map.getOrDefault(i + "-" + j, 0);
                // 将默认价格与之前的结果 dp[i-1][j] 中的最大值赋给 dp[i][j]
                dp[i][j] = Math.max(defPrice, dp[i - 1][j]);

                // 尝试垂直方向切割
                for (int k = 1; k <= i; k++) {
                    // 在垂直方向切割后，计算两块木块的最大利润之和，并更新 dp[i][j]
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }

                // 尝试水平方向切割
                for (int l = 1; l <= j; l++) {
                    // 在水平方向切割后，计算两块木块的最大利润之和，并更新 dp[i][j]
                    dp[i][j] = Math.max(dp[i][j], dp[i][l] + dp[i][j - l]);
                }
            }
        }
        // 返回切割一块 m x n 大小的木块后，能得到的最大利润
        return dp[m][n];
    }


    public static long sellingWood2(int m, int n, int[][] prices) {
        Map<Long, Integer> value = new HashMap<>();
        for (int[] price : prices) {
            value.put(pairHash(price[0], price[1]), price[2]);
        }

        long[][] memo = new long[m + 1][n + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        long res = dfs(m, n, value, memo);
        return res;
    }

    public static long dfs(int x, int y, Map<Long, Integer> value, long[][] memo) {
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        long key = pairHash(x, y);
        long ret = value.getOrDefault(key, 0);
        if (x > 1) {
            for (int i = 1; i < x; i++) {
                ret = Math.max(ret, dfs(i, y, value, memo) + dfs(x - i, y, value, memo));
            }
        }
        if (y > 1) {
            for (int j = 1; j < y; j++) {
                ret = Math.max(ret, dfs(x, j, value, memo) + dfs(x, y - j, value, memo));
            }
        }
        memo[x][y] = ret;
        return ret;
    }

    public static long pairHash(int x, int y) {
        return (long) x << 16 ^ y;
    }



}
