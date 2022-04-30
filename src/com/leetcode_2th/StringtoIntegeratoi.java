package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月21日 下午9:18:53 
 *
 */
public class StringtoIntegeratoi {
	public int myAtoi(String str) {
		int res = 0;
		if(str==null){
			return res;
		}
		int flag = 1;
		int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i))){
			i++;
		}
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			flag = -1;
			i++;
		}
		while (i < n && Character.isDigit(str.charAt(i))) {
			int tmp = res;
			res = res * 10 + (int)(str.charAt(i) - '0');
			if((res - (int)(str.charAt(i) - '0'))/10!=tmp){
				if(flag==-1){
					return Integer.MIN_VALUE;
				}else{
					return Integer.MAX_VALUE;
				}
			}
			i++;
		}
		return res*flag;
    }
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;

	public int atoi(String str) {
		int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i))){
			i++;
		}
		int sign = 1;
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
	public static void main(String[] args) {
		StringtoIntegeratoi s = new StringtoIntegeratoi();
		System.out.println(s.myAtoi("123"));
	}
}
