package com.leetCode._2th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence
 *
 * where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 *
 * @author Zealot
 * @date 2016年2月27日 上午10:09:06
 *
 */
public class WordBreakII {
	StringBuffer tmp = new StringBuffer();
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if(s==null||wordDict==null||wordDict.size()==0||!isWordBreak(s, wordDict)){
			return res;
		}
		dfs(0,  s, wordDict, res);
		return res;
	}
	private void dfs(int cur,  String s, Set<String> wordDict, List<String> res) {
		if(cur==s.length()){
			res.add(tmp.substring(1, tmp.length()));
		}
		StringBuffer sb = new StringBuffer();
		for(int i = cur,count = 1; i < s.length(); i++,count++) {
			sb.append(s.charAt(i));
			if(wordDict.contains(sb.toString())){
				tmp.append(" ").append(sb);
				dfs(cur+count,  s, wordDict, res);
				tmp = new StringBuffer(tmp.substring(0, tmp.length()-sb.length()-1));
			}
		}
	}
	public static boolean isWordBreak(String s, Set<String> wordDict) {
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
	public static void main(String[] args) {
		WordBreakII w = new WordBreakII();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("aaa");
		wordDict.add("aaaa");
		List<String> res = w.wordBreak("aaaaaaa", wordDict);
		for(String s: res){
			System.out.println(s);
		}
	}
}
