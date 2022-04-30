package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

 * @author Zealot
 * @date 2016年3月7日 下午12:07:33 
 *
 */
public class TwoSum {
	int[] res = new int[2];
	public int[] twoSum(int[] nums, int target) {
		backTracing(nums, target, 0, new ArrayList<Integer>());
		return res;
    }
	/**
	 * 人家要的是index，不是value。时间复杂度O(n!)
	 * @date 2016年4月17日 上午11:24:49
	 * @param nums
	 * @param target
	 * @param cur
	 * @param list
	 */
	private void backTracing(int[] nums, int target, int cur, List<Integer> list) {
		if(list.size()==2){
			int sum = list.get(0)+list.get(1);
			if(sum==target){
				System.out.println(list.get(0)+"+"+list.get(1)+"="+sum);
				res[0] = list.get(0);
				res[1] = list.get(1);
			}
			
			return ;
		}
		for(int i = cur; i < nums.length; i++) {
			list.add(nums[i]);
			backTracing(nums, target, cur+1, list);
			list.remove(list.size()-1);
		}
	}
	/**
	 * 
	 * @date 2016年3月9日 上午10:49:37
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		int[] nums2 = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}
		Arrays.sort(nums);
		for(int i = 0, j = nums.length - 1; i <= j; ){
			if(nums[i]+ nums[j]==target){
				res[0] = nums[i];
				res[1] = nums[j];
				break;
			}else if (nums[i]+ nums[j] > target){
				j--;
			}else{
				i++;
			}
		}
		int index = 0;
		int[] res2 = new int[2];
		for(int i = 0 ;i < nums2.length; i++) {
			if(nums2[i]==res[0]||nums2[i]==res[1]){
				res2[index++] = i;
			}
		}
		return res2;
	}
	public static void main(String[] args) {
		int[] a = {3,3};
		TwoSum t = new TwoSum();
		int[] res = t.twoSum2(a, 6);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
