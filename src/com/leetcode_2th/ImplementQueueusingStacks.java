package com.leetcode_2th;

import java.util.Stack;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月19日 下午9:23:43 
 *
 */
public class ImplementQueueusingStacks {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
    	int size = s2.size();
    	for(int i = 0; i < size; i++) {
    		s.push(s2.pop());
    	}
    	s.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	int size = s.size();
    	for(int i = 0; i < size; i++) {
    		s2.push(s.pop());
    	}
        s2.pop();
    }

    // Get the front element.
    public int peek() {
    	int size = s.size();
    	for(int i = 0; i < size; i++) {
    		s2.push(s.pop());
    	}
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	int size = s.size();
    	for(int i = 0; i < size; i++) {
    		s2.push(s.pop());
    	}
        return s2.isEmpty();
    }
}
