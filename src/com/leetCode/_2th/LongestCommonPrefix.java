package com.leetCode._2th;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @author Zealot
 * @date 2016年2月27日 下午9:16:00
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0){
			return "";
		}

		String res = strs[0];
		for(int i = 1; i < strs.length; i++){
			String s = strs[i];
			int size = 0;
			if(s.length()>res.length()){
				size = res.length();
			}else{
				size = s.length();
				res = res.substring(0, size);
			}
			for(int j = 0; j < size; j ++){
				char c = s.charAt(j);
				if(c!=res.charAt(j)){
					res = res.substring(0, j);
					break;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] a = {"flower","flow","flight"};
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(a));

	}
}
