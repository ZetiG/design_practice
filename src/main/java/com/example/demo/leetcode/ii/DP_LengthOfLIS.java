package com.example.demo.leetcode.ii;

/**
 * Description: 300. 最长递增子序列
 *  给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *  子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/20 19:31
 */
public class DP_LengthOfLIS {

    public static void main(String[] args) {
//        int[] n1 = {10,9,2,5,3,7,101,18};
//        System.err.println(lengthOfLIS(n1)); // 4
//
//        int[] n2 = {0,1,0,3,2,3};
//        System.err.println(lengthOfLIS(n2)); // 4
//
//        int[] n3 = {7,7,7,7,7,7,7};
//        System.err.println(lengthOfLIS(n3)); // 1
//
//        int[] n4 = {2,15,3,7,17,18};
//        System.err.println(lengthOfLIS(n4)); // 5

        int[] n5 = {1,3,6,7,9,4,10,5,6};
        System.err.println(lengthOfLIS(n5)); // 6

    }


    // 2 15  3  7  17  18
    // 1  2  2  3   4   5
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];    // dp[n] = 数组前n个数中，最大递增子序
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}