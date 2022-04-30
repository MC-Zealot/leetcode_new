package com.leetcode_3th.linked_list;

import com.leetCode.CommonStructure.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2 输出: false 示例 2:
 * 
 * 输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 * 
 * @author Zealot
 * @date Jul 25, 2019 8:49:00 PM
 *
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head == null)
	        return true;
	 
	    ListNode p = head;
	    ListNode prev = new ListNode(head.val);//逆序链表，如果正序等于逆序，则是回文
	 
	    while(p.next != null){
	        ListNode temp = new ListNode(p.next.val);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	 
	    ListNode p1 = head;
	    ListNode p2 = prev;
	 
	    while(p1!=null){
	        if(p1.val != p2.val)
	            return false;
	 
	        p1 = p1.next;
	        p2 = p2.next;
	    }
	 
	    return true;
	}
}
