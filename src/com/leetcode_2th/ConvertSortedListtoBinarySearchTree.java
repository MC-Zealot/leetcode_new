package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.CommonStructure.ListNode;
import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月20日 下午1:55:05
 *
 */
public class ConvertSortedListtoBinarySearchTree {
	private ListNode list;

	private TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode leftChild = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}

	public TreeNode sortedListToBST(ListNode head) {
		Map map = new HashMap();
		int n = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}
	
}
