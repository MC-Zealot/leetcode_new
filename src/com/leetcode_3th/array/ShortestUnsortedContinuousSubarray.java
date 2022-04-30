package com.leetcode_3th.array;

import java.util.Arrays;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 示例 1:
 * 
 * 输入: [2, 6, 4, 8, 10, 9, 15] 输出: 5 解释: 你只需要对 [6, 4, 8, 10, 9]
 * 进行升序排序，那么整个表都会变为升序排序。 说明 :
 * 
 * 输入的数组长度范围在 [1, 10,000]。 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 
 * 
 * @author Zealot
 * @date Jul 22, 2019 1:35:30 PM
 *
 */
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int[] tmp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = nums[i];
		}
		Arrays.sort(tmp);
		int start = -1;
		int end = -1;
		boolean[] flags= new boolean[nums.length];
		for (int i = 0; i < tmp.length; i++) {
			if (start == -1 && nums[i] != tmp[i]) {
				flags[i] = true;
			} else if (start != -1 && (nums[i] == tmp[i])) {
				flags[i - 1] = true;
			}else if(start!=-1 &&  i==nums.length-1) {
				flags[i] = true;
			}
		}
		int res = 0;
		for(int i = 0; i < flags.length; i++) {
			if(flags[i]==true) {
				start= i;
				break;
			}
		}
		for(int i = flags.length-1; i >=0; i--) {
			if(flags[i]==true) {
				end= i;
				break;
			}
		}
		if(start!=-1 && end!=-1) {
			res = end - start + 1;
		}
		
		return res;
	}

	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
		int[] nums = { 2,6,4,8,10,9,15 };
//		int[] nums2= {1,3,2,4,5};
		System.out.println(s.findUnsortedSubarray(nums));
	}
}
