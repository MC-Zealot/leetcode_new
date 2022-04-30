package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example, given the below binary tree,
1 /\ 24
/\ 23
The highlighted path yields the maximum sum 10.
 * 
 * @author Zealot
 * @date 2016年5月20日 下午8:41:52 
 *
 */
public class BinaryTreeMaximumPathSum {
	private int maxSum;
	public int maxPathSum(TreeNode root) {
	   maxSum = Integer.MIN_VALUE;
	   findMax(root);
	   return maxSum;
	}
	private int findMax(TreeNode p) {
	   if (p == null) return 0;
	   int left = findMax(p.left);
	   int right = findMax(p.right);
	   maxSum = Math.max(p.val + left + right, maxSum);
	   int ret = p.val + Math.max(left, right);
	   return ret > 0 ? ret : 0;
	}
}
