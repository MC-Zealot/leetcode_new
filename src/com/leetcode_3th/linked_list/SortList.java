package com.leetcode_3th.linked_list;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date Jul 25, 2019 4:29:21 PM 
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		ListNode head2 = walker.next;//head2走到了中间的节点
		walker.next = null;
		ListNode head1 = head;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode helper = new ListNode(0);
		helper.next = head1;
		ListNode pre = helper;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				head1 = head1.next;
			} else {
				ListNode next = head2.next;
				head2.next = pre.next;
				pre.next = head2;
				head2 = next;
			}
			pre = pre.next;
		}
		if (head2 != null) {
			pre.next = head2;
		}
		return helper.next;
	}
	
	
	public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge2(sortList(head), sortList(slow));
    }
    public ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
