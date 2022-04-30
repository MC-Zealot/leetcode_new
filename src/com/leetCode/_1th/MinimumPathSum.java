package com.leetCode._1th;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Zealot
 * @date 2015年8月16日 上午11:51:22
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int i, j;
		for (i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (j = 1; j < n; j++) {
			grid[0][j] += grid[0][j - 1];
		}
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}
}