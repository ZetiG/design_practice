package com.example.demo.leetcode.ii;

/**
 * Description: 213. 打家劫舍 II
 *  你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈，
 *  这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *  给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-ii
 *
 * @author Zeti
 * @date 2023/4/3 10:52
 */
public class DP_Burglary2 {

    public static void main(String[] args) {
        int[] n1 = {2,3,2}; // 3
        System.err.println(rob(n1));

        int[] n2 = {1,2,3,1}; // 4
        System.err.println(rob(n2));

        int[] n3 = {1,2,3}; // 3
        System.err.println(rob(n3));

        int[] n4 = {2,1}; // 2
        System.err.println(rob(n4));

        int[] n5 = {1,2,1,1}; // 3
        System.err.println(rob(n5));

    }


    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(maxRob(nums, 0, nums.length-2), maxRob(nums, 1, nums.length-1));
    }

    // 根据题意，可将环形拆解为两个非环形链表
    private static int maxRob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
