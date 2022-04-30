package com.leetCode._1th;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * @author Zealot
 * @date 2015年7月21日 下午8:39:38
 */
public class BinaryTreeInorderTraversal_94 {

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return list;
		}
		if (root.left != null) {
			inorderTraversal(root.left);
		}
		list.add(root.val);
		if (root.right != null) {
			inorderTraversal(root.right);
		}
		return list;
	}
	/**
	 * 非递归中序遍历
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t.left = t2;
		t.right = t3;
		t3.left = t4;
		t3.right = t5;
		t4.right = t6;
		BinaryTreeInorderTraversal_94 b = new BinaryTreeInorderTraversal_94();
		List<Integer> list = b.inorderTraversal(t);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
