package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
        _______5______
       /              \
    ___2__          ___7__
   /      \        /      \
   0       3       6       8
            \ 				\
             4				 9
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 搜索二叉树，根节点比左边大，比又变小，并且没有重复节点
 * @author Zealot
 *
 */
public class LowestCommonAncestorofaBinarySearchTree_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) {
			return null;
		}
		if(root.val > p.val && root.val >q.val){
			return lowestCommonAncestor(root.left, p, q);
		}
		if(p.val>root.val&&q.val>root.val){
			return lowestCommonAncestor(root.right, p, q);
		}else{
			return root;
		}
		
    }
	
	public static void main(String[] args) {
		LowestCommonAncestorofaBinarySearchTree_235 m = new LowestCommonAncestorofaBinarySearchTree_235();
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
		System.out.println(m.lowestCommonAncestor(t, t5, t3).val);
	}
}
