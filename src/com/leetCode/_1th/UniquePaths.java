package com.leetCode._1th;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author Zealot
 * @date 2015年8月5日 下午9:04:19
 */
public class UniquePaths {
	private static int sum = 0;
	public int uniquePaths(int m, int n) {
		 if(m==1||n==1){
			 return 1;
		 }
		 uniquePaths2(m, n);
			return sum;
	}
	public int uniquePaths2(int m, int n) {
		if(n==0||n==1 ||m==0||m==1){
			return 1;
		}
		sum+=(m-1)+(n-1);
		return uniquePaths2(m-1, n-1);
	}
	public int uniquePaths3(int m, int n) {
		 if(m<=1||n<=1){
			 return 1;
		 }
		 return uniquePaths3(m-1, n)+uniquePaths3(m, n-1);
	}
	public int uniquePaths4(int m, int n) {
		 if(m<=1||n<=1){
			 return 1;
		 }
		 int[][] D = new int[m][n];
		 //把边界都附上初值1，因为如果边长为1，另一个边无论为多长，总的可走的方法，只有1种。
		    for(int i = 0; i < m; i++){ 
		        D[i][0] = 1;
		    }
		
		    for(int j = 0; j < n; j++){
		        D[0][j] = 1;
		    }
		    for(int i = 1; i < m; i++){
		        for(int j = 1; j < n; j++){
		            D[i][j] = D[i - 1][j] + D[i][j - 1];
		        }
		    }
		   return D[m-1][n-1]; 
	}
	public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		System.out.println(u.uniquePaths4(3, 3));
//		System.out.println(sum);
	}
}
