package com.leetcode_2th;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Zealot
 * @date 2016年6月17日 上午10:53:01
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] != (i + 1) && nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[tmp - 1] = tmp;
			} else {
				i++;
			}
		}
		for (i = 0; i < n; i++){
			if (nums[i] != (i + 1)){
				return i + 1;
			}
		}
		return n + 1;
	}
	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int[] a = {2,1};
		System.out.println(f.firstMissingPositive(a));
	}
}
