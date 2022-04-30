package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月20日 下午5:24:05 
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
		int i = 0, j = s.length() - 1;
		s = s.toLowerCase();
		while(i < j){
			while(i <s.length()&&!((s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 25)||(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9))){
				i++;
			}
			while(j >=0 &&!((s.charAt(j) - 'a' >= 0 && s.charAt(j) - 'a' <= 25)||(s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9))){
				j--;
			}
			if(i < j&&s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
    }
	public boolean isPalindrome2(String s) {
		   int i = 0, j = s.length() - 1;
		   while (i < j) {
		      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
		      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
		      if (Character.toLowerCase(s.charAt(i))
		            != Character.toLowerCase(s.charAt(j))) {
		         return false;
		}
		i++; j--; }
		   return true;
		}
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
