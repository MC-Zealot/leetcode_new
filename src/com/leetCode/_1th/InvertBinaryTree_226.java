package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * @author Zealot
 * @date 2015年7月22日 下午5:58:02
 */
public class InvertBinaryTree_226 {
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return null;
		}
		invertTree2(root);
		return root;
	}
	public void invertTree2(TreeNode root) {
		if(root.left!=null||root.right!=null){
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
		if(root.left!=null){
			invertTree(root.left);
		}
		if(root.right!=null){
			invertTree(root.right);
		}
	}
	public static void main(String[] args) {
		TreeNode t =new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 =new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t.left=t2;
		t.right=t3;
		t3.left = t4;
		t3.right = t5;
		t4.right = t6;
		InvertBinaryTree_226 i = new InvertBinaryTree_226();
		i.invertTree(t);
	}
}
