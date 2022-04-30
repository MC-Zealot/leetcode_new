package com.leetcode_3th.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

 * 
 * @author Zealot
 * @date Jul 31, 2019 2:49:42 PM 
 *
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer,Integer>map = new HashMap<>();
        for (int num:nums) {
        	if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key:map.keySet()){
            int value = map.get(key);
            if (bucket[value]==null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }
        List<Integer>res = new LinkedList<>();
        for (int i=nums.length;i >= 1 && res.size() < k;i--){
            if (bucket[i]!=null){
                res.addAll(bucket[i]);
            }
        }
        return res;
	}
}
