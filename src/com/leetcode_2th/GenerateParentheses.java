package com.leetcode_2th;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * 所有的前缀字串皆满足X的个数大于等于Y的个数
 * 
 * @author Zealot
 * @date 2016年6月13日 上午11:00:23
 *
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (n <= 0)
			return res;
		helper(n, n, new String(), res);
		return res;
	}

	private void helper(int l, int r, String item, ArrayList<String> res) {
		if (r < l)
			return;
		if (l == 0 && r == 0) {
			res.add(item);
		}
		if (l > 0)
			helper(l - 1, r, item + "(", res);
		if (r > 0)
			helper(l, r - 1, item + ")", res);
	}
}
