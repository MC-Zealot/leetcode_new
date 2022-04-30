package com.leetCode._1th;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. 
 * 
 * Note: Your algorithm should have a linear runtime
 * complexity. Could you implement it without using extra memory?
 * 
 * @author Zealot
 *
 */
public class SingleNumber_136 {
	public static int singleNumber(int[] nums) {
		int a = 0;
		for(int i = 0; i < nums.length; i++) {
			a = a^nums[i];
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = {1,2,1,2,5,4,5};
		System.out.println(singleNumber(a));
	}
}
