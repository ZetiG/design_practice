package com.example.demo.leetcode.i;

/**
 * Description: 2591. 将钱分给最多的儿童
 *
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 *
 * 你需要按照如下规则分配：
 *      1. 所有的钱都必须被分配。
 *      2. 每个儿童至少获得 1 美元。
 *      3. 没有人获得 4 美元。
 *
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 *
 * @author Zeti
 * @date 2023/9/22 15:42
 */
public class DistMoney {
    public static void main(String[] args) {
        // money = 20, children = 3  // 1
        System.err.println(distMoney(20, 3));

        // money = 16, children = 2  // 2
        System.err.println(distMoney(16, 2));

        // money = 16, children = 3  // 1
        System.err.println(distMoney(16, 3));

        // money = 2, children = 2  // 0
        System.err.println(distMoney(2, 2));

        // money = 12, children = 3  // 1
        System.err.println(distMoney(12, 3));

        // money = 17, children = 2  // 1
        System.err.println(distMoney(17, 2));

    }

    // 大神解：数学论，分情况计算
    public static int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        // 假设每个孩子数量均获得8美元后，还未分配完金额，则默认将剩余的钱全部给其中一个孩子，所以答案需要减去一个
        if (money > 8 * children) {
            return children - 1;
        }
        // 假设总金额刚好等于n-1个孩子分配到8美元且剩余4美元, 则代表被减去的那个孩子只能分到4美元，由题目要求得知不能有孩子分配到4美元，
        // 这时需要揪出一个能获得8美元的孩子，和这个获得4美元的孩子进行整合分配(这两个孩子怎么分都无所谓)
        // (20 == 8 * 3 - 4)
        if (money == 8 * (children - 1) + 4) {
            return children - 2;
        }
        // 先保证每个孩子至少能分到1美元，那么最多有多少孩子能获得8美元就是简单的除法计算了，
        // 因为前面保证每个孩子至少1美元，所以除的时候则是除以/(8-1)美元
        return (money - children) / 7;
    }

    // 官方解
    public static int distMoney2(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int cnt = Math.min(money / 7, children);
        money -= cnt * 7;
        children -= cnt;
        if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
            cnt--;
        }
        return cnt;
    }

    // 自己解：依赖贪心思想，一开始认为所有孩子都可以分配8美元，判断是否满足题目要求条件，如果不满足则逐个减少能获得8美元的孩子的数量
    public static int distMoney3(int money, int children) {
        if (money <=0 || money < children) {
            return -1;
        }
        int i = children;
        while (i > 0) {
            int sum = i * 8;
            int r1 = money - sum;
            int c1 = children - i;
            if (sum <= money && r1 >= c1 && !(c1 == 0 && r1 > 0) && !(r1 == 4 && c1 == 1)) {
                return i;
            }
            i--;
        }
        return 0;
    }


}
