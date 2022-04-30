package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 *
 * @author Zealot
 * @date 2016年3月1日 下午8:56:33
 *
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length==0){
			return res;
		}
		Arrays.sort(candidates);
		dfs(0, candidates, target, res, new ArrayList<Integer>(),0);
		return res;
	}
	private void dfs(int cur,int[] candidates, int target,List<List<Integer>> res,List<Integer> tmp,int sum) {
		if(sum == target){
			res.add(new ArrayList<Integer>(tmp));
			return ;
		}
		for(int i = cur; i < candidates.length;i ++){
			if(sum + candidates[i] > target){
				break;
			}
			if(i>cur&&candidates[i-1]==candidates[i]){
				continue;
			}
			tmp.add(candidates[i]);
			dfs(i + 1, candidates, target, res, tmp, sum + candidates[i]);
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		int[] candidates = {1, 0, 1, 2,-1, -4};
		int target = 0;
		List<List<Integer>> res = c.combinationSum2(candidates, target);
		for(List<Integer> list: res){
			System.out.println(list.toString());
		}
	}
}
