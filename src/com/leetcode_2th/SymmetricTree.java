package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * 
 * @author Zealot
 * @date 2016年6月18日 下午4:16:21 
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		
		return preOrder(root.left, root.right);
	}
	private boolean preOrder(TreeNode left, TreeNode right) {
		//如果都为空，则真
		if(left==null&&right==null){
			return true;
		}
		//如果有一对不相等，则是假
		if(left==null && right!=null){
			return false;
		}
		if(left!=null && right==null){
			return false;
		}
		
		if(left.val != right.val){
			return false;
		}
		boolean r1 = preOrder(left.left, right.right);
		if(r1==false){
			return false;
		}
		boolean r2 =preOrder(left.right, right.left);
		if(r2==false){
			return false;
		}
		
		return true;
	}
}
