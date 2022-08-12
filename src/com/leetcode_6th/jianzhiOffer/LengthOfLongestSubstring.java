package com.leetcode_6th.jianzhiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null ){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        Map<String, Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int ret = 0;
        for(; fast < s.length(); fast++){
            char c = s.charAt(fast);
            String str = String.valueOf(c);
            if(map.containsKey(str) && map.get(str) >= slow){
                slow = map.get(str) + 1;
            }
            map.put(str, fast);
            ret = Math.max(ret, fast - slow + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String s = "dvdf";
        int ret = l.lengthOfLongestSubstring(s);
        System.out.println(ret);

    }
}
