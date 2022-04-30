package com.leetCode._1th;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author Zealot
 * @date 2015年8月16日 下午7:48:30
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i]>nums[i+1]){
				return nums[i+1];
			}
		}
		return nums[0];
	}
	public static void main(String[] args) {
		int[] a = {4,5,5,6,7,1,1,2,2};
		int[] b = {3};
		int[] c = {1,2};
		FindMinimuminRotatedSortedArrayII f = new FindMinimuminRotatedSortedArrayII();
		System.out.println(f.findMin(a));
	}
}
