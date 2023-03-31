package com.example.demo.leetcode.ii;

/**
 * Description: 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindromic-substrings
 *
 * @author Zeti
 * @date 2023/3/30 19:16
 */
public class DP_CountSubstrings {

    public static void main(String[] args) {
//        String s1 = "abc";  // 3
//        System.err.println(countSubstrings(s1));
//
//        String s2 = "aaa";  // 6
//        System.err.println(countSubstrings(s2));

        String s3 = "aaaaa";  // 6
        System.err.println(countSubstrings(s3));

    }
    public static int countSubstrings(String s) {
        char[] cr = s.toCharArray();
        boolean[][] dp = new boolean[cr.length][cr.length];

        int ct = 0;
        for(int i = cr.length - 1; i >= 0; i--) {
            for(int j = i; j < cr.length; j++) {
                if (cr[i] == cr[j]) {
                    if (j - 1 >= i + 1) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]) {
                    ct++;
                }
            }
        }
        return ct;
    }

    // 输入：s = "abc"
    //解释：三个回文子串: "a", "b", "c"

    //输入：s = "aaa"
    //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
    public static int countSubstrings2(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;//回文串的数量
        //字符串从后往前判断
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - 1 >= i + 1) {  // 子串 s[i+1..j-1] 有效性
                        if (dp[i + 1][j - 1]) dp[i][j] = true;
                    } else {
                        // 此时 j < i + 2 即 j <= i+1
                        // 再之 s[i] == s[j]，必回文
                        dp[i][j] = true;
                    }
                }
                //如果从i到j能构成回文串，count就加1
                if (dp[i][j])
                    count++;
            }
        }
        return count;
    }



}
