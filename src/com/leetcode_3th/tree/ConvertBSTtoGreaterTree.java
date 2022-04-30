package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 例如：
 * 
输入: 二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
 * 
 * 2 5 13
 * 20 18 13
 * @author Zealot
 * @date Jul 29, 2019 2:36:48 PM
 *
 */
public class ConvertBSTtoGreaterTree {
	public TreeNode convertBST(TreeNode root) {
		if(root==null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		dfs(root, list);
		Collections.sort(list);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int tmp = 0;
		for(int i = list.size()-1; i >=0; i--) {
			tmp += list.get(i);
			map.put(list.get(i), tmp);
		}
		
		dfs2(root, map);
	
		return root;
	}
	public void dfs(TreeNode root, List<Integer> list) {
		if(root==null) {
			return;
		}
		list.add(root.val);
		dfs(root.left,list);
		dfs(root.right,list);
	}
	public void dfs2(TreeNode root, Map<Integer, Integer> map) {
		if(root==null) {
			return;
		}
		root.val = map.get(root.val);
		dfs2(root.left,map);
		dfs2(root.right,map);
	}
	public static void main(String[] args) {
		ConvertBSTtoGreaterTree c = new ConvertBSTtoGreaterTree();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(13);
		n1.left = n2;
		n1.right = n3;
		c.convertBST(n1);
	}
}
