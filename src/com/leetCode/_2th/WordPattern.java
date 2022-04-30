package com.leetCode._2th;

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
 * @date 2016年2月19日 下午9:32:09
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if(pattern==null||str==null){
			return false;
		}
		int pLen = pattern.toCharArray().length;
		int sLen = str.split(" ").length;
		if(pLen != sLen){
			return false;
		}
		String[] ss = str.split(" ");
		Map<Character, String> map = new HashMap<Character, String>();
		for(int i = 0; i < pLen; i++) {
			if(!map.containsKey(pattern.charAt(i))){
				if(map.containsValue(ss[i])){
					return false;
				}
				map.put(pattern.charAt(i), ss[i]);
			}else{
				String s = map.get(pattern.charAt(i));
				if(!s.equals(ss[i])){
					return false;
				}
			}
		}

		return true;
	}
	public static void main(String[] args) {
		WordPattern w = new WordPattern();
		System.out.println(w.wordPattern("abba", "dog dog dog dog"));
	}
}
