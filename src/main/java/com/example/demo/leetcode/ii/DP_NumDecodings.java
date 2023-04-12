package com.example.demo.leetcode.ii;

/**
 * Description: 91. 解码方法 
 *  一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 *
 *  'A' -> "1"
 *  'B' -> "2"
 *  ...
 *  'Z' -> "26"
 *  要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 *  "AAJF" ，将消息分组为 (1 1 10 6)
 *  "KJF" ，将消息分组为 (11 10 6)
 *  注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *  给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *  题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/decode-ways
 *
 * @author Zeti
 * @date 2023/4/12 14:47
 */
public class DP_NumDecodings {

    public static void main(String[] args) {
        String s1 = "12";
        System.err.println(numDecodings(s1)); // 2

        String s2 = "226";
        System.err.println(numDecodings(s2)); // 3

        String s3 = "06";
        System.err.println(numDecodings(s3)); // 0

        String s4 = "27";
        System.err.println(numDecodings(s4)); // 1

    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != '0') {
                dp[i+1] += dp[i];
            }

            if (i > 0 && s.charAt(i-1) != '0' && ((s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0')) <= 26) {
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }



}
