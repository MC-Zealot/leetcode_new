package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example: 
 * Given 1->2->3->4->5->NULL, 
 * return 1->3->5->2->4->NULL.
 * 
 * Note: The relative order inside both the even and odd groups should remain as
 * it was in the input. The first node is considered odd, the second node even
 * and so on ...
 * 
 * @author Zealot
 * @date 2016年1月19日 下午8:51:46
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode oddPointer=null;
		ListNode tmpOddHead=null;
		ListNode evenPointer=null;
		ListNode tmpEvenHead=null;
		while(head!=null){
			ListNode tmpA = new ListNode(head.val);
			if(head.next!=null){
				ListNode tmpB = new ListNode(head.next.val);
				head = head.next.next;  
				if(oddPointer==null){
					oddPointer=tmpA;
					tmpOddHead=oddPointer;
				}else{
					oddPointer.next = tmpA;
					oddPointer = oddPointer.next;
				}
				if(evenPointer==null){
					evenPointer=tmpB;
					tmpEvenHead = evenPointer;
				}else{
					evenPointer.next = tmpB;
					evenPointer = evenPointer.next;
				}
			}else{
				oddPointer.next = tmpA;
				oddPointer = oddPointer.next;
				break;
			}
			
		}
		oddPointer.next = tmpEvenHead;
		
		return tmpOddHead;
	}
	public ListNode oddEvenList2(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode oddPointer=head;
		ListNode tmpOddHead=head;
		ListNode evenPointer=head.next;
		ListNode tmpEvenHead = head.next;
		while(head.next.next!=null){
			head = head.next.next;
			ListNode tmpA = new ListNode(head.val);
			if(head.next!=null){
				ListNode tmpB = new ListNode(head.next.val);
				oddPointer.next = tmpA;
				oddPointer = oddPointer.next;
				evenPointer.next = tmpB;
				evenPointer = evenPointer.next;
			}else{
				oddPointer.next = tmpA;
				oddPointer = oddPointer.next;
				evenPointer.next = null;
				break;
			}
			
		}
		oddPointer.next = tmpEvenHead;
		
		return tmpOddHead;
	}
	public static void main(String[] args) {
		OddEvenLinkedList oll = new OddEvenLinkedList();
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		ListNode head6 = new ListNode(6);
		ListNode head7 = new ListNode(7);
		ListNode head8 = new ListNode(8);
		
		head1.next = head2;
		head2.next = head3;
//		head3.next = head4;
//		head4.next = head5;
//		head5.next = head6;
//		head6.next = head7;
//		head7.next = head8;
		ListNode reList = oll.oddEvenList2(head1);
		while(reList!=null){
			System.out.print(reList.val+" ");
			reList = reList.next;
		}
	}
}
