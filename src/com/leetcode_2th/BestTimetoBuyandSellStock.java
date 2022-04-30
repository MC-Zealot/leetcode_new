package com.leetcode_2th;
/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 

design an algorithm to find the maximum profit.
 * @author Zealot
 * @date 2016年6月4日 下午4:50:39 
 *
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length<=1){
			return 0;
		}
		int[] nums = new int[prices.length];
		nums[0] = 0;
		for(int i = 1; i < nums.length; i++) {
			nums[i] = prices[i] - prices[i - 1]; 
		}
		return maxSubArray2(nums);
    }
	public int maxSubArray2(int[] nums) {
		int maxEndingHere = nums[0], maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
}
