package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Zealot
 * @date 2015年8月16日 上午10:29:50
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1==null&&l2==null){
			return null;
		}
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode head = new ListNode(0);/////
		ListNode l = head;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				l.next= l1;
				l1=l1.next;
			}else{
				l.next=l2;
				l2=l2.next;
			}
			l= l.next;
		}
		if (l1 != null) {
            l.next = l1;
        }
        if (l2 != null) {
            l.next = l2;
        }
		return head.next;
	}
	public static void main(String[] args) {
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l4;
		
		ListNode l21 = new ListNode(1);
		ListNode l23 = new ListNode(3);
		ListNode l25 = new ListNode(5);
		l21.next = l23;
		l23.next = l25;
		
		ListNode l = m.mergeTwoLists(l1, l21);
		while(l!=null){
			System.out.print(l.val+" ");
			l=l.next;
		}
	}
}
