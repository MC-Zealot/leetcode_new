package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * 
 * @author Zealot
 * @date 2016年6月7日 下午5:44:16 
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(strs.length==0){
			return res;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str: strs){
			char[]  cc = str.toCharArray();
			Arrays.sort(cc);
			String key = new String(cc);
			List<String> list = map.get(key);
			if(list==null){
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(key, list);
		}
		// 将列表按单词排序
		for (String key : map.keySet()) {
			List<String> curr = map.get(key);
			Collections.sort(curr);
			res.add(curr);
		}
		return res;
    }
}
