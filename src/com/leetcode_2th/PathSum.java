package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月18日 下午4:40:02 
 *
 */
public class PathSum {
	boolean res = false;
	int cur = 0;
	public boolean hasPathSum(TreeNode root, int sum) {
		dfs(root, sum);
		return res;
    }
	private void dfs(TreeNode root, int sum) {
		if(root==null){
			return ;
		}
		cur = cur + root.val;
		if(root.left==null && root.right==null){
			if(cur==sum){
				res = true;
			}
		}
		dfs(root.left, sum);
		dfs(root.right, sum);
		cur = cur - root.val;
	}
}
