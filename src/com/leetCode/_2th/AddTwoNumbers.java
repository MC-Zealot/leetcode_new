package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Zealot
 * @date 2016年3月9日 下午9:58:43
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null){
			return null;
		}
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		
		int carry = 0;//进位
		ListNode dummy = new ListNode(-1);
		ListNode tmp = dummy;
		//相同位
		while(l1!=null&&l2!=null){
			int digit1 = l1.val;
			int digit2 = l2.val;
			int sum = digit1+digit2+carry;
			if(sum>=10){
				sum=sum-10;
				carry=1;
			}else{
				carry=0;
			}
			ListNode l = new ListNode(sum);
			
			tmp.next = l;
			
			tmp = tmp.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		//如果l1多
		while(l1!=null){
			int digit1 = l1.val;
			int sum = digit1+carry;
			if(sum>=10){
				sum=sum-10;
				carry=1;
			}else{
				carry=0;
			}
			ListNode l = new ListNode(sum);
			
			tmp.next = l;
			tmp = tmp.next;
			l1 = l1.next;
		}
		//如果l2多
		while(l2!=null){
			int digit2 = l2.val;
			int sum = digit2+carry;
			if(sum>=10){
				sum=sum-10;
				carry=1;
			}else{
				carry=0;
			}
			ListNode l = new ListNode(sum);
			
			tmp.next = l;
			tmp = tmp.next;
			l2 = l2.next;
		}
		//都没有下一个 了，但是还需要进位
		if(l1==null&&l2==null&&carry==1){
			ListNode l = new ListNode(1);
			
			tmp.next = l;
			tmp = tmp.next;
		}
		return dummy.next;
    }
}
