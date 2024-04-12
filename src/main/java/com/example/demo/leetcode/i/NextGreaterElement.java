package com.example.demo.leetcode.i;

import java.util.*;

/**
 * Description: 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素
 * 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * @author Zeti
 * @date 2024/4/12 14:22
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] n1_1 = {4,1,2};
        int[] n2_1 = {1,3,4,2};
        System.err.println(Arrays.toString(nextGreaterElement(n1_1, n2_1))); // [-1,3,-1]

        int[] n1_2 = {2,4};
        int[] n2_2 = {1,2,3,4};
        System.err.println(Arrays.toString(nextGreaterElement(n1_2, n2_2))); // [3,-1]

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        // 维护单调栈
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = nums2.length-1; i >= 0; --i) {
            int nm = nums2[i];
            //
            while (!deque.isEmpty() && nm > deque.peek()) {
                deque.pop();
            }
            map.put(nm, deque.isEmpty() ? -1 : deque.peek());
            deque.push(nm);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}
