package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Zealot
 * @date 2016年5月31日 下午8:24:01 
 *
 */
public class MaximumSubarray {
	/**
	 * time: O(n^2)
	 * space:O(n)
	 * @date 2016年5月31日 下午8:37:05
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curSum = 0;
		map.put(-1, 0);
		for (int i = 0; i < nums.length; i++) {
			curSum = curSum+nums[i];
			map.put(i, curSum);
		}
		int s = 0;
		for(int start = 0; start < nums.length; start++) {
			for(int end = start; end < nums.length; end++){
				s = map.get(end) - map.get(start-1);
				max = max<s?s:max;
			}
		}
		return max;
    }

	/**
	 * time:O(nlogn)
	 * space:O(n)
	 * @date 2016年5月31日 下午8:52:38
	 * @param A
	 * @return
	 */
	public int maxSubArray2(int[] A) {
		return maxSubArrayHelper(A, 0, A.length - 1);
	}
	
	private int maxSubArrayHelper(int[] A, int L, int R) {
		if (L > R)
			return Integer.MIN_VALUE;
		int M = (L + R) / 2;
		int leftAns = maxSubArrayHelper(A, L, M - 1);
		int rightAns = maxSubArrayHelper(A, M + 1, R);
		int lMaxSum = 0;
		int sum = 0;
		for (int i = M - 1; i >= L; i--) {
			sum += A[i];
			lMaxSum = Math.max(sum, lMaxSum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = M + 1; i <= R; i++) {
			sum += A[i];
			rMaxSum = Math.max(sum, rMaxSum);
		}
		return Math.max(lMaxSum + A[M] + rMaxSum, Math.max(leftAns, rightAns));
	}
	/**
	 * time:O(n)
	 * space:O(1)
	 * dp
	 * @date 2016年5月31日 下午8:53:28
	 * @param A
	 * @param L
	 * @param R
	 * @return
	 */
	public int maxSubArray3(int[] A) {
		int maxEndingHere = A[0], maxSoFar = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] a = {5,-2,-3,1};
		MaximumSubarray m = new MaximumSubarray();
		System.out.println(m.maxSubArray(a));
	}
}
