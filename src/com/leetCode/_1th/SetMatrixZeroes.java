package com.leetCode._1th;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 * @author Zealot
 * @date 2015年8月31日 下午10:01:02
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int[][] extraMatrix = new int[matrix.length][matrix[0].length];//把0位放到另一个矩阵里边，记住
		for(int m = 0; m < matrix.length; m++) {
			for(int n = 0; n < matrix[m].length; n++) {
				if(matrix[m][n]==0){
					setZero(extraMatrix, m, n);
				}
			}
		}
		for(int m = 0; m < matrix.length; m++) {//把记住的0位，改变原来的矩阵
			for(int n = 0; n < matrix[m].length; n++) {
				if(extraMatrix[m][n]==1){
					matrix[m][n]=0;
				}
			}
		}
		
	}
	public void setZero(int[][] extraMatrix,int m, int n) {
		for(int mIndex = 0; mIndex < extraMatrix.length; mIndex++){
			extraMatrix[mIndex][n] = 1; 
		}
		for(int nIndex = 0; nIndex < extraMatrix[m].length; nIndex++){
			extraMatrix[m][nIndex]=1;
		}
	}
	public static void main(String[] args) {
		
	}
}
