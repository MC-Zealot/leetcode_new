package com.leetCode._1th;
/**
Given a sorted array and a target value, return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * @author Zealot
 * @date 2015年7月25日 下午5:48:20
 */
public class SearchInsertPosition_35 {
	public int searchInsert(int[] nums, int target) {
		if(nums==null){
			return 0;
		}
		if(nums[0]>target){
			return 0;
		}
		if(nums[nums.length-1]<target){
			return nums.length;
		}
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i]==target){
				return i;
			}else if(nums[i+1]==target){
				return i+1;
			}
			else if(nums[i]<target&&nums[i+1]>target){
				return i+1;
			}
		}
     return 0;   
    }
	public static void main(String[] args) {
		int[] a = {1,3,5,6};
		SearchInsertPosition_35 s = new SearchInsertPosition_35();
		System.out.println(s.searchInsert(a, 0));
	}
}
