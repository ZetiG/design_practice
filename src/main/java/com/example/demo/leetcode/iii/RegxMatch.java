package com.example.demo.leetcode.iii;

/**
 * Description: 正则匹配，给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * ps1: 输入：s = "aa" p = "a"     输出：false    解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * ps2: 输入：s = "aa" p = "a*"    输出：true     解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * ps3: 输入：s = "ab" p = ".*"    输出：true     解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * ps4: 输入：s = "aab" p = "c*a*b"    输出：true     解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * ps5: 输入：s = "mississippi" p = "mis*is*p*."   输出：false
 *
 * @author Zeti
 * @date 2022/1/25 4:29 PM
 */
public class RegxMatch {

    public static void main(String[] args) {

        //        System.err.println(mt("aa", "a"));
        //        System.err.println(mt("aa", "a*"));
        //        System.err.println(mt("ab", ".*"));
        //        System.err.println(mt("aab", "c*a*b"));
        //        System.err.println(mt("mississippi", "mis*is*p*."));


//        System.err.println(isMatch("aa", "a"));
//        System.err.println(isMatch("aa", "a*"));
//        System.err.println(isMatch("ab", ".*"));
//        System.err.println(isMatch("aab", "c*a*b"));
        System.err.println(isMatch("mississippi", "mis*is*p*."));

    }

    // d1
    public static boolean mt(String s, String p) {

        // TODO: 2022/1/25

        return false;
    }


    public static boolean isMatch(String s, String p) {
        if (p == null) {
            if (s == null) {
                return true;
            }
            return false;
        }

        if (s == null && p.length() == 1) {
            return false;
        }

        int m = s.length() + 1;
        int n = p.length() + 1;

        boolean[][] dp = new boolean[m][n];

        dp[0][0] = true;

        for (int j = 2; j < n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int r = 1; r < m; r++) {
            int i = r - 1;
            for (int c = 1; c < n; c++) {
                int j = c - 1;
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[r][c] = dp[r - 1][c - 1];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[r][c] = dp[r - 1][c] || dp[r][c - 2];
                    } else {
                        dp[r][c] = dp[r][c - 2];
                    }
                } else {
                    dp[r][c] = false;
                }

            }
        }
        return dp[m - 1][n - 1];
    }

}
