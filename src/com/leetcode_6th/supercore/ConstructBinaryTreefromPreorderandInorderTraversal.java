package com.leetcode_6th.supercore;

import com.leetCode.CommonStructure.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder);
    }
    public TreeNode dfs(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode node = new TreeNode(rootVal);
        if(preorder.length == 1){
            return node;
        }
        int p = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                p = i;
                break;
            }
        }
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + p);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, p);
        node.left = dfs(preorderLeft, inorderLeft);

        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + p, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, p + 1, inorder.length);
        node.right = dfs(preorderRight, inorderRight);
        return node;
    }
}
