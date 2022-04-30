package com.leetcode_2th;
/**
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * 
 * @author Zealot
 * @date 2016年4月23日 下午2:58:34 
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		if(s==null){
			return false;
		}
		s = s.trim();
		if(s.startsWith("+")||s.startsWith("-")){
			s = s.substring(1, s.length());
		}
		if(s.contains("e+")||s.contains("e-")){
			s = s.replace("e+", "e").replace("e-", "e");
		}
		if("".equals(s)||".".equals(s)||"e".equals(s)){
			return false;
		}
		if(s.startsWith("e")||s.endsWith("e")||s.startsWith(".e")||s.endsWith("e.")){
			return false;
		}
		boolean isDot = false;
		boolean isE = false;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='.'&& !isDot&&isE==false){
				isDot = true;
				continue;
			}
			if(s.charAt(i)=='e'&& !isE){
				isE = true;
				continue;
			}
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		System.out.println(v.isNumber(" 005047e+6"));
	}
}
