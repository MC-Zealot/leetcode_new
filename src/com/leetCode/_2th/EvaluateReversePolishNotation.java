package com.leetCode._2th;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author Zealot
 * @date 2016年3月22日 下午9:03:44 
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if(tokens.length==0){
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(String str: tokens){
			if("+".equals(str)){
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num1+num2);
			}else if("-".equals(str)){
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num2-num1);
			}else if("*".equals(str)){
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num2*num1);
			}else if("/".equals(str)){
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num2/num1);
			}else{
				stack.push(Integer.parseInt(str));
			}
		}
		
		return stack.peek();
    }
	public static void main(String[] args) {
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		String[] s = {"4", "13", "5", "/", "+"};
		System.out.println(e.evalRPN(s));
	}
}
