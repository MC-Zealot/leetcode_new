package com.competition.No300Weekly;

import java.util.Arrays;

/**
 * 2328. 网格图中递增路径的数目
 * 给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。
 *
 * 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 109 + 7 取余 后返回。
 *
 * 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[3,4]]
 * 输出：8
 * 解释：严格递增路径包括：
 * - 长度为 1 的路径：[1]，[1]，[3]，[4] 。
 * - 长度为 2 的路径：[1 -> 3]，[1 -> 4]，[3 -> 4] 。
 * - 长度为 3 的路径：[1 -> 3 -> 4] 。
 * 路径数目为 4 + 3 + 1 = 8 。
 * 示例 2：
 *
 * 输入：grid = [[1],[2]]
 * 输出：3
 * 解释：严格递增路径包括：
 * - 长度为 1 的路径：[1]，[2] 。
 * - 长度为 2 的路径：[1 -> 2] 。
 * 路径数目为 2 + 1 = 3 。
 *
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 */
public class CountPaths {
    static final int MOD = (int) 1e9 + 7;
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    int[][] grid;
    int[][] f;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                ans = (ans + dfs(i, j)) % MOD;
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        if (f[i][j] != -1) {
            return f[i][j];
        }
        int res = 1;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]){
                res = (res + (dfs(x, y))) % MOD;
            }
        }
        return f[i][j] = res;
    }
}
