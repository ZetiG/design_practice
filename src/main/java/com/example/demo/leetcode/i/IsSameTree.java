package com.example.demo.leetcode.i;

/**
 * Description: 100. 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author Zeti
 * @date 2024/4/3 10:12
 */
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, t2,null);

        TreeNode t_3 = new TreeNode(2);
        TreeNode t_1 = new TreeNode(1, null,t_3);

        System.err.println(isSameTree(t1, t_1));


        System.err.println(isSameTree(null, new TreeNode(0)));


    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q == null)) {
            return true;
        }
        Integer pv = null, qv = null;

        if (p != null) {
            pv = p.val;
        }
        if (q != null) {
            qv = q.val;
        }
        if (pv == null || qv == null || !pv.equals(qv)) {
            return false;
        }


        if (!isSameTree(p.left, q.left)) return false;
        if (!isSameTree(p.right, q.right)) return false;

        return true;
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

