package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午8:28:21 
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String s: tokens) {
			if("+".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			} else if("-".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			} else if("*".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			} else if("/".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
			} else{
				stack.push(Integer.parseInt(s));
			}
		}
		
		return stack.peek();
    }
	
	interface Operator {
		int eval(int x, int y);
	}

	private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {
		{
			put("+", new Operator() {
				public int eval(int x, int y) {
					return x + y;
				}
			});
			put("-", new Operator() {
				public int eval(int x, int y) {
					return x - y;
				}
			});
			put("*", new Operator() {
				public int eval(int x, int y) {
					return x * y;
				}
			});
			put("/", new Operator() {
				public int eval(int x, int y) {
					return x / y;
				}
			});
		}
	};

	public int evalRPN2(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
