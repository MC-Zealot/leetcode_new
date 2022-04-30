package com.leetCode._2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Zealot
 * @date 2016年1月20日 下午9:42:09
 */
public class PathSum {
	 int s = 0;
	 boolean flag = false;
	    public boolean hasPathSum(TreeNode root, int sum) {
	        if(root==null){
	            return false;
	        }
	        
	        blTree(root,sum);
	        return flag;
	    }
	    public void blTree(TreeNode node, int sum){
	        s+=node.val;
	        if(node.left==null&&node.right==null){//左右子节点都为空的时候，说明是叶子节点。这个时候判断和是否与给定数相等
	        	if(s==sum){
	        		flag=true;
	        		return ;
	        	}
	        }
	        if(node.left!=null){
	            blTree(node.left,sum);
	        }
	        
	        if(node.right!=null){
	            blTree(node.right,sum);
	        }
	        s-=node.val;
	    }
	    public static void main(String[] args) {
	    	PathSum ps = new PathSum();
	    	TreeNode t1 = new TreeNode(1);
	    	TreeNode t2 = new TreeNode(2);
	    	TreeNode t3 = new TreeNode(8);
	    	TreeNode t4 = new TreeNode(11);
	    	TreeNode t5 = new TreeNode(13);
	    	TreeNode t6 = new TreeNode(4);
	    	TreeNode t7 = new TreeNode(7);
	    	TreeNode t8 = new TreeNode(2);
	    	t1.left = t2;
//	    	t1.right = t3;
//	    	t2.left = t4;
//	    	t3.left = t5;
//	    	t3.right = t6;
//	    	t4.left = t7;
//	    	t4.right = t8;
	    	
	    	
	    	System.out.println(ps.hasPathSum(t1, 1));
		}
}
