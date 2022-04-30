package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月3日 上午10:21:32 
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * space:O(1)
	 * time:O(n)
	 * @date 2016年5月3日 上午11:28:45
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s==null){
			return 0;
		}
		int start = 0, cur = 0, max = 0, size = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(256);
		for(; cur < s.length(); cur++) {
			char c = s.charAt(cur);
			if(!map.containsKey(c)){
				map.put(c, cur);
				size++;
			}else {
				int index = map.get(c);
				map.put(c, cur);
				if(index < start){
					size++;
					max = size > max ?  size : max;
					continue;
				}
				start = index + 1;
				size = cur - start + 1;
			}
			max = size > max ?  size : max;
		}
		
		size = cur - start ;
		max = size > max ?  size : max;
		return max;
    }
	/**
	 * 
	 * @date 2016年5月3日 下午3:24:08
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
	}
}
