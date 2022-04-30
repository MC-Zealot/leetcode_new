package com.leetcode_3th.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

 * 
 * @author Zealot
 * @date Jul 21, 2019 6:25:22 PM 
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int res = 0;
		if(nums.length==0){
			return res;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
		}
		System.out.println(map.toString());
		int tmp_count_max = 0;
		for(Integer key: map.keySet()) {
			if(tmp_count_max < map.get(key)) {
				res = key;
				tmp_count_max = map.get(key);
			}
		}
		return res;
    }
	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int[] a = {3,2,3};
		System.out.println(m.majorityElement(a));
	}
}
