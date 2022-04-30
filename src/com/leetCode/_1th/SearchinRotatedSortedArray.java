package com.leetCode._1th;
/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author Zealot
 * @date 2015年9月4日 下午10:03:30
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums.length==0){
			return -1;
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==target){
				return i;
			}
		}
		return -1;
	}
}
