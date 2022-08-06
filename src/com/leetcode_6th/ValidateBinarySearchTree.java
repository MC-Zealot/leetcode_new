package com.leetcode_6th;

import com.leetCode.CommonStructure.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    public boolean helper(TreeNode node, Integer low, Integer upper){
        if(node == null) {
            return true;
        }
        if((low!=null && low >= node.val)|| (upper!=null && upper <= node.val)){
            return false;
        }
        return helper(node.left, low, node.val) && helper(node.right, node.val, upper);
    }
}
