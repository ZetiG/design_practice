package com.example.demo.leetcode.ii;

/**
 * Description: 55. 跳跃游戏
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 *
 * @author Zeti
 * @date 2023/4/3 11:45
 */
public class DP_CanJump {

    public static void main(String[] args) {

        int[] n1 = {2,3,1,1,4};   // true
        System.err.println(canJump(n1));

        int[] n2 = {3,2,1,0,4};   // false
        System.err.println(canJump(n2));

        int[] n3 = {0};   // true
        System.err.println(canJump(n3));

        int[] n4 = {0, 1};   // false
        System.err.println(canJump(n4));

        int[] n5 = {1, 0};   // true
        System.err.println(canJump(n5));

        int[] n6 = {2, 0, 0};   // true
        System.err.println(canJump(n6));

        int[] n7 = {1, 2, 0, 1};   // true
        System.err.println(canJump(n7));

    }

    // [2,3,1,1,4]
    // [3,2,1,0,4]
    public static boolean canJump(int[] nums) {
        int ln = nums.length;
        if (ln <= 1) {
            return true;
        }

        for (int i = ln-2, j=ln-1; i >= 0; i--) {
            if (nums[i] >= j - i) {
                j = i;
                if (i == 0) {
                    return true;
                }
            }
        }
        return false;
    }


}
