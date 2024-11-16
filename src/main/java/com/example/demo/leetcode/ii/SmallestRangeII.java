package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 910. 最小差值 II
 * 给你一个整数数组 nums，和一个整数 k 。
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 *
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 *
 * @author Zeti
 * @date 2024/10/23 15:13
 */
public class SmallestRangeII {
    public static void main(String[] args) {

        int[] n1 = {1}; int k1 = 0;
        System.err.println(smallestRangeII(n1, k1)); // 0

        int[] n2 = {0,10}; int k2 = 2;
        System.err.println(smallestRangeII(n2, k2)); // 6

        int[] n3 = {1,3,6}; int k3 = 3;
        System.err.println(smallestRangeII(n3, k3)); // 3

        int[] n4 = {-7,-4,3,9,15}; int k4 = 4;
        System.err.println(smallestRangeII(n4, k4)); // 14


    }

    // 1,3,6   k=3
    // +k = 4,
    // 4 6 9
    public static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);  // 先保证数组顺序
        int res = nums[nums.length-1] - nums[0];    // 当数组长度=1时，以及初始化最小值，默认数组内所有元素+0
        for (int i = 1; i < nums.length; i++) {
            // 题意要求计算最小的极差值, 即缩小最大值和最小值之间的差距，所以原数组的最小值尽量+k，原数组的最大值尽量-k，
            // 但有可能出现 (nums[0]+k) > 0 而 nums[nums.length-1] < 0，所有需要重新找出数组处理后的最大值和最小值；

            // 求数组变化后的最小值，这个最小值有可能是(nums[0]+k)，也有可能是(nums[i]-k)
            // 最小值（nums[0] + k）和 最大值（nums[nums.length-1] - k）的目的是尽量缩小数组变换后的极差值
            int min = Math.min(nums[0] + k, nums[i] - k);
            int max = Math.max(nums[nums.length-1] - k, nums[i-1] + k);
            res = Math.min(res, max - min);
        }
        return res;
    }


}
