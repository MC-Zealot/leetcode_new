package com.leetcode_3th.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 
 * 示例 1:
 * 
 * 输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c". 示例 2:
 * 
 * 输入: "aaa" 输出: 6 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 8:53:58 PM
 *
 */
public class PalindromicSubstrings {
	public boolean isPalindromic(String s) {
		for (int i = 0; i < (s.length() / 2); i++)
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		return true;
	}

	public int countSubstrings(String s) {
		int len = s.length();
		int[] dp = new int[len];
		for (int i = 1; i < len; i++) {
			int tmpNum = 0;
			for (int j = 0; j < i; j++)
				if (s.charAt(i) == s.charAt(j)) {
					String subStr = s.substring(j, i + 1);
					if (isPalindromic(subStr)) {
						tmpNum++;
					}
				}
			dp[i] = dp[i - 1] + tmpNum;
		}
		return dp[len - 1] + len;
	}

	public static void main(String[] args) {
		PalindromicSubstrings p = new PalindromicSubstrings();

	}
}
