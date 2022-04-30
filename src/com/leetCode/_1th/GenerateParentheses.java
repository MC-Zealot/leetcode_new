package com.leetCode._1th;

import java.util.ArrayList;
import java.util.List;

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
1 () 
  12
2 (()), ()()  
  1122  1212  
3 ((())), (()()), (())(), ()(()), ()()()
  111222  112122  112212  121122  121212


 * @author Zealot
 * @date 2015年8月13日 下午7:52:35
 */
public class GenerateParentheses {
	int All = 0;
	char[] cc;
	int left;
	int right;
	static List<String> list = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		
		int size = n;
		All=size*2;
		cc=new char[All+1];
		left = n;
		right = n;
		backTrace(1);
		
		return list;
	}
	private boolean placeLeft( int p){
		cc[p]= '(';
		if(left>0){
			left--;
			return true;
		}
		return false;
	}
	private boolean placeRight( int p){
		cc[p]= ')';
		if(left<right&&right>0){
			right--;
			return true;
		}
		return false;
	}
	private void backTrace(int p) {
		if(p>All){
			list.add(String.valueOf(cc));
		}else{
			for(int i = 1;i < All; i++){
				if(placeLeft(p)){
					backTrace(p+1);
				}else if(placeRight(p)){
					backTrace(p+1);
				}
				
			}
		}
	}
	
	public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		
		System.out.println(g.generateParenthesis2(3));
	}
}
