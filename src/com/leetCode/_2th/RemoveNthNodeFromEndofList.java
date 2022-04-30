package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 * @author Zealot
 * @date 2016年2月17日 下午8:24:23
 *
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size = 0;
		ListNode p = head;
		while(p!=null){
			size++;
			p = p.next;
		}
		if(size==n){
			return head.next;
		}
		int index = size - n + 1;
		ListNode p2 = head;
		int i = 1;
		while(p2!=null){

			if(i + 1 == index){
				p2.next=p2.next.next;
				break;
			}
			i++;
			p2 = p2.next;
		}

		return head;
	}
}
