package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月4日 下午5:33:56 
 *
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        
        help(root);
        return root;
    }
	private void help(TreeNode root) {
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if(root.left!=null){
			help(root.left);
		}
		if(root.right!=null){
			help(root.right);
		}
	}
}
