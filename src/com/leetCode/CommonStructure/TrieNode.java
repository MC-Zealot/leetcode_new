package com.leetCode.CommonStructure;

public class TrieNode {
	// Initialize your data structure here.
	public boolean iskey;
    public TrieNode[] children = new TrieNode[26]; // 各个子节点
    public TrieNode() {
        iskey = false;
        for(int i=0; i<26; ++i)
            children[i] = null;
    

    }
}
