package com.example.demo.leetcode.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Description: 顺时针旋转90'二维矩阵
 * ps1: 输入：matrix = [[1,2],[3,4]]   输出：[[3,1],[4,2]]
 * ps2: 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]   输出：[[7,4,1],[8,5,2],[9,6,3]]
 * ps3: 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]    输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * @author Zeti
 * @date 2022/1/17 3:16 PM
 */
public class Spin {

    public static void main(String[] args) {
//        int[][] a1 = {{1, 2, 3}      7  4  1
//                     ,{4, 5, 6}      8  5  2
//                     ,{7, 8, 9}};    9  6  3
//
//                      0,0  0,1  0,2
//                      1,0  1,1  1,2
//                      2,0  2,1  2,2


        int[][] a2 = {{5,  1,  9,  11}
                     ,{2,  4,  8,  10}
                     ,{13, 3,  6,  7}
                     ,{15, 14, 12, 16}};

//        System.err.println(sp1(a1));
        System.err.println(Arrays.deepToString(sp1(a2)));

    }


    public static int[][] sp1(int[][] nums) {

//        int[][] a1 = {{1, 2, 3}      7  4  1
//                     ,{4, 5, 6}      8  5  2
//                     ,{7, 8, 9}};    9  6  3
//
//                            0,0  0,1  0,2
//                            1,0  1,1  1,2
//                            2,0  2,1  2,2
//
//
//                0,0 -> 0,3      0,1 -> 1,3      0,2 -> 2,3      0,3 -> 3,3
//
//                1,0 -> 0,2      1,1 -> 1,2      1,2 -> 2,2      1,3 -> 3,2
//
//                2,0 -> 0,1      2,1 -> 1,1      2,2 -> 2,1      2,3 -> 3,1
//
//                3,0 -> 0,0      3,1 -> 1,0      3,2 -> 2,0      3,3 -> 3,0

//                {{5,  1,  9,  11}
//                ,{2,  4,  8,  10}
//                ,{13, 3,  6,  7}
//                ,{15, 14, 12, 16}};
            int length = nums.length;
            //因为是对称的，只需要计算循环前半行即可
            for (int i = 0; i < length / 2; i++)
                for (int j = i; j < length - i - 1; j++) {
                    int temp = nums[i][j];
                    int m = length - j - 1;
                    int n = length - i - 1;
                    nums[i][j] = nums[m][i];
                    nums[m][i] = nums[n][m];
                    nums[n][m] = nums[j][n];
                    nums[j][n] = temp;
                }

        return nums;
    }

}
