package com.leetcode_2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".


 * 
 * @author Zealot
 * @date 2016年6月6日 上午9:45:21 
 *
 */
public class WordBreak {
	/**
	 * DP求解
	 * 使用bool数组记录到第i位能否由词典给出。
	 * 递推公式：res[i+1] = res[j] && wordDict.contains(s.substring(j, i + 1))
	 * @date 2016年6月6日 上午10:16:13
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {

		if(s==null || s.length()==0){
			return false;
		}
		boolean[] res = new boolean[s.length()+1];
		res[0]=true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				String str = s.substring(j, i+1);
				System.out.println(str);
				if(res[j]&&wordDict.contains(str)){
					res[i+1]=true;
					break;
				}
			}
		}
		return res[s.length()];
    }
	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		String s = "oj";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(w.wordBreak(s, wordDict));
	}
}
