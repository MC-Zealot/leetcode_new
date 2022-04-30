package com.leetcode_2th;


/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月10日 下午12:09:20 
 *
 */
public class ExcelSheetColumnNumber {
	
	public int titleToNumber(String s) {
		if(s==null){
			return 0;
		}
        int r = 0;
        int j = s.length()- 1;
        for(int i = 0; i < s.length(); i++) {
        	int tmp = s.charAt(i) - 'A' + 1 ;
        	r = tmp * (int)Math.pow(26.0, (double)(j--)) + r;
        }
		return r;
    }
	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("AAA"));
	}
}
