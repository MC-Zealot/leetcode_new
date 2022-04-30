package com.leetcode_2th;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Zealot
 * @date 2016年7月7日 下午12:00:44 
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}
}
