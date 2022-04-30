package com.leetcode_2th;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月31日 下午8:58:59
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if(A.length == 0){
			return 0;
		}
		
		int max = A[0], min = A[0], maxAns = A[0];
		for (int i = 1; i < A.length; i++) {
			int mx = max, mn = min;
			max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
			min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
	}
	public static void main(String[] args) {
		MaximumProductSubarray m = new MaximumProductSubarray();
		int[]a ={};
		System.out.println(m.maxProduct(a));
	}
}
