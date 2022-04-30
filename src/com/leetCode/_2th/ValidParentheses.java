package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author Zealot
 * @date 2016年2月17日 上午10:02:55
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		boolean flag = false;
		while(s.length()!=0) {
			char[] ss = s.toCharArray();
			for(int i = 0; i < s.length() - 1;i++) {
				if(map.containsKey(ss[i])&&map.get(ss[i])==ss[i+1]){
					String last = "";
					if(i+2<s.length()){
						last = s.substring(i+2, s.length());
					}
					s = s.substring(0, i) + last;
					flag = true;
					break;
				}
			}
			if(flag ==false){
				return false;
			}
			flag = false;
		}
		return true;
	}
}
