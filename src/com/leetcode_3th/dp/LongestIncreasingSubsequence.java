package com.leetcode_3th.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 * 
 * @author Zealot
 * @date Jul 30, 2019 8:29:58 PM
 *
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int N = nums.length;
		if (N == 0) {
			return 0;
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
