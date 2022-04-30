package com.leetCode._2th;

import java.util.HashMap;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 前序:根节点
 * 中序：左子树、右子树
 * @author Zealot
 * @date 2016年2月18日 下午8:33:01
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, map);
	}

	private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder,
			int inL, int inR, HashMap<Integer, Integer> map) {
		if (preL > preR || inL > inR)
			return null;
		TreeNode root = new TreeNode(preorder[preL]);
		int index = map.get(root.val);
		root.left = helper(preorder, preL + 1, index - inL + preL, inorder,
				inL, index - 1, map);
		root.right = helper(preorder, preL + index - inL + 1, preR, inorder,
				index + 1, inR, map);
		return root;
	}

}
