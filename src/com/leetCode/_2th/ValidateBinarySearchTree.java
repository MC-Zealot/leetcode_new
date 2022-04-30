package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * 
 * @author Zealot
 * @date 2016年3月18日 下午10:06:22 
 *
 */
public class ValidateBinarySearchTree {
	boolean res = true;
	/**
	 * 中序遍历为升序
	 * SPACE:O(n)
	 * TIME:O(n)
	 * @date 2016年5月13日 上午11:22:16
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
	    if(root==null){
			return true;
		}
	    List<Integer> list = new ArrayList<Integer>();
		dfs(root,list);
		for(int i = 0;i< list.size()-1;i++) {
			if(list.get(i+1)<=list.get(i)){
				return false;
			}
		}
		return res;
	}
	private void dfs(TreeNode node,List<Integer> list) {
		if(node.left!=null){
			dfs(node.left,list);
		}
		list.add(node.val);
		if(node.right!=null){
			dfs(node.right,list);
		}
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t6 = new TreeNode(12);
		TreeNode t7 = new TreeNode(20);
		t1.left = t2;
		t1.right = t3;
		t3.left = t6;
		t3.right = t7;
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		System.out.println(v.isValidBST(t1));
	}
}
