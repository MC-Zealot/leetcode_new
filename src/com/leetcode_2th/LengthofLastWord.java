package com.leetcode_2th;
/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 *  return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * @author Zealot
 * @date 2016年6月23日 上午10:16:12 
 *
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null){
			return 0;
		}
		String[] ss = s.split(" ");
		if(ss.length>0){
			return ss[ss.length - 1].length();
		}
		return 0;
	}

	public int lengthOfLastWord2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int idx = s.length() - 1;
		while (idx >= 0 && s.charAt(idx) == ' ') {
			idx--;
		}
		int idx2 = idx;
		while (idx2 >= 0 && s.charAt(idx2) != ' ') {
			idx2--;
		}
		return idx - idx2;
	} 
	public static void main(String[] args) {
		LengthofLastWord l = new LengthofLastWord();
		System.out.println(l.lengthOfLastWord("Hello Wor12ld"));
	}
}
