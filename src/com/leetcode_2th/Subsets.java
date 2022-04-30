package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * 
 * @author Zealot
 * @date 2016年6月28日 下午12:37:28 
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0){
			return res;
		}
		Arrays.sort(nums);
		dfs(nums, 0, res, new ArrayList<Integer>());
		
		return res;
    }
	private void dfs(int[] nums, int cur, List<List<Integer>> res, List<Integer> tmp) {
		res.add(new ArrayList<Integer>(tmp));
		for(int i = cur; i < nums.length; i++) {
			if(i > cur && nums[i]==nums[i - 1]){
				continue;
			}
			
			tmp.add(nums[i]);
			dfs(nums, i + 1, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] a = {1,2,3};
		List<List<Integer>> res = s.subsets(a);
		for(List<Integer> list: res){
			System.out.println(list.toString());
		}
	}
}
