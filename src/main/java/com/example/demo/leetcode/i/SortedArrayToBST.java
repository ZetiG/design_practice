package com.example.demo.leetcode.i;

/**
 * Description: 108. 将有序数组转换为二叉搜索树
 *  给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author Zeti
 * @date 2023/9/21 14:26
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] n1 = {-10,-3,0,5,9};
        System.err.println(sortedArrayToBST(n1));

        int[] n2 = {1,2};
        System.err.println(sortedArrayToBST(n2));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
    }

    public static TreeNode bst(int[] nums, int lIdx, int rIdx) {
        if (lIdx > rIdx) {
            return null;
        }

        int mIdx = (lIdx + rIdx) / 2;

        TreeNode root = new TreeNode(nums[mIdx]);
        root.left = bst(nums, lIdx, mIdx-1);
        root.right = bst(nums, mIdx+1, rIdx);
        return root;
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
