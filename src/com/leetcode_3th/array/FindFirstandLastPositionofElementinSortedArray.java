package com.leetcode_3th.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4] 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 
 * @author Zealot
 * @date Jul 18, 2019 10:19:18 AM
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
	private int binarySearch(int[] array, int des) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] == des) {
				return mid;
			} else if (array[mid] > des) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		int index = binarySearch(nums, target);
		if (nums.length == 0 || index == -1) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		int left = index, right = index;
		if(index>0) {
			while(left>=0 && nums[left]==target) {
				left--;
			}
			left++;
		}
		if(index<nums.length-1) {
			while(right<=nums.length-1 && nums[right] == target) {
				right++;
			}
			right--;
		}
		res[0] = left;
		res[1] = right;
		return res;
	}
}
