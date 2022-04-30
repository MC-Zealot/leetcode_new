package com.leetCode._2th;
/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 * @author Zealot
 * @date 2016年1月10日 下午6:08:02
 */
public class Searcha2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		for(int col = 0; col < matrix[0].length; col++){
			for(int row = 0; row < matrix.length; row++) {
				if(target==matrix[row][col]){
					return true;
				}
			}
		}
		return false;
    }
}
