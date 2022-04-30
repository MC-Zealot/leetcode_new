package com.leetcode_2th;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author Zealot
 * @date 2016年5月5日 下午1:52:20
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1.length() == 0){
			return word2.length();
		}
		if (word2.length() == 0){
			return word1.length();
		}
		String minWord = word1.length() > word2.length() ? word2 : word1;
		String maxWord = word1.length() > word2.length() ? word1 : word2;
		int[] res = new int[minWord.length() + 1];
		for (int i = 0; i <= minWord.length(); i++) {
			res[i] = i;
		}
		for (int i = 0; i < maxWord.length(); i++) {
			int[] newRes = new int[minWord.length() + 1];
			newRes[0] = i + 1;
			for (int j = 0; j < minWord.length(); j++) {
				if (minWord.charAt(j) == maxWord.charAt(i)) {
					newRes[j + 1] = res[j];
				} else {
					newRes[j + 1] = Math.min(res[j], Math.min(res[j + 1], newRes[j])) + 1;
				}
			}
			res = newRes;
		}
		return res[minWord.length()];
	}
}
