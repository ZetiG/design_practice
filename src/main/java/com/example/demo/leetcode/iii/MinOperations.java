package com.example.demo.leetcode.iii;

import java.util.Arrays;

/**
 * Description: 2009. 使数组连续的最少操作数
 * 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 * 如果 nums 满足以下条件，那么它是 连续的 ：
 *      nums 中所有元素都是 互不相同 的。
 *      nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 *
 * 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 * 请你返回使 nums 连续 的 最少 操作次数。
 *
 * @author Zeti
 * @date 2024/4/8 14:02
 */
public class MinOperations {
    public static void main(String[] args) {
        int[] n1 = {4,2,5,3};
        System.err.println(minOperations(n1));  // 0

        int[] n2 = {1,2,3,5,6};
        System.err.println(minOperations(n2));  // 1

        int[] n3 = {1,10,100,1000};
        System.err.println(minOperations(n3));  // 3

        int[] n4 = {8,5,9,9,8,4};
        System.err.println(minOperations(n4));  // 2

    }

    // 4 5 8 8 9 9
    // 4 5 8 9   8 9
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);

        // 去重
        int x = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[x++] = nums[i];
            }
        }

        // 4 5 8 9 9 9
        int ans = 0;
        int left = 0;
        for (int right = 0; right < x; right++) {
            while (nums[left] < nums[right] - (nums.length - 1)) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return nums.length - ans;
    }


    public static int minOperations2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i]; // 原地去重
            }
        }

        int ans = 0;
        int left = 0;
        for (int i = 0; i < m; i++) {
            while (nums[left] < nums[i] - n + 1) { // nums[left] 不在窗口内
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }


}
