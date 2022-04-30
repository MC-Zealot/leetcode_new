package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], 
 *   [ 4, 5, 6 ], 
 *   [ 7, 8, 9 ] ] 
 *You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author Zealot
 * @date 2016年3月14日 下午8:20:50
 *
 */

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return res;
		}
		int min = Math.min(matrix.length, matrix[0].length);
		int levelNum = min / 2;
		for (int level = 0; level < levelNum; level++) {
			for (int i = level; i < matrix[0].length - level - 1; i++) {
				res.add(matrix[level][i]);
			}
			for (int i = level; i < matrix.length - level - 1; i++) {
				res.add(matrix[i][matrix[0].length - 1 - level]);
			}
			for (int i = matrix[0].length - 1 - level; i > level; i--) {
				res.add(matrix[matrix.length - 1 - level][i]);
			}
			for (int i = matrix.length - 1 - level; i > level; i--) {
				res.add(matrix[i][level]);
			}
		}
		if (min % 2 == 1) {
			if (matrix.length < matrix[0].length) {
				for (int i = levelNum; i < matrix[0].length - levelNum; i++) {
					res.add(matrix[levelNum][i]);
				}
			} else {
				for (int i = levelNum; i < matrix.length - levelNum; i++) {
					res.add(matrix[i][levelNum]);
				}
			}
		}
		return res;
	}
	@Deprecated
	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return res;
		}
		int min = Math.min(matrix.length, matrix[0].length);
		
		int levelNum = (int)Math.ceil(min/2.);
		for (int level = 0; level < levelNum; level++) {
			for (int i = level; i < matrix[0].length - level; i++) {
				res.add(matrix[level][i]);
			}
			for (int i = level + 1; i < matrix.length - level; i++) {
				res.add(matrix[i][matrix[0].length - 1 - level]);
			}
			for (int i = matrix[0].length - 2 - level; i >= level; i--) {
				res.add(matrix[matrix.length - 1 - level][i]);
			}
			for (int i = matrix.length - 2 - level; i > level; i--) {
				res.add(matrix[i][level]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{2,3}};
		List<Integer> list = sm.spiralOrder2(matrix);
		for(Integer i: list){
			System.out.println(i);
		}
	}
}
