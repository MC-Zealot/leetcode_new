package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * @author Zealot
 * @date 2016年6月14日 下午4:00:32 
 *
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode start = head;
		do{
			if(slow==null||fast==null||fast.next==null){
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}while(fast!=slow);
		
		while(start!=slow){
			start = start.next;
			slow = slow.next;
		};
		return start;
    }
}
