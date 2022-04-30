package com.leetcode_3th.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

 * 
 * @author Zealot
 * @date Jul 30, 2019 9:41:59 AM 
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s==null || s.length()==0){
			return false;
		}
		boolean[] res = new boolean[s.length()+1];//res[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
		res[0]=true;
		for(int i=1;i<=s.length();i++){
			for(int j=0;j<i;j++){
				String str = s.substring(j, i);
				System.out.println(str);
				if(res[j]&&wordDict.contains(str)){
					res[i]=true;
					break;
				}
			}
		}
		return res[s.length()];
	}
	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		String s = "oj";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(w.wordBreak(s, wordDict));
	}
}
