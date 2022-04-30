package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月6日 下午3:33:21 
 *
 */
public class PalindromeNumber {
	/**
	 * 虽然能通过，但是可能会溢出,但是也不会报错。
	 * @date 2016年5月6日 下午4:55:53
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		int tmp = x, rev = 0;
		while (tmp > 0) {
			rev = rev * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		return x == rev;
	}
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(2147483647));
		System.out.println(Integer.MAX_VALUE);
	}
}
