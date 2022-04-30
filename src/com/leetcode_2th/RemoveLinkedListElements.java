package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5


 * 
 * @author Zealot
 * @date 2016年6月24日 下午5:46:49 
 *
 */
public class RemoveLinkedListElements {
	@Deprecated
	public ListNode removeElements(ListNode head, int val) {
		
		ListNode node = head;
		while(node!=null){
			if(node.val==val){
				if(node.next!=null){
					node.val = node.next.val;
					node.next = node.next.next;
				}else{
					node = null;
				}
			}
			node = node.next;
		}
		return head;
    }
	public ListNode removeElements2(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode curr = head;
		ListNode pre = dummy;
		
		while(curr!=null){
			if(curr.val == val){
				pre.next = curr.next;
			}else{
				pre = pre.next;
			}
			curr = curr.next;
		}
		
		
		
		return dummy.next;
	}
	public static void main(String[] args) {
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		
	}
}
