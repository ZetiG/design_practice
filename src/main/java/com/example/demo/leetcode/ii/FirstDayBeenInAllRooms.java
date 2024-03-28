package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 1997. 访问完所有房间的第一天
 * 你需要访问 n 个房间，房间从 0 到 n - 1 编号。同时，每一天都有一个日期编号，从 0 开始，依天数递增。你每天都会访问一个房间。
 *
 * 最开始的第 0 天，你访问 0 号房间。给你一个长度为 n 且 下标从 0 开始 的数组 nextVisit 。在接下来的几天中，你访问房间的 次序 将根据下面的 规则 决定：
 *
 * 假设某一天，你访问 i 号房间。
 * 如果算上本次访问，访问 i 号房间的次数为 奇数 ，那么 第二天 需要访问 nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i 。
 * 如果算上本次访问，访问 i 号房间的次数为 偶数 ，那么 第二天 需要访问 (i + 1) mod n 号房间。
 * 请返回你访问完所有房间的第一天的日期编号。题目数据保证总是存在这样的一天。由于答案可能很大，返回对 109 + 7 取余后的结果。
 *
 * @author Zeti
 * @date 2024/3/28 10:22
 */
public class FirstDayBeenInAllRooms {
    public static void main(String[] args) {

        int[] n1 = {0,1,2,0,3};
        System.err.println(firstDayBeenInAllRooms2(n1)); // 2

//        int[] n2 = {0,0,2};
//        System.err.println(firstDayBeenInAllRooms(n2)); // 6
//
//        int[] n3 = {0,1,2,0};
//        System.err.println(firstDayBeenInAllRooms(n3)); // 6
//
//        int[] n4 = {0,0,0,0,0};
//        System.err.println(firstDayBeenInAllRooms(n4)); // 30

    }

    // 0,1,2,0,3

    // 0 0 1 1 2 2 3
    // 0 1 2 3 4 5 6 7 8 9 10
    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        int[] visitFrequency = new int[nextVisit.length];
        System.err.println(Arrays.toString(visitFrequency));

        int visitIdx = 0;
        int res = 0;
        while (visitIdx < nextVisit.length-1) {
            visitFrequency[visitIdx]++;
            System.err.println(Arrays.toString(visitFrequency));

            res++;
            int frequency = visitFrequency[visitIdx];
            if (frequency % 2 == 0) {   // 偶数
                visitIdx = (visitIdx + 1) % nextVisit.length;
            } else {    // 奇数
                visitIdx = nextVisit[visitIdx];
            }
        }
        return res;
    }

    // [0, 0, 0, 0, 0]
    // [1, 0, 0, 0, 0]
    // [2, 0, 0, 0, 0]
    // [2, 1, 0, 0, 0]
    // [2, 2, 0, 0, 0]
    // [2, 2, 1, 0, 0]
    // [2, 2, 2, 0, 0]
    // [2, 2, 2, 1, 0]
    // [3, 2, 2, 1, 0]
    // [4, 2, 2, 1, 0]
    // [4, 3, 2, 1, 0]
    // [4, 4, 2, 1, 0]
    // [4, 4, 3, 1, 0]
    // [4, 4, 4, 1, 0]
    // [4, 4, 4, 2, 0]
    public static int firstDayBeenInAllRooms2(int[] nextVisit) {
        final long MOD = 1_000_000_007;
        long[] visitFrequency = new long[nextVisit.length];

        for (int i = 0; i < nextVisit.length-1; i++) {
            int next = nextVisit[i];

            // + MOD 避免算出负数
            visitFrequency[i + 1] = (visitFrequency[i] * 2 - visitFrequency[next] + 2 + MOD) % MOD;
        }
        return (int) visitFrequency[nextVisit.length-1];
    }
}
