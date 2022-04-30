package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. if there isn't one, return 0 instead.
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest) 
 * 
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * @author Zealot
 * @date 2016年4月1日 下午4:15:15 
 *
 */
public class MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, k, 0, new ArrayList<Integer>(), 0, list);
		if (list.size() > 0) {
			Collections.sort(list);
			return list.get(list.size() - 1);
		}
		return 0;
	}

	private void dfs(int[] nums, int k, int cur, List<Integer> tmp, int sum, List<Integer> list) {
		if (sum == k) {
			list.add(tmp.size());
		}
		for (int i = cur; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(nums, k, cur + 1, tmp, sum + nums[i], list);
			tmp.remove(tmp.size() - 1);
		}
	}
	public int maxSubArrayLen2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int size = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
			if(map.containsKey(sum - k)){
				size = size < (i - map.get(sum - k) )? (i - map.get(sum - k)) : size;
			}
			if(k == sum) {
				size = i + 1;
			}
			
		}
		return size;
	}

	public static void main(String[] args) {
//		int[] a = { 1, -1, 5, -2, 3 };
//		 int[] a = {-2, -1, 2, 1};
		 int[] a = {1,1,1,1,1,1};
		MaximumSizeSubarraySumEqualsk m = new MaximumSizeSubarraySumEqualsk();
		System.out.println(m.maxSubArrayLen2(a, 1));
	}
}
