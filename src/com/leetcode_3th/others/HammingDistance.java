package com.leetcode_3th.others;


/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。

 * 
 * @author Zealot
 * @date Aug 2, 2019 4:32:30 PM 
 *
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int tmp = x^y;
		int res = 0;
		while(tmp>0) {
			if((tmp & 1) == 1) {
				res++;
			}
			tmp = tmp>>1;
		}
		return res;
	}
	public static void main(String[] args) {
		HammingDistance h = new HammingDistance();
		System.out.println(h.hammingDistance(1, 4));
	}
}
