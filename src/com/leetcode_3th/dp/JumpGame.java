package com.leetcode_3th.dp;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 * 
 * @author Zealot
 * @date Jul 19, 2019 1:06:57 PM 
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int reach = 0;
		for(int i = 0; i < nums.length && i <=reach; i++) {
			reach=Math.max(i+nums[i], reach);
		}
		if(reach<nums.length-1) {
			return false;
		}
		return true;
	}
}
