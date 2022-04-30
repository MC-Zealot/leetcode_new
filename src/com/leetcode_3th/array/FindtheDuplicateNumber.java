package com.leetcode_3th.array;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * 
 * 示例 1: Input: [1,3,4,2,2] Output: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,1,3,4,2] 输出: 3
 * 
 * 说明：
 * 
 * 不能更改原数组（假设数组是只读的）。 只能使用额外的 O(1) 的空间。 时间复杂度小于 O(n^2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 
 * 
 * @author Zealot
 * @date Jul 21, 2019 9:19:05 PM
 *
 */
public class FindtheDuplicateNumber {
	/**
	 * O(n^2)
	 * 
	 * @date Jul 21, 2019 9:32:45 PM
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return nums[i];
				}
			}
		}
		return 0;
	}

	public int findDuplicate2(int[] nums) {
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2, cnt = 0;
			for (int num : nums) {
				if (num <= mid)
					++cnt;
			}
			if (cnt <= mid)
				left = mid + 1;
			else
				right = mid;
		}
		return right;
	}

	public static void main(String[] args) {
		FindtheDuplicateNumber f = new FindtheDuplicateNumber();
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(f.findDuplicate2(nums));
	}
}
