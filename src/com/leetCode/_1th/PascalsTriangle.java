package com.leetCode._1th;

import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author Zealot
 * @date 2015年9月7日 下午9:35:20
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if(numRows<=0){
			return list;
		}
		List<Integer> tmpList = new LinkedList<Integer>();
		tmpList.add(1);
		list.add(tmpList);
		for(int i = 1; i < numRows; i++) {
			List<Integer> realList = new LinkedList<Integer>();
			for(int j = 0; j < list.get(list.size()-1).size(); j++ ) {
				realList.add(list.get(list.size()-1).get(j));
			}
			realList.add(0, 0);
			realList.add(0);
			List<Integer> reList = new  LinkedList<Integer>();
			for(int j = 0; j < realList.size()-1; j++) {
				reList.add(realList.get(j)+realList.get(j+1));
			}
			list.add(reList);
		}
		
		return list;
	}
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		System.out.println(p.generate(6).toString());
	}
}