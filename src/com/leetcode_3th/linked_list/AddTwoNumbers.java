package com.leetcode_3th.linked_list;

import com.leetCode.CommonStructure.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 
 * @author Zealot
 * @date Jul 24, 2019 9:16:51 PM
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		int digit = 0;
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		while (l1 != null && l2 != null) {
			digit = l1.val + l2.val + carry;
			if (digit >= 10) {
				carry = 1;
				digit = digit - 10;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(digit);
			l1 = l1.next;
			l2 = l2.next;
			dummy = dummy.next;
		}
		digit = 0;
		while (l1 != null) {
			digit = l1.val + carry;
			if (digit >= 10) {
				carry = 1;
				digit = digit - 10;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(digit);
			l1 = l1.next;
			dummy = dummy.next;
		}
		digit = 0;
		while (l2 != null) {
			digit = l2.val + carry;
			if (digit >= 10) {
				carry = 1;
				digit = digit - 10;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(digit);
			l2 = l2.next;
			dummy = dummy.next;
		}
		if(carry==1) {
			dummy.next = new ListNode(carry);
		}
		return res.next;
	}
}
