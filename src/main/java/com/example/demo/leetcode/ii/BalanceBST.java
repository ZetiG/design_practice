package com.example.demo.leetcode.ii;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1382. 将二叉搜索树变平衡
 *
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * @author Zeti
 * @date 2023/9/21 15:05
 */
public class BalanceBST {
    public static void main(String[] args) {
        // [1,null,2,null,3,null,4,null,null] =>> [2,1,3,null,null,null,4]
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, null, t4);
        TreeNode t2 = new TreeNode(2, null, t3);
        TreeNode t1 = new TreeNode(1, null, t2);

        System.err.println(balanceBST(t1));

        // [2,1,3]  =>> [2,1,3]
        TreeNode t_3 = new TreeNode(3);
        TreeNode t_1 = new TreeNode(1);
        TreeNode t_2 = new TreeNode(2, t_1, t_3);
        System.err.println(balanceBST(t_2));

    }


    public static TreeNode balanceBST(TreeNode root) {
        // 1.遍历出元素
        int[] nums = traverse(root);

        // 2.重组新的二叉树， 参考lc.108.将有序数组转换为二叉搜索树[i.SortedArrayToBST]
        TreeNode treeNode = sortedArrayToBST(nums);

        return treeNode;
    }

    /**
     * 遍历二叉树获取所有元素的值，并升序排序
     * {@link  com.example.demo.leetcode.i.SortedArrayToBST}
     * @param nums
     * @return List<Integer>
     */
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

    /**
     * 二叉树中序遍历，并升序排序
     * {@link  com.example.demo.leetcode.i.InorderTraversal}
     * @param root
     * @return List<Integer>
     */
    public static int[] traverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        while (root != null || !queue.isEmpty()) {
            if (root != null) {
                queue.push(root);
                root = root.left;
            } else {
                TreeNode pop = queue.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res.stream().sorted().mapToInt(a->a).toArray();
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
