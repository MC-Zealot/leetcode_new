package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 *
 * @Description:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author Zealot
 * @date 2016年2月16日 上午11:43:30
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {

		if(head==null||head.next==null){
			return head;
		}
		ListNode smallList = new ListNode(-1);
		ListNode bigList = new ListNode(-1);
		ListNode smallHead = smallList;
		ListNode bigHead = bigList;
		while(head!=null){
			if(head.val < x){
				smallList.next = new ListNode(head.val);
				smallList = smallList.next;
			}else{
				bigList.next = new ListNode(head.val);
				bigList = bigList.next;
			}
			head = head.next;
		}
		smallList.next = bigHead.next;

		return smallHead.next;

	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		PartitionList p = new PartitionList();
		ListNode l = p.partition(l1, 1);
		while(l.next!=null){
			System.out.println(l.val);
			l = l.next;
		}
	}
}
