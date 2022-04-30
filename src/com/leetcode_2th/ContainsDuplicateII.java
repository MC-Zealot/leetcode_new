package com.leetcode_2th;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author Zealot
 * @date 2016年6月14日 下午2:29:46
 *
 */
public class ContainsDuplicateII {
	/**
	 * TLE
	 * @date 2016年6月14日 下午3:48:51
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums.length==0||k==0){
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(set.size()>=k){
				int del = list.pop();
				set.remove(del);
			}
			if(set.contains(nums[i])){
				return true;
			}
			set.add(nums[i]);
			list.push(nums[i]);
		}
		
		return false;
    }
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				if(i - index <= k){
					return true;
				}else{
					map.put(nums[i], i);
				}
			}else{
				map.put(nums[i], i);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,1,2,3};
		int k  = 2;
		
	}
}
