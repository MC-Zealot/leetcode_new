package com.leetCode._2th;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given s = "leetcode", dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author Zealot
 * @date 2016年2月26日 上午9:31:56
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null || s.length()==0){
			return false;
		}
		boolean[] res = new boolean[s.length()+1];
		res[0]=true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				String str = s.substring(j, i+1);
				if(res[j]&&wordDict.contains(str)){
					res[i+1]=true;
					break;
				}
			}
		}
		return res[s.length()];
	}
}
