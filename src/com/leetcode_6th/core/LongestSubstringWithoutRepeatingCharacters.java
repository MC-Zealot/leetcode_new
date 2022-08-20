package com.leetcode_6th.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int local = 0;
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            if(map.containsKey(str) && map.get(str) >= start){
                local = i - map.get(str);
                start = map.get(str) + 1;
            }else{
                local++;
            }
            max = Math.max(max, local);
            map.put(str, i);
        }
        return max;
    }
}
