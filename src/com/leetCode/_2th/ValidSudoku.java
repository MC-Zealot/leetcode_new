package com.leetCode._2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Created by Zealot on 16/2/11.
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean reVal = false;
		if(board.length == 0){
			return reVal;
		}
		//每一行是否合法
		for(int row = 0; row < board.length; row++){
			char[] a = board[row];
			reVal = isSubValid(a);
			if(!reVal){
				return  reVal;
			}
		}
		//每一列是否合法
		for(int col = 0; col < board.length; col++){
			char[] a = new char[9];
			for(int i = 0; i < 9; i++) {
				a[i] = board[i][col];
			}
			reVal = isSubValid(a);
			if(!reVal){
				return  reVal;
			}
		}
		//每一个九宫格是否合法
		for(int row = 0; row < 9; row = row + 3){
			for(int col = 0; col < 9; col = col +3){

				char[] a = getSubSudoku(board,row,col);
				reVal = isSubValid(a);
				if(!reVal){
					return  reVal;
				}
			}
		}
		return true;
	}

	/**
	 * 判断子集是否合法.
	 * 子集包括一行,一列,一个子9宫格
	 * @param a
	 * @return
	 */
	private boolean isSubValid(char[] a){
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < a.length; i++){
			if(set.contains(a[i])&&!".".equals(String.valueOf(a[i]))){
				return false;
			}
			set.add(a[i]);
		}

		return true;
	}

	/**
	 * 获取子九宫格
	 * @param a
	 * @param row 从哪一行开始
	 * @param col 从哪一列开始
	 * @return
	 */
	private char[] getSubSudoku(char[][] a, int row, int col){
		char[] subSudoku = new char[9];
		int length = row+3;
		int height = col+3;
		int index = 0;
		for(int i = row; i<length; i++){
			for(int j = col ; j < height; j++) {
				subSudoku[index++] = a[i][j];
			}
		}

		return subSudoku;
	}

	public static void main(String[] args) {
		ValidSudoku v = new ValidSudoku();
//		char[][] board = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		String[] board2 = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] board= new char[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j]=board2[i].charAt(j);
				System.out.print(" "+board[i][j]);
			}
			System.out.println();
		}
		System.out.println(v.isValidSudoku(board));
	}
}
