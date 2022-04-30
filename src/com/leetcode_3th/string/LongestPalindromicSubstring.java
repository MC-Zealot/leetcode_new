package com.leetcode_3th.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 12:32:22 PM
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String res = "";
		if(s==null || s.length()==0) {
			return res;
		}
		int b = 0;
		// 2种情况，中心点是一个，中心点是2个
		//如果中心点是2个，1、如何发现。2、如何判断。3、如何改变
		
		for (int center = 0; center < s.length(); center++) {
			int center_len = 1;
			int index = center + 1;
			while(index < s.length() && s.charAt(center) == s.charAt(index)) {
				center_len++;
				index+=1;
			}
			index--;
			b=1;
			// 开始向旁边扩散，应该是一个while循环
			while (center - b>= 0 && index + b  < s.length()) {
				if (s.charAt(center - b) != s.charAt(index + b)) {
					break;
				}
				b++;
			}
			b--;
			//比较字符串长度
			int size = center_len + b + b;
			if(res.length()< size) {
				char[] tmp = new char[size];
				for(int i = center - b,j = 0; i <= index + b && j < size; i++,j++) {
					tmp[j] = s.charAt(i);
				}
				res = String.valueOf(tmp);
			}
			
		}
		
		return res;
	}
	
	/**
	 * O(n^2)
	 * 并且有重复计算，如果可以把历史计算的都保存起来（dp），可以缩短计算时间
	 * 超时
	 * @date Aug 7, 2019 2:58:47 PM
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		if (s.length() <= 1) {
			return s;
		}
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String tmp = s.substring(i, j + 1);
				if (isPalindrome(tmp)) {
					if (tmp.length() > res.length()) {
						res = tmp;
					}
				}
			}
		}
		return res;
	}

	public boolean isPalindrome(String s) {
		for (int i = 0; i < (s.length() / 2); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 这里动态规划的思路是 dp[i][j] 表示的是 从i 到 j 的字串，是否是回文串。

则根据回文的规则我们可以知道：

如果s[i] == s[j] 那么是否是回文决定于 dp[i+1][ j - 1]

当 s[i] != s[j] 的时候， dp[i][j] 直接就是 false。

动态规划的进行是按照字符串的长度从1 到 n推进的。

代码很明晰：给出java代码，复杂度 O(n^2)
	 * @date Aug 7, 2019 3:34:58 PM
	 * @param s
	 * @return
	 */
	public String longestPalindrome3(String s) {
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}

		boolean[][] dp = new boolean[s.length()][s.length()];
		int i, j;

		for (i = 0; i < s.length(); i++) {
			for (j = 0; j < s.length(); j++) {
				if (i >= j) {
					dp[i][j] = true; // 当i == j 的时候，只有一个字符的字符串; 当 i > j 认为是空串，也是回文

				} else {
					dp[i][j] = false; // 其他情况都初始化成不是回文
				}
			}
		}

		int k;
		int maxLen = 1;
		int rf = 0, rt = 0;
		for (k = 1; k < s.length(); k++) {
			for (i = 0; k + i < s.length(); i++) {
				j = i + k;
				if (s.charAt(i) != s.charAt(j)) { // 对字符串 s[i....j] 如果 s[i] != s[j] 那么不是回文
					dp[i][j] = false;
				} else {// 如果s[i] == s[j] 回文性质由 s[i+1][j-1] 决定
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j]) {
						if (k + 1 > maxLen) {
							maxLen = k + 1;
							rf = i;
							rt = j;
						}
					}
				}
			}
		}
		return s.substring(rf, rt + 1);
	}
	public static void main(String[] args) {
		String s = "aabcb";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));
	}
}
