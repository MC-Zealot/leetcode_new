package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * 
 * @author Zealot
 * @date 2016年5月10日 上午11:42:41 
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		int carry = 0;
		while(l1!=null && l2!=null) {
			int digit = l1.val + l2.val + carry;
			if(digit>=10) {
				digit -= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			ListNode listNode = new ListNode(digit);
			p.next = listNode;
			l1 = l1.next;
			l2 = l2.next;
			p = p.next;
		}
		while(l1!=null) {
			int digit = l1.val + carry;
			if(digit>=10) {
				digit -= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			ListNode listNode = new ListNode(digit);
			p.next = listNode;
			l1 = l1.next;
			p = p.next;
		}
		while(l2!=null) {
			int digit = l2.val + carry;
			if(digit>=10) {
				digit -= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			ListNode listNode = new ListNode(digit);
			p.next = listNode;
			l2 = l2.next;
			p = p.next;
		}
		if(carry==1) {
			p.next = new ListNode(carry);
		}
		
		return dummy.next;
    }
	/**
	 * 这个代码写的漂亮
	 * @date 2016年5月10日 下午12:03:55
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			int digit = x + y + carry;
			carry = digit / 10;
			digit = digit % 10;
			ListNode listNode = new ListNode(digit);
			p.next = listNode;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			p = p.next;
		}
		if (carry > 0) {
			p.next = new ListNode(carry);
		}

		return dummy.next;
	}
}
