package com.example.demo.leetcode.ii;

/**
 * Description: 2807. 在链表中插入最大公约数
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 *
 * @author Zeti
 * @date 2024/1/8 16:36
 */
public class InsertGreatestCommonDivisors {
    public static void main(String[] args) {
        // 输入：head = [18,6,10,3]
        //输出：[18,6,6,2,10,1,3]
        //解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
        //- 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
        //- 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
        //- 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
        //所有相邻结点之间都插入完毕，返回链表。

        // res = [18,6,6,2,10,1,3]
        ListNode h4 = new ListNode(3);
        ListNode h3 = new ListNode(10, h4);
        ListNode h2 = new ListNode(6, h3);
        ListNode h1 = new ListNode(18, h2);
        System.err.println(insertGreatestCommonDivisors(h1));


    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        for (ListNode cur = head; cur.next != null; cur = cur.next.next) {
            cur.next = new ListNode(gcd(cur.val, cur.next.val), cur.next);
        }
        return head;
    }

    public static ListNode insertGreatestCommonDivisors2(ListNode head) {
        ListNode currNode = head;
        while (currNode != null && currNode.next != null) {
            ListNode next = currNode.next;
            int gcdOfTwoNum = maxGcdOfTwoNum(currNode.val, next.val);
            currNode.next = new ListNode(gcdOfTwoNum, next);
            currNode = next;
        }
        return head;
    }


    // 1. greatest common divisor 求两数的最大公约数1
    private static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    // 2. greatest common divisor 求两数的最大公约数2
    private static int maxGcdOfTwoNum(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : maxGcdOfTwoNum(b, a % b);
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
