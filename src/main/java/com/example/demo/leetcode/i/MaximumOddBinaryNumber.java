package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2864. 最大二进制奇数
 *
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * 注意 返回的结果字符串 可以 含前导零。
 *
 * @author Zeti
 * @date 2024/3/13 10:05
 */
public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s1 = "010";
        System.err.println(maximumOddBinaryNumber(s1)); // 001

        String s2 = "0101";
        System.err.println(maximumOddBinaryNumber(s2)); // 1001

        String s3 = "10011001010";
        System.err.println(maximumOddBinaryNumber(s3)); // 11110000001

    }

    // 灵神方法
    public static String maximumOddBinaryNumber(String s) {
        // 统计1的数量
        int count1 = (int) s.chars().filter(c -> c == '1').count();
        // 1重复count-1次，拼接0重复s.len-count次，拼接1
        return "1".repeat(count1 - 1) + "0".repeat(s.length() - count1) + "1";
    }

    // 笨比方法
    public static String maximumOddBinaryNumber2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                deque.offer('0');
                continue;
            }
            deque.push('1');
        }

        deque.offer(deque.pop());

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pop());
        }
        return res.toString();
    }

}
