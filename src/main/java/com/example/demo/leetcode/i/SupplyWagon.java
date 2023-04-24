package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: LCP 72. 补给马车
 * 远征队即将开启未知的冒险之旅，不过在此之前，将对补给车队进行最后的检查。supplies[i] 表示编号为 i 的补给马车装载的物资数量。
 * 考虑到车队过长容易被野兽偷袭，他们决定将车队的长度变为原来的一半（向下取整），计划为：
 * 找出车队中 物资之和最小 两辆 相邻 马车，将它们车辆的物资整合为一辆。若存在多组物资之和相同的马车，则取编号最小的两辆马车进行整合；
 * 重复上述操作直到车队长度符合要求。
 * 请返回车队长度符合要求后，物资的分布情况。
 *
 * 示例 1：
 * 输入：supplies = [7,3,6,1,8]
 * 输出：[10,15]
 *
 * 示例 2：
 * 输入：supplies = [1,3,1,5]
 * 输出：[5,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/hqCnmP
 *
 * @author Zeti
 * @date 2023/4/24 17:30
 */
public class SupplyWagon {

    public static void main(String[] args) {
        int[] s1 = {7,3,6,1,8};
        System.err.println(Arrays.toString(supplyWagon(s1))); // [10,15]

        int[] s2 = {1,3,1,5};
        System.err.println(Arrays.toString(supplyWagon(s2))); // [5,5]

    }

    // 7, 3, 6, 1, 8
    // 7, 3, 7, 8
    // 10, 7, 8
    // 10, 15
    public static int[] supplyWagon(int[] supplies) {
        // len: 需要合并的次数；每次合并两个数字
        int len = supplies.length%2 == 0 ? supplies.length / 2 : supplies.length / 2 + 1;

        while (len > 0) {
            int minCt = Integer.MAX_VALUE;
            int idx = 0;
            // 遍历数组中，和最小的两个数的下标（由于是[i+(i-1)]）所以下标是后面的数字下标
            for (int i = 1; i < supplies.length; i++) {
                int i1 = supplies[i] + supplies[i - 1];
                if (i1 < minCt) {
                    minCt = i1;
                    idx = i;
                }
            }

            // 将最小和，赋值到数组前一个下标内
            supplies[idx-1] = minCt;
            // 后面的元素前移
            if (supplies.length - 1 - idx >= 0) {
                System.arraycopy(supplies, idx + 1, supplies, idx, supplies.length - 1 - idx);
            }
            supplies = Arrays.copyOfRange(supplies, 0, supplies.length-1);
            len--;
        }

        return supplies;
    }

}
