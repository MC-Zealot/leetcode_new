package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * 
 * @author Zealot
 * @date 2016年7月8日 下午9:38:22 
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(n, k, res, new ArrayList<Integer>(), 1);
		return res;
    }
	private void dfs(int n, int k, List<List<Integer>> res, List<Integer> tmp, int cur) {
		if(tmp.size()==k){
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i = cur; i <= n; i++) {
			tmp.add(i);
			dfs(n, k, res, tmp, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void main(String[] args) {
		Combinations c = new Combinations();
		List<List<Integer>> res = c.combine(4, 2);
		for(List<Integer> l : res){
			System.out.println(l.toString());
		}
	}
}
