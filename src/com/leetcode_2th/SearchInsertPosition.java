package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月1日 上午9:58:24 
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		int mid = 0;
		while(start<end){
			mid = (start+end)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]>target){
				end = mid -1;
			}else{
				start = mid +1;
			}
		}
		if(nums[start]>=target){
			return start;
		}else{
			return start + 1;
		}
    }
	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = {1};
//		int[] nums = {1,3};
		int target = 0;
		System.out.println(s.searchInsert(nums, target));
	}
}
