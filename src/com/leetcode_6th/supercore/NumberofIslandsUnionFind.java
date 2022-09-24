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
public class NumberofIslandsUnionFind {
    int colNum;
    int rowNum;

    /**
     * 陆地连通之后的数量与和水数量 - 水的数量
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        this.rowNum = grid.length;
        this.colNum = grid[0].length;
        int waterNum = 0;//水的数量
        UnionFind uf = new UnionFind(colNum * rowNum);
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(grid[i][j] == '0'){
                    waterNum++;
                }else {
                    int newX = i + 1;
                    int newY = j;
                    // 先判断坐标合法，再检查右边一格和下边一格是否是陆地
                    if(newX < rowNum && newY < colNum && grid[i][j] == '1' && grid[newX][newY] == '1'){
                        uf.union(getIndex(i,j), getIndex(newX, newY));
                    }
                    int newX2 = i;
                    int newY2 = j + 1;
                    if(newX2 < rowNum && newY2 < colNum && grid[i][j] == '1' && grid[newX2][newY2] == '1'){
                        uf.union(getIndex(i,j), getIndex(newX2, newY2));
                    }
                }
            }
        }
        return uf.count - waterNum;
    }
    public int getIndex(int i, int j){
        return i * colNum + j;
    }
    public class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i = 0;i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }
}
