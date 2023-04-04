package com.example.demo.leetcode.ii;

/**
 * Description: 918. 环形子数组的最大和
 *  给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
 *  环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
 *  子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray
 *
 * @author Zeti
 * @date 2023/4/4 15:11
 */
public class DP_MaxSubArray2 {

    public static void main(String[] args) {
        int[] n1 = {1,-2,3,-2}; // 3
        System.err.println(maxSubarraySumCircular(n1));

        int[] n2 = {1}; // 1
        System.err.println(maxSubarraySumCircular(n2));

        int[] n3 = {5,-3,5};    // 10
        System.err.println(maxSubarraySumCircular(n3));

        int[] n4 = {3,-2,2,-3};   // 3
        System.err.println(maxSubarraySumCircular(n4));

        int[] n5 = {-2,-1};   // -1
        System.err.println(maxSubarraySumCircular(n5));

        int[] n6 = {-2};   // -2
        System.err.println(maxSubarraySumCircular(n6));

    }

    public static int maxSubarraySumCircular(int[] nums) {
        int ln = nums.length;
        if (ln == 1) {
            return nums[0];
        }

        int arrayCount = 0;

        // 第一种情况：最大和的连续子数组在数组中间时
        int max = nums[0];
        int ct = 0;
        for (int i = 0; i < ln; i++) {
            arrayCount += nums[i];
            ct = Math.max(ct+nums[i], nums[i]);
            max = Math.max(max, ct);
        }

        // 第二种情况：最大和的连续子数组在数组首尾相连时
        // 求最小子数组的和，（数组总和 - 最小连续子数组的和 = 环形最大子数组的和）
        int min = nums[0];
        int cct = 0;
        for (int i = 1; i < ln-1; i++) {
            cct = Math.min(cct+nums[i], nums[i]);
            min = Math.min(min, cct);
        }

        return Math.max(max, arrayCount-min);
    }


}
