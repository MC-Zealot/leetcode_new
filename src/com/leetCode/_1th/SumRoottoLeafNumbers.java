package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * @author Zealot
 * @date 2015年9月6日 下午9:53:32
 */
public class SumRoottoLeafNumbers {
	String reVal = "";
	int sum =0;
	int tmp = 0;
	
	public int sumNumbers(TreeNode root) {
		
		if(root==null){
			return sum;
		}
		if(root.left==null&&root.right==null){
			return root.val;
		}
		foo(root);
		return sum;
	}
	private void foo(TreeNode root) {
		boolean sign = false; 
		tmp=root.val;
		reVal +=tmp;
		if(root.left!=null){
			foo(root.left);
			sign = true;
		}
		
		if(root.right!=null){
			foo(root.right);
			sign = true;
		}
		System.out.println(reVal);
		if(!sign){
			sum +=Integer.parseInt(reVal);
		}
		reVal = reVal.substring(0, reVal.length()-1);
	}
	public static void main(String[] args) {
		SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
//		t2.left = t4;
		t2.right = t5;
		System.out.println(s.sumNumbers(t1));
	}
}
