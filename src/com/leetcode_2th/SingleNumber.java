package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月24日 下午12:00:19 
 *
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		
		return res;
	}
}
