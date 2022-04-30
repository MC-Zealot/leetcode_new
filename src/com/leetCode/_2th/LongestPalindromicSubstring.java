package com.leetCode._2th;

/**
 *
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 *
 * @author Zealot
 * @date 2016年2月24日 下午1:52:46
 *
 */
public class LongestPalindromicSubstring {
	/**
	 * O(n^3)
	 * 暴力破解：start,end两层循环，遍历所有的子串，判断这些子串是否是回文
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if(s==null){
			return null;
		}
		String reVal = s.charAt(0)+"";

		for(int i = 1; i < s.length() - 1; i++) {
			String mid = ""+s.charAt(i);
			String tmp = mid;
			for(int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--,k++) {
				tmp = s.charAt(j) + tmp + s.charAt(k);
				if(isPalindrome(tmp)){
					if( tmp.length() > reVal.length()){
						reVal = tmp;
					}
				}else{
					tmp.substring(1, tmp.length() - 1);
				}
			}
			mid = ""+s.charAt(i)+ s.charAt(i+1);
			tmp = mid;
			for(int j = i - 1, k = i + 2; j >= 0 && k < s.length(); j--,k++) {
				tmp = s.charAt(j) + tmp + s.charAt(k);
				if(isPalindrome(tmp)){
					if( tmp.length() > reVal.length()){
						reVal = tmp;
					}
				}else{
					tmp.substring(1, tmp.length() - 1);
				}
			}

		}

		return reVal;
	}
	/**
	 * O(n^2)
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		if(s==null){
			return null;
		}
		String reVal = s.charAt(0)+"";

		for(int i = 1; i < s.length() - 1; i++) {
			if(reVal.length() == s.length()){
				break;
			}
			String mid = ""+s.charAt(i);
			String tmp = mid;
			for(int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--,k++) {
				if(s.charAt(j)==s.charAt(k)){
					tmp = s.charAt(j) + tmp + s.charAt(k);
					if( tmp.length() > reVal.length()){
						reVal = tmp;
					}
				}
			}
			if(s.charAt(i)!=s.charAt(i+1)){
				continue;
			}
			mid = ""+s.charAt(i)+ s.charAt(i+1);
			tmp = mid;
			for(int j = i - 1, k = i + 2; j >= 0 && k < s.length(); j--,k++) {
				if(s.charAt(j)==s.charAt(k)){
					tmp = s.charAt(j) + tmp + s.charAt(k);
					if( tmp.length() > reVal.length()){
						reVal = tmp;
					}
				}
			}

		}

		return reVal;
	}
	/**
	 * O(n^2)
	 * 使用下标
	 * @param s
	 * @return
	 */
	public String longestPalindrome3(String s) {
		if(s==null){
			return null;
		}
		if(s.length()==2){
			if(s.charAt(0)==s.charAt(1)){
				return s;
			}else{
				return String.valueOf(s.charAt(0));
			}
		}
		int end = 0;
		int start = 0;
		int size = 0;
		for(int i = 0; i < s.length() - 1; i++) {
			for(int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--,k++) {
				if(s.charAt(j)!=s.charAt(k)){
					break;
				}
				if((k - j + 1> size)){
					end = k;
					start = j;
					size = k - j + 1;
				}
			}
			if(s.charAt(i)!=s.charAt(i+1)){
				continue;
			}
			for(int j = i, k = i + 1; j >= 0 && k < s.length(); j--,k++) {
				if(s.charAt(j)!=s.charAt(k)){
					break;
				}
				if((k - j + 1 > size)){
					end = k;
					start = j ;
					size = k - j + 1;
				}
			}

		}

		return s.substring(start, end+1);
	}
	private static boolean isPalindrome(String str) {
		for(int i = 0,j=str.length()-1;i < j; i++,j--){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome3("abb"));
//		char a = 'a';
//		char b = 'b';
//		if(a==b)
//		    System.out.println("a==b");
//		else
//		    System.out.println("a is not  equal b");
	}
}
