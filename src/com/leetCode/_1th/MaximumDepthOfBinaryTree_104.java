package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;



/**
 * 
 Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * 
 * @author Zealot
 *
 *         Definition for a binary tree node. public class TreeNode { int val;
 *         TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class MaximumDepthOfBinaryTree_104 {
	int depth = 0;
	int now = 0;

	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		now++;
		if(now>depth) {
			depth=now;
		}
		if (root.left != null) {
			maxDepth(root.left);
		}
		if (root.right != null) {
			maxDepth(root.right);
		}
		now--;
		return depth;
	}
	public int maxDepth2(TreeNode root) {
		if(root==null){
			return 0;
		}
		
		return 1+ Math.max(maxDepth2(root.left), maxDepth2(root.right));
	}
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree_104 m = new MaximumDepthOfBinaryTree_104();
		TreeNode t =new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 =new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t.left=t2;
		t.right=t3;
		t3.left = t4;
		t3.right = t5;
		t4.right = t6;
		int d = m.maxDepth2(t);
		System.out.println(d);
		
	}

}

