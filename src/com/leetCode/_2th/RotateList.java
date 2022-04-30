package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.


 * 
 * @author Zealot
 * @date 2016年3月14日 上午10:17:09 
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
				p.next = null;
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
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		RotateList rl = new RotateList();
		ListNode res = rl.rotateRight(l1, 2000000000);
		while(res!=null){
			System.out.print(res.val+"\t");
			res = res.next;
		}
	}
}
