package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Zealot
 * @date 2016年2月23日 上午10:45:25 
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode node = head;
		while(node!=null){
			if(node.val == val){
				if(node.next!=null){
					node.val = node.next.val;
					node.next = node.next.next;
				}else{
					node = null;//只是把node指针指向null,原链表并没有改变
					break;
				}
			} 
			node = node.next;
		}
		
		return head;
    }
	public ListNode removeElements2(ListNode head, int val) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode curr = head;
		ListNode pre = fakeHead;
		
		while(curr!=null){
			if(curr.val == val){
				pre.next = curr.next;
			}else{
				pre = pre.next;
			}
			curr = curr.next;
		}
		
		
		
		return fakeHead.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next= l6;
		l6.next = l7;
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		ListNode l = r.removeElements(l1, 6);
		while(l!=null){
			System.out.print(l.val+" ");
			l = l.next;
		}
	}
	
}
