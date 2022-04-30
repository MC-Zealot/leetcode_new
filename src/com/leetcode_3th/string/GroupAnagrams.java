package com.leetcode_3th.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * 输出: 
 * [ ["ate","eat","tea"],
 * ["nat","tan"], 
 * ["bat"] ] 
 * 
 * 说明：
 * 所有输入均为小写字母。 不考虑答案输出的顺序。
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 7:15:13 PM
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i = 0; i < strs.length; i++) {
			char[] cc = strs[i].toCharArray();
			Arrays.sort(cc);
			if(!map.containsKey(String.valueOf(cc))) {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(String.valueOf(cc), list);
			}else {
				map.get(String.valueOf(cc)).add(strs[i]);	
			}
		}
		
		for(String key: map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}
	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(ga.groupAnagrams(strs));
	}
}
