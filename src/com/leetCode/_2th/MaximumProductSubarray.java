package com.leetCode._2th;
/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author Zealot
 * @date 2016年3月22日 下午11:16:16 
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0){
			return 0;
		}
		if (nums.length == 1){
			return nums[0];
		}
		int max_local = nums[0];
		int min_local = nums[0];
		int global = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int max_copy = max_local;
			max_local = Math.max(Math.max(nums[i] * max_local, nums[i]), nums[i] * min_local);
			min_local = Math.min(Math.min(nums[i] * max_copy, nums[i]), nums[i] * min_local);
			global = Math.max(global, max_local);
		}
		return global;
	}  
}
