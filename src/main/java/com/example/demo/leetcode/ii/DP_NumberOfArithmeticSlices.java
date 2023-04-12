package com.example.demo.leetcode.ii;

/**
 * Description: 413. 等差数列划分
 *  如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *  例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 *  给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *  子数组 是数组中的一个连续序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-slices
 *
 * @author Zeti
 * @date 2023/4/12 11:42
 */
public class DP_NumberOfArithmeticSlices {

    public static void main(String[] args) {
        int[] n1 = {1,2,3,4}; // 3
        System.err.println(numberOfArithmeticSlices(n1));

        int[] n2 = {1}; // 0
        System.err.println(numberOfArithmeticSlices(n2));

        int[] n3 = {1,2,3,4,5,6,7,8,9}; // 28
        System.err.println(numberOfArithmeticSlices(n3));

        int[] n4 = {-1, 0, 1}; // 1
        System.err.println(numberOfArithmeticSlices(n4));

        int[] n5 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; // 1
        System.err.println(numberOfArithmeticSlices(n5));

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    // 输入：nums = [1,2,3,4] =>> [1, 2, 3]、[2, 3, 4]、 [1,2,3,4]
    public static int numberOfArithmeticSlices2(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        // 计算并记录数组内前后差值；这里节省空间不开辟新的数组，直接存入原数组，最后一个值为原数组的值
        for (int i = 1; i < len; i++) {
            nums[i-1] = nums[i] - nums[i-1];
        }
        nums[len-1] = Integer.MIN_VALUE;    // 干掉最后一个原数组的值

        // 求和结果
        int res = 0;

        int tmp = 2;    // 等差数组的个数，由于当前的nums数组内存的是前后差值，所以num[0]表示的两个数的差
        int n = nums[0];    // 当前等差数组的差值
        for (int i = 1; i < nums.length; i++) {
            if (n == nums[i]) { // 值相同，代表是等差数组，个数+1
                tmp++;
            } else {
                // 值不同，则代表和前面的不等差，先把前面缓存的值计算后，再从当前继续向后
                res += (tmp-2) * (tmp-1) / 2;
                n = nums[i];
                tmp = 2;
            }
        }
        // 这里处理整个数组都是等差的情况，该情况下循环里并未计算结果
        res += (tmp-2) * (tmp-1) / 2;
        return res;
    }

}
