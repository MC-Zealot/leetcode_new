package com.leetCode._2th;
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
 * @date 2016年3月27日 下午3:55:23 
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuffer str = new StringBuffer();
		while (n > 0) {
			int r = n % 26;
			n = n / 26;
			if (r == 0) { // 为26的整数倍，该位设置为Z，n减掉1
				str.append("Z");
				n--;
			} else {
				str.append((char)('A' + r - 1));
			}
		}
		return str.reverse().toString();
	}  
	public static void main(String[] args) {
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(1));
	}
}
