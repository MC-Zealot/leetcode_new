package com.leetCode._2th;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @Description
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @author Zealot
 * @date 2016年2月12日 下午4:47:55
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()==0) {
			return 0;
		}


		if(triangle.size()==1) {
			return triangle.get(0).get(0);
		}
		List<List<Integer>> triangleSum = new LinkedList<List<Integer>>();

		int min_sum = 0;


		int sumHead = 0;
		int sumTail = 0;
		List<Integer> ll = new LinkedList<Integer>();
		ll.add(triangle.get(0).get(0));
		sumHead = sumHead + triangle.get(0).get(0);
		sumTail = sumTail + triangle.get(0).get(0);
		triangleSum.add(ll);
		for(int i = 1; i < triangle.size(); i++) {
			sumHead=sumHead+triangle.get(i).get(0);
			List<Integer> l = new LinkedList<Integer>();
			l.add(sumHead);
			triangleSum.add(l);
		}
		for(int i = 1; i < triangle.size(); i++) {
			sumTail=sumTail+triangle.get(i).get(i);
			List<Integer> l = triangleSum.get(i);
			l.add(sumTail);
			triangleSum.add(l);
		}
		if(triangle.size()>2) {
			for(int i = 2; i < triangle.size(); i++) {
				List<Integer> l = triangleSum.get(i);
				List<Integer> l_1 = triangleSum.get(i-1);
				for(int j = 1; j < i; j++) {
					int tmp = Math.min(l_1.get(j-1), l_1.get(j));
					int last = l.get(l.size()-1);
					l.remove(l.size()-1);
					l.add(tmp+triangle.get(i).get(j));
					l.add(last);
				}
			}
		}


		List<Integer> list = triangleSum.get(triangleSum.size()-1);
		min_sum = list.get(0);
		for(Integer i : list) {
			if(min_sum> i){
				min_sum = i;
			}
		}

		return min_sum;
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
