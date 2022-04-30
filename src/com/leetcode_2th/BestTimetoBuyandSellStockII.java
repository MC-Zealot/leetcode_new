package com.leetcode_2th;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author Zealot
 * @date 2016年6月8日 上午11:38:39
 *
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		
		if(prices.length<=1){
			return 0;
		}
		int size = prices.length - 1;
		int max = 0;
		for(int i = 0; i < size; i++)  {
			if(prices[i+1]>prices[i]){
				max +=(prices[i+1] - prices[i]);
			}
		}
		
		return max;
    }
}
