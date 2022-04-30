package com.leetcode_3th.dp;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例 1:

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
注意:

数组的长度不会超过20，并且数组中的值全为正数。
初始的数组的和不会超过1000。
保证返回的最终结果为32位整数。

 * 
 * @author Zealot
 * @date Jul 31, 2019 10:39:04 AM 
 *
 */
public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return 0;
		int res[] = new int[1];
		dfsCore(nums, 0, 0, 0, S, res);
		return res[0];
	}
	private void dfsCore(int[] nums, int sum, int idx, int k, 
			int target, int[] res) {
		if (k == nums.length) {
			if (sum == target)
				res[0] += 1;
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			dfsCore(nums, sum + nums[i], i + 1, k + 1, target, res);
			dfsCore(nums, sum - nums[i], i + 1, k + 1, target, res);
		}
	}
	
	public int findTargetSumWays2(int[] nums, int S) {
		int[] arr = new int[1];
		helper(nums, S, arr, 0, 0);
		return arr[0];
	}

	public void helper(int[] nums, int S, int[] arr, int sum, int start) {
		if (start == nums.length) {
			if (sum == S) {
				arr[0]++;
			}
			return;
		}
		// 这里千万不要加for循环，因为我们只是从index0开始
		helper(nums, S, arr, sum - nums[start], start + 1);
		helper(nums, S, arr, sum + nums[start], start + 1);

	}
}
