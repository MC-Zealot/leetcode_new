package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author Zealot
 * @date 2016年2月19日 上午10:43:36 
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> reVal = new ArrayList<List<Integer>>();
		if(root==null){
			return reVal;
		}
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root);
		while(q1.size()!=0 || q2.size()!=0){
			List<Integer> list1 = new ArrayList<Integer>();
			Iterator<TreeNode> iter = q1.iterator();
			while(iter.hasNext()){
				list1.add(iter.next().val);
			}
			//翻转q1
			Stack<TreeNode> tmp1 = new Stack<TreeNode>();
			while(q1.size()!=0) {
				tmp1.push(q1.poll());
			}
			while(!tmp1.isEmpty()){
				q1.offer(tmp1.pop());
			}
			
			while(q1.size()!=0) {
				TreeNode head = q1.poll();
				if(head.right!=null) q2.offer(head.right);
				if(head.left!=null) q2.offer(head.left);
			}
			if(list1.size()!=0){
				reVal.add(list1);
			}
			List<Integer> list2 = new ArrayList<Integer>();
			Iterator<TreeNode> iter2 = q2.iterator();
			while(iter2.hasNext()){
				list2.add(iter2.next().val);
			}
			//翻转q2
			Stack<TreeNode> tmp = new Stack<TreeNode>();
			while(q2.size()!=0) {
				tmp.push(q2.poll());
			}
			while(!tmp.isEmpty()){
				q2.offer(tmp.pop());
			}
			
			while(q2.size()!=0) {
				TreeNode head = q2.poll();
				if(head.left!=null) q1.offer(head.left);
				if(head.right!=null) q1.offer(head.right);
				
			}
			if(list2.size()!=0){
				reVal.add(list2);
			}
		}
		return reVal;
	}
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		List<List<Integer>> list = b.zigzagLevelOrder(t1);
		for(List<Integer> l: list){
			System.out.println(l.toString());
		}
	}
}
