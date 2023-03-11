package com.example.demo.leetcode.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1590. 使数组和能被 P 整除
 *
 * 给你一个正整数数组nums，请你移除 最短子数组（可以为 空），使得剩余元素的 和能被 p整除。 不允许将整个数组都移除。
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1。
 * 子数组定义为原数组中连续的一组元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p
 * 
 * @author Zeti
 * @date 2023/3/10 16:00
 */
public class MinSubarray {

    public static void main(String[] args) {
        int[] s1 = {3,1,4,2};
        int p1 = 6;
        System.err.println(1 == minSubarray(s1, p1));

        int[] s2 = {6,3,5,2};
        int p2 = 9;
        System.err.println(2 == minSubarray(s2, p2));

        int[] s3 = {1,2,3};
        int p3 = 3;
        System.err.println(0 == minSubarray(s3, p3));

        int[] s4 = {1,2,3};
        int p4 = 7;
        System.err.println(-1 == minSubarray(s4, p4));

        int[] s5 = {1000000000,1000000000,1000000000};
        int p5 = 3;
        System.err.println(0 == minSubarray(s5, p5));

    }
    // todo

    // 3,1,4,2 => 6
    // 3 4 8 10
    //
    // 3,1,2,2,2 => 6
    // 3 4 6 8 10
    public static int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }

        Map<Integer, Integer> index = new HashMap<>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            int i1 = (y - x + p) % p;
            if (index.containsKey(i1)) {
                res = Math.min(res, i - index.get(i1) + 1);
            }
        }

        return res == nums.length ? -1 : res;
    }


}
