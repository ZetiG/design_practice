package com.example.demo.leetcode.ii;

/**
 * Description: 1014. 最佳观光组合
 * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点i 和j之间的 距离 为j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-sightseeing-pair
 *
 * @author Zeti
 * @date 2023/4/7 15:10
 */
public class DP_MaxScoreSightseeingPair {

    public static void main(String[] args) {
//        int[] n1 = {8,1,5,2,6}; // 11
//        System.err.println(maxScoreSightseeingPair(n1));
//
//        int[] n2 = {1,2};   // 2
//        System.err.println(maxScoreSightseeingPair(n2));
//
//        int[] n3 = {1,3,5};   // 7
//        System.err.println(maxScoreSightseeingPair(n3));
//
//        int[] n4 = {8,1,5,2,6};   // 11
//        System.err.println(maxScoreSightseeingPair(n4));

        int[] n5 = {1,2,2};   // 13
        //          0 1 2
        // val[i] + val[j] + i - j
        System.err.println(maxScoreSightseeingPair(n5));


    }

    // 8,1,5,2,6
    // 0 1 2 3 4
    //
    // values[i] + values[j] + i - j
    //             ||
    //            \||/
    // max[(values[i] + i) + (values[j] - j)]
    public static int maxScoreSightseeingPair(int[] values) {
        int res = Integer.MIN_VALUE;
        int left = values[0];

        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, left + values[j] - j);
            left = Math.max(left, values[j] + j);
        }
        return res;
    }



}
