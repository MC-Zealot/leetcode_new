package com.leetcode_6th;

public class PaintFence {
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = k;
        dp[1] = k * k;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1]*(k - 1) + dp[i - 2] * (k - 1);
        }

        return dp[n - 1];
    }
}
