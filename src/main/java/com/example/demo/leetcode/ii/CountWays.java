package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 2580. 统计将重叠区间合并成组的方案数
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
 *
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 *      每个区间只属于一个组。
 *      两个有 交集 的区间必须在 同一个 组内。
 *      如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 *
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 109 + 7 取余 后返回。
 *
 * @author Zeti
 * @date 2024/3/27 15:44
 */
public class CountWays {

    public static void main(String[] args) {
        int[][] r1 = {{6,10},{5,15}};
        System.err.println(countWays(r1)); // 2

        int[][] r2 = {{1,3},{10,20},{2,5},{4,8}};
        System.err.println(countWays(r2)); // 4

        int[][] r3 = {{5,12},{16,28},{32,41},{7,15},{17,26},{41,46},{1,12}};
        System.err.println(countWays(r3)); // 8

    }

    public static int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int res = 2;
        int end = ranges[0][1];

        for (int i = 1; i < ranges.length; i++) {
            int[] curr = ranges[i];
            if (curr[0] > end) {
                res = res * 2 % 1000000007;
            }
            end = Math.max(end, curr[1]);
        }
        return res;
    }





}
