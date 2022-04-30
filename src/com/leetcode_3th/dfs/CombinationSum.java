package com.leetcode_3th.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 * 
 * @author Zealot
 * @date Jul 18, 2019 10:29:00 AM 
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length==0) {
			return res;
		}
		Arrays.sort(candidates);
		int[] flags = new int[candidates.length];
		dfs(0,candidates, flags, res, new ArrayList<Integer>(), target,0);
		return res;
    }
	public void dfs(int curr, int[] nums, int[] flags, List<List<Integer>> res, List<Integer> tmp, int target,int sum_tmp) {
		if(sum_tmp==target) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}else if(sum_tmp>target) {
			return;
		}
		for(int i = curr; i < nums.length; i++) {
			tmp.add(nums[i]);
			flags[i]=1;
			sum_tmp+=nums[i];
			dfs(i,nums, flags, res, tmp, target,sum_tmp);
			sum_tmp-=nums[i];
			flags[i]=0;
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums= {2,3,6,7};
		int target=7;
		System.out.println(cs.combinationSum(nums, target));
	}
}
