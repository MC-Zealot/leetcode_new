package com.leetcode_3th.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 输入: m = 3, n = 2 输出: 3 
 * 解释: 从左上角开始，总共有 3 条路径可以到达右下角。 
 * 1. 向右 -> 向右 -> 向下 
 * 2. 向右 -> 向下 -> 向右 
 * 3. 向下 -> 向右 -> 向右 
 * 
 * 示例 2:
 * 输入: m = 7, n = 3 输出: 28
 * 
 * 
 * @author Zealot
 * @date Jul 21, 2019 11:03:15 AM
 *
 */
public class UniquePaths {
	/**
	 * 思路错误
	 * @date Jul 21, 2019 11:51:09 AM
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		int res = 1;
		if(m==0||n==0) {
			return 0;
		}
		if(m==1||n==1) {
			return res;
		}
		//1算正方形，
		//还有剩下的分成2块。
		//之后再相乘
		int min = Math.min(m, n);
		int max = Math.max(m, n);
		if(max-min>1) {
			while((max - min) >1) {
				res*=calCube(min);
				max = max - min;
				int tmpMax = Math.max(min, max);
				int tmpMin = Math.max(min, max);
				max = tmpMax;
				min = tmpMin;
			}
		}
		
		System.out.println(res);
		System.out.println(min+","+max);
		if((max-min)==1) {
			System.out.println("1:"+res);
			res*=(calCube(min)+1);
		}
		if(max==min) {
			res*=calCube(max);
		}
		return res;
	}
	public int calCube(int n){
		int res=1;
		for(int i = 0; i < n-1; i++) {
			res*= (i+2);
		}
		return res;
	}
	/**
	 * O(n^2)
	 * @date Jul 21, 2019 12:10:42 PM
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
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
			}
		}
		return a[m - 1][n - 1];
    }
	public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		System.out.println(u.uniquePaths(7, 3));
	}
}
