package com.leetCode._1th;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Zealot
 * @date 2015年8月5日 下午8:39:49
 */
public class FindMinimuminRotatedSortedArray {
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
		int[] a = {4,5,6,7,1,2};
		int[] b = {3};
		int[] c = {1,2};
		FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
		System.out.println(f.findMin(c));
		Arrays.sort(a);
	}
}
