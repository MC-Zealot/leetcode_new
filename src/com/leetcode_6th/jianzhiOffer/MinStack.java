package com.leetcode_6th.jianzhiOffer;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    PriorityQueue<Integer> minHeap;
    public MinStack() {
        stack = new Stack<>();
        minHeap = new PriorityQueue<Integer>();
    }

    public void push(int x) {
        stack.add(x);
        minHeap.add(x);
    }

    public void pop() {
        int top = stack.pop();
        minHeap.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = minHeap.peek();
        return min;
    }
}
