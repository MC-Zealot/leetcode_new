package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 * @author Zealot
 * @date 2015年7月25日 下午8:13:39
 */
public class RemoveDuplicatesfromSortedList_83 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode node = head;
		while(node.next!=null){
			if(node.val==node.next.val){
				if(node.next.next==null){
					node.next=null;
					break;
				}
				node.next = node.next.next;
				continue;
			}

			node = node.next;
		}
		return head;
	}
	/**
	 *
	 * @date 2016年3月6日 上午10:47:04
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode node = head;
		while (node!=null) {
			if(node.next!=null&&node.next.val == node.val){
				node.next = node.next.next;
				continue;
			}
			node = node.next;
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList_83 r = new RemoveDuplicatesfromSortedList_83();
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		head.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;

		r.deleteDuplicates(head);
	}
}
