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

    // d2 动态规划
    public static String longestPalindrome(String s) {
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
