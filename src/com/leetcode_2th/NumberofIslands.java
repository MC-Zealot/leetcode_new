package com.leetcode_2th;
/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 * 
 * @author Zealot
 * @date 2016年6月16日 下午10:34:01 
 *
 */
public class NumberofIslands {
	private int m, n;  
    
    public int numIslands(char[][] grid) {  
        m = grid.length;  
        if (m == 0) return 0;  
        n = grid[0].length;  
        if (n == 0) return 0;  
          
        int ans = 0;  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (grid[i][j] != '1') continue;  
                  
                ans++;  
                dfs(grid, i, j);  
            }  
        }  
        return ans;  
    }  
      
      
    public void dfs(char[][] grid, int i, int j) {  
        if (i < 0 || i >= m || j < 0 || j >= n) return;  
          
        if (grid[i][j] == '1') {  
            grid[i][j] = '2';  
            dfs(grid, i - 1, j);  
            dfs(grid, i + 1, j);  
            dfs(grid, i, j - 1);  
            dfs(grid, i, j + 1);  
        }  
    }  
}
