package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description: 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * @author Zeti
 * @date 2023/5/29 10:18
 */
public class Partition {
    public static void main(String[] args) {
        String s1 = "aab";
        System.err.println(partition(s1)); // [["a","a","b"],["aa","b"]]

        String s2 = "a";
        System.err.println(partition(s2)); // [["a"]]

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() != 0) {
            Deque<String> deque = new ArrayDeque<>();
            dfs(s.toCharArray(), 0, s.length(), deque, res);
        }
        return res;
    }

    private static void dfs(char[] charArrays, int idx, int len, Deque<String> deque, List<List<String>> res) {
        // 遍历完成，添加结果至res集合
        if (idx == len) {
            res.add(new ArrayList<>(deque));
            return;
        }

        // 遍历字符串的每个字符以作为起始位置，并以当前字符为起点递归向下遍历所有的组合
        for (int i = idx; i < len; i++) {
            // 判断是否满足截取的条件
            if (!checkPalindrome(charArrays, idx, i)) {
                continue;
            }

            deque.addLast(new String(charArrays, idx, i + 1 - idx));
            dfs(charArrays, i + 1, len, deque, res);
            deque.removeLast();
        }
    }

    // 给定字符串，起始位置，结束位置，判断字符串是否是回文串
    private static boolean checkPalindrome(char[] charArrays, int left, int right) {
        while (right > left) {
            if (charArrays[left] != charArrays[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
