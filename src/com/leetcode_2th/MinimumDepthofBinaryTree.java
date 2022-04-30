package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月13日 下午5:44:01 
 *
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left==null){
			return minDepth(root.right) + 1;
		}
		if(root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	public static void main(String[] args) {
		MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		root.left = root2;
		root.right = root3;
		root2.right = root4;
		root3.left = root5;
		root3.right = root6;
		System.out.println(m.minDepth(root));
	}
}
