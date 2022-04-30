package com.leetcode_2th;
/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 

the characters without disturbing the relative positions of the remaining characters.

 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * 
 * @author Zealot
 * @date 2016年7月5日 下午3:10:38 
 *
 */
public class DistinctSubsequences {
	int res = 0;
	/**
	 * 暴力求解
	 * TLE
	 * @date 2016年7月5日 下午3:45:27
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct(String s, String t) {
		if(s==null||t==null){
			return res;
		}
		dfs(s, t, "", 0);
		return res;
    }
	private void dfs(String s, String t, String pre, int cur) {
		if(t.startsWith(pre)){
			if(t.equals(pre)){
				res++;
				return;
			}
		}else{
			return;
		}
		for(int i = cur; i < s.length(); i++) {
			pre = pre + s.charAt(i);
			dfs(s, t, pre, i + 1);
			pre = pre.substring(0, pre.length() - 1);
		}
	}

	/**
	 * 无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j -
	 * 1个字符，得到匹配个数为dp[i][j - 1].现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j -
	 * 1]。除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配
	 * 
	 * @date 2016年7月5日 下午4:32:17
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct1(String S, String T) {
		int[][] dp = new int[T.length() + 1][S.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= T.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= S.length(); j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				dp[i][j] = dp[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[T.length()][S.length()];
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DistinctSubsequences d = new DistinctSubsequences();
		String s = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String t = "bddabdcae";
		System.out.println(d.numDistinct1(s, t));
		long end = System.currentTimeMillis();
		System.out.println(end -start);
	}
}
