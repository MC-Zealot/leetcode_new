package com.leetcode_2th;


/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月3日 下午12:15:42 
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0){
			return "";
		}
		String res = strs[0];
		for(int i = 1; i < strs.length; i++){
			String tmp  = strs[i];
			int j = 0;
			for(; j < tmp.length() && j < res.length(); j++) {
				if(tmp.charAt(j)!=res.charAt(j)){
					break;
				}
			}
			if(j != res.length()){
				res = res.substring(0, j);
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs = {""};
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
		
		
		
	}
}
