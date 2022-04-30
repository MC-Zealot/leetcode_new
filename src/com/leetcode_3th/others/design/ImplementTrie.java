package com.leetcode_3th.others.design;

import com.leetCode.CommonStructure.TrieNode;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 * 
 * @author Zealot
 * @date Aug 2, 2019 10:15:27 AM 
 *
 */
public class ImplementTrie {
	class Trie {
		public class TrieNode {
			// Initialize your data structure here.
			public boolean iskey;
			public TrieNode[] children = new TrieNode[26]; // 各个子节点

			public TrieNode() {
				iskey = false;
				for (int i = 0; i < 26; ++i)
					children[i] = null;
			}
		}

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String s) {
			TrieNode node = root;
			for (int i = 0; i < s.length(); ++i) {
				if (node.children[s.charAt(i) - 'a'] == null) {
					node.children[s.charAt(i) - 'a'] = new TrieNode();
				}
				node = node.children[s.charAt(i) - 'a'];
			}
			node.iskey = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				if (node != null) {
					node = node.children[word.charAt(i) - 'a'];
				} else {
					return false;
				}
			}

			return node == null ? false : node.iskey;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return true;
		}
	}
}
