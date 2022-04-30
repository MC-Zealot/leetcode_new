package com.leetCode._1th;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * @author Zealot
 * @date 2015年8月16日 下午4:36:00
 */
public class AddDigits {
	public int addDigits(int num) {
		while(num>9){
			int sum=0;
			for(int i = 0; i < String.valueOf(num).length(); i++){
				sum+=Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i)));
			}
			num=sum;
		}
		return num;
	}
	public static void main(String[] args) {
		AddDigits a = new AddDigits();
		System.out.println(a.addDigits(111));
	}
}
