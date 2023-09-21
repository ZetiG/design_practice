package com.example.demo.leetcode.i;

/**
 * Description: 543. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * @author Zeti
 * @date 2023/9/21 10:50
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        // [1,2,3,4,5]   3
        TreeNode td5 = new TreeNode(5);
        TreeNode td4 = new TreeNode(4);
        TreeNode td3 = new TreeNode(3);
        TreeNode td2 = new TreeNode(2, td4, td5);
        TreeNode td1 = new TreeNode(1, td2, td3);
        DiameterOfBinaryTree bt1 = new DiameterOfBinaryTree();
        System.err.println(bt1.diameterOfBinaryTree(td1));


        TreeNode td_2 = new TreeNode(2);
        TreeNode td_1 = new TreeNode(1, td_2, null);
        DiameterOfBinaryTree bt2 = new DiameterOfBinaryTree();
        System.err.println(bt2.diameterOfBinaryTree(td_1));

    }

    int maxDepth;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        maxDepth = Math.max(maxDepth, (left + right));
        return Math.max(left, right) + 1;
    }


    static class TreeNode {
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

