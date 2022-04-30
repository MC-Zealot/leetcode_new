package com.leetcode_3th.array;

/**
 * 
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中
 * output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,4] 输出: [24,12,8,6] 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶： 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * 
 * @author Zealot
 * @date Jul 21, 2019 8:23:41 PM
 *
 */
public class ProductofArrayExceptSelf {
	/**
	 * 使用了除法
	 * @date Jul 21, 2019 8:38:44 PM
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		if(nums.length==0) {
			return res;
		}
		int p = 1;
		for(int i = 0; i < nums.length; i++) {
			p*=nums[i];
		}
		for(int i = 0; i < nums.length; i++) {
			res[i] = p/nums[i];
		}
		return res;
	}
	/**
	 * 开辟2个数组，一个数组保存0~i-1的乘积
	 * 另一个保存i+1,len-1的乘积
	 * @date Jul 21, 2019 8:39:07 PM
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];
		if(nums.length==0) {
			return res;
		}
		int[] a = new int[nums.length];
		int[] b = new int[nums.length];
		for(int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
		for(int i = 0; i < b.length; i++) {
			b[i] = 1;
		}
		for(int i = 1; i < nums.length; i++) {
			a[i] = nums[i - 1] * a[i - 1];
		}
		for(int i = nums.length - 2; i >=0; i--) {
			b[i] = nums[i + 1] * b[i+1];
		}
		for(int i = 0; i < nums.length; i++) {
			res[i] = a[i] * b[i];
		}
		return res;
	}
	public static void main(String[] args) {
		ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
		int[] nums = {1,2,3,4};
		int[] res = p.productExceptSelf(nums);
		for(int i = 0; i < res.length; i ++) {
			System.out.println(res[i]);
		}
		
	}
}
