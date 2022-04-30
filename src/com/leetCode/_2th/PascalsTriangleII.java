package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * @author Zealot
 * @date 2016年1月16日 下午12:46:02
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if(rowIndex<0){
            return list;
        }
        list.add(1);
        if(rowIndex==0){
            return list;
        }
        
        for(int i = 0; i < rowIndex; i++){
            list.add(0,0);
            list.add(0);    
             List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j < list.size() -1; j++) {
               tmp.add(list.get(j)+list.get(j+1)); 
            }
            list = tmp;
        }
        return list;
    }
    public static void main(String[] args) {
    	PascalsTriangleII pt2 = new PascalsTriangleII();
    	System.out.println(pt2.getRow(4));
	}
}
