package com.leetCode._2th;
/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 *
 * @author Zealot
 * @date 2016年3月2日 下午11:48:22
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (i >= 0 && j >= 0) {
			int digit = (int) (a.charAt(i) - '0' + b.charAt(j) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.append(digit);
			i--;
			j--;
		}
		while (i >= 0) {
			int digit = (int) (a.charAt(i) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.append(digit);
			i--;
		}
		while (j >= 0) {
			int digit = (int) (b.charAt(j) - '0') + carry;
			carry = digit / 2;
			digit %= 2;
			res.append(digit);
			j--;
		}
		if (carry > 0) {
			res.append(carry);
		}
		return res.reverse().toString();
	}
	public static void main(String[] args) {
		String a = "023";
		System.out.println(a.charAt(0)-'0'+a.charAt(1)-'0');//2个char的ascii码相减，减掉0的ascii码就是那个字符的实际代表的数字了
		char c1 = a.charAt(0);
		char c2 = a.charAt(1);
		int c3 = c1-'0'+c2-'0';
		System.out.println(c1);//减掉0的ascii码就是那个字符的实际代表的数字了
		System.out.println(c2);//减掉0的ascii码就是那个字符的实际代表的数字了
		System.out.println(c3);//减掉0的ascii码就是那个字符的实际代表的数字了
		System.out.println((int)c1);
	}
}
