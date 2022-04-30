package com.leetCode._2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author Zealot
 * @date 2016年1月26日 下午10:17:36
 */
public class MinimumDepthofBinaryTree {

    int depth=0;
    int tmp = 0;
    public int minDepth(TreeNode root) {
        
        if(root==null){
            return depth;
        }
        preTrace(root);
        return depth;
    }
    public void preTrace(TreeNode root){
        tmp++;
        if(root.left!=null){
            preTrace(root.left);
        }
        
        if(root.right!=null){
            preTrace(root.right); 
        }
        
        if(depth==0){
            depth = tmp;
        }
        if(root.left==null&&root.right==null&&depth>tmp){//判断为叶子节点，左右子节点都为null
            depth=tmp;
        }
        tmp--;
    }

}
