package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 * 
 * @author Zealot
 * @date 2016年7月10日 下午1:35:57 
 *
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
        if(rowIndex==0){
        	return res;
        }
        
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        if(rowIndex==1){
        	return list1;
        }
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        if(rowIndex==2){
        	return list2;
        }
        List<Integer> pre = new ArrayList<Integer>(list2);
        for(int i = 2; i < rowIndex; i++) {
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int j = 0; j < i+1; j++) {//下标i是从0计数，要算到第i+1个真是的位置
        		if(j==0||j==i ){
        			list.add(1);
        		}else{
        			list.add(pre.get(j-1)+pre.get(j));
        		}
        	}
        	pre = new ArrayList<Integer>(list);
        }
		return pre;
    }
}
