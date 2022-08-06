package com.leetcode_6th;

import com.leetCode.CommonStructure.TreeNode;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);

        return Math.max(1+a, 1 + b);
    }
}
