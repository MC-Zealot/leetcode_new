package com.leetcode_2th;
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
 * 
 * @author Zealot
 * @date 2016年6月23日 上午11:04:38 
 *
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
			return "";
		}
		if (num1.charAt(0) == '0'){
			return "0";
		}
		if (num2.charAt(0) == '0'){
			return "0";
		}
		StringBuffer res = new StringBuffer();
		int num = 0;
		for (int i = num1.length() + num2.length(); i > 0; i--) {
			for (int j = Math.min(i - 1, num1.length()); j > 0; j--) {//num1的长度
				if (i - j <= num2.length()) {//总长度减去num1的长度，不能大于nums2的长度
					num += (int) (num1.charAt(j - 1) - '0')	* (int) (num2.charAt(i - 1 - j) - '0');//num1的位*对应num2的位
				}
			}
			if (i != 1 || num > 0){
				res.append(num % 10);
			}
			num = num / 10;
		}
	    return res.reverse().toString();  
    }

	public String multiply2(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}

		int len1 = num1.length(), len2 = num2.length();
		int len3 = len1 + len2;
		int i, j, product, carry;

		int[] num3 = new int[len3];
		for (i = len1 - 1; i >= 0; i--) {
			carry = 0;
			for (j = len2 - 1; j >= 0; j--) {
				product = carry + num3[i + j + 1] + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
				num3[i + j + 1] = product % 10;
				carry = product / 10;
			}
			num3[i + j + 1] = carry;
		}

		StringBuilder sb = new StringBuilder();
		i = 0;

		while (i < len3 - 1 && num3[i] == 0) {
			i++;
		}

		while (i < len3) {
			sb.append(num3[i++]);
		}

		return sb.toString();
	}
}
