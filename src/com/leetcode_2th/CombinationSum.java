package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 * @author Zealot
 * @date 2016年6月28日 下午12:46:16 
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length==0){
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, 0, res, new ArrayList<Integer>(), 0, target);
		
		return res;
    }
	private void dfs(int[] candidates, int cur, List<List<Integer>> res, List<Integer> tmp, int sum, int target) {
		if(sum==target){
			res.add(new ArrayList<Integer>(tmp));
		}else if(target > sum){
			for(int i = cur; i < candidates.length; i++) {
				tmp.add(candidates[i]);
				dfs(candidates, i, res, tmp, sum + candidates[i], target);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] a = {2, 3, 6, 7};
		List<List<Integer>> res = c.combinationSum(a, 7);
		for(List<Integer> list: res){
			System.out.println(list.toString());
		}
	}
}
