package com.leetCode._2th;

import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord,
 * such that:

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
 * @date 2016年3月19日 下午4:23:00 
 *
 */
class WordNode{
	String word;
	int numSteps;
	
	public WordNode(String word, int numSteps){
		this.word = word;
		this.numSteps = numSteps;
	}
}
public class WordLadder {
	 
	    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	        queue.add(new WordNode(beginWord, 1));
	 
	        wordDict.add(endWord);
	 
	        while(!queue.isEmpty()){
	            WordNode top = queue.remove();
	            String word = top.word;
	 
	            if(word.equals(endWord)){
	                return top.numSteps;
	            }
	            //word在wordDict里边，有没有只更改一个，就可以匹配到的。如果有，则加入到队列当中
	            char[] arr = word.toCharArray();
	            for(int i=0; i<arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	                    if(wordDict.contains(newWord)){
	                        queue.add(new WordNode(newWord, top.numSteps+1));
	                        wordDict.remove(newWord);//?为什么要删除
	                    }
	 
	                    arr[i]=temp;
	                }
	            }
	        }
	 
	        return 0;
	    }
}
