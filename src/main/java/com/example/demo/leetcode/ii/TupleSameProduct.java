package com.example.demo.leetcode.ii;

import java.util.HashMap;

/**
 * Description: 1726. 同积元组
 *
 *   给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
 * @author Zeti
 * @date 2023/10/19 10:28
 */
public class TupleSameProduct {

    public static void main(String[] args) {
        // 2,3,4,6 => 8
        int[] n1 = {2,3,4,6};
        System.err.println(tupleSameProduct(n1));

        // 1,2,4,5,10 => 16
        int[] n2 = {1,2,4,5,10};
        System.err.println(tupleSameProduct(n2));

    }


    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int nm = nums[i] * nums[j];
                map.put(nm, map.getOrDefault(nm, 0)+1);
            }
        }

        int ans = 0;
        for (Integer v : map.values()) {
            ans += v * (v - 1) * 4;
        }

        return ans;
    }


}
