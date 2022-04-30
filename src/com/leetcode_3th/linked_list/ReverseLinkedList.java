package com.leetcode_3th.linked_list;

import java.util.Stack;

import com.leetCode.CommonStructure.ListNode;

/**
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 10:16:17 PM
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		Stack<Integer> s = new Stack<Integer>();
		while(head!=null) {
			s.push(head.val);
			head = head.next;
		}
		ListNode p = new ListNode(0);
		ListNode res = p;
		while(s.size()>0) {
			p.next = new ListNode(s.pop());
			p = p.next;
		}
		return res.next;
	}
}
