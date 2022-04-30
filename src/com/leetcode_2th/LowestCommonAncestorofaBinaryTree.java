package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v 
and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 since a node can be a descendant of itself according to the LCA definition.
 * @author Zealot
 * @date 2016年7月2日 下午3:26:28 
 *
 */
public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) { return root; }//如果已经找到p,q返回，或者root为null，返回null
        TreeNode left = lowestCommonAncestor(root.left, p, q);//先在左子树找
        TreeNode right = lowestCommonAncestor(root.right, p, q);//再找右子树
        if(left != null && right != null){//如果左右子树分别有一个，则返回根节点
            return root;
        }else if(left!=null){//如果只在左子树，返回left
            return left;
        }else{//如果只在右子树，返回right
            return right;
        }
    }
}
