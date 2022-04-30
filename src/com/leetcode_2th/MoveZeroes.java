package com.leetcode_2th;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * 
 * @author Zealot
 * @date 2016年6月6日 上午11:55:55
 *
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int place = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==0){
				continue;
			}else{
				nums[place++]=nums[i];
			}
		}
		for(; place < nums.length; place++) {
			nums[place] = 0;
		}
	}
	public static void main(String[] args) {
		MoveZeroes m  = new MoveZeroes();
		int[] nums = {0, 1};
		m.moveZeroes(nums);
	}
}
