package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T
 * 
 * in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author Zealot
 * @date 2016年6月24日 下午5:54:50
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();//字符，次数
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		int start = 0;//窗口起始位置
		int count = 0;//窗口内包含T字符的长度
		int minLen = S.length() + 1;
		int minStart = 0;
		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
				if (map.get(S.charAt(i)) >= 0) {
					count++;
				}
				while (count == T.length()) {
					if (i - start + 1 < minLen) {
						minLen = i - start + 1;
						minStart = start;
					}
					if (map.containsKey(S.charAt(start))) {
						map.put(S.charAt(start), map.get(S.charAt(start)) + 1);
						if (map.get(S.charAt(start)) > 0) {
							count--;
						}
					}
					start++;
				}
			}
		}
		if (minLen > S.length()) {
			return "";
		}
		return S.substring(minStart, minStart + minLen);
	}

	public String minWindow2(String s, String t) {
		int lengthT = t.length();
		int lengthS = s.length();
		int[] mapT = new int[256];
		for (int i = 0; i < lengthT; i++) {
			char curc = t.charAt(i);
			mapT[curc]++;
		}
		int[] mapS = new int[256];
		int start = 0;
		int resLenth = Integer.MAX_VALUE;
		String res = "";
		int count = 0;
		for (int i = 0; i < lengthS; i++) {
			char curc = s.charAt(i);
			if (mapT[curc] > 0) {
				mapS[curc]++;
				if (mapS[curc] <= mapT[curc]) {
					count++;
				}
			}
			while (count == lengthT) {
				curc = s.charAt(start);
				if (mapT[curc] > 0) {
					if (mapS[curc] > mapT[curc]) {
						mapS[curc]--;
					} else {
						break;
					}
				}
				start++;
			}
			if (count == lengthT && i - start + 1 < resLenth) {
				resLenth = i - start + 1;
				res = s.substring(start, i + 1);
			}
		}

		return res;
	}
	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		String S = "AACB";
		String T = "ABC";
		System.out.println(m.minWindow(S, T));
	}
}
