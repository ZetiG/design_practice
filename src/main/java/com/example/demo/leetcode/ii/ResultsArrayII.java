package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 3255. 长度为 K 的子数组的能量值 II
 *
 *  给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 *  一个数组的 能量值 定义为：
 *      - 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 *      - 否则为 -1 。
 *  你需要求出 nums 中所有长度为 k 的 子数组的能量值。
 *  请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 *
 *  定义范围：
 *  1 <= n == nums.length <= 105
 *  1 <= nums[i] <= 106
 *  1 <= k <= n
 *
 * @author Zeti
 * @date 2024/11/7 14:01
 */
public class ResultsArrayII {
    public static void main(String[] args) {
        // [1,2,3,4,3,2,5] 该数组共5个长度为k的子数组：
        // [1, 2, 3] 中最大元素为 3 。
        // [2, 3, 4] 中最大元素为 4 。
        // [3, 4, 3] 中元素 不是 连续的。
        // [4, 3, 2] 中元素 不是 上升的。
        // [3, 2, 5] 中元素 不是 连续的。
        int[] n1 = {1,2,3,4,3,2,5};
        int k1 = 3;
        System.err.println(Arrays.toString(resultsArray(n1, k1))); // [3,4,-1,-1,-1]

        int[] n2 = {2,2,2,2,2};
        int k2 = 4;
        System.err.println(Arrays.toString(resultsArray(n2, k2))); // [-1,-1]

        int[] n3 = {3,2,3,2,3,2};
        int k3 = 2;
        System.err.println(Arrays.toString(resultsArray(n3, k3))); // [-1,3,-1,3,-1]

        int[] n4 = {1,7,8};
        int k4 = 2;
        System.err.println(Arrays.toString(resultsArray(n4, k4))); // [-1,8]

        int[] n5 = {1,1};
        int k5 = 1;
        System.err.println(Arrays.toString(resultsArray(n5, k5))); // [1]

    }

    public static int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] - nums[i - 1] != 1) {
                cnt = 1;
            } else {
                cnt++;
            }

            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;

    }



}
