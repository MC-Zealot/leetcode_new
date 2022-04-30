package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You may
 * assume that the array does not change. There are many calls to sumRange
 * function.
 * 
 * @author Zealot
 * @date 2016年4月10日 下午12:36:38
 *
 */
public class RangeSumQueryImmutable {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public RangeSumQueryImmutable(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum+=nums[i];
			map.put(i, sum);
		}
	}

	public int sumRange(int i, int j) {
		return map.get(j) - (i- 1<=-1? 0 : map.get(i -1));
	}
	public static void main(String[] args) {
		int[] a = {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImmutable r = new RangeSumQueryImmutable(a);
		System.out.println(r.sumRange(2, 5));
	}
}
