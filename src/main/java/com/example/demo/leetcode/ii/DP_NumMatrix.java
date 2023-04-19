package com.example.demo.leetcode.ii;

/**
 * Description: 304. 二维区域和检索 - 矩阵不可变
 *
 * @author Zeti
 * @date 2023/4/19 10:12
 */
public class DP_NumMatrix {
    int[][] sum;

    public static void main(String[] args) {
        // 方法1 前缀和，行前缀和
        int[][] m1 = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        DP_NumMatrix mt1 = new DP_NumMatrix(m1);
        System.err.println(mt1.sumRegion(2,1,4,3));
        System.err.println(mt1.sumRegion(1,1,2,2));
        System.err.println(mt1.sumRegion(1,2,2,4));

        int[][] m2 = {{-1}};
        DP_NumMatrix mt2 = new DP_NumMatrix(m2);
        System.err.println(mt2.sumRegion(0,0,0,0));


        // 方法2 前缀和，行+列前缀和
        // sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
        //
        // sumRegion(row,col,row ,col) = sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1]

    }

    // [3,0,1,4,2]
    // [5,6,3,2,1]
    // [1,2,0,1,5]
    // [4,1,0,1,7]
    // [1,0,3,0,5]
    public DP_NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] mtr = matrix[i];
            sum[i][0] = matrix[i][0];
            for (int j = 1; j < mtr.length; j++) {
                sum[i][j] = sum[i][j-1] + mtr[j];
            }
        }
    }

    // ["NumMatrix","sumRegion","sumRegion","sumRegion"]
    //[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
    //输出:
    //[null, 8, 11, 12]
    // sum
    // 3  3  4  8 10
    // 5 11 14 16 17
    // 1  3  3  4 9
    // 4  5  5  6 13
    // 1  1  4  4 9
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 > 0) {
                total += sum[i][col2] - sum[i][col1-1];
            } else {
                total += sum[i][col2];
            }
        }
        return total;
    }


}
