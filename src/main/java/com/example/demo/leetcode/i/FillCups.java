package com.example.demo.leetcode.i;

/**
 * Description: 2335. 装满杯子需要的最短总时长
 *  现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
 *  给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups
 *
 * @author Zeti
 * @date 2023/2/11 14:07
 */
public class FillCups {

    public static void main(String[] args) {
        int[] amount1 = {5,4,4};    // 7  1 + ((4 + 4 + 4) / 2)
        System.err.println(fillCups(amount1));

        int[] amount2 = {1,4,2};    // 4 1 + ((1 + 3 + 2) / 2)
        System.err.println(fillCups(amount2));

        int[] amount3 = {5,0,0};    // 5 5 + ((0 + 0 + 0) / 2)
        System.err.println(fillCups(amount3));

        int[] amount4 = {5,0,3};    // 5 2 + ((3 + 0 + 3) / 2)
        System.err.println(fillCups(amount4));
    }

    /**
     * 思路:
     * 如果其中一个值大于其他两值之和，则该值就是最终次数
     * 否则，三个值之和相加除以2，向上取整
     *
     * @param amount
     * @return
     */
    public static int fillCups(int[] amount) {
        if (amount.length < 3) {
            return 0;
        }

        int max;
        int count = amount[0] + amount[1] + amount[2];

        max = amount[0] > amount[1] ? amount[0] : amount[1];
        max = max > amount[2] ? max : amount[2];

        //
        if (max > (count - max)) {
            int i = max - (count - max);
            return i + (int)Math.ceil((double) (count - i) / 2);
        }
        return (int)Math.ceil((double)count / 2);
    }




}


