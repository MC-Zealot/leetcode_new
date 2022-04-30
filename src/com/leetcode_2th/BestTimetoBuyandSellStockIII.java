package com.leetcode_2th;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author Zealot
 * @date 2016年7月5日 上午11:17:34 
 *
 */
public class BestTimetoBuyandSellStockIII {
	/**
	 * runtime complexity: O(n^2)
	 * TLE
	 * @date 2016年7月5日 下午2:23:21
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices.length<=1){
			return 0;
		}
		int[] nums = new int[prices.length];
		nums[0] = 0;
		for(int i = 1; i < nums.length; i++) {
			nums[i] = prices[i] - prices[i - 1]; 
		}
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			int pre = maxSubArray(nums, 0, i);
			int post = maxSubArray(nums, i, nums.length);
			res = Math.max(pre + post, res);
		}
		return res;
    }
	private int maxSubArray(int[] nums, int start, int end) {
		int globe = nums[start];
		int local = nums[start];
		for(int i = start + 1; i < end; i++) {
			local = Math.max(local + nums[i], nums[i]);
			globe = Math.max(local, globe);
		}
		return globe;
	}
	/**
	 *	// 基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值 
	 * @date 2016年7月5日 下午3:08:06
	 * @param prices
	 * @return
	 */
    public int maxProfit2(int[] prices) {  
        if(prices.length == 0){  
            return 0;  
        }  
          
        int max = 0;  
        // dp数组保存左边和右边的利润最大值  
        int[] left = new int[prices.length];        // 计算[0,i]区间的最大值  
        int[] right = new int[prices.length];   // 计算[i,len-1]区间的最大值  
          
        process(prices, left, right);  
          
        // O(n)找到最大值  
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
          
        return max;  
    }  
      
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0];        // 最低买入价  
          
        // 左边递推公式  
        for(int i=1; i<left.length; i++){  
            left[i] = Math.max(left[i-1], prices[i]-min);   // i的最大利润为（i-1的利润）和（当前卖出价和之前买入价之差）的较大那个  
            min = Math.min(min, prices[i]);     // 更新最小买入价  
        }  
          
        right[right.length-1] = 0;  
        int max = prices[right.length-1];       // 最高卖出价  
        // 右边递推公式  
        for(int i=right.length-2; i>=0; i--){  
            right[i] = Math.max(right[i+1], max-prices[i]); // i的最大利润为（i+1的利润）和（最高卖出价和当前买入价之差）的较大那个  
            max = Math.max(max, prices[i]);     // 更新最高卖出价  
        }  
          
    }  
}
