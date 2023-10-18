package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 1984. 学生分数的最小差值
 *
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * 返回可能的 最小差值 。
 *
 * @author Zeti
 * @date 2023/10/18 14:59
 */
public class MinimumDifference {
    public static void main(String[] args) {
        int[] n1 = {9, 4, 1, 7};
        int k1 = 2;
        System.err.println(minimumDifference(n1, k1));

    }


    public static int minimumDifference(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            res = Math.min(res, nums[i+k-1] - nums[i]);
        }

        return res;
    }

}
