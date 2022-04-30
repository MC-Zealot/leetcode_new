package com.leetCode._2th;
/**
 *
 * @Description:
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * @author Zealot
 * @date 2016年2月16日 下午5:57:36
 *
 */
public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int[] a ={-1,-1};
		if(nums.length==0) {
			return a;
		}
		int start = 0;
		int end = nums.length-1;
		int mid  = (start+end)/2;
		int flag = -1;
		while(start<= end){
			mid  = (start+end)/2;
			if(nums[mid]>target){
				end = mid-1;
			}else if(nums[mid]<target){
				start = mid+1;
			}else if(nums[mid]==target){
				flag = mid;
				break;
			}

		}
		if(flag==-1){
			return a;
		}
		for(int i = mid; i >=0; i--){
			if(nums[i]==target){
				a[0] = i;
			}else{
				break;
			}
		}
		for(int i = mid; i < nums.length; i++) {
			if(nums[i]==target){
				a[1] = i;
			}else{
				break;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		SearchforaRange s = new SearchforaRange();
		int[] nums={4};
		int target = 4;
		int[] a = s.searchRange(nums, target);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
