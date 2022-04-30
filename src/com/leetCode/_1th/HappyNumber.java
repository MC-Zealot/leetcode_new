package com.leetCode._1th;

/**
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * 无限循环，用f(n)与f(n+1),如果相等，则无线循环
 * @author Zealot
 * @date 2015年8月22日 下午9:04:20
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		int x = n;
		int y = n;
		while (x > 1) {
			x = cal(x);
			if (x == 1){
				return true;
			}
			y = cal(cal(y));
			if (y == 1){
				return true;
			}

			if (x == y){
				return false;
			}
		}
		return true;
	}

	private int cal(int x) {
		String str = String.valueOf(x);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Math.pow(Double.parseDouble(String.valueOf(str.charAt(i))),2);
		}
		return sum;
	}

	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		System.out.println(h.isHappy(19));
	}
}
