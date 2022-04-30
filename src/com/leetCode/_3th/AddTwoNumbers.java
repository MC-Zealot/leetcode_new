package com.leetCode._3th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2018年4月24日 上午1:13:14 
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		if(l1==null && l2!=null){
			return l2;
		}else if(l1!=null && l2==null){
			return l1;
		}else if(l1==null && l2==null){
			return null;
		}
		int carry = 0;
		while(l1!=null && l2!=null){
			int cur = l1.val + l2.val + carry;
			
			if (cur >= 10) {
				carry = 1;
				cur=cur-10;
			} else {
				carry = 0;
			}
			p.next = new ListNode(cur);
			l1 = l1.next;
			l2 = l2.next;
			p = p.next;
			
		}
		while(l1!=null){
			int cur = l1.val +  carry;
			
			if (cur >= 10) {
				carry = 1;
				cur=cur-10;
			} else {
				carry = 0;
			}
			p.next = new ListNode(cur);
			l1 = l1.next;
			p = p.next;
			
		}
		while(l2!=null){
			int cur = l2.val +  carry;
			
			if (l2.val + carry >= 10) {
				carry = 1;
				cur=cur-10;
			} else {
				carry = 0;
			}
			p.next = new ListNode(cur);
			l2 = l2.next;
			p = p.next;
			
		}
		if(carry>0){
			p.next = new ListNode(carry);
		}
		
		return dummy.next;
    }
	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next =l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next =l5;
		l5.next = l6;
		ListNode res = atn.addTwoNumbers(l1, l4);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
		
	}
}
