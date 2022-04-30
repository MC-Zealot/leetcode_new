package com.leetcode_3th.tree;

import java.util.HashMap;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


 * 
 * @author Zealot
 * @date Jul 28, 2019 3:35:36 PM 
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
	private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> inorderMap) {
		if (preL > preR || inL > inR) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preL]);
		int index = inorderMap.get(root.val);
		root.left = helper(preorder, preL + 1, index - inL + preL, inorder, inL, index - 1, inorderMap);//index - inL等于左子树节点个数的size
		root.right = helper(preorder, preL + index - inL + 1, preR, inorder, index + 1, inR, inorderMap);
		return root;
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		TreeNode root7 = new TreeNode(7);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		int[] preorder = {1,2,4,5,3,6,7};
		int[] inorder = {4,2,5,1,6,3,7};
		ConstructBinaryTreefromPreorderandInorderTraversal c =new ConstructBinaryTreefromPreorderandInorderTraversal();
		c.buildTree(preorder, inorder);
	}
}
