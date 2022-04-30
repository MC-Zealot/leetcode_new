package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author Zealot
 * @date 2016年1月10日 上午11:44:00
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(re, 1, 0, k, n, tmp);
		return re;
	}

	private void dfs(List<List<Integer>> re, int cur, int sum, int k, int n,
			List<Integer> tmp) {
		if (sum > n || tmp.size() > k) {
			return;
		}
		if (tmp.size() == k && sum == n) {
			re.add(new ArrayList<Integer>(tmp));
		} else {
			for (int i = cur; i <= 9; i++) {
				tmp.add(i);
				dfs(re, i + 1, sum + i, k, n, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		List<List<Integer>> re = cs.combinationSum3(3, 9);
		for(List<Integer> list: re) {
			System.out.println(list.toString());
		}
	}
	
}
