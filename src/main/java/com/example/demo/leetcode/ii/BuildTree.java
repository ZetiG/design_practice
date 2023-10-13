package com.example.demo.leetcode.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * @author Zeti
 * @date 2023/10/10 16:46
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] p1 = {3,9,20,15,7};
        int[] i1 = {9,3,15,20,7};
        System.err.println(buildTree(p1, i1));  // 3,9,20,null,null,15,7

        int[] p2 = {-1};
        int[] i2 = {-1};
        System.err.println(buildTree(p2, i2));  // -1

        int[] p3 = {3,9,4,1,6,20,15,7};
        int[] i3 = {4,1,9,6,3,15,20,7};
        System.err.println(buildTree(p3, i3));  // 3,9,20,null,null,15,7

    }

    private static Map<Integer, Integer> indexMap;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode treeNode = myBuildTree(preorder, 0, n - 1, 0);
        return treeNode;
    }

    // {3,9,4,1,6,20,15,7};  中-左-右
    // {4,1,9,6,3,15,20,7};  左-中-右
    public static TreeNode myBuildTree(int[] pre, int pStart, int pEnd, int iStart) {
        if (pStart > pEnd) {
            return null;
        }

        int root = pre[pStart];     // 在前序遍历中定位根节点, 前序遍历第一个节点就是根节点，子树同理
        TreeNode td = new TreeNode(root);   // 先把根节点建立出来
        Integer iEnd = indexMap.get(root);  // 查出根节点在中序遍历中的下标
        int subSize = iEnd - iStart;    // 得到左子树中的节点数目

        td.left = myBuildTree(pre, pStart+1, pStart+subSize, iStart);
        td.right = myBuildTree(pre, pStart+subSize+1, pEnd, iEnd+1);

        return td;
    }

    public static TreeNode myBuildTree2(int[] p1, int plIdx, int prIdx, int ilIdx) {
        if (plIdx > prIdx) {
            return null;
        }

        int in_root = indexMap.get(p1[plIdx]);  // 在中序遍历中定位根节点
        TreeNode root = new TreeNode(p1[plIdx]);    // 先把根节点建立出来
        int size_left_subtree = in_root - ilIdx;    // 得到左子树中的节点数目

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(p1, plIdx + 1, plIdx + size_left_subtree, ilIdx);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(p1, plIdx + size_left_subtree + 1, prIdx, in_root + 1);
        return root;
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
