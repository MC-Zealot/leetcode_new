package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 

A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

0  　　 000    000
1  　　 001    001
2   　　011    010
3   　　010    011
4   　　110    100
5   　　111    101
6   　　101    110
7   　　100    111
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * @author Zealot
 * @date 2016年6月30日 下午2:35:21 
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int size = 1 << n;
		for (int i = 0; i < size; i++) {
			res.add((i >> 1) ^ i);// 异或：留下不一样的，第一位不变
		}
		return res;
    }
}
