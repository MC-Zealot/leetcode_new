package com.leetcode_3th.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 * @author Zealot
 * @date Jul 19, 2019 10:51:20 AM
 *
 */
public class MaximumSubarray {
	int res = Integer.MIN_VALUE;

	public int maxSubArray(int[] nums) {
		if (nums.length <= 0) {
			return res;
		}
		int tmp = Integer.MIN_VALUE;

		dfs(0, tmp, nums);
		return res;
	}

	public void dfs(int curr, int sum, int[] nums) {
		if (curr == nums.length) {
			return;
		}

		res = Math.max(res, sum);// TODO 并且是连续，这个条件需要加上
		System.out.println(curr + ", " + res);
		for (int i = curr; i < nums.length; i++) {
			if (sum == Integer.MIN_VALUE) {
				sum = 0;
			}
			dfs(i, sum + nums[i], nums);
		}
	}

	/**
	 * 定义开始点和终止点，计算区间sum O(n^3)
	 * 
	 * @date Jul 19, 2019 11:38:53 AM
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		int res = Integer.MIN_VALUE;
		int sumSoFar = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				sumSoFar = 0;
				for (int q = i; q <= j; q++) {
					sumSoFar += nums[q];
				}
				res = Math.max(res, sumSoFar);
			}
		}
		return res;
	}

	/**
	 * O(n)遍历到第i时sum，保存到Map 定义开始和结尾，从Map获取sum，相间得到区间内的sum
	 * 
	 * time: O(n^2) 
	 * space:O(n)
	 * 
	 * @date Jul 19, 2019 11:45:37 AM
	 * @param nums
	 * @return
	 */
	public int maxSubArray3(int[] nums) {
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curSum = 0;
		map.put(-1, 0);
		for (int i = 0; i < nums.length; i++) {
			curSum = curSum + nums[i];
			map.put(i, curSum);
		}
		int s = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start; end < nums.length; end++) {
				s = map.get(end) - map.get(start - 1);
				max = max < s ? s : max;
			}
		}
		return max;
	}

	public int maxSubArray4(int[] nums) {
		int maxSoFar = nums[0], maxEnding = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
			maxEnding = Math.max(maxSoFar, maxEnding);
		}
		
		return maxEnding;
	}
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(m.maxSubArray4(nums));
	}
}
