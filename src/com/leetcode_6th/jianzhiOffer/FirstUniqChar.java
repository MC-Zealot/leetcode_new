package com.leetcode_6th.jianzhiOffer;

import com.leetcode_6th.ChangeCoin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if(s == null || s.equals("")){
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        Set<Character> set = new HashSet<>();
        for(Character c: map.keySet()){
            int cnt = map.get(c);
            if(cnt == 1){
                set.add(c);
            }
        }
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(set.contains(c)){
                return c;
            }
        }
        return ' ';
    }

}
