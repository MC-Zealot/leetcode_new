package com.leetcode_2th;
/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?
 * 
 * @author Zealot
 * @date 2016年4月21日 下午8:49:05 
 *
 */
public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int start = 0;
        for(int i = 0; i < s.length; i++) {
        	if(s[i]==' '){
        		reverse(s, start, i - 1);
        		start = i + 1;
        	}else if (i == s.length - 1){
        		reverse(s, start, i);
        	}
        }
    }
	public void reverse(char[] s, int start, int end){
		if(s.length==0){
			return;
		}
		while(start<end){
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		ReverseWordsinaStringII r = new ReverseWordsinaStringII();
		char[] cc = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		r.reverseWords(cc);
	}
}
