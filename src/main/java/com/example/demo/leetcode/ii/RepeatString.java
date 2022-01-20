package com.example.demo.leetcode.ii;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: 找出字符串中最长的回文子串
 * ps1: 输入：s = "babad"  输出："bab"    解释："aba" 同样是符合题意的答案。
 * ps2: 输入：s = "cbbd"   输出："bb"
 * ps3: 输入：s = "a"      输出："a"
 * ps4: 输入：s = "ac"     输出："a"
 *
 * @author Zeti
 * @date 2022/1/20 4:25 PM
 */
public class RepeatString {

    public static void main(String[] args) {
        String s1 = "babcad";
        String s2 = "babad";
        String s3 = "cbbd";
        String s4 = "a";
        String s5 = "ac";
        String s6 = "ccc";
        String s7 = "aacabdkacaa";
        String s8 = "xaabacxcabaaxcabaax";

        System.err.println(getStr(s1));
        System.err.println(getStr(s2));
        System.err.println(getStr(s3));
        System.err.println(getStr(s4));
        System.err.println(getStr(s5));
        System.err.println(getStr(s6));
        System.err.println(getStr(s7));
        System.err.println(getStr(s8));

        System.err.println(longestPalindrome(s8));

    }

    // d1
    public static String getStr(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        int[] maxSub = new int[2];

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            // 之前出现过
            if (map.containsKey(s.charAt(i))) {

                List<Integer> sIndexs = map.get(s.charAt(i));
                sIndexs.add(i);
                map.put(s.charAt(i), sIndexs);

                for (Integer idx : sIndexs) {

                    if (i != idx && i - idx > maxLen && check(s, idx, i)) {
                        maxLen = i - idx;

                        maxSub[0] = idx;
                        maxSub[1] = i;
                    }
                }
            } else {
                // 首次出现
                ArrayList<Integer> idx = new ArrayList<>();
                idx.add(i);
                map.put(s.charAt(i), idx);
            }

        }
        return s.substring(maxSub[0], maxSub[1] + 1);
    }

    public static boolean check(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
