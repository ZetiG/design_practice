package com.example.demo.leetcode.ii;

/**
 * Description: 1261. 在受污染的二叉树中查找元素
 *
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果
 *
 * @author Zeti
 * @date 2024/3/12 10:54
 */
public class FindElements {
    public static void main(String[] args) {
        // [[[-1,null,-1]]
        TreeNode trr1 = new TreeNode(-1);
        TreeNode t1 = new TreeNode(-1, null, trr1);
        FindElements fe1 = new FindElements(t1);
        System.err.println(fe1.find(1));
        System.err.println(fe1.find(2));

        //             0
        //       1            2
        //    3     4      5     6
        //  7   8     10       13
        //       18
        //
        TreeNode tl18 = new TreeNode(-1);
        TreeNode tl8 = new TreeNode(-1, null, tl18);
        TreeNode tl7 = new TreeNode(-1);
        TreeNode tl3 = new TreeNode(-1, tl7, tl8);
        TreeNode tl10 = new TreeNode(-1);
        TreeNode tl4 = new TreeNode(-1, null, tl10);
        TreeNode tl1 = new TreeNode(-1, tl3, tl4);

        TreeNode tr13 = new TreeNode(-1);
        TreeNode tr6 = new TreeNode(-1, tr13, null);
        TreeNode tr5 = new TreeNode(-1);
        TreeNode tr2 = new TreeNode(-1, tr5, tr6);

        TreeNode tn1 = new TreeNode(-1, tl1, tr2);

        FindElements fe2 = new FindElements(tn1);
        System.err.println(fe2);
        System.err.println(fe2.find(5));
        System.err.println(fe2.find(18));

    }


    TreeNode treeNode;

    public FindElements(TreeNode root) {
       if (root != null) {
           root.val = 0;
       }
        initElements(root);
    }

    private void initElements(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            initElements(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            initElements(root.right);
        }
        treeNode = root;
    }

    public boolean find(int target) {
        return dfs(treeNode, target);
    }

    private boolean dfs(TreeNode node, int target) {
        // 如果当前节点为空，返回false
        if (node == null) {
            return false;
        }
        // 如果当前节点值等于目标值，返回true
        if (node.val == target) {
            return true;
        }
        // 在左子树中查找目标值
        boolean leftResult = dfs(node.left, target);
        // 如果在左子树中找到，直接返回true
        if (leftResult) {
            return true;
        }
        // 在右子树中查找目标值
        boolean rightResult = dfs(node.right, target);
        // 如果在右子树中找到，直接返回true
        if (rightResult) {
            return true;
        }
        // 如果左右子树都没有找到，返回false
        return false;
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
