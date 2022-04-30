package com.leetCode._2th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author Zealot
 * @date 2016年2月23日 下午9:14:11
 *
 */
public class LetterCombinationsofaPhoneNumber {
	public static void DFS(String digits, List<String> result, StringBuffer s, int start, HashMap<Integer, String> map) {
		if (start == digits.length()){
			result.add(s.toString());
		}
		else {
			String tmp = map.get(digits.charAt(start) - '0');
			for (int i = 0; i < tmp.length(); i++) {
				s.append(tmp.charAt(i));
				DFS(digits, result, s, start + 1, map);
				s.deleteCharAt(s.length() - 1);
			}
		}
	}

	public static List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0){
			return new ArrayList<String>();
		}
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		List<String> result = new ArrayList<String>();
		StringBuffer s = new StringBuffer();
		DFS(digits, result, s, 0, map);
		return result;
	}
}
