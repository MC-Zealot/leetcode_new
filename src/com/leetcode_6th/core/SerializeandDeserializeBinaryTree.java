package com.leetcode_6th.core;

import com.leetCode.CommonStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        preIter(root, queue);
        StringBuffer sb = new StringBuffer();
        while(queue.size() > 0){
            int val = queue.poll();
            sb.append(val).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
    public void preIter(TreeNode node, Queue<Integer> q){
        if(node == null){
            q.add(10000);
            return;
        }
        q.add(node.val);
        preIter(node.left, q);
        preIter(node.right,q);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<Integer> queue = new LinkedList<>();
        String[] ss = data.split(",");
        for(int i = 0; i < ss.length; i++){
            String str = ss[i];
            queue.add(Integer.parseInt(str));
        }
        return preIterInitTree(queue);
    }
    public TreeNode preIterInitTree(Queue<Integer> queue){
        if(queue.size() == 0){
            return null;
        }else if(queue.peek() == 10000){
            queue.poll();
            return null;
        }
        int val = queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = preIterInitTree(queue);
        node.right = preIterInitTree(queue);
        return node;
    }
}
