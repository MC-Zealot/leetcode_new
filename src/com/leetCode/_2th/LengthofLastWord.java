package com.leetCode._2th;
/**
 *
 * @Description:
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
 * @author Zealot
 * @date 2016年2月16日 下午12:02:35
 *
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null){
			return 0;
		}
		String[] ss = s.trim().split(" ");

		return ss[ss.length-1].length();

	}
	public static void main(String[] args) {
		LengthofLastWord l = new LengthofLastWord();
		System.out.println(l.lengthOfLastWord(" "));
	}
}
