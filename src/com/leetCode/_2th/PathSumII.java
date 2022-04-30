package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 *
 * @author Zealot
 * @date 2016年2月23日 下午9:48:23
 *
 */
public class PathSumII {
	int s = 0;
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> tmp = new ArrayList<Integer>();
		blTree(root, sum, tmp);
		return list;
	}
	private void blTree(TreeNode root, int sum, List<Integer> tmp) {
		if(root==null){
			return;
		}
		s+=root.val;
		tmp.add(root.val);
		if(root.left==null&&root.right==null&&s==sum){
			List<Integer> t = new ArrayList<Integer>();
			for(Integer i: tmp){
				t.add(i);
			}
			list.add(t);
		}
		if(root.left!=null){
			blTree(root.left, sum, tmp) ;
		}
		if(root.right!=null){
			blTree(root.right, sum, tmp) ;
		}
		tmp.remove(tmp.size()-1);
		s-=root.val;
	}
	public static void main(String[] args) {
		PathSumII p = new PathSumII();
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(5);
		TreeNode t10 = new TreeNode(1);
		/**
		 * Given the below binary tree and sum = 22,
		 5
		 / \
		 4   8
		 /   / \
		 11  13  4
		 /  \    / \
		 7    2  5   1
		 */
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t4.left = t7;
		t4.right = t8;
		t6.left = t9;
		t6.right = t10;
		List<List<Integer>> list = p.pathSum(t1, 22);
		for(List<Integer> l: list){
			System.out.println(l.toString());
		}




	}
}
