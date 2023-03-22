package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 1626. 无矛盾的最佳球队
 *  假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *  然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。
 *  如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *  给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。
 *  请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-team-with-no-conflicts
 *
 * @author Zeti
 * @date 2023/3/22 09:56
 */
public class BestTeamScore {

    public static void main(String[] args) {
        int[] scores = {1,3,5,10,15}, ages = {1,2,3,4,5};
        System.err.println(34 == bestTeamScore(scores, ages));

        int[] scores2 = {4,5,6,5}, ages2 = {2,1,2,1};
        System.err.println(16 == bestTeamScore(scores2, ages2));

        int[] scores3 = {1,2,3,5}, ages3 = {8,9,10,1};
        System.err.println(6 == bestTeamScore(scores3, ages3));

        int[] scores4 = {1,10,10,3,15}, ages4 = {1,2,3,4,5};
        System.err.println(36 == bestTeamScore(scores4, ages4));

        int[] scores5 = {9,2,8,8,2}, ages5 = {4,1,3,3,5};
        System.err.println(27 == bestTeamScore(scores5, ages5));


    }

    // 1,3,5,10,15
    // 1,2,3,4,5
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }

        // 排序，按成绩排序，成绩相同时，按年龄排序
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
