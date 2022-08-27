package com.leetcode_6th.supercore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberofIslands {
    char[][] grid;
    int[][] flags;
    int ret;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.flags = new int[m][n];
        this.ret = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(flags[i][j] == 0 && grid[i][j] == '1'){
                    ret++;
                    dfs(i,j);
                }
            }
        }
        return ret;
    }
    public void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || flags[i][j] == 1 || grid[i][j] == '0'){
            return;
        }
        flags[i][j] = 1;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        }
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    /**
     * 不需要flags
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    /**
     * BFS
     * https://leetcode.cn/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
     * @param grid
     * @return
     */
    public int numIslands3(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        while(queue.size() > 0){
            int[] cur = queue.poll();
            i = cur[0]; j = cur[1];
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.add(new int[] { i + 1, j });
                queue.add(new int[] { i - 1, j });
                queue.add(new int[] { i, j + 1 });
                queue.add(new int[] { i, j - 1 });
            }
        }
    }

}
