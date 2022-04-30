package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * 
 * @author Zealot
 * @date 2016年7月2日 下午2:51:54 
 *
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null||k<0){
			return null;
		}
		ListNode p = head;
		ListNode dummy = new ListNode(-1);
		int len = 0;
		while(p!=null){
			len++;
			p = p.next;
		}
		p = head;
		if(k>len){
			k = k%len;
		}
		
		int index = 0;
		while(p!=null){
			index++;
			if(index==len-k){
				dummy.next = p.next;
				p.next = null;//p.next=null
				break;
			}
			p = p.next;
		}
		ListNode tmp = dummy;
		while(tmp!=null){
			if(tmp.next==null){
				tmp.next = head;
				break;
			}
			tmp = tmp.next;
		}
		return dummy.next;
    }
}
