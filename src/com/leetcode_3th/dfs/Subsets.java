package com.leetcode_3th.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],  
 * [1,2],   [] ]
 * 
 * @author Zealot
 * @date Jul 21, 2019 1:24:24 PM
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(0, nums, tmp, res);
		return res;
	}

	public void dfs(int curr, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
		if (tmp.size() <= nums.length) {
			res.add(new ArrayList<Integer>(tmp));
		}
		for (int i = curr; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(i+1, nums, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = {1,2,3};
		System.out.println(s.subsets(nums));
	}
}
