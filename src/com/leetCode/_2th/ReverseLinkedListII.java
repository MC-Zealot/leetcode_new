package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 *
 * @author Zealot
 * @date 2016年2月28日 下午2:34:25
 *上面的代码还是有些细节的，链表的题目就是这样，想起来道理很简单，实现中可能会出些小差错，还是熟能生巧哈。

 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preNode = dummy;
		int i = 1;
		while (preNode.next != null && i < m) {
			preNode = preNode.next;
			i++;
		}
		if (i < m)
			return head;
		ListNode mNode = preNode.next;
		ListNode cur = mNode.next;
		while (cur != null && i < n) {
			ListNode next = cur.next;
			cur.next = preNode.next;
			preNode.next = cur;
			mNode.next = next;
			cur = next;
			i++;
		}
		return dummy.next;
	}
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if(head==null){
			return null;
		}

		ListNode dummy =  new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode pre = new ListNode(-1);
		pre.next = p;
		int index = 1;
		while(p!=null&&index<m){
			index++;
			p = p.next;
			pre = pre.next;
		}
		if(index < m){
			return head;
		}
		while(p.next!=null && index <n){
			ListNode tmp = new ListNode(p.next.val);
			tmp.next = pre.next;
			pre.next = tmp;//插入
			p.next = p.next.next;//删掉
			index++;
		}
		if(m==1){
			dummy.next = pre.next;
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
		ListNode head = r.reverseBetween2(l1, 2, 4);
		while(head!=null){
			System.out.print(" "+head.val);
			head = head.next;
		}
		System.out.println();
	}
}
