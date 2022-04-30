package com.leetcode_2th;

import java.util.Stack;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

 * @author Zealot
 * @date 2016年7月4日 下午4:41:37 
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		//stack
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while(pre.next!=null){
			index++;
			if (index <= n && index >= m) {
				stack.push(pre.next.val);
				pre.next = pre.next.next;
			}else{
				pre = pre.next;
			}
		}
		pre = dummy;
		index = 0;
		while(pre.next!=null||!stack.isEmpty()){
			index++;
			if (index <= n && index >= m) {
				ListNode tmp  = pre.next;
				pre.next = new ListNode(stack.pop());
				pre.next.next = tmp;
			}
			pre = pre.next;
			
		}
		return dummy.next;
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
		ReverseLinkedListII r = new ReverseLinkedListII();
		// r.reverse(l1);
		ListNode head = r.reverseBetween(l1, 1, 4);
		while(head!=null){
			System.out.print(" "+head.val);
			head = head.next;
		}
		System.out.println();
	}
}
