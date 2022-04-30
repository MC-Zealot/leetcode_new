package com.leetcode_2th;
/**
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * 
 * @author Zealot
 * @date 2016年6月17日 上午10:14:33 
 *
 */
public class ReverseString {
	public String reverseString(String s) {
        if(s==null){
            return null;
        }
        int l = 0, r = s.length() - 1;
        char[] cc = s.toCharArray();
        while(l < r){
        	char tmp = cc[l];
        	cc[l] = cc[r];
        	cc[r] = tmp;
        	l++;
        	r--;
        }
        return new String(cc);
    }
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		System.out.println(r.reverseString("hello"));
	}
}
