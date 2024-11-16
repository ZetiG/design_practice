package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 1547. 切棍子的最小成本
 *
 * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
 * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
 * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
 * 返回切棍子的 最小总成本 。
 *
 * @author Zeti
 * @date 2024/11/11 10:25
 */
public class MinCost {
    public static void main(String[] args) {
        int n1 = 7; int[] c1 = {1,3,4,5};
        System.err.println(minCost(n1, c1));    // 16

        int n2 = 9; int[] c2 = {5,6,1,4,2};
        System.err.println(minCost(n2, c2));    // 22

    }

    public static int minCost(int n, int[] cuts) {
        // 先排序 cuts 数组
        Arrays.sort(cuts);

        // 定义新的 cuts 数组，包含了起始点 0 和终点 n
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }

        int[][] dp = new int[newCuts.length][newCuts.length];

        // 双指针填表法, 动态规划填充 dp 数组
        for (int i = 2; i < newCuts.length; i++) {  // i 作为右端点
            for (int j = i - 2; j >= 0; j--) { // j 作为左端点
                dp[j][i] = Integer.MAX_VALUE;

                // k 枚举分割点，找出最小切割成本
                for (int k = j + 1; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i] + newCuts[i] - newCuts[j]);
                }
            }
        }

        // 最小成本保存在 dp[0][len - 1]
        return dp[0][newCuts.length - 1];
    }


}
