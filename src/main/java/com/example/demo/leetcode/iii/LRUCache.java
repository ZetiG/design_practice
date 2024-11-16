package com.example.demo.leetcode.iii;

import java.util.HashMap;

/**
 * Description: 146. LRU 缓存
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity
 * ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author Zeti
 * @date 2024/10/21 16:27
 */
public class LRUCache {
    public static void main(String[] args) {

        //输入
        //["put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[ [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        //输出
        //[null, null, null, 1, null, -1, null, -1, 3, 4]

        LRUCache lc1 = new LRUCache(2);
        lc1.put(1, 1);
        lc1.put(2, 2);
        System.err.println(lc1.get(1));
        lc1.put(3, 3);
        System.err.println(lc1.get(2));
        lc1.put(4, 4);
        System.err.println(lc1.get(1));
        System.err.println(lc1.get(3));
        System.err.println(lc1.get(4));
        System.err.println();

        // ["LRUCache","put","put","get","put","put","get"]
        //  [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        LRUCache lc2 = new LRUCache(2);
        lc2.put(2,1);
        lc2.put(2,2);
        System.err.println(lc2.get(2));
        lc2.put(1,1);
        lc2.put(4,1);
        System.err.println(lc2.get(2));
        System.err.println();

        // ["LRUCache","put","put","put","put","get","get"]
        // [[2],[],[],[],[],[1],[2]]
        LRUCache lc3 = new LRUCache(2);
        lc3.put(2,1);
        lc3.put(1,1);
        lc3.put(2,3);
        lc3.put(4,1);
        System.err.println(lc3.get(1));
        System.err.println(lc3.get(2));
        System.err.println();

    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.head = new ListNode();
        this.tail = new ListNode();
        this.capacity = capacity;
        this.size = 0;
        // 预先连接虚拟头尾节点
        this.head.next = this.tail;
        this.tail.pre = this.head;

    }

    public int get(int key) {
        // key不存在，返回-1
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 访问存在时
        // 中链表中摘除该节点，并将该节点的前后节点相连接
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;

        // 将该访问的节点放置头部
        ListNode headNext = head.next;
        head.next = node;
        headNext.pre = node;
        node.next = headNext;
        node.pre = head;

        return node.val;
    }

    public void put(int key, int value) {
        ListNode listNode = cache.get(key);
        if (listNode != null) {
            // key已经存在，修改val值
            listNode.val = value;

            // 获取前后节点，并连接它们
            ListNode pre = listNode.pre;
            ListNode next = listNode.next;
            pre.next = next;
            next.pre = pre;

        } else {
            // 不存在，新增
            listNode = new ListNode(key, value);
            if (size == capacity) {
                // 容量已满, 删除尾结点
                ListNode tailNode = tail.pre;
                ListNode tailNodePre = tailNode.pre;

                // 连接待删除尾结点的前一个节点和虚拟尾节点
                tailNodePre.next = tail;
                tail.pre = tailNodePre;

                cache.remove(tailNode.key);
            } else {
                // 容量未满，直接新增在头部
                size++;
            }
        }
        // 添加节点到头部
        ListNode headNext = head.next;
        headNext.pre = listNode;
        head.next = listNode;
        listNode.pre = head;
        listNode.next = headNext;

        cache.put(key, listNode);

    }

    private static HashMap<Integer, ListNode> cache;
    private final ListNode head, tail;
    private final int capacity;
    private int size;

    // 链表节点
    static class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;
        ListNode() {}
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

