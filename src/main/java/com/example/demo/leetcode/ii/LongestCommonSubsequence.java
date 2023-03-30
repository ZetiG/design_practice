package com.example.demo.leetcode.ii;

/**
 * Description: 1143. 最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-subsequence
 * 
 * @author Zeti
 * @date 2023/3/30 16:10
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String t1 = "abcde", t11 = "ace";   // 3
        System.err.println(longestCommonSubsequence(t1, t11));

        String t2 = "abc", t22 = "abc";   // 3
        System.err.println(longestCommonSubsequence(t2, t22));

        String t3 = "abc", t33 = "def";   // 0
        System.err.println(longestCommonSubsequence(t3, t33));

    }

    // 暴力遍历
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length + 1][t2.length + 1];

        for (int i = 1; i <= t1.length; i++) {
            char c1 = t1[i - 1];
            for (int j = 1; j <= t2.length; j++) {
                char c2 = t2[j - 1];
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }




}
