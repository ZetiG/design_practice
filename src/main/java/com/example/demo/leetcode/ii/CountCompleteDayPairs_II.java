package com.example.demo.leetcode.ii;

/**
 * Description: 3185. 构成整天的下标对数目 II
 *
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 *
 * @author Zeti
 * @date 2024/10/23 10:59
 */
public class CountCompleteDayPairs_II {
    public static void main(String[] args) {

        int[] h1 = {12,12,30,24,24};
        System.err.println(countCompleteDayPairs(h1));  // 2 分别是 (0, 1) 和 (3, 4)。

        int[] h2 = {72,48,24,3};
        System.err.println(countCompleteDayPairs(h2));  // 3: (0, 1)、(0, 2) 和 (1, 2)。

        int[] h3 = {};
        System.err.println(countCompleteDayPairs(h3));

    }


    // 当 (i + j) % 24 == 0 时，即满足：(i % 24 + j % 24) % 24 == 0
    public static long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        int[] cnt = new int[24];
        for (int hour : hours) {
            ans += cnt[(24 - hour % 24) % 24];
            cnt[hour % 24]++;
        }
        return ans;
    }


    public static long countCompleteDayPairs2(int[] hours) {
        long res = 0L;
        int[] cnt = new int[24];
        int zeroCnt = 0;
        for(int hour : hours){
            // 当前值取模24得余数m
            int m = hour % 24;
            if(m == 0){
                res += zeroCnt;
                zeroCnt++;
            } else {
                //
                res += cnt[24 - m];
                cnt[m]++;
            }
        }
        return res;
    }

}