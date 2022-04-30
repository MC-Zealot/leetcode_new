package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author Zealot
 * @date 2015年9月7日 下午8:23:18
 */
public class KthSmallestElementinaBST {
	int index=0;
	int reVal = 0;
	public int kthSmallest(TreeNode root, int k) {
		if(root==null){
			return 0;
		}
		if(root.left!=null){
			kthSmallest(root.left,  k);
		}
		index++;
		if(k==index){
			reVal = root.val;
		}
		if(root.right!=null){
			kthSmallest(root.right,  k);
		}
		
		return reVal;
	}
	public static void main(String[] args) {
		KthSmallestElementinaBST k = new KthSmallestElementinaBST();
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println(k.kthSmallest(t1, 2));
		
		
	}
}
