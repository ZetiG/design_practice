package com.example.demo.leetcode.ii;

/**
 * Description: 152. 乘积最大子数组
 *  给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *  测试用例的答案是一个32-位 整数。
 *  子数组 是数组的连续子序列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-subarray
 *
 * @author Zeti
 * @date 2023/4/6 15:21
 */
public class DP_MaxProduct {

    public static void main(String[] args) {
        int[] n1 = {2,3,-2,4};  // 6
        System.err.println(maxProduct(n1));

        int[] n2 = {-2,2,3,-2,4};  // 96
        System.err.println(maxProduct(n2));

        int[] n3 = {-2,0,-1};  // 0
        System.err.println(maxProduct(n3));

        int[] n4 = {-2};  // -2
        System.err.println(maxProduct(n4));

        int[] n5 = {2,-2,-3};  // 12
        System.err.println(maxProduct(n5));


    }

    // DP、负负得正
    public static int maxProduct(int[] nums) {
        int res = nums[0];  // 返回结果
        int max = nums[0];  // 保存当前最大值，因为当最大值为正数时，乘以负数即变为最小的负数
        int min = nums[0];  // 保存当前最小值，因为当最小值为负数时，乘以负数即变为最大的正整数，即负数*负数=正数

        for (int i = 1; i < nums.length; i++) {
            // 当前数组元素为负数时，交换最大与最小值；
            // 因为：最大正数*负数=最小负数 最小负数*负数=最大正数
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }

}
