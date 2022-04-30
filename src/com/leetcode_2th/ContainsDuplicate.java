package com.leetcode_2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author Zealot
 * @date 2016年6月6日 下午12:04:19
 *
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		int size = nums.length;
		Set<Integer> set = new HashSet<Integer>(size);
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])){
				return true;
			}
			set.add(nums[i]);
		}
				
		return false;
    }

	public boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int x : nums) {
			if (set.contains(x))
				return true;
			set.add(x);
		}
		return false;
	}
}
