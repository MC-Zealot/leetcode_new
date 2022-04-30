package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * @author Zealot
 * @date 2015年8月16日 上午10:11:39
 */
public class SortColors {
	/**
	 * 先记录0和1出现的次数
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		int size0= 0;
		int size1= 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==0){
				size0++;
			}else if(nums[i]==1) {
				size1++;
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(size0>0){
				nums[i]=0;
				size0--;
			}else if(size1>0){
				nums[i]=1;
				size1--;
			}else{
				nums[i]=2;
			}
		}
		for(int i =0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	/**
	 * 链表???
	 * @param nums
	 */
	public void sortColors2(int[] nums) {
		ListNode l ; 
		for(int i =0; i < nums.length-1; i++){
			l = new ListNode(nums[i]);
		}
	}
	public static void main(String[] args) {
		int[] a ={0,1,0,2,1,2,2,0};
		SortColors s = new SortColors();
		System.out.println(a);
		s.sortColors(a);
	}
}
