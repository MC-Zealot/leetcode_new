package com.leetCode._1th;

import java.util.Stack;

/**
 * 
 * @author Zealot
 * @date 2015年7月30日 下午9:50:00
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
    public static void main(String[] args) {
    	ImplementQueueusingStacks i = new ImplementQueueusingStacks();
    	i.push(1);
    	i.push(2);
    	System.out.println(i.peek());
//    	Stack<Integer> s = new Stack<Integer>();
//    	s.push(1);
//    	s.push(2);
//    	System.out.println(s.peek());
	}
}
