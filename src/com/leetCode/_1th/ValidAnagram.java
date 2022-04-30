package com.leetCode._1th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. 
 *              s = "rat",     t = "car"    , return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * @author Zealot
 * @date 2015年8月4日 下午8:46:50
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s==null||t==null||s.length()!=t.length()){
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < s.toCharArray().length; i++){
			Integer time = map.get(s.charAt(i));
			if(time==null){
				map.put(s.charAt(i), 1);
			}else{
				map.put(s.charAt(i), time+1);
			}
		}
		for(int i = 0; i < t.toCharArray().length; i++) {
			Integer time = map.get(t.charAt(i));
			if(time==null){
				return false;
			}else if(time==1){
				map.remove(t.charAt(i));
			}else{
				map.put(t.charAt(i),time-1);
			}
			
		}
		return true;
	}
	public boolean isAnagram2(String s, String t) {
		if(s==null||t==null||s.length()!=t.length()){
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < s.toCharArray().length; i++){
			Integer time = map.get(s.charAt(i));
			if(time==null){
				map.put(s.charAt(i), 1);
			}else{
				map.put(s.charAt(i), time+1);
			}
			Integer time2 = map.get(t.charAt(i));
			if(time2==null){
				map.put(t.charAt(i), -1);
			}else{
				map.put(t.charAt(i), time2-1);
			}
		}
		for(Character c : map.keySet()){
			if(map.get(c)!=0){
				return false;
			}
		}
		return true;
	}
	public boolean isAnagram3(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] c=new int[256];//初始化数组中每一个元素的值为0
        for (int i=0; i<s.length(); ++i){
            c[s.charAt(i)]++; 
            c[t.charAt(i)]--;
        }

        for (int i=0; i<256; ++i){
            if (c[i]!=0) return false;
        }
        return true;
    }
	public static void main(String[] args) {
//		ValidAnagram v = new ValidAnagram();
//		System.out.println(v.isAnagram3("anagram", "nagaram"));
		int[] c=new int[100];
		for(int i =0; i < c.length;i++) {
			System.out.println(c[i]);
		}
	}
}
