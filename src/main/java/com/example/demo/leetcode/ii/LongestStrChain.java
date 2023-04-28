package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1048. 最长字符串链 
 * 给出一个单词数组words，其中每个单词都由小写英文字母组成。
 * 如果我们可以不改变其他字符的顺序，在 wordA的任何地方添加 恰好一个 字母使其变成wordB，那么我们认为wordA是wordB的 前身 。
 *
 * 例如，"abc"是"abac"的 前身，而"cba"不是"bcad"的 前身
 * 词链是单词[word_1, word_2, ..., word_k]组成的序列，k >= 1，其中word1是word2的前身，word2是word3的前身，依此类推。一个单词通常是 k == 1 的 单词链。
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的最长可能长度 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-string-chain
 *
 * @date  2023/4/27 17:45
 * @author Zeti
 */
public class LongestStrChain {

    public static void main(String[] args) {
        String[] w1 = {"a","b","ba","bca","bda","bdca"};    // 4
        System.err.println(longestStrChain(w1));

        String[] w2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};    // 5
        System.err.println(longestStrChain(w2));

        String[] w3 = {"abcd","dbqca"};    // 1
        System.err.println(longestStrChain(w3));

    }


    public static int longestStrChain(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        // 按字符串长度倒序
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int res = 0;
        // 逐个字符串进行删减
        for (String wd : words) {
            cnt.put(wd, 1);
            for (int i = 0; i < wd.length(); i++) {
                String str = wd.substring(0, i) + wd.substring(i + 1);
                if (cnt.containsKey(str)) {
                    cnt.put(wd, Math.max(cnt.get(wd), cnt.get(str) + 1));
                }
            }
            res = Math.max(res, cnt.get(wd));
        }
        return res;
    }

}
