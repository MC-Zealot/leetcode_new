package com.leetcode_2th;
/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author Zealot
 * @date 2016年5月6日 下午2:15:17 
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		int i = digits.length - 1;
		while (carry == 1 && i >= 0) {
			int digit = digits[i];
			digit = digit + carry;
			if (digit >= 10) {
				carry = 1;
				digit = 0;
			} else {
				carry = 0;
			}
			digits[i] = digit;

			i--;
		}
		if (i == -1 && carry == 1) {
			int[] res = new int[digits.length + 1];
			System.arraycopy(digits, 0, res, 1, digits.length);
			res[0] = 1;
			return res;
		}
		return digits;
	}
	public static void main(String[] args) {
		int[] digits = {9};
		PlusOne p = new PlusOne();
		int[] res = p.plusOne(digits);
		for(int i: res){
			System.out.print(i+"\t");
		}
	}
}
