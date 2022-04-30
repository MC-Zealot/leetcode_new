package com.leetcode_2th;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * @author Zealot
 * @date 2016年6月1日 上午10:58:46
 *
 */
public class FindMinimuminSortedRotatedArray {

	public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if(mid -1>=0){
				if(nums[mid]<nums[mid -1] && nums[mid] < nums[mid+1]){
					return nums[mid];
				}else if (nums[mid - 1] < nums[mid + 1]) {
					end = mid - 1;
				} else   {
					start = mid + 1;
				} 
			}else{
				if(nums[mid] < nums[mid+1]){
					return nums[mid];
				}else if (nums[mid + 1] > nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				} 
			}
		}
		return nums[start];
	}
	/**
	 * time:O(logn)
	 * @date 2016年6月1日 下午1:47:29
	 * @param nums
	 * @return
	 */
	public int findMin3(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r && nums[l] >= nums[r]) {
			int m = (l + r) / 2;
			if (nums[m] > nums[r]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return nums[l];
	}
	public static void main(String[] args) {
		FindMinimuminSortedRotatedArray f = new FindMinimuminSortedRotatedArray();
		int[] a = {4,5,6,7,0,1,2};
//		int[] a = {3,1,2};
		System.out.println(f.findMin3(a));
	}
	public int findMin2(int[] nums) {
		int start = 0, end = nums.length - 1, mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid + 1] > nums[mid]) {
				end = mid - 1;
			} else if (nums[mid + 1] < nums[mid] && nums[mid - 1] > nums[mid]) {
				start = mid + 1;
			} else {
				return nums[mid];
			}
		}
		return 0;
	}
}
