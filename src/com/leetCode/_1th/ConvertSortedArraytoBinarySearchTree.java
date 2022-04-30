package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST（AVL）.
 * 平衡二叉树
 * 给定一个区间[left, right]，取其中值mid=(left+right)/2对应的元素作为二叉树的根。二叉树的左子树根的值为对[left, mid-1]继续操作的结果，右子树类似。
 * @author Zealot
 * @date 2015年8月4日 下午10:09:17
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		
		TreeNode node = buildTree(0, nums.length-1, nums);
		return node;
	}
	private TreeNode buildTree(int start, int end, int[] nums) {
		if(start>end){
			return null;
		}else if(start==end){
			return new TreeNode(nums[start]);
		}
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(start, mid-1, nums);
		root.right = buildTree(mid+1, end, nums);
		return root;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3};
		ConvertSortedArraytoBinarySearchTree c = new ConvertSortedArraytoBinarySearchTree();
		TreeNode root = c.sortedArrayToBST(a);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}
}
