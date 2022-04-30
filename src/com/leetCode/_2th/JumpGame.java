package com.leetCode._2th;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * 
 * @author Zealot
 * @date 2016年2月19日 下午10:13:26 
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if(nums.length==0){
			return false;
		}
		
		int reach = 0;
		for(int i = 0;i <=reach&& i < nums.length;i ++){
			reach = Math.max(nums[i] + i, reach);
		}
		if(reach<nums.length-1){
			return false;
		}
		return true;
    }

	public boolean canJump2(int[] A) {
		if (A == null || A.length == 0)
			return false;
		int reach = 0;
		for (int i = 0; i <= reach && i < A.length; i++) {
			reach = Math.max(A[i] + i, reach);
		}
		if (reach < A.length - 1)
			return false;
		return true;
	}  
	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] a = {0};
		System.out.println(j.canJump2(a));
	}
}
