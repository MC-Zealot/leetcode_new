package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * 
 *  Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 * 
 * @author Zealot
 * @date 2016年6月20日 上午11:07:31 
 *
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode odd = head;//奇数
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;//奇数前边那一位
		ListNode lPre = dummy;//前边那些奇数的最后一位
		while(odd!=null){
			System.out.println(odd.val);
			ListNode tmp = null;
			if(odd.next!=null&& odd.next.next!=null){
				tmp = odd.next.next;//fast的下个指针
			}
			pre.next = odd.next;//原链表删掉fast
			pre = pre.next;
			odd.next = lPre.next;//把fast移到前边
			lPre.next = odd;
			lPre = lPre.next;
			odd = tmp;
		}
		return dummy.next;
    }
	public static void main(String[] args) {
		OddEvenLinkedList o = new OddEvenLinkedList();
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		for(int i = 0; i < 1; i++) {
			p.next = new ListNode(i+1);
			p = p.next;
		}
		ListNode res = o.oddEvenList(dummy.next);
		while(res!=null){
			System.out.print(res.val+"\t");
			res = res.next;
		}
		
	}
}
