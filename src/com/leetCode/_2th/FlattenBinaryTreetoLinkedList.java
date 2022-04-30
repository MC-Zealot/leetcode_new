package com.leetCode._2th;

import java.util.LinkedList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
这道题前序遍历存到list中后，还需要改变原来的树结构
 * @author Zealot
 * @date 2016年1月21日 下午8:51:30
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }
        List<Integer> list = new LinkedList<Integer>();
        blTree(root,list);
        for(int i = 1; i < list.size(); i++) {
        	root.left=null;
        	root.right= new TreeNode(list.get(i));
        	root = root.right;
        }
    }
    public void blTree(TreeNode node, List<Integer> list){
        list.add(node.val);
        if(node.left!=null){
	        blTree(node.left,list);
	    }
	        
	    if(node.right!=null){
	        blTree(node.right,list);
	    }
    }
    public static void main(String[] args) {
    	FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	TreeNode t5 = new TreeNode(5);
    	TreeNode t6 = new TreeNode(6);
    	t1.left = t2;
    	t1.right = t5;
    	t2.left = t3;
    	t2.right = t4;
    	t5.right = t6;
    	f.flatten(t1);
	}
}
