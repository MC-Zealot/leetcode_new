package com.leetCode._1th;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * 
 * @author Zealot
 * @date 2015年8月12日 下午9:02:40
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int size = 1<<n;
		for(int i = 0; i < size; i++) {
			list.add((i>>1)^i);//异或：留下不一样的，第一位不变
		}
		return list;
	}
	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		List<Integer> list = g.grayCode(2);
		System.out.println(list.toString());
		
	}
}
