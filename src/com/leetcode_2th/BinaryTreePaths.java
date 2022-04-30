package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 * 
 * @author Zealot
 * @date 2016年7月19日 下午10:13:12 
 *
 */
public class BinaryTreePaths {
	String tmp = "";
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if(root==null){
			return res;
		}
		bl(root, res);
		return res;
	}
	private void bl(TreeNode root,List<String> res) {
		if(root==null){
			return;
		}
		tmp = tmp +root.val+ "->";
		if(root.left==null && root.right ==null){
			res.add(tmp.substring(0, tmp.lastIndexOf("->")));
		}

		if(root.left!=null){
			bl(root.left, res);
			String[] ss = tmp.split("->");
			StringBuffer sb =new StringBuffer();
			for(int i = 0; i < ss.length-1;i++){
				sb.append(ss[i]).append("->");
			}
			tmp = sb.toString();
		}
		if(root.right!=null){
			bl(root.right, res);
			String[] ss = tmp.split("->");
			StringBuffer sb =new StringBuffer();
			for(int i = 0; i < ss.length-1;i++){
				sb.append(ss[i]).append("->");
			}
			tmp = sb.toString();
		}

	}
}
