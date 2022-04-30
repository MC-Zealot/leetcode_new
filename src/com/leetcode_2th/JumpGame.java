package com.leetcode_2th;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * 
 * @author Zealot
 * @date 2016年6月28日 下午12:08:31 
 *
 */
public class JumpGame {
	/**
	 * TIME:O(n^2)
	 * @date 2016年6月28日 下午12:27:48
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if(nums.length==0){
			return false;
		}
		boolean[] isDest = new boolean[nums.length];
		isDest[0]= true;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i] && i + j + 1 < nums.length; j++) {
				isDest[i + j + 1] = true;
			}
		}
		for(boolean b: isDest){
			if(b==false){
				return false;
			}
		}
		return true;
	}
	/**
	 * O(n)
	 * @date 2016年6月28日 下午12:35:01
	 * @param nums
	 * @return
	 */
	public boolean canJump2(int[] nums) {
		if (nums == null || nums.length == 0){
			return false;
		}
		int reach = 0;
		for (int i = 0; i <= reach && i < nums.length; i++) {
			reach = Math.max(nums[i] + i, reach);
		}
		if (reach < nums.length - 1){
			return false;
		}
		return true;
	} 
	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] a = {3,2,1,1,4};
		System.out.println(j.canJump(a));
	}
}
