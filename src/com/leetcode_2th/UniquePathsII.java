package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月31日 上午11:49:15 
 *
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] a = new int[m][n];
		for(int i = 0; i < n; i++) {
			if(obstacleGrid[0][i]==1){
				break;
			}
			a[0][i] = 1;
		}
		for(int i = 0; i < m; i++) {
			if(obstacleGrid[i][0]==1){
				break;
			}
			a[i][0] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j]==0){
					
					a[i][j] = a[i - 1][j] + a[i][j - 1];
				}else{
					a[i][j] = 0;
				}
			}
		}
		return a[m - 1][n - 1];
    
    }

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int[] res = new int[obstacleGrid[0].length];
		res[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[j] = 0;
				} else {
					if (j > 0)
						res[j] += res[j - 1];
				}
			}
		}
		return res[obstacleGrid[0].length - 1];
	}

}
