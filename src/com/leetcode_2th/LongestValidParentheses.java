package com.leetcode_2th;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
 * 
 * parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author Zealot
 * @date 2016年7月4日 下午5:14:50 
 *
 */
public class LongestValidParentheses {
	Map<Character, Character> map = new HashMap<Character, Character>(){
		{
			put('(', ')');
		}
	};
	/**
	 * O(n^3)
	 * @date 2016年7月4日 下午5:41:10
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				String tmp  = s.substring(i, j + 1);
				if(isParentheses(tmp)){
					max= max< tmp.length()? tmp.length(): max;
				}
			}
		}
		return max;
    }
	private boolean isParentheses(String str) {
		if(str==null||str.length()==0){
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public int longestValidParentheses2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int start = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i + 1;
				} else {
					stack.pop();
					max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}  
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String s = "((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))";
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses(s));
		long end = System.currentTimeMillis();
		System.out.println(end -start);
	}
}
