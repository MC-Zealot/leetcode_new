package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 * 
 * @author Zealot
 * @date 2016年6月27日 下午3:48:46 
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				char sc = map.get(s.charAt(i));
				char tc = t.charAt(i);
				if (sc != tc) {
					return false;
				}
			} else {
				if (map.containsValue(t.charAt(i))) {
					return false;
				}
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
	public static void main(String[] args) {
		IsomorphicStrings i= new IsomorphicStrings();
		String s ="paper";
		String t = "title";
		System.out.println(i.isIsomorphic(s, t));
	}
}
