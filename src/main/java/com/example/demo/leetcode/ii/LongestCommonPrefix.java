package com.example.demo.leetcode.ii;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 3043. 最长公共前缀的长度
 * 给你两个 正整数 数组 arr1 和 arr2 。
 *
 * 正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。
 * 设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 ，而 1223 和 43456 没有 公共前缀。
 * 你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。
 * 返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。
 *
 * @author Zeti
 * @date 2024/4/10 11:37
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        int[] a1_1 = {1,10,100}, a2_1 = {1000};
        System.err.println(longestCommonPrefix(a1_1, a2_1));    // 3

        int[] a1_2 = {1,2,3}, a2_2 = {4,4,4};
        System.err.println(longestCommonPrefix(a1_2, a2_2));    // 0

    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int k : arr1) {
            int a1 = k;
            while (a1 > 0) {
                set.add(a1);
                a1 /= 10;
            }
        }

        int max = 0;
        for (int i : arr2) {
            int a2 = i;

            while (a2 > 0) {
                if (set.contains(a2)) {
                    max = Math.max(max, a2);
                    break;
                }
                a2 /= 10;
            }
        }
        return max > 0 ? Integer.toString(max).length() : 0;
    }


    // 双层遍历，超时
    public int longestCommonPrefix2(int[] arr1, int[] arr2) {
        int maxLen = 0;
        for (int i = 0; i < arr1.length; i++) {
            int a1 = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                int a2 = arr2[j];
                maxLen = Math.max(maxLen, sub(String.valueOf(a1), String.valueOf(a2)));
            }
        }
        return maxLen;
    }

    // 取两个字符串的共同前缀
    public static int sub(String a, String b){
        int len = Math.min(a.length(), b.length());
        int i;
        for(i=0; i<len; i++) {
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
        }
        return i+1;
    }

}
