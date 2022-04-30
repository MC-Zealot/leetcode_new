package com.leetCode._3th;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 
 * @author Zealot
 * @date 2018年4月24日 上午12:40:55 
 *
 */
public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int[] nums2 = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}
		int res[] = new int[2];
		res[0] = 0;
		res[1] = 0;
		int tmp[] = new int[2];
		if (nums.length <= 1) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0, j = nums.length - 1; i < j;) {
			if (nums[i] + nums[j] == target) {
				tmp[0] = nums[i];
				tmp[1] = nums[j];
				break;
			} else if (nums[i] + nums[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		int index =0;
		for(int i = 0; i < nums2.length; i++) {
			if(nums2[i]==tmp[0]){
				res[index++] = i;
			}else if(nums2[i]==tmp[1]){
				res[index++] = i;
			}
		}
		return res;
	}
	public int[] twoSum2(int[] nums, int target) {
		int res[] = new int[2];
		res[0] = 0;
		res[1] = 0;
		if (nums.length <= 1) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])){
				res[0] = map.get(target-nums[i]);
				res[1] = i;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		TwoSum t = new TwoSum();
		int[] res = t.twoSum2(a, 9);
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res.length);
	}
}
