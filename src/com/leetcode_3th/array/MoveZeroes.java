package com.leetcode_3th.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 * 
 * @author Zealot
 * @date Jul 21, 2019 8:56:19 PM
 *
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		// 记录每个下标前移的位数，记录他前边有几个0
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int zero_count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zero_count++;
			}
			map.put(i, zero_count);
		}
		System.out.println(map.toString());
		for (int i = 0; i < nums.length; i++) {
			if (i==0||nums[i] == 0) {
				continue;
			}
			int zero_c = map.get(i - 1);
			nums[i - zero_c] = nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i + zero_count  >= nums.length) {
				nums[i] = 0;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] nums = { 1, 0, 3, 12 };
		m.moveZeroes(nums);
	}

}
