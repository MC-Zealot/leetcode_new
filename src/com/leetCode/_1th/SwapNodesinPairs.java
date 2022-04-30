package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author Zealot
 * @date 2015年8月16日 下午7:38:35
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode point = head;
		while (point != null && point.next != null) {
			int tmp = point.val;
			point.val = point.next.val;
			point.next.val = tmp;
			point = point.next.next;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		SwapNodesinPairs s = new SwapNodesinPairs();
		ListNode reVal = s.swapPairs(l1);
		while (reVal != null) {
			System.out.println(reVal.val);
			reVal = reVal.next;
		}

	}
}
