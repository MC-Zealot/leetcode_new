package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * 
 * Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * 
 * @author Zealot
 * @date 2016年6月22日 下午4:46:33 
 *
 */
public class _4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0){
			return res;
		}
		List<Integer> curList = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        dfs(nums, target, 0, res, curList, 0);
		
		
		return res;
    }
	private void dfs(int[] nums, int target, int cur, List<List<Integer>> res, List<Integer> curList, int sum) {
		if(curList.size() == 4){
			if(sum==target){
				res.add(new ArrayList<Integer>(curList));
			}
			return ;
		}
		for(int i = cur; i < nums.length; i++) {
			if(i > cur && nums[i-1] == nums[i]){
				continue;
			}
			curList.add(nums[i]);
				
			dfs(nums, target, i+1, res, curList, sum + nums[i]);
			curList.remove(curList.size() - 1);
		}
	}
	public List<List<Integer>> fourSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		for (int i = num.length - 1; i > 2; i--) {
			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<ArrayList<Integer>> curRes = threeSum(num, i - 1,
						target - num[i]);
				for (int j = 0; j < curRes.size(); j++) {
					curRes.get(j).add(num[i]);
				}
				res.addAll(curRes);
			}
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> threeSum(int[] num, int end,
			int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = end; i > 1; i--) {
			if (i == end || num[i] != num[i + 1]) {
				ArrayList<ArrayList<Integer>> curRes = twoSum(num, i - 1,
						target - num[i]);
				for (int j = 0; j < curRes.size(); j++) {
					curRes.get(j).add(num[i]);
				}
				res.addAll(curRes);
			}
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int l = 0;
		int r = end;
		while (l < r) {
			if (num[l] + num[r] == target) {
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);
				item.add(num[r]);
				res.add(item);
				l++;
				r--;
				while (l < r && num[l] == num[l - 1])
					l++;
				while (l < r && num[r] == num[r + 1])
					r--;
			} else if (num[l] + num[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		_4Sum s = new _4Sum();
		int[] a = {1, 0, -1, 0, -2, 2};
		 List<List<Integer>> res = s.fourSum(a, 0);
		 for(List<Integer> list: res){
			 System.out.println(list);
		 }
	}
}
