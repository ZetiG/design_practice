package com.example.demo.leetcode.ii;

/**
 * Description: 2834. 找出美丽数组的最小和
 * 给你两个正整数：n 和 target 。
 *
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 *
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
 *
 * @author Zeti
 * @date 2024/3/8 10:57
 */
public class MinimumPossibleSum {

    public static void main(String[] args) {
        System.err.println(minimumPossibleSum(2, 3)); // [1,3]  = 4
        System.err.println(minimumPossibleSum(3, 3)); // [1,3,4]  = 8
        System.err.println(minimumPossibleSum(1, 1)); // [1]  = 1
        System.err.println(minimumPossibleSum(3, 5)); // [1,2,5]  = 8

    }

    // 1,2,3,4,5,6... 添加了x之后，就不能添加(target−x)，因此最大可以添加到(target/2)
    public static int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;  // 题目要求对结果取模当前值

        int m = target / 2;    // 求和最小，肯定从1,2,3... 开始，添加了x之后，就不能添加(target−x)，因此最大可以添加到(target/2)
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 + ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }


}
