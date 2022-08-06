package com.leetcode_6th;

public class BestTimetoBuyandSellStock{
    public int maxProfit(int[] prices) {
        int[] nums = new int[prices.length];
        nums[0]=0;
        for(int i = 1; i < prices.length; i++){
            nums[i] = prices[i] - prices[i - 1];
        }
        return maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int ret = 0;
        int local_max = nums[0];
        for(int i = 0; i < nums.length; i++){
            local_max = Math.max(local_max + nums[i], nums[i]);
            ret = Math.max(local_max, ret);
        }

        return ret;
    }
}
