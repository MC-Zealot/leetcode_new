package com.leetCode._1th;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
 * @author Zealot
 * @date 2015年9月5日 下午9:43:10
 */
public class ImplementStackusingQueues {
	static Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	// Push element x onto stack.
    public void push(int x) {
    	q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(!empty()){
    		int size = q1.size()-1;
    		for(int i = 0; i < size; i++){
    			q2.offer(q1.poll());
    		}
    		q1.poll();
    		int size2 = q2.size();
    		for(int i = 0; i <size2; i++) {
    			q1.offer(q2.poll());
    		}
    	}
    }

    // Get the top element.
    public int top() {
    	int reVal =0;
    	int size = q1.size()-1;
    	for(int i = 0; i < size; i++){
        	q2.offer(q1.poll());
        }
    	reVal = q1.peek();
    	q2.offer(q1.poll());
    	int size2 = q2.size();
        for(int i = 0; i < size2; i++) {
        	q1.offer(q2.poll());
        }
        return reVal;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return q1.isEmpty();
    }
    public static void main(String[] args) {
    	ImplementStackusingQueues i = new ImplementStackusingQueues();
    	i.push(1);
    	System.out.println(q1.toString());
    	i.push(2);
    	System.out.println(q1.toString());
//    	System.out.println(i.top());
    	i.push(3);
    	System.out.println(q1.toString());
    	i.push(4);
    	System.out.println(q1.toString());
    	System.out.println(i.top());
    	System.out.println(i.top());
	}
}
