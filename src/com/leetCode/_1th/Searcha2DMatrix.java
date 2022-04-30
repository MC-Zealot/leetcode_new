package com.leetCode._1th;
/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * @author Zealot
 * @date 2015年8月29日 下午3:40:08
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0) {
			return false;
		}
		int valRow = -1;
		int valCol = -1;
		for(int row = 1; row < matrix.length; row++) {
			if(matrix[row][0]>target){
				valRow=row-1;
				break;
			}
		}
		if(valRow==-1){
			valRow=matrix.length-1;
		}
		for(int col = 1; col<matrix[valRow].length; col++) {
			if(matrix[valRow][col]>target){
				valCol=col-1;
				break;
			}
		}
		if(valCol==-1){
			valCol=matrix[valRow].length-1;
		}
		if(matrix[valRow][valCol]==target){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][]	 a = new int[1][3];
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=3;
//		a[1][0]=10;
//		a[1][1]=11;
		Searcha2DMatrix s = new Searcha2DMatrix();
//		System.out.println(a.length);
		System.out.println(s.searchMatrix(a, 1));
	}
}
