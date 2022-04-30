package com.leetCode._2th;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.CommonStructure.TrieNode;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * @author Zealot
 * @date 2016年4月5日 下午8:33:02
 *
 */
public class ImplementTriePrefixTree {
	public class Trie {
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
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
	}
}
