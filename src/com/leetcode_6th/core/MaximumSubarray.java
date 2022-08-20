package com.leetcode_6th.core;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
