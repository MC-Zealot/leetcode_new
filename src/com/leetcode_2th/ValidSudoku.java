package com.leetcode_2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * @author Zealot
 * @date 2016年6月16日 下午7:52:53 
 *
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		if(m!=9||n!=9){
			return false;
		}
		//每一行都没有重复元素
		for(int i = 0; i < m; i ++) {
			Set<Character> set = new HashSet<Character>();
			for(int j = 0; j < n; j++) {
				if(board[i][j]=='.'){
					continue;
				}
				if(!set.contains(board[i][j])){
					set.add(board[i][j]);
				}else{
					return false;
				}
			}
		}
		//每一列都没有重复元素
		for(int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<Character>();
			for(int j = 0; j < m; j++) {
				if(board[j][i]=='.'){
					continue;
				}
				if(!set.contains(board[j][i])){
					set.add(board[j][i]);
				}else{
					return false;
				}
			}
		}
		//每一个九宫格没有重复元素
		for (int i = 0; i < m; i = i + 3) {
			for (int j = 0; j < n; j = j + 3) {
				Set<Character> set = new HashSet<Character>();
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						if(board[k][l]=='.'){
							continue;
						}
						if (!set.contains(board[k][l])) {
							set.add(board[k][l]);
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
    }
}
