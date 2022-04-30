package com.leetCode._1th;

import java.util.Arrays;

/**

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * @author Zealot
 * @date 2015年9月13日 下午5:00:23
 */
public class PerfectSquares {
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
	}
	public static void main(String[] args) {
//		PerfectSquares p = new PerfectSquares();
//		System.out.println(p.numSquares(12));
		System.out.println(Integer.MAX_VALUE);
	}
}
