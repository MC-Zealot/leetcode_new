package com.leetcode_2th;

import java.util.HashMap;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 * 
 * @author Zealot
 * @date 2016年7月11日 下午7:05:45 
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null){
			return null;
		}
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
	}

	private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> inorderMap) {
		if (preL > preR || inL > inR) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preL]);
		int index = inorderMap.get(root.val);
		root.left = helper(preorder, preL + 1, index - inL + preL, inorder, inL, index - 1, inorderMap);
		root.right = helper(preorder, preL + index - inL + 1, preR, inorder, index + 1, inR, inorderMap);
		return root;
	}
}
