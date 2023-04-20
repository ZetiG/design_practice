package com.example.demo.leetcode.ii;

/**
 * Description: 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @author Zeti
 * @date 2023/4/20 10:59
 */
public class DP_MaximalSquare {
    public static void main(String[] args) {
        char[][] m1 = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.err.println(maximalSquare(m1));  // 4

        char[][] m2 = {{'0','1'}, {'1','0'}};
        System.err.println(maximalSquare(m2));  // 1

        char[][] m3 = {{'0'}};
        System.err.println(maximalSquare(m3));  // 0

        char[][] m4 = {{'1','1','1','1','0'}, {'1','1','1','1','0'}, {'1','1','1','1','1'}, {'1','1','1','1','1'}, {'0','0','1','1','1'}};
        System.err.println(maximalSquare(m4));  // 16

        char[][] m5 = {{'0','1'}, {'1','0'}};
        System.err.println(maximalSquare(m5));  // 1

        // [['0','0','0','0','0'],['0','0','0','0','0'],['0','0','0','0','1'],['0','0','0','0','0']]
        char[][] m6 = {{'0','0','0','0','0'}, {'0','0','0','0','0'}, {'0','0','0','0','1'}, {'0','0','0','0','0'}};
        System.err.println(maximalSquare(m6));  // 1


    }

    public static int maximalSquare(char[][] matrix) {
        int res = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

    //  1  0  1  0  0
    //  1  0  1  1  1
    //  1  1  1  1  1
    //  1  0  0  1  0

    // '1','1','1','1','0'
    // '1','1','1','1','0'
    // '1','1','1','1','1'
    // '1','1','1','1','1'
    // '0','0','1','1','1'
    public static int maximalSquare_2(char[][] matrix) {
        int max_side = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];  // 记录当前位置最大正方形的边长
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // 边界
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - 48;   // matrix内存储的为字符，0、1转为十进制数字
                } else {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    if (min == 0 || matrix[i][j] == '0') {
                        dp[i][j] = matrix[i][j] - 48;
                    } else {
                        dp[i][j] = min + 1;
                    }
                }
                max_side = Math.max(max_side, dp[i][j]);
            }
        }
        return max_side * max_side;
    }


}
