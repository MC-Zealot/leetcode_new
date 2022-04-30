package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Zealot
 * @date 2016年3月13日 下午7:15:27
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int start = 0;
		int length = 0;
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))||map.get(s.charAt(i))<start) {
				length = i - start +1;
				if (max < length) {
					max = length;
				}
				map.put(s.charAt(i), i);
			} else {
				start = map.get(s.charAt(i)) + 1;
				
				map.put(s.charAt(i), i);
				length = i - start + 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("bbbb"));
		Map<Character, Integer> map = new HashMap<Character, Integer>();
	}
}
