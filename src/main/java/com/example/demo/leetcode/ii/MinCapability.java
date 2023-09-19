package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 2560. 打家劫舍 IV
 *
 *  沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * 返回小偷的 最小 窃取能力。
 *
 * @author Zeti
 * @date 2023/9/19 10:47
 */
public class MinCapability {
    public static void main(String[] args) {
        int[] n1 = {2, 3, 5, 9};
        int k1 = 2;
        System.err.println(minCapability(n1, k1));

        int[] n2 = {2, 7, 9, 3, 1};
        int k2 = 2;
        System.err.println(minCapability(n2, k2));

    }


    public static int minCapability(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        while (min <= max) {
            int mid = (min + max) / 2;
            int ck = 0;
            boolean flag = false;
            for (int n : nums) {
                if (n <= mid && !flag) {
                    ck++;
                    flag = true;
                } else {
                    flag = false;
                }
            }

            if (ck >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }


}


