package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Zealot
 * @date 2016年5月30日 上午9:57:44 
 *
 */
public class UniquePaths {
	/**
	 * SPACE:O(N^2)
	 * @date 2016年5月30日 上午10:07:26
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		int[][] a = new int[m][n];
		for(int i = 0; i < n; i++) {
			a[0][i] = 1;
		}
		for(int i = 0; i < m; i++) {
			a[i][0] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				a[i][j] = a[i - 1][j] + a[i][j - 1];
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		return a[m - 1][n - 1];
    }
	public int uniquePaths2(int m, int n) {
		int[] up = new int[n];
		int[] cur = new int[n];
		cur[0] = 1;
		
		for(int i = 0; i < n; i++) {
			up[i] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				cur[j] = up[j] + cur[j - 1];
			}
			up = cur;
		}
		return up[n - 1];
	}

	public int uniquePaths3(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] += res[j - 1];
			}
		}
		return res[n - 1];
	}

	public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		int m = 1,n=2;
		System.out.println(u.uniquePaths(m, n));
		System.out.println(u.uniquePaths2(m, n));
		Map map = new HashMap();
	}
}
