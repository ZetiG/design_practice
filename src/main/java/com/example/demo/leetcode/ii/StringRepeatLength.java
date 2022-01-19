package com.example.demo.leetcode.ii;

import java.util.HashMap;

/**
 * Description: 字符串无重复的最长子串长度
 * ps1: 输入: s = "abcabcbb"  输出: 3   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * ps2: 输入: s = "bbbbb"     输出: 1    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * ps3: 输入: s = "pwwkew"    输出: 3   解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * ps4: 输入: s = ""          输出: 0
 *
 * @author Zeti
 * @date 2022/1/19 4:40 PM
 */
public class StringRepeatLength {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = " ";
        String s6 = "abcd";
        String s7 = "aab";

        System.err.println(substringLength(s1));
        System.err.println(substringLength(s2));
        System.err.println(substringLength(s3));
        System.err.println(substringLength(s4));
        System.err.println(substringLength(s5));
        System.err.println(substringLength(s6));
        System.err.println(substringLength(s7));

        System.err.println("----------------------");

        System.err.println(lengthOfLongestSubstring(s1));
        System.err.println(lengthOfLongestSubstring(s2));
        System.err.println(lengthOfLongestSubstring(s3));
        System.err.println(lengthOfLongestSubstring(s4));
        System.err.println(lengthOfLongestSubstring(s5));
        System.err.println(lengthOfLongestSubstring(s6));
        System.err.println(lengthOfLongestSubstring(s7));
    }


    // 利用ASCII码
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


    // d1 滑动窗口，
    public static int substringLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        HashMap<Character, Integer> window = new HashMap<>();// 用来存储滑动窗内包含的数据
        int left = 0;   // 记录最左边不重复元素的起始位置
        for (int i = 0; i < s.length(); i++) {

            // 包含当前字符，则剔除最左边元素
            if (window.containsKey(s.charAt(i))) {
                left = Math.max(left, window.get(s.charAt(i)) + 1);
            }

            window.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }


}
