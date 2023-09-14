package com.example.demo.leetcode.ii;

/**
 * Description: 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * @author Zeti
 * @date 2023/9/11 11:12
 */
public class DP_CanPartition {

    public static void main(String[] args) {
        int[] n1 = {1,2,3,4,5};
        System.err.println(canPartition(n1));

        int[] n2 = {1,5,11,5};
        System.err.println(canPartition(n2));

        int[] n3 = {1,5,10,6};
        System.err.println(canPartition(n3));

        int[] n4 = {1,2,5};
        System.err.println(canPartition(n4));

        int[] n5 = {1,5,11,3};
        System.err.println(canPartition(n5));

    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    // 0-1背包填充
    // T=true F=false
    //             列数据：背包容量，
    //              0  1  2  3  4  5  6  7  8  9  10 11
    // nums[0]=1    F  T  F  F  F  F  F  F  F  F  F  F
    // nums[1]=5    F  T  F  F  F  T  T  F  F  F  F  F
    // nums[2]=11   F  T  F  F  F  T  T  F  F  F  F  T
    // nums[3]=5    F  T  F  F  F  T  T  F  F  F  T  T
    // 行数据：填充物品下标
    public static boolean canPartition2(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[length][target+1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            int nm = nums[i];
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];

                // 当当前物品=背包容量时，一定可以完全填充
                if (nm == j) {
                    dp[i][j] = true;
                } else if (nm < j) {
                    // 当当前物品小于背包容量时，看[上一个物品是否能完全填充该背包]或者[是否存在一个物品+当前物品刚好也能完全填充背包]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nm];
                }
            }
        }
        return dp[length-1][target];
    }



}
