package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月11日 上午10:19:23 
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0){
			return true;
		}
		if (board == null || board.length == 0 || board[0].length == 0){
			return false;
		}
		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(search(board, word, 0, i, j, used)){
					return true;
				}
			}
		}
		
		return false;
    }
	private boolean search(char[][] board, String word, int index, int i, int j, boolean[][] used) {
		if (index == word.length()){
			return true;
		}
		if(i<0||j<0||i>=board.length||j>=board[0].length||used[i][j]||word.charAt(index)!=board[i][j]){
			return false;
		}
		used[i][j] = true;
		boolean res = search(board, word, index + 1, i - 1, j, used)
						|| search(board, word, index + 1, i + 1, j, used)
						|| search(board, word, index + 1, i, j - 1, used)
						|| search(board, word, index + 1, i, j + 1, used);
		used[i][j] = false;
		
		return res;
	}
}
