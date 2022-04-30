package com.leetcode_3th.tree;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

 * @author Zealot
 * @date Jul 29, 2019 2:56:53 PM 
 *
 */
public class DiameterofBinaryTree {
	/**
	 * 计算每一个节点左右子树的最大深度，然后相加备选
	 * @date Jul 29, 2019 3:11:31 PM
	 * @param root
	 * @return
	 */
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        max = Math.max(max, helper(root.left) + helper(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}
