package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a linked list and a value x, partition it such that 
 * 
 * all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * 
 * @author Zealot
 * @date 2016年7月10日 下午12:50:37 
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
        	return head;
        }
        
        ListNode small = new ListNode(-1);
        ListNode newsmallhead = small;
        ListNode big = new ListNode(-1);
        ListNode newbighead = big;
        
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        
        small.next = newbighead.next;
        
        return newsmallhead.next;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		PartitionList p = new PartitionList();
		ListNode l = p.partition(l1, 3);
		while(l.next!=null){
			System.out.println(l.val);
			l = l.next;
		}
	}
}
