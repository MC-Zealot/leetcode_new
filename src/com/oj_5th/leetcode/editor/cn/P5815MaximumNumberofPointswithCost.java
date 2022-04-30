package com.oj_5th.leetcode.editor.cn;

public class P5815MaximumNumberofPointswithCost {
//    5815. Maximum Number of Points with Cost
    public long maxPoints2(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            long[] cur = new long[n + 1];
            long lmax = 0;
            for (int j = 0; j < n; j++) {
                lmax = Math.max(lmax - 1, dp[j]);
                cur[j] = lmax;
            }
            long rmax = 0;
            for (int j = n - 1; j >= 0; j--) {
                rmax = Math.max(rmax - 1, dp[j]);
                cur[j] = Math.max(cur[j], rmax);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = cur[j] + points[i][j];
            }
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }
    //    5815. Maximum Number of Points with Cost
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        long[][] left = new long[m][n];
        long[][] right = new long[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[i][j] = dp[i - 1][j] + points[i][j];
                    continue;
                }
                left[i][j] = Math.max(left[i][j - 1] - points[i][j - 1] + points[i][j] - 1, dp[i - 1][j] + points[i][j]);
            }
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    right[i][j] = dp[i - 1][j] + points[i][j];
                    continue;
                }
                right[i][j] = Math.max(dp[i - 1][j] + points[i][j], right[i][j + 1] - points[i][j + 1] + points[i][j] - 1);
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(left[i][j], right[i][j]);
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        P5815MaximumNumberofPointswithCost p = new P5815MaximumNumberofPointswithCost();
        int[][] a = {{2,4,0,5,5},{0,5,4,2,5},{2,0,2,3,1},{3,0,5,5,2}};
        System.out.println(p.maxPoints(a));
    }
}
