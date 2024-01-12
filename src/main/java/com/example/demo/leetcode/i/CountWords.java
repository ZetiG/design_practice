package com.example.demo.leetcode.i;

import java.util.*;

/**
 * Description: 2085. 统计出现过一次的公共字符串
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 *
 * @author Zeti
 * @date 2024/1/12 14:36
 */
public class CountWords {
    public static void main(String[] args) {
        String[] w1 = {"leetcode","is","amazing","as","is"}, s1 = {"amazing","leetcode","is"};
        System.err.println(countWords(w1, s1)); // 2

        String[] w2 = {"b","bb","bbb"}, s2 = {"a","aa","aaa"};
        System.err.println(countWords(w2, s2)); // 0

        String[] w3 = {"a","ab"}, s3 = {"a","a","a","ab"};
        System.err.println(countWords(w3, s3)); // 1

    }


    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> m1 = new HashMap<>();
        for (String str : words1) {
            m1.put(str, m1.getOrDefault(str, 0)+1);
        }

        Map<String, Integer> m2 = new HashMap<>();
        for (String str : words2) {
            m2.put(str, m2.getOrDefault(str, 0)+1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            if (entry.getValue() == 1) {
                if (m2.containsKey(entry.getKey()) && m2.get(entry.getKey()) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

}
