package com.leetcode_3th.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 6:18:59 PM
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		int l = 0, r = 0;
//		char[] tmp = new char[2 * n];
		List<Integer> list1 = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list1.add(1);
			list1.add(2);
		}
		int[] flags = new int[n * 2];
		List<Character> tmp = new ArrayList<Character>();
		dfs(0,n, l, r, set, tmp, list1,flags);
		
		for(String str: set) {
			res.add(str);
		}
		return res;
	}

	/**
	 * 超时
	 * @date Jul 24, 2019 7:09:58 PM
	 * @param curr
	 * @param n
	 * @param l
	 * @param r
	 * @param set
	 * @param tmp
	 * @param list1
	 * @param flags
	 */
	public void dfs(int curr, int n, int l, int r, Set<String> set, List<Character> tmp, List<Integer> list1,int[] flags) {
//		System.out.println(String.valueOf(tmp));
		if (l < r) {
			return;
		}
		if (n * 2 == l + r) {
			StringBuilder sb = new StringBuilder(); 
	        // Appends characters one by one 
	        for (Character ch : tmp) { 
	            sb.append(ch); 
	        } 
	        set.add(sb.toString());
			return;
		}
		for(int i = 0;i < list1.size(); i++) {
			if(flags[i]==1) {
				continue;
			}
			if(list1.get(i)==1) {
				l++;
				tmp.add('(') ;
				flags[i] = 1;
				dfs(i+1, n, l, r, set, tmp, list1,flags);
				flags[i] = 0;
				l--;
				tmp.remove(tmp.size()-1);
			}else {
				r++;
				tmp.add(')') ;
				flags[i] = 1;
				dfs(i+1, n, l, r, set, tmp, list1,flags);
				flags[i] = 0;
				r--;
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	public ArrayList<String> generateParenthesis2(int n) {
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
	
	public List<String> generateParenthesis3(int n) {
		List<String> res = new ArrayList<String>();
		if(n == 0){
			return res;
		}
		dfs(n, new String(), res, 0, 0);
		return res;
	}
	/**
	 * 递归
	 * @date Aug 13, 2019 11:00:21 AM
	 * @param n
	 * @param tmp
	 * @param res
	 * @param l
	 * @param r
	 */
	public void dfs(int n, String tmp, List<String> res, int l, int r) {

		if (l < r) {
			return;
		}
		if (tmp.length() == 2 * n) {
			res.add(tmp);
			return;
		}

		if (l < n) {
			dfs(n, tmp + "(", res, l + 1, r);
		}
		if (r < n) {
			dfs(n, tmp + ")", res, l, r + 1);
		}
	}


	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis3(3));
	}
}
