package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 31. 下一个排列
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 
 * 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 *
 * @author Zeti
 * @date 2023/6/16 16:09
 */
public class NextPermutation {

    // 题意解释， 例如数组[1,2,3]
    // 它所有的排列组合为：[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
    // 对应的整数为：123， 132，312，321
    // 即当前数组[1,2,3] => 123 对应的下一个比它大的整数为 132 => [1,3,2]
    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        System.err.println(Arrays.toString(nextPermutation(n1)));

        int[] n2 = {1,3,2};
        System.err.println(Arrays.toString(nextPermutation(n2)));

        int[] n3 = {2,1,3};
        System.err.println(Arrays.toString(nextPermutation(n3)));

        int[] n4 = {2,3,1};
        System.err.println(Arrays.toString(nextPermutation(n4)));

        int[] n5 = {3,1,2};
        System.err.println(Arrays.toString(nextPermutation(n5)));

        int[] n6 = {3,2,1};
        System.err.println(Arrays.toString(nextPermutation(n6)));

        int[] n7 = {1,1,5};
        System.err.println(Arrays.toString(nextPermutation(n7)));

        int[] n8 = {5,4,7,5,3,2};
        System.err.println(Arrays.toString(nextPermutation(n8)));

    }

    public static int[] nextPermutation(int[] nums) {
        int len = nums.length;

        // 判断当前数字是否已经是最大值，如果是则需要单独处理
        boolean isMax = true;
        for (int i = 0; i < len-1; i++) {
            if (nums[i] < nums[i+1]) {
                isMax = false;
            }
        }
        // 当前数组已经是最大值，则进行数组翻转，转为最小数组，即为结果
        if (isMax) {
            for (int i = 0; i < len/2; i++) {
                int tmp = nums[i];
                nums[i] = nums[len - i - 1];
                nums[len - i - 1] = tmp;
            }
            return nums;
        }

        // 当前数组非最大值，如下处理
        // 从倒数第二个数字开始，从后向前遍历到当前数字，找到第一个比它大的值进行位置替换
        // 标记当前是否已替换过最大值：true为替换过，false未替换过
        boolean flag = false;   // 核心就在这里！！！

        for (int i = len-2; i >= 0; i--) {
            int j = len-1;
            while (j > i) {
                // 如果未替换过最大值，则每次while循环判断的都是下面这块逻辑，且找的都是比当前nums[i]大的值，满足则替换
                if (!flag && nums[j] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    // 将标记改为替换过最大值，同时初始化i，j坐标
                    flag = true;
                    i+=1;
                    j = len-1;
                }

                // 这里可用尾部数组排序进行优化
                // 如果已经替换过最大值，则每次while循环判断的是当前逻辑，且找的都是比当前nums[i]小的值，满足则替换
                if (flag && nums[j] < nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    // 当前下标i的值已经是满足条件的最小值，则继续向后处理i=i+1, j永远都是从数组尾部开始;
                    i+=1;
                    j = len-1;
                }
                j--;
            }
            // 当前i循环结束，且已完成替换，直接结束
            if (flag) {
                break;
            }
        }
        return nums;
    }

}
