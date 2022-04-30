package com.leetcode_2th;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
给定一个未排序的数组，找出其排序后的序列中两个相邻元素之间的最大差值。

最好在线性时间、线性空间复杂度内完成。

如果数组少于2个元素，返回0

可以假设数组中的所有元素均为非负整数，并且在32位带符号整数的范围以内。
 * 
 * @author Zealot
 * @date 2016年7月4日 上午10:44:08 
 *
 */
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int gap = -1;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(gap, nums[i] - nums[i - 1]);
		}
		return gap;
	}
}
