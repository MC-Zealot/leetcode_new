package com.leetCode._2th;
/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
 * 
 * @author Zealot
 * @date 2016年4月14日 下午10:12:10 
 *
 */
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int x1 = 0x7fffffff, x2 = 0x7fffffff;
        for(int num : nums){
            if(num <= x1) x1 = num;
            else if(num <=x2) x2 = num;
            else return true;
        }
        return false;
	}
	public static void main(String[] args) {
		int[] nums = {5,1,5,5,2,5,4};
		IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
		System.out.println(i.increasingTriplet(nums));
	}
}
