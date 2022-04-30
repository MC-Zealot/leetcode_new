package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Zealot
 * @date 2016年6月30日 下午2:23:46 
 *
 */
public class BinaryTreePreorderTraversal {
	/**
	 * recursive
	 * @date 2016年6月30日 下午2:27:26
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
    }
	private void dfs(TreeNode root, List<Integer> list){
		if(root==null){
			return ;
		}
		list.add(root.val);
		dfs(root.left, list);
		dfs(root.right, list);
	}
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root!=null){
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				res.add(node.val);
				if(node.right!=null){
					stack.push(node.right);
				}
				if(node.left!=null){
					stack.push(node.left);
				}
			}
		}
		
		return res;
    }
}
