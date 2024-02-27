package com.example.demo.leetcode.i;

/**
 * Description: 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author Zeti
 * @date 2024/2/27 16:49
 */
public class RangeSumBST {
    public static void main(String[] args) {
        RangeSumBST bst = new RangeSumBST();

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(5, t1, t2);
        TreeNode t4 = new TreeNode(18);
        TreeNode t5 = new TreeNode(15, null, t4);
        TreeNode t6 = new TreeNode(10, t3, t5);
        // 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
        // 输出：32
        System.err.println(bst.rangeSumBST(t6, 7, 15));


        TreeNode t_1 = new TreeNode(1);
        TreeNode t_3 = new TreeNode(3, t_1, null);
        TreeNode t_6 = new TreeNode(6);
        TreeNode t_7 = new TreeNode(7, t_6, null);
        TreeNode t_5 = new TreeNode(5, t_3, t_7);
        TreeNode t_13 = new TreeNode(13);
        TreeNode t_18 = new TreeNode(18);
        TreeNode t_15 = new TreeNode(15, t_13, t_18);
        TreeNode t_10 = new TreeNode(10, t_5, t_15);
        // 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        // 输出：23
        System.err.println(bst.rangeSumBST(t_10, 6, 10));

    }


    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            rangeSumBST(root.right, low, high);
        }
        return sum;
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
