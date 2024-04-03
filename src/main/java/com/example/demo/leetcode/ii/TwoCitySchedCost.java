package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1029. 两地调度
 *
 *  公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 * @author Zeti
 * @date 2024/4/3 11:17
 */
public class TwoCitySchedCost {
    public static void main(String[] args) {
        int[][] i1 = {{10,20},{30,200},{400,50},{30,20}};
        System.err.println(twoCitySchedCost(i1));   // 110

        int[][] i2 = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.err.println(twoCitySchedCost(i2));   // 1859

        int[][] i3 = {{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}};
        System.err.println(twoCitySchedCost(i3));   // 3086

    }


    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
        }
        return res;
    }

}
