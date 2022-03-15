package com.example.demo.leetcode.iii;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: 雇佣K名工人所需支付的最少工资，贪心、大根堆
 *
 * 有 n名工人。给定两个数组 quality 和 wage，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i]。
 *
 * 现在我们想雇佣 k 名工人组成一个工资组。在雇佣一组 k 名工人时，我们必须按照下述规则向他们支付工资：
 *
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 *
 * ps1:
 *      输入： quality = [10,20,5], wage = [70,50,30], k = 2
 *      输出： 105.00000
 *      解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 *
 * ps2:
 *      输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
 *      输出： 30.66667
 *      解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
 *
 * @author Zeti
 * @date 2022/3/15 10:44 AM
 */
public class KWorkerMoney {

    public static void main(String[] args) {
        int[] q = {10,20,5};
        int[] w = {70,50,30};
        int k = 2;

        System.err.println(lessMoney(q, w, k));

    }


    // {7, 10}, {2.5, 20}, {6, 5}
    public static double lessMoney(int[] q, int[] w, int k) {
        // 用于保存性价比，将每个工人对应的性价比和质量一一对应，作为数组存起来
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; i++) {
            workers[i] = new double[]{w[i] / q[i], q[i]};
        }

        // 按照性价比排序，（w[i] / q[i]）越低，性价比越高
        Arrays.sort(workers, Comparator.comparingDouble(wk -> wk[0]));

        // 定义总需要支付的工资
        double sumMoney = Integer.MAX_VALUE;

        // 工人质量和
        double sumQ = 0d;

        PriorityQueue<Double> queue = new PriorityQueue<>();

        // 遍历这些工人
        for (double[] worker : workers) {
            sumQ += worker[1];
            queue.add(-worker[1]);

            if (queue.size() > k) {
                sumQ += queue.poll();
            }

            if (queue.size() == k) {
                sumMoney = Math.min(sumMoney, sumQ * worker[0]);
            }
        }

        return sumMoney;
    }



}
