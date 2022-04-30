package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月18日 下午4:50:03 
 *
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode node = head;
		while (node!=null) {
			if(node.next!=null&&node.next.val == node.val){
				node.next = node.next.next;
				continue;
			}
			node = node.next;
		}
		return head;
	}
}
