package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your
 * function.
 * 
 * @author Zealot
 * @date 2015年7月21日 下午8:21:25
 */
public class DeleteNodeinaLinkedList_237 {
	public void deleteNode(ListNode node) {
		if(node!=null){
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l.next = l2;
		l2.next = l3;
		l3.next = l4;
		DeleteNodeinaLinkedList_237 d = new DeleteNodeinaLinkedList_237();
		d.deleteNode(l3);
		while(l!=null){
			System.out.println(l.val);
			l=l.next;
		}
		
	}
}
