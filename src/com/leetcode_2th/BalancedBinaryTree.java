package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 高度差<=1
 * @author Zealot
 * @date 2016年5月16日 下午1:28:11
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t.left = t2;
		t.right = t3;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t5.left = t7;
		BalancedBinaryTree b =  new BalancedBinaryTree();
		System.out.println(b.isBalanced(t));
	}
}
