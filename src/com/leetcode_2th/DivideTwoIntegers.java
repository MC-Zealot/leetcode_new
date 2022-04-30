package com.leetcode_2th;
/**
 * 任何一个整数可以表示成以2的幂为底的一组基的线性组合
 * a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
 * 
 * @author Zealot
 * @date 2016年6月11日 上午11:55:55 
 *
 */
public class DivideTwoIntegers {
	/**
	 * TLE
	 * runtime: O(n)
	 * @date 2016年6月11日 下午12:13:49
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		if(divisor==0){
			return Integer.MIN_VALUE;
		}
		boolean flag = false;
		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
			flag = true;
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
		}
		
		int i = 0;
		int k = 0;
        while(i<dividend){
        	i+=divisor;
        	k++;
        }
        if(flag){
			k = -k;
		}
		return k;
    }
	/**
	 * RUNTIME:O(logn)
	 * @date 2016年6月12日 上午10:10:46
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide2(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			res++;
		}
		if (divisor == Integer.MIN_VALUE) {
			return res;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1;
			digit++;
		}
		while (digit >= 0) {
			if (dividend >= divisor) {
				int t = 1 << digit;
				res += t;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -res : res;

	}
	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide2(20, 4));
	}
}
