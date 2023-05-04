package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/4 16:34
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4};
        System.err.println(Arrays.toString(productExceptSelf(n1)));  // [24,12,8,6]

        int[] n2 = {-1, 1, 0, -3, 3};
        System.err.println(Arrays.toString(productExceptSelf(n2)));  // [0,0,9,0,0]


    }

    // 1,2,3,4
    // 1 2 6 24
    //
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int[][] tmp = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                tmp[i][0] = 1;
                tmp[len-1][1] = 1;
            } else {
                tmp[i][0] = nums[i-1] * tmp[i-1][0];
                tmp[len-i-1][1] = nums[len-i] * tmp[len-i][1];
            }

            if (i >= len-i-1) {
                res[i] = tmp[i][0] * tmp[i][1];
                res[len-i-1] = tmp[len-i-1][0] * tmp[len-i-1][1];
            }
        }

        return res;
    }

}
