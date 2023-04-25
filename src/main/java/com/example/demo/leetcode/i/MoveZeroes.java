package com.example.demo.leetcode.i;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Description: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的【相对顺序】相对顺序不是排序，而是数组移动操作前的顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 *
 * @author Zeti
 * @date 2023/4/25 14:29
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] n1 = {0,4,0,3,12};
        System.err.println(Arrays.toString(moveZeroes(n1)));
    }

    public static int[] moveZeroes(int[] nums) {
        int zeroCt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCt++;
                continue;
            }
            int temp = nums[i - zeroCt];
            nums[i - zeroCt] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

}
