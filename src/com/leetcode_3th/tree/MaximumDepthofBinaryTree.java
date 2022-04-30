package com.leetcode_3th.tree;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * 3 / \ 9 20 / \ 15 7 返回它的最大深度 3 。
 * 
 * 
 * @author Zealot
 * @date Jul 28, 2019 3:05:32 PM
 *
 */
public class MaximumDepthofBinaryTree {

	int max = 0;

	public int maxDepth(TreeNode root) {

		int depth = 0;
		dfs(root, depth);
		return max;
	}

	public void dfs(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		depth++;
		if (depth > max) {
			max = depth;
		}
		dfs(root.left, depth);
		dfs(root.right, depth);
		depth--;
	}
}
