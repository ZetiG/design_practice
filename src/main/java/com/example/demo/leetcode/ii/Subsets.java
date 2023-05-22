package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author Zeti
 * @date 2023/5/20 16:11
 */
public class Subsets {
    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        System.err.println(subsets(n1)); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        int[] n2 = {0};
        System.err.println(subsets(n2)); // [[],[0]]

    }


    // 1 2 3
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;

    }

    private static void backtrack(int[] nums, int i, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(nums, j + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
