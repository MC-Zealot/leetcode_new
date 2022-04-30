package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 * @author Zealot
 * @date 2015年8月31日 下午7:50:21
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode start = head;
		do{
			if(slow==null||fast==null||fast.next==null){
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}while(fast!=slow);
		
		while(start!=slow){
			start = start.next;
			slow = slow.next;
		};
		return start;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		head.next = head2;
		LinkedListCycleII l = new LinkedListCycleII();
		System.out.println(l.detectCycle(head2));
	}
}
