package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @date 2016年3月3日 下午9:44:00
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			// 将单词按字母排序
			char[] carr = str.toCharArray();
			Arrays.sort(carr);
			String key = new String(carr);
			List<String> list = map.get(key);
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(key, list);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		// 将列表按单词排序
		for (String key : map.keySet()) {
			List<String> curr = map.get(key);
			Collections.sort(curr);
			res.add(curr);
		}
		return res;
	}
}
