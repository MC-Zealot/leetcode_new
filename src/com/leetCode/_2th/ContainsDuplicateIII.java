package com.leetCode._2th;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author Zealot
 * @date 2016年4月6日 上午9:15:37
 *
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k < 1 || t < 0){
			return false;
		}
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null && set.ceiling(n) <= t + n){
            	return true;
            }
            set.add(n);
            if (i >= k){
            	set.remove(nums[i - k]);
            }
        }
		return false;
	}
	/**
	 * |nums[i]-nums[j]|<=t
	 * |i-j|<=k
	 * @date 2016年4月6日 下午6:10:03
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if(k < 1 || t < 0){
			return false;
		}
        int left = 0, right = 1, len = nums.length;
        while(right < len){
        	if(right-left+1>t){
        		left++;
        	}
        	
        }
		return false;
	}
}