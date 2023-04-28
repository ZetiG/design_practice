package com.example.demo.leetcode.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 * @author Zeti
 * @date 2023/4/28 17:13
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] n1 = {1,1,1}; int k1 = 1;
        System.err.println(subarraySum(n1, k1));    // 2

        int[] n2 = {1,2,3,5,4,6,3}; int k2 = 6;
        System.err.println(subarraySum(n2, k2));    // 2

        int[] n3 = {1,-1,0}; int k3 = 0;
        System.err.println(subarraySum(n3, k3));    // 3


    }


    public static int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        map.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    // 1,-1,0
    // 1 0 0
    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > k) {
                continue;
            }
            if (sum == k) {
                res++;
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > k) {
                    break;
                }
                if (sum == k) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
