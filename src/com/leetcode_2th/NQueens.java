package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 

where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * 
 * @author Zealot
 * @date 2016年7月13日 下午2:47:33 
 *
 */
public class NQueens {
    private int[] x ; //当前解

    public void init(int n){
        x = new int[n+1];  //x[i]表示皇后i放在棋盘的第i行的第x[i]列
    }
    public boolean place (int k){
        for (int j = 1 ; j < k ; j++){
            //这个主要是刷选符合皇后条件的解，因为皇后可以攻击与之同一行同一列的或同一斜线上的棋子
            if ( (Math.abs(k - j)) == (Math.abs(x[j]-x[k])) || (x[j] == x[k]) ){
                return false ;  //如果是与之同一行同一列的或同一斜线上的棋子，返回false;
            }
        }
        return true ;//如果不是与之同一行同一列的或同一斜线上的棋子，返回true;
    }
    public void backTrace (int t, List<List<String>> res, List<String> tmp, int n){
        if (t > n){  //当t>n时,算法搜索到叶节点，得到一个新的n皇后互不攻击放置方案，方案数加1
//        	for(int i = 0 ; i < tmp.size(); i++) {
//        		System.out.println(tmp.get(i));
//        	}
        	res.add(new ArrayList<String>(tmp));
//            System.out.print ("\n----------------\n");//华丽的分割线
        }else { //当t<=n时，当前扩展的结点Z是解空间中的内部结点，该节点有x[i]=1,2，…,n共n个子结点，
                //对于当前扩展结点Z的每一个儿子结点，由place()方法检测其可行性，
                //并以深度优先的方式递归地对可行子树搜索，或剪去不可行子数
            for (int i = 1 ; i <= n ; i++){
                x[t] = i ;
                StringBuffer sb = new StringBuffer();
                for(int j = 1; j <= n; j++) {
                	if(j!=i){
                		sb.append(".");
                	}else{
                		sb.append("Q");
                	}
                }
                tmp.add(sb.toString());
                if (place (t)){     //检查结点是否符合条件
                    backTrace (t+1, res, tmp,n);    //递归调用
                }
                tmp.remove(tmp.size() - 1);
            }
        }
    }
	public List<List<String>> solveNQueens(int n) {
		init(n);
		List<List<String>> res = new ArrayList<List<String>>();
		backTrace(1, res, new ArrayList<String>(),n);
		return res;
    }
	public static void main(String[] args) {
		NQueens n = new NQueens();
		n.solveNQueens(8);
	}
}
