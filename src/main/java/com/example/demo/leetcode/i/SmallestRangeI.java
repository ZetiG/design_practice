package com.example.demo.leetcode.i;

/**
 * Description: 908. 最小差值 I
 *
 * 给你一个整数数组 nums，和一个整数 k 。
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的任意整数。对于每个索引 i ，最多 只能 应用
 * 一次 此操作。
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 * 在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 *
 * @author Zeti
 * @date 2024/10/23 14:43
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        int[] n1 = {1}; int k1 = 0;
        System.err.println(smallestRangeI(n1, k1)); // 0

        int[] n2 = {0,10}; int k2 = 2;
        System.err.println(smallestRangeI(n2, k2)); // 6

        int[] n3 = {1,3,6}; int k3 = 3;
        System.err.println(smallestRangeI(n3, k3)); // 0

        int[] n4 = {-7,-4,3,9,15}; int k4 = 4;
        System.err.println(smallestRangeI(n4, k4)); // 14

    }

    // -7 -4 3 9 15    k=4
    // -3 0 0 9 11
    public static int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int abs = Math.abs(max - min);
        return abs <= 2*k ? 0 : abs - 2*k;

    }

}
