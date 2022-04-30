package com.leetcode_2th;
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * 
 * @author Zealot
 * @date 2016年7月5日 上午9:53:44 
 *
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][] res = new int[grid.length][grid[0].length];
		res[0][0] = grid[0][0];
		// 赋初值
		for (int i = 1; i < grid[0].length; i++) {
			res[0][i] = grid[0][i] + res[0][i - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			res[i][0] = grid[i][0] + res[i - 1][0];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				res[i][j] = grid[i][j] + Math.min(res[i][j - 1], res[i - 1][j]);
			}
		}
		return res[grid.length - 1][grid[0].length - 1];
    }
}
