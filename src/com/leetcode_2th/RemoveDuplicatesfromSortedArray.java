package com.leetcode_2th;

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
 * @date 2016年6月7日 上午10:32:16
 *
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int place = 0,//可能被替换的位置
				j = 0;//是否出现过相同元素，0为没有，其他为出现过。
		for (int next = 1; next < nums.length; next++) {
			if (nums[place] != nums[next]) {
				place++;
				if (place + j + 1 != next) {
					nums[place] = nums[next];
				}
			}else{
				j++;
			}
		}
		return place + 1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2,3,3,3,4,4,5,5,5,5,5,6};
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		r.removeDuplicates(a);
	}
}
