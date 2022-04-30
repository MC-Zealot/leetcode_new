package com.leetcode_3th.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润
 * = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 示例 2: 输入: [7,6,4,3,1] 输出: 0 解释:
 * 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 * @author Zealot
 * @date Jul 21, 2019 4:44:51 PM
 *
 */
public class BestTimetoBuyandSellStock {
	/**
	 * O(n^2)
	 * 
	 * @date Jul 21, 2019 4:47:39 PM
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				res = Math.max(prices[j] - prices[i], res);
			}
		}
		return res;
	}

	/**
	 * dp 从每天的股价转换成每天的涨幅 然后计算最长子序列
	 * O(n)
	 * @date Jul 21, 2019 5:14:42 PM
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		if(prices.length<=1) {
			return 0;
		}
		int[] nums = new int[prices.length];
		nums[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			nums[i] = prices[i] - prices[i - 1];
		}
		return maxSubArray(nums);
	}

	public int maxSubArray(int[] nums) {
		int res = nums[0];
		int maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSoFar = Math.max(nums[i] + maxSoFar, nums[i]);
			res = Math.max(res, maxSoFar);
		}
		return res;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		int[] prices = { 7, 6, 4, 3, 1 };
		System.out.println(b.maxProfit(prices));
	}
}
