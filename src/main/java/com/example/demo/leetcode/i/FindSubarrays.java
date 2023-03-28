package com.example.demo.leetcode.i;

import java.util.HashMap;

/**
 * Description: 2395. 和相等的子数组
 *  给你一个下标从 0开始的整数数组nums，判断是否存在两个长度为2的子数组且它们的和相等。注意，这两个子数组起始位置的下标必须不相同。
 *  如果这样的子数组存在，请返回true，否则返回false。
 *  子数组 是一个数组中一段连续非空的元素组成的序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-subarrays-with-equal-sum
 * 
 * @author Zeti
 * @date 2023/3/28 11:53
 */
public class FindSubarrays {

    public static void main(String[] args) {
        int[] n1 = {4,2,4};
        System.err.println(findSubarrays(n1));

        int[] n2 = {1,2,3,4,5};
        System.err.println(findSubarrays(n2));

        int[] n3 = {0,0,0};
        System.err.println(findSubarrays(n3));

    }

    public static boolean findSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int i1 = nums[i] + nums[i + 1];
            if (null != map.get(i1)) {
                return true;
            }
            map.put(i1, 1);
        }
        return false;
    }
}
