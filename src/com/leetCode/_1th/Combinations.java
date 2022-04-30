package com.leetCode._1th;

import java.util.ArrayList;
import java.util.List;

/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author Zealot
 * @date 2015年9月4日 下午10:17:03
 */
public class Combinations {
	public  List<List<Integer>> combine(int n, int k) {
		return combine(1, n, k);//在数学中，计算组合的时候，是从1开始的
	}

	private List<List<Integer>> combine(int start, int end, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k > (end - start + 1) || k < 1 || start > end){
			return res;
		}
		if (k == 1) {
			for (int i = 0; i < end - start + 1; i++) {
				List<Integer> sublist = new ArrayList<Integer>();
				sublist.add(start + i);
				res.add(sublist);
			}
		}else{
			for (int i = 0; i < end - start + 2 - k; i++) {//减k加1，是因为排列中，如果n=4,k=3,第一位取1或者2,剩下只有3或者四，此时，k还剩2个， 就没有必要挑选了
				List<List<Integer>> subres = combine(start + i + 1, end, k - 1);
				for (List<Integer> l : subres) {
					l.add(0, start + i);
				}
				res.addAll(subres);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));
	}
}
