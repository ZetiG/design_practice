package com.example.demo.leetcode.i;

import java.util.Stack;

/**
 * Description: 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *      void push(int x) 将元素 x 推到队列的末尾
 *      int pop() 从队列的开头移除并返回元素
 *      int peek() 返回队列开头的元素
 *      boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 说明：
 *  你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *  你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * @author Zeti
 * @date 2024/3/7 14:30
 */
public class MyQueue {

    public static void main(String[] args) {
        // [null,null,null,null,null,1,null,2,3,4,5]
        MyQueue queue = new MyQueue(); // ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.push(5);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

    }

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x) {
        while (!st1.empty()) {
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.empty()) {
            st1.push(st2.pop());
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */