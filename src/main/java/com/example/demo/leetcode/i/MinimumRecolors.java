package com.example.demo.leetcode.i;


/**
 * Description: 2379. 得到 K 个黑块的最少涂色次数
 *
 * 给你一个长度为 n下标从 0开始的字符串blocks，blocks[i]要么是'W'要么是'B'，表示第i块的颜色。字符'W' 和'B'分别表示白色和黑色。
 * 给你一个整数k，表示想要连续黑色块的数目。
 * 每一次操作中，你可以选择一个白色块将它 涂成黑色块。
 * 请你返回至少出现 一次连续 k个黑色块的 最少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 * 
 * @author Zeti
 * @date 2023/3/9 15:05
 */
public class MinimumRecolors {

    public static void main(String[] args) {
        String s1 = "WBBWWBBWBW";
        int k1 = 7;
        System.err.println(minimumRecolors2(s1, k1));

        String s2 = "WBWBBBW";
        int k2 = 2;
        System.err.println(minimumRecolors2(s2, k2));

        String s3 = "BWWWBB";
        int k3 = 6;
        System.err.println(minimumRecolors2(s3, k3));

        String s4 = "WWBWBWWBBB";
        int k4 = 4;
        System.err.println(minimumRecolors2(s4, k4));

    }

    // 输入：blocks = "WBBWWBBWBW", k = 7
    // 输出：3
    // 解释： 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。 得到 blocks = "BBBBBBBWBW" 。
    // 可以证明无法用少于 3 次操作得到 7 个连续的黑块。 所以我们返回 3 。

    // 输入：blocks = "WBWBBBW", k = 2
    // 输出：0
    // 解释：不需要任何操作，因为已经有 2 个连续的黑块。所以我们返回 0 。

    // 1.大小为k的滑动窗口，取窗口内变更数量最少的值
    public static int minimumRecolors(String blocks, int k) {
        if (k > blocks.length()) {
            return 0;
        }

        int left,right = k;
        int min = Integer.MAX_VALUE, sum = 0;
        int sLength = blocks.length();
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < sLength; i++) {
            if (i >= right) {
                min = Math.min(min, sum);
                right = i;
                left = i - k + 1;
                if (chars[left-1] == 'W') {
                    sum--;
                }
            }
            if (chars[i] == 'W') {
                sum++;
            }
        }
        min = Math.min(min, sum);
        return min;
    }


    // K=7
    // W B B W W B B W B W
    // 1 0 0 1 1 0 0 1 0 1
    // 1 1 1 2 3 3 3 4 4 5

    // K=4
    // W W B W B W W B B B
    // 1 1 0 1 0 1 1 0 0 0
    // 1 2 2 3 3 4 5 5 5 5
    // 前缀和
    public static int minimumRecolors2(String blocks, int k) {
        if (k > blocks.length()) {
            return 0;
        }

        int bmum=0;
        int[] ints = new int[blocks.length()];
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                bmum++;
            }
            ints[i] = bmum;
        }

        int min = ints[k-1];
            for (int i = k; i < ints.length; i++) {
            min = Math.min(min, ints[i]-ints[i-k]);
        }
        return min;
    }



}
