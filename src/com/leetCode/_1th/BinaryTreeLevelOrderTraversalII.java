package com.leetCode._1th;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author Zealot
 * @date 2015年9月4日 下午7:27:36
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null){
			return new LinkedList<List<Integer>>();
		}
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//使用队列当作容器

		queue.offer(root);
		while (!queue.isEmpty()) {//使用循环，进行层次遍历树
			int levelNum = queue.size();//层级有多少个节点
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {//每一个节点都遍历其子节点
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				subList.add(queue.poll().val);
			}
			wrapList.add(0, subList);//倒序插入
		}
		return wrapList;
	}
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		

		System.out.println(b.levelOrderBottom(t1).toString());
	}
}
