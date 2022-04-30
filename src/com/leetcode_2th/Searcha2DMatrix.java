package com.leetcode_2th;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

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
 * 
 * @author Zealot
 * @date 2016年7月7日 上午10:15:08 
 *
 */
public class Searcha2DMatrix {
	/**
	 * runtime complexity: O(m+logn)
	 * @date 2016年7月7日 上午10:40:34
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int i = 0;
		for (; i < matrix.length; i++) {
			int first = matrix[i][0];
			if(first==target){
				return true;
			}else if(first > target){
				if(i==0){
					return false;
				}
				break;
			}
		}
		i--;
		int l = 0, r = matrix[0].length - 1;
		while(l <= r){
			int m = l + (r - l) / 2;
			if(matrix[i][m] == target){
				return true;
			}else if(matrix[i][m] > target){
				r = m - 1;
			}else {
				l = m + 1;
			}
		}
		return false;
	}
	/**
	 * runtime complexity: O(logm + logn)
	 * @date 2016年7月7日 上午10:51:15
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int heigth = matrix.length;
		int width = matrix[0].length;

		if (matrix[0][0] > target || matrix[heigth - 1][width - 1] < target){
			return false;
		}

		int head = 0;
		int tail = heigth - 1;
		int mid;
		while (head != tail && matrix[tail][0] > target) {
			mid = (head + tail + 1) / 2;
			if (matrix[mid][0] < target){
				head = mid;
			}
			else if (matrix[mid][0] > target){
				tail = mid - 1;
			}
			else{
				return true;
			}
		}
		int row = tail;
		head = 0;
		tail = width - 1;
		while (head <= tail) {
			mid = (head + tail) / 2;
			if (matrix[row][mid] < target)
				head = mid + 1;
			else if (matrix[row][mid] > target)
				tail = mid - 1;
			else
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		Searcha2DMatrix s = new Searcha2DMatrix();
		s.searchMatrix(matrix, 3);
	}
}
