package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * @author Zealot
 * @date 2015年9月2日 下午9:55:04
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
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(3);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		SymmetricTree s = new SymmetricTree();
		System.out.println(s.isSymmetric(t1));
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t1 = new TreeNode(1);
	}
}
