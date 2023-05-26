package com.example.demo.leetcode.ii;

/**
 * Description: 79. 单词搜索 
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 *
 * @author Zeti
 * @date 2023/5/25 11:04
 */
public class Exist {
    public static void main(String[] args) {
        char[][] b1 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String w1 = "ABCCED";
        System.err.println(isExist(b1, w1));    // true

        char[][] b2 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String w2 = "SEE";
        System.err.println(isExist(b2, w2));    // true

        char[][] b3 = {{'A','B'}};
        String w3 = "BA";
        System.err.println(isExist(b3, w3));    // true

        char[][] b4 = {{'a','a','a','a'}, {'a','a','a','a'}, {'a','a','a','a'}};
        String w4 = "aaaaaaaaaaaaa";
        System.err.println(isExist(b4, w4));    // true

    }

    // A B C E
    // S F C S
    // A D E E
    public static boolean isExist(char[][] board, String word) {
        int l = board.length;
        int h = board[0].length;

        boolean[][] used = new boolean[l][h];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                boolean check = check(board, used, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, boolean[][] used, int i, int j, String word, int strIdx) {
        if (board[i][j] != word.charAt(strIdx)) {
            return false;
        }
        if (strIdx == word.length()-1) {
            return true;
        }

        boolean result = false;
        used[i][j] = true;
        int[][] around = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    //当前点的周边四个点位： 右、下、左、上
        for (int[] ard : around) {
            i += ard[0];
            j +=  ard[1];
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                // 当前点位没有被使用过
                if (!used[i][j]) {
                    boolean res = check(board, used, i, j, word, strIdx+1);
                    if (res) {
                        result = true;
                        break;
                    }
                }
            }
            i -= ard[0];
            j -=  ard[1];
        }
        used[i][j] = false;
        return result;
    }

//    public static boolean isExist(char[][] board, String word) {
//        int h = board.length, w = board[0].length;
//        boolean[][] visited = new boolean[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                boolean flag = check(board, visited, i, j, word, 0);
//                if (flag) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
//        if (board[i][j] != s.charAt(k)) {
//            return false;
//        } else if (k == s.length() - 1) {
//            return true;
//        }
//        visited[i][j] = true;
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        boolean result = false;
//        for (int[] dir : directions) {
//            int newi = i + dir[0], newj = j + dir[1];
//            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
//                if (!visited[newi][newj]) {
//                    boolean flag = check(board, visited, newi, newj, s, k + 1);
//                    if (flag) {
//                        result = true;
//                        break;
//                    }
//                }
//            }
//        }
//        visited[i][j] = false;
//        return result;
//    }

}
