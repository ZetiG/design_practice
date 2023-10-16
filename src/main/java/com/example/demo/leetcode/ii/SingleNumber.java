package com.example.demo.leetcode.ii;

import org.apache.flink.shaded.guava18.com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description: 260. 只出现一次的数字 III
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 *
 * @author Zeti
 * @date 2023/10/16 17:12
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] n1 = {1,2,1,3,2,5};
        System.err.println(Arrays.toString(singleNumber(n1)));

        int[] n2 = {-1,0};
        System.err.println(Arrays.toString(singleNumber(n2)));

        int[] n3 = {0,1};
        System.err.println(Arrays.toString(singleNumber(n3)));

    }

    public static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);  // 先排序，出现两次的数字会排在一起
        Integer res1 = null, res2 = null;
        // -1,1,1,2,2,3,5
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i < len-1 && nums[i+1] - nums[i] == 0) {
                ++i;
            } else {
                if (res1 == null) {
                    res1 = nums[i];
                } else {
                    res2 = nums[i];
                }
            }
        }
        return new int[]{res1, res2};
    }


    // 遍历，开辟额外存储空间
    public static int[] singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }



}
