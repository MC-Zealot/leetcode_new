package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Zealot
 * @date 2015年8月22日 下午9:57:18
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1){
			return -1;
		}
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;//相当于后序遍历返回其值，深度优先遍历，比较的是每一层的2个左右节点
 
	}
	public static void main(String[] args) {
		BalancedBinaryTree b = new BalancedBinaryTree();
		TreeNode t1 = new  TreeNode(1);
		TreeNode t2 = new  TreeNode(2);
		TreeNode t3 = new  TreeNode(3);
		TreeNode t4 = new  TreeNode(4);
		TreeNode t5 = new  TreeNode(5);
		TreeNode t6 = new  TreeNode(6);
		TreeNode t7 = new  TreeNode(7);
		TreeNode t8 = new  TreeNode(8);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
//		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
//		t4.left = t8;
		System.out.println(b.isBalanced(t1));
	}
}
