package com.leetcode_2th;
/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * 
 * @author Zealot
 * @date 2016年6月17日 上午9:55:41 
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
       StringBuffer sb = new StringBuffer();
       while(n>0){
    	   int digit = n % 26;
    	   char c = (char) (digit + 'A' - 1);
    	   if(digit==0){
    		   c = 'Z';
    		   n--;
    	   }
    	   sb.append(c);
    	   n = n / 26;
       }
		return sb.reverse().toString();
    }
	public static void main(String[] args) {
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(26));
	}
}
