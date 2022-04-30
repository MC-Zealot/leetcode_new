package com.leetcode_3th.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()" 输出: true 示例 2:
 * 
 * 输入: "()[]{}" 输出: true 示例 3:
 * 
 * 输入: "(]" 输出: false 示例 4:
 * 
 * 输入: "([)]" 输出: false 示例 5:
 * 
 * 输入: "{[]}" 输出: true
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 5:26:57 PM
 *
 */
public class ValidParentheses {
	private static final Map<Character, Character> map = new HashMap<Character, Character>() {
		{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}
	};
	public boolean isValid(String s) {
		boolean res = false;
		if (s == null) {
			return res;
		}
		if (s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		// 入栈
		for (int i = 0; i < s.length(); i++) {

			if (stack.size() > 0 ) {
				if(String.valueOf(s.charAt(i)).equals(String.valueOf(map.get(stack.peek())))) {
					stack.pop();
					continue;
				}
				
			}
			stack.push(s.charAt(i));
			System.out.println(stack.size()+", "+stack.peek()+", " + s.charAt(i)+"," + String.valueOf(stack.peek()).equals(String.valueOf(s.charAt(i))));
		}
		if (stack.size() == 0) {
			return true;
		}
		return res;
	}

	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("()[]{}"));
	}
}
