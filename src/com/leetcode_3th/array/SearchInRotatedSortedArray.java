package com.leetcode_3th.array;

/**
 * 
 * 
 * @author Zealot
 * @date Jul 17, 2019 5:17:25 PM 
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int nums[], int target) {
		int left = 0, right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2 ;
			int l = nums[left],r=nums[right], m=nums[mid];
			if (m == target) {
				return mid;
			}else if(m >= l) {
				if(target >= l && target < m) {
					right = mid - 1;
				}else {
					left=mid+1;
				}
			}else {
				if (target <= r && target > m) {
					left = mid + 1;
				}else {
					right=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int[] nums= {3,1};
		int target = 1;
		System.out.println(s.search(nums, target));
		
	}
}
