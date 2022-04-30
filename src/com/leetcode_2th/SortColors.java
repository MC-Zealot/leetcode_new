package com.leetcode_2th;
/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * 
 *  with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 * 
 * @author Zealot
 * @date 2016年6月27日 下午2:26:31 
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {

		int size0= 0;
		int size1= 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==0){
				size0++;
			}else if(nums[i]==1) {
				size1++;
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(size0>0){
				nums[i]=0;
				size0--;
			}else if(size1>0){
				nums[i]=1;
				size1--;
			}else{
				nums[i]=2;
			}
		}
    }

	public void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int[] res = new int[nums.length];
		int[] helper = new int[3];
		for (int i = 0; i < nums.length; i++) {
			helper[nums[i]]++;
		}
		for (int i = 1; i < 3; i++) {
			helper[i] = helper[i] + helper[i - 1];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			res[helper[nums[i]] - 1] = nums[i];
			helper[nums[i]]--;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = res[i];
		}
	}  

	public void sortColors3(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int idx0 = 0;
		int idx1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = 2;
				nums[idx1++] = 1;
				nums[idx0++] = 0;
			} else if (nums[i] == 1) {
				nums[i] = 2;
				nums[idx1++] = 1;
			}
		}
	}
}
