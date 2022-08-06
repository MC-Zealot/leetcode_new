package com.leetcode_6th;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int sum = 0;
        for(int i = 0;i < m; i++){
            sum = sum + grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for(int j = 0; j < n; j++){
            sum = sum + grid[0][j];
            dp[0][j] = sum;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i != 0 && j != 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
