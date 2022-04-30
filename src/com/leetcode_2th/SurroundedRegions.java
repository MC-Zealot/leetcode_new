package com.leetcode_2th;

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * 
 * @author Zealot
 * @date 2016年7月11日 上午11:40:23 
 *
 */
public class SurroundedRegions {
	/**
	 * DFS
	 * TLE
	 * @date 2016年7月11日 下午12:13:01
	 * @param board
	 */
	public void solve(char[][] board) {
//		printBoard(board);
		if(board.length<3 || board[0].length<3) return;
		for(int i = 0; i < board[0].length; i++) {
			if(board[0][i]=='O'){
				dfs(board, 0, i);
			}
			if(board[board.length - 1][i]=='O'){
				dfs(board, board.length - 1, i);
			}
		}
		for(int i = 0; i < board.length; i++) {
			if(board[i][0] == 'O'){
				dfs(board, i, 0);
			}
			if(board[i][board[0].length - 1] =='O'){
				dfs(board, i, board[0].length - 1);
			}
		}
		changeBoard(board, 'O', 'X');
		changeBoard(board, 'Q', 'O');
//		System.out.println();
//		printBoard(board);
    }
	private void printBoard(char[][] board) {
		for(int i = 0; i <board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	private void changeBoard(char[][] board, char from, char to) {
		for(int i = 0; i <board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j]==from){
					board[i][j] = to;
				}
			}
		}
	}
	private void dfs(char[][] board, int x, int y) {
		if ( x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O') {
			board[x][y] = 'Q';
			dfs(board, x - 1, y);
			dfs(board, x, y - 1);
			dfs(board, x + 1, y);
			dfs(board, x, y + 1);
		}
	}
	
	
	
	
	
	
	
	
	public void solve2(char[][] board) {
		if(board.length<3 || board[0].length<3) return;
        fillBorders(board, 'O', 'Y');
        replace(board, 'O', 'X');
        fillBorders(board, 'Y', 'O');
    }
	public void fill(char[][] board, int i, int j, char target, char c) {
	        int m = board.length, n = board[0].length;
	        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=target) return;
	        Stack<String> s = new Stack<String>();
	        s.push(i+","+j);
	        
	        while(!s.isEmpty()) {
	        	String str =  s.pop();
	            i = Integer.parseInt(str.split(",")[0]);
	            j = Integer.parseInt(str.split(",")[1]);
	           
	            board[i][j] = c;
	            if(i>0 && board[i-1][j]==target) s.push((i-1)+","+j);
	            if(i<m-1 && board[i+1][j]==target) s.push((i+1)+","+j);
	            if(j>0 && board[i][j-1]==target) s.push(i+","+(j-1));
	            if(j<n-1 && board[i][j+1]==target) s.push(i+","+(j+1));
	        }
	}
	    
	    public void fillBorders(char[][] board, char target, char c) {
	        int m = board.length, n = board[0].length;
	        for(int i=0; i<m; i++) {
	            if(board[i][0]==target) fill(board, i, 0, target, c);
	            if(board[i][n-1]==target) fill(board, i, n-1, target, c);
	        }
	        
	        for(int j=1; j<n-1; j++) {
	            if(board[0][j]==target) fill(board, 0, j, target, c);
	            if(board[m-1][j]==target) fill(board, m-1, j, target, c);
	        }
	    }
	    
	    
	    public void replace(char[][] board, char target, char c) {
	    	int m = board.length, n = board[0].length;
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                if(board[i][j]==target)
	                    board[i][j] = c;
	            }
	        }
	    }
	public static void main(String[] args) {
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		s.solve(board);
	}
}
