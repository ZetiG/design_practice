package com.example.demo.leetcode.ii;

import org.apache.flink.shaded.curator4.com.google.common.collect.Lists;

import java.util.List;

/**
 * Description: 139. 单词拆分
 *  给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *  注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 *
 * @author Zeti
 * @date 2023/4/8 16:34
 */
public class DP_WordBreak {

    public static void main(String[] args) {
//        String s1 = "leetcode";
//        List<String> w1 = Lists.newArrayList("leet", "code");
//        System.err.println(wordBreak(s1, w1));  // true
//
//        String s2 = "applepenapple";
//        List<String> w2 = Lists.newArrayList("apple", "pen");
//        System.err.println(wordBreak(s2, w2));  // true
//
//        String s3 = "catsandog";
//        List<String> w3 = Lists.newArrayList("cats", "dog", "sand", "and", "cat");
//        System.err.println(wordBreak(s3, w3));  // false
//
//        String s4 = "aaaaaaa";
//        List<String> w4 = Lists.newArrayList("aaaa","aaa");
//        System.err.println(wordBreak(s4, w4));  // true
//
//        String s5 = "abcdefg";
//        List<String> w5 = Lists.newArrayList("abcd","efg");
//        System.err.println(wordBreak(s5, w5));  // true

        String s6 = "abcd";
        List<String> w6 = Lists.newArrayList("a","abc","b","cd");
        System.err.println(wordBreak(s6, w6));  // true

    }

    // 可以类比于背包问题
    public static boolean wordBreak(String s, List<String> wordDict) {
       int len = s.length();
       boolean[] dp = new boolean[len+1];
       dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && wordDict.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

}
