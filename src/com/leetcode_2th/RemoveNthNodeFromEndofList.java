package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * @author Zealot
 * @date 2016年6月14日 上午11:23:36 
 *
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null){
			return null;
		}
		ListNode p = head;
		int size = 0;
		while(p!=null){
			size++;
			p = p.next;
		}
		if(size==n){
			return head.next;
		}
		int k = size - n + 1;
		if(k<=0){
			return null;
		}
		p = head;
		int i = 0;
		while(p!=null){
			i++;
			if(i==k - 1){
				p.next = p.next.next;
				break;
			}else{
				p = p.next;
			}
		}
		return head;
    }

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null)
			return null;
		int i = 0;
		ListNode runner = head;
		while (runner != null && i < n) {
			runner = runner.next;
			i++;
		}
		if (i < n)
			return head;
		if (runner == null)
			return head.next;
		ListNode walker = head;
		while (runner.next != null) {
			walker = walker.next;
			runner = runner.next;
		}
		walker.next = walker.next.next;
		return head;
	}  
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l.next = l2;
		RemoveNthNodeFromEndofList r =  new RemoveNthNodeFromEndofList();
		ListNode node = r.removeNthFromEnd(l, 1);
		System.out.println(node.val);
		System.out.println(node.next.val);
	}
}
