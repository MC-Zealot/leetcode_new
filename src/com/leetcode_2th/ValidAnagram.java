package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 * 
 * @author Zealot
 * @date 2016年6月12日 上午10:23:25 
 *
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
        	return false;
        }
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char c2 = t.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
			if(map.containsKey(c2)){
				map.put(c2, map.get(c2)-1);
			}else{
				map.put(c2, -1);
			}
		}
		for(Character c : map.keySet()){
			if(map.get(c)!=0){
				return false;
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		ValidAnagram v = new ValidAnagram();
		System.out.println(v.isAnagram("anagram", "nagabam"));
	}
}
