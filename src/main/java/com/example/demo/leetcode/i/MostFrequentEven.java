package com.example.demo.leetcode.i;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2404. 出现最频繁的偶数元素
 *  给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *  如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/most-frequent-even-element
 *
 * @author Zeti
 * @date 2023/4/13 10:21
 */
public class MostFrequentEven {

    public static void main(String[] args) {
        int[] n1 = {0,1,4,4,2,2,1,1};
        System.err.println(mostFrequentEven(n1));   // 2

        int[] n2 = {4,4,4,9,2,4};
        System.err.println(mostFrequentEven(n2));   // 4

        int[] n3 = {29,47,21,41,13,37,25,7};
        System.err.println(mostFrequentEven(n3));   // -1


    }


    public static int mostFrequentEven(int[] nums) {
        int numCount = 0;    // 当前最小数字出现的次数
        int minNum = -1;    // 当前最小数字

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n % 2 != 0) {   // 奇数跳过
                continue;
            }

            // hash表中计数+1
            Integer ct = map.getOrDefault(n, 0);
            ct++;
            map.put(n, ct);

            // 当前数字出现的次数大于缓存值，替换
            if (ct > numCount) {
                minNum = n;
                numCount = ct;
            } else if (ct == numCount) {    // 出现次数相同，取最小的数字
                minNum = Math.min(minNum, n);
            }
        }
        return minNum;
    }

}
