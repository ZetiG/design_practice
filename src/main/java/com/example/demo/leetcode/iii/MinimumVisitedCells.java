package com.example.demo.leetcode.iii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: 2617. 网格图中最少访问的格子数
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。
 *
 * 当你在格子 (i, j) 的时候，你可以移动到以下格子之一：
 *      满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者
 *      满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。
 *
 * 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。
 *
 * @author Zeti
 * @date 2024/3/22 09:09
 */
public class MinimumVisitedCells {
    public static void main(String[] args) {
//        int[][] g1 = {{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}};
//        System.err.println(minimumVisitedCells(g1));  // 4
//
//        int[][] g2 = {{0,5,1,8,0},{5,8,8,6,0}};
//        System.err.println(minimumVisitedCells(g2));  // -1
//
//        int[][] g3 = {{1,0,11},{1,14,10},{12,10,2},{2,0,0},{13,0,0}};
//        System.err.println(minimumVisitedCells(g3));  // 5
//
//        int[][] g4 = {{1},{1},{3},{0}};
//        System.err.println(minimumVisitedCells(g4));  // 4

        int[][] g5 = {{3,0,0,3},{0,0,0,0},{0,0,0,0},{1,1,0,0}};
        System.err.println(minimumVisitedCells3(g5));  // 3

//        int[][] g6 = {{105,140,114,108,114,44,107,20,105,141,4,30,126,44,130,9,19,40,110,0,29,21,99,61,92,117,60,121,85,60,49,96,78,98,29,113,75,86,62,6,61,109,70,47,82,30,63,75,21,7,40,75,8,47,9,31,91,82,5,0,10,27,73,68,54,47,56,50,48,76,11,5,24,32,20,46,60,63,28,12,14,33,38,60,14,56,28,30,59,30},{101,3,118,144,29,144,69,42,67,24,15,66,0,48,136,85,4,106,66,130,119,36,105,9,28,69,99,18,28,71,23,2,16,66,59,79,61,84,5,23,14,79,60,39,89,17,52,41,1,2,98,25,59,50,6,2,42,59,6,63,19,73,32,9,8,83,27,70,38,12,0,4,38,61,46,55,44,21,63,7,59,0,29,44,39,46,58,54,9,40},{104,28,70,91,20,68,106,24,122,45,128,39,136,22,135,29,113,47,60,114,5,79,18,15,32,15,65,72,82,2,42,86,98,86,51,64,100,60,1,24,64,100,12,5,77,15,38,65,29,39,28,79,17,40,12,27,66,37,80,15,24,26,32,84,83,71,77,30,30,2,55,52,57,6,43,74,71,14,50,69,3,16,35,32,48,47,11,50,8,47},{25,121,89,9,81,128,95,70,40,48,24,37,107,108,46,126,56,118,83,19,38,121,118,54,37,0,44,80,82,28,30,13,99,97,27,44,91,53,104,33,37,90,2,0,5,32,62,70,49,54,54,8,90,76,76,44,70,65,32,29,53,23,33,25,44,67,4,44,3,67,58,15,44,72,48,19,12,17,34,8,4,43,36,0,28,14,61,22,60,31},{139,129,49,109,36,82,74,73,46,133,46,66,122,40,133,93,70,22,92,50,19,35,37,117,75,47,72,65,48,87,11,41,12,57,48,59,87,6,83,69,14,25,47,18,81,36,40,54,11,39,58,7,80,11,78,29,47,43,6,80,75,31,26,46,31,30,0,19,46,64,57,60,23,9,4,8,65,26,29,16,26,8,23,39,28,13,16,24,50,11},{125,86,135,135,117,57,16,107,3,68,134,120,28,12,29,72,108,121,69,67,51,78,41,32,66,93,1,37,72,109,70,76,42,104,31,47,74,9,5,21,79,57,18,64,89,43,79,86,35,0,48,43,49,64,25,16,33,19,56,82,60,66,64,31,16,9,13,29,49,18,63,39,39,50,31,43,53,13,13,35,8,18,56,22,53,0,9,19,49,6},{77,26,118,99,74,116,59,129,128,96,53,29,51,72,26,39,98,52,99,42,46,35,41,77,0,66,106,11,10,58,78,88,80,69,94,68,89,47,36,73,100,64,88,69,2,92,71,72,51,8,30,30,37,48,13,86,1,18,5,81,37,4,81,13,59,45,64,24,18,74,42,68,17,16,54,33,36,29,54,37,9,41,50,11,60,55,57,9,23,46},{63,140,129,120,63,44,65,31,83,106,5,128,88,6,109,62,21,71,74,96,78,21,92,71,73,103,87,1,43,51,107,94,77,51,85,19,48,82,30,2,48,62,97,27,23,91,13,80,92,33,29,57,5,45,32,17,77,17,19,64,29,30,38,19,24,58,54,66,44,48,41,0,17,41,48,20,36,49,2,47,9,9,47,3,14,50,2,5,33,47},{119,33,107,135,103,49,136,89,96,108,20,1,17,34,115,90,92,18,6,6,103,20,0,80,68,9,87,93,89,99,108,3,46,37,45,69,100,93,4,25,21,67,90,75,44,35,90,47,36,83,77,23,80,25,33,88,35,84,20,37,69,59,28,30,3,38,49,64,53,12,11,43,5,58,61,66,10,56,12,24,40,51,17,45,53,30,1,55,33,7},{61,117,52,5,88,78,75,108,114,73,88,6,56,90,115,82,60,83,23,118,67,91,41,42,39,17,9,11,52,33,53,13,100,82,9,54,61,68,104,31,1,34,25,91,17,62,8,62,30,55,74,55,58,39,72,71,71,7,69,43,3,1,66,70,30,64,31,0,6,25,32,37,0,55,46,23,13,21,5,5,8,57,7,47,30,17,34,0,19,18},{107,83,116,34,120,91,53,91,132,125,0,45,33,72,115,109,48,43,70,56,81,46,31,23,113,6,43,24,5,50,56,26,74,28,64,88,19,75,55,91,97,14,80,4,82,12,93,20,76,50,22,57,15,25,3,77,63,5,20,51,68,71,19,67,41,1,5,54,55,7,33,24,33,59,39,47,34,21,31,34,38,24,3,24,11,4,32,33,2,42},{58,61,82,61,5,50,106,106,119,113,2,107,30,93,102,96,96,106,107,107,24,110,113,38,111,16,109,6,9,14,28,94,85,54,66,87,9,8,79,59,0,88,90,0,52,34,91,28,69,31,86,86,64,38,15,82,45,11,30,51,17,77,44,59,75,10,70,13,19,7,46,22,63,6,13,2,21,52,42,14,37,5,7,0,47,49,31,9,8,9},{66,41,48,102,104,88,101,98,39,49,91,43,120,110,20,30,11,60,80,81,42,114,26,44,17,57,72,2,4,68,100,2,12,83,68,39,25,34,95,32,12,66,34,43,25,30,39,27,3,45,61,26,53,58,49,40,49,55,31,33,49,61,27,24,60,43,53,65,43,60,46,57,20,33,8,41,62,15,7,54,53,36,19,48,53,18,0,14,13,29},{123,52,60,20,132,90,21,13,103,12,96,96,24,27,52,89,121,8,61,1,87,38,90,80,34,48,104,18,74,86,106,14,61,90,17,47,24,43,17,59,13,64,90,66,93,23,89,47,74,34,2,46,15,58,83,41,17,43,32,10,78,67,63,11,48,49,40,27,57,36,14,58,65,32,14,33,50,28,10,50,39,20,48,41,46,36,12,3,44,22},{124,25,54,44,93,125,131,10,82,16,80,18,121,24,114,26,26,12,34,5,55,23,54,109,1,24,55,77,45,75,102,44,41,9,93,99,86,86,28,16,35,16,12,54,92,13,45,10,49,31,32,80,43,44,44,68,66,65,46,42,75,36,26,63,9,8,63,6,61,25,30,27,30,37,11,58,3,21,21,27,4,16,45,7,3,51,30,9,4,15},{6,44,114,92,24,66,80,50,38,99,60,67,50,56,116,41,120,34,77,34,62,47,105,100,60,84,20,103,13,58,72,78,61,15,74,12,97,21,43,7,77,61,15,34,64,53,65,78,50,42,71,48,68,11,66,23,78,16,48,11,66,75,19,5,48,33,57,11,17,25,9,34,18,53,33,14,12,43,32,32,2,46,26,14,38,31,8,39,30,18},{11,96,50,97,45,3,104,72,46,112,2,73,63,43,107,82,95,71,4,76,75,90,8,77,7,83,97,108,74,86,91,93,79,96,98,9,84,45,82,42,73,6,25,13,62,9,65,10,48,64,64,1,42,0,53,61,37,64,76,39,45,37,72,1,19,9,26,59,25,38,26,3,44,2,38,42,31,25,29,38,31,22,37,26,49,26,39,37,40,36},{128,78,80,12,119,81,5,90,35,55,54,101,117,91,0,1,109,92,44,53,111,97,34,54,5,43,10,84,51,82,104,12,48,47,4,54,15,6,71,37,92,60,62,9,7,20,22,7,30,45,2,15,32,27,68,66,13,24,29,55,26,6,24,9,14,48,7,44,66,61,18,20,27,14,52,39,24,29,5,16,20,22,38,14,8,41,39,46,21,10},{133,10,22,45,112,6,29,45,58,75,35,38,46,84,107,83,39,5,95,5,95,55,22,0,65,51,33,36,65,30,16,79,75,42,94,59,76,93,35,33,29,28,42,45,63,8,80,11,26,34,81,31,61,1,50,22,58,16,32,45,54,68,4,69,63,62,31,62,34,29,57,24,29,39,12,3,3,41,14,19,28,6,26,44,7,2,4,32,8,25},{112,45,59,94,29,58,68,8,53,25,70,65,33,16,33,103,91,75,71,95,107,3,93,103,95,81,54,82,29,26,69,17,91,74,7,82,24,81,29,79,92,52,67,44,17,54,67,74,67,41,65,49,53,4,72,22,20,5,22,34,63,0,44,52,26,16,18,8,4,63,3,5,9,2,0,49,38,45,12,9,25,4,27,2,31,45,41,8,17,14},{19,116,95,55,105,67,94,52,2,11,61,111,47,116,50,77,35,64,85,73,44,62,75,90,11,52,66,15,74,96,89,20,2,81,95,9,57,25,17,30,39,27,61,20,45,7,62,52,38,56,5,72,22,5,37,76,64,68,45,0,48,15,55,62,15,35,8,20,18,36,37,51,10,48,47,1,8,11,44,23,39,21,18,48,39,45,14,0,20,37},{4,57,64,78,92,114,33,111,92,16,83,32,32,29,112,108,75,81,75,68,66,50,6,20,7,97,92,61,58,41,6,60,57,59,9,4,93,50,22,46,46,56,87,37,59,67,0,40,16,31,13,5,31,66,44,68,46,72,44,14,67,30,30,63,43,34,13,23,52,29,60,12,25,51,4,4,18,53,4,34,2,16,36,47,44,8,13,43,18,21},{5,66,41,42,29,104,4,90,9,81,61,105,26,24,7,66,3,64,50,79,44,71,39,100,62,69,4,91,41,0,63,97,81,37,17,84,74,87,8,21,14,71,50,43,54,83,13,62,59,79,66,38,41,49,30,48,44,34,28,45,35,30,29,2,62,49,20,17,27,18,48,50,18,5,22,52,23,2,37,6,2,12,33,10,25,18,21,7,41,16},{2,16,50,51,58,80,52,74,106,78,45,21,99,94,85,3,84,9,17,38,103,45,62,75,86,60,65,20,50,71,83,20,63,48,15,58,34,41,71,38,6,40,40,57,11,53,28,4,76,64,18,68,25,30,6,25,68,69,17,52,30,65,20,49,26,54,28,22,45,58,52,29,52,18,28,49,29,31,19,41,13,31,11,34,43,31,33,22,12,31},{51,63,84,53,113,46,101,110,118,16,24,92,101,32,10,99,38,50,69,67,61,23,57,11,9,41,35,99,88,95,51,46,9,76,60,63,64,15,72,43,76,62,38,17,65,66,71,33,34,48,40,2,44,11,16,16,4,9,63,24,21,44,35,35,22,37,28,13,45,19,22,49,47,25,42,8,31,17,10,9,10,6,44,38,21,26,38,9,24,14},{10,70,1,30,13,65,36,83,96,5,15,96,41,74,82,69,66,107,25,62,25,10,9,103,58,93,99,58,48,72,11,93,14,89,29,69,19,14,59,73,72,80,11,41,15,60,44,54,61,52,69,42,60,11,72,3,54,7,18,49,63,47,10,29,15,24,30,21,35,0,9,22,43,50,42,30,13,2,10,13,22,31,32,38,2,0,19,25,6,6},{53,12,56,90,98,75,90,116,41,43,83,38,0,76,79,81,64,9,77,74,32,38,94,57,75,58,49,44,88,19,14,56,11,1,17,53,10,71,27,54,71,5,57,82,6,15,5,71,22,40,68,63,31,29,50,40,55,58,55,65,65,28,5,8,14,38,57,4,47,17,9,2,16,44,45,39,10,1,40,34,8,7,23,15,11,30,23,4,6,13},{48,39,24,120,81,25,29,18,60,36,74,69,59,63,92,109,31,58,92,38,102,71,63,38,48,97,93,27,36,18,19,22,39,59,32,2,72,0,11,85,29,71,42,43,6,28,6,16,49,55,3,9,27,42,24,2,63,7,43,22,41,24,24,3,34,45,45,11,5,15,46,10,29,13,10,16,39,28,10,1,3,23,3,23,8,33,19,35,18,9},{51,119,27,119,34,112,15,111,79,43,61,35,60,13,31,54,0,58,91,99,28,10,45,52,68,60,70,14,85,51,55,47,81,38,57,7,70,70,27,75,61,21,6,26,38,45,56,6,74,71,51,22,70,33,41,7,42,64,1,25,43,50,42,5,46,0,26,9,38,41,50,35,22,17,17,48,37,18,13,19,36,2,33,19,21,7,30,14,10,13},{77,77,3,19,90,15,73,3,5,18,12,26,46,17,26,90,101,91,86,80,1,91,66,53,61,7,36,32,21,6,88,85,54,56,35,87,67,18,59,20,60,33,18,51,67,39,61,26,56,65,50,58,32,62,32,0,65,24,58,6,31,22,33,6,39,42,32,14,26,43,34,48,1,22,1,46,33,27,38,5,20,2,38,35,16,30,34,35,27,3},{121,86,83,3,33,48,35,34,5,93,25,32,100,73,26,40,30,46,39,51,0,14,23,19,43,44,5,88,62,34,35,54,37,75,82,40,79,0,64,23,79,79,32,11,15,67,4,20,34,21,65,18,20,23,52,46,26,0,28,29,52,9,50,38,20,47,28,31,18,38,16,28,47,39,14,45,1,24,22,9,8,36,39,10,4,35,15,26,6,1},{7,62,26,94,55,19,71,86,83,62,20,107,13,90,55,49,1,8,32,23,31,84,42,50,72,60,79,91,16,37,5,62,67,29,15,46,37,79,11,43,80,75,24,20,33,20,0,21,36,64,56,30,32,4,38,4,13,5,46,51,28,7,53,37,55,43,12,31,46,21,47,35,22,3,3,35,21,31,4,11,12,14,20,7,28,5,4,6,23,24},{28,29,12,108,112,28,16,9,15,103,86,56,61,87,55,89,77,13,32,80,21,75,92,20,89,20,59,69,40,82,71,34,51,3,82,20,12,72,80,44,19,6,19,64,23,53,72,52,66,24,6,52,23,9,18,7,18,12,32,29,36,17,10,39,2,32,23,22,36,39,44,12,43,33,1,38,30,30,31,28,16,3,12,26,17,6,22,5,10,29},{23,15,50,73,106,36,63,12,108,64,50,48,10,95,80,56,61,1,90,70,64,60,51,22,89,26,79,30,9,61,35,74,84,44,46,42,29,61,66,58,51,14,9,60,52,22,0,57,65,37,7,15,33,53,5,22,1,51,15,54,2,41,6,18,36,47,17,45,1,1,26,7,43,15,7,21,17,22,32,28,35,26,0,32,22,31,32,23,13,0},{82,1,70,72,95,81,108,57,89,34,65,101,99,15,90,7,8,95,70,73,53,65,85,79,32,12,87,81,14,77,7,35,29,41,68,19,40,34,6,58,24,66,74,67,73,20,1,41,54,68,52,44,3,52,24,23,8,44,20,26,31,39,1,45,8,35,25,18,38,45,21,16,28,28,0,4,6,35,2,2,33,5,26,9,8,8,0,26,16,5},{110,27,48,9,27,54,40,65,54,60,87,65,79,22,19,65,89,51,9,96,12,28,16,85,78,43,59,75,47,87,53,27,37,81,46,52,71,13,4,42,36,75,24,47,52,57,22,25,55,34,32,36,28,51,26,7,7,26,23,34,1,36,27,15,37,8,29,11,3,42,26,14,39,40,26,39,38,8,30,14,16,32,3,15,6,13,23,10,6,23},{102,2,51,31,73,81,74,98,12,106,73,9,6,26,16,5,18,83,3,93,19,15,84,38,72,51,52,69,64,74,67,64,64,48,16,32,19,6,42,12,42,24,41,3,52,59,41,57,36,43,62,33,51,44,38,38,48,51,56,40,11,29,46,46,3,41,11,33,28,11,36,23,8,29,20,16,13,15,10,13,1,16,21,29,3,0,9,19,10,20},{96,17,12,55,29,40,100,60,80,92,6,29,96,48,54,97,25,94,52,70,25,26,61,36,16,40,50,79,35,47,33,51,53,45,75,8,44,43,17,64,18,22,66,70,2,8,8,39,43,14,48,41,34,44,38,4,14,11,21,36,17,32,4,11,28,21,3,35,12,1,34,7,40,22,32,26,21,28,21,11,30,20,15,26,25,13,21,4,8,1},{49,81,60,48,70,87,54,96,25,87,58,80,70,11,20,72,60,24,29,57,52,46,26,82,19,25,66,28,72,56,40,6,58,42,42,44,5,48,31,10,60,45,1,47,41,52,67,41,12,54,63,38,60,41,54,29,2,21,16,42,37,24,21,13,6,38,28,45,10,33,16,16,17,15,36,37,34,32,23,23,8,6,11,11,13,10,15,0,5,9},{1,79,60,71,1,75,6,23,85,58,12,83,78,60,96,40,37,45,75,77,1,65,80,21,30,55,82,9,76,9,32,20,0,70,39,23,47,54,34,4,14,44,0,5,42,66,40,38,14,2,19,43,32,20,31,32,34,15,37,36,5,0,21,36,4,23,18,43,43,9,36,3,30,37,7,1,33,22,11,31,26,28,9,9,16,25,8,0,23,5},{76,2,88,55,54,52,59,13,76,86,7,38,13,58,60,5,71,3,32,64,70,58,70,55,35,31,6,74,49,62,48,68,18,69,13,56,31,38,42,60,61,27,54,16,61,5,29,26,22,27,46,36,43,14,17,31,13,27,11,30,36,14,9,0,35,10,7,2,25,11,34,30,20,24,16,8,11,16,13,11,10,29,1,13,10,20,25,13,10,20},{83,83,97,77,50,1,13,6,40,26,82,47,60,28,51,54,63,27,60,77,22,74,29,55,61,16,68,52,33,6,27,33,70,19,48,72,45,53,14,57,14,59,49,42,50,28,61,47,38,57,22,35,23,17,8,12,33,39,12,43,4,46,13,41,7,16,8,13,13,35,9,28,20,31,2,13,33,8,23,16,30,21,6,18,22,17,5,6,19,10},{18,50,105,33,58,35,58,44,34,8,15,19,78,0,28,79,89,20,12,69,5,46,24,31,75,62,80,0,32,66,20,8,27,25,23,64,10,55,10,49,19,44,32,32,61,37,34,7,5,53,43,51,39,13,38,12,38,29,44,30,39,21,38,21,33,32,14,4,32,13,3,12,16,9,33,28,17,32,10,15,16,24,13,24,17,0,17,15,17,20},{39,2,12,38,27,53,27,63,93,23,62,11,91,5,0,73,67,26,2,5,26,9,0,16,9,13,64,56,34,29,37,66,76,50,73,47,34,11,23,7,61,34,56,12,0,29,38,7,3,16,10,24,31,46,54,26,19,36,21,13,18,14,1,29,43,43,37,10,13,32,0,27,8,2,19,1,30,24,20,3,2,26,2,14,22,0,6,19,4,18},{71,11,71,12,51,76,99,41,51,30,76,31,5,65,85,80,27,22,69,2,49,75,63,78,76,35,43,2,55,53,48,26,30,53,57,35,61,47,23,15,26,3,14,40,40,49,61,33,49,31,1,22,33,39,28,27,32,33,17,18,18,20,12,15,29,10,9,37,33,26,1,32,20,15,26,15,8,8,28,12,24,18,12,23,23,22,4,12,17,15},{80,92,97,86,57,75,92,50,45,8,51,19,56,44,10,45,14,44,69,50,15,43,78,7,81,30,1,4,14,11,7,47,9,40,63,21,27,49,42,27,15,49,20,15,13,34,19,31,19,46,35,46,23,8,24,20,19,27,48,5,40,34,35,5,3,40,34,16,33,21,7,10,28,16,23,11,16,29,21,13,4,24,21,17,17,13,11,9,17,16},{62,40,40,11,65,29,2,92,52,56,92,6,35,27,45,11,32,69,60,48,70,48,39,19,29,54,32,78,61,24,47,22,3,48,19,28,7,26,10,20,41,23,39,27,32,55,25,49,4,25,26,9,26,42,29,40,12,33,41,2,3,37,13,1,20,20,14,37,8,35,1,24,11,30,21,5,15,22,26,11,1,16,17,10,15,0,13,17,11,7},{22,54,5,89,15,52,45,55,44,28,35,15,78,48,64,17,1,57,44,17,28,18,21,38,70,57,26,29,39,59,22,13,57,30,5,15,16,10,22,45,17,38,15,53,13,1,20,25,7,43,29,29,39,45,3,12,10,12,1,32,6,32,37,7,1,15,34,6,21,31,28,15,21,13,21,20,18,4,23,25,10,5,15,18,19,0,3,11,2,2},{39,101,75,92,32,50,87,67,21,54,41,1,8,17,22,1,61,68,16,68,51,82,61,24,26,10,23,37,9,67,30,57,59,58,48,64,67,34,28,30,62,35,10,42,30,13,2,14,34,40,7,48,10,4,27,37,42,24,18,33,27,35,36,5,34,10,35,14,14,28,16,19,14,0,11,22,25,24,23,16,2,16,5,11,12,1,2,1,0,6},{41,80,93,7,9,20,68,55,46,29,9,7,3,54,45,34,37,80,63,24,70,52,77,46,7,31,74,57,68,2,9,18,20,13,26,18,39,4,34,24,60,13,42,32,38,5,10,24,35,47,36,47,35,5,43,12,34,12,28,38,24,19,5,29,36,9,27,17,15,0,3,10,19,24,7,0,7,15,20,6,21,16,18,1,1,2,14,11,3,4},{1,100,36,7,25,65,88,29,60,43,47,20,21,24,36,7,34,80,21,23,61,77,12,19,28,72,17,49,71,58,53,68,60,50,6,11,17,59,16,12,27,25,24,53,37,13,55,16,31,36,34,39,3,25,19,9,8,7,30,31,2,26,29,33,9,4,35,32,4,15,28,0,13,22,27,9,10,0,2,22,21,7,12,12,1,7,11,13,11,6},{63,82,81,44,18,20,25,68,3,0,39,12,37,36,32,48,18,71,53,70,60,47,18,1,74,30,25,17,1,50,58,23,15,32,52,18,40,50,47,60,54,30,5,13,18,22,25,46,28,0,41,18,10,46,1,37,4,5,1,34,21,10,13,3,31,24,7,26,3,12,30,25,26,14,4,6,5,8,9,18,12,7,11,12,8,1,12,9,8,9},{2,21,83,8,12,46,22,47,69,18,64,50,42,13,32,1,55,26,70,20,33,42,62,52,1,21,61,66,52,66,8,51,58,6,58,33,45,23,60,50,28,47,34,38,10,38,37,4,3,41,7,22,16,10,7,39,28,13,29,13,2,2,7,22,6,29,32,1,18,9,19,11,11,23,5,18,4,20,16,14,6,14,3,10,7,10,6,6,8,4},{2,58,21,39,81,56,83,5,16,59,40,43,28,14,35,3,70,42,71,38,54,2,37,60,1,70,49,18,8,37,65,34,35,4,25,56,43,20,60,20,0,22,49,16,38,46,33,10,32,14,6,42,10,7,21,26,3,28,19,29,19,19,8,16,4,30,6,12,6,25,6,7,12,15,7,8,18,15,18,19,0,3,13,3,1,10,11,0,0,3},{63,21,13,61,77,62,62,30,3,71,7,22,85,0,70,9,78,25,46,8,38,54,47,24,16,11,8,7,67,40,23,43,36,34,15,43,6,9,12,36,21,39,53,26,3,8,0,37,23,39,27,19,40,44,5,22,3,25,18,22,15,31,10,25,5,23,27,26,2,8,1,24,10,20,0,20,2,18,15,17,8,13,3,10,8,3,8,8,6,7},{27,82,89,53,56,88,4,13,61,26,1,39,20,26,73,66,73,68,55,77,64,5,2,29,17,3,42,38,26,37,14,31,12,44,6,31,53,52,25,33,1,42,12,34,36,34,2,36,39,34,41,19,5,36,29,2,21,5,28,21,23,10,1,5,11,31,14,17,17,20,16,5,7,20,15,9,7,19,9,5,13,4,8,6,1,10,9,9,4,2},{59,31,23,34,72,17,50,19,38,68,5,19,37,44,42,52,42,6,75,72,62,72,68,39,53,21,47,41,48,66,18,38,46,61,27,10,59,10,48,0,23,12,31,10,28,21,48,8,5,26,15,5,10,41,17,40,13,14,8,36,25,21,17,28,30,4,7,23,4,21,19,15,18,7,6,8,9,13,13,16,4,12,3,2,11,3,3,7,4,1},{31,23,63,78,1,61,1,49,76,81,50,60,3,3,10,60,46,37,0,16,22,9,25,41,19,60,30,53,65,2,49,5,59,4,31,0,15,32,51,24,8,45,31,46,13,4,25,38,35,37,33,13,35,36,6,17,9,1,12,1,7,3,11,0,29,23,18,3,1,13,23,22,0,10,20,11,5,17,5,4,3,7,10,10,3,5,2,5,2,5},{91,64,71,50,86,85,51,18,50,28,28,53,30,36,74,76,77,20,2,62,37,51,1,22,23,51,18,55,18,55,9,39,0,22,26,36,31,24,7,14,49,43,2,1,30,46,1,44,13,32,29,39,7,24,21,4,13,9,0,27,18,18,19,25,29,6,27,25,9,11,5,15,13,16,0,17,9,1,10,8,12,3,11,10,1,0,4,1,5,4},{21,1,84,70,14,55,42,53,12,10,68,78,52,25,9,7,38,72,52,42,11,3,53,55,5,49,37,35,30,47,28,33,21,41,18,1,34,26,10,28,37,30,1,28,1,25,31,26,9,5,31,1,31,36,12,13,22,34,0,6,10,8,24,13,13,21,6,13,14,10,15,3,3,15,15,2,16,9,13,4,8,3,5,1,8,6,4,4,1,0},{55,32,46,80,16,23,2,10,18,6,18,30,17,25,3,25,66,14,69,8,60,36,51,6,37,46,15,42,29,25,17,2,7,27,54,34,53,30,19,1,35,38,22,31,18,29,2,38,21,10,41,3,38,3,10,15,8,2,14,32,5,24,13,7,4,7,9,16,18,2,14,14,14,10,6,14,1,1,12,11,4,2,7,7,7,4,2,3,0,2},{13,51,62,76,52,55,33,10,57,28,35,26,4,53,43,44,24,64,14,50,63,66,10,18,56,52,35,48,22,17,0,4,14,35,17,13,50,43,23,11,32,10,1,27,23,19,13,5,35,17,35,3,26,31,14,6,3,1,30,27,20,28,0,4,15,10,6,12,4,2,3,18,4,5,0,14,9,11,3,6,2,0,1,6,0,3,1,0,2,0},{55,37,18,65,71,36,45,59,47,21,54,13,43,74,61,49,30,58,8,31,18,41,20,35,53,6,16,40,23,13,31,48,14,32,17,49,37,29,7,46,6,8,15,28,32,2,30,10,26,20,13,13,13,22,33,32,26,3,17,7,5,10,17,11,9,7,0,17,7,0,2,17,3,2,3,13,5,8,10,2,6,0,3,3,1,1,0,0,1,0}};
//        System.err.println(minimumVisitedCells3(g6));  // 4

    }

