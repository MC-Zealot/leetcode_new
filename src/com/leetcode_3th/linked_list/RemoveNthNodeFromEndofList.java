package com.leetcode_3th.linked_list;

import com.leetCode.CommonStructure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 * 
 * @author Zealot
 * @date Jul 25, 2019 9:23:06 AM
 *
 */
public class RemoveNthNodeFromEndofList {
	/**
	 * 先扫描一遍，找到要删除节点的下标，然后再遍历一次，删除该节点
	 * 
	 * @date Jul 25, 2019 9:25:25 AM
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = new ListNode(-1);

		p.next = head;
		ListNode dummy = p;
		int count = 0;
		while (p.next != null) {
			p = p.next;
			count++;
		}
		int del_index = count - n;
		if (del_index == 0) {
			return head.next;
		}
		p = new ListNode(-1);
		p.next = head;
		// 找到要删除的前一个点p
		while (del_index > 0) {
			p = p.next;
			del_index--;
		}
		// 删除
		p.next = p.next.next;

		return dummy.next;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p = head;
		int count = 0;
		while (p != null) {
			p = p.next;
			count++;
		}
		int del_index = count - n;

		p = head;
		// 找到要删除的点p
		int index = 0;
		while (del_index > index) {
			p = p.next;
			index++;
		}
		// 删除
		if (p.next != null) {
			p.val = p.next.val;
			p.next = p.next.next;
		} else {
			p = null;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
//		l.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
		ListNode node = r.removeNthFromEnd(l, 1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
//		System.out.println(node.val);
//		System.out.println(node.next.val);
	}
}
