package com.leetCode._2th;
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author Zealot
 * @date 2016年3月12日 上午10:18:19 
 *
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if(num1==null||num2==null){
			return null;
		}
		
		int a = stringToInt(num1);
		int b = stringToInt(num2);
		if(a==0||b==0){
			return "0";
		}
		int c = 0;
		for(int i = 0; i < b; i++) {
			if(c + a< c){
				return "0";
			}
			c = c + a;
		}
		return String.valueOf(c);
    }
	public String multiply2(String num1, String num2) {
		if(num1==null||num2==null){
			return null;
		}
		
		int a = stringToInt(num1);
		int b = stringToInt(num2);
		if(a==0||b==0){
			return "0";
		}
		String res = "0";
		for(int i = 0; i < b; i++) {
			res = addNumbers(res, num1);
		}
		return res;
	}
	
	/**
	 * O(m+n)
	 * @date 2016年3月12日 下午2:34:28
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addNumbers(String a, String b) {
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
			carry = digit / 10;
			digit %= 10;
			res.append(digit);
			i--;
			j--;
		}
		while (i >= 0) {
			int digit = (int) (a.charAt(i) - '0') + carry;
			carry = digit / 10;
			digit %= 10;
			res.append(digit);
			i--;
		}
		while (j >= 0) {
			int digit = (int) (b.charAt(j) - '0') + carry;
			carry = digit / 10;
			digit %= 10;
			res.append(digit);
			j--;
		}
		if (carry > 0) {
			res.append(carry);
		}
		return res.reverse().toString();
	}
	private static int stringToInt(String a) {
		if(a==null){
			return 0;
		}
		int  b = 0;
		for(int i = 0; i < a.length(); i++) {
			int digit = a.charAt(i) - '0';
			if(b*10+digit<b){
				return 0;
			}
			b = b * 10 + digit;
		}
		return b;
	}
	public String multiply3(String num1, String num2) {  
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
			return "";
		}
		if (num1.charAt(0) == '0'){
			return "0";
		}
		if (num2.charAt(0) == '0'){
			return "0";
		}
		StringBuilder res = new StringBuilder();
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
	public static void main(String[] args) {
		MultiplyStrings m = new MultiplyStrings();
		System.out.println(m.multiply2("10", "16"));
		/*String a = "1234566666666666666666";
		int  b = 0;
		for(int i = 0; i < a.length(); i++) {
			int digit = a.charAt(i) - '0';
			if(b*10+digit<b){
				System.out.println("error");
				break;
			}
			b = b * 10 + digit;
		}
		System.out.println(b);*/
	}
}
