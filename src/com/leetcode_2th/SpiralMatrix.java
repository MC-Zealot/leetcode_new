package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月27日 下午4:01:28 
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length==0){
			return res;
		}
		int size = matrix.length * matrix[0].length;
		int row = matrix.length;
		int col = matrix[0].length;
		int round = 0;
		for(int i = 0; i < size; ) {
			for(int a = round; a < col - round && i < size; a++) {
				res.add(matrix[round][a]);
				i++;
			}
			for(int b = round + 1; b < row - round && i < size; b++) {
				res.add(matrix[b][col - round -1]);
				i++;
			}
			for(int c = col - round - 2; c >= round && row >1 && i < size; c--) {
				res.add(matrix[row-round -1][c]);
				i++;
			}
			for(int d = row - round -2; d >=round + 1 && col > 1&& i < size; d--) {
				res.add(matrix[d][round]);
				i++;
			}
			round++;
		}
		
		return res;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralMatrix s = new SpiralMatrix();
		List<Integer> l = s.spiralOrder(matrix);
		for(Integer i: l) {
			System.out.print(i + "\t");
		}
	}
}
