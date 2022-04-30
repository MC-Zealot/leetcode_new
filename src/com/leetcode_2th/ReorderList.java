package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月18日 下午4:52:42 
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode dummy = new ListNode(0);
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            } else {
                break;
            }
        }

        ListNode temp = slow.next;
        slow.next = null;
        dummy.next = temp;
        slow = temp;
        temp = dummy;

        while (slow != null) {
            ListNode node = slow.next;
            slow.next = temp;
            temp = slow;
            slow = node;
        }

        dummy.next.next = null;
        temp = dummy;
        while (head != null) {
            temp.next = head;
            temp = temp.next;
            head = head.next;
            if (fast != null) {
                temp.next = fast;
                temp = temp.next;
                fast = fast.next;
            }
        }

    }

    public static void main(String[] args) {
    	ReorderList q = new ReorderList();
        ListNode n1 = new ListNode(1);
        ListNode pt = n1;
        for (int i = 2; i <= 4; i++) {
            pt.next = new ListNode(i);
            pt = pt.next;
        }
        q.reorderList(n1);
    }
}
