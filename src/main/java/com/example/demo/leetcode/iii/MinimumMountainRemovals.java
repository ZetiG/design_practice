package com.example.demo.leetcode.iii;

import java.util.Arrays;

/**
 * Description: 1671. 得到山形数组的最少删除次数
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 *      arr.length >= 3
 *      存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 *      arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *      arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组nums, 请你返回将 nums 变成"山形状数组"的最少删除次数。
 *
 * @author Zeti
 * @date 2023/12/22 09:37
 */
public class MinimumMountainRemovals {

    public static void main(String[] args) {
//        int[] n1 = {1,3,1};
//        System.err.println(minimumMountainRemovals(n1)); // 0
//
//        int[] n2 = {2,1,1,5,6,2,3,1};
//        System.err.println(minimumMountainRemovals(n2)); // 3 删除下标为0、1、5； 剩余 [1,5,6,3,1]
//
//        int[] n3 = {23,47,63,72,81,99,88,55,21,33,32};
//        System.err.println(minimumMountainRemovals(n3)); // 1
//
//        int[] n4 = {4,3,2,1,1,2,3,1};
//        System.err.println(minimumMountainRemovals(n4)); // 4

        int[] n5 = {1,16,84,9,29,71,86,79,72,12};
        System.err.println(minimumMountainRemovals(n5)); // 2


    }

    /**
     * 遍历，当数组的每个元素依次作为山峰时，定义两个数组存储左右两边各自需要删除的元素个数，答案最少的删除个数就是两个数组下标相同时，对应元素之和
     */
    public static int minimumMountainRemovals(int[] nums) {

        // 左侧最长递增子序
        int[] left = getLISArray(nums);

        // 翻转数组
        int[] reverse = reverse(nums);

        // 右侧最长递增子序
        int[] right = getLISArray(reverse);

        // 计算最长递增子序
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] > 1 && right[nums.length - i - 1] > 1) {
                // 当元素下标i为山峰顶时，左右两侧最长递增子序之和即为符合题意的最大山峰
                max = Math.max(max, left[i] + right[nums.length-i-1] - 1);
            }
        }
        // 数组总长度-最大山峰长度=需要剔除的最小元素数量
        return nums.length-max;
    }


    /**
     * 最长递增子序
     */
    public static int[] getLISArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * 翻转数组
     */
    public static int[] reverse(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = tmp;
        }

        return nums;
    }



}
