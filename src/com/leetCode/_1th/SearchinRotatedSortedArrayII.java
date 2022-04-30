package com.leetCode._1th;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author Zealot
 * @date 2015年9月4日 下午10:11:08
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if(nums.length==0){
			return false;
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==target){
				return true;
			}
		}
		return false;
	}
}
