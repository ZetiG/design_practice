package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 763. 划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-labels
 *
 * @author Zeti
 * @date 2023/6/25 10:25
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";
        System.err.println(partitionLabels(s1));    // [9,7,8]

        String s2 = "eccbbbbdec";
        System.err.println(partitionLabels(s2));    // [10]

    }


    public static List<Integer> partitionLabels(String s) {
        // 字符最后一次出现的下标
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i)-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIdx[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

}
