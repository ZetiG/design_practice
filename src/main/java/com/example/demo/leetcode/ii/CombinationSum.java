package com.example.demo.leetcode.ii;

import java.util.*;

/**
 * Description: 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 *
 * @author Zeti
 * @date 2023/5/20 09:51
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] c1 = {2,3,6,7}; int t1 = 7;
        System.err.println(combinationSum(c1, t1)); // [[2,2,3],[7]]

        int[] c2 = {2,3,5}; int t2 = 8;
        System.err.println(combinationSum(c2, t2)); // [[2,2,2,2],[2,3,3],[3,5]]

        int[] c3 = {2}; int t3 = 1; // []
        System.err.println(combinationSum(c3, t3));

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        backtracking(candidates, 0, candidates.length, target, new ArrayDeque<>(), res);

        return res;
    }

    private static void backtracking(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            backtracking(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }


}
