package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Zealot
 * @date 2016年2月18日 下午9:09:21
 *
 */
public class _3SumClosest {
	
	List<Integer> list = new ArrayList<Integer>();
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	int rightSum = 0;
	int minDiff = Integer.MAX_VALUE;
	/**
	 * 时间复杂度O(n!)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		dfs(0, nums, target);
		return rightSum;
	}
	private void dfs(int cur, int[] nums, int target) {
		if(map.size()==3){
			int s = 0;
			for(Integer i : map.keySet()){
				s+=map.get(i);
			}
			
			//判断是否相差最小
			int diff = Math.abs(s-target);
			if(diff < minDiff){
				minDiff = diff;
				rightSum = s;
			}
			
		}else{
			for(int i = cur; i < nums.length; i++) {
				if(map.containsKey(i)){
					continue;
				}
				map.put(i, nums[i]);
				dfs(cur+1,nums,target);
				map.remove(i);
			}
		}
	}
	/**
	 * O(n2)
	 * @param num
	 * @param target
	 * @return
	 */
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
		int[] nums = {-16,-2,17,-16,3,-7,-13,20,-4,12,5,13,-7,0,5,4,-17,-16,9,1,8,-6,0,-8,16,10,-6,9,-4,12,16,5,19,2,-9,-17,-8,-17,7,-10,2,20,-18,-20,-14,-6,6,17,-10,-8,18,-15,7,-9,13,13,-13,3,18,10,12,16,-6,-19,-6,-13,8,-5,16,5,8,-3,-9,-9,-5,14,14,-13,-18,13,15,-3,9,14,18,-14,-14,1,20,-4,-6,0,3,15,20,20,9,13,-8,-1,-2,6};
		System.out.println(s.threeSumClosest(nums, -58));
	}
}
