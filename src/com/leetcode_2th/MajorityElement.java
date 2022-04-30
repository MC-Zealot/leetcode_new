package com.leetcode_2th;

import java.util.Arrays;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月3日 下午12:06:32 
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
    }
}
