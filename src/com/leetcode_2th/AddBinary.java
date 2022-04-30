package com.leetcode_2th;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 * @author Zealot
 * @date 2016年6月8日 上午11:45:14 
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a==null||b==null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		while(indexA>=0&&indexB>=0){
			int aa = a.charAt(indexA) - '0';
			int bb = b.charAt(indexB) - '0';
			int cur = (aa+bb+carry)%2;
			carry = (aa+bb+carry)/2;
			sb.append(cur);
			indexA--;
			indexB--;
		}
		while(indexA>=0){
			int aa = a.charAt(indexA) - '0';
			int cur = (aa+carry)%2;
			carry = (aa+carry)/2;
			sb.append(cur);
			indexA--;
		}
		while(indexB>=0){
			int bb = b.charAt(indexB) - '0';
			int cur = (bb+carry)%2;
			carry = (bb+carry)/2;
			sb.append(cur);
			indexB--;
		}
		if(carry>0){
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "11";
		String b = "1";
		System.out.println(ab.addBinary(a, b));
	}
}
