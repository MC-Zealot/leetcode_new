package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 * @author Zealot
 * @date 2016年7月14日 下午10:13:15 
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null || pattern.length() != str.split(" ").length) {
			return false;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if(map.containsKey(pattern.charAt(i))){
				String tmp = map.get(pattern.charAt(i));
				if(!tmp.equals(str.split(" ")[i])){
					return false;
				}
			}else{
				if(map.containsValue(str.split(" ")[i])){
					return false;
				}
				map.put(pattern.charAt(i), str.split(" ")[i]);
			}
			
		}
		return true;
    }
	public static void main(String[] args) {
		WordPattern w = new WordPattern();
		String p = "abba";
		String str = "dog dog dog dog";
		System.out.println(w.wordPattern(p, str));
	}
}
