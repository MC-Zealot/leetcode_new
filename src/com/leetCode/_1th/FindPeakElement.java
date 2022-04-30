package com.leetCode._1th;
/**
 * 
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
 * @author Zealot
 * @date 2015年8月22日 下午9:35:56
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums==null||nums.length==1){
			return 0;
		}
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i]>nums[i+1]) {
				return i;
			}
		}
		return nums.length-1;
	}
}
