package com.example.demo.leetcode.i;

/**
 * Description: 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
 *
 * @author Zeti
 * @date 2023/6/26 10:28
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode lna1 = new ListNode(4);
        ListNode lna2 = new ListNode(1);
        ListNode lna3 = new ListNode(8);
        ListNode lna4 = new ListNode(4);
        ListNode lna5 = new ListNode(5);
        lna1.next =lna2;
        lna2.next =lna3;
        lna3.next =lna4;
        lna4.next =lna5;

        ListNode lnb1 = new ListNode(5);
        ListNode lnb2 = new ListNode(6);
        ListNode lnb3 = new ListNode(1);
        ListNode lnb4 = new ListNode(8);
        ListNode lnb5 = new ListNode(4);
        ListNode lnb6 = new ListNode(5);
        lnb1.next =lnb2;
        lnb2.next =lnb3;
        lnb3.next =lnb4;
        lnb4.next =lnb5;
        lnb5.next =lnb6;


        System.err.println(getIntersectionNode(lna1, lnb1));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }


}
