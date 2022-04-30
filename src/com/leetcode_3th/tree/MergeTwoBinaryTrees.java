package com.leetcode_3th.tree;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * 
 * @author Zealot
 * @date Jul 29, 2019 5:45:54 PM 
 *
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null) {
			return t2;
		}
		if(t2==null) {
			return t1;
		}
		dfs(t1, t2);
		return t1;
	}
	public void dfs(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null) {
			return;
		} else if(t1!=null && t2!=null) {
			t1.val = t1.val + t2.val;
			if(t1.left==null) {
				t1.left = t2.left;
			}else {
				dfs(t1.left, t2.left);
			}
			if(t1.right==null) {
				t1.right = t2.right;
			}else {
				dfs(t1.right, t2.right);
			}
			
		}
	}
}
