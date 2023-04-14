package com.example.demo.leetcode.ii;

/**
 * Description: 931. 下降路径最小和 
 *  给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *  下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 
 *  (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/14 10:24
 */
public class DP_MinFallingPathSum {
    public static void main(String[] args) {
        int[][] m1 = {{2,1,3},{6,5,4},{7,8,9}};
        System.err.println(minFallingPathSum(m1)); // 输出：13

        int[][] m2 = {{-19,57},{-40,-5}};
        System.err.println(minFallingPathSum(m2)); // 输出：-59

        int[][] m3 = {{-48}};
        System.err.println(minFallingPathSum(m3)); // 输出：-48


    }

    // 2  1  3          //  1 2 3
    // 6  5  4          //  6 6 6
    // 7  8  9          //  9 8 3

    // 1 2 3
    // 9 8 3
    // 6 6 6
    public static int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        if (len == 1) {
            return matrix[0][0];
        }

        int[][] dp = new int[len][len];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == len - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
                }

                if (i == len - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }




}
