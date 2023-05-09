package com.example.demo.leetcode.ii;

/**
 * Description: 6419. 使二叉树所有路径值相等的最小代价
 *  给你一个整数n表示一棵 满二叉树里面节点的数目，节点编号从 1到 n。根节点编号为 1，树中每个非叶子节点i都有两个孩子，分别是左孩子2 * i和右孩子2 * i + 1。
 * 树中每个节点都有一个值，用下标从0开始、长度为 n的整数数组cost表示，其中cost[i]是第i + 1个节点的值。每次操作，你可以将树中任意节点的值增加1。你可以执行操作 任意 次。
 * 你的目标是让根到每一个 叶子结点的路径值相等。请你返回 最少需要执行增加操作多少次。
 *
 * 注意：
 * 满二叉树指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个节点，且所有叶子节点距离根节点距离相同。
 * 路径值 指的是路径上所有节点的值之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/9 11:24
 */
public class MinIncrements {
    public static void main(String[] args) {
        int n1 = 7;
        int[] c1 = {1,5,2,2,3,3,1};
        System.err.println(minIncrements(n1, c1)); // 6

        int n2 = 3;
        int[] c2 = {5,3,3};
        System.err.println(minIncrements(n2, c2)); // 0

    }


    // 从叶子结点开始，使同一层的叶子结点值相等
    public static int minIncrements(int n, int[] cost) {
        var res = 0;
        for (int i = n / 2; i > 0; --i) {
            res += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);

        }
        return res;
    }


}
