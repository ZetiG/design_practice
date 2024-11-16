package com.example.demo.leetcode.i;

/**
 * Description: 3184. 构成整天的下标对数目 I
 *
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 *
 * @author Zeti
 * @date 2024/10/23 11:44
 */
public class countCompleteDayPairs_I {
    public static void main(String[] args) {
        //输入： hours = [12,12,30,24,24]
        //输出： 2

        //输入： hours = [72,48,24,3]
        //输出： 3
        //构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。

        int[] h1 = {12,12,30,24,24};
        System.err.println(countCompleteDayPairs(h1));  // 2 分别是 (0, 1) 和 (3, 4)。

        int[] h2 = {72,48,24,3};
        System.err.println(countCompleteDayPairs(h2));  // 3: (0, 1)、(0, 2) 和 (1, 2)。

        int[] h3 = {};
        System.err.println(countCompleteDayPairs(h3));


    }

    public static int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for (int i = 0; i < hours.length-1; i++) {
            for (int j = i+1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
