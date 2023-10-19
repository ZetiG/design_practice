package com.example.demo.leetcode.ii;

/**
 * Description: 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author Zeti
 * @date 2023/10/18 16:24
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode td9 = new TreeNode(11);
        TreeNode td8 = new TreeNode(-3, null, td9);
        TreeNode td7 = new TreeNode(1);
        TreeNode td6 = new TreeNode(-2);
        TreeNode td5 = new TreeNode(3);
        TreeNode td4 = new TreeNode(2, null, td7);
        TreeNode td3 = new TreeNode(3, td5, td6);
        TreeNode td2 = new TreeNode(5, td3, td4);
        TreeNode td1 = new TreeNode(10, td2, td8);
        int k1 = 8;
        System.err.println(pathSum(td1, k1));   // 10,5,-3,3,2,null,11,3,-2,null,1 => 3


        TreeNode t10 = new TreeNode(1);
        TreeNode t9 = new TreeNode(5);
        TreeNode t8 = new TreeNode(4, t9, t10);
        TreeNode t7 = new TreeNode(13);
        TreeNode t6 = new TreeNode(8,t7, t8);
        TreeNode t5 = new TreeNode(2);
        TreeNode t4 = new TreeNode(7);
        TreeNode t3 = new TreeNode(11, t4, t5);
        TreeNode t2 = new TreeNode(4,  t3, null);
        TreeNode t1 = new TreeNode(5,t2, t6);
        int k2 = 22;
        System.err.println(pathSum(t1, k2));    // 5,4,8,11,null,13,4,7,2,null,null,5,1 => 3


        TreeNode td15 = new TreeNode(5);
        TreeNode td14 = new TreeNode(4, null, td15);
        TreeNode td13 = new TreeNode(3, null, td14);
        TreeNode td12 = new TreeNode(2, null, td13);
        TreeNode td11 = new TreeNode(1, null, td12);
        int k3 = 3;
        System.err.println(pathSum(td11, k3));


        TreeNode d6 = new TreeNode(1000000000);
        TreeNode d5 = new TreeNode(1000000000, d6, null);
        TreeNode d4 = new TreeNode(1000000000, d5, null);
        TreeNode d3 = new TreeNode(294967296, d4, null);
        TreeNode d2 = new TreeNode(1000000000, d3, null);
        TreeNode d1 = new TreeNode(1000000000, d2, null);
        int k4 = 0;
        System.err.println(pathSum(d1, k4));


    }

    public static int pathSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int res = tt(root, k);
        res += pathSum(root.left, k);
        res += pathSum(root.right, k);
        return res;
    }

    public static Integer tt(TreeNode td, long k) {
        int res = 0;
        if (td == null) {
            return 0;
        }

        if (td.val == k) {
            res++;
        }

        res += tt(td.left, k-td.val);
        res += tt(td.right, k-td.val);
        return res;
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