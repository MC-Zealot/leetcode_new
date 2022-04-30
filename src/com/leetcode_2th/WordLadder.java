package com.leetcode_2th;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * 
 * @author Zealot
 * @date 2016年6月12日 上午11:21:04 
 *
 */
public class WordLadder {

	public int ladderLength(String beginWord, String endWord, HashSet<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length()){
			return 0;
		}
			
		LinkedList<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		int level = 1;
		int lastNum = 1;
		int curNum = 0;
		queue.offer(beginWord);
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			lastNum--;
			for (int i = 0; i < cur.length(); i++) {
				char[] charCur = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charCur[i] = c;
					String temp = new String(charCur);
					if (temp.equals(endWord))
						return level + 1;
					if (wordList.contains(temp) && !visited.contains(temp)) {
						curNum++;
						queue.offer(temp);
						visited.add(temp);
					}
				}
			}
			if (lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}
		return 0;
	}  
	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		LinkedList<Integer> s = new LinkedList<Integer>();
		
		
	}
}
