package com.leetCode._2th;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
 * 
 * @author Zealot
 * @date 2016年3月22日 下午9:19:47 
 *
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s==null||s.length()==0||"".equals(s.trim())){
			return s.trim();
		}
		String[] ss = s.trim().replace("   "," ").replace("  "," ").split(" ");
		Stack<String> stack = new Stack<String>();
		for(String str: ss){
			stack.push(str);
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()){
			sb.append(stack.pop()).append(" ");
		}
		
		return sb.toString().substring(0, sb.length()-1);
    }
	public static void main(String[] args) {
//		ReverseWordsinaString r = new ReverseWordsinaString();
//		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(" blue blue  ".trim());
	}
}
