package com.example.demo.leetcode.i;

import java.util.concurrent.TimeUnit;

/**
 * Description: 3106. 满足距离约束且字典序最小的字符串
 * 给你一个字符串 s 和一个整数 k 。
 * 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
 * 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
 * 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
 * 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
 *
 * 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
 *
 * @author Zeti
 * @date 2024/4/9 15:42
 */
public class GetSmallestString {
    public static void main(String[] args) {
        String s1 = "zbbz"; int k1 = 3;
        System.err.println(getSmallestString(s1, k1));  // aaaz

        String s2 = "xaxcd"; int k2 = 4;
        System.err.println(getSmallestString(s2, k2));  // aawcd

        String s3 = "lol"; int k3 = 0;
        System.err.println(getSmallestString(s3, k3));  // lol


    }

    public static String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cr = s.charAt(i);
            if (k == 0 || cr == 'a') {
                builder.append(cr);
                continue;
            }

            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int num = Math.min((cr - 'a'), ('z' - cr + 1));
            if (num <= k) {
                builder.append('a');
            } else {
                builder.append((char) (cr - k));
            }
            k = Math.max(k - num, 0);
        }
        return builder.toString();
    }
}