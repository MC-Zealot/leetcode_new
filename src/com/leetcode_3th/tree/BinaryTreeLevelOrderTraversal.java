package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

 * 
 * @author Zealot
 * @date Jul 28, 2019 2:38:52 PM 
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		pre_iter(root, res);
		return res;
	}
	public void pre_iter(TreeNode root, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(root.val);
		res.add(tmp);
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root.left != null) {
			q.add(root.left);
		}
		if (root.right != null) {
			q.add(root.right);
		}
		if(root.left == null && root.right == null) {
			return ;
		}
		List<TreeNode> H_list = new ArrayList<TreeNode>();//每一层的树节点
		tmp = new ArrayList<Integer>();//每一层的val值
		while (q.size() > 0) {
			TreeNode node = q.poll();
			H_list.add(node);
			tmp.add(node.val);
			if (q.size() > 0) {
				continue;
			}

			for (int i = 0; i < H_list.size(); i++) {
				if (H_list.get(i).left != null) {
					q.add(H_list.get(i).left);
				}
				if (H_list.get(i).right != null) {
					q.add(H_list.get(i).right);
				}
			}
			if(tmp.size()>0) {
				res.add(tmp);	
			}
			tmp = new ArrayList<Integer>();//每一层的val值
			H_list = new ArrayList<TreeNode>();
		}
	}
}
