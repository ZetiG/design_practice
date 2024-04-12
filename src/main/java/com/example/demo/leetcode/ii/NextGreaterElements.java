package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: 503. 下一个更大元素 II
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * @author Zeti
 * @date 2024/4/12 14:51
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        int[] n1 = {1,2,1};
        System.err.println(Arrays.toString(nextGreaterElements(n1)));   // [2,-1,2]

        int[] n2 = {1,2,3,4,3};
        System.err.println(Arrays.toString(nextGreaterElements(n2)));   // [2,3,4,-1,4]

    }


    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 1) {
            return new int[]{-1};
        }
        
        // 找出数组中最后一个最大值，
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIdx = nums[i] >= nums[maxIdx] ? i : maxIdx;
        }

        int[] res = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = maxIdx; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() <= nums[i]) {
                deque.pop();
            }
            res[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
        }

        for (int i = nums.length-1; i > maxIdx; i--) {
            while (!deque.isEmpty() && deque.peek() <= nums[i]) {
                deque.pop();
            }
            res[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
        }
        return res;
    }

}
