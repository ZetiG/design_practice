package com.example.demo.leetcode.ii;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1630. 等差子数组
 *  如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。
 *  更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i， s[i+1] - s[i] == s[1] - s[0] 都成立。
 *
 * 例如，下面这些都是 等差数列 ：
 *  1, 3, 5, 7, 9
 *  7, 7, 7, 7
 *  3, -1, -5, -9
 *
 * 下面的数列 不是等差数列 ：
 *  1, 1, 2, 5, 7
 *
 *  给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]] 。
 *  所有数组的下标都是 从 0 开始 的。 返回 boolean 元素构成的答案列表 answer 。
 *  如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是
 *  true；否则answer[i] 的值就是 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-subarrays
 *
 * @author Zeti
 * @date 2023/3/23 19:37
 */
public class CheckArithmeticSubarrays {

    public static void main(String[] args) {

        // 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
        // 输出：[true,false,true]
        int[] n1 = {4,6,5,9,3,7}, l1 = {0,0,2}, r1 = {2,3,5};
        System.err.println(checkArithmeticSubarrays(n1, l1, r1));

        // 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
        // 输出：[false,true,false,false,true,true]
        int[] n2 = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, l2 = {0,1,6,4,8,7}, r2 = {4,4,9,7,9,10};
        System.err.println(checkArithmeticSubarrays(n2, l2, r2));

    }


    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            // 获取字串长度下标
            int i1 = l[i];
            int r1 = r[i];

            boolean flag = true;
            int[] array = Arrays.stream(Arrays.copyOfRange(nums, i1, r1 + 1)).sorted().toArray();
            for (int j = 1; j < array.length - 1; j++) {
                if (!(array[j] - array[j - 1] == array[j + 1] - array[j])) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }


}
