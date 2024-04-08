package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 3107. 使数组中位数等于 K 的最少操作数
 *
 * 给你一个整数数组 nums 和一个 非负 整数 k 。
 * 一次操作中，你可以选择任一下标 i ，然后将 nums[i] 加 1 或者减 1 。
 * 请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。
 * 一个数组的 中位数 指的是数组按 非递减 顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。
 *
 * @author Zeti
 * @date 2024/4/8 16:52
 */
public class MinOperationsToMakeMedianK {
    public static void main(String[] args) {
        int[] n1 = {2,5,6,8,5};
        int k1 = 4;
        System.err.println(minOperationsToMakeMedianK(n1, k1));   // 2

        int[] n2 = {2,5,6,8,5};
        int k2 = 7;
        System.err.println(minOperationsToMakeMedianK(n2, k2));   // 3

        int[] n3 = {1,2,3,4,5,6};
        int k3 = 4;
        System.err.println(minOperationsToMakeMedianK(n3, k3));   // 0

        int[] n4 = {75,17,74,22,40,86};
        int k4 = 86;
        System.err.println(minOperationsToMakeMedianK(n4, k4));   // 23

        int[] n5 = {45,50,89,30,4,5,91,58};
        int k5 = 31;
        System.err.println(minOperationsToMakeMedianK(n5, k5));   // 33

    }

    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int m = nums.length / 2;

        // 由于排过序
        // 如果当前中位数>k; 则[0-midIdx]中大于k的都变为k
        if (nums[m] > k) {
            for (int i = m; i >= 0 && nums[i] > k; i--) {
                ans += nums[i] - k;
            }
        } else {
            for (int i = m; i < nums.length && nums[i] < k; i++) {
                ans += k - nums[i];
            }
        }
        return ans;
    }





}
