package com.example.demo.leetcode.i;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/3/28 15:55
 */
public class NumArray {
    public static void main(String[] args) {
        int[] n1 = {-2,0,3,-5,2,-1};
        NumArray na = new NumArray(n1);
        System.err.println(na.sumRange(0, 2));  // 1
        System.err.println(na.sumRange(2, 5));  // -1
        System.err.println(na.sumRange(0, 5));  // -3

    }

    int[] arr;

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return arr[right];
        }
        return arr[right] - arr[left-1];
    }
}
