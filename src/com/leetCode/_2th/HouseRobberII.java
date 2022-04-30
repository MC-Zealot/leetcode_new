package com.leetCode._2th;

/**
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * House Robber I的升级版. 因为第一个element 和最后一个element不能同时出现. 则分两次call House Robber I. case 1: 不包括最后一个element. case 2: 不包括第一个element.
 两者的最大值即为全局最大值
 * @Description:
 * @author Zealot
 * @date 2016年2月12日 上午11:57:35
 *
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0], nums[1]);
		return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1, nums.length-1));
	}

	private int robsub(int[] nums, int s, int e) {
		int n = e - s + 1;
		int[] d =new int[n];
		d[0] = nums[s];
		d[1] = Math.max(nums[s], nums[s+1]);

		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-2]+nums[s+i], d[i-1]);
		}
		return d[n-1];
	}
}
