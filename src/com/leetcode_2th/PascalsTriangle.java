package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zealot
 * @date 2016年6月11日 上午8:54:41 
 *
 */
public class PascalsTriangle {
	/**
	 * TIME:O(1+2+3+...+n)=O(n^2)
	 * @date 2016年6月11日 上午9:49:55
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0){
        	return res;
        }
        
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        res.add(list1);
        if(numRows==1){
        	return res;
        }
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        res.add(list2);
        if(numRows==2){
        	return res;
        }
        List<Integer> pre = new ArrayList<Integer>(list2);
        for(int i = 2; i < numRows; i++) {
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int j = 0; j < i+1; j++) {//下标i是从0计数，要算到第i+1个真是的位置
        		if(j==0||j==i ){
        			list.add(1);
        		}else{
        			list.add(pre.get(j-1)+pre.get(j));
        		}
        	}
        	pre = new ArrayList<Integer>(list);
        	res.add(list);
        }
		return res;
    }
	/**
	 * 
	 * @date 2016年6月11日 上午9:50:44
	 * @param numRows
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> generate2(int numRows) {  
	     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	     if(numRows<=0)  
	        return res;  
	     ArrayList<Integer> pre = new ArrayList<Integer>();  
	     pre.add(1);  
	     res.add(pre);  
	     for(int i=2;i<=numRows;i++)  
	     {  
	         ArrayList<Integer> cur = new ArrayList<Integer>();  
	         cur.add(1);  
	         for(int j=0;j<pre.size()-1;j++)  
	         {  
	             cur.add(pre.get(j)+pre.get(j+1));  
	         }  
	         cur.add(1);  
	         res.add(cur);  
	         pre = cur;  
	     }  
	     return res;  
	}  
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		p.generate(4);
	}
}
