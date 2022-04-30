package com.leetCode._2th;
/**
 *
 * @Description:
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
 * @author Zealot
 * @date 2016年2月14日 上午9:46:35
 *
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int reVal = m;
		for(int i = m+1; i < n; i++) {
			reVal = reVal&i;
			if(reVal==0){
				return 0;
			}
		}
		return reVal;
	}
	/**11010　　11011　　11100　　11101　　11110
	 * 是该数字范围内所有的数的左边共同的部分
	 * 之所以只计算m和n，是因为他们中间的数，不相同的位，一直都在变化。肯定不是共同的部分
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd2(int m, int n) {
		int d = Integer.MAX_VALUE;
		while ((m & d) != (n & d)) {
			d <<= 1;
		}
		return m & d;
	}
	public static void main(String[] args) {
		BitwiseANDofNumbersRange b = new BitwiseANDofNumbersRange();
		System.out.println(b.rangeBitwiseAnd(700000000, 2147483641));
	}
}
