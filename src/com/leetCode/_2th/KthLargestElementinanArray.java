package com.leetCode._2th;

import java.util.Arrays;

/**
 * Find the ktnh largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Zealot
 * @date 2016年1月16日 下午2:05:38
 */
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] a = {3,2,1,5,6,4};
		System.out.println(k.findKthLargest(a, 3));
	}
}
