package com.leetcode_2th;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Zealot
 * @date 2016年6月7日 下午1:03:42
 *
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int max = 0;
		int res = 0;
		int[] container = new int[A.length];
		for (int i = 0; i < A.length; i++) {//从目前为止最高的，放到新的数组container中
			container[i] = max;
			max = Math.max(max, A[i]);//并且找到最大的
		}
		max = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			container[i] = Math.min(max, container[i]);//container与max比较
			max = Math.max(max, A[i]);
			res += container[i] - A[i] > 0 ? container[i] - A[i] : 0;
		}
		return res;
	}
}
