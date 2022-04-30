package com.leetcode_2th;
/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * 
 * @author Zealot
 * @date 2016年7月12日 上午9:57:53 
 *
 */
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int left = 0, right = A.length - 1;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (A[mid] == target){
				return true;
			}
			if (A[mid] > A[right]) {
				if (A[mid] > target && A[left] <= target){
					right = mid;
				}
				else{
					left = mid + 1;
				}
			} else if (A[mid] < A[right]) {
				if (A[mid] < target && A[right] >= target){
					left = mid + 1;
				}
				else{
					right = mid;
				}
			} else {
				right--;
			}

		}
		return A[left] == target ? true : false;
	}
	public static void main(String[] args) {
		SearchinRotatedSortedArrayII s = new SearchinRotatedSortedArrayII();
		int[] a = {3,1,2};
		System.out.println(s.search(a, 3));
	}
}
