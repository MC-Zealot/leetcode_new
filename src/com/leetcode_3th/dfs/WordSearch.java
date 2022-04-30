package com.leetcode_3th.dfs;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board = [ 
 * 	['A','B','C','E'], 
 * 	['S','F','C','S'], 
 * 	['A','D','E','E'] 
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true. 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 * @author Zealot
 * @date Jul 21, 2019 3:11:16 PM
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0){
			return true;
		}
		if(board.length==0||board[0].length==0) {
			return false;
		}
		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(dfs(board, used, 0, word, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean dfs(char[][] board, boolean[][] used, int index, String word, int i, int j) {
		if (index == word.length()){
			return true;
		}
		if(i<0||j<0||i>=board.length||j>=board[0].length||used[i][j]||word.charAt(index)!=board[i][j]){
			return false;
		}
		used[i][j] = true;
		boolean res = dfs(board, used, index + 1, word, i - 1, j)
					|| dfs(board, used, index + 1, word, i + 1, j)
					|| dfs(board, used, index + 1, word, i, j - 1)
					|| dfs(board, used, index + 1, word, i, j + 1);
		used[i][j] = false;
		
		return res;
	}
}
