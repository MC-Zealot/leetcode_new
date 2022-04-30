package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午9:12:58
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
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
