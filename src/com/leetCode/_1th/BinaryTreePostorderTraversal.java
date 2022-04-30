package com.leetCode._1th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, return [3,2,1].
 * 
 * @author Zealot
 * @date 2015年8月12日 下午9:55:10
 */
public class BinaryTreePostorderTraversal {
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root==null){
			return new ArrayList<Integer>();
		}
		pt(root);
		return list;
	}
	private void pt(TreeNode root) {
		if(root!=null){
			if(root.left!=null){
				pt(root.left);
			}
			if(root.right!=null){
				pt(root.right);
			}
			list.add(root.val);
		}
	}
}
