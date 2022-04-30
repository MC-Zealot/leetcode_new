package com.leetcode_3th.dfs;


/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
示例 1:

输入:
11110
11010
11000
00000
输出: 1

示例 2:
输入:
11000
11000
00100
00011
输出: 3
 * 
 * @author Zealot
 * @date Aug 1, 2019 12:45:05 PM 
 *
 */
public class NumberofIslands {
	int res = 0;

	public int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return res;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != '1') continue;
				
				res += 1;
				dfs(i, j, grid);
			}
		}
		
		return res;
	}

	/**
	 * 
	 * @date Aug 1, 2019 1:42:53 PM
	 * @param curr_i
	 * @param curr_j
	 * @param grid
	 */
	public void dfs(int i, int j, char[][] grid) {
		// 往外走一个，如果是1，增面积+1，并且flag为true。如果外边都是0，则为一个岛屿，从下一个不为0的岛屿开始
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
			return;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			dfs(i + 1, j, grid);
			dfs(i, j + 1, grid);
			dfs(i - 1, j, grid);
			dfs(i, j - 1, grid);
		}
	}

	public static void main(String[] args) {
		char grid[][] = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		NumberofIslands n = new NumberofIslands();
		System.out.println(n.numIslands(grid));
	}
}
