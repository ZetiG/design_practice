package com.example.demo.leetcode.ii;

import lombok.Data;


/**
 * Description: 求两个链表表示的非负整数相加后的结果
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头
 * <p>
 * ps1: 输入：l1 = [2,4,3], l2 = [5,6,4]   输出：[7,0,8]  解释：342 + 465 = 807.
 * ps2: 输入：l1 = [0], l2 = [0]   输出：[0]
 * ps3: 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]     输出：[8,9,9,9,0,0,0,1]
 *
 * @author Zeti
 * @date 2022/1/19 2:55 PM
 */
public class LinkedNumberAdd {

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode ln2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        System.err.println(add(ln1, ln2));

        ListNode ln3 = new ListNode(0, null);
        ListNode ln4 = new ListNode(0, null);
        System.err.println(add(ln3, ln4));

        ListNode ln5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode ln6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        System.err.println(add(ln5, ln6));

        ListNode ln7 = new ListNode(9, null);
        ListNode ln8 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
        System.err.println(add(ln7, ln8));


    }


    // d1 遍历两个链表相加，逐级相加，为空补0，注意进位
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }


    @Data
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
