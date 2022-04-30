package com.WebTest.booking;

import java.util.ArrayList;
import java.util.List;

public class Webtest {
	public int testname(){
		//堆排序
		//1             1
//		2   5           2    
//	  3  4 6  7         4
//		                8
//当插入一个节点，判断根节点，如果是小于根节点，则插入在左边节点
//如果是大于根节点，则插入在右节点
		int[] a ={1,2,5,3,4,6,7};
		
		
		
		
		int[] b = {4,3,-1,6,-10,1};
		List<List> ret = new ArrayList<List>();
		
		//数组，连续子序列（有正有负），开始、结束位置、和最大。可能有多个。
		int local_max = a[0]; 
		int globle_max = a[0];
		for(int i = 0; i < a.length; i++) {
			if(local_max+a[i] > a[i]) {
				local_max=local_max+a[i];
			}else {
				local_max = a[i]; 
			}
			if(local_max> globle_max) {
				globle_max = local_max;
			}
			
		}
		return globle_max;
	}
	
}
