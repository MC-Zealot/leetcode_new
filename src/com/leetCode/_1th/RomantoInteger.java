package com.leetCode._1th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
 * 
 * 
 * @author Zealot
 * @date 2015年7月31日 下午8:36:20
 */
public class RomantoInteger {
	
	public int romanToInt(String s) {
		if("".equals(s)||s==null){
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char c = s.charAt(s.length()-1);
		int result = map.get(c);
		int pivot = result;
		for(int i = s.length()-2; i >=0; i--) {
			int curr = map.get(s.charAt(i));
			if(pivot>curr){
				result-=curr;
			}else{
				result+=curr;
			}
			pivot = curr;
		}
		
		return result;
	}
	public static void main(String[] args) {
		RomantoInteger r = new RomantoInteger();
		System.out.println(r.romanToInt("XCIX"));
	}
}
