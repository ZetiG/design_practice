package com.example.demo.leetcode.i;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 二叉树迭代
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 *
 * ps1: 输入：root = [1,null,2,3]  输出：[1,3,2]
 * ps2: 输入：root = [1,2]         输出：[2,1]
 * ps3: 输入：root = []            输出：[]
 * ps4: 输入：root = [1,null,2]    输出：[1,2]
 *
 * @author Zeti
 * @date 2022/3/15 5:31 PM
 */
public class BinaryTreeTraversal {

    //               8
    //        6              13
    //    5      7        9       16
    //  3  4   5   7    7   10  15  18
    public static void main(String[] args) {
        // L4
        TreeNode nodeL4_1 = new TreeNode();
        nodeL4_1.val = 3;

        TreeNode nodeR4_2 = new TreeNode();
        nodeR4_2.val = 4;

        TreeNode nodeL4_3 = new TreeNode();
        nodeL4_3.val = 5;

        TreeNode nodeR4_4 = new TreeNode();
        nodeR4_4.val = 7;

        TreeNode nodeL4_5 = new TreeNode();
        nodeL4_5.val = 7;

        TreeNode nodeR4_6 = new TreeNode();
        nodeR4_6.val = 10;

        TreeNode nodeL4_7 = new TreeNode();
        nodeL4_7.val = 15;

        TreeNode nodeR4_8 = new TreeNode();
        nodeR4_8.val = 18;

        // L3
        TreeNode nodeL3_1 = new TreeNode();
        nodeL3_1.val = 5;
        nodeL3_1.left = nodeL4_1;
        nodeL3_1.right = nodeR4_2;

        TreeNode nodeR3_2 = new TreeNode();
        nodeR3_2.val = 7;
        nodeR3_2.left = nodeL4_3;
        nodeR3_2.right = nodeR4_4;

        TreeNode nodeL3_3 = new TreeNode();
        nodeL3_3.val = 9;
        nodeL3_3.left = nodeL4_5;
        nodeL3_3.right = nodeR4_6;

        TreeNode nodeR3_4 = new TreeNode();
        nodeR3_4.val = 16;
        nodeR3_4.left = nodeL4_7;
        nodeR3_4.right = nodeR4_8;

        // L2
        TreeNode nodeL2 = new TreeNode();
        nodeL2.val = 6;
        nodeL2.left = nodeL3_1;
        nodeL2.right = nodeR3_2;

        TreeNode nodeR2 = new TreeNode();
        nodeR2.val = 13;
        nodeR2.left = nodeL3_3;
        nodeR2.right = nodeR3_4;

        // L1
        TreeNode root = new TreeNode();
        root.val = 8;
        root.left = nodeL2;
        root.right = nodeR2;


        // 递归
        List<Integer> integers = inorderTraversal(root);
        System.err.println(integers);

        // 迭代
        System.err.println(inorderTraversal2(root));

        // morris
        System.err.println(inorderTraversal3(root));

        System.err.println(inorderTraversal4(root));

    }

    private static void createTreeNode(TreeNode root, int level) {
        if (level <= 0) {
            return;
        }

        TreeNode nodeL = new TreeNode();
        nodeL.val = level + 1;

        TreeNode nodeR = new TreeNode();
        nodeR.val = level + 2;

        root.left = nodeL;
        root.right = nodeR;

        level--;

        createTreeNode(nodeL, level);
        createTreeNode(nodeR, level);
    }

    /**
     * 递归
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    // 递归
    private static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    /**
     * 迭代
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {

            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.poll();
            list.add(root.val);
            root = root.right;

        }

        return list;
    }

    /**
     * Morris
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {

                while (node != null && node.left != null) {
                    node = node.left;
                }

            } else {
                node = node.right;
            }
            list.add(node.val);
        }
        return list;
    }

    public static List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {  // 说明左子树已经访问完了，我们需要断开链接
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else { // 如果没有左孩子，则直接访问右孩子
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }



    //               8
    //        6              13
    //    5      7        9       16
    //  3  4   5   7    7   10  15  18
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
