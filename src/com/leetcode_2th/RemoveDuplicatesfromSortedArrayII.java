package com.leetcode_2th;
/**
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 

It doesn't matter what you leave beyond the new length.
 * 
 * @author Zealot
 * @date 2016年7月8日 下午10:06:34 
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int num = 0;// 一共重复的次数
		int time = 0;// 某一个数字，重复的次数
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1] && ++time >= 2) {// 如果大于等于2次，则计数
				num++;
			}
			if (nums[i] != nums[i + 1] && time > 0) {
				time = 0;
			}
			nums[i - num + 1] = nums[i + 1];
		}
		return nums.length - num;
	}
}
