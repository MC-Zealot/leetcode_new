package com.leetcode_3th.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1
 * 的最近公共祖先是节点 3。 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4
 * 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。  
 * 
 * 说明:
 * 
 * 所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
 * 
 * 
 * @author Zealot
 * @date Jul 29, 2019 10:07:46 AM
 *
 */
public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode res = null;
		if (root == null || p == null || q == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (queue.size() > 0) {
			TreeNode node = queue.poll();
			boolean isC = isContainsNode(node, p, q);
			if (isC == false) {
				continue;
			}
			res = node;
			queue.add(node.left);
			queue.add(node.right);
		}

		return res;
	}

	public boolean isContainsNode(TreeNode root, TreeNode p, TreeNode q) {
		int[] flags = new int[2];
		boolean res = false;
		dfs(root, p, q, flags);
		if (flags[0] == 1 && flags[1] == 1) {
			res = true;
		}
		return res;
	}

	public void dfs(TreeNode root, TreeNode p, TreeNode q, int[] flags) {
		if (root == null) {
			return;
		}
		if (root.val == p.val) {
			flags[0] = 1;
		} else if (root.val == q.val) {
			flags[1] = 1;
		}
		dfs(root.left, p, q, flags);
		dfs(root.right, p, q, flags);
	}
}
