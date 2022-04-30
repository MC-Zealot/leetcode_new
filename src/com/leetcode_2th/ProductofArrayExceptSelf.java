package com.leetcode_2th;
/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal 
 * to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: .)
 * The output array does not count as extra space 
for the purpose of space complexity analysis
 * @author Zealot
 * @date 2016年6月18日 下午3:50:05 
 *
 */
public class ProductofArrayExceptSelf {
	/**
	 * SPACE: O(n)
	 * @date 2016年6月18日 下午4:07:14
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		if (nums.length <= 1) {
			return res;
		}
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] * nums[i - 1];
			b[i] = b[i - 1] * nums[n - i];
		}
		for (int i = 0; i < n; i++) {
			a[i] *= b[n - i - 1];
		}
		return a;
	}
	/**
	 * SPACE: O(1)
	 * @date 2016年6月18日 下午4:08:17
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf2(int[] nums) {
		int product = 1;
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			product = product * nums[i - 1];
			result[i] = product;
		}
		product = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			product = product * nums[i];
			result[i - 1] = product * result[i - 1];
		}
		return result;
	}
}
