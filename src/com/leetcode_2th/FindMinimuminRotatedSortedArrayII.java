package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月2日 下午5:02:13 
 *
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r && nums[l] >= nums[r]) {
			int M = (l + r) / 2;
			if (nums[M] > nums[r]) {
				l = M + 1;
			} else if (nums[M] < nums[l]) {
				r = M;
			} else { // A[L] == A[M] == A[R]
				l = l + 1;
			}
		}
		return nums[l];
	}
}
