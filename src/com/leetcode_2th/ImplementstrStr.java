package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月20日 下午5:14:29 
 *
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if(haystack.length()<needle.length()){
			return -1;
		}
		for(int i = 0;i < haystack.length() - needle.length() + 1; i++) {
			int index = 0;
			for(int j = i, k = 0; j < haystack.length() && k < needle.length(); j++, k++){
				if(haystack.charAt(j)!=needle.charAt(k)){
					break;
				}
				index++;
			}
			if(index==needle.length()){
				return i;
			}
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length()){
					return i;
				}
				if (i + j == haystack.length()){
					return -1;
				}
				if (needle.charAt(j) != haystack.charAt(i + j)){
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		ImplementstrStr i = new ImplementstrStr();
//		System.out.println(i.strStr("1", "-1"));
		double a = 0.539959;
		System.out.println(a);
		System.out.println(a);
	}
}
