package com.example.demo.leetcode.ii;

/**
 * Description: 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author Zeti
 * @date 2024/4/10 14:57
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode t9 = new TreeNode(8);
        TreeNode t8 = new TreeNode(0);
        TreeNode t7 = new TreeNode(1, t8, t9);
        TreeNode t6 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2, t5, t6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t2 = new TreeNode(5, t3, t4);
        TreeNode t1 = new TreeNode(3, t2, t7);

        System.err.println(lowestCommonAncestor(t1, t6, t9).val); // 3


    }

    //        3
    //    5       1
    //  6   2   0   8
    //    7   4
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
