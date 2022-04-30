package com.leetcode_3th.dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入: [   [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 * @author Zealot
 * @date Jul 21, 2019 11:53:53 AM
 *
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int[][] sum_grid = new int[grid.length][grid[0].length];
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		sum_grid[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) {
			sum_grid[i][0] = grid[i][0] + sum_grid[i - 1][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			sum_grid[0][i] = grid[0][i] + sum_grid[0][i - 1];
		}
/**
 * 状态转移方程，因为到达当前位置 (i, j)  只有两种情况，要么从上方 (i-1, j) 过来，要么从左边 (i, j-1) 过来
 * 当前的是sum，包括之前所有路径的和，所有是当前的全局最优
 */
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[i].length; j++) {
				int left = 0, up = 0;
				left = sum_grid[i][j - 1];
				up = sum_grid[i - 1][j];
				sum_grid[i][j] = grid[i][j] + Math.min(left, up);
			}
		}
		return sum_grid[grid.length - 1][grid[0].length - 1];
	}
}
