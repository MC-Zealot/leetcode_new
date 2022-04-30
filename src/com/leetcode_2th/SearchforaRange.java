package com.leetcode_2th;
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * 
 * @author Zealot
 * @date 2016年6月29日 上午11:18:03 
 *
 */
public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		int k = binarySearch(nums, target);
		if(k== -1){
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		int start = k, end = k;
		while (start >= 0 && nums[start] == target) {
			res[0] = start--; 
		}
		while (end < nums.length && nums[end] == target) {
			res[1] = end++; 
		}
		return res;
    }
	public int binarySearch(int[] nums, int target){
		int l = 0, r = nums.length - 1;
		while(l <= r){
			int mid = l + (r - l) / 2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] > target){
				r = mid -1;
			}else {
				l = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		SearchforaRange s = new SearchforaRange();
		int[] a = {1,4};
		int[] res = s.searchRange(a, 4);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
