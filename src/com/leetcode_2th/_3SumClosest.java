package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Zealot
 * @date 2016年6月22日 上午10:48:35 
 *
 */
public class _3SumClosest {
	/**
	 * TLE
	 * @date 2016年6月22日 上午11:44:05
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length==0){
			return 0;
		}
		List<Integer> res = new ArrayList<Integer>();//存放差值
		List<Integer> curList = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        dfs(nums, target, 0, res, curList);
        
        int min = Integer.MAX_VALUE;
        int resInt = 0;
        for(Integer i: res){
        	int diff = Math.abs(i - target);
        	if(diff < min){
        		min = diff;
        		resInt = i;
        	}
        }
		return resInt;
    }
	private void dfs(int[] nums, int target, int cur, List<Integer> res, List<Integer> curList) {
		if(curList.size() == 3){
			int sum = curList.get(0)+curList.get(1)+curList.get(2);
			res.add(sum);
			return ;
		}
		for(int i = cur; i < nums.length; i++) {
			curList.add(nums[i]);
			dfs(nums, target, i+1, res, curList);
			curList.remove(curList.size() - 1);
		}
	}
	
	public int threeSumClosest2(int[] num, int target) {
		if (num == null || num.length <= 2)
			return Integer.MIN_VALUE;
		Arrays.sort(num);
		int closest = num[0] + num[1] + num[2] - target;
		for (int i = 0; i < num.length - 2; i++) {
			int cur = twoSum(num, target - num[i], i + 1);
			if (Math.abs(cur) < Math.abs(closest))
				closest = cur;
		}
		return target + closest;
	}

	private int twoSum(int[] num, int target, int start) {
		int closest = num[start] + num[start + 1] - target;
		int l = start;
		int r = num.length - 1;
		while (l < r) {
			if (num[l] + num[r] == target)
				return 0;
			int diff = num[l] + num[r] - target;
			if (Math.abs(diff) < Math.abs(closest))
				closest = diff;
			if (num[l] + num[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return closest;
	}
	public static void main(String[] args) {
		_3SumClosest s = new _3SumClosest();
		int[] a = {-1, 2, 1, -4};
		System.out.println(s.threeSumClosest(a, 1));
	}
}
