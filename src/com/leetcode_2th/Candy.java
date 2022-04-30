package com.leetcode_2th;
/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 * 
 * @author Zealot
 * @date 2016年7月4日 上午10:12:49 
 *
 */
public class Candy {
	/**
	 * dp
	 * O(N)
	 * @date 2016年7月4日 上午10:31:10
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] nums = new int[ratings.length];
		nums[0] = 1;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			} else {
				nums[i] = 1;
			}
		}
		int res = nums[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = nums[i + 1] + 1;
			}
			res += Math.max(cur, nums[i]);
			nums[i] = cur;
		}
		return res;
	}  
}