    // 3 0 0 3
    // 0 0 0 0
    // 0 0 0 0
    // 1 1 0 0
    public static int minimumVisitedCells3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int f = 0;
        PriorityQueue<int[]>[] colHeaps = new PriorityQueue[n]; // 每一列的最小堆
        Arrays.setAll(colHeaps, i -> new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0])));

        PriorityQueue<int[]> rowH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // 行最小堆

        for (int i = 0; i < m; i++) {
            rowH.clear();
            for (int j = 0; j < n; j++) {
                while (!rowH.isEmpty() && rowH.peek()[1] < j) { // 无法到达第 j 列
                    rowH.poll(); // 弹出无用数据
                }
                PriorityQueue<int[]> colH = colHeaps[j];
                while (!colH.isEmpty() && colH.peek()[1] < i) { // 无法到达第 i 行
                    colH.poll(); // 弹出无用数据
                }

                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1; // 起点算 1 个格子
                if (!rowH.isEmpty()) {
                    f = rowH.peek()[0] + 1; // 从左边跳过来
                }
                if (!colH.isEmpty()) {
                    f = Math.min(f, colH.peek()[0] + 1); // 从上边跳过来
                }

                int g = grid[i][j];
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowH.offer(new int[]{f, g + j}); // 经过的格子数，向右最远能到达的列号
                    colH.offer(new int[]{f, g + i}); // 经过的格子数，向下最远能到达的行号
                }
            }
        }
        return f < Integer.MAX_VALUE ? f : -1; // 此时的 f 是在 (m-1, n-1) 处算出来的
    }


    public static int minimumVisitedCells2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], -1);
        }

        dist[0][0] = 1;
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] col = new PriorityQueue[n];
        for (int i = 0; i < m; ++i) {
            row[i] = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        }
        for (int i = 0; i < n; ++i) {
            col[i] = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j) {
                    row[i].poll();
                }
                if (!row[i].isEmpty()) {
                    dist[i][j] = update(dist[i][j], dist[i][row[i].peek()[1]] + 1);
                }

                while (!col[j].isEmpty() && col[j].peek()[1] + grid[col[j].peek()[1]][j] < i) {
                    col[j].poll();
                }
                if (!col[j].isEmpty()) {
                    dist[i][j] = update(dist[i][j], dist[col[j].peek()[1]][j] + 1);
                }

                if (dist[i][j] != -1) {
                    row[i].offer(new int[]{dist[i][j], j});
                    col[j].offer(new int[]{dist[i][j], i});
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public static int update(int x, int y) {
        return x == -1 || y < x ? y : x;
    }



    public static int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < j; k++) {
                    if (dp[i][k] > 0 && grid[i][k] > 0 && (j - k) <= (grid[i][k])) {
                        if (dp[i][j] > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + 1);
                        } else {
                            dp[i][j] = dp[i][k] + 1;
                        }
                        break;
                    }
                }

                for (int l = 0; l < i; l++) {
                    if (dp[l][j] > 0 && grid[l][j] > 0 && (i - l) <= (grid[l][j])) {
                        if (dp[i][j] > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[l][j] + 1);
                        } else {
                            dp[i][j] = dp[l][j] + 1;
                        }
                        break;
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }


}
