package com.leetCode._1th;

import java.util.Stack;

public class Test4 {
	/**
     * 1. 假设有两个栈，A 和 B。其中 A 装满了元素，但是没有排序；B 是空的。请利用这两个栈，将 A 中的元素按照降序排好放入 B 中。
     * 假设我们已经有一个 Stack 类，并且已经实现有以下的方法 push - 入栈， pop - 出栈， peek -
     * 查看栈顶元素但是不弹出，isEmpty - 看栈是否为空。 注意，我们希望这个方法是空间复杂度为 O(1) 的
     */

public Stack<Integer> sort(Stack<Integer> stack){
    Stack<Integer> reVal = new Stack<Integer>();
    while(!stack.isEmpty()){
        int tmp = stack.pop();//
        while(!reVal.isEmpty()&&reVal.peek()>tmp){
            int tmp2 = reVal.pop();
            stack.push(tmp2);
        
        }
        reVal.push(tmp);
    }
    return reVal;
}
public static void main(String[] args) {
	Stack<Integer> s = new Stack<Integer>();
	s.push(2);
	s.push(2);
	s.push(5);
	s.push(3);
	Test4 t = new Test4();
	Stack<Integer> r = t.sort(s);
	System.out.println(r.toString());
	int size = r.size();
	for(int i = 0; i < size; i++){
		System.out.println(r.pop());
	}
}
}
