package com.leetCode._2th;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * @author Zealot
 * @date 2016年4月5日 下午9:07:20
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int left = 0, right = 0, sum = 0, len = nums.length, res = len + 1;
		while (right < len) {
			while (sum < s && right < len) {
				sum += nums[right++];
			}
			while (sum >= s) {
				res = Math.min(res, right - left);
				sum -= nums[left++];
			}
		}
		return res == len + 1 ? 0 : res;
	}
	public int minSubArrayLen2(int s, int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		int left = 0, right = 0, sum = 0, len = nums.length, res = len;
		int sum2 = 0;
		boolean flag = true;
		for(int i = 0; i < nums.length; i++) {
			sum2+=nums[i];
			if(sum2>s){
				flag = false;
				break;
			}
		}
		if(sum2==s&&flag){
			return nums.length;
		}
		while (right <= len) {
			if(sum < s&&right < len){
				sum+=nums[right++];
			}else if(sum>=s){
				res = Math.min(right - left, res);
				sum-=nums[left++];
			}else{
				return res == nums.length?0:res;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
//		int[] a  = {2,3,1,2,4,3};
		int[] a  = {1,4,4};
		System.out.println(m.minSubArrayLen2(10, a));
	}
}
