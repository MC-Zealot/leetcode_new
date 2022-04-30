package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * @author Zealot
 * @date 2015年8月16日 下午4:52:30
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode p = null;
		while(head!=null){
			ListNode tmp = new ListNode(head.val);
			tmp.next = p;
			p=tmp;
			head = head.next;
		}
		return p;
	}
	public ListNode reverseList2(ListNode head) {
        ListNode newNode = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = newNode;
            newNode = head;
            head = tmp;
        }
        return newNode;
    }
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
//		while(l1!=null){
//			System.out.println(l1.val);
//			l1 = l1.next;
//		}
		ListNode newNode =r.reverseList(l1);
		System.out.println(newNode);
		while(newNode!=null){
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}
}
