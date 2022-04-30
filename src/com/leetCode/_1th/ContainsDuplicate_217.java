package com.leetCode._1th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author Zealot
 * @date 2015年7月22日 下午5:30:18
 */
public class ContainsDuplicate_217 {
	public boolean containsDuplicate(int[] nums) {
		if(nums==null){
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}else{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,2};
		ContainsDuplicate_217 c = new ContainsDuplicate_217();
		System.out.println(c.containsDuplicate(a));
	}
}
