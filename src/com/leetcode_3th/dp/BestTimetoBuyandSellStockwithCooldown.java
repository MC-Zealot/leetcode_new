package com.leetcode_3th.dp;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 * 
 * @author Zealot
 * @date Jul 30, 2019 9:06:49 PM 
 *
 */
public class BestTimetoBuyandSellStockwithCooldown {
	/**
	 * 这题比Best Time to Buy and Sell Stock II多了一个cooldown的条件，就变得麻烦多了。这题是一个多阶段优化问题，首先范围缩小到广搜，贪心或者动规。因为每步之间互相牵连，贪心显然不行。广搜固然可以，不过是O(2^n)复杂度，所以我们先考虑用动规。

对于每一天，有三种动作，buy, sell, cooldown, sell 和 cooldown 可以合并成一种状态，因为手里最终没有股票。最终需要的结果是 sell，即手里股票卖了获得最大利润。我们可以用两个数组来记录当前持股和未持股的状态，令sell[i] 表示第i天未持股时，获得的最大利润，buy[i]表示第i天持有股票时，获得的最大利润。

对于sell[i]，最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是今天卖了股票，所以状态转移方程如下：

sell[i] = max{sell[i - 1], buy[i-1] + prices[i]}

对于buy[i]，最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天卖了股票，今天买了股票，因为 cooldown 只能隔天交易，所以今天买股票要追溯到前天的状态。状态转移方程如下：

buy[i] = max{buy[i-1], sell[i-2] - prices[i]}

最终我们要求的结果是sell[n - 1]，表示最后一天结束时，手里没有股票时的最大利润。

这个算法的空间复杂度是O(n)，不过由于sell[i]仅仅依赖前一项，buy[i]仅仅依赖前两项，所以可以优化到O(1)，具体见第二种代码实现。
	 * @date Jul 30, 2019 10:07:19 PM
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,0,2};
		BestTimetoBuyandSellStockwithCooldown b = new BestTimetoBuyandSellStockwithCooldown();
		System.out.println(b.maxProfit(nums));
	}
}
