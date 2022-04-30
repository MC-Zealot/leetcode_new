package com.leetCode._1th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * @author Zealot
 * @date 2015年9月2日 下午8:30:42
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int min=0;
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			if(min>nums[i]){
				min=nums[i];
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(max<nums[i]){
				max=nums[i];
			}
		}
		System.out.println("max:" + max);
		System.out.println("min:" + min);
		for(;min<=max;min++) {
			if(!set.contains(min)){
				return min;
			}
		}
		return ++max;
	}
	public static void main(String[] args) {
		int[] a = {1,0};
		MissingNumber m = new MissingNumber();
		System.out.println(m.missingNumber(a));
	}
}
