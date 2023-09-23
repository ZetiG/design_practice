package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author Zeti
 * @date 2023/9/23 10:03
 */
public class LevelOrder {
    public static void main(String[] args) {
        // 3,9,20,null,null,15,7   // [[3],[9,20],[15,7]]
        TreeNode t5 = new TreeNode(7);
        TreeNode t4 = new TreeNode(15);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9);
        TreeNode t1 = new TreeNode(3, t2, t3);
        System.err.println(levelOrder(t1));

        TreeNode t11 = new TreeNode(1);
        System.err.println(levelOrder(t11));

        TreeNode t_2 = new TreeNode(2);
        TreeNode t_1 = new TreeNode(1, t_2, null);
        System.err.println(levelOrder(t_1));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 用于存储每一层级的节点值
        List<Integer> resSon = new ArrayList<>();

        // 先进先出队列
        LinkedList<TreeNode> linked = new LinkedList<>();
        linked.push(root);
        int num = 1;    // 当前层节点数量，因为是根节点且已入栈，初始化1
        int numSon = 0; // 下一层节点数量

        // 开始
        TreeNode td;
        while (!linked.isEmpty()) {
            td = linked.pop();   // 进入循环后，栈顶元素出栈
            num--;
            if (td == null) {   // 当前元素为空，出栈
                continue;
            }

            resSon.add(td.val);

            // 当前节点的左右子节点入栈，这里儿子层数量++
            if (td.left != null) {
                linked.offer(td.left);
                numSon++;
            }
            if (td.right != null) {
                linked.offer(td.right);
                numSon++;
            }

            // 当当前层数为0，代表当前层被遍历完，将该层的节点值加入待返回的集合
            if (num == 0) {
                res.add(resSon);
                resSon = new ArrayList<>();
                num = numSon;
                numSon = 0;
            }
        }
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

