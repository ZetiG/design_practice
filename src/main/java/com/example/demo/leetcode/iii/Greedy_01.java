package com.example.demo.leetcode.iii;

import java.util.Arrays;

/**
 * Description: 贪心算法-分糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * ps1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * <p>
 * ps2:
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件
 *
 * @author Zeti
 * @date 2022/3/4 4:25 PM
 */
public class Greedy_01 {

    public static void main(String[] args) {
        int[] a1 = {1, 0, 2};
        int[] a2 = {1, 2, 2};
        int[] a3 = {1, 3, 2, 2, 1};
        int[] a4 = {1, 2, 87, 87, 87, 2, 1};
        // 应得苹果数 1  2  3   1   3   2  1

        // 不成环状
        System.err.println(candy(a1)); // 5
        System.err.println(candy(a2)); // 4
        System.err.println(candy(a3)); // 7
        System.err.println(candy(a4)); // 13
        System.err.println(candy(new int[]{3, 4, 0, 1})); // 6

        // --------------------------
        // 成环状
        System.err.println(candy2(new int[]{3, 4, 0, 1}));  // 10

        System.err.println(candy2(new int[]{2, 1, 6, 4, 3, 3, 3})); // 13


    }

    // 单队列排队，前后遍历
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }


    // 环状排队
    public static int candy2(int[] ratings) {
        // 3, 4, 0, 1
        // 2, 1, 6, 4, 3, 3, 3       2 + 1 + 3 + 2 + 1 + 1 + 3 = 13

        // 1. 找出最小值下标
        int minIdx = 0;
        int min = ratings[0];
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] < min) {
                min = ratings[i];
                minIdx = i;
            }
        }

        // 定义结果集
        int[] ct = new int[ratings.length];

        // 得到最小值以及下标后，从最小值处向后循环
        for (int i = minIdx; i < ratings.length; i++) {

            if (i > minIdx && ratings[i] > ratings[i - 1]) {
                ct[i] = ct[i - 1] + 1;
            } else {
                ct[i] = 1;
            }
        }

        // 上一步，反向循环
        for (int i = ratings.length - 1; i > minIdx; i--) {
            if (i < ratings.length - 1 && ratings[i - 1] > ratings[i]) {
                ct[i - 1] = Math.max(ct[i - 1], ct[i] + 1);
            } else {
                ct[i] = Math.max(ct[i], 1);
            }
        }

        // 循环前半部分
        for (int i = minIdx; i >= 0; i--) {
            if (i < minIdx && ratings[i] > ratings[i + 1]) {
                ct[i] = ct[i + 1] + 1;
            } else {
                ct[i] = 1;
            }
        }

        // 上一步，反向循环
        for (int i = 0; i < minIdx; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                ct[i] = Math.max(ct[i], ct[i - 1] + 1);
            } else {
                ct[i] = Math.max(ct[i], 1);
            }

        }

        // 处理首尾
        if (ratings[0] > ratings[ratings.length - 1] && ct[0] <= ct[ratings.length - 1]) {
            int tmp = ct[0];
            for (int i = 0; i < ct.length - 1; i++) {
                if (i == 0) {
                    ct[0] = ct[ratings.length - 1] + 1;
                    continue;
                }

                if (ct[i] > tmp) {
                    tmp = ct[i];
                    ct[i] = ct[i - 1] + 1;
                }
            }

        } else if (ratings[0] < ratings[ratings.length - 1] && ct[0] >= ct[ratings.length - 1]) {
            int tmp = ct[ratings.length - 1];
            for (int i = ratings.length - 1; i >= 0; i--) {
                if (i == ratings.length - 1) {
                    ct[ratings.length - 1] = ct[0] + 1;
                    continue;
                }

                if (ct[i] > tmp) {
                    tmp = ct[i];
                    ct[i] = ct[i + 1] + 1;
                }
            }
        }

        return Arrays.stream(ct).sum();
    }


}
