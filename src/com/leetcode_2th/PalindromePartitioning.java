package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月19日 下午9:32:39 
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
	public static void main(String[] args) {
		String s= "aab";
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> list = p.partition(s);
	}
}
