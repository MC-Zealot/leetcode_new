package com.leetCode._2th;
/**
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 * 判断正、负、整数边界,防止溢出
 * @author Zealot
 * @date 2016年3月11日 下午8:23:39 
 *
 */
public class DivideTwoIntegers {
	/**
	 * TLE
	 * @date 2016年6月12日 上午9:52:22
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	@Deprecated
	public int divide(int dividend, int divisor) {
		if(dividend == 0 ){
			return 0;
		}
		
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		boolean flag = false;
		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
			flag = true;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int count = 0;
		while (dividend >= 0) {
			if (count > count + 1) {
				return Integer.MAX_VALUE;
			}
			count++;
			dividend = dividend - divisor;
		}
		--count;
		if(flag){
			count = -count;
		}
		
		return count;
    }

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
				res += 1 << digit;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -res : res;
	}

	public static void main(String[] args) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-12, -0));
	}
}
