package com.leetcode_3th.dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 * 
 * @author Zealot
 * @date Jul 21, 2019 5:48:59 PM 
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		
		int max = nums[0], min = nums[0], maxAns = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int mx = max, mn = min;
			max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
			min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
    }
	
	public static void main(String[] args) {
		MaximumProductSubarray  m = new MaximumProductSubarray();
		int[] nums = {2,-5,-2,-4,3};
		System.out.println(m.maxProduct(nums));
	}
}
