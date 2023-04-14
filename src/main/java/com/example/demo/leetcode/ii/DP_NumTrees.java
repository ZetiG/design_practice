package com.example.demo.leetcode.ii;

/**
 * Description: 96. 不同的二叉搜索树
 *  给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode.cn/problems/unique-binary-search-trees/
 *
 * @author Zeti
 * @date 2023/4/13 16:14
 */
public class DP_NumTrees {
    public static void main(String[] args) {
        int n1 = 1;
        System.err.println(numTrees(n1));

        int n3 = 3;
        System.err.println(numTrees(n3));

        int n5 = 5;
        System.err.println(numTrees(n5));

        int n19 = 19;
        System.err.println(numTrees(n19));

    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
