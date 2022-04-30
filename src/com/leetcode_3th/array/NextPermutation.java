package com.leetcode_3th.array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int left = nums.length - 2, right = nums.length - 1;
		// 找到左边和右边的下标,
		// find left，找到第一个左边<右边的下标（right和left指针一起向左移动）
		while (left < right && left >= 0) {
			if (nums[left] < nums[right]) {
				// 当找到left之后，find right, right 从最右边开始找
				right=nums.length - 1;
				while (left < right) {
					if (nums[right] > nums[left]) {
						break;
					}
					right--;
				}
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				break;
			}
			left--;
			right--;
		}

		// 给left后边排序
		int start = left + 1;
		// 如果是字典最后一个
		if (left < 0) {
			start = 0;
		}
		// 排序，从start开始，到最后
		int[] a = new int[nums.length - start];
		for (int i = 0; i < a.length; i++) {
			a[i] = nums[i + start];
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			nums[i + start] = a[i];
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 
	 * @date Aug 14, 2019 3:15:41 PM
	 * @param nums
	 */
	public void nextPermutation2(int[] nums) {
		int len = nums.length;
		int start = 0;
		OK:
		for (int i = len - 1; i >= 0; i--) {
			for (int j = len - 1; j >= i; j--) {
				if (nums[j] > nums[i]) {
					int tmp = nums[j];
					nums[j] = nums[i];
					nums[i] = tmp;
					start = i + 1;
					break OK;
				}
			}
		}
		int[] tmp_nums = new int[len - start];
		int s = start;
		for (int i = 0; i < tmp_nums.length; i++) {
			tmp_nums[i] = nums[start++];
		}
		Arrays.sort(tmp_nums);
		for (int i = 0; s < len; s++, i++) {
			nums[s] = tmp_nums[i];
		}
	}
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
//		int[] a = {1,3,2};
		int[]		a = {4,2,0,2,3,2,0};
		np.nextPermutation(a);

	}
}
