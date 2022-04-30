package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * @author Zealot
 * @date 2016年6月8日 下午12:03:03 
 *
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}else if((p==null&&q!=null)||(p!=null&&q==null)){
			return false;
		}else if(p.val==q.val){
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
        return false;
    }
}
