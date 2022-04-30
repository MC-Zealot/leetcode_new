package com.leetcode_3th.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 
 * 示例:
 * 
 * 输入: [4,3,2,7,8,2,3,1]
 * 
 * 输出: [5,6]
 * 
 * 
 * @author Zealot
 * @date Jul 21, 2019 10:10:19 PM
 *
 */
public class FindAllNumbersDisappearedinanArray {
	/**
	 * 对于每个数字nums[i]，如果其对应的nums[nums[i] - 1]是正数，我们就赋值为其相反数
	 * 
	 * @date Jul 21, 2019 10:28:10 PM
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] > 0) {
				nums[idx] = -nums[idx];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		FindAllNumbersDisappearedinanArray f = new FindAllNumbersDisappearedinanArray();
		System.out.println(f.findDisappearedNumbers(nums));
	}
}
