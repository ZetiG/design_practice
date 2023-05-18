package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author Zeti
 * @date 2023/5/16 17:08
 */
public class Permute {
    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        System.err.println(permute(n1)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] n2 = {0,1};
        System.err.println(permute(n2)); // [[0,1],[1,0]]

        int[] n3 = {1};
        System.err.println(permute(n3)); // [[1]]

    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>(len);
        boolean[] used = new boolean[len];
        dfs2(nums, len, deque, used, 0, res);

        return res;
    }

    private static void dfs2(int[] nums,  int len, Deque<Integer> deque, boolean[] used, int idx, List<List<Integer>> res) {
        if (idx == len) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            // 当前值未被使用
            if (!used[i]) {
                deque.addLast(nums[i]); // 丢入队列
                used[i] = true; // 标记已使用

                dfs2(nums,len, deque, used, idx+1, res);

                deque.removeLast();
                used[i] = false;
            }
        }
    }


    public static List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }




}
