package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * 
 * @author Zealot
 * @date 2016年7月14日 下午10:32:52 
 *
 */
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			count++;
			ListNode next = cur.next;
			if (count == k) {
				pre = reverse(pre, next);
				count = 0;
			}
			cur = next;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode pre, ListNode end) {
		if (pre == null || pre.next == null)
			return pre;
		ListNode head = pre.next;
		ListNode cur = pre.next.next;
		while (cur != end) {
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		head.next = end;
		return head;
	}
}
