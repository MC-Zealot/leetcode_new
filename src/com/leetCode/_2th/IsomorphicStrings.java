package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.


 * @author Zealot
 * @date 2016年2月18日 上午11:01:18
 *
 */
public class IsomorphicStrings {
	/**
	 * 有一个测试用例没通过
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic(String s, String t) {
		if(s==null||t==null||s.length()!=t.length()){
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Map<Character,Integer> map2 = new HashMap<Character,Integer>();
		for(int i = 0;i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if(map.containsKey(cs)&&map2.containsKey(ct)){
				if(map.get(cs)!=map2.get(ct)){
					return false;
				}
				map.put(cs, i);
				map2.put(ct, i);
			}else if((!map.containsKey(cs))&&(!map2.containsKey(ct))){

				map.put(cs, i);
				map2.put(ct, i);
			}else{
				return false;
			}
		}
		return true;
	}
	/**
	 * AC
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic2(String s, String t) {
		if(s == null || s.length() <= 1) return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0 ; i< s.length(); i++){
			char a = s.charAt(i);
			char b = t.charAt(i);
			if(map.containsKey(a)){
				if(map.get(a).equals(b))
					continue;
				else
					return false;
			}else{
				if(!map.containsValue(b))
					map.put(a,b);
				else return false;

			}
		}
		return true;
	}
	public static void main(String[] args) {
		IsomorphicStrings i = new IsomorphicStrings();
		System.out.println(i.isIsomorphic("aba#$#", "bab^&^"));
	}
}
