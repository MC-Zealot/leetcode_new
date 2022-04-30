package com.leetcode_2th;
/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * 
 * @author Zealot
 * @date 2016年6月18日 下午2:50:20 
 *
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int level = n / 2;
		for(int i = 0; i < level; i++) {
			for(int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[j][n - 1 -i];
				matrix[j][n - 1 -i] = matrix[i][j];
				int tmp2 = matrix[n - 1 -i][n - 1 - j];
				matrix[n - 1 -i][n - 1 - j] = tmp;
				int tmp3 = matrix[n - 1 - j][n - 1 -(n - 1 -i)];
				matrix[n - 1 - j][n - 1 -(n - 1 -i)] =tmp2;
				matrix[i][j] = tmp3;
			}
		}
    }
	public static void main(String[] args) {
//		int[][] matrix = {{1,2},{3,4}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		RotateImage r = new RotateImage();
		r.rotate(matrix);
	}
}
