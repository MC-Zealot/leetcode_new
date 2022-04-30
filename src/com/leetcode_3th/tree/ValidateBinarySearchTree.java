package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

public class ValidateBinarySearchTree {
	boolean res = true;
	/**
	 * 中序遍历为升序
	 * SPACE:O(n)
	 * TIME:O(n)
	 * @date 2016年5月13日 上午11:22:16
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
	    if(root==null){
			return true;
		}
	    List<Integer> list = new ArrayList<Integer>();
		dfs(root,list);
		for(int i = 0;i< list.size()-1;i++) {
			if(list.get(i+1)<=list.get(i)){
				return false;
			}
		}
		return res;
	}
	private void dfs(TreeNode node,List<Integer> list) {
		if(node.left!=null){
			dfs(node.left,list);
		}
		list.add(node.val);
		if(node.right!=null){
			dfs(node.right,list);
		}
	}
}
