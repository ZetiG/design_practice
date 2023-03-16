package com.example.demo.leetcode.iii;


import java.util.Arrays;

/**
 * Description: 2488. 统计中位数为 K 的子数组
 *  给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *  统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * 注意：
 *  数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 *  例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 *  子数组是数组中的一个连续部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-subarrays-with-median-k
 *
 * @author Zeti
 * @date 2023/3/16 15:07
 */
public class CountSubarrays {

    public static void main(String[] args) {

        int[] n1 = {3,2,1,4,5}; int k1 = 4;
        // res = 3
        System.err.println(3 == countSubarrays(n1, k1));

        int[] n2 = {2,3,1}; int k2 = 3;
        // res = 1
        System.err.println(1 == countSubarrays(n2, k2));

        int[] n3 = {2,5,1,4,3,6}; int k3 = 1;
        // res = 3
        System.err.println(3 == countSubarrays(n3, k3));

    }

    // 暴力解法，TLE超时
    // nums = [3,2,1,4,5], k = 4
    //解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
    public static int countSubarrays(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] ints = subAndSort(nums, i, j);

                // 偶数量
                int len = ints.length;
                if(len % 2 == 0) {
//                    if ((ints[len/2] + ints[len/2-1]) / 2 == k) {
                    // 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，
                    // 如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
                    if ((ints[len/2-1]) == k) {
                        total++;
                    }
                } else {
                    // 奇数量
                    if (ints[len/2] == k) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    private static int[] subAndSort(int[] nums, int startIdx, int endIdx) {
        int[] ints = Arrays.copyOfRange(nums, startIdx, endIdx+1);
        Arrays.sort(ints);
        return ints;
    }

}
