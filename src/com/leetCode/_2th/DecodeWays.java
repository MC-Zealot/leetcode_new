package com.leetCode._2th;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * 定义dp[i+1]为能解码长度为i+1的string s[0:i]的方法数：
1. dp[0] = 1，dp[1] = 0
2. v = s[i-1]*10+s[i]：
v<=26： dp[i+1] = dp[i] + dp[i-1]
v>26：dp[i+1] = dp[i]

corner case：有0的情况
Y = 0：显然无法解码成h[Y]，此时只能看h[XY]是否valid：dp[i+1] = dp[i-1]
X = 0：显然无法解码成h[XY]，此时dp[i+1] = dp[i]

整理总结corner case：
XY可以解码的条件是：9<XY<=26
Y可以单独解码的条件是：Y != '0'
 * 
 * @author Zealot
 * @date 2016年3月17日 上午11:38:48
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null ||"".equals(s)|| s.charAt(0) < '1' || s.charAt(0) > '9'){
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = dp[1] = 1;

		for (int i = 1; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return 0;
			}
			int v = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
			if (v <= 26 && v > 9){
				dp[i + 1] += dp[i - 1];
			}
			if (s.charAt(i) != '0'){
				dp[i + 1] += dp[i];
			}
			if (dp[i + 1] == 0){
				return 0;
			}
		}
		return dp[s.length()];
	}
}
