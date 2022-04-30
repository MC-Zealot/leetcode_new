package com.leetCode._1th;

/**
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 * @author Zealot
 * @date 2015年9月7日 下午10:19:09
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int lastDigit = ++digits[digits.length-1];
		boolean sign = false;
		if(lastDigit==10){
			sign = true;
			digits[digits.length-1]=0;
		}
		
		if(digits.length==1&&lastDigit==10){
			int[] b = {1,0};
			return b;
		}
		for(int i =digits.length-2; i >=0; i--) {
			if(digits[i+1]==0&&sign){
				sign = false;
				digits[i]++;
				if(digits[i]==10){
					sign = true;
					digits[i] = 0;
				}
				
			}
		}
		if(digits[0]==0){
			digits = new int[digits.length+1];
			digits[0]=1;
			for(int i = 1; i < digits.length; i++){
				digits[i]=0;
			}
		}
		return digits;
	}
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] a = {9,9};
		int [] val = p.plusOne(a);
		for(int i = 0; i < val.length; i++) {
			System.out.print(val[i]+" ");
		}
	}
}
