package com.example.demo.leetcode.iii;

/**
 * Description: 贪心算法-分糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * ps1：
 *  输入：ratings = [1,0,2]
 *  输出：5
 *  解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * ps2:
 *  输入：ratings = [1,2,2]
 *  输出：4
 *  解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *       第三个孩子只得到 1 颗糖果，这满足题面中的两个条件
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
       // 应得苹果数  1  2  3   1   3   2  1

        System.err.println(candy(a1)); // 5
        System.err.println(candy(a2)); // 4
        System.err.println(candy(a3)); // 7
        System.err.println(candy(a4)); // 13

    }

    // 前后遍历
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


}
