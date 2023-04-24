package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 1105. 填充书架
 * 给定一个数组 books ，其中books[i] = [thicknessi, heighti]表示第 i 本书的厚度和高度。你也会得到一个整数 shelfWidth 。
 * 按顺序将这些书摆放到总宽度为 shelfWidth 的书架上。
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelfWidth ），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。
 * 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/filling-bookcase-shelves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/23 16:58
 */
public class DP_MinHeightShelves {

    public static void main(String[] args) {
        int[][] b1 = {{1,1}, {2,3}, {2,3}, {1,1}, {1,1}, {1,1}, {1,2}};
        int s1 = 4;
        System.err.println(minHeightShelves(b1, s1)); // 6

        int[][] b2 = {{1,3}, {2,4}, {3,2}};
        int s2 = 6;
        System.err.println(minHeightShelves(b2, s2)); // 4

    }

    // [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len+1];  // dp[n]前n本书的最大高度和
        Arrays.fill(dp, 1000*1000);
        dp[0] = 0;

        // 递推计算前i本书的最大高度和
        for (int i = 0; i < len; i++) {
            int cw = 0; // 当前宽度
            int ch = 0; // 当前高度

            // 每次将第i本书当做最后一本书，再递推前面的书，求出当前0-i本书的总的最小高度和
            for (int j = i; j >= 0; j--) {
                cw += books[j][0];
                if (cw > shelfWidth) {
                    break;
                }

                ch = Math.max(ch, books[j][1]);
                dp[i+1] = Math.min(dp[i+1], dp[j]+ch);
            }
        }
        return dp[len];
    }


}
