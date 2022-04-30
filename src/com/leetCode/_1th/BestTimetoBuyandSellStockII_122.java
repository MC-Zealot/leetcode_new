package com.leetCode._1th;

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
 *
 */
public class BestTimetoBuyandSellStockII_122 {

    public int maxProfit(int[] prices) {
    	int max = 0;
    	for(int i =1; i < prices.length; i++) {
    		if(prices[i] >prices[i-1]){
    			max += (prices[i]-prices[i-1]);
    		}
    	}
    	
        return max;
    }
    public static void main(String[] args) {
		int[] prices = {1};
		BestTimetoBuyandSellStockII_122 b = new BestTimetoBuyandSellStockII_122();
		System.out.println(b.maxProfit(prices));
	}
}
