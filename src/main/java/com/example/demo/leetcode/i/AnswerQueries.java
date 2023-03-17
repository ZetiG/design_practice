package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 2389. 和有限的最长子序列
 *  给你一个长度为 n的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 *  返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度 。
 *  子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-subsequence-with-limited-sum
 * 
 * @author Zeti
 * @date 2023/3/17 15:53
 */
public class AnswerQueries {

    public static void main(String[] args) {
        int[] n1 = {4,5,2,1};
        int[] q1 = {3,10,21};
        // [2,3,4]
        System.err.println(Arrays.toString(answerQueries(n1, q1)));

        int[] n2 = {2,3,4,5};
        int[] q2 = {1};
        // [0]
        System.err.println(Arrays.toString(answerQueries(n2, q2)));

    }

    // [4, 5, 2, 1]
    // [3, 10, 21]
    // res = [2, 3, 4]
    public static int[] answerQueries(int[] nums, int[] queries) {
        // 排序
        Arrays.sort(nums);

        // 前缀和 1，2，4，5
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }

        for (int q = 0; q < queries.length; q++) {
            int query = queries[q];
            queries[q] = search(nums, query);
        }
        return queries;
    }

    private static int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }




}
