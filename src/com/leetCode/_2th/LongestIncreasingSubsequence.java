package com.leetCode._2th;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n^2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author Zealot
 * @date 2016年1月10日 下午3:17:15
 */
public class LongestIncreasingSubsequence {
	/**
	 * 时间复杂度:O(n^2): 我们依次遍历整个序列，每一次求出从第一个数到当前这个数的最长上升子序列，直至遍历到最后一个数字为止，
	 * 然后再取dp数组里最大的那个即为整个序列的最长上升子序列
	 * 。我们用dp[i]来存放序列1~i的最长上升子序列的长度，那么dp[i]=max(dp[j] + 1, dp[i]),(j∈[1, i-1]);
	 * 显然dp[1]=1,我们从i=2开始遍历后面的元素即可。
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int N = nums.length;
		if (N == 0)
			return 0;
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
