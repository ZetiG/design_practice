package com.example.demo.leetcode.i;

/**
 * Description: 859. 亲密字符串
 *  给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 *  交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *  例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * @author Zeti
 * @date 2023/3/23 09:34
 */
public class BuddyStrings {

    public static void main(String[] args) {
        String s1 = "ab", g1 = "ba";
        System.err.println(buddyStrings(s1, g1));

        String s2 = "ab", g2 = "ab";
        System.err.println(buddyStrings(s2, g2));

        String s3 = "aa", g3 = "aa";
        System.err.println(buddyStrings(s3, g3));

        String s4 = "cabbba", g4 = "abbccc";
        System.err.println(buddyStrings(s4, g4));

        String s5 = "abab", g5 = "acaa";
        System.err.println(buddyStrings(s5, g5));

    }


    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // 字符串相等时，若存在重复字符则一定可以交换位置，否则无法交换
        if (s.equals(goal)) {
            int[] ints = new int[26];   // 26个英文字符，根据题意字符串只会出现字母，所以一定在26个字母中

            // 循环s字符串，看里面是否存在重复出现的字母；因为进来的前提条件是s=goal，s存在则goal也一定存在
            for (int i = 0; i < s.length(); i++) {
                // 统计每个字符出现的次数，数组对应位置+1
                ints[s.charAt(i) - 'a']++;
                if (ints[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        // 题目要求，只需要交换两个字符串的位置即可使"s=goal"；否则均不满足题意
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                    continue;
                }
                if (second == -1) {
                    second = i;
                    continue;
                }
                return false;
            }
        }

        return (second != -1 && s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first));
    }



}
