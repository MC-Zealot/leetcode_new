package com.leetcode_2th;

import java.util.Stack;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月2日 下午11:05:35 
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = newNode;
            newNode = head;
            head = tmp;
        }
        return newNode;
    }
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
//		while(l1!=null){
//			System.out.println(l1.val);
//			l1 = l1.next;
//		}
		ListNode newNode =r.reverseList(l1);
		while(newNode!=null){
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}
}
