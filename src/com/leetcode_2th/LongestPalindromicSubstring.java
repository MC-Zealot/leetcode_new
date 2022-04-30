package com.leetcode_2th;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月5日 上午11:36:20
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
/**
 * 复用了代码
 * @date 2016年5月5日 下午12:00:44
 * @param s
 * @param left
 * @param right
 * @return
 */
	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		l.longestPalindrome("abba");
	}
}
