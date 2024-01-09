package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2707. 字符串中的额外字符
 *  给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，
 *  每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 *
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 *
 * @author Zeti
 * @date 2024/1/9 09:21
 */
public class MinExtraChar {
    public static void main(String[] args) {

        String s1 = "leetscode";
        String[] d1 = {"leet","code","leetcode"};
        System.err.println(minExtraChar(s1, d1));   // 1, 中间一个s不在d1中

        String s2 = "sayhelloworld";
        String[] d2 = {"hello","world"};
        System.err.println(minExtraChar(s2, d2));   // 3, say不在d1中

    }


    // dp
    public static int minExtraChar2(String s, String[] dictionary) {
        int len = s.length();
        int[] dp = new int[len+1];  // 当字符串长度为len时，dp[len]为当前字符串在dictionary中未匹配上的字符数
        Arrays.fill(dp, Integer.MAX_VALUE); // 初始化dp[]

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        dp[0] = 0;  // 当字符串长度为0时，未匹配上的字符数一定为0
        for (int i = 1; i <= len; i++) {    // 遍历字符串，以i为截取字符串的结尾
            dp[i] = dp[i-1] + 1;    // dp[n]最差的情况就是dp[n-1]+1

            for (int j = i - 1; j >= 0; j--) {  // 以i为结尾，j往前推遍历，判断是否在dictionary中匹配的上
                String substr = s.substring(j, i);
                if (set.contains(substr)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }


    // 字典树
    public static int minExtraChar(String s, String[] dictionary) {
        // 构造字典树，将dictionary中所有字符串倒序遍历，插入字典树
        Node root = new Node();
        for (String w : dictionary) {
            Node node = root;
            for (int k = w.length() - 1; k >= 0; --k) {
                int i = w.charAt(k) - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Node();
                }
                node = node.children[i];
            }
            node.isEnd = true;
        }

        // dp
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + 1;    // 最坏的情况:dp[i] = dp[i-1] + 1;
            Node node = root;
            for (int j = i - 1; j >= 0; --j) {  // 以i为字符串的结尾，j为s[0,i]倒序遍历的指针，依次判断s[0,i]中的s[j]是否在字典中
                node = node.children[s.charAt(j) - 'a'];
                if (node == null) {
                    break;
                }
                if (node.isEnd && f[j] < f[i]) {
                    f[i] = f[j];
                }
            }
        }
        return f[n];
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }


}
