package com.leetCode._1th;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author Zealot
 * @date 2015年9月5日 下午8:50:12
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums.length<=1){
			return nums.length;
		}
		int num = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i+1]){
				num++;
			}
			nums[i-num+1] = nums[i+1]; 
			for(int j = 0; j < nums.length; j++) {
				System.out.print(nums[j]+" ");
			}
			System.out.println();
		}
		return nums.length-num;
	}
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		int[] a = {1,1,1,1,2,2,3};
		
		System.out.println(r.removeDuplicates(a));
	}
}
