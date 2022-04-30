package com.leetCode._1th;
/**
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * @author Zealot
 * @date 2015年8月21日 上午8:02:43
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] a = new int[n][n];
		if(n>1){
			for(int y = 0; y < n; y++){
				for(int x = 0; x < n; x++) {
					a[x][n-y-1]=matrix[y][x];
				}
			}
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					matrix[y][x] = a[y][x];
				}
			}
		}
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < n; j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}
	public static void main(String[] args) {
		int n = 2;
		int[][] matrix = new int[n][n];
		int index=1;
		for(int y = 0 ; y < n; y++){
			for(int x = 0; x < n; x++) {
				matrix[y][x]= index++;
			}
		}
		RotateImage r = new RotateImage();
		r.rotate(matrix);
	}
}
