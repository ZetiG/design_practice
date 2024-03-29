package com.example.demo.leetcode.i;

/**
 * Description: 2908. 元素和最小的山形三元组 I
 * 给你一个下标从 0 开始的整数数组 nums 。
 *
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 *
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 *
 * @author Zeti
 * @date 2024/3/29 09:16
 */
public class MinimumSum {

    public static void main(String[] args) {
        int[] n1 = {8,6,1,5,3};
        System.err.println(minimumSum(n1)); // 9

        int[] n2 = {5,4,8,7,10,2};
        System.err.println(minimumSum(n2)); // 13

        int[] n3 = {6,5,4,3,4,5};
        System.err.println(minimumSum(n3)); // -1

    }

    public static int minimumSum(int[] nums) {
        int len = nums.length;

        // 遍历后缀最小值，截止到下标2即可，因为题意要求找三元组，开始遍历找的时候下标肯定是从0,1 2开始
        int[] suf = new int[len];
        suf[len-1] = nums[len-1];   // 倒序初始化数字
        for (int i = len - 2; i > 1; i--) {
            suf[i] = Math.min(nums[i], suf[i+1]);
        }

        int res = Integer.MAX_VALUE;
        int pre = nums[0];  // 前缀最小值初始化
        for (int i = 1; i < len - 1; i++) {
            // 判断是否是山型，即(x<y>z)
            if (pre < nums[i] && nums[i] > suf[i+1]) {
                res = Math.min(res, pre + nums[i] + suf[i+1]);
            }
            pre = Math.min(pre, nums[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 8, 6, 1, 5, 3
    public static int minimumSum2(int[] nums) {
        int n = nums.length;

        int[] suf = new int[n]; // 后缀最小值
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }

        int ans = Integer.MAX_VALUE;
        int pre = nums[0]; // 前缀最小值
        for (int j = 1; j < n - 1; j++) {
            if (pre < nums[j] && nums[j] > suf[j + 1]) { // 山形
                ans = Math.min(ans, pre + nums[j] + suf[j + 1]); // 更新答案
            }
            pre = Math.min(pre, nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }



}
