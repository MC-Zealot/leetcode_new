package com.leetcode_6th;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;
                //上左
                if(i - 1 >= 0 && j - 1 >=0){
                    a = dp[i - 1][j - 1];
                }
                //上
                if(i - 1 >= 0){
                    b = dp[i - 1][j];
                }
                //上右
                if(i - 1 >= 0 && j + 1 < m){
                    c = dp[i - 1][j + 1];
                }
                //选择最小的
                int min = Math.min(a,b);
                min = Math.min(min, c);
                dp[i][j] = min + matrix[i][j];
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ret = Math.min(ret, dp[m - 1][i]);
        }
        return ret;
    }
}
