package com.leetCode._1th;

/**
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * @author Zealot
 * @date 2015年8月4日 下午8:12:25
 */
public class IntegertoRoman {
	public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
	public static void main(String[] args) {
		IntegertoRoman i = new IntegertoRoman();
		System.out.println(i.intToRoman(34));
	}
}
