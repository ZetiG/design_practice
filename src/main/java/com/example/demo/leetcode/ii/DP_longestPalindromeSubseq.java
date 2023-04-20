package com.example.demo.leetcode.ii;

/**
 * Description: 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/20 16:32
 */
public class DP_longestPalindromeSubseq {
    public static void main(String[] args) {
//        String s1 = "bbbab";
//        System.err.println(longestPalindromeSubseq(s1)); // 4
//
//        String s2 = "cbbd";
//        System.err.println(longestPalindromeSubseq(s2)); // 2
//
//        String s3 = "aa";
//        System.err.println(longestPalindromeSubseq(s3)); // 2

        String s4 = "aabaa";
        System.err.println(longestPalindromeSubseq(s4)); // 5

    }

    //   a  a  b  a  a
    // b 1  2  2  3  5
    // b    1  1  3  3
    // b       1  1  2
    // a          1  2
    // b             1
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

//    public static int longestPalindromeSubseq2(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            dp[i][i] = 1;
//            char c1 = s.charAt(i);
//            for (int j = i + 1; j < n; j++) {
//                char c2 = s.charAt(j);
//                if (c1 == c2) {
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }


}
