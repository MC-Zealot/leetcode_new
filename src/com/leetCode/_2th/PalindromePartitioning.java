package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 *
 * @author Zealot
 * @date 2016年2月23日 下午10:56:27
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<List<String>>();
		if(s==null || s.length()==0)
			return res;
		helper(s, getDict(s),0,new ArrayList<String>(), res);
		return res;
	}

	private void helper(String s, boolean[][] dict, int start, ArrayList<String> item, List<List<String>> res) {
		if (start == s.length()) {
			res.add(new ArrayList<String>(item));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (dict[start][i]) {
				item.add(s.substring(start, i + 1));
				helper(s, dict, i + 1, item, res);
				item.remove(item.size() - 1);
			}
		}
	}
	private boolean[][] getDict(String s) {
		boolean[][] dict = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dict[i + 1][j - 1])) {
					dict[i][j] = true;
				}
			}
		}
		return dict;
	}
	private static boolean isPalindrome(String str) {
		for(int i = 0,j=str.length()-1;i < j; i++,j--){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
		}
		return true;
	}
}
