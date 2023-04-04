package com.example.demo.leetcode.ii;

/**
 * Description: 53. 最大子数组和
 *  给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *  子数组 是数组中的一个连续部分。
 *
 * @author Zeti
 * @date 2023/4/4 15:11
 */
public class DP_MaxSubArray {

    public static void main(String[] args) {
        int[] n1 = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        System.err.println(maxSubArray(n1));

        int[] n2 = {1}; // 1
        System.err.println(maxSubArray(n2));

        int[] n3 = {5,4,-1,7,8};    // 23
        System.err.println(maxSubArray(n3));

        int[] n4 = {-2,1};   // 1
        System.err.println(maxSubArray(n4));

        int[] n5 = {-2,-1};   // -1
        System.err.println(maxSubArray(n5));

    }

    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    // DP 空间优化，每次只保留dp[i-1]的值即可求出dp[i]
    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }

    // DP 未优化
    public static int maxSubArray_dp(int[] nums) {
        int ln = nums.length;
        if (ln == 1) {
            return nums[0];
        }

        int[] dp = new int[ln];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    // 暴力循环，超时
    public static int maxSubArray_for(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int ct = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                max = Math.max(max, ct += nums[j]);
            }
        }
        return max;
    }


}
