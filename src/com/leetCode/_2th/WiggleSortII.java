package com.leetCode._2th;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?


 * 
 * @author Zealot
 * @date 2016年4月14日 上午11:14:04 
 *
 */
public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }
 
        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
        for(int i = 0; i < nums.length; i++){
        	System.out.print(nums[i]+"\t");
        }
    }
	public static void main(String[] args) {
		WiggleSortII w = new WiggleSortII();
//		int[] a = {1, 5, 1, 1, 6, 4,3,8};
		int[] a = {1, 3, 2, 2, 3, 1};
		w.wiggleSort(a);
	}
}