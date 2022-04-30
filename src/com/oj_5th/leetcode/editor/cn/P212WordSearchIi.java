//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 
// 👍 412 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
*   [212] word-search-ii
*   2021-07-25 22:46:07
*/
public class P212WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
        // TO TEST
    }
    //[212] word-search-ii
    //leetcode submit region begin(Prohibit modification and deletion)
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }
class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }
        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return this._result;
    }
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }
        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';
        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;
        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }


        public List<String> findWords2(char[][] board, String[] words) {
            List<String> result = new ArrayList<>();
            for (int w = 0; w < words.length; w++) {
                boolean isEnd = false;
                for (int i = 0; i < board.length && !isEnd; i++) {
                    for (int j = 0; j < board[0].length && !isEnd; j++) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if (dfsSearch(board, words[w], i, j, 0, visited)) {
                            result.add(words[w]);
                            isEnd = true;
                        }
                    }
                }
            }
            return result;
        }

        private boolean dfsSearch(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
            if (idx >= word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
                return false;
            }
            visited[i][j] = true;
            boolean next = board[i][j] == word.charAt(idx) &&
                      (dfsSearch(board, word, i + 1, j, idx + 1, visited)
                    || dfsSearch(board, word, i - 1, j, idx + 1, visited)
                    || dfsSearch(board, word, i, j + 1, idx + 1, visited)
                    || dfsSearch(board, word, i, j - 1, idx + 1, visited));
            if (!next) {
                visited[i][j] = false;
            }
            return next;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}