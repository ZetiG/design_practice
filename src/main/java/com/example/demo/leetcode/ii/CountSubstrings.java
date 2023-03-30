package com.example.demo.leetcode.ii;

/**
 * Description: 1638. 统计只差一个字符的子串数目
 * 给你两个字符串s 和t，请你找出 s中的非空子串的数目，这些子串满足替换 一个不同字符以后，是 t串的子串。换言之，请你找到 s和 t串中 恰好只有一个字符不同的子字符串对的数目。
 * 比方说，"computer"and"computation"只有一个字符不同：'e'/'a'，所以这一对子字符串会给答案加 1 。
 * 请你返回满足上述条件的不同子字符串对数目。
 * 一个 子字符串是一个字符串中连续的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-substrings-that-differ-by-one-character
 *
 * @author Zeti
 * @date 2023/3/29 17:35
 */
public class CountSubstrings {

    public static void main(String[] args) {
        String s = "aba", t = "baba";   // 输出：6
        System.err.println(countSubstrings(s, t));

        String s2 = "ab", t2 = "bb";   // 输出：3
        System.err.println(countSubstrings(s2, t2));

        String s3 = "a", t3 = "a";   // 输出：0
        System.err.println(countSubstrings(s3, t3));

        String s4 = "abe", t4 = "bbc"; // 输出：10
        System.err.println(countSubstrings(s4, t4));

    }

    // aba   baba
    // a b ab ba  aba
    // b a ba bab
    // 暴力遍历
    public static int countSubstrings2(String s, String t) {
        // 暴力遍历两个字符串，逐个递增判断是否满足题目要求
        // aba
        // baba
        int total = 0;
        for (int m = 0; m < s.length(); m++) {
            for (int n = 0; n < t.length(); n++) {

                int sonLen = 0; // 每次比较的子串，不同的字符数; 题目要求最大1个不同字符
                for (int i = 0; (i+m) < s.length() && (i+n) < t.length(); i++) {
                    if (s.charAt(i+m) != t.charAt(i+n)) {
                        sonLen++;
                    }

                    // 当比较的两个子串的不同字符只有一个时，才满足条件；否则退出循环
                    if (sonLen == 1) {
                        total += sonLen;
                    } else if (sonLen > 1) {
                        break;
                    }
                }
            }
        }
        return total;
    }


    public static int countSubstrings4(String s, String t) {
        char[] sarr = s.toCharArray(), tarr = t.toCharArray();
        int ans = 0, n = s.length(), m = t.length();

        for (int d = 1 - m; d < n; ++d) { // d=i-j, j=i-d
            int i = Math.max(d, 0);
            for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
                if (sarr[i] != tarr[i - d]) {
                    k0 = k1; // 上上一个不同
                    k1 = i;  // 上一个不同
                }
                ans += k1 - k0;
            }
        }
        return ans;
    }

    // dp
    public static int countSubstrings(String s, String t) {
        int ans = 0;
        int m = s.length(), n = t.length();
        int[][] f = new int[m + 1][n + 1];
        int[][] g = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s.charAt(i) == t.charAt(j)) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                } else {
                    ans += (f[i][j] + 1) * (g[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }


}
