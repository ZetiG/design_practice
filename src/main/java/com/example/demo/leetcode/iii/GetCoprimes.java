package com.example.demo.leetcode.iii;

import java.util.*;

/**
 * Description: 1766. 互质树
 *
 * 给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点。
 * 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
 * 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
 * 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
 * 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如果不存在这样的祖先节点，ans[i] 为 -1 。
 *
 * @author Zeti
 * @date 2024/4/11 10:24
 */
public class GetCoprimes {
    public static void main(String[] args) {
        int[] n1 = {2,3,3,2};
        int[][] e1 = {{0,1},{1,2},{1,3}};
        System.err.println(Arrays.toString(getCoprimes(n1, e1)));  // [-1,0,0,1]
//
//        int[] n2 = {5,6,10,2,3,6,15};
//        int[][] e2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
//        System.err.println(Arrays.toString(getCoprimes(n2, e2)));  // [-1,0,-1,0,0,0,-1]

//        int[] n2 = {9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9};
//        int[][] e2 = {{17,0},{30,17},{41,30},{10,30},{13,10},{7,13},{6,7},{45,10},{2,10},{14,2},{40,14},{28,40},{29,40},{8,29},{15,29},{26,15},{23,40},{19,23},{34,19},{18,23},{42,18},{5,42},{32,5},{16,32},{35,14},{25,35},{43,25},{3,43},{36,25},{38,36},{27,38},{24,36},{31,24},{11,31},{39,24},{12,39},{20,12},{22,12},{21,39},{1,21},{33,1},{37,1},{44,37},{9,44},{46,2},{4,46}};
//        System.err.println(Arrays.toString(getCoprimes(n2, e2)));  // [-1,21,17,43,10,42,7,13,29,44,17,31,39,10,10,29,32,0,40,23,12,39,12,40,25,35,15,38,40,40,17,24,5,1,19,14,17,21,25,24,14,17,40,25,37,17,10]

    }



    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    static {
        // 预处理，题目说明每个节点的取值范围是1-50；这里率先初始化50内所有数对应的质数
        // coprime[i] 保存 [1, MX) 中与 i 互质的所有元素
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }
    }

    public static int[] getCoprimes(int[] nums, int[][] edges) {
        // 构建数组内所有元素的无向环图(因为题目并没有说明edges数组[0]和[1]哪个是父节点和子节点)
        List<Integer>[] g = new ArrayList[nums.length];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edg : edges) {
            g[edg[0]].add(edg[1]);
            g[edg[1]].add(edg[0]);
        }

        // 最终返回数组
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        int[] valDepth = new int[MX];
        int[] valNodeId = new int[MX];
        dfs(0, -1, 1, g, nums, ans, valDepth, valNodeId);
        return ans;
    }

    // x：当前节点下标(初始0);
    private static void dfs(int x, int fa, int depth, List<Integer>[] g, int[] nums, int[] ans, int[] valDepth, int[] valNodeId) {
        // x 的节点值
        int val = nums[x];

        // 计算与 val 互质的祖先节点值中，节点深度最大的节点编号
        int maxDepth = 0;
        for (int j : coprime[val]) {
            if (j == 0) {
                break;
            }
            if (valDepth[j] > maxDepth) {
                maxDepth = valDepth[j];
                ans[x] = valNodeId[j];
            }
        }

        // tmpDepth 和 tmpNodeId 用于恢复现场
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];

        // 保存 val 对应的节点深度和节点编号
        valDepth[val] = depth;
        valNodeId[val] = x;

        // 向下递归
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
            }
        }

        // 恢复现场
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
