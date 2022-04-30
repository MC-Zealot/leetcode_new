package com.leetCode._2th;

import java.util.Stack;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Zealot
 * @date 2016年3月21日 下午8:18:05 
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head==null){
			return ;
		}
		ListNode p = head;
		int size = 0;
		while(p!=null){
			size++;
			p = p.next;
		}
		if(size<=2){
			return ;
		}
		int k = (int)Math.ceil(size/2.);
		p = head;
		ListNode kp = new ListNode(-1);
		int index = 0;
		while(p!=null){
			index ++;
			if(index == k) {
				kp.next = p.next;
				p.next = null;
			}
			p = p.next;
		}
		kp = kp.next;
		Stack<Integer> s = new Stack<Integer>();
		while(kp!=null){
			s.push(kp.val);
			kp = kp.next;
		}
		p = head;
		while(p!=null&&!s.isEmpty()) {
			ListNode l = new ListNode(s.pop());
			l.next = p.next;
			p.next = l;
			p = l.next;
		}
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
		ReorderList r = new ReorderList();
		r.reorderList(l1);
	}
}
