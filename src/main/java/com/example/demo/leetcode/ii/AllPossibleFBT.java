package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 894. 所有可能的真二叉树
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 * @author Zeti
 * @date 2024/4/2 10:35
 */
public class AllPossibleFBT {
    public static void main(String[] args) {
        System.err.println(allPossibleFBT(7));
        System.err.println(allPossibleFBT(3));
        System.err.println(allPossibleFBT(4));
        System.err.println(allPossibleFBT(1));
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        List<TreeNode>[] dp = new List[n+1];
        for(int i = 0;i <= n;i++){
            dp[i] = new ArrayList<>();
        }

        // 初始根节点，当n=1时，只会存在根节点
        dp[1].add(new TreeNode(0));

        for (int i = 3; i <= n; i+=2) {
            for (int j = 1; j < i; j+=2) {

                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i-1-j]) {
                        dp[i].add(new TreeNode(0, left, right));
                    }
                }
            }
        }
        return dp[n];
    }



    public static List<TreeNode> allPossibleFBT2(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < n-1; i+=2) {
            List<TreeNode> lns = allPossibleFBT(i);
            List<TreeNode> rns = allPossibleFBT(n-1-i);

            for (TreeNode ln : lns) {
                for (TreeNode rn : rns) {
                    list.add(new TreeNode(0, ln, rn));
                }
            }
        }
        return list;
    }




    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
