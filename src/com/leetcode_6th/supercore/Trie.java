package com.leetcode_6th.supercore;

public class Trie {
    Trie[] nodes;
    boolean isEnd = false;
    public Trie() {
        nodes = new Trie[26];
    }

    public void insert(String word) {
        Trie tmp = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(tmp.nodes[c - 'a'] == null){
                tmp.nodes[c - 'a'] = new Trie();
            }
            tmp = tmp.nodes[c - 'a'];
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {
        Trie tmp = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(tmp.nodes[c - 'a'] == null){
                return false;
            }
            tmp = tmp.nodes[c - 'a'];
        }
        return tmp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tmp.nodes[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.nodes[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        t.insert("app");
        System.out.println(t.search("app"));
    }
}
