package com.leetCode._1th;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author Zealot
 * @date 2015年8月12日 下午9:44:39
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length==0||prices.length==1){
			return 0;
		}
		int[] a=new int[prices.length-1];
		for(int i = 0; i < prices.length-1; i++) {
			a[i]=prices[i+1]-prices[i];
		}
		int reVal = maxSubArray3(a);
		
		return reVal<0?0:reVal;
	}
	public int maxSubArray3(int[] nums) {
		int reVal = Integer.MIN_VALUE;
		int tmp = 0;
		for(int i = 0; i < nums.length; i++) {
			if(tmp<0){
				tmp = nums[i];
			}else{
				tmp += nums[i];
			}
				
			if(tmp>reVal){
				reVal=tmp;
			}
		}
		return reVal;
	}
	public static void main(String[] args) {
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] nums = {-2,-2,-1,2};
		System.out.println(b.maxSubArray3(nums));
	}
}
