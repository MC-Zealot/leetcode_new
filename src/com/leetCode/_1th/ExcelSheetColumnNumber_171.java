package com.leetCode._1th;

/**
 * 
 * @author Zealot
 *@date 2015年7月18日 下午8:32:41
 */
public class ExcelSheetColumnNumber_171 {
	public int titleToNumber(String s) {
		if(s==null){
			return 0;
		}
		int sum = 0;
		byte[] bb = s.getBytes();
		for(int i = bb.length; i >0 ; i--) {
			sum += (Math.pow(26,bb.length-i))*getNumFromLetter(bb[i-1]);
			
		}
		return sum;
	}
	private static int getNumFromLetter(byte letter){
		return letter-64;
	}
	public static void main(String[] args) {
		String letter = "AB";
		ExcelSheetColumnNumber_171 e = new ExcelSheetColumnNumber_171();
		System.out.println(e.titleToNumber(letter));
//		System.out.println(getNumFromLetter(letter));
//		System.out.println(Math.pow(26,2));
	}
}
