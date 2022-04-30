package com.leetcode_2th;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

global[i][j]:当前到达第i天最多可以进行j次交易，所得到的最大利润。 
local[i][j]:当前到达第i天最多可以进行j次交易，而且最后一次交易在当天卖出，所得到的最大利润。 
状态转移方程： 
global[i][j] = max(local[i][j], global[i-1][j]) 
上述方程比较两个量的大小：①当前局部最大值；②过往全局最大值。 
local[i][j] = max(global[i-1][j-1] + max(diff, 0), local[i-1][j] + diff) 
上述方程比较两个量的大小： 
①全局到i-1天进行j-1次交易，然后加上今天的交易（如果今天的交易赚钱的话）。 
②取局部第i-1天进行j次交易，然后加上今天的差值（local[i-1][j]是第i-1天卖出的交易，它加上diff后变成第i天卖出，并不会增加交易次数。无论diff是正还是负都要加上，否则就不满足local[i][j]必须在最后一天卖出的条件了）

另外需要注意的一个问题是，当k远大于数组的大小时，上述算法将变得低效。因此将其改用不限交易次数的方式解决。
 * 
 * @author Zealot
 * @date 2016年7月7日 上午11:35:26 
 *
 */
public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (len == 0) {
			return 0;
		}
		if (k >= len) {
			return helper(prices);
		}

		int[] max_local = new int[k + 1];
		int[] max_global = new int[k + 1];
		int diff;
		for (int i = 0; i < len - 1; i++) {
			diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; j--) {
				max_local[j] = Math.max(max_global[j - 1] + Math.max(diff, 0), max_local[j] + diff);
				max_global[j] = Math.max(max_local[j], max_global[j]);
			}
		}

		return max_global[k];
	}

	private int helper(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			profit = Math.max(profit, profit + prices[i + 1] - prices[i]);
		}

		return profit;
	}
}
