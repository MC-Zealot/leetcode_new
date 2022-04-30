package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,3,2] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 * 
 * @author Zealot
 * @date Jul 25, 2019 9:35:47 PM
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
	}

	public void dfs(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		dfs(root.left, res);
		res.add(root.val);
		dfs(root.right, res);
	}
	
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root!=null){
			Stack<TreeNode> stack = new Stack<TreeNode>();
			Set<TreeNode> set = new HashSet<TreeNode>();//保存已经访问的节点
			stack.push(root);	
			while(stack.size() != 0){
				root = stack.peek();
				if(root.left != null && !set.contains(root.left)){
					stack.push(root.left);	
					root = root.left;
					continue;
				}
				TreeNode node = stack.pop();
				set.add(node);
				res.add(node.val);
				if(root.right != null && !set.contains(root.right)){
					stack.push(root.right);	
				}
			}
		}
		return res;
	}
}
