package com.leetcode_6th.supercore;

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
        preTrav(root, queue);
        StringBuffer sb = new StringBuffer();
        while(queue.size() >  0){
            sb.append(queue.poll()).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
    public void preTrav(TreeNode node, Queue<Integer> queue){
        if(node == null){
            queue.add(10000);
            return;
        }
        queue.add(node.val);
        preTrav(node.left, queue);
        preTrav(node.right, queue);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < ss.length; i++){
            queue.add(Integer.parseInt(ss[i]));
        }
        TreeNode ret = genTree(queue);
        return ret;
    }
    public TreeNode genTree(Queue<Integer> queue){
        if(queue.size() == 0){
            return null;
        }
        int val = queue.poll();
        if(val == 10000){
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = genTree(queue);
        node.right = genTree(queue);
        return node;
    }
}
