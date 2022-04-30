package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Zealot
 * @date 2016年7月12日 下午4:10:14 
 *
 */
public class BinaryTreePostorderTraversal {
	
	/**
	 * recursion
	 * dfs
	 * @date 2016年7月12日 下午4:12:46
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
    }
	private void dfs(TreeNode root, List<Integer> res) {
		if(root==null){
			return ;
		}
		dfs(root.left, res);
		dfs(root.right, res);
		res.add(root.val);
	}
	
	public List<Integer> postorderTraversal2(TreeNode p) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				TreeNode temp = stack.peek().right;
				if (temp == null || temp == prev) {
					node = stack.pop();
					res.add(node.val);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
		return res;
	}
}
