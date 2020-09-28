package com.example.demo.algorithm;

/**
 * Description:  滑动窗口算法
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 *
 * @author Zeti
 * @date 2020/9/26 6:48 下午
 */
public class SlidingWindow {

    public static void main(String[] args) {

        int s = 8;

        int[] nums = {4,7, 3, 3, 2, 1, 4, 0, 6};

        int[] a = {2, 3, 1, 2, 4, 3};

        int i = minSubArrayLen(7, nums);

        System.err.println("最小数组长度为：" + i);

    }

    /**
     *  算法1
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int window = 0;

        while (right < n) {
            window += nums[right];
            while (window >= s) {
                res = Math.min(res, right - left + 1);
                window -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 滑动窗口算法2
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == s ? 1 : 0;

        int left = 0;   // 左边界
        int right = 0;  //右边界
        int window = 0; // 窗口内总和
        int res = Integer.MAX_VALUE; // 记录最小数组长度

        while (right < len) {
            for (; right < len && window < s; right++)
                window += nums[right];


            while (window >= s) {
                res = Math.min(res, right - left);

                window -= nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
