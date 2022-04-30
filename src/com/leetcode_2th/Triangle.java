package com.leetcode_2th;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


 * @author Zealot
 * @date 2016年6月24日 下午4:37:09 
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null||triangle.size()==0){
			return 0;
		}
		
		int[] res = new int[triangle.get(triangle.size() - 1).size()];
        for(int i = 0; i < triangle.size(); i++){
        	int[] tmp = new int[res.length];
        	System.arraycopy(res, 0, tmp, 0, res.length);
        	for(int j = 0; j < triangle.get(i).size(); j++) {
        		if(j==0){
        			res[j]= triangle.get(i).get(j) + tmp[j];
        		}else if(j == triangle.get(i).size() - 1){
        			res[j]= triangle.get(i).get(j) + tmp[j - 1];
        		}else{
        			res[j]= triangle.get(i).get(j) + Math.min(tmp[j - 1], tmp[j]);
        		}
        	}
        }
        //find smallest
        int min = res[0];
        for(int i = 0; i < res.length; i++) {
        	if(min > res[i]){
        		min = res[i];
        	}
        }
		return min;
    }
	public static void main(String[] args) {
		Triangle t = new Triangle();
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(2);
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new LinkedList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new LinkedList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(t.minimumTotal(triangle));
	}
}
