package com.example.demo.leetcode.ii;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: 5. 最长回文子串
 * ps1: 输入：s = "babad"  输出："bab"    解释："aba" 同样是符合题意的答案。
 * ps2: 输入：s = "cbbd"   输出："bb"
 * ps3: 输入：s = "a"      输出："a"
 * ps4: 输入：s = "ac"     输出："a"
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author Zeti
 * @date 2022/1/20 4:25 PM
 */
public class PalindromeString {

    public static void main(String[] args) {

        System.err.println(longestPalindrome("babcad"));
        System.err.println(longestPalindrome("babad"));
        System.err.println(longestPalindrome("cbbd"));
        System.err.println(longestPalindrome("a"));
        System.err.println(longestPalindrome("ac"));
        System.err.println(longestPalindrome("ccc"));
        System.err.println(longestPalindrome("aacabdkacaa"));
        System.err.println(longestPalindrome("xaabacxcabaaxcabaax"));

    }

    //   b a b c a d
    // b 1 0 1 0 0 0
    // a   1
    // b     1
    // c       1
    // a         1
    // d           1
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int subStringStartIdx = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        // 遍历所有可能的回文串的长度
        for (int len = 1; len <= chars.length; len++) {
            // 当回文串长度为len时，left为左边起始点，right为右边终点
            for (int left = 0; left < chars.length; left++) {
                // 通过len可计算出right的位置
                int right = left + len - 1;
                if (right >= chars.length) {
                    break;
                }
                if (left == right) {
                    dp[left][right] = true;
                }

                if (right > left && chars[left] == chars[right]) {
                    if (right - left < 3) {    // 长度<=3, 且char[i] = char[j], 则一定是回文串
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];    // 长度大于3，且char[i] = char[j], 则判断去头斩尾后的子串是否是回文串
                    }
                }

                if (dp[left][right] && right-left+1 > maxLen) {
                    maxLen = right-left+1;
                    subStringStartIdx = left;
                }
            }
        }

        return s.substring(subStringStartIdx, subStringStartIdx+maxLen);
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

    // d2 动态规划
    public static String longestPalindrome_2(String s) {
        //边界条件判断
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                //如果两种字符不相同，肯定不能构成回文子串
                char l = s.charAt(left);
                char r = s.charAt(right);

                if (l != r)
                    continue;

                //下面是s.charAt(left)和s.charAt(right)两个
                //字符相同情况下的判断
                //如果只有一个字符，肯定是回文子串
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        //截取最长的回文子串
        return s.substring(start, start + maxLen);
    }



}
