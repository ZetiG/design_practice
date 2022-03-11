package com.example.demo.data_structure;

import org.apache.commons.lang3.RandomUtils;

import java.util.Stack;

/**
 * Description: 跳跃表
 *
 * @author Zeti
 * @date 2022/3/10 4:48 PM
 */
public class SkipList<T> {

    final int MAX_LEVEL = 32;//最大的层
    Node<T> head;  //头节点，入口
    int highLevel;  //当前跳表索引层数

    public SkipList(Node<T> head) {
        this.head = head;
    }

    public SkipList(){
        head = new Node(Integer.MIN_VALUE,null);
        highLevel=0;
    }

    /**
     * 跳表查询
     *
     * @param target 目标下标
     * @return
     */
    public Node search(int target) {
        Node head = this.head;
        while (head != null) {

            // 首节点即为目标
            if (head.idx == target) {
                return head;
            }

            // 右节点为空，或者大于当前下标，则向下一层
            if (head.right == null || head.right.idx > target) {
                head = head.down;
                continue;
            }

            // 右节点即为目标
            if (head.right.idx == target) {
                return head.right;
            } else {
                head = head.right;
            }
        }

        return null;
    }

    public void add(Node<T> node) {
        int idx = node.idx;

        // 查询是否存在该节点
        Node nd = search(idx);
        if (nd != null) {
            // 若存在该节点, 则覆盖val
            nd.val = node.val;
            return;
        }

        // 定义栈，记录需要建立的索引
        Stack<Node<T>> stack = new Stack<>();
        Node<T> head = this.head;
        while (head != null) {

            // 当前节点等于目标节点 或者 右侧无节点 或者 右侧节点大于当前插入节点，向下
            if (head.idx == idx || head.right == null || head.right.idx > idx) {
                // 将曾经向下的节点记录一下
                stack.add(head);
                head = head.down;

            } else {
                // 右侧有节点，且小于当前节点，则继续向右查找
                head = head.right;
            }
        }

        // 当前索引层，初始第一层
        int level = 1;
        Node<T> downNode = null;

        while (!stack.isEmpty()) {

            // 抛出待插入的左侧节点, 并在该层插入node
            head = stack.pop();

            Node<T> nodeTeam = new Node<>(node.idx, node.val);//节点需要重新创建
            nodeTeam.down = downNode;   // 处理竖方向
            downNode = nodeTeam;    // 标记新的节点下次使用

            //右侧为null 说明插入在末尾
            if (head.right == null) {
                head.right = nodeTeam;

            } else if (head.right.idx > node.idx) {    // 右侧还有节点，插入在两者之间
                nodeTeam.right = head.right;
                head.right = nodeTeam;
            }

            // 判断是否需要结束创建索引，一、到达最高级节点；二、随机数概率
            if (level > MAX_LEVEL || RandomUtils.nextFloat(0,1) > 0.7) {
                break;
            }

            // 向上建索引
            level++;

            // 比当前最大高度要高但是依然在允许范围内 需要改变head节点
            if (level > highLevel) {
                highLevel = level;
                //需要创建一个新的节点
                Node<T> highHeadNode = new Node<>(Integer.MIN_VALUE, null);
//                highHeadNode.down = nodeTeam;
                highHeadNode.down = this.head;
                this.head = highHeadNode;
                // TODO: 2022/3/11  
                head = highHeadNode;    // 改变head
                stack.add(head);    // 下次抛出head
            }
        }

    }

    /**
     * 删除
     *
     * @param target
     * @return
     */
    public void erase(int target) {
        Node node = head;
        while (node != null) {

            // 首节点即为目标
            if (head.idx == target) {
                head = head.down;
            }

            // 右节点为空，或者大于当前下标，则向下一层
            if (head.right == null || head.right.idx > target) {
                head = head.down;
                continue;
            }

            // 右节点即为目标
            if (head.right.idx == target) {
                head.right = head.right.right;  // 删除当前层索引该元素
                head = head.down;   // 继续向下找，并删除下层该元素
            } else {
                head = head.right;
            }
        }

    }

    static class Node<T> {
        int idx;
        T val;
        Node<T> right, down;

        public Node(int idx, T val) {
            this.idx = idx;
            this.val = val;
        }

    }


    public void printList() {
        Node teamNode=head;
        int index=1;
        Node last=teamNode;
        while (last.down!=null){
            last=last.down;
        }
        while (teamNode!=null) {
            Node enumNode=teamNode.right;
            Node enumLast=last.right;
            System.out.printf("%-8s","head->");
            while (enumLast!=null&&enumNode!=null) {
                if(enumLast.idx==enumNode.idx) {
                    System.out.printf("%-5s",enumLast.idx+"->" + enumLast.val + "  ");
                    enumLast=enumLast.right;
                    enumNode=enumNode.right;
                } else{
                    enumLast=enumLast.right;
                    System.out.printf("%-5s","");
                }

            }
            teamNode=teamNode.down;
            index++;
            System.out.println();
        }
    }

    //  1       5
    //  1   3   5   7
    //  1 2 3 4 5 6 7 8
    public static void main(String[] args) {
        SkipList<Integer>list=new SkipList<>();
        for(int i=1;i<30;i++) {
            i++;
            list.add(new Node(i,i + "H"));
        }
        list.printList();


        list.add(new Node<>(5, 55));

        list.printList();
//        list.erase(4);
//        list.erase(8);
//        list.printList();
    }

}
