package com.leetcode_2th;

import java.util.Stack;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月21日 上午11:23:56 
 *
 */
public class ReverseWordsinaString {
	/**
	 * runtime:O(N)
	 * SPACE:O(N)
	 * @date 2016年4月21日 下午7:51:22
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if(s==null){
			return s;
		}
		s = s.trim().replace("   ", " ").replace("  ", " ");
		String[] ss = s.split(" ");
		StringBuffer res = new StringBuffer();
		Stack<String> stack = new Stack<String>();
		for(int i= 0; i < ss.length; i++) {
			stack.push(ss[i]);
		}
		while(!stack.isEmpty()){
			res.append(stack.pop()).append(" ");
		}
		return res.substring(0, res.length()-1).toString();
    }
}
