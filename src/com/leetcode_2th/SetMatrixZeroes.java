package com.leetcode_2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * @author Zealot
 * @date 2016年6月30日 下午3:32:59 
 *
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		Set<Integer> h = new HashSet<Integer>();//横坐标
		Set<Integer> z = new HashSet<Integer>();//纵坐标
		
		//遇到0，记录该行号和列号
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0){
					h.add(i);
					z.add(j);
				}
			}
		}
		//-1变为0
		//横坐标
		for(int i : h) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
		for(int i : z) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[j][i] = 0;
			}
		}
    }
}
