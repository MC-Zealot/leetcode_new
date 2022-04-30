package com.leetCode._2th;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * string convert(string text, int numRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 *
 * @author Zealot
 * @date 2016年3月6日 下午4:12:50
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		int len = s.length(), k = 0, interval = (numRows << 1) - 2;
		String[] res = new String[len];
		for (int j = 0; j < len; j += interval)
			// 处理第一行
			res[k++] = String.valueOf(s.charAt(j));
		// 处理中间行
		for (int i = 1; i < numRows - 1; i++) {
			int inter = (i << 1);
			for (int j = i; j < len; j += inter) {
				res[k++] = String.valueOf(s.charAt(j));
				inter = interval - inter;
			}
		}
		for (int j = numRows - 1; j < len; j += interval){
			// 处理最后一行
			res[k++] = String.valueOf(s.charAt(j));
		}
		StringBuffer reVal = new StringBuffer();
		for (String str : res) {
			reVal.append(str);
		}
		return reVal.toString();
	}
	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		System.out.println(z.convert(s, 3));
	}
}
