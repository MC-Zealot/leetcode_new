package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description: Given an array of integers and an integer k, find out whether
 *               there are two distinct indices i and j in the array such that
 *               nums[i] = nums[j] and the difference between i and j is at most
 *               k.
 * @author Zealot
 * @date 2016年2月14日 下午12:25:21
 *
 */
public class ContainsDuplicateII {
	//O(NK)
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j <= i+k && j < nums.length; j++) {
				if(nums[i]==nums[j]){
					return true;
				}
			}
		}
		return false;
	}
	//O(N)
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
	//O(N)
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				if(index>=0 && i - index <= k){
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
}