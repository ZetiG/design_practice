package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 438. 找到字符串中所有字母异位词 
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 *
 * @author Zeti
 * @date 2023/4/26 17:04
 */
public class FindAnagrams {
    public static void main(String[] args) {
        String s1 = "cbaebabacd", p1 = "abc";
        System.err.println(findAnagrams(s1, p1));   // [0,6]

        String s2 = "abab", p2 = "ab";
        System.err.println(findAnagrams(s2, p2));   // [0,1,2]

    }

    public static List<Integer> findAnagrams(String s, String p) {

        int s_len = s.length(), p_len = p.length();
        List<Integer> ans = new ArrayList<Integer>();//用于记录窗口滑动过程中的可行解

        //字符s的长度一定要大于字符p的长度，否则不存在异位词
        if (s_len < p_len) {
            return ans;
        }

        int[] count = new int[26]; //用于维护窗口滑动过程中窗口中的字符与字符p中每个字符的差值
        int diff = 0; // 用于维护count数组中不为0的个数

        //初始统计
        for (int i = 0; i < p_len; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        // 统计count数组中不为0的个数，并赋值给diff
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) diff++;
        }

        //如果窗口最初始的时候满足异位词，则将0加入到ans数组中
        if (diff == 0) ans.add(0);

        //窗口开始滑动,左右都按照同频率滑动
        for (int i = 0; i < s_len - p_len; i++) {
            //左指针移动导致diff变化的情况
            if (count[s.charAt(i) - 'a'] == 1) {
                diff--;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                diff++;
            }
            count[s.charAt(i) - 'a']--;    // 左指针移动

            //右指针移动导致diff变化的情况
            if (count[s.charAt(i + p_len) - 'a'] == -1) {
                diff--;
            } else if (count[s.charAt(i + p_len) - 'a'] == 0) {
                diff++;
            }
            count[s.charAt(i + p_len) - 'a']++;  // 右指针移动

            //判断是否满足异位词的条件，满足加入到ans中
            if (diff == 0) ans.add(i + 1);
        }
        return ans;
    }


    public static List<Integer> findAnagrams_2(String s, String p) {
        // 用于返回字母异位词的起始索引
        List<Integer> res = new ArrayList<>();

        // 用 map 存储目标值中各个单词出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 用另外一个 map 存储滑动窗口中有效字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0; // 左指针
        int right = 0; // 右指针
        int valid = p.length(); // 只有当 valid == 0 时，才说明 window 中包含了目标子串
        while (right < s.length()) {
            // 如果目标子串中包含了该字符，才存入 window 中
            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                    valid--;
                }
            }
            // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
            // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
            while (valid == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                if (map.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }


}
