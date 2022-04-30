package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月19日 下午4:57:19 
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null || nums.length==0)  
	        return null;  
		return helper(nums, 0, nums.length-1);
	}

	private TreeNode helper(int[] nums, int l, int r) {
		if(l>r){
			return null;
		}
		int m = (l + r)/2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = helper(nums, l, m-1);
		root.right = helper(nums, m+1, r);
		return root;
	}
}
