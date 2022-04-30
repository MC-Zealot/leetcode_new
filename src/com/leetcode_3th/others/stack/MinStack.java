package com.leetcode_3th.others.stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 * 
 * @author Zealot
 * @date Aug 1, 2019 9:25:17 PM 
 *
 */
public class MinStack {
	Stack<Integer> s = new Stack<Integer>();
	int min = Integer.MAX_VALUE;

	public void push(int x) {
		min = Math.min(min, x);
		s.push(x);
	}

	public void pop() {
		if (s.size() > 0) {
			int pop = s.pop();
			if (pop == min) {
				min = Integer.MAX_VALUE;
				Stack<Integer> tmp = new Stack<Integer>();
				while(s.size()>0) {
					min = Math.min(min, s.peek());
					tmp.push(s.pop());
				}
				while(tmp.size()>0) {
					s.push(tmp.pop());
				}
			}
		}

	}

	public int top() {
		if (s.size() > 0) {
			return s.peek();
		} else {
			return 0;
		}

	}

	public int getMin() {
		return min;
	}
}
