package com.example.demo.leetcode.ii;

/**
 * Description: 45. 跳跃游戏 II
 *
 *  给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *  每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *  0 <= j <= nums[i]
 *  i + j < n
 *  返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 *
 * @author Zeti
 * @date 2023/3/1 16:16
 */
public class Greedy_jump {

    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        // 输出: 2

        int[] n1 = {2,3,1,1,4};
        System.err.println(2 == jump(n1));

        int[] n2 = {2,3,0,1,4};
        System.err.println(2 == jump(n2));

        int[] n3 = {1,2};
        System.err.println(1 == jump(n3));

        int[] n4 = {1,2,3};
        System.err.println(2 == jump(n4));

        int[] n5 = {2,3,1};
        System.err.println(1 == jump(n5));

    }

    // {2, 3, 1, 1, 4}
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int total = nums.length - 1;
        int jump = 0;

        while (total > 0) {
            int j = 0;
            // 贪心，倒序思考，每次找距离终点最远距离
            for (int i = total - 1; i >= 0; i--) {
                if (total - i <= nums[i]) {
                    j = i;
                }
            }
            total = j;
            jump++;
        }
        return jump;
    }


}
