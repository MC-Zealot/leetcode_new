package com.leetCode._2th;


/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 * 
 * @author Zealot
 * @date 2015年12月27日 下午2:41:15
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        int w=0;//正常遍历的下标i，加上w(已经遍历了多少个0了)，所以，整体的下标为w+i
        for(int i = 0; i < nums.length-w; i++) {
            while((w+i+1<nums.length)&&nums[i+w]==0){//如果整体的下标为0，那么+1
            	w++;
            }
            nums[i] = nums[i+w];
        }
        for(int i=nums.length-w; i < nums.length; i++){
            nums[i] = 0;
        }
    }
	public static void main(String[] args) {
//		int[] a = {1,0};
		int[] a = {0, 1, 0, 3, 12,0,5};
		MoveZeroes mz = new MoveZeroes();
		mz.moveZeroes(a);
		for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
	}
}
