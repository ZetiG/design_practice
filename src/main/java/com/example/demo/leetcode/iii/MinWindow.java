package com.example.demo.leetcode.iii;

import java.util.HashMap;

/**
 * Description: 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 *
 * @author Zeti
 * @date 2024/1/9 14:08
 */
public class MinWindow {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.err.println(minWindow(s1, t1));  // "BANC"

        String s2 = "a";
        String t2 = "a";
        System.err.println(minWindow(s2, t2));  // "a"

        String s3 = "a";
        String t3 = "aa";
        System.err.println(minWindow(s3, t3));  // ""


    }

    // 滑动窗口
    // A D O B E C O D E B A  N  C
    // 0 1 2 3 4 5 6 7 8 9 10 11 12
    public static String minWindow(String s, String t) {
        // 遍历t字符串，将每个字符及出现的次数存入hash表；后续遍历s字符串时，每覆盖一个字符时则对应计数-1
        HashMap<Character, Integer> map = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int charCount = t.length(); // 可以理解为需要被覆盖的总字符数，用来判断是否完全覆盖，==0时表示被完全覆盖
        int left = 0;   // 窗口左边界
        int right = 0;  // 窗口右边界
        int minLen = Integer.MAX_VALUE; // 结果值-满足题意的最小字符串长度(因为下标是从0开始，最后使用时需要+1)
        int startIdx = 0;   // 满足题意的最小字符串的长度起始下标

        for (; right < s.length(); right++) {
            Character rc = s.charAt(right);
            if (map.get(rc) == null) {  // 非t字符串内的字符，跳过
                continue;
            }

            // 对于t内包含的字符，hash表对应计数减1，且待覆盖的总长度减1
            int it = map.getOrDefault(rc, 0) - 1;
            map.put(rc, it);
            if (it >= 0) { // 若某个字符的计数小于0（it<0）, 则代表已经该字符被完全覆盖，待覆盖的总数无须变化
                charCount--;
            }

            // left->right的字符串已经包含全部t的字符，这时移动左边界，使得窗口尽量最小化且包含所有t的字符
            // 每右移一次left边界；等于去掉一个左边的字符，判断该字符是否在t内，在则加入map
            while (charCount == 0) {
                // 记录满足题意的较小的字符串长度和起始点
                if (right-left < minLen) {
                    minLen = right-left;
                    startIdx = left;
                }

                // 移动窗口左边界，并判断左边界去掉的字符是否在t内
                Character lc = s.charAt(left);
                Integer num = map.get(lc);
                if (num != null) {
                    map.put(lc, num+1);
                    // 这里t中某个字符计数+1>0时，代表之前被完全覆盖的字符这时由于左窗口边界右移(left++)被丢弃，
                    // 导致s[left+1, right]内不存在该字符了
                    if (num+1>0) {
                        charCount++;
                    }
                }
                left++;
            }
        }
        // minLen < s.length() 由于minLen初始值为MAX_VALUE，这里是避免没符合条件的字符串时下标越界
        return minLen < s.length() ? s.substring(startIdx, startIdx + minLen+1) : "";
    }



}
