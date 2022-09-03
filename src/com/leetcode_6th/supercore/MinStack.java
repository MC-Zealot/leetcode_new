package com.leetcode_6th.supercore;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stackMin;
    public MinStack() {
        stack = new Stack();
        stackMin = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if(stackMin.size() == 0 || stackMin.peek() >= val){
            stackMin.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if(stackMin.peek() == val){
            stackMin.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
