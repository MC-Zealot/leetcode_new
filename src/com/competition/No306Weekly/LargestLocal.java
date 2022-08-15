package com.competition.No306Weekly;

/**
 * 6148. 矩阵中的局部最大值 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 *
 * 示例 1：
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * 示例 2：
 *
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 *
 * 提示：
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 */
public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int[][] ret = new int[grid.length -2][grid[0].length - 2];
        for(int i = 0;i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length -2; j++){
                int left = j;
                int right = j+2;
                int up = i;
                int down = i + 2;
                ret[i][j] = findMax(grid, left, up, right, down);
            }
        }
        return ret;
    }
    public int findMax(int[][] grid, int left, int up, int right, int down){
        int max = Integer.MIN_VALUE;
        for(int i = up; i <= down && i < grid.length; i++){
            for(int j = left; j <= right && j < grid[0].length; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestLocal l = new LargestLocal();
        int[][] matrix =  {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] ret = l.largestLocal(matrix);
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                System.out.print(ret[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
